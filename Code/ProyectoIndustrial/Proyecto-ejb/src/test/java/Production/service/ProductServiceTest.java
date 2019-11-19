package Production.service;

import Group.service.GroupService;
import Production.Product;
import Production.exceptions.MandatoryAttributeProductionException;
import java.security.acl.Group;
import javax.persistence.EntityManager;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ProductServiceTest {
    
    
    @Test
    public void createProductTest() throws MandatoryAttributeProductionException{
        // Arrange
        Product product = new Product();
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        
        Mockito.doNothing().when(entityManager).persist(product);
                
        ProductService productService = new ProductService();
        productService.setEntityManager(entityManager);
        
        // Act
        Product result = productService.createProduct(product);
        
        // Assert
        Assert.assertEquals(result, product);
    }
    
    
    @Test
    public void updateDescripcionProductTest() throws MandatoryAttributeProductionException{
        // Arrange
        String name = null;
        String description = "a";
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        Product product = Mockito.mock(Product.class);
        
        Mockito.when(
                entityManager.merge(product)
        ).thenReturn(product);
        
        ProductService productService = new ProductService();
        productService.setEntityManager(entityManager);
        
        // Act
        Product result = productService.updateProduct(product, name, description);
        
        //Assert
        Assert.assertEquals(result, product);
        
    }
    
    
    @Test
    public void updateNameProductTest() throws MandatoryAttributeProductionException{
        // Arrange
        String name = "b";
        String description = null;
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        Product product = Mockito.mock(Product.class);
        
        Mockito.when(
                entityManager.merge(product)
        ).thenReturn(product);
        
        ProductService productService = new ProductService();
        productService.setEntityManager(entityManager);
        
        // Act
        Product result = productService.updateProduct(product, name, description);
        
        //Assert
        Assert.assertEquals(result, product);
        
    }
    
    
}
