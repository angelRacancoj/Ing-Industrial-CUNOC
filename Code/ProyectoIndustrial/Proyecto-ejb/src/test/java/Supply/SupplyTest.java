
package Supply;

import java.time.LocalDate;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SupplyTest {
    
    Supply testSupply = new Supply();
    int testCode = 100;
    String testName = "name test of a Supply";
    LocalDate testExpirationDate = LocalDate.now();
    LocalDate testDateAdmission = LocalDate.now(); 
    double testCost = 10.10;
    double testQuantity = 20.20;
    boolean testAvailability = true;
    String testDescription = "Text of Description of a Supply";
    Measure testMeasure = new Measure();
    Supply testSupplyFullConstructor = new Supply(testCode, testName, testExpirationDate, testDateAdmission, testCost, testQuantity, testAvailability, testDescription, testMeasure);
          
    @Test
    public void testSetAndGetCode() throws Exception {
        testSupply.setCode(testCode);
        int result = testSupply.getCode();
        
        Assert.assertEquals(result,testCode);
    }
    
    @Test
    public void testSetAndGetName() throws Exception {
        testSupply.setName(testName);
        String result = testSupply.getName();
        
        Assert.assertEquals(result,testName);
    }
    
    @Test
    public void testSetAndGetExpirationDate() throws Exception {
        testSupply.setExpirationDate(testExpirationDate);
        LocalDate result = testSupply.getExpirationDate();
        
        Assert.assertEquals(result,testExpirationDate);
    }
    
    @Test
    public void testSetAndGetDateOfAdmission() throws Exception {
        testSupply.setDateOfAdmission(testDateAdmission);
        LocalDate result = testSupply.getDateOfAdmission();
        
        Assert.assertEquals(result,testDateAdmission);
    }
    
    @Test
    public void testSetAndGetCost() throws Exception {
        testSupply.setCost(testCost);
        double result = testSupply.getCost();
        
        Assert.assertEquals(result,testCost);
    }
    
    @Test
    public void testSetAndGetQuantity() throws Exception {
        testSupply.setQuantity(testQuantity);
        double result = testSupply.getQuantity();
        
        Assert.assertEquals(result,testQuantity);
    }
    
    @Test
    public void testSetAndGetAvailability() throws Exception {
        testSupply.setAvailability(testAvailability);
        boolean result = testSupply.isAvailability();
        
        Assert.assertEquals(result,testAvailability);
    }
    
    @Test
    public void testSetAndGetDescription() throws Exception {
        testSupply.setDescription(testDescription);
        String result = testSupply.getDescription();
        
        Assert.assertEquals(result,testDescription);
    }
    
    @Test
    public void testSetAndGetMeasure() throws Exception {
        testSupply.setMeasure(testMeasure);
        Measure result = testSupply.getMeasure();
        
        Assert.assertEquals(result,testMeasure);
    }
}