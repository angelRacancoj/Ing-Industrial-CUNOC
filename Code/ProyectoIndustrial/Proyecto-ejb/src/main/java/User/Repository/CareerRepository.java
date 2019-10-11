package User.Repository;

import User.Career;
import User.RolUser;
import static config.Constants.PERSISTENCE_UNIT_NAME;
import java.util.List;
import java.util.Optional;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Stateless
@LocalBean
public class CareerRepository{
    
    @PersistenceContext(name=PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;
    
    
//    public Optional<Career> findById(int id_career){
//        Query query=entityManager.createQuery("SELECT c FORM career c WHERE :c.id_career= :id_career").setParameter("id_career", id_career); 
//        return query.getResultStream().findFirst();
//    }
//    public Optional<List<Career>> findByName(String name_career){
//        Query query=entityManager.createQuery("SELECT c FORM career c WHERE :c.name_career LIKE CONCAT('%',:name_career,'%')").setParameter("name_career",name_career);
//        return Optional.of(query.getResultList());
//    }
//    public Optional<List<Career>> findAll(){
//        Query query=entityManager.createQuery("SELECT c FORM career c");
//        return Optional.of(query.getResultList());
//    }
    
    public Optional<Long> getNextId_rol(){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();  
        CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
        Root<Career> root = criteriaQuery.from(Career.class);
        criteriaQuery.select(criteriaBuilder.count(root));
        return Optional.of(entityManager.createQuery(criteriaQuery).getSingleResult());
    }
    
    public Optional<List<Career>> getCareer(Integer id_career, String name){       
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Career> criteriaQuery = criteriaBuilder.createQuery(Career.class);
        Root<Career> Career = criteriaQuery.from(Career.class);
        Predicate id_careerCareerPredicate = criteriaBuilder.equal(Career.get("id_career"),id_career);
        Predicate nameCareerPredicate = criteriaBuilder.like(Career.get("name"), "%" + name + "%");
        criteriaQuery.where(id_careerCareerPredicate, nameCareerPredicate);
        TypedQuery<Career> query = entityManager.createQuery(criteriaQuery);
        return Optional.of(query.getResultList());
    }
}
