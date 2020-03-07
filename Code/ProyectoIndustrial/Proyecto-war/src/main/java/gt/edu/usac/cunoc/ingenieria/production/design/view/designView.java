/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.usac.cunoc.ingenieria.production.design.view;

import Design.Design;
import Design.DesignData;
import Production.NecessarySupply;
import Production.facade.ProductionFacadeLocal;
import Supply.Supply;
import Supply.facade.SupplyFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author daniel
 */
@Named
@ViewScoped
public class designView implements Serializable {

    private List<Supply> supplies;
    private List<Supply> suppliesSelected;
    private List<NecessarySupply> necessarySupplys;

    private Supply selectedSupply;
    private UploadedFile file;
    private Design designCreate;
    private DesignData designDataCreate;

    @EJB
    private SupplyFacadeLocal supplyFacade;
    @EJB
    private ProductionFacadeLocal productionFacadeLocal;

    @PostConstruct
    public void init() {
        //supplies = service.createSupplies(5);
        designCreate = new Design();
        designDataCreate = new DesignData();
        supplies = supplyFacade.getSupplyAvailable();
        suppliesSelected = new ArrayList<>();
        necessarySupplys = new ArrayList<>();
    }

    public void createDesign() {
        
        designDataCreate.setPicture(file.getContents());
        productionFacadeLocal.createDesign(designCreate, designDataCreate, necessarySupplys);
    }

    public void addSupplyCreate(Supply supply) {
        NecessarySupply  necessarySupply =  new NecessarySupply(null, 0);
        necessarySupply.setDesignId(designCreate);
        necessarySupply.setSupplyCode(supply);
        
        necessarySupplys.add(necessarySupply);
        
        supplies.remove(supply);
        suppliesSelected.add(supply);
    }

    public void removeSupplyCreate(NecessarySupply  supplyNecessary) {
           necessarySupplys.remove(supplyNecessary);
          
        
        suppliesSelected.remove(supplyNecessary);
        supplies.add(supplyNecessary.getSupplyCode());
    }
    
    
    public void upload() {
        if (file != null) {
            FacesMessage message = new FacesMessage("Successful", file.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public List<Supply> getSupplies() {
        return supplies;
    }

    public void setSupplies(List<Supply> supplies) {
        this.supplies = supplies;
    }

    public List<Supply> getSuppliesSelected() {
        return suppliesSelected;
    }

    public void setSuppliesSelected(List<Supply> suppliesSelected) {
        this.suppliesSelected = suppliesSelected;
    }

    public Supply getSelectedSupply() {
        return selectedSupply;
    }

    public void setSelectedSupply(Supply selectedSupply) {
        this.selectedSupply = selectedSupply;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public List<NecessarySupply> getNecessarySupplys() {
        return necessarySupplys;
    }

    public void setNecessarySupplys(List<NecessarySupply> necessarySupplys) {
        this.necessarySupplys = necessarySupplys;
    }

    public Design getDesignCreate() {
        return designCreate;
    }

    public void setDesignCreate(Design designCreate) {
        this.designCreate = designCreate;
    }

    public DesignData getDesignDataCreate() {
        return designDataCreate;
    }

    public void setDesignDataCreate(DesignData designDataCreate) {
        this.designDataCreate = designDataCreate;
    }
    
    
    

}
