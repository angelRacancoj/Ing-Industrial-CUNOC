/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.usac.cunoc.ingenieria.production.group.view;

/**
 *
 * @author daniel
 */

import Group.GroupIndustrial;
import Group.facade.GroupFacadelocal;
import Production.facade.ProductionFacadeLocal;
import User.User;
import User.exception.UserException;
import User.facade.UserFacadeLocal;
import gt.edu.usac.cunoc.ingenieria.utils.MessageUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class groupView implements Serializable{
    private static final String GROUP_CREATED = "Grupo Creado";
    private List<User> allStudents;
    private List<User> groupList;
    private List<GroupIndustrial> groupsList;
    
    private GroupIndustrial groupIndustrial;
    
    //TODO file up bloob, clase de journal
    
    @EJB
    private GroupFacadelocal groupFacadelocal;
    
    @EJB
    private ProductionFacadeLocal productionFacadeLocal;

    @EJB
    private UserFacadeLocal userFacadeLocal;

    
    @PostConstruct
    public void init() {
        try {
            allStudents = userFacadeLocal.getUserEstudent();
            groupList = new ArrayList<>();
            
            groupsList = groupFacadelocal.getAll();
            
        } catch (UserException ex) {
            Logger.getLogger(groupView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void AddStudent(User user) {
        groupList.add(user);
        allStudents.remove(user);
    }
    
    public void createGroup(){
        try {
            //groupIndustrial.setIdGroup(null);
           groupFacadelocal.createGroup(groupIndustrial, groupList);
           MessageUtils.addSuccessMessage(GROUP_CREATED);
        } catch (Exception e) {
            MessageUtils.addErrorMessage(e.getMessage());
        }
        
    }
    
    public void editGroup(GroupIndustrial groupIndustrial){
        groupFacadelocal.updateGroup(groupIndustrial, "inf", "A");
    }
    public void selection(GroupIndustrial groupSelected){
        groupIndustrial = groupSelected;
    }
    
    public List<User> getAllStudents() {
        return allStudents;
    }

    public void setAllStudents(List<User> allStudents) {
        this.allStudents = allStudents;
    }

    public List<User> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<User> groupList) {
        this.groupList = groupList;
    }

    public GroupIndustrial getGroupIndustrial() {
       if(groupIndustrial == null){
           groupIndustrial = new GroupIndustrial(null);
       }
        return groupIndustrial;
    }

    public void setGroupIndustrial(GroupIndustrial groupIndustrial) {
        this.groupIndustrial = groupIndustrial;
    }

    public List<GroupIndustrial> getGroupsList() {
        return groupsList;
    }

    public void setGroupsList(List<GroupIndustrial> groupsList) {
        this.groupsList = groupsList;
    }
    
    
  

   
    
    
    
    
    
    
}
