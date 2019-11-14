package Production;

import Supply.Supply;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NecessarySupplyTest {
    
    @Test
    public void testSetAndGetIdNecessarySupply() throws Exception {
        // Arrange
        NecessarySupply testNecessarySupply = new NecessarySupply();
        int testVal = 100;
        
        // Act
        testNecessarySupply.setIdNecessarySupply(testVal);
        int result = testNecessarySupply.getIdNecessarySupply();
        
        // Assert
        Assert.assertEquals(result, testVal);
        
    }
    
    @Test
    public void testSetAndGetIdStep() throws Exception {
        // Arrange
        NecessarySupply testNecessarySupply = new NecessarySupply();
        Step testVal = new Step();
        
        // Act
        testNecessarySupply.setStep(testVal);
        Step result = testNecessarySupply.getStep();
        
        // Assert
        Assert.assertEquals(result, testVal);
        
    }
    
        
    /*@Test
    
    public void testSetAndGetIdSupply() throws Exception {
        // Arrange
        NecessarySupply testNecessarySupply = new NecessarySupply();
        Supply testVal = new Supply();
        
        // Act
        testNecessarySupply.setSupplyCode(testVal);
        Supply result = testNecessarySupply.getStep();
        
        // Assert
        Assert.assertEquals(result, testVal);
        
    }*/
    
    
}
