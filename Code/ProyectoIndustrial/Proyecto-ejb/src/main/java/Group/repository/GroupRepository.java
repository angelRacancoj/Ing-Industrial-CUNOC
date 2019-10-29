package Group.repository;

import Group.Group;
import static config.Constants.PERSISTENCE_UNIT_NAME;
import java.util.List;
import java.util.Optional;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author angelrg
 */

@Stateless
@LocalBean
public class GroupRepository {
    
    public static final String FIND_BY_ID = "SELECT g FROM Group g WHERE g.idGroup = :id";
    public static final String GET_ALL = "SELECT g FROM Group g";
    
    
    private EntityManager entityManager;
    
    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    public Optional<Group> findById(Integer id){
        TypedQuery<Group> typedQuery = entityManager.createQuery(FIND_BY_ID,Group.class).setParameter("id", id);
        try {
            return Optional.of(typedQuery.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
 
    }
    
    public List<Group> getAll(){
        TypedQuery<Group> typedQuery = entityManager.createQuery(GET_ALL,Group.class);
        return typedQuery.getResultList();
    }
    
}
