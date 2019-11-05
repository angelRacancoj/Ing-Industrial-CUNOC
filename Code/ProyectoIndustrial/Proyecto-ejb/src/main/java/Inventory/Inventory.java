package Inventory;

import Supply.Supply;
import Supply.repository.AvailabilityFilter;
import Supply.repository.ExpirationDateFilter;
import Supply.repository.SupplyRepository;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author angelrg
 */
@Stateless
public class Inventory implements InventoryLocal {

    SupplyRepository supplyRepository;
    
    
    @Override
    public List<Supply> getSupply(Integer codeSupply, String nameSupply, AvailabilityFilter availabilitySupply, ExpirationDateFilter expirationDateSupply) {
        return supplyRepository.getSupply(codeSupply, nameSupply, availabilitySupply, expirationDateSupply);
    }

    
}
