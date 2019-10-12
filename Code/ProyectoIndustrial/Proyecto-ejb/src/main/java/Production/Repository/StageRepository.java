/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Production.Repository;

import Production.Production;
import Production.Stage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import config.Constants;
import java.util.List;
import java.util.Optional;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author daniel
 */
public class StageRepository {

    //@PersistenceContext(name = config.Constants.PERSISTENCE_UNIT_NAME)
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

    public Optional<List<Stage>> AllStages() {

        String consult = "SELECT s FROM Stage s";
        List<Stage> stages = entityManager.createQuery(consult).getResultList();

        try {
            return Optional.of(stages);
        } catch (Exception e) {
            return Optional.empty();
        }

    }

    public Optional<List<Stage>> findStageLikeName(String nameStage) {
        //Query query = entityManager.createQuery("");
        TypedQuery<Stage> typedQuery = entityManager.createQuery("SELECT s FROM Stage s WHERE s.name  LIKE  " + nameStage, Stage.class);
        //Production production = typedQuery.getSingleResult();
        try {
            return Optional.of(typedQuery.getResultList());
        } catch (Exception e) {
            return Optional.empty();
        }

    }

}
