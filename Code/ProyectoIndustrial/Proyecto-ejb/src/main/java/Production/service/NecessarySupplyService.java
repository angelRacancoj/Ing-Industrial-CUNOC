package Production.service;

import Production.Step;
import Production.NecessarySupply;
import Supply.Supply;
import static config.Constants.PERSISTENCE_UNIT_NAME;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class NecessarySupplyService {
    
    @PersistenceContext(name=PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;
    
    public void createNecessarySupply(Step step_id, Supply supply_code){ 
        NecessarySupply necessarySupply = new NecessarySupply(step_id, supply_code); 
        entityManager.persist(necessarySupply);
    }
    public void updateNecessarySupply(Integer idNecessarySupply,Step step_id, Supply supply_code){
        NecessarySupply necessarySupply = entityManager.find(NecessarySupply.class, idNecessarySupply);
        if(step_id!=null){
            necessarySupply.setStep(step_id);
        }
        if(supply_code!=null){
            necessarySupply.setSupplyCode(supply_code);
        }
        
        
    }
    
    
}
