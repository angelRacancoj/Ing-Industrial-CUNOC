package Inventory.facade;

import Inventory.objects.DesignUnits;
import Inventory.objects.SupplyQuantity;
import Inventory.repository.InventoryRepository;
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
    public List<SupplyQuantity> getNecessarySupplies(DesignUnits productionUnits) {
        return inventoryRepository.getNecessarySupplies(productionUnits);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double unitCost(DesignUnits designUnits) {
        return inventoryRepository.unitCost(designUnits);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double totalCost(DesignUnits designUnits) {
        return inventoryRepository.totalCost(designUnits);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<DesignUnits> DesignWithUnitsPlaces(Integer id, String nameProduction) {
        return inventoryRepository.DesignWithUnitsPlaces(id, nameProduction);
    }

}
