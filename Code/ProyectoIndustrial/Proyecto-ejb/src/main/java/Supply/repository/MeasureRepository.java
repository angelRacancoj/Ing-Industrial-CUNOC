
package Supply.repository;

import Supply.Measure;
import static config.Constants.PERSISTENCE_UNIT_NAME;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Stateless
@LocalBean
public class MeasureRepository {
    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;

    public MeasureRepository() {
    }
    
    public List<Measure> getMeasures(){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Measure> criteriaQuery = criteriaBuilder.createQuery(Measure.class);
        Root<Measure> measure = criteriaQuery.from(Measure.class);
        criteriaQuery.select(measure);
        TypedQuery<Measure> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
