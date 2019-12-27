package Supply.facade;

import Supply.Supply;
import Supply.exception.MandatoryAttributeSupplyException;
import User.User;
import javax.ejb.Local;

@Local
public interface SupplyFacadeLocal {

    /**
     * Set the Quantity to cero and save a who do the change
     *
     * @param supplyToChange
     * @param user
     * @param noteModify
     * @return
     */
    public Supply modifyByTheft(Supply supplyToChange, User user, String noteModify);

    /**
     * This option allow to modify the quantity available, and save the identity
     * of the modifier user
     *
     * @param supplyToChange
     * @param newQuantity
     * @param user
     * @param noteModify
     * @return
     * @throws Supply.exception.MandatoryAttributeSupplyException
     */
    public Supply modifyByMissing(Supply supplyToChange, Integer newQuantity, User user, String noteModify) throws MandatoryAttributeSupplyException;
}
