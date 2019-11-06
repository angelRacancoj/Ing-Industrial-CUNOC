
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
        if (production.getUnity() == 0) {
            throw new MandatoryAttributeProductionException("Unidad por lote nulo");

        }
        if (production.getCreationDate() == null) {
            throw new MandatoryAttributeProductionException("Fecha de creacion nula");
        }
        if (production.getProductId() == null) {
            throw new MandatoryAttributeProductionException("Producto nulo");
        }

        entityManager.persist(production);
        return production;
    }
    
     public Production edit(Production Production) throws MandatoryAttributeProductionException {
         
         
        if (Production.getName() == null) {
            throw new MandatoryAttributeProductionException("Nombre nulo");
        }
        if (Production.getUnity() == 0) {
            throw new MandatoryAttributeProductionException("Unidad por lote nulo");

        }
        if (Production.getCreationDate() == null) {
            throw new MandatoryAttributeProductionException("Fecha de creacion nula");
        }
        if (Production.getProductId() == null) {
            throw new MandatoryAttributeProductionException("Producto nulo");
        }
        
        entityManager.merge(Production);
        
        return Production;
    }

}
