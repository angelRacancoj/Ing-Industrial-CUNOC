package Inventory.repository;

import Design.Design;
import Inventory.objects.ProductionUnits;
import Inventory.objects.SupplyQuantity;
import Production.ExtraCost;
import Production.NecessarySupply;
import Production.Production;
import Production.repository.ProductionRepository;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author angelrg
 */
@Stateless
@LocalBean
public class InventoryRepository {

    private ProductionRepository productionRepository;

    @EJB
    public void setProductionRepository(ProductionRepository productionRepository) {
        this.productionRepository = productionRepository;
    }

    /**
     * TODO needs a function that get the best options
     *
     * @return
     */
    public List<Production> getBestProductsBaseOnAvailableMaterial() {
        return null;
    }

    public double costByPruductionAndQuantityWithExtraCost(ProductionUnits productionUnits) {
        double cost = costByPruductionAndQuantityWithoutExtraCost(productionUnits);

        for (ExtraCost extraCost : productionUnits.getProduction().getExtraCostList()) {
            cost += extraCost.getCost();
        }
        return cost;
    }

    public double costByPruductionAndQuantityWithoutExtraCost(ProductionUnits productionUnits) {
        double cost = 0;
        for (SupplyQuantity necessarySupply : getNecessarySupplies(productionUnits)) {
            cost += (necessarySupply.getQuantity() * necessarySupply.getSupply().getCost());
        }
        return cost;
    }

    public List<SupplyQuantity> getNecessarySupplies(ProductionUnits productionUnits) {
        Production product = productionRepository.findByIdProduction(productionUnits.getProduction().getIdProduction()).get();
        if (product.getPostDesign() != null) {
            return necesarySupplyByQuantity(product.getPostDesign(), productionUnits.getUnits());
        } else {
            return necesarySupplyByQuantity(product.getDesignId(), productionUnits.getUnits());
        }
    }

    private List<SupplyQuantity> necesarySupplyByQuantity(Design design, int quantity) {
        System.out.println("Diseño: " + design.getIdDesign() + ", Unidades: " + quantity);
        ArrayList<SupplyQuantity> necesarySupplies = new ArrayList<>();
        for (NecessarySupply necessaryS : design.getNecessarySupplyList()) {
            necesarySupplies.add(new SupplyQuantity(necessaryS.getSupplyCode(), (necessaryS.getQuantity() * quantity)));
            System.out.println("Insumo: " + necessaryS.getSupplyCode().getInternalCode() + ", Cantidad: " + (necessaryS.getQuantity() * quantity));
        }
        return necesarySupplies;
    }

    public List<ProductionUnits> ProductionWithUnitsPlaces(Integer id, String nameProduction) {
        List<Production> productions = productionRepository.findProduction(id, nameProduction);
        List<ProductionUnits> productionUnits = new ArrayList<>();
        for (Production production : productions) {
            productionUnits.add(new ProductionUnits(production, 1));
        }
        return productionUnits;
    }
}
