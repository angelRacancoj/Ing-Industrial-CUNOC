package Produce.repository;

import Produce.History;
import static config.Constants.PERSISTENCE_UNIT_NAME;
import java.util.List;
import java.util.Optional;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author angelrg
 */
@Stateless
@LocalBean
public class HistoryRespository {

    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;

    public Optional<History> findById(int id) {
        return Optional.of(entityManager.find(History.class, id));
    }

    public List<History> getAll() {
        CriteriaQuery criteriaQuery = entityManager.getCriteriaBuilder().createQuery();
        criteriaQuery.select(criteriaQuery.from(History.class));

        Query query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

}
