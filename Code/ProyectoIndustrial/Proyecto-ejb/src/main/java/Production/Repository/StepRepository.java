package Production.Repository;

import Production.Step;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

/**
 *
 * @author daniel
 */
@Stateless
@LocalBean
public class StepRepository {

    @PersistenceContext(name = config.Constants.PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;

    /**
     * Busca un Step por el id si no encuentra nada devulve un Optional
     * vacio
     *
     * @param idStep
     * @return Step
     */
    public Optional<Step> findByIdStep(String idStep) {

        TypedQuery<Step> typedQuery = entityManager.createQuery("SELECT s FROM Step s WHERE s.idStep = " + idStep, Step.class);
        try {
            return Optional.of(typedQuery.getSingleResult());
        } catch (Exception e) {
            return Optional.empty();
        }

    }

    public List<Step> AllSteps() {

        String consult = "SELECT s FROM Step s";
        List<Step> steps = entityManager.createQuery(consult).getResultList();

        
            return steps;
       

    }

    public List<Step> findStepLikeName(String nameStep) {
        
        TypedQuery<Step> typedQuery = entityManager.createQuery("SELECT s FROM Step s WHERE s.name LIKE  " + nameStep, Step.class);
        
        return typedQuery.getResultList();
        

    }

}
