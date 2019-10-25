package User.repository;

import User.Career;
import User.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.mockito.AdditionalMatchers;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserRepositoryTest {

    private static String GET_USER_BY_CARNET = "SELECT u FROM user u WHERE u.carnet = :carnet";
    EntityManager entityManager = Mockito.mock(EntityManager.class);

    @Test
    public void getUserByCarnetTest() {
        Integer carnet = 201630875;
        TypedQuery<User> typeQuery = Mockito.mock(TypedQuery.class);
        Mockito.when(entityManager.createQuery(GET_USER_BY_CARNET, User.class)).thenReturn(typeQuery);
        Mockito.when(typeQuery.setParameter("carnet", carnet)).thenReturn(typeQuery);
        User user = new User();
        Mockito.when(typeQuery.getSingleResult()).thenReturn(user);
        UserRepository userRepository = new UserRepository();
        userRepository.setEntityManager(entityManager);
        Optional<User> result = userRepository.getUserByCarnet(carnet);
        Assert.assertEquals(result.get(), user);
    }

    @Test
    public void getUserWithCarnetTest() {
        Integer carnet = 201630879;
        List<User> users = new ArrayList<>();
        users.add(new User());
        Predicate predicate = Mockito.mock(Predicate.class);
        CriteriaQuery<User> criteriaQuery = Mockito.mock(CriteriaQuery.class);
        List<User> result = mockittoWhen(users,predicate,criteriaQuery,"carnet",carnet).getUser(carnet, null,null, null, null);
        
        //asserte
        Assert.assertEquals(result, users);

        Predicate[] predicates = new Predicate[1];
        predicates[0] = predicate;
        
        //verefy query
        Mockito.verify(criteriaQuery).where(predicates);
    }

    @Test
    public void getUserWithNameTest() {
        Integer carnet = 201630879;
        List<User> users = new ArrayList<>();
        users.add(new User());
        Predicate predicate = Mockito.mock(Predicate.class);
        CriteriaQuery<User> criteriaQuery = Mockito.mock(CriteriaQuery.class);
        List<User> result = mockittoWhen(users,predicate,criteriaQuery,"carnet",carnet).getUser(carnet, null,null, null, null);
        
        //asserte
        Assert.assertEquals(result, users);

        Predicate[] predicates = new Predicate[1];
        predicates[0] = predicate;
        
        //verefy query
        Mockito.verify(criteriaQuery).where(predicates);
    }

    @Test
    public void getUserWithStateTest() {
        Integer state = 1;
        List<User> users = new ArrayList<>();
        users.add(new User());
        CriteriaBuilder criteriaBuilder = Mockito.mock(CriteriaBuilder.class);
        CriteriaQuery<User> criteriaQuery = Mockito.mock(CriteriaQuery.class);
        Root<User> user = Mockito.mock(Root.class);
        Predicate predicate = Mockito.mock(Predicate.class);
        TypedQuery<User> typeQuery = Mockito.mock(TypedQuery.class);
        Mockito.when(entityManager.getCriteriaBuilder()).thenReturn(criteriaBuilder);
        Mockito.when(criteriaBuilder.createQuery(User.class)).thenReturn(criteriaQuery);
        Mockito.when(criteriaQuery.from(User.class)).thenReturn(user);
        Mockito.when(criteriaBuilder.equal(user.get("state"), state)).thenReturn(predicate);
        Mockito.when(criteriaQuery.where(predicate)).thenReturn(criteriaQuery);
        Mockito.when(entityManager.createQuery(criteriaQuery)).thenReturn(typeQuery);
        Mockito.when(typeQuery.getResultList()).thenReturn(users);
        UserRepository userRepository = new UserRepository();
        userRepository.setEntityManager(entityManager);
        Mockito.when(criteriaQuery.where(Mockito.any(Predicate[].class))).thenReturn(criteriaQuery);

        List<User> result = userRepository.getUser(null, null, state, null, null);

        Assert.assertEquals(result, users);

        Predicate[] predicates = new Predicate[1];
        predicates[0] = predicate;

        Mockito.verify(criteriaQuery).where(predicates);
    }

    @Test
    public void getUserWithidRolTest() {
        Integer idRol = 1;
        List<User> users = new ArrayList<>();
        users.add(new User());
        Predicate predicate = Mockito.mock(Predicate.class);
        CriteriaQuery<User> criteriaQuery = Mockito.mock(CriteriaQuery.class);
        List<User> result = mockittoWhen(users,predicate,criteriaQuery,"id_rol",idRol).getUser(null, null,null, idRol, null);
        
        //asserte
        Assert.assertEquals(result, users);

        Predicate[] predicates = new Predicate[1];
        predicates[0] = predicate;
        
        //verefy query
        Mockito.verify(criteriaQuery).where(predicates);
    }

    private UserRepository mockittoWhen(List<User> users,Predicate predicate,CriteriaQuery<User> criteriaQuery,String atribute,Integer value) {
        
        CriteriaBuilder criteriaBuilder = Mockito.mock(CriteriaBuilder.class);
        Root<User> user = Mockito.mock(Root.class);
        TypedQuery<User> typeQuery = Mockito.mock(TypedQuery.class);
        
        Mockito.when(entityManager.getCriteriaBuilder()).thenReturn(criteriaBuilder);
        Mockito.when(criteriaBuilder.createQuery(User.class)).thenReturn(criteriaQuery);
        Mockito.when(criteriaQuery.from(User.class)).thenReturn(user);
        Mockito.when(criteriaBuilder.equal(user.get(atribute), value)).thenReturn(predicate);
        Mockito.when(criteriaQuery.where(predicate)).thenReturn(criteriaQuery);
        Mockito.when(entityManager.createQuery(criteriaQuery)).thenReturn(typeQuery);
        Mockito.when(typeQuery.getResultList()).thenReturn(users);
        Mockito.when(criteriaQuery.where(Mockito.any(Predicate[].class))).thenReturn(criteriaQuery);
        
        UserRepository userRepository = new UserRepository();
        userRepository.setEntityManager(entityManager);
        return userRepository;
    }
}
