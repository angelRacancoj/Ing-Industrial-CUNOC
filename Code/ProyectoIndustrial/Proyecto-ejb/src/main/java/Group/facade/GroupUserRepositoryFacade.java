/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Group.facade;

import Group.GroupUser;
import java.util.List;
import java.util.Optional;
import javax.ejb.Local;

/**
 *
 * @author angelrg
 */
@Local
public interface GroupUserRepositoryFacade {

    public Optional<GroupUser> findById(Integer id);

    public List<GroupUser> getAll();
}
