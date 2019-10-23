package Modify.repository;

import Modify.ModifySupply;
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
public class ModifySupplyRepository {
    
    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;
    
    public Optional<ModifySupply> getById(Integer id){
        return Optional.of(entityManager.find(ModifySupply.class, id));
    }
    
    public List<ModifySupply> getModificationByUser(Integer id){
        Query query = entityManager.createQuery("SELECT ms FROM ModifySupply ms WHERE ms.user.carnet = :id");
        query.setParameter("id", id);
        return query.getResultList();
    }
    
    public List<ModifySupply> getModificationBySupply(Integer id){
        Query query = entityManager.createQuery("SELECT ms FROM ModifySupply ms WHERE ms.supply.code = :id");
        query.setParameter("id", id);
        return query.getResultList();
    }
    
    public List<ModifySupply> getAll(){
        CriteriaQuery criteriaQuery = entityManager.getCriteriaBuilder().createQuery();
        criteriaQuery.select(criteriaQuery.from(ModifySupply.class));
        
        Query query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
    
}
