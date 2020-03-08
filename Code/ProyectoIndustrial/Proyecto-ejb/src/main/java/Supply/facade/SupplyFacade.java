package Supply.facade;

import Supply.Measure;
import Supply.repository.AvailabilityFilter;
import Supply.repository.ExpirationDateFilter;
import Supply.repository.MeasureRepository;
import Supply.repository.SupplyRepository;
import java.util.List;
import Supply.Supply;
import Supply.exception.MandatoryAttributeSupplyException;
import Supply.service.SupplyServices;
import User.User;
import User.exception.UserException;
import java.time.LocalDate;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import Supply.repository.AvailabilityFilter;
import java.util.ArrayList;

@Stateless
@LocalBean
public class SupplyFacade implements SupplyFacadeLocal {

    @EJB
    private MeasureRepository measureRepository;

    @EJB
    private SupplyServices supplyService;

    @EJB
    private SupplyRepository supplyRepository;

    @EJB
    public void setMeasureRepository(MeasureRepository measureRepository) {
        this.measureRepository = measureRepository;
    }

    @EJB
    public void setSupplyService(SupplyServices supplyService) {
        this.supplyService = supplyService;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Measure> getAllMeasures() {
        return measureRepository.getAllMeasures();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Measure> getMeasure(Measure measure) throws MandatoryAttributeSupplyException {
        return measureRepository.getMeasure(measure);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Supply createSupply(Supply newSupply) throws MandatoryAttributeSupplyException {
        return supplyService.create(newSupply);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Supply> searchSupplies(Integer codeSupply, String nameSupply, AvailabilityFilter availabilitySupply, ExpirationDateFilter expirationDateSupply) {
        return supplyRepository.getSupply(codeSupply, nameSupply, availabilitySupply, expirationDateSupply);
    }
    
    
    @Override
    public List<Supply> getSupplyAvailable(){
        List<Supply> list =new ArrayList<>();
        list = supplyRepository.getSupply(null, null,AvailabilityFilter.AVAILABLE ,null);
        return list;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Supply modifyByTheft(Supply supplyToChange, User user, String noteModify) {
        return supplyService.modifyByTheft(supplyToChange, user, noteModify);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Supply modifyByMissing(Supply supplyToChange, Double newQuantity, User user, String noteModify) throws MandatoryAttributeSupplyException {
        return supplyService.modifyByMissing(supplyToChange, newQuantity, user, noteModify);
    }

    @Override
    public Supply modifySupply(Supply supply) throws UserException {
        return supplyService.modifySupply(supply);
    }

}
