/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Production.service;

import Produce.History;
import Production.Product;
import Production.Production;
import Production.Stage;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 *
 * @author daniel
 */
@Stateless
@LocalBean
public class ProductionService {

    @PersistenceContext(name = config.Constants.PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;
    
    public void create(Production production) {
        if (production.getHistoryList() == null) {
            production.setHistoryList(new ArrayList<History>());
        }
        if (production.getStageList() == null) {
            production.setStageList(new ArrayList<Stage>());
        }
        
        try {
           
            Product productId = production.getProductId();
            if (productId != null) {
                productId = entityManager.getReference(productId.getClass(), productId.getIdProduct());
                production.setProductId(productId);
            }
            List<History> attachedHistoryList = new ArrayList<History>();
            for (History historyListHistoryToAttach : production.getHistoryList()) {
                historyListHistoryToAttach = entityManager.getReference(historyListHistoryToAttach.getClass(), historyListHistoryToAttach.getHistory_id());
                attachedHistoryList.add(historyListHistoryToAttach);
            }
            production.setHistoryList(attachedHistoryList);
            List<Stage> attachedStageList = new ArrayList<Stage>();
            for (Stage stageListStageToAttach : production.getStageList()) {
                stageListStageToAttach = entityManager.getReference(stageListStageToAttach.getClass(), stageListStageToAttach.getIdStage());
                attachedStageList.add(stageListStageToAttach);
            }
            production.setStageList(attachedStageList);
            entityManager.persist(production);
            if (productId != null) {
                productId.getProductionList().add(production);
                productId = entityManager.merge(productId);
            }
            for (History historyListHistory : production.getHistoryList()) {
                Production oldProductionIdOfHistoryListHistory = historyListHistory.getProduction();
                historyListHistory.setProduction(production);
                historyListHistory = entityManager.merge(historyListHistory);
                if (oldProductionIdOfHistoryListHistory != null) {
                    oldProductionIdOfHistoryListHistory.getHistoryList().remove(historyListHistory);
                    oldProductionIdOfHistoryListHistory = entityManager.merge(oldProductionIdOfHistoryListHistory);
                }
            }
            for (Stage stageListStage : production.getStageList()) {
                Production oldProductionIdOfStageListStage = stageListStage.getProductionId();
                stageListStage.setProductionId(production);
                stageListStage = entityManager.merge(stageListStage);
                if (oldProductionIdOfStageListStage != null) {
                    oldProductionIdOfStageListStage.getStageList().remove(stageListStage);
                    oldProductionIdOfStageListStage = entityManager.merge(oldProductionIdOfStageListStage);
                }
            }
            entityManager.getTransaction().commit();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
}
