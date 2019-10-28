package User.repository;

import User.RolUser;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RolUserRepositoryTest {

    EntityManager entityManager = Mockito.mock(EntityManager.class);

    @Test
    public void getRolUser() {
        List<RolUser> rolUsers = new ArrayList<>();
        rolUsers.add(new RolUser());
        Predicate predicate = Mockito.mock(Predicate.class);
        CriteriaQuery<RolUser> criteriaQuery = Mockito.mock(CriteriaQuery.class);
        List<RolUser> result = mockittoWhen(rolUsers, predicate, criteriaQuery, null, null, null).getRolUser(null, null);

        //asserte
        Assert.assertEquals(result, rolUsers);
        
    }
    
    @Test
    public void getRolUserWithId() {
        Integer id=1;
        List<RolUser> rolUsers = new ArrayList<>();
        rolUsers.add(new RolUser());
        Predicate predicate = Mockito.mock(Predicate.class);
        CriteriaQuery<RolUser> criteriaQuery = Mockito.mock(CriteriaQuery.class);
        List<RolUser> result = mockittoWhen(rolUsers, predicate, criteriaQuery,"id_rol", id, null).getRolUser(id, null);

        //asserte
        Assert.assertEquals(result, rolUsers);
        
        Predicate[] predicates = new Predicate[1];
        predicates[0] = predicate;

        //verefy query
        Mockito.verify(criteriaQuery).where(predicates);
    }
    @Test
    public void getRolUserWithName() {
        String name="name";
        List<RolUser> rolUsers = new ArrayList<>();
        rolUsers.add(new RolUser());
        Predicate predicate = Mockito.mock(Predicate.class);
        CriteriaQuery<RolUser> criteriaQuery = Mockito.mock(CriteriaQuery.class);
        List<RolUser> result = mockittoWhen(rolUsers, predicate, criteriaQuery,"name", null, name).getRolUser(null, name);

        //asserte
        Assert.assertEquals(result, rolUsers);
        
        Predicate[] predicates = new Predicate[1];
        predicates[0] = predicate;

        //verefy query
        Mockito.verify(criteriaQuery).where(predicates);
    }
    private RolUserRepository mockittoWhen(List<RolUser> rolUsers, Predicate predicate, CriteriaQuery<RolUser> criteriaQuery, String atribute, Integer id, String name) {

        CriteriaBuilder criteriaBuilder = Mockito.mock(CriteriaBuilder.class);
        Root<RolUser> rolUser = Mockito.mock(Root.class);
        TypedQuery<RolUser> typeQuery = Mockito.mock(TypedQuery.class);

        Mockito.when(entityManager.getCriteriaBuilder()).thenReturn(criteriaBuilder);
        Mockito.when(criteriaBuilder.createQuery(RolUser.class)).thenReturn(criteriaQuery);
        Mockito.when(criteriaQuery.from(RolUser.class)).thenReturn(rolUser);
        if (atribute==null) {
            //not add predicate
        } else if (id == null) {
            Mockito.when(criteriaBuilder.like(rolUser.get(atribute), "%" + name + "%")).thenReturn(predicate);
        } else {
            Mockito.when(criteriaBuilder.equal(rolUser.get(atribute), id)).thenReturn(predicate);
        }
        Mockito.when(criteriaQuery.where(predicate)).thenReturn(criteriaQuery);
        Mockito.when(entityManager.createQuery(criteriaQuery)).thenReturn(typeQuery);
        Mockito.when(typeQuery.getResultList()).thenReturn(rolUsers);
        Mockito.when(criteriaQuery.where(Mockito.any(Predicate[].class))).thenReturn(criteriaQuery);

        RolUserRepository rolUserRepository = new RolUserRepository();
        rolUserRepository.setEntityManager(entityManager);
        return rolUserRepository;
    }
}
