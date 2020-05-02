/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.usac.cunoc.ingenieria.production.production.view;

import Design.Design;
import Production.Commentary;
import Production.ExtraCost;
import Production.Production;
import Production.Stage;
import Production.Step;
import Production.facade.ProductionFacadeLocal;
import static config.Constants.MAIN_PAGE;
import gt.edu.usac.cunoc.ingenieria.utils.MessageUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.FlowEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author daniel
 */
@Named
@ViewScoped
public class productionProcessView implements Serializable {

    private static final String ERROR_INSUFFICIENT_SUPPLIES = "No hay insumos suficientese para esta produccion (guarde su proceso y agregue mas insumos)";
    private static final String ERROR_EMPY_COMMENTARY = "El comentario no puede estar vacio";
    private static final String ERROR_EMPY_EXTRA_COST = "La descripcion del gasto puede estar vacia";
    private static final String ERROR_NULL_PRODUCTION = "No se ha seleccionado ninguna produccion";
    private static final String ERROR_END_DATE_PRODUCTION = "La produccion ya fue finalizada, puede volver a finalizarla pero la fecha de finalizacion cambiara";
    private static final String CREATE_COMMENTARY = "El comentario se agrego";
    private static final String CREATE_EXTRA_COST = "El gasto extra se agrego";
    private static final String SAVE_PROCESS = "Proceso Guardado";

    @EJB
    private ProductionFacadeLocal productionFacadeLocal;
    @Inject
    private ExternalContext externalContext;

    private List<Production> productions;
    private Production productionSelect;
    private Design postDesign;
    private List<ExtraCost> listExtraCost;
    private ExtraCost newExtraCost;

    private Stage preProcess;
    private Stage process;
    private Stage postProcess;
    private List<Stage> stages;

    private Step stepSlect;
    private Commentary commentary;

    private String text;
    private boolean skip;

    //private List<Step> stepsPreProcess;
    @PostConstruct
    public void init() {
        productions = new ArrayList<>();

        preProcess = new Stage();
        stages = new ArrayList<>();

        productions = productionFacadeLocal.AllProductions();
        commentary = new Commentary(null, "");

        text = "";
        stepSlect = new Step();
        stepSlect.setCommentaryList(new ArrayList<>());

        newExtraCost = new ExtraCost();

    }

    /**
     *
     */
    public void endProduction() {
        if (productionSelect != null) {

            boolean hayInsumosSuficientesParaDescontar = true;
            for (int i = 0; i < postDesign.getNecessarySupplyList().size(); i++) {
                if (postDesign.getNecessarySupplyList().get(i).getSupplyCode().getQuantity() < postDesign.getNecessarySupplyList().get(i).getQuantity()) {
                    hayInsumosSuficientesParaDescontar = false;
                }
            }

            if (hayInsumosSuficientesParaDescontar) {
                for (int i = 0; i < postDesign.getNecessarySupplyList().size(); i++) {
                    
                }
            } else {
                //error
                MessageUtils.addErrorMessage(ERROR_INSUFFICIENT_SUPPLIES);
            }

        } else {
            MessageUtils.addErrorMessage(ERROR_NULL_PRODUCTION);
        }

    }

    /**
     *
     * @param production
     */
    public void selectProduction(Production production) {
        this.productionSelect = production;

        if (productionSelect.getPostDesign() == null) {
            postDesign = productionSelect.getDesignId();
        }

        if (productionSelect.getExtraCostList() != null) {
            listExtraCost = new ArrayList<>();
            productionSelect.setExtraCostList(listExtraCost);
        }
        listExtraCost = productionSelect.getExtraCostList();

        for (int i = 0; i < production.getStageList().size(); i++) {
            if (production.getStageList().get(i).getName().equals("Pre-Produccion")) {
                preProcess = production.getStageList().get(i);
                //stepsPreProcess = preProcess.getStepList();
                stages.add(preProcess);
            }
            if (production.getStageList().get(i).getName().equals("Produccion")) {
                process = production.getStageList().get(i);
                stages.add(process);
            }
            if (production.getStageList().get(i).getName().equals("Post-Produccion")) {
                postProcess = production.getStageList().get(i);
                stages.add(postProcess);
            }
        }

    }

    public StreamedContent convertFichier(byte[] bytes) {

        InputStream is = new ByteArrayInputStream(bytes);
        //System.out.println("size file : " + bytes.length);
        StreamedContent image = new DefaultStreamedContent(is);
        //System.out.println("dans le convertisseur : " + image.getContentType());
        return image;

    }

    public void selectStep(Step step) {
        this.setStepSlect(step);
    }

    public void addCommentary() {
        commentary.setCommentary(text);
        if (!commentary.getCommentary().isEmpty()) {
            commentary.setIdStep(stepSlect);
            stepSlect.getCommentaryList().add(commentary);
            text = "";
            commentary = new Commentary();
            MessageUtils.addSuccessMessage(CREATE_COMMENTARY);

        } else {
            MessageUtils.addErrorMessage(ERROR_EMPY_COMMENTARY);
        }

    }

    public void addExtraCost() {

        if (!newExtraCost.getDescription().isEmpty() && newExtraCost.getCost() != 0) {
            listExtraCost.add(newExtraCost);
            newExtraCost = null;
            MessageUtils.addSuccessMessage(CREATE_EXTRA_COST);

        } else {
            MessageUtils.addErrorMessage(ERROR_EMPY_EXTRA_COST);
        }

    }

    public void deleteCommentary(Commentary commentary) {
        stepSlect.getCommentaryList().remove(commentary);
    }

    public void deleteExtraCost(ExtraCost extra) {
        listExtraCost.remove(extra);
    }

    public void exitPage() {
        try {
            externalContext.redirect(externalContext.getRequestContextPath() + MAIN_PAGE);
        } catch (IOException ex) {
            Logger.getLogger(productionProcessView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Metodo para guardar el progreso de la realizacion de una produccion lo
     * que guarda son los comentario hechos en los distintos pasos
     */
    public void saveProgress() {
        if (productionSelect != null) {
            if (productionSelect.getEndDate() == null) {//aca esta el error
                productionSelect.setState(true);
                try {
                    //agregar los comentarios
                    productionSelect.setStageList(stages);
                    productionFacadeLocal.updateCommentayOfSteps(productionSelect);
                    MessageUtils.addSuccessMessage(SAVE_PROCESS);
                    externalContext.redirect(externalContext.getRequestContextPath() + MAIN_PAGE);
                } catch (IOException ex) {
                    //Logger.getLogger(productionProcessView.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                MessageUtils.addErrorMessage(ERROR_END_DATE_PRODUCTION);
            }
        } else {
            MessageUtils.addErrorMessage(ERROR_NULL_PRODUCTION);
        }
    }

    public String onFlowProcess(FlowEvent event) {

        return event.getNewStep();

    }

    //-------------------get and set ------------------------------------
    public List<Production> getProductions() {
        return productions;
    }

    public void setProductions(List<Production> productions) {
        this.productions = productions;
    }

    public Production getProductionSelect() {
        return productionSelect;
    }

    public void setProductionSelect(Production productionSelect) {
        this.productionSelect = productionSelect;
    }

    public Stage getPreProcess() {
        return preProcess;
    }

    public void setPreProcess(Stage preProcess) {
        this.preProcess = preProcess;
    }

    public Stage getProcess() {
        return process;
    }

    public void setProcess(Stage process) {
        this.process = process;
    }

    public Stage getPostProcess() {
        return postProcess;
    }

    public void setPostProcess(Stage postProcess) {
        this.postProcess = postProcess;
    }

//    public List<Step> getStepsPreProcess() {
//        return stepsPreProcess;
//    }
//
//    public void setStepsPreProcess(List<Step> stepsPreProcess) {
//        this.stepsPreProcess = stepsPreProcess;
//    }
    public Step getStepSlect() {
        if (stepSlect.getCommentaryList().isEmpty()) {
            List<Commentary> lista = new ArrayList<>();
            stepSlect.setCommentaryList(lista);
        }

        return stepSlect;
    }

    public void setStepSlect(Step stepSlect) {
        this.stepSlect = stepSlect;
    }

    public Commentary getCommentary() {
        return commentary;
    }

    public void setCommentary(Commentary commentary) {
        this.commentary = commentary;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public Design getPostDesign() {
        return postDesign;
    }

    public void setPostDesign(Design postDesign) {
        this.postDesign = postDesign;
    }

    public List<ExtraCost> getListExtraCost() {
        return listExtraCost;
    }

    public void setListExtraCost(List<ExtraCost> listExtraCost) {
        this.listExtraCost = listExtraCost;
    }

    public ExtraCost getNewExtraCost() {
        if (newExtraCost == null) {
            newExtraCost = new ExtraCost();
        }
        return newExtraCost;
    }

    public void setNewExtraCost(ExtraCost newExtraCost) {
        this.newExtraCost = newExtraCost;
    }

}
