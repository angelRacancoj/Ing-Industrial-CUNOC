/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Produce.service;

import Produce.History;
import java.util.Date;
import javax.persistence.EntityManager;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author angelrg
 */
public class HistoryServiceTest {

    @Test
    public void createHistoryTest() {
        // Arrange
        History history = new History();
        EntityManager entityManager = Mockito.mock(EntityManager.class);

        Mockito.doNothing().when(entityManager).persist(history);

        HistoryService historyService = new HistoryService();
        historyService.setEntityManager(entityManager);

        // Act
        History result = historyService.createHistory(history);

        // Assert
        Assert.assertEquals(result, history);
    }

    @Test
    public void setEndDateActiveHistory() {
        // Arrange
        History history = new History();
        history.setIsActive(true);

        EntityManager entityManager = Mockito.mock(EntityManager.class);
        HistoryService historyService = new HistoryService();

        mergeHistory(history, entityManager, historyService);

        // Act
        Date date = new Date(2019, 1, 1);
        boolean result = historyService.setEndDate(history, date);

        // Assert
        Assert.assertTrue(result);
    }

    @Test
    public void setEndDateNoActiveHistory() {
        // Arrange
        History history = new History();
        history.setIsActive(false);

        EntityManager entityManager = Mockito.mock(EntityManager.class);
        HistoryService historyService = new HistoryService();

        mergeHistory(history, entityManager, historyService);

        // Act
        Date date = new Date(2019, 1, 1);
        boolean result = historyService.setEndDate(history, date);

        // Assert
        Assert.assertFalse(result);
    }

    @Test
    public void updateTotalCostTest() {
        // Arrange
        History history = new History();
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        HistoryService historyService = new HistoryService();
        mergeHistory(history, entityManager, historyService);

        // Act
        double cost = 100;
        History result = historyService.updateTotalCost(history, cost);

        // Assert
        Assert.assertEquals(result, history);
    }

    private void mergeHistory(History history, EntityManager entityManager, HistoryService historyService) {
        Mockito.when(
                entityManager.merge(history)
        ).thenReturn(history);

        historyService.setEntityManager(entityManager);
    }
}
