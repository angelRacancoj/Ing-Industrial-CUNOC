
package Supply.service;

import Modify.ModificationType;
import Modify.ModifySupply;
import Modify.service.ModifySupplyService;
import Supply.Measure;
import Supply.Supply;
import Supply.exception.MandatoryAttributeSupplyException;
import User.User;
import static config.Constants.PERSISTENCE_UNIT_NAME;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class SupplyServices {
    
    
    private EntityManager entityManager;
    private ModifySupplyService modifySupplyService;
    
    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    @EJB
    public void setModifySupplyService(ModifySupplyService modifySupplyService){
        this.modifySupplyService = modifySupplyService;
    }
    
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
    
    public Supply modifyByMissing(Supply supplyToChange, Integer newQuantity, User user, String noteModify) throws MandatoryAttributeSupplyException{
        if (newQuantity == null){
            throw new MandatoryAttributeSupplyException("Atributo Cantidad Obligatorio");
        } else {
            supplyToChange.setQuantity(newQuantity);
            saveModificationHistory(supplyToChange, user, ModificationType.POR_FALTANTE, newQuantity, noteModify);
        }
        return supplyToChange;
    }
    
    public Supply modifyByTheft(Supply supplyToChange, User user, String noteModify){
        supplyToChange = deactivateSupplySimple(supplyToChange);
        saveModificationHistory(supplyToChange, user, ModificationType.POR_ROBO, 0, noteModify);
        return supplyToChange; 
    }
    
    public Supply deactiveSupply(Supply supplyToChange, User user){
        supplyToChange = deactivateSupplySimple(supplyToChange);
        return supplyToChange;
    }
    
    private Supply deactivateSupplySimple(Supply supplyToChange){
        supplyToChange.setQuantity(0);
        supplyToChange.setAvailability(false);
        return supplyToChange;
    }
    
    public Supply activateSupply(Supply supplyToChange, Integer newQuantity, User user) throws MandatoryAttributeSupplyException{
        if (newQuantity == null){
            throw new MandatoryAttributeSupplyException("Atributo Cantidad Obligatorio");
        }
        supplyToChange.setAvailability(true);
        supplyToChange.setQuantity(newQuantity);
        return supplyToChange;
    }
    
    public Supply modifySupply(Supply supply, String newName, LocalDate newExpirationDate, Double newCost, boolean newAvailability, String newDescription, Measure newMeasure, User user) throws MandatoryAttributeSupplyException{
        if (newName == null){
            throw new MandatoryAttributeSupplyException("Atributo Nombre Obligatorio");
        } 
        if (newExpirationDate == null){
            throw new MandatoryAttributeSupplyException("Atributo Fecha de Expiración Obligatorio");
        }
        if (newCost == null){
            throw new MandatoryAttributeSupplyException("Atributo Costo Obligatorio");
        }
        if (newMeasure == null){
            throw new MandatoryAttributeSupplyException("Atributo Medida Obligatorio");
        }
        supply.setName(newName);
        supply.setExpirationDate(newExpirationDate);
        supply.setCost(newCost);
        supply.setAvailability(newAvailability);
        supply.setDescription(newDescription);
        supply.setMeasure(newMeasure);
        return supply;
    }
    
    private void saveModificationHistory(Supply supply, User user, ModificationType typeModification, Integer newQuantity, String note){
        ModifySupply newModifySupply = new ModifySupply(user, supply, typeModification, newQuantity,  Date.from(LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()), note);
        modifySupplyService.createModifySupply(newModifySupply);
    }
}
