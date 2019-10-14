package Group.Services;

import Group.GroupUser;
import Group.Group;
import Produce.History;
import static config.Constants.PERSISTENCE_UNIT_NAME;
import java.util.ArrayList;
import java.util.Collection;
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
public class GroupService {
    
    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;
    
    
    public void create(Group group) {
        if (group.getHistoryCollection() == null) {
            group.setHistoryCollection(new ArrayList<History>());
        }
        if (group.getGroupUserCollection() == null) {
            group.setGroupUserCollection(new ArrayList<GroupUser>());
        }
        
        try {
            entityManager.getTransaction().begin();
            Collection<History> attachedHistoryCollection = new ArrayList<History>();
            for (History historyCollectionHistoryToAttach : group.getHistoryCollection()) {
                historyCollectionHistoryToAttach = entityManager.getReference(historyCollectionHistoryToAttach.getClass(), historyCollectionHistoryToAttach.getHistory_id());
                attachedHistoryCollection.add(historyCollectionHistoryToAttach);
            }
            group.setHistoryCollection(attachedHistoryCollection);
            Collection<GroupUser> attachedGroupUserCollection = new ArrayList<GroupUser>();
            for (GroupUser groupUserCollectionGroupUserToAttach : group.getGroupUserCollection()) {
                groupUserCollectionGroupUserToAttach = entityManager.getReference(groupUserCollectionGroupUserToAttach.getClass(), groupUserCollectionGroupUserToAttach.getidGroupUser());
                attachedGroupUserCollection.add(groupUserCollectionGroupUserToAttach);
            }
            group.setGroupUserCollection(attachedGroupUserCollection);
            entityManager.persist(group);
            for (History historyCollectionHistory : group.getHistoryCollection()) {
                Group oldGroupIdOfHistoryCollectionHistory = historyCollectionHistory.getGroup();
                historyCollectionHistory.setGroup(group);
                historyCollectionHistory = entityManager.merge(historyCollectionHistory);
                if (oldGroupIdOfHistoryCollectionHistory != null) {
                    oldGroupIdOfHistoryCollectionHistory.getHistoryCollection().remove(historyCollectionHistory);
                    oldGroupIdOfHistoryCollectionHistory = entityManager.merge(oldGroupIdOfHistoryCollectionHistory);
                }
            }
            for (GroupUser groupUserCollectionGroupUser : group.getGroupUserCollection()) {
                Group oldGroupIdOfGroupUserCollectionGroupUser = groupUserCollectionGroupUser.getGroup();
                groupUserCollectionGroupUser.setGroup(group);
                groupUserCollectionGroupUser = entityManager.merge(groupUserCollectionGroupUser);
                if (oldGroupIdOfGroupUserCollectionGroupUser != null) {
                    oldGroupIdOfGroupUserCollectionGroupUser.getGroupUserCollection().remove(groupUserCollectionGroupUser);
                    oldGroupIdOfGroupUserCollectionGroupUser = entityManager.merge(oldGroupIdOfGroupUserCollectionGroupUser);
                }
            }
            entityManager.getTransaction().commit();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
}
