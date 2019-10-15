package Group.Services;

import Group.*;
import User.User;
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

public class GroupUserService {

    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;
    
    
//    public void create(GroupUser groupUser) throws Exception {
//        EntityManager em = null;
//        try {
//            em.getTransaction().begin();
//            Group groupId = groupUser.getGroup();
//            if (groupId != null) {
//                groupId = em.getReference(groupId.getClass(), groupId.getIdGroup());
//                groupUser.setGroup(groupId);
//            }
//            User userCarnet = groupUser.getUser();
//            if (userCarnet != null) {
//                userCarnet = em.getReference(userCarnet.getClass(), userCarnet.getCarnet());
//                groupUser.setUserCarnet(userCarnet);
//            }
//            em.persist(groupUser);
//            if (groupId != null) {
//                groupId.getGroupUserCollection().add(groupUser);
//                groupId = em.merge(groupId);
//            }
//            if (userCarnet != null) {
//                userCarnet.getGroupUserCollection().add(groupUser);
//                userCarnet = em.merge(userCarnet);
//            }
//            em.getTransaction().commit();
//        } catch (Exception ex) {
//            if (findGroupUser(groupUser.getIdGruopUser()) != null) {
//                //throw new PreexistingEntityException("GroupUser " + groupUser + " already exists.", ex);
//            }
//            throw ex;
//        } finally {
//            if (em != null) {
//                em.close();
//            }
//        }
//    }
}
