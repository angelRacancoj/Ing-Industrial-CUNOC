/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory.facade;

import Inventory.objects.productionCost;
import Production.Production;
import Supply.Supply;
import Supply.repository.AvailabilityFilter;
import Supply.repository.ExpirationDateFilter;
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
     * Calculate the best Production to produce base on material available
     *
     * @return
     */
    public List<productionCost> getBestProductsBaseOnAvailableMaterial();

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
     * TODO
     * Add quantity to NecessarySupply object to do the correct calculates
     *
     * @param selectedProduction
     * @return
     */
    public List<productionCost> costByPruductionAndBatch(List<productionCost> selectedProduction);
}
