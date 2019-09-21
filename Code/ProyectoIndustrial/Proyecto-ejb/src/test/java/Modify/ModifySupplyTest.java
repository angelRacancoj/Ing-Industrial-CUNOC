package Modify;

import Supply.Supply;
import User.User;
import java.time.Instant;
import java.util.Date;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author angelrg
 */
public class ModifySupplyTest {

    @Test
    public void testGetAndSetIdModifySupply() throws Exception {
        //Arrange
        ModifySupply modifySupply = new ModifySupply();
        int testVal = 201912345;

        //Act
        modifySupply.setIdModifySupply(testVal);
        int result = modifySupply.getIdModifySupply();

        //Assert
        Assert.assertEquals(result, testVal);
    }

    @Test
    public void testGetAndSetUser() throws Exception {
        //Arrange
        ModifySupply modifySupply = new ModifySupply();
        User user = new User();

        //Act
        modifySupply.setUser(user);
        User result = modifySupply.getUser();
        
        //Assert
        Assert.assertEquals(result, user);
    }

    @Test
    public void testGetAndSetSupply() throws Exception {
        //Arrange
        ModifySupply modifySupply = new ModifySupply();
        Supply supply = new Supply();

        //Act
        modifySupply.setSupply(supply);
        Supply result = modifySupply.getSupply();
        
        //Assert
        Assert.assertEquals(result, supply);
    }

    @Test
    public void testGetAndSetModificationTypeUser() throws Exception {
        //Arrange
        ModifySupply modifySupply = new ModifySupply();
        ModificationType testModType = ModificationType.POR_ROBO;

        //Act
        modifySupply.setmodifyType(testModType);
        ModificationType result = modifySupply.getmodifyType();

        //Assert
        Assert.assertEquals(result, testModType);
    }

    @Test
    public void testGetAndSetQuantity() throws Exception {
        //Arrange
        ModifySupply modifySupply = new ModifySupply();
        int testVal = 23;

        //Act
        modifySupply.setQuantity(testVal);
        int result = modifySupply.getQuantity();

        //Assert
        Assert.assertEquals(result, testVal);
    }

    @Test
    public void testGetAndSetDate() throws Exception {
        //Arrange
        ModifySupply modifySupply = new ModifySupply();
        Date testDate = Date.from(Instant.now());

        //Act
        modifySupply.setDate(testDate);
        Date result = modifySupply.getDate();

        //Assert
        Assert.assertEquals(result, testDate);
    }

    @Test
    public void testGetAndSetNota() throws Exception {
        //Arrange
        ModifySupply modifySupply = new ModifySupply();
        String testText = "Esta es una nota de prueba";

        //Act
        modifySupply.setNote(testText);
        String result = modifySupply.getNote();
        
        //Assert
        Assert.assertEquals(result, testText);
    }

}
