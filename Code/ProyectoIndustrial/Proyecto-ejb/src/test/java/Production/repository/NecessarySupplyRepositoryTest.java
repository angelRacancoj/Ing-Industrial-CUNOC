package Production.repository;


import static Produce.repository.HistoryRespository.GET_ALL;
import Production.NecessarySupply;
import static Production.Product_.idProduct;
import static Production.Step_.idStep;
import static Production.repository.NecessarySupplyRepository.FIND_BY_STEP;
import static Production.repository.NecessarySupplyRepository.FIND_BY_SUPPLY;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;


public class NecessarySupplyRepositoryTest {
    
    
    @Test
    public void getNecessarySupplyByIdTest() {
        // Arrange
        int idNecessarySupply = 1;
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        NecessarySupply necessarySupply = new NecessarySupply();
        Mockito.when(
                entityManager.find(NecessarySupply.class, idNecessarySupply)
        ).thenReturn(necessarySupply);
        NecessarySupplyRepository necessarySupplyRepository = new NecessarySupplyRepository();
        necessarySupplyRepository.setEntityManager(entityManager);

        // Act
        Optional<NecessarySupply> result = necessarySupplyRepository.getNecessarySupplyById(idNecessarySupply);

        // Assert
        Assert.assertEquals(result.get(), necessarySupply);
    }
    
    public void getNecessarySupplyByStepTest() {
        
        // Arrange
        int idStep = 1;
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        Query query = Mockito.mock(Query.class);
        
        Mockito.when(
                entityManager.createQuery(FIND_BY_STEP)
        ).thenReturn(query);
        Mockito.when(
                query.setParameter("step", idStep)
        ).thenReturn(query);
        
        List<NecessarySupply> NecessarySupplies = new LinkedList<NecessarySupply>();
        Mockito.when(query.getResultList()).thenReturn(NecessarySupplies);
        
        NecessarySupplyRepository necessarySupplyRepository = new NecessarySupplyRepository();
        necessarySupplyRepository.setEntityManager(entityManager);
        
        // Act
        Optional<NecessarySupply> result = necessarySupplyRepository.getNecessarySupplyByStep(idStep);
        
        // Assert
        Assert.assertEquals(result, NecessarySupplies);
    }
    
    
    public void getNecessarySupplyBySupplyTest() {
        
        // Arrange
        int idSupply = 1;
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        Query query = Mockito.mock(Query.class);
        
        Mockito.when(
                entityManager.createQuery(FIND_BY_SUPPLY)
        ).thenReturn(query);
        Mockito.when(
                query.setParameter("supply", idSupply)
        ).thenReturn(query);
        
        List<NecessarySupply> NecessarySupplies = new LinkedList<NecessarySupply>();
        Mockito.when(query.getResultList()).thenReturn(NecessarySupplies);
        
        NecessarySupplyRepository necessarySupplyRepository = new NecessarySupplyRepository();
        necessarySupplyRepository.setEntityManager(entityManager);
        
        // Act
        Optional<NecessarySupply> result = necessarySupplyRepository.getNecessarySupplyBySupply(idSupply);
        
        // Assert
        Assert.assertEquals(result, NecessarySupplies);
    }
    
    
    public void getAllTest(){
        // Arrange
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        Query query = Mockito.mock(Query.class);
        
        Mockito.when(
                entityManager.createQuery(GET_ALL)
        ).thenReturn(query);
        
        List<NecessarySupply> necessarySupply = new LinkedList<NecessarySupply>();
        Mockito.when(
                query.getResultList()
        ).thenReturn(necessarySupply);
        
        NecessarySupplyRepository necessarySupplyRepository = new NecessarySupplyRepository();
        necessarySupplyRepository.setEntityManager(entityManager);
        
        // Act
        List<NecessarySupply> result = necessarySupplyRepository.getAll();
        
        //Assert
        Assert.assertEquals(result, necessarySupply);
    }
    
    
    
}
