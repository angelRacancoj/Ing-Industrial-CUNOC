package Production.repository;

import Production.Commentary;
import java.util.List;
import java.util.Optional;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import static config.Constants.PERSISTENCE_UNIT_NAME;


@Stateless
@LocalBean
public class CommentaryRepository {
    
    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;
    
    public List<Commentary> getAll(){
        CriteriaQuery criteriaQuery = entityManager.getCriteriaBuilder().createQuery();
        criteriaQuery.select(criteriaQuery.from(Commentary.class));
        
        Query query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
    
    
    
    
    
    
}
