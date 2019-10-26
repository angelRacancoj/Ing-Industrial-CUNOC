package Produce.service;

import Group.Group;
import Produce.History;
import Production.Production;
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
public class HistoryService {
    
    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;
    
    public void createHistory(Date startDate, Integer batchesProduced, boolean isActive, Production production, Group group, Production productionId){
        History history = new History(startDate, batchesProduced, isActive, production, group, productionId);
        entityManager.persist(history);
    }
    
    /**
     * return false if have already set a End Date 
     * @param historyId
     * @param date
     * @return
     */
    public boolean setEndDate(Integer historyId, Date date){
        History history = entityManager.find(History.class, historyId);
        if (history.isIsActive()) {
            history.setEndDate(date);
            history.setIsActive(false);
            return true;
        }
        return false;
    }
    
    public void updateTotalCost(Integer historyId, double totalCost){
        History history = entityManager.find(History.class, historyId);
        history.setTotalCost(totalCost);
    }
}
