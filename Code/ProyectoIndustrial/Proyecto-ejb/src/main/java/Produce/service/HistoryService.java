package Produce.service;

import Produce.History;
import Produce.facade.HistoryServiceFacade;
import static config.Constants.PERSISTENCE_UNIT_NAME;
import java.util.Date;
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
public class HistoryService implements HistoryServiceFacade {

    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public History createHistory(History history) {
        entityManager.persist(history);
        return history;
    }

    /**
     * return false if have already set a End Date
     *
     * @param history
     * @param date
     * @return
     */
    public boolean setEndDate(History history, Date date) {
        if (history.isIsActive()) {
            history.setEndDate(date);
            history.setIsActive(false);
            entityManager.merge(history);
            return true;
        }
        return false;
    }

    public History updateTotalCost(History history, double totalCost) {
        history.setTotalCost(totalCost);
        return entityManager.merge(history);
    }
}
