
package Production.service;

import Production.Product;
import Production.Production;
import Production.exceptions.MandatoryAttributeProductionException;
import java.time.LocalDate;
import javax.persistence.EntityManager;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author daniel
 */
public class ProductionServiceTest {
        EntityManager entityManager= Mockito.mock(EntityManager.class);
        ProductionService productionService= new ProductionService();
        LocalDate localDate = LocalDate.now();
        
        Product product = new Product();
        
        @Test
        public void CreateProductionTest() throws MandatoryAttributeProductionException{
            //Arrange
            Production production = new Production(null, "production", true, 4, localDate);
            productionService.setEntityManager(entityManager);
            
            Mockito.doNothing().when(entityManager).persist(production);
            
            
            production.setProductId(product);
            //Act
            Production result = productionService.create(production);
            //Assert
            Assert.assertEquals(result, production);
            
        }
        
        @Test(expectedExceptions = MandatoryAttributeProductionException.class,
                expectedExceptionsMessageRegExp = "Nombre nulo")
        public void MandatoryAttributeProductionExceptionNameCreate() throws Exception {
            //Arrange
            Production production = new Production(null, null, true, 10, localDate);
            production.setProductId(product);
            productionService.setEntityManager(entityManager);
            
            //Act
            productionService.create(production);
            
            
        }
        
        
        @Test(expectedExceptions = MandatoryAttributeProductionException.class,
                expectedExceptionsMessageRegExp = "Unidad por lote nulo")
        public void MandatoryAttributeProductionExceptionUnityCreate() throws Exception {
            //Arrange
            Production production = new Production(null, "nombre", true, 0, localDate);
            production.setProductId(product);
            productionService.setEntityManager(entityManager);
            
            //Act
            productionService.create(production);
            
            
        }
        
        @Test(expectedExceptions = MandatoryAttributeProductionException.class,
                expectedExceptionsMessageRegExp = "Fecha de creacion nula")
        public void MandatoryAttributeProductionExceptionDateCreate() throws Exception {
            //Arrange
            Production production = new Production(null, "nombre", true, 10, null);
            production.setProductId(product);
            productionService.setEntityManager(entityManager);
            
            //Act
            productionService.create(production);
            
            
        }
        
        
        @Test(expectedExceptions = MandatoryAttributeProductionException.class,
                expectedExceptionsMessageRegExp = "Producto nulo")
        public void MandatoryAttributeProductionExceptionProductCreate() throws Exception {
            //Arrange
            Production production = new Production(null, "nombre", true, 10, localDate);            
            productionService.setEntityManager(entityManager);
            
            //Act
            productionService.create(production);
            
            
        }
        
        
        @Test
        public void editProductionTest() throws MandatoryAttributeProductionException{
            //Arrange
            Production production = new Production(null, "production", true, 4, localDate);
            productionService.setEntityManager(entityManager);
            
            //Mockito.doNothing().when(entityManager).merge(production);
            Mockito.when(entityManager.merge(production)).thenReturn(production);
            production.setProductId(product);
            //Act
            Production result = productionService.edit(production);
            //Assert
            Assert.assertEquals(result, production);
            
        }
        
        //Test if editar 
        @Test(expectedExceptions = MandatoryAttributeProductionException.class,
                expectedExceptionsMessageRegExp = "Nombre nulo")
        public void MandatoryAttributeProductionExceptionNameEdit() throws Exception {
            //Arrange
            Production production = new Production(null, null, true, 10, localDate);
            production.setProductId(product);
            productionService.setEntityManager(entityManager);
            
            //Act
            productionService.edit(production);
            
            
        }
        
        
        @Test(expectedExceptions = MandatoryAttributeProductionException.class,
                expectedExceptionsMessageRegExp = "Unidad por lote nulo")
        public void MandatoryAttributeProductionExceptionUnityEdit() throws Exception {
            //Arrange
            Production production = new Production(null, "nombre", true, 0, localDate);
            production.setProductId(product);
            productionService.setEntityManager(entityManager);
            
            //Act
            productionService.edit(production);
            
            
        }
        
        @Test(expectedExceptions = MandatoryAttributeProductionException.class,
                expectedExceptionsMessageRegExp = "Fecha de creacion nula")
        public void MandatoryAttributeProductionExceptionDateEdit() throws Exception {
            //Arrange
            Production production = new Production(null, "nombre", true, 10, null);
            production.setProductId(product);
            productionService.setEntityManager(entityManager);
            
            //Act
            productionService.edit(production);
            
            
        }
        
        
        @Test(expectedExceptions = MandatoryAttributeProductionException.class,
                expectedExceptionsMessageRegExp = "Producto nulo")
        public void MandatoryAttributeProductionExceptionProductEdit() throws Exception {
            //Arrange
            Production production = new Production(null, "nombre", true, 10, localDate);            
            productionService.setEntityManager(entityManager);
            
            //Act
            productionService.edit(production);
            
            
        }
        
        
}
