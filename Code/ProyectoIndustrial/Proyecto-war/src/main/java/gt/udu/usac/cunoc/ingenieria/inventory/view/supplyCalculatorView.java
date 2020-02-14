package gt.udu.usac.cunoc.ingenieria.inventory.view;

import Inventory.facade.InventoryLocal;
import Inventory.objects.productionCost;
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
    List<productionCost> selectedProductions = new LinkedList<>();
    List<productionCost> finalProductions;
    Production selectedProduction;

    public void onProductionDrop(DragDropEvent ddEvent) {
        Production prod = ((Production) ddEvent.getData());

        selectedProductions.add(new productionCost(prod, 1));
        productionList.remove(prod);
    }

    public void productionCost() {
        setFinalProductions(inventoryLocal.costByPruductionAndBatch(selectedProductions));
        System.out.println("Final productions: "+finalProductions.size());
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

    public List<productionCost> getSelectedProductions() {
        return selectedProductions;
    }

    public void setSelectedProductions(List<productionCost> selectedProductions) {
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

    public List<productionCost> getFinalProductions() {
        return finalProductions;
    }

    public void setFinalProductions(List<productionCost> finalProductions) {
        this.finalProductions = finalProductions;
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

    public void cleanSelectedProductionAndProductionList() {
        setSelectedProductions(null);
        productionList.clear();
    }
}
