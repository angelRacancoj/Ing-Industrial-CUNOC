package gt.udu.usac.cunoc.ingenieria.inventory.view;

import Inventory.facade.InventoryLocal;
import Production.Production;
import Production.facade.ProductionFacadeLocal;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.event.DragDropEvent;

/**
 *
 * @author angelrg
 */
@Named
@ViewScoped
public class supplyCalculatorView implements Serializable {

    @EJB
    private InventoryLocal inventoryLocal;

    @EJB
    private ProductionFacadeLocal productionFacadeLocal;

    List<Production> productionList;
    List<Production> selectedProductions = new LinkedList<Production>();
    Production selectedProduction;

    public void onProductionDrop(DragDropEvent ddEvent) {
        Production prod = ((Production) ddEvent.getData());
        System.out.println("Prod: " + (prod == null) + ", ID: " + prod.getIdProduction()+", Nombre:"+prod.getName());

        selectedProductions.add(prod);
        productionList.remove(prod);
    }

    public Production getSelectedProduction() {
        return selectedProduction;
    }

    public void setSelectedProduction(Production selectedProduction) {
        this.selectedProduction = selectedProduction;
    }

    public List<Production> getProductionList() {
        return productionList;
    }

    public void setProductionList(List<Production> productionList) {
        this.productionList = productionList;
    }

    public List<Production> getSelectedProductions() {
        return selectedProductions;
    }

    public void setSelectedProductions(List<Production> selectedProductions) {
        this.selectedProductions = selectedProductions;
    }

    public InventoryLocal getInventoryLocal() {
        return inventoryLocal;
    }

    public void setInventoryLocal(InventoryLocal inventoryLocal) {
        this.inventoryLocal = inventoryLocal;
    }

    public ProductionFacadeLocal getProductionFacadeLocal() {
        return productionFacadeLocal;
    }

    public void setProductionFacadeLocal(ProductionFacadeLocal productionFacadeLocal) {
        this.productionFacadeLocal = productionFacadeLocal;
    }

    /**
     * When search the list set empty
     */
    public void searchProduction() {
        setProductionList(productionFacadeLocal.AllProductions());
    }

    public Production getPoductionById(Integer id) {
        return productionFacadeLocal.getProductionById(id).get();
    }

    public void cleanSelectedProduction() {
        setSelectedProductions(null);
    }
}
