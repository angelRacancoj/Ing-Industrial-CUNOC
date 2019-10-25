package User.repository;

import User.Career;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.mockito.Mockito;
import org.testng.annotations.Test;

public class CareerRepositoryTest {
    private static String FIND_BY_CARNET="SELECT c ";
    
    @Test
    public void getCareerByIdTest(){
        Integer id=1;
        EntityManager entityManager=Mockito.mock(EntityManager.class);
        CriteriaBuilder criteriaBuilder=Mockito.mock(CriteriaBuilder.class);
                //criteriaBuilder.createQuery(Career.class);
        
    
    }
    @Test
    public void getCareerByNameTest(){
    
    }
    @Test
    public void getCareerByIdAndNameTest(){
    
    }
    
    public void createQuery(EntityManager entityManager){
        Mockito.when(this);
    }
}
