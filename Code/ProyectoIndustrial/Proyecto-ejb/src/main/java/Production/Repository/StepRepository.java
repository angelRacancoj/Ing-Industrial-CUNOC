/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Production.Repository;

import Production.Production;
import Production.Stage;
import Production.Step;
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
public class StepRepository {

    //@PersistenceContext(name = config.Constants.PERSISTENCE_UNIT_NAME)
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

    public Optional<List<Step>> AllSteps() {

        String consult = "SELECT s FROM Step s";
        List<Step> steps = entityManager.createQuery(consult).getResultList();

        try {
            return Optional.of(steps);
        } catch (Exception e) {
            return Optional.empty();
        }

    }

    public Optional<List<Step>> findStepLikeName(String nameStep) {
        //Query query = entityManager.createQuery("");
        TypedQuery<Step> typedQuery = entityManager.createQuery("SELECT s FROM Step s WHERE s.name LIKE  " + nameStep, Step.class);
        //Production production = typedQuery.getSingleResult();
        try {
            return Optional.of(typedQuery.getResultList());
        } catch (Exception e) {
            return Optional.empty();
        }

    }

}
