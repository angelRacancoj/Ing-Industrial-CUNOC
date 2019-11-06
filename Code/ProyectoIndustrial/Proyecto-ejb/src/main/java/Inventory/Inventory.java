package Inventory;

import Production.Production;
import Supply.Supply;
import Supply.repository.AvailabilityFilter;
import Supply.repository.ExpirationDateFilter;
import Supply.repository.SupplyRepository;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author angelrg
 */
@Stateless
public class Inventory implements InventoryLocal {

    private SupplyRepository supplyRepository;

    @EJB
    public void setSupplyRepository(SupplyRepository supplyRepository) {
        this.supplyRepository = supplyRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Supply> getSupply(Integer codeSupply, String nameSupply, AvailabilityFilter availabilitySupply, ExpirationDateFilter expirationDateSupply) {
        return supplyRepository.getSupply(codeSupply, nameSupply, availabilitySupply, expirationDateSupply);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Supply> getExpiredSupplys() {
        
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
    public List<Production> calculateProductOnMaxCost(Double maxCost) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Double> costByPruductionAndBatch(List<Production> selectedProduction) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
