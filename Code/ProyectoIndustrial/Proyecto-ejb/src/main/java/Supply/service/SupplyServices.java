
package Supply.service;

import Supply.Measure;
import Supply.Supply;
import Supply.exception.MandatoryAttributeSupplyException;
import User.User;
import static config.Constants.PERSISTENCE_UNIT_NAME;
import java.time.LocalDate;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class SupplyServices {
    
    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    EntityManager entityManager;

    public SupplyServices() {
    }
    
    public Supply create(Supply newSupply) throws MandatoryAttributeSupplyException{
        if (newSupply.getName() == null){
            throw new MandatoryAttributeSupplyException("Atributo Nombre Obligatorio");
        } 
        if (newSupply.getExpirationDate() == null){
            throw new MandatoryAttributeSupplyException("Atributo Fecha de Expiración Obligatorio");
        }
        if (newSupply.getCost() == null){
            throw new MandatoryAttributeSupplyException("Atributo Costo Obligatorio");
        }
        if (newSupply.getQuantity() == null){
            throw new MandatoryAttributeSupplyException("Atributo Cantidad Obligatorio");
        }
        if (newSupply.getMeasure() == null){
            throw new MandatoryAttributeSupplyException("Atributo Medida Obligatorio");
        }
        newSupply.setDateOfAdmission(LocalDate.now());
        newSupply.setAvailability(true);
        entityManager.persist(newSupply);
        return newSupply;
    }
    
    public Supply modifyByMissing(Supply supplyToChange, Double newQuantity, User user) throws MandatoryAttributeSupplyException{
        if (newQuantity == null){
            throw new MandatoryAttributeSupplyException("Atributo Cantidad Obligatorio");
        } else {
            supplyToChange.setQuantity(newQuantity);
            saveModificationHistory(supplyToChange, user, TypeModification.MODIFY_BY_MISSING);
        }
        return supplyToChange;
    }
    
    public Supply modifyByTheft(Supply supplyToChange, User user){
        supplyToChange = deactivateSupplySimple(supplyToChange);
        saveModificationHistory(supplyToChange, user, TypeModification.MODIFY_BY_THEFT);
        return supplyToChange; 
    }
    
    public Supply deactiveSupply(Supply supplyToChange, User user){
        supplyToChange = deactivateSupplySimple(supplyToChange);
        saveModificationHistory(supplyToChange, user, TypeModification.ATTRIBUTES);
        return supplyToChange;
    }
    
    private Supply deactivateSupplySimple(Supply supplyToChange){
        supplyToChange.setQuantity(0.0);
        supplyToChange.setAvailability(false);
        return supplyToChange;
    }
    
    public Supply activateSupply(Supply supplyToChange, Double newQuantity, User user) throws MandatoryAttributeSupplyException{
        if (newQuantity == null){
            throw new MandatoryAttributeSupplyException("Atributo Cantidad Obligatorio");
        }
        supplyToChange.setAvailability(true);
        supplyToChange.setQuantity(newQuantity);
        saveModificationHistory(supplyToChange, user, TypeModification.ATTRIBUTES);
        return supplyToChange;
    }
    
    public Supply modifySupply(Supply supply, String newName, LocalDate newExpirationDate, Double newCost, Double newQuantity, boolean newAvailability, String newDescription, Measure newMeasure, User user) throws MandatoryAttributeSupplyException{
        if (newName == null){
            throw new MandatoryAttributeSupplyException("Atributo Nombre Obligatorio");
        } 
        if (newExpirationDate == null){
            throw new MandatoryAttributeSupplyException("Atributo Fecha de Expiración Obligatorio");
        }
        if (newCost == null){
            throw new MandatoryAttributeSupplyException("Atributo Costo Obligatorio");
        }
        if (newQuantity == null){
            throw new MandatoryAttributeSupplyException("Atributo Cantidad Obligatorio");
        }
        if (newMeasure == null){
            throw new MandatoryAttributeSupplyException("Atributo Medida Obligatorio");
        }
        supply.setName(newName);
        supply.setExpirationDate(newExpirationDate);
        supply.setCost(newCost);
        supply.setQuantity(newQuantity);
        supply.setAvailability(newAvailability);
        supply.setDescription(newDescription);
        supply.setMeasure(newMeasure);
        saveModificationHistory(supply, user, TypeModification.ATTRIBUTES);
        return supply;
    }
    
    private void saveModificationHistory(Supply supply, User user, TypeModification typeModification){
        //Guardar El cambio en entidad "modify_supply"
    }
}
