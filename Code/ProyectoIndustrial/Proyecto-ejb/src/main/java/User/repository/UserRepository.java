package User.repository;

import User.RolUser;
import User.User;
import static config.Constants.PERSISTENCE_UNIT_NAME;
import java.util.ArrayList;
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
public class UserRepository {
    @PersistenceContext(name=PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;
    
    public Optional<List<User>> getUser(Integer carnet, String name, Integer state,Integer id_rol,Integer id_career){       
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> User = criteriaQuery.from(User.class);
        List<Predicate> predicates=new ArrayList<>();
        if(carnet!=null){
            predicates.add(criteriaBuilder.like(User.get("carnet"), "%" + carnet + "%"));
        }
        if(name!=null){
            predicates.add(criteriaBuilder.like(User.get("name"), "%" + name + "%"));
        }
        if(state!=null){
            predicates.add(criteriaBuilder.equal(User.get("state"), state));
        }
        if(id_rol!=null){
            predicates.add(criteriaBuilder.equal(User.get("id_rol"), id_rol));
        }
        if(id_career!=null){
            predicates.add(criteriaBuilder.equal(User.get("id_career"), id_career));
        }
        criteriaQuery.where((Predicate[]) predicates.stream().toArray());
        TypedQuery<User> query = entityManager.createQuery(criteriaQuery);
        return Optional.of(query.getResultList());
    }
    
}
