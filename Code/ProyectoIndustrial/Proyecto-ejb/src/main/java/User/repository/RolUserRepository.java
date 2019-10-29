package User.repository;

import User.Career;
import User.RolUser;
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
public class RolUserRepository {
    @PersistenceContext(name=PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;
    

    public List<RolUser> getRolUser(Integer id_rol, String name){       
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<RolUser> criteriaQuery = criteriaBuilder.createQuery(RolUser.class);
        Root<RolUser> RolUser = criteriaQuery.from(RolUser.class);
        List<Predicate> predicates=new ArrayList<>();
        if(id_rol!=null){
            predicates.add(criteriaBuilder.equal(RolUser.get("id_rol"),id_rol));
        }
        if(name!=null){
            predicates.add(criteriaBuilder.like(RolUser.get("name"), "%" + name + "%"));
        }
        criteriaQuery.where((Predicate[]) predicates.stream().toArray());
        TypedQuery<RolUser> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList(); 
    }
}
