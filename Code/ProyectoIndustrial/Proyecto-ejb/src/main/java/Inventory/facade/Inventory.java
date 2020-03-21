package Inventory.facade;

import Inventory.objects.ProductionUnits;
import Inventory.objects.SupplyQuantity;
import Inventory.repository.InventoryRepository;
import Production.NecessarySupply;
import Production.Product;
import Production.Production;
import javax.ejb.Stateless;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author angelrg
 */
@Stateless
public class Inventory implements InventoryLocal {

    private InventoryRepository inventoryRepository;

    @EJB
    public void setInventoryRepository(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Production> calculateProductOnMaxCost(Double maxCost) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Production> getBestProductsBaseOnAvailableMaterial() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<SupplyQuantity> getNecessarySupplies(ProductionUnits productionUnits) {
        return inventoryRepository.getNecessarySupplies(productionUnits);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double costByPruductionAndQuantityWithoutExtraCost(ProductionUnits productionUnits) {
        return inventoryRepository.costByPruductionAndQuantityWithoutExtraCost(productionUnits);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double costByPruductionAndQuantityWithExtraCost(ProductionUnits productionUnits) {
        return inventoryRepository.costByPruductionAndQuantityWithExtraCost(productionUnits);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ProductionUnits> ProductionWithUnitsPlaces(Integer id, String nameProduction, Product product) {
        return inventoryRepository.ProductionWithUnitsPlaces(id, nameProduction, product);
    }

}
