package Modify.service;

import Modify.ModifySupply;
import Modify.facade.ModifySupplyServiceFacade;
import static config.Constants.PERSISTENCE_UNIT_NAME;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author angelrg
 */
@Stateless
@LocalBean
public class ModifySupplyService implements ModifySupplyServiceFacade{

    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Create a new modification history
     *
     * @param modifySupply
     * @return 
     */
    @Override
    public ModifySupply createModifySupply(ModifySupply modifySupply) {

        entityManager.persist(modifySupply);
        return modifySupply;
    }
}
