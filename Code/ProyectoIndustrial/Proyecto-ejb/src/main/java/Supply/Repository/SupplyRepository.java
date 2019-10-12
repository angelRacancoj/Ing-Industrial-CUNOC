
package Supply.Repository;

import Supply.Supply;
import static config.Constants.PERSISTENCE_UNIT_NAME;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Stateless
@LocalBean
public class SupplyRepository {

    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;

    public SupplyRepository() {
    
    }
     
    public Optional<Long> getNextCodeSupply(){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();  
        CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
        Root<Supply> root = criteriaQuery.from(Supply.class);

        //Selecting the count
        criteriaQuery.select(criteriaBuilder.count(root));
        return Optional.of(entityManager.createQuery(criteriaQuery).getSingleResult());
    }
    
        public Optional<List<Supply>> getSupply(Integer codeSupply, String nameSupply, boolean availabilitySupply, LocalDate expirationDateSupply){       
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Supply> criteriaQuery = criteriaBuilder.createQuery(Supply.class);
        Root<Supply> supply = criteriaQuery.from(Supply.class);
        Predicate codeSupplyPredicate = criteriaBuilder.like(supply.get("code"), "%" + codeSupply + "%");
        Predicate nameSupplyPredicate = criteriaBuilder.like(supply.get("name"), "%" + nameSupply + "%");
        Predicate availabilitySupplyPredicate = criteriaBuilder.equal(supply.get("availability"), availabilitySupply);
        Predicate expirationDateSupplyGreaterPredicate = criteriaBuilder.greaterThan(supply.get("expiration_date"), expirationDateSupply);
        Predicate expirationDateSupplyLessPredicate = criteriaBuilder.lessThanOrEqualTo(supply.get("expiration_date"), expirationDateSupply);
        criteriaQuery.where(codeSupplyPredicate, nameSupplyPredicate,availabilitySupplyPredicate);
        TypedQuery<Supply> query = entityManager.createQuery(criteriaQuery);
        return Optional.of(query.getResultList());
    }
}   