/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;
    
    
    public void create(Step step) throws MandatoryAttributeProductionException {

        if (step.getName() == null) {
            throw new MandatoryAttributeProductionException("Nombre nulo");
        }
        if (step.getDescription()== null) {
            throw new MandatoryAttributeProductionException("Descropcion nula");
        }

        entityManager.persist(step);
        entityManager.getTransaction().commit();

    }
    
     public void edit(Step oldStep) throws MandatoryAttributeProductionException {
         
         //se setea antes o despues?
        if (oldStep.getName() == null) {
            throw new MandatoryAttributeProductionException("Nombre nulo");
        }
        if (oldStep.getDescription()== null) {
            throw new MandatoryAttributeProductionException("Descripcion nula");
        }
        

        entityManager.merge(oldStep);

    }
    
    
}
