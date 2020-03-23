package Production.repository;


import Production.Commentary;
import Production.Product;
import static Production.repository.ProductRepository.FIND_BY_ID;
import static Production.repository.ProductRepository.FIND_BY_NAME;
import static Production.repository.ProductRepository.GET_ALL;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductRepositoryTest {
    
    
//    @Test
//    public void getProductByIdtWithResult() throws Exception {
//        // Arrange
//        int id = 1;
//        EntityManager entityManager = Mockito.mock(EntityManager.class);
//        TypedQuery type = Mockito.mock(TypedQuery.class);
//        Product product = new Product();
//        Mockito.when(
//                entityManager.createQuery(FIND_BY_ID,Product.class)
//        ).thenReturn(type);
//        Mockito.when(type.setParameter("id", id)).thenReturn(type);
//        Mockito.when(type.getSingleResult()).thenReturn(product);
//        ProductRepository productRepository = new ProductRepository();
//        productRepository.setEntityManager(entityManager);
//
//        // Act        
//        Optional<Product> result = productRepository.getProductById(id);
//
//        // Assert
//        Assert.assertEquals(result.get(), product);
//    }
//    
//    
//    
//    @Test
//    public void getProductByIdWithNoResult() throws Exception {
//        // Arrange
//        int id = 1;
//        EntityManager entityManager = Mockito.mock(EntityManager.class);
//        TypedQuery type = Mockito.mock(TypedQuery.class);
//        Product product = new Product();
//        NoResultException exception = new NoResultException();
//        Mockito.when(
//                entityManager.createQuery(FIND_BY_ID,Product.class)
//        ).thenReturn(type);
//        Mockito.when(type.setParameter("id", id)).thenReturn(type);
//        Mockito.when(type.getSingleResult()).thenThrow(exception);
//        ProductRepository productRepository = new ProductRepository();
//        productRepository.setEntityManager(entityManager);
//
//        // Act        
//        Optional<Product> result = productRepository.getProductById(id);
//
//        // Assert
//        
//        Assert.assertFalse(result.isPresent(), "Expected an optional empty");
//        
//        
//    }
    
    
    
    @Test
    public void getProductByNametWithResult() throws Exception {
        // Arrange
        String name = "nombre";
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        TypedQuery type = Mockito.mock(TypedQuery.class);
        Product product = new Product();
        Mockito.when(
                entityManager.createQuery(FIND_BY_NAME,Product.class)
        ).thenReturn(type);
        Mockito.when(type.setParameter("name", name)).thenReturn(type);
        Mockito.when(type.getSingleResult()).thenReturn(product);
        ProductRepository productRepository = new ProductRepository();
        productRepository.setEntityManager(entityManager);

        // Act        
        Optional<Product> result = productRepository.getProductByName(name);

        // Assert
        Assert.assertEquals(result.get(), product);
    }
    
    
    
    @Test
    public void getProductByNameWithNoResult() throws Exception {
        // Arrange
        String name = "nombre";
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        TypedQuery type = Mockito.mock(TypedQuery.class);
        Product product = new Product();
        NoResultException exception = new NoResultException();
        Mockito.when(
                entityManager.createQuery(FIND_BY_NAME,Product.class)
        ).thenReturn(type);
        Mockito.when(type.setParameter("name", name)).thenReturn(type);
        Mockito.when(type.getSingleResult()).thenThrow(exception);
        ProductRepository productRepository = new ProductRepository();
        productRepository.setEntityManager(entityManager);

        // Act        
        Optional<Product> result = productRepository.getProductByName(name);

        // Assert
        
        Assert.assertFalse(result.isPresent(), "Expected an optional empty");   
    }
    
    
    @Test
    public void getAllWithResult() throws Exception {
        // Arrange
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        TypedQuery type = Mockito.mock(TypedQuery.class);
        List<Product> product = new LinkedList<Product>();
        Mockito.when(
                entityManager.createQuery(GET_ALL ,Product.class)
        ).thenReturn(type);
        Mockito.when(type.getResultList()).thenReturn(product);
        ProductRepository productRepository = new ProductRepository();
        productRepository.setEntityManager(entityManager);

        // Act        
        Optional<List<Product>> result = productRepository.getAll();

        // Assert
        Assert.assertEquals(result.get(), product);
    }
    
    
    @Test
    public void getAllWithNoResult() throws Exception {
        // Arrange
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        TypedQuery type = Mockito.mock(TypedQuery.class);
        List<Product> product = new LinkedList<Product>();
        NoResultException exception = new NoResultException();
        Mockito.when(
                entityManager.createQuery(GET_ALL,Product.class)
        ).thenReturn(type);
        Mockito.when(type.getResultList()).thenThrow(exception);
        ProductRepository productRepository = new ProductRepository();
        productRepository.setEntityManager(entityManager);

        // Act        
        Optional<List<Product>> result = productRepository.getAll();

        // Assert
        Assert.assertFalse(result.isPresent(), "Expected an optional empty");
    }
    
    
}
