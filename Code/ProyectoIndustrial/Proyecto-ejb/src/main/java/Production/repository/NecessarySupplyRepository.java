package Production.repository;

import Production.NecessarySupply;
import Supply.Supply;
import static config.Constants.PERSISTENCE_UNIT_NAME;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
public class NecessarySupplyRepository {
    
    
    
    
    
    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;

    public NecessarySupplyRepository() {
    }

    public List<NecessarySupply> getNecessarySupply(Integer codeStep){       
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<NecessarySupply> criteriaQuery = criteriaBuilder.createQuery(NecessarySupply.class);
        Root<NecessarySupply> necessarySupply = criteriaQuery.from(NecessarySupply.class);
        ArrayList<Predicate> predicates = new ArrayList<>();

        if (codeStep != null){
            predicates.add(criteriaBuilder.like(necessarySupply.get("code"), "%" + codeStep + "%"));
        }

        criteriaQuery.where((Predicate[]) predicates.toArray());
        TypedQuery<NecessarySupply> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
    
    
    
    
    
    
    
}
