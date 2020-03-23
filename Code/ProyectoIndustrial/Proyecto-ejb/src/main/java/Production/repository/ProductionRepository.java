package Production.repository;

import Production.Product;
import Production.Production;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import static config.Constants.*;
import java.util.ArrayList;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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
        return Optional.of(entityManager.find(Production.class, idProduction));
    }
//    public Optional<Production> findByIdProduction(int idProduction) {
//
//        TypedQuery<Production> typedQuery = entityManager.createQuery(QUERY_FIND_BY_ID, Production.class)
//                .setParameter(1, idProduction);
//
//        try {
//            return Optional.of(typedQuery.getSingleResult());
//        } catch (Exception e) {
//            return Optional.empty();
//        }
//
//    }

    public List<Production> AllProductions() {

        TypedQuery<Production> typedQuery = entityManager.createQuery(QUERY_ALL_PRODUCTIONS, Production.class);
        return typedQuery.getResultList();

    }

    public List<Production> findProductionLikeName(String nameProduction) {

        TypedQuery<Production> typedQuery = entityManager.createQuery(QUERY_LIKE_PRODUCTIONS, Production.class)
                .setParameter(1, nameProduction);

        return typedQuery.getResultList();

    }

    /**
     * To get all results just set all with null
     *
     * @param idProduction
     * @param name
     * @return
     */
    public List<Production> findProduction(Integer idProduction, String name) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Production> criteriaQuery = criteriaBuilder.createQuery(Production.class);
        Root<Production> production = criteriaQuery.from(Production.class);
        ArrayList<Predicate> predicates = new ArrayList<>();

        if (idProduction != null) {
            predicates.add(criteriaBuilder.like(production.get("idProduction"), "%" + idProduction + "%"));
        }

        if (name != null) {
            predicates.add(criteriaBuilder.like(production.get("name"), "%" + name + "%"));
        }

        criteriaQuery.where(predicates.stream().toArray(Predicate[]::new));
        TypedQuery<Production> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

}
