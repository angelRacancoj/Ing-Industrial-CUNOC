/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Group.facade;

import User.User;
import Group.Group;
import Group.GroupUser;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author angelrg
 */
public interface GroupFacadelocal {

    /**
     * Create a new group, need a list of students to create the group
     *
     * @param group
     * @param users
     * @return
     */
    public Optional<Group> createGroup(Group group, List<User> users);

    /**
     * Add a User in a new Group, this method verify if this relationship
     * already exist
     *
     * @param group
     * @param users
     * @return
     */
    public Optional<GroupUser> assignUserToGroup(Group group, User users);

    /**
     * To update just information or section, send the same text, if the text is
     * empty can't update the fill
     *
     * @param group
     * @param information
     * @param section
     * @return
     */
    public Group updateGroup(Group group, String information, String section);

    /**
     * Change the group of an user, in the GroupUser element
     *
     * @param groupUser
     * @param group
     * @return
     */
    public GroupUser updateUserGroup(GroupUser groupUser, Group group);

    /**
     * This method remove a user from a group
     *
     * @param groupUser
     * @return
     */
    public Optional<GroupUser> removeUserFromGroup(GroupUser groupUser);

    /**
     * Find a Group base on its ID
     *
     * @param id
     * @return
     */
    public Optional<Group> findById(Integer id);

    /**
     * Return all groups stored in the system
     *
     * @return
     */
    public List<Group> getAll();

    /**
     * Find a GroupUser base on ID, this entity contain the relationship between
     * User and a Group
     *
     * @param id
     * @return
     */
    public Optional<GroupUser> findGroupUserById(Integer id);

    /**
     * Return the users that are in a Group, base on the ID
     *
     * @param groupId
     * @return
     */
    public List<User> findUsersByGroup(Integer groupId);

    /**
     * Return the Groups where the user were assigned
     *
     * @param carnet
     * @return
     */
    public List<Group> findGroupsOfUser(Integer carnet);

    /**
     * Return al relation between a group and user
     *
     * @param groupId
     * @param carnet
     * @return
     */
    public List<GroupUser> getGroupUserByUserAndGroup(Integer groupId, Integer carnet);

    /**
     * return all elements
     *
     * @return
     */
    public List<GroupUser> getAllGroupUser();

}
