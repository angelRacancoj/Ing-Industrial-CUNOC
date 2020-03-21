package gt.udu.usac.cunoc.ingenieria.inventory.view;

import Inventory.facade.InventoryLocal;
import Inventory.objects.ProductionUnits;
import Inventory.objects.SupplyQuantity;
import Production.Product;
import Production.facade.ProductionFacadeLocal;
import gt.edu.usac.cunoc.ingenieria.utils.MessageUtils;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

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

    //Search utilities
    List<ProductionUnits> productionList = new LinkedList<>();
    List<Product> products = new LinkedList<>();
    Integer id;
    String productionName;
    Product product;

    //calculate cost
    List<SupplyQuantity> suplyQuantity = new LinkedList<>();
    double costWithoutExtraCost;
    double costWithExtraCost;
    ProductionUnits selectedProduction;
    
    @PostConstruct
    public void init() {
        getAllProducts();
    }
    
    public void searchProduction() {
        setProductionList(inventoryLocal.ProductionWithUnitsPlaces(id, productionName, product));
        if (getProductionList().isEmpty()) {
            MessageUtils.addSuccessMessage("Sin resultados en la busqueda");
        }
    }
    
    private void getAllProducts() {
        products.addAll(productionFacadeLocal.getProduct());
    }
    
    public void calculateCost() {
        if (selectedProduction == null) {
            MessageUtils.addWarningMessage("Debe seleccionar una produccion");
        } else {
            setSuplyQuantity(inventoryLocal.getNecessarySupplies(selectedProduction));
            setCostWithoutExtraCost(inventoryLocal.costByPruductionAndQuantityWithoutExtraCost(selectedProduction));
            setCostWithExtraCost(inventoryLocal.costByPruductionAndQuantityWithExtraCost(selectedProduction));
        }
    }
    
    public void cleanSearch() {
        setCostWithExtraCost(0);
        setCostWithoutExtraCost(0);
        setSuplyQuantity(null);
    }
    
    public void cleanCriteria() {
        id = null;
        productionName = null;
        product = null;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
    
    public void setProductionName(String productionName) {
        this.productionName = productionName;
    }

    public String getProductionName() {
        return productionName;
    }

    public Product getProduct() {
        return product;
    }
    
    
    public void setProduct(Product product) {
        this.product = product;
    }
    
    public void setSelectedProduction(ProductionUnits selectedProduction) {
        this.selectedProduction = selectedProduction;
    }
    
    public void setProductionList(List<ProductionUnits> productionList) {
        this.productionList = productionList;
    }
    
    public List<ProductionUnits> getProductionList() {
        return productionList;
    }
    
    public List<Product> getProducts() {
        return products;
    }
    
    public ProductionUnits getSelectedProduction() {
        if (selectedProduction == null) {
            selectedProduction = new ProductionUnits();
        }
        return selectedProduction;
    }
    
    public List<SupplyQuantity> getSuplyQuantity() {
        return suplyQuantity;
    }
    
    public void setSuplyQuantity(List<SupplyQuantity> suplyQuantity) {
        this.suplyQuantity = suplyQuantity;
    }
    
    public double getCostWithoutExtraCost() {
        return costWithoutExtraCost;
    }
    
    public void setCostWithoutExtraCost(double costWithoutExtraCost) {
        this.costWithoutExtraCost = costWithoutExtraCost;
    }
    
    public double getCostWithExtraCost() {
        return costWithExtraCost;
    }
    
    public void setCostWithExtraCost(double costWithExtraCost) {
        this.costWithExtraCost = costWithExtraCost;
    }
    
}
