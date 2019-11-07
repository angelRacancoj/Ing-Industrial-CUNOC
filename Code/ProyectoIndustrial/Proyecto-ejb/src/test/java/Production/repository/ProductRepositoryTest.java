package Production.repository;


import static Produce.repository.HistoryRespository.GET_ALL;
import Production.Product;
import static Production.repository.ProductRepository.FIND_BY_NAME;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductRepositoryTest {
    
    @Test
    public void getProductByIdResult() {
        // Arrange
        int idProduct = 1;
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        Product product = new Product();
        Mockito.when(
                entityManager.find(Product.class, idProduct)
        ).thenReturn(product);
        ProductRepository productRepository = new ProductRepository();
        productRepository.setEntityManager(entityManager);

        // Act
        Optional<Product> result = productRepository.getProductById(idProduct);

        // Assert
        Assert.assertEquals(result.get(), product);
    }
    
    public void getProductByNameTest() {
        
        // Arrange
        String productName = "nombre";
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        Query query = Mockito.mock(Query.class);
        
        Mockito.when(
                entityManager.createQuery(FIND_BY_NAME)
        ).thenReturn(query);
        Mockito.when(
                query.setParameter("name", productName)
        ).thenReturn(query);
        
        List<Product> products = new LinkedList<Product>();
        Mockito.when(query.getResultList()).thenReturn(products);
        
        ProductRepository productRepository = new ProductRepository();
        productRepository.setEntityManager(entityManager);
        
        // Act
        Optional<Product> result = productRepository.getProductByName(productName);
        
        // Assert
        Assert.assertEquals(result, products);
    }
    
    
    public void getAllTest(){
        // Arrange
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        Query query = Mockito.mock(Query.class);
        
        Mockito.when(
                entityManager.createQuery(GET_ALL)
        ).thenReturn(query);
        
        List<Product> product = new LinkedList<Product>();
        Mockito.when(
                query.getResultList()
        ).thenReturn(product);
        
        ProductRepository productRepository = new ProductRepository();
        productRepository.setEntityManager(entityManager);
        
        // Act
        List<Product> result = productRepository.getAll();
        
        //Assert
        Assert.assertEquals(result, product);
    }
    
}
