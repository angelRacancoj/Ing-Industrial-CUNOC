package User.repository;

import User.Career;
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

public class CareerRepositoryTest {
    EntityManager entityManager = Mockito.mock(EntityManager.class);
    
    @Test
    public void getCareer(){
        List<Career> careers = new ArrayList<>();
        careers.add(new Career());
        Predicate predicate = Mockito.mock(Predicate.class);
        CriteriaQuery<Career> criteriaQuery = Mockito.mock(CriteriaQuery.class);
        List<Career> result = mockittoWhen(careers, predicate, criteriaQuery, null, null, null).getCareer(null, null);

        //asserte
        Assert.assertEquals(result, careers);
    }
    
    
    @Test
    public void getCareerWithId(){
        Integer id = 1;
        List<Career> careers = new ArrayList<>();
        careers.add(new Career());
        Predicate predicate = Mockito.mock(Predicate.class);
        CriteriaQuery<Career> criteriaQuery = Mockito.mock(CriteriaQuery.class);
        List<Career> result = mockittoWhen(careers, predicate, criteriaQuery, "id_career", id, null).getCareer(id, null);

        //asserte
        Assert.assertEquals(result, careers);

        Predicate[] predicates = new Predicate[1];
        predicates[0] = predicate;

        //verefy query
        Mockito.verify(criteriaQuery).where(predicates);
    }
    
    @Test
    public void getCareerWithName(){
        String name = "name";
        List<Career> careers = new ArrayList<>();
        careers.add(new Career());
        Predicate predicate = Mockito.mock(Predicate.class);
        CriteriaQuery<Career> criteriaQuery = Mockito.mock(CriteriaQuery.class);
        List<Career> result = mockittoWhen(careers, predicate, criteriaQuery, "name", null, name).getCareer(null, name);

        //asserte
        Assert.assertEquals(result, careers);

        Predicate[] predicates = new Predicate[1];
        predicates[0] = predicate;

        //verefy query
        Mockito.verify(criteriaQuery).where(predicates);
    }
    
    
    
    private CareerRepository mockittoWhen(List<Career> careers, Predicate predicate, CriteriaQuery<Career> criteriaQuery, String atribute, Integer id, String name) {

        CriteriaBuilder criteriaBuilder = Mockito.mock(CriteriaBuilder.class);
        Root<Career> user = Mockito.mock(Root.class);
        TypedQuery<Career> typeQuery = Mockito.mock(TypedQuery.class);

        Mockito.when(entityManager.getCriteriaBuilder()).thenReturn(criteriaBuilder);
        Mockito.when(criteriaBuilder.createQuery(Career.class)).thenReturn(criteriaQuery);
        Mockito.when(criteriaQuery.from(Career.class)).thenReturn(user);
        if (atribute==null) {
            //not add predicate
        } else if (id == null) {
            Mockito.when(criteriaBuilder.like(user.get(atribute), "%" + name + "%")).thenReturn(predicate);
        } else {
            Mockito.when(criteriaBuilder.equal(user.get(atribute), id)).thenReturn(predicate);
        }
        Mockito.when(criteriaQuery.where(predicate)).thenReturn(criteriaQuery);
        Mockito.when(entityManager.createQuery(criteriaQuery)).thenReturn(typeQuery);
        Mockito.when(typeQuery.getResultList()).thenReturn(careers);
        Mockito.when(criteriaQuery.where(Mockito.any(Predicate[].class))).thenReturn(criteriaQuery);

        CareerRepository careerRepository = new CareerRepository();
        careerRepository.setEntityManager(entityManager);
        return careerRepository;
    }
    
}
