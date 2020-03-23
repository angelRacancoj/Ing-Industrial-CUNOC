/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.usac.cunoc.ingenieria.production.design.view;

import Design.Design;
import Production.facade.ProductionFacadeLocal;
import Supply.facade.SupplyFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author daniel
 */
@Named
@ViewScoped
public class designEditView implements Serializable {

    @EJB
    private SupplyFacadeLocal supplyFacade;
    @EJB
    private ProductionFacadeLocal productionFacadeLocal;
    
    
    private Design designSelectedEdit;
    private List<Design> listDesignEdit;
    
    
    public void init() {
        designSelectedEdit = new Design();
        
        listDesignEdit = productionFacadeLocal.AllDesigns();
        
        for (int i = 0; i < listDesignEdit.size(); i++) {
            System.out.println(listDesignEdit.get(i).toString());
        }
    }
    
    public void selectDesignEdit(Design design) {
        designSelectedEdit = design;
    }

    
    
    
    public Design getDesignSelectedEdit() {
        return designSelectedEdit;
    }

    public void setDesignSelectedEdit(Design designSelectedEdit) {
        this.designSelectedEdit = designSelectedEdit;
    }
     public List<Design> getListDesignEdit() {
        return listDesignEdit;
    }

    public void setListDesignEdit(List<Design> listDesignEdit) {
        this.listDesignEdit = listDesignEdit;
    }


}
