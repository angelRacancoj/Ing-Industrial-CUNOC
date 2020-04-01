package Inventory.facade;

import Inventory.objects.DesignUnits;
import Inventory.objects.SupplyQuantity;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author angelrg
 */
@Local
public interface InventoryLocal {

    /**
     * Get the cost base on selected Design and Quantity of units to produce
     *
     * @param designUnits
     * @return
     */
    public List<SupplyQuantity> getNecessarySupplies(DesignUnits designUnits);

    /**
     * Return the cost of the Design by a unit
     *
     * @param designUnits
     * @return
     */
    public double unitCost(DesignUnits designUnits);

    /**
     * Return the cost of produce the units base on the Design
     *
     * @param designUnits
     * @return
     */
    public double totalCost(DesignUnits designUnits);

    /**
     * Return all Designs with the units variable as int, to set the quantity of
     * units required by the user
     *
     * This method enable to do search by different filters
     *
     * @param id
     * @param nameProduction
     * @return
     */
    public List<DesignUnits> DesignWithUnitsPlaces(Integer id, String nameProduction);
}
