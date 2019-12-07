package User.service;

import User.Career;
import User.RolUser;
import User.User;
import User.exception.UserException;
import javax.persistence.EntityManager;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserServiceTest {

    EntityManager entityManager = Mockito.mock(EntityManager.class);

//    @Test
//    public void createUserTest() {
//        User user = new User();
//        UserService userService = new UserService();
//        userService.setEntityManager(entityManager);
//        Mockito.doNothing().when(entityManager).persist(user);
//        User result;
//        try {
//            result = userService.createUser(user);
//        } catch (UserException e) {
//            result = null;
//        }
//        Assert.assertEquals(result, user);
//    }

    @Test
    public void createUserNullTest() {
        User user = null;
        UserService userService = new UserService();
        userService.setEntityManager(entityManager);
        Mockito.doNothing().when(entityManager).persist(user);
        User result;
        try {
            result = userService.createUser(user);
        } catch (UserException e) {
            result = null;
        }
        Assert.assertEquals(result, user);
    }
    
    @Test
    public void updateUserTest() {
        Integer carnet = 201630873;
        String name = "fulanito";
        String email = "fulanito@mail.com";
        Integer phone = 31529868;
        String pass = "pass";
        Boolean state = true;
        RolUser rolUser = new RolUser("Estudiante");
        Career career = new Career("Sistemas");
        User user = new User(carnet, name, email, phone, pass, state, rolUser, career);
        UserService userService = new UserService();
        userService.setEntityManager(entityManager);
        Mockito.when(entityManager.find(User.class, user.getCarnet())).thenReturn(user);
        User result = null;
        try {
            result = userService.updateUser(user);
        } catch (UserException e) {

        }
        Assert.assertEquals(result, user);

    }
    
    @Test
    public void updateUserNullTest() {
        User user = null;
        UserService userService = new UserService();
        userService.setEntityManager(entityManager);
        User result = null;
        try {
            result = userService.updateUser(user);
        } catch (UserException e) {

        }
        Assert.assertEquals(result, user);

    }

}
