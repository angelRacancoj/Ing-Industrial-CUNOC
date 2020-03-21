package Inventory.facade;

import Inventory.objects.ProductionUnits;
import Inventory.objects.SupplyQuantity;
import Production.Product;
import Production.Production;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author angelrg
 */
@Local
public interface InventoryLocal {

    /**
     * Calculate the best Production to produce base on material available
     *
     * @return
     */
    public List<Production> getBestProductsBaseOnAvailableMaterial();

    /**
     * Base on available money calculate the best products to produce base on
     * higher note of production by Product
     *
     * TODO object (Production,batch)
     *
     * @param maxCost
     * @return
     */
    public List<Production> calculateProductOnMaxCost(Double maxCost);

    /**
     * Get the cost base on selected Production (selectedProductions) and
     * Quantity of batches
     *
     * TODO Add quantity to NecessarySupply object to do the correct calculates
     *
     * @param productionUnits
     * @return
     */
    public List<SupplyQuantity> getNecessarySupplies(ProductionUnits productionUnits);

    /**
     * Return the cost of the production, base of the order units, without extra
     * costs.
     *
     * @param productionUnits
     * @return
     */
    public double costByPruductionAndQuantityWithoutExtraCost(ProductionUnits productionUnits);

    /**
     * Return the cost of the production, base of the order units, include all
     * extra costs.If there is no extra cost, just return the cost to produce the units
 required.
     *
     *
     * @param productionUnits
     * @return
     */
    public double costByPruductionAndQuantityWithExtraCost(ProductionUnits productionUnits);

    /**
     * Return all products with the units variable as int, to set the quantity
     * of units required by the user
     *
     * This method enable to do search by different filters
     *
     * @param id
     * @param nameProduction
     * @param product
     * @return
     */
    public List<ProductionUnits> ProductionWithUnitsPlaces(Integer id, String nameProduction, Product product);
}
