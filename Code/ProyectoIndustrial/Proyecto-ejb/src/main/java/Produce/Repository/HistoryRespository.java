package Produce.Repository;

import static config.Constants.PERSISTENCE_UNIT_NAME;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author angelrg
 */
@Stateless
@LocalBean
public class HistoryRespository {

    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;

    
    
}
