package Produce.repository;

import Produce.History;
import Produce.facade.HistoryRepositoryFacade;
import java.util.List;
import java.util.Optional;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import static config.Constants.PERSISTENCE_UNIT_NAME;

/**
 *
 * @author angelrg
 */
@Stateless
@LocalBean
public class HistoryRespository implements HistoryRepositoryFacade {

    public static final String GET_ALL = "SELECT h FROM History h";

    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<History> findById(int id) {
        return Optional.of(entityManager.find(History.class, id));
    }

    @Override
    public List<History> getAll() {
        Query query = entityManager.createQuery(GET_ALL);
        return query.getResultList();
    }

}
