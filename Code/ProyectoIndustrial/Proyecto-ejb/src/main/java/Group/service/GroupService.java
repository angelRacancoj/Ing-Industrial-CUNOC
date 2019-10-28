package Group.service;

import Group.Group;
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
public class GroupService {

    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;

    public void createGroup(String information, String section) {
        Group group = new Group(information, section);
        entityManager.persist(group);
    }

    /**
     * To update just information or section, send the same text, if the text is
     * empty can't update the fill
     *
     * @param idGroup
     * @param information
     * @param section
     */
    public void updateGroup(Integer idGroup, String information, String section) {
        Group group = entityManager.find(Group.class, idGroup);
        if (!information.isEmpty() && !group.getInformation().equalsIgnoreCase(information)) {
            group.setInformation(information);
        }
        if (!section.isEmpty() && !group.getSection().equalsIgnoreCase(section)) {
            group.setSection(section);
        }
    }
}
