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
        User user = new User();
        
        //Act
        testGroupUser.setUser(user);
        User result = testGroupUser.getUser();
        
        //Assert
        Assert.assertEquals(result, user);
    }

    @Test
    public void testSetAndGetGroup() throws Exception {
        //Arrange
        GroupUser testGroupUser = new GroupUser();
        Group group = new Group();

        //Act
        testGroupUser.setGroup(group);
        Group result = testGroupUser.getGroup();
        
        //Assert
        Assert.assertEquals(result, group);
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
