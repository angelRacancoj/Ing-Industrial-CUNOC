/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;

    public void create(Production production) throws MandatoryAttributeProductionException {

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
        entityManager.getTransaction().commit();

    }
    
     public void edit(Production oldProduction) throws MandatoryAttributeProductionException {
         
         
        if (oldProduction.getName() == null) {
            throw new MandatoryAttributeProductionException("Nombre nulo");
        }
        if (oldProduction.getUnity() == 0) {
            throw new MandatoryAttributeProductionException("Unidad por lote nulo");

        }
        if (oldProduction.getCreationDate() == null) {
            throw new MandatoryAttributeProductionException("Fecha de creacion nula");
        }
        if (oldProduction.getProductId() == null) {
            throw new MandatoryAttributeProductionException("Producto nulo");
        }
        
        entityManager.merge(oldProduction);
        

    }

}
