/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.usac.cunoc.ingenieria.production.design.view;

import Design.Design;
import Design.DesignData;
import Production.NecessarySupply;
import Production.Product;
import Production.facade.ProductionFacadeLocal;
import Supply.Supply;
import Supply.facade.SupplyFacadeLocal;
import gt.edu.usac.cunoc.ingenieria.utils.MessageUtils;
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

    private static final String DESIGN_CREATED = "Diseño Creado Correctamente";
    private static final String ERROR_NECESSARY_SUPPLYS = "No hay insumos";

    private List<Supply> supplies;
    private List<Supply> suppliesSelected;
    private List<NecessarySupply> necessarySupplys;

    private List<Design> listDesignEdit;

    //producto seleccionado y lisado de productos para el comboBox
    private List<Product> products;
    private Product productSelect;

    private Supply selectedSupply;
    private UploadedFile file;
    private Design designCreate;
    private Design designSelectedEdit;
    private DesignData designDataCreate;

    @EJB
    private SupplyFacadeLocal supplyFacade;
    @EJB
    private ProductionFacadeLocal productionFacadeLocal;

    @PostConstruct
    public void init() {
        //Productos del Combobox
        products = productionFacadeLocal.getProduct();
        productSelect = new Product();

        designCreate = new Design();
        designSelectedEdit = new Design();
        designDataCreate = new DesignData();

        supplies = supplyFacade.getSupplyAvailable();
        listDesignEdit = productionFacadeLocal.AllDesigns();

        suppliesSelected = new ArrayList<>();
        necessarySupplys = new ArrayList<>();

    }

    public void selectDesignEdit(Design design) {
        designSelectedEdit = design;
    }

    public void createDesign() {
        try {
            if(!necessarySupplys.isEmpty()){
            if (file != null) {
                designDataCreate.setPicture(file.getContents());
            }
            productionFacadeLocal.createDesign(designCreate, designDataCreate, necessarySupplys);
            MessageUtils.addSuccessMessage(DESIGN_CREATED);
            }else{
                MessageUtils.addErrorMessage(ERROR_NECESSARY_SUPPLYS);
            }
        } catch (Exception e) {
            MessageUtils.addErrorMessage(e.getMessage());
        }
    }

    private int qty;

    public void setQty(int qty) {
        System.out.println("set value " + qty);
        this.qty = qty;
    }

    public int getQty() {
        return qty;
    }

    public void addSupplyCreate(Supply supply) {
        NecessarySupply necessarySupply = new NecessarySupply(null, 0.1);
        necessarySupply.setDesignId(designCreate);
        necessarySupply.setSupplyCode(supply);

        necessarySupplys.add(necessarySupply);

        supplies.remove(supply);
        suppliesSelected.add(supply);
    }

    public void removeSupplyCreate(NecessarySupply supplyNecessary) {
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

    public List<Design> getListDesignEdit() {
        return listDesignEdit;
    }

    public void setListDesignEdit(List<Design> listDesignEdit) {
        this.listDesignEdit = listDesignEdit;
    }

    public Design getDesignSelectedEdit() {
        return designSelectedEdit;
    }

    public void setDesignSelectedEdit(Design designSelectedEdit) {
        this.designSelectedEdit = designSelectedEdit;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Product getProductSelect() {
        return productSelect;
    }

    public void setProductSelect(Product productSelect) {
        this.productSelect = productSelect;
    }

}
