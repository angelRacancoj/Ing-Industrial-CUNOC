package Production.repository;

import Production.Production;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

/**
 *
 * @author daniel
 */
@Stateless
@LocalBean
public class ProductionRepository {
    @PersistenceContext(name = config.Constants.PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;
    
    
    /**
     * fecha de creacion de la produccion
     * reacion entre comentario y paso
     */
    
    /**
     * Busca una produccion por el id  si no encruenta nada devulve un Optional vacio
     * 
     * @param idProduction
     * @return Production
     */
    public Optional<Production> findByIdProduction(String idProduction){
        //Query query = entityManager.createQuery("");
        TypedQuery <Production> typedQuery = entityManager.createQuery("SELECT p FROM Production p WHERE p.idProduction  = "+idProduction , Production.class);
        //Production production = typedQuery.getSingleResult();
        try {
            return Optional.of(typedQuery.getSingleResult());
        } catch (Exception e) {
            return Optional.empty();
        }
        
    }
    
    public List<Production> AllProductions(){
        
        String consult = "SELECT p FROM Production p";
        List<Production> productions = entityManager.createQuery(consult).getResultList();
        
        return productions;
        
    }
    
    public List<Production> findProductionLikeName(String nameProduction){
        
        TypedQuery <Production> typedQuery = entityManager.createQuery("SELECT p FROM Production p WHERE p.name  LIKE  " + nameProduction , Production.class);
        
        
            return typedQuery.getResultList();
        
        
    }
    
    
            
    
}
