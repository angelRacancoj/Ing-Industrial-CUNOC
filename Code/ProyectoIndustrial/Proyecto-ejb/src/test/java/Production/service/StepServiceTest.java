package Production.service;

import Production.Step;
import Production.exceptions.MandatoryAttributeProductionException;
import javax.persistence.EntityManager;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author daniel
 */
public class StepServiceTest {
     EntityManager entityManager = Mockito.mock(EntityManager.class);
    
    StepService stepService = new StepService();
    

    @Test
    public void editProductionTest() throws MandatoryAttributeProductionException {
        //Arrange
        Step step = new Step(null, "name", "description");
        stepService.setEntityManager(entityManager);
        Mockito.when(entityManager.merge(step)).thenReturn(step);
        
        //Act
        Step result = stepService.edit(step);
        //Assert
        Assert.assertEquals(result, step);

    }
    
     //Test if editar 
    @Test(expectedExceptions = MandatoryAttributeProductionException.class,
            expectedExceptionsMessageRegExp = "Nombre nulo")
    public void MandatoryAttributeProductionExceptionNameEdit() throws Exception {
        //Arrange
        Step step = new Step(null, null, "description");
        stepService.setEntityManager(entityManager);
        //Act
        stepService.edit(step);

    }

    @Test(expectedExceptions = MandatoryAttributeProductionException.class,
            expectedExceptionsMessageRegExp = "Descripcion nula")
    public void MandatoryAttributeProductionExceptionUnityEdit() throws Exception {
        //Arrange
        Step step = new Step(null, "name", null);
        stepService.setEntityManager(entityManager);
        
        //Act
        stepService.edit(step);

    }

    
}
