
package Production.service;


import Production.Step;
import Production.exceptions.MandatoryAttributeProductionException;
import static config.Constants.*;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author daniel
 */
@Stateless
@LocalBean
public class StepService {
   private EntityManager entityManager;
    
    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
     public Step edit(Step oldStep) throws MandatoryAttributeProductionException {
         
         //se setea antes o despues?
        if (oldStep.getName() == null) {
            throw new MandatoryAttributeProductionException("Nombre nulo");
        }
        if (oldStep.getDescription()== null) {
            throw new MandatoryAttributeProductionException("Descripcion nula");
        }
        

        entityManager.merge(oldStep);
        return oldStep;
    }
    
    
}
