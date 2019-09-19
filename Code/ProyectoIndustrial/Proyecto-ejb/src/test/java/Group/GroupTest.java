package Group;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Proyecto-ejb
 * @author jose - 18.09.2019 
 * @Title: GroupTest
 * @Description: description
 *
 * Changes History
 */
public class GroupTest {
    
    @Test
    public void testSetAndGetIdGroup() throws Exception {
        // Arrange
        Group testGroup = new Group();
        int testVal = 100;
        
        // Act
        testGroup.setIdGroup(testVal);
        int result = testGroup.getIdGroup();
        
        // Assert
        Assert.assertEquals(result, testVal);
    }
}