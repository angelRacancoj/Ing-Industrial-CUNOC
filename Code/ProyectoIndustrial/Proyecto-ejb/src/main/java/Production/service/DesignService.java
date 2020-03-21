/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Production.service;

import Design.Design;
import Design.DesignData;
import Production.NecessarySupply;
import static config.Constants.PERSISTENCE_UNIT_NAME;
import java.util.List;
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
public class DesignService {
    private EntityManager entityManager;
    
    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Design createDesign(Design design, DesignData designData, List<NecessarySupply> necessarySupplys){
        
        
        design.setDesignData(designData);
        design.setNecessarySupplyList(necessarySupplys);
        
        entityManager.persist(design);
        return design;
    }
    
}
