/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Production.repository;

import Design.Design;
import static config.Constants.PERSISTENCE_UNIT_NAME;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author daniel
 */
@Stateless
@LocalBean
public class DesignRepository {

    public static final String QUERY_ALL_DESIGNS = "SELECT d FROM Design d";
    private EntityManager entityManager;

    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     *
     *
     * @return Lista con todos los diseños en la base de datos
     */
    public List<Design> AllDesigns() {

        TypedQuery<Design> typedQuery = entityManager.createQuery(QUERY_ALL_DESIGNS, Design.class);
        return typedQuery.getResultList();

    }

}
