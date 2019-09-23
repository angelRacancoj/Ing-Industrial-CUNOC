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
    public void testSetAndGetIdProduction() throws Exception {
        // Arrange
        NecessarySupply testNecessarySupply = new NecessarySupply();
        Produccion testVal = new Produccion();
        
        // Act
        testNecessarySupply.setProduccion(testVal);
        Produccion result = testNecessarySupply.getProduccion();
        
        // Assert
        Assert.assertEquals(result, testVal);
        
    }
    
    
    @Test
    
    public void testSetAndGetIdSupply() throws Exception {
        // Arrange
        NecessarySupply testNecessarySupply = new NecessarySupply();
        Supply testVal = new Supply();
        
        // Act
        testNecessarySupply.setSupply(testVal);
        Supply result = testNecessarySupply.getSupply();
        
        // Assert
        Assert.assertEquals(result, testVal);
        
    }
    
    
}
