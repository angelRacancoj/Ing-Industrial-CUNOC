package Produce.repository;

import Produce.History;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author angelrg
 */
public class HistoryRepositoryTest {
    
    @Test
    public void findByIdTest(){
        // Arrange
        int historyId =1;
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        History history = new History();
        
        Mockito.when(
                entityManager.find(History.class, historyId)
        ).thenReturn(history);
        
        HistoryRespository historyRepository = new HistoryRespository();
        historyRepository.setEntityManager(entityManager);
        
        //Act
        Optional<History> result = historyRepository.findById(historyId);
        
        // Assert
        Assert.assertEquals(result.get(), history);
    }
    
    @Test
    public void getAllTest(){
        // Arrange
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        Query query = Mockito.mock(Query.class);
        
        Mockito.when(
                entityManager.createQuery(HistoryRespository.GET_ALL)
        ).thenReturn(query);
        
        List<History> historyList = new LinkedList<History>();
        
        Mockito.when(
                query.getResultList()
        ).thenReturn(historyList);
        
        HistoryRespository historyRepository = new HistoryRespository();
        historyRepository.setEntityManager(entityManager);
        
        //Act
        List<History> result = historyRepository.getAll();
        
        // Assert
        Assert.assertEquals(result, historyList);
    }
}
