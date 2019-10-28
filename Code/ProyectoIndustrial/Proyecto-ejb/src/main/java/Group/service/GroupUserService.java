package Group.service;

import Group.*;
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

public class GroupUserService {

    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;
    
    public void  createGroupUser(User user, Group group, Date admissionDate){
        GroupUser groupUser = new GroupUser(user, group, admissionDate);
        entityManager.persist(groupUser);
    }
    
    public void updateUserGroup(Integer groupId, Group group){
        GroupUser groupUser = entityManager.find(GroupUser.class, groupId);
        groupUser.setGroup(group);
    }
}
