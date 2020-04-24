/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.usac.cunoc.ingenieria.production.production.view;

import Production.Commentary;
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
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author daniel
 */
@Named
@ViewScoped
public class productionProcessView implements Serializable {

     private static final String ERROR_EMPY_COMMENTARY = "El comentario no puede estar vacio";
     private static final String ERROR_NULL_PRODUCTION = "No se ha seleccionado ninguna produccion";
     private static final String ERROR_END_DATE_PRODUCTION = "La produccion ya fue finalizada, puede volver a finalizarla pero la fecha de finalizacion cambiara";
     private static final String CREATE_COMMENTARY = "El comentario se agrego";
    
    @EJB
    private ProductionFacadeLocal productionFacadeLocal;
    @Inject
    private ExternalContext externalContext;

    private List<Production> productions;
    private Production productionSelect;

    private Stage preProcess;
    private Stage process;
    private Stage postProcess;
    private List<Stage> stages;

    private Step stepSlect;
    private Commentary commentary;

    //private List<Step> stepsPreProcess;

    @PostConstruct
    public void init() {
        productions = new ArrayList<>();

        preProcess = new Stage();
        stages = new ArrayList<>();

        productions = productionFacadeLocal.AllProductions();
        commentary = new Commentary(null, "");

    }

    public void selectProduction(Production production) {
        this.productionSelect = production;

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
        if (!commentary.getCommentary().isEmpty()) {
            stepSlect.getCommentaryList().add(commentary);
            this.commentary.setCommentary("");
            MessageUtils.addSuccessMessage(CREATE_COMMENTARY);
        } else {
            MessageUtils.addErrorMessage(ERROR_EMPY_COMMENTARY);
        }

    }

    public void deleteCommentary(Commentary commentary){
        stepSlect.getCommentaryList().remove(commentary);
    }
    
    public void exitPage(){
         try {
             externalContext.redirect(externalContext.getRequestContextPath() + MAIN_PAGE);
         } catch (IOException ex) {
             Logger.getLogger(productionProcessView.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    
    public void saveProgress(){
        if(productionSelect != null){
            if(productionSelect.getEndDate() != null){
                try {
                    //agregar los comentarios
                    productionSelect.setStageList(stages);
                    productionFacadeLocal.updateCommentayOfSteps(productionSelect);
                    externalContext.redirect(externalContext.getRequestContextPath() + MAIN_PAGE);
                } catch (IOException ex) {
                    //Logger.getLogger(productionProcessView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                MessageUtils.addErrorMessage(ERROR_END_DATE_PRODUCTION);
            }
        }else{
            MessageUtils.addErrorMessage(ERROR_NULL_PRODUCTION);
        }
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

}
