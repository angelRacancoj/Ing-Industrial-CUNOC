package Group;

import User.User;
import java.time.Instant;
import java.util.Date;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author angelrg
 */
public class GroupUserTest {

    @Test
    public void testSetAndGetIdGroupUser() throws Exception {
        //Arrange
        GroupUser testGroupUser = new GroupUser();
        int testVal = 123;

        //Act
        testGroupUser.setidGroupUser(testVal);
        int result = testGroupUser.getidGroupUser();

        //Assert
        Assert.assertEquals(result, testVal);
    }

    @Test
    public void testSetAndGetUser() throws Exception {
        //Arrange
        GroupUser testGroupUser = new GroupUser();
//       User user = new User
    }

    @Test
    public void testSetAndGetIdGroupGroup() throws Exception {
        //Arrange
        GroupUser testGroupUser = new GroupUser();

        //Act
        //Assert
    }

    @Test
    public void testSetAndGetIdGroupAdmissionDate() throws Exception {
        //Arrange
        GroupUser testGroupUser = new GroupUser();
        Date testDate = Date.from(Instant.now());

        //Act
        testGroupUser.setAdmissionDate(testDate);
        Date result = testGroupUser.getAdmissionDate();

        //Assert
        Assert.assertEquals(result, testDate);
    }
}
