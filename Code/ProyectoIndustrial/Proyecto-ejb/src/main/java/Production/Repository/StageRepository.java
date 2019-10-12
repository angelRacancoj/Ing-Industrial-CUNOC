package Production.Repository;

import Production.Stage;
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
public class StageRepository {

    @PersistenceContext(name = config.Constants.PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;

    /**
     * Busca una Stage por el id si no encuentra nada devulve un Optional
     * vacio
     *
     * @param idStage
     * @return Production
     */
    public Optional<Stage> findByIdStage(String idStage) {

        TypedQuery<Stage> typedQuery = entityManager.createQuery("SELECT s FROM Stage s WHERE s.idStage = " + idStage, Stage.class);
        try {
            return Optional.of(typedQuery.getSingleResult());
        } catch (Exception e) {
            return Optional.empty();
        }

    }

    public List<Stage> AllStages() {

        String consult = "SELECT s FROM Stage s";
        List<Stage> stages = entityManager.createQuery(consult).getResultList();

        
            return stages;
        

    }

    public List<Stage> findStageLikeName(String nameStage) {
        
        TypedQuery<Stage> typedQuery = entityManager.createQuery("SELECT s FROM Stage s WHERE s.name  LIKE  " + nameStage, Stage.class);
           
            return typedQuery.getResultList();
    

    }

}
