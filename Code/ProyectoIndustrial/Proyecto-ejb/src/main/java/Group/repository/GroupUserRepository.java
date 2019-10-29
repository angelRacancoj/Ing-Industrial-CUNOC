package Group.repository;

import Group.GroupUser;
import Group.Group;
import User.User;
import java.util.List;
import java.util.Optional;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import static config.Constants.PERSISTENCE_UNIT_NAME;

/**
 *
 * @author angelrg
 */
@Stateless
@LocalBean
public class GroupUserRepository {
    
    public static final String FIND_USERS_BY_GROUP = "SELECT u FROM GroupUser g, User u WHERE g.group.idGroup = :groupId AND g.user.carnet = u.carnet";
    public static final String FIND_GROUP_OF_USERS = "SELECT u FROM GroupUser g, User u WHERE g.group.idGroup = :groupId AND g.user.carnet = u.carnet";
    public static final String GET_ALL_GROUP_USERS = "SELECT gu FROM GroupUser gu";
    public static final String GROUP_PARAMETER_NAME = "groupId";
    public static final String CARNET_PARAMETER_NAME = "carnet";
    
    
    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Optional<GroupUser> findById(Integer id) {
        return Optional.of(entityManager.find(GroupUser.class, id));
    }

    public List<User> findUsersByGroup(Integer groupId) {
        Query query = entityManager.createQuery(FIND_USERS_BY_GROUP);
        query.setParameter(GROUP_PARAMETER_NAME, groupId);
        return query.getResultList();
    }

    public List<Group> findGroupsOfUser(Integer carnet) {
        Query query = entityManager.createQuery(FIND_GROUP_OF_USERS);
        query.setParameter(CARNET_PARAMETER_NAME, carnet);
        return query.getResultList();
    }

    public List<GroupUser> getAll() {
        Query query = entityManager.createQuery(GET_ALL_GROUP_USERS);
        return query.getResultList();
    }
}
