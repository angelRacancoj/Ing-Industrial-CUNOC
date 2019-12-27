package Supply.facade;

import Supply.Supply;
import Supply.exception.MandatoryAttributeSupplyException;
import Supply.service.SupplyServices;
import User.User;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class SupplyFacade implements SupplyFacadeLocal {
    
    private SupplyServices supplyService;

    @EJB
    public void setSupplyService(SupplyServices supplyService) {
        this.supplyService = supplyService;
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
    public Supply modifyByMissing(Supply supplyToChange, Integer newQuantity, User user, String noteModify) throws MandatoryAttributeSupplyException{
        return supplyService.modifyByMissing(supplyToChange, newQuantity, user, noteModify);
    }

}
