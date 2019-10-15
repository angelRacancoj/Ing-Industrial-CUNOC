package Group.repository;

import Group.GroupUser;
import Group.Group;
import User.User;
import static config.Constants.PERSISTENCE_UNIT_NAME;
import java.util.List;
import java.util.Optional;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author angelrg
 */
@Stateless
@LocalBean
public class GroupUserRepository {

    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;

    public Optional<GroupUser> findById(Integer id) {
        return Optional.of(entityManager.find(GroupUser.class, id));
    }

    public List<User> findUsersByGroup(Integer groupId) {
        Query query = entityManager.createQuery("SELECT u FROM GroupUser g, User u WHERE g.group.idGroup = :groupId AND g.user.carnet = u.carnet");
        query.setParameter("groupId", groupId);
        return query.getResultList();
    }

    public List<Group> findGroupsOfUser(Integer carnet) {
        Query query = entityManager.createQuery("SELECT gu FROM GroupUser gu, Group g WHERE gu.user.carnet = :carnet AND gu.group.idGroup = g.idGroup");
        query.setParameter("carnet", carnet);
        return query.getResultList();
    }

    public List<GroupUser> getAll() {
        CriteriaQuery criteriaQuery = entityManager.getCriteriaBuilder().createQuery();
        criteriaQuery.select(criteriaQuery.from(GroupUser.class));

        Query query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
