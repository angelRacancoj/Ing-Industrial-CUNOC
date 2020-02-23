
package Production.service;

import Production.Production;
import Production.exceptions.MandatoryAttributeProductionException;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import  static config.Constants.*;

/**
 *
 * @author daniel
 */
@Stateless
@LocalBean
public class ProductionService {

    
    private EntityManager entityManager;
    
    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Production create(Production production) throws MandatoryAttributeProductionException {

        if (production.getName() == null) {
            throw new MandatoryAttributeProductionException("Nombre nulo");
        }
        
        if (production.getStartDate() == null) {
            throw new MandatoryAttributeProductionException("Fecha de creacion nula");
        }
        

        entityManager.persist(production);
        return production;
    }
    
     public Production edit(Production Production) throws MandatoryAttributeProductionException {
         
         
        if (Production.getName() == null) {
            throw new MandatoryAttributeProductionException("Nombre nulo");
        }
        
        if (Production.getStartDate() == null) {
            throw new MandatoryAttributeProductionException("Fecha de creacion nula");
        }
        
        
        entityManager.merge(Production);
        
        return Production;
    }

}
