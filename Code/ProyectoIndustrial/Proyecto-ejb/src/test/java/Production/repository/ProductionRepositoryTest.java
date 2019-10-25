package Production.repository;
import Production.Production;
import static Production.repository.ProductionRepository.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;


/**
 *
 * @author daniel
 */
public class ProductionRepositoryTest {
    
    
    private TypedQuery getTypedQuery(){
        TypedQuery<Production> typedQuery = Mockito.mock(TypedQuery.class);
        
        
        
        return typedQuery;
        
    }
    
    private EntityManager getmanager(String query, int productionId , Production expected, boolean mockError) {
        
        EntityManager entityManager= Mockito.mock(EntityManager.class);
        TypedQuery<Production> typedQuery = Mockito.mock(TypedQuery.class);
        Mockito.when(entityManager.createQuery(query, Production.class)).thenReturn(typedQuery);
        Mockito.when(typedQuery.setParameter(1, productionId)).thenReturn(typedQuery);
        if (mockError) {
            Mockito.when(typedQuery.getSingleResult()).thenThrow(new NoResultException());
            return entityManager;
        }
        Mockito.when(typedQuery.getSingleResult()).thenReturn(expected);
        return  entityManager;
    }
    
    @Test
    public void FindByIdProductionTest() throws Exception {
        // Arrange
        int productionId = 1;
        Production production = new Production();
        EntityManager entityManager= getmanager(QUERY_FIND_BY_ID, productionId, production, false);
        ProductionRepository productionRepository = new  ProductionRepository();
        productionRepository.setEntityManager(entityManager);

        // Act
        Optional<Production> result = productionRepository.findByIdProduction(productionId);
        // Assert
        Assert.assertEquals(result.get(), production);
        
    }
    
    @Test
    public void FindByIdProductionNoResultExceptionTest() throws Exception {
        // Arrange
        int productionId = 1;
        Production production = new Production();
        EntityManager entityManager= getmanager(QUERY_FIND_BY_ID, productionId, production, true);
        ProductionRepository productionRepository = new  ProductionRepository();
        productionRepository.setEntityManager(entityManager);

        // Act
        Optional<Production> result = productionRepository.findByIdProduction(productionId);
        // Assert
        Assert.assertFalse(result.isPresent(),"Expected optinal empty");
        
    }
    
    @Test
    public void AllProductionsTest() throws Exception {
        // Arrange
        List<Production> productions= new ArrayList<Production>();       
        EntityManager entityManager= Mockito.mock(EntityManager.class);
        TypedQuery<Production> typedQuery = Mockito.mock(TypedQuery.class);
        Mockito.when(entityManager.createQuery(QUERY_ALL_PRODUCTIONS, Production.class)).thenReturn(typedQuery);
        ProductionRepository productionRepository = new  ProductionRepository();
        productionRepository.setEntityManager(entityManager);        
        Mockito.when(typedQuery.getResultList()).thenReturn(productions);
        

        // Act
        List<Production> result = productionRepository.AllProductions();
        // Assert
        Assert.assertEquals(result, productions);
        
    }
    
    
    @Test
    public void findProductionLikeNameTest() throws Exception {
        // Arrange
        String name= "nombre";
        List<Production> productions= new ArrayList<Production>();
        
        EntityManager entityManager= Mockito.mock(EntityManager.class);
        TypedQuery<Production> typedQuery = Mockito.mock(TypedQuery.class);
        Mockito.when(entityManager.createQuery(QUERY_LIKE_PRODUCTIONS, Production.class)).thenReturn(typedQuery);
        Mockito.when(typedQuery.setParameter(1, name)).thenReturn(typedQuery); 
        Mockito.when(typedQuery.getResultList()).thenReturn(productions);
         
         
        ProductionRepository productionRepository = new  ProductionRepository();
        productionRepository.setEntityManager(entityManager);
        
        
        

        // Act
        List<Production> result = productionRepository.findProductionLikeName(name);
        // Assert
        Assert.assertEquals(result, productions);
        
    }
    
    
}
