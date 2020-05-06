package Production.service;

import Production.Production;
import Production.exceptions.MandatoryAttributeProductionException;
import Production.repository.ProductionRepository;
import User.exception.UserException;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import static config.Constants.*;
import java.util.Optional;
import javax.ejb.EJB;

/**
 *
 * @author daniel
 */
@Stateless
@LocalBean
public class ProductionService {

    private EntityManager entityManager;

    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Production create(Production production) throws MandatoryAttributeProductionException {

        if (production.getName() == null) {
            throw new MandatoryAttributeProductionException("Nombre nulo");
        }

        if (production.getStartDate() == null) {
            throw new MandatoryAttributeProductionException("Fecha de creacion nula");
        }

        entityManager.persist(production);
        return production;
    }

    public Production edit(Production Production) throws MandatoryAttributeProductionException {

        if (Production.getName() == null) {
            throw new MandatoryAttributeProductionException("Nombre nulo");
        }

        if (Production.getStartDate() == null) {
            throw new MandatoryAttributeProductionException("Fecha de creacion nula");
        }

        entityManager.merge(Production);

        return Production;
    }

    /**
     * Can update Name, Quantity, the Design and Group
     *
     * @param production
     * @return
     * @throws UserException
     */
    public Production updateProduction(Production production) throws UserException {
        if (production == null) {
            throw new UserException("No se ha indicado la producción");
        }

        Production updateProduction = entityManager.find(Production.class, production.getIdProduction());

        if (updateProduction == null) {
            throw new UserException("No existe la Producción");
        }

        if (!production.getName().isEmpty()) {
            updateProduction.setName(production.getName());
        }

        if (production.getQuantity() > 0) {
            updateProduction.setQuantity(production.getQuantity());
        }

        if (production.getDesignId() != null) {
            updateProduction.setDesignId(production.getDesignId());
        }

        if (production.getGroupId() != null) {
            updateProduction.setGroupId(production.getGroupId());
        }

        return updateProduction;

    }

}
