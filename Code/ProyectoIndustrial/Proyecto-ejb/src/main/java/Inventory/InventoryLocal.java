/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory;

import Production.Product;
import Production.Production;
import Supply.Supply;
import Supply.repository.AvailabilityFilter;
import Supply.repository.ExpirationDateFilter;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author angelrg
 */
@Local
public interface InventoryLocal {

    /**
     *
     * Get all supplies in Data Base, is available to use filter for searching
     * based in the parameters, to unable a filter send a NULL
     *
     * To get all supply send all parameters with NULL
     *
     * @param codeSupply
     * @param nameSupply
     * @param availabilitySupply
     * @param expirationDateSupply
     * @return
     */
    public List<Supply> getSupply(Integer codeSupply, String nameSupply, AvailabilityFilter availabilitySupply, ExpirationDateFilter expirationDateSupply);

    /**
     * Return list of supply expired to the current date
     *
     * @return
     */
    public List<Supply> getExpiredSupplys();

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
     * TODO object (Production,batch)
     *
     * @param selectedProduction
     * @return
     */
    public List<Double> costByPruductionAndBatch(List<Production> selectedProduction);
}
