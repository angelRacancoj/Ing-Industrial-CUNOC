package User.repository;

import Production.Step;
import User.RolUser;
import User.User;
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
import static config.Constants.PERSISTENCE_UNIT_NAME;

@Stateless
@LocalBean
public class UserRepository {
    @PersistenceContext(name=PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;
    
    public void setEntityManager(EntityManager entityManager){
        this.entityManager=entityManager;
    }
    
    public Optional<User> getUserByCarnet(Integer carnet){
        TypedQuery<User> typeQuerry= entityManager.createQuery("SELECT u FROM user u WHERE u.carnet = :carnet",User.class);
        typeQuerry.setParameter("carnet",carnet);
        try {
            return Optional.of(typeQuerry.getSingleResult());
        } catch (Exception e) {
            return Optional.empty();
        }
    }
    
    public List<User> getUser(Integer carnet, String name, Integer state,Integer id_rol,Integer id_career){       
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> user = criteriaQuery.from(User.class);
        List<Predicate> predicates=new ArrayList<>();
        if(carnet!=null){
            predicates.add(criteriaBuilder.equal(user.get("carnet"),carnet));
        }
        if(name!=null){
            predicates.add(criteriaBuilder.like(user.get("name"), "%" + name + "%"));
        }
        if(state!=null){
            predicates.add(criteriaBuilder.equal(user.get("state"), state));
        }
        if(id_rol!=null){
            predicates.add(criteriaBuilder.equal(user.get("id_rol"), id_rol));
        }
        if(id_career!=null){
            predicates.add(criteriaBuilder.equal(user.get("id_career"), id_career));
        }
        criteriaQuery.where(predicates.stream().toArray(Predicate[]::new));
        TypedQuery<User> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
    
}
