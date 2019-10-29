/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Production.service;


import Production.Stage;
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
public class StageService {
    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;
    
        public void create(Stage stage) throws MandatoryAttributeProductionException {

        if (stage.getName() == null) {
            throw new MandatoryAttributeProductionException("Nombre nulo");
        }
        if (stage.getDescription()== null) {
            throw new MandatoryAttributeProductionException("Descropcion nula");
        }

        entityManager.persist(stage);
        entityManager.getTransaction().commit();

    }
    
     public void edit(Stage oldStage) throws MandatoryAttributeProductionException {
         
         //se setea antes o despues?
        if (oldStage.getName() == null) {
            throw new MandatoryAttributeProductionException("Nombre nulo");
        }
        if (oldStage.getDescription()== null) {
            throw new MandatoryAttributeProductionException("Descripcion nula");
        }
        

        entityManager.merge(oldStage);

    }
    
}
