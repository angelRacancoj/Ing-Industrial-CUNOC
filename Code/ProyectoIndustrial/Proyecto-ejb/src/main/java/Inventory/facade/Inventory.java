package Inventory.facade;

import Supply.repository.ExpirationDateFilter;
import Supply.repository.AvailabilityFilter;
import Supply.repository.SupplyRepository;
import Inventory.objects.productionCost;
import Inventory.repository.InventoryRepository;
import Production.Production;
import javax.ejb.Stateless;
import java.util.List;
import javax.ejb.EJB;
import Supply.Supply;

/**
 *
 * @author angelrg
 */
@Stateless
public class Inventory implements InventoryLocal {

    private SupplyRepository supplyRepository;
    private InventoryRepository inventoryRepository;

    @EJB
    public void setSupplyRepository(SupplyRepository supplyRepository) {
        this.supplyRepository = supplyRepository;
    }

    @EJB
    public void setInventoryRepository(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Supply> getSupply(Integer codeSupply, String internalCode, String nameSupply, AvailabilityFilter availabilitySupply, ExpirationDateFilter expirationDateSupply) {
        return supplyRepository.getSupply(codeSupply, nameSupply, internalCode, availabilitySupply, expirationDateSupply);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<productionCost> getBestProductsBaseOnAvailableMaterial() {
        return inventoryRepository.getBestProductsBaseOnAvailableMaterial();
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
    public List<productionCost> costByPruductionAndBatch(List<productionCost> selectedProduction) {
        return inventoryRepository.costByPruductionAndBatch(selectedProduction);
    }
}
