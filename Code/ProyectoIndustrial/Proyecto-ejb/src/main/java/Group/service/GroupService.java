package Group.service;

import Group.Group;
import static config.Constants.PERSISTENCE_UNIT_NAME;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import Group.facade.GroupServiceFacade;

/**
 *
 * @author angelrg
 */
@Stateless
@LocalBean
public class GroupService implements GroupServiceFacade{

    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Group createGroup(Group group) {
        entityManager.persist(group);
        return group;
    }

    /**
     * To update just information or section, send the same text, if the text is
     * empty can't update the fill
     *
     * @param group
     * @param information
     * @param section
     * @return
     */
    @Override
    public Group updateGroup(Group group, String information, String section) {

        if ((information != null) && (!information.isEmpty())) {
            group.setInformation(information);
        }
        if ((section != null) && (!section.isEmpty())) {
            group.setSection(section);
        }

        return entityManager.merge(group);
    }
}
