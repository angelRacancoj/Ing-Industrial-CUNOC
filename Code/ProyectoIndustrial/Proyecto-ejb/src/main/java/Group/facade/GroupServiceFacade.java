package Group.facade;

import Group.Group;
import javax.ejb.Local;

/**
 *
 * @author angelrg
 */
@Local
public interface GroupServiceFacade {

    public Group createGroup(Group group);

    public Group updateGroup(Group group, String information, String section);

}
