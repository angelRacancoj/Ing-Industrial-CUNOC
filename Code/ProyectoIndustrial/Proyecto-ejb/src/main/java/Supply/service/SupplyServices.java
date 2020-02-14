package Supply.service;

import Modify.ModificationType;
import Modify.ModifySupply;
import Modify.service.ModifySupplyService;
import Supply.Measure;
import Supply.Supply;
import Supply.exception.MandatoryAttributeSupplyException;
import User.User;
import User.exception.UserException;
import static config.Constants.PERSISTENCE_UNIT_NAME;
import java.time.LocalDate;
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
    public void setModifySupplyService(ModifySupplyService modifySupplyService) {
        this.modifySupplyService = modifySupplyService;
    }

    public SupplyServices() {
    }

    public Supply create(Supply newSupply) throws MandatoryAttributeSupplyException {
        if (newSupply.getName() == null) {
            throw new MandatoryAttributeSupplyException("Atributo Nombre Obligatorio");
        }
        if (newSupply.getExpirationDate() == null) {
            throw new MandatoryAttributeSupplyException("Atributo Fecha de Expiración Obligatorio");
        }
        if (newSupply.getCost() == null) {
            throw new MandatoryAttributeSupplyException("Atributo Costo Obligatorio");
        }
        if (newSupply.getQuantity() == null) {
            throw new MandatoryAttributeSupplyException("Atributo Cantidad Obligatorio");
        }
        if (newSupply.getMeasure() == null) {
            throw new MandatoryAttributeSupplyException("Atributo Medida Obligatorio");
        }
        newSupply.setDateOfAdmission(LocalDate.now());
        newSupply.setAvailability(true);
        entityManager.persist(newSupply);
        return newSupply;
    }

    public Supply modifyByMissing(Supply supplyToChange, Double newQuantity, User user, String noteModify) throws MandatoryAttributeSupplyException {
        if (newQuantity == null) {
            throw new MandatoryAttributeSupplyException("Atributo Cantidad Obligatorio");
        } else {
            supplyToChange.setQuantity(newQuantity);
            saveModificationHistory(supplyToChange, user, ModificationType.POR_FALTANTE, newQuantity, noteModify);
        }
        return supplyToChange;
    }

    public Supply modifyByTheft(Supply supplyToChange, User user, String noteModify) {
        supplyToChange = deactivateSupplySimple(supplyToChange);
        saveModificationHistory(supplyToChange, user, ModificationType.POR_ROBO, 0.0, noteModify);
        return supplyToChange;
    }

    public Supply deactiveSupply(Supply supplyToChange) {
        supplyToChange = deactivateSupplySimple(supplyToChange);
        return supplyToChange;
    }

    private Supply deactivateSupplySimple(Supply supplyToChange) {
        supplyToChange.setQuantity(0.0);
        supplyToChange.setAvailability(false);
        return supplyToChange;
    }

    public Supply activateSupply(Supply supplyToChange, Double newQuantity) throws MandatoryAttributeSupplyException {
        if (newQuantity == null) {
            throw new MandatoryAttributeSupplyException("Atributo Cantidad Obligatorio");
        }
        supplyToChange.setAvailability(true);
        supplyToChange.setQuantity(newQuantity);
        return supplyToChange;
    }

    public Supply modifySupply(Supply supply) throws UserException {
        if (supply == null) {
            throw new UserException("Supply is null");
        }
        Supply updateSupply = entityManager.find(Supply.class, supply.getCode());
        if (supply.getName() != null) {
            updateSupply.setName(supply.getName());
        }
        if (supply.getExpirationDate() != null) {
            updateSupply.setExpirationDate(supply.getExpirationDate());
        }
        if (supply.getCost() != null && supply.getCost() >= 0) {
            updateSupply.setCost(supply.getCost());
        }
        if (supply.getDescription() != null) {
            updateSupply.setDescription(supply.getDescription());
        }
        return updateSupply;
    }

    private void saveModificationHistory(Supply supply, User user, ModificationType typeModification, Double newQuantity, String note) {
        ModifySupply newModifySupply = new ModifySupply(user, supply, typeModification, newQuantity, LocalDate.now(), note);
        modifySupplyService.createModifySupply(newModifySupply);
    }
}
