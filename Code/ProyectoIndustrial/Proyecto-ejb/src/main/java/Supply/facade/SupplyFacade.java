package Supply.facade;

import Supply.Supply;
import Supply.repository.AvailabilityFilter;
import Supply.repository.ExpirationDateFilter;
import Supply.repository.SupplyRepository;
import Supply.service.SupplyServices;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import Supply.repository.AvailabilityFilter;

@Stateless
@LocalBean
public class SupplyFacade implements SupplyFacadeLocal {

    private SupplyRepository supplyRepository;

    @EJB
    public void setSupplyRepository(SupplyRepository supplyRepository) {
        this.supplyRepository = supplyRepository;
    }
    
    public List<Supply> getSupplyAvailable(){
        List<Supply> list =new ArrayList<>();
        list = supplyRepository.getSupply(null, null,AvailabilityFilter.AVAILABLE ,null);
        return list;
    }

}
