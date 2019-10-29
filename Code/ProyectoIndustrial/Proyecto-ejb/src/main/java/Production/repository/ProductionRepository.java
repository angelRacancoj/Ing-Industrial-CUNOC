package Production.repository;

import Production.Production;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import static config.Constants.*;

/**
 *
 * @author daniel
 */
@Stateless
@LocalBean
public class ProductionRepository {

    private EntityManager entityManager;
    public static final String QUERY_FIND_BY_ID = "SELECT p FROM Production p WHERE p.idProduction  = ?";
    public static final String QUERY_ALL_PRODUCTIONS = "SELECT p FROM Production p";
    public static final String QUERY_LIKE_PRODUCTIONS = "SELECT p FROM Production p WHERE p.name  LIKE ?";

    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * fecha de creacion de la produccion reacion entre comentario y paso
     */
    /**
     * Busca una produccion por el id si no encruenta nada devulve un Optional
     * vacio
     *
     * @param idProduction
     * @return Production
     */
    public Optional<Production> findByIdProduction(int idProduction) {

        TypedQuery<Production> typedQuery = entityManager.createQuery(QUERY_FIND_BY_ID, Production.class)
                .setParameter(1, idProduction);

        try {
            return Optional.of(typedQuery.getSingleResult());
        } catch (Exception e) {
            return Optional.empty();
        }

    }

    public List<Production> AllProductions() {

        TypedQuery<Production> typedQuery = entityManager.createQuery(QUERY_ALL_PRODUCTIONS, Production.class);
        return typedQuery.getResultList();

    }

    public List<Production> findProductionLikeName(String nameProduction) {

        TypedQuery<Production> typedQuery = entityManager.createQuery(QUERY_LIKE_PRODUCTIONS, Production.class)
                .setParameter(1, nameProduction);

        return typedQuery.getResultList();

    }

}
