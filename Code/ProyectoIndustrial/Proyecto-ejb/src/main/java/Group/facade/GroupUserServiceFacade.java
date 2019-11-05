/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Group.facade;

import Group.GroupUser;
import javax.ejb.Local;

/**
 *
 * @author angelrg
 */
@Local
public interface GroupUserServiceFacade {

    public GroupUser createGroupUser(GroupUser groupUser);
}
