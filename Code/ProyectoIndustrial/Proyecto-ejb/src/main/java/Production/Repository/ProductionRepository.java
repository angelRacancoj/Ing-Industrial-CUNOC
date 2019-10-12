/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Production.Repository;

import Production.Production;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import config.Constants;
import java.util.List;
import java.util.Optional;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author daniel
 */
public class ProductionRepository {
    //@PersistenceContext(name = config.Constants.PERSISTENCE_UNIT_NAME)
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
    
    public Optional<List<Production>> AllProductions(){
        
        String consult = "SELECT p FROM Production p";
        List<Production> productions = entityManager.createQuery(consult).getResultList();
        
        try {
            return Optional.of(productions);
        } catch (Exception e) {
            return Optional.empty();
        }
        
    }
    
    public Optional<List<Production>> findProductionLikeName(String nameProduction){
        //Query query = entityManager.createQuery("");
        TypedQuery <Production> typedQuery = entityManager.createQuery("SELECT p FROM Production p WHERE p.name  LIKE  " + nameProduction , Production.class);
        //Production production = typedQuery.getSingleResult();
        try {
            return Optional.of(typedQuery.getResultList());
        } catch (Exception e) {
            return Optional.empty();
        }
        
    }
    
    
            
    
}
