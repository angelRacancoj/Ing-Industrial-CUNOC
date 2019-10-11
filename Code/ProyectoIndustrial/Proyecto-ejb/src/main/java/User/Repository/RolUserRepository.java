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
public class RolUserRepository {
    @PersistenceContext(name=PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;
    
//    public Optional<RolUser> findById(int id_rol){
//        Query query=entityManager.createQuery("SELECT r FORM rol_user r WHERE :r.id_rol= :id_rol").setParameter("id_rol",id_rol);
//        return query.getResultStream().findFirst();
//    }
//    
//    public Optional<List<RolUser>> findByName(int id_rol){
//        Query query=entityManager.createQuery("SELECT r FORM rol_user r WHERE :r.id_rol LIKE CONCAT('%',:id_rol,'%')").setParameter("id_rol",id_rol);
//        List<RolUser> result = query.getResultList();
//        return Optional.of(query.getResultList());
//    }
//    public Optional<List<RolUser>> findAll(){
//        Query query=entityManager.createQuery("SELECT c FORM career c");
//        return Optional.of(query.getResultList());
//    }
    
    public Optional<Long> getNextId_rol(){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();  
        CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
        Root<RolUser> root = criteriaQuery.from(RolUser.class);
        criteriaQuery.select(criteriaBuilder.count(root));
        return Optional.of(entityManager.createQuery(criteriaQuery).getSingleResult());
    }
    
    public Optional<List<RolUser>> getRolUser(Integer id_rol, String name){       
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<RolUser> criteriaQuery = criteriaBuilder.createQuery(RolUser.class);
        Root<RolUser> RolUser = criteriaQuery.from(RolUser.class);
        Predicate id_rolRolUser = criteriaBuilder.equal(RolUser.get("id_rol"),id_rol);
        Predicate nameRolUserPredicate = criteriaBuilder.like(RolUser.get("name"), "%" + name + "%");
        criteriaQuery.where(id_rolRolUser, nameRolUserPredicate);
        TypedQuery<RolUser> query = entityManager.createQuery(criteriaQuery);
        return Optional.of(query.getResultList()); 
    }
}
