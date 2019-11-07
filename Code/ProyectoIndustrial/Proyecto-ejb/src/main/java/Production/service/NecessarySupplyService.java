package Production.service;

import Production.NecessarySupply;
import Production.Step;
import Supply.Supply;
import Production.exceptions.MandatoryAttributeProductionException;
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
    
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    public NecessarySupply createNecessarySupply(NecessarySupply necessarySupply) throws MandatoryAttributeProductionException{
        if(necessarySupply==null){
            throw new MandatoryAttributeProductionException("Necessary Supply is null");
        }
        entityManager.persist(necessarySupply);
        return necessarySupply;
    }
    public NecessarySupply updateNecessarySupply(NecessarySupply necessarySupply, Step step, Supply supply) throws MandatoryAttributeProductionException{
        if(necessarySupply==null){
            throw new MandatoryAttributeProductionException("Necessary Supply is null");
        }
        NecessarySupply updateNecessarySupply = entityManager.find(NecessarySupply.class, necessarySupply.getIdNecessarySupply());
        if(step!=null){
            updateNecessarySupply.setStep(step);
        }
        if(supply!=null){
            updateNecessarySupply.setSupplyCode(supply);
        }
        return updateNecessarySupply;
    }
    
    
}
