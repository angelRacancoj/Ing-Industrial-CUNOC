package Modify.service;

import Modify.ModificationType;
import Modify.ModifySupply;
import Supply.Supply;
import User.User;
import static config.Constants.PERSISTENCE_UNIT_NAME;
import java.util.Date;
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
public class ModifySupplyService {

    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;

    /**
     * The comment can be empty
     *
     * @param user
     * @param supply
     * @param modifyType
     * @param quantity
     * @param date
     * @param note
     */
    public void createModifySupply(User user, Supply supply, ModificationType modifyType, Integer quantity, Date date, String note) {

        if (!note.isEmpty()) {
            ModifySupply modifySupply = new ModifySupply(user, supply, modifyType, quantity, date, note);
            entityManager.persist(modifySupply);
        } else {
            ModifySupply modifySupply = new ModifySupply(user, supply, modifyType, quantity, date);
            entityManager.persist(modifySupply);
        }

    }
}
