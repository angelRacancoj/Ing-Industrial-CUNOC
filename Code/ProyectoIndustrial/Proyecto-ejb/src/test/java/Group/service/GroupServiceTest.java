package Group.service;

import Group.Group;
import javax.persistence.EntityManager;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author angelrg
 */
public class GroupServiceTest {
    
    @Test
    public void createGroupTest(){
        // Arrange
        Group group = new Group();
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        
        Mockito.doNothing().when(entityManager).persist(group);
                
        GroupService groupService = new GroupService();
        groupService.setEntityManager(entityManager);
        
        // Act
        Group result = groupService.createGroup(group);
        
        // Assert
        Assert.assertEquals(result, group);
    }
    
    @Test
    public void updateGroupInformationTest(){
        // Arrange
        String informacion = "hola mundo";
        String section = null;
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        Group group = Mockito.mock(Group.class);
        
        Mockito.when(
                entityManager.merge(group)
        ).thenReturn(group);
        
        GroupService groupService = new GroupService();
        groupService.setEntityManager(entityManager);
        
        // Act
        Group result = groupService.updateGroup(group, informacion, section);
        
        //Assert
        Assert.assertEquals(result, group);
        
    }
    
    @Test
    public void updateGroupSectionTest(){
        // Arrange
        String informacion = null;
        String section = "a";
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        Group group = Mockito.mock(Group.class);
        
        Mockito.when(
                entityManager.merge(group)
        ).thenReturn(group);
        
        GroupService groupService = new GroupService();
        groupService.setEntityManager(entityManager);
        
        // Act
        Group result = groupService.updateGroup(group, informacion, section);
        
        //Assert
        Assert.assertEquals(result, group);
        
    }
    
    @Test
    public void updateGroupSectionAndInformationTest(){
        // Arrange
        String informacion = "hola mundo";
        String section = "a";
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        Group group = Mockito.mock(Group.class);
        
        Mockito.when(
                entityManager.merge(group)
        ).thenReturn(group);
        
        GroupService groupService = new GroupService();
        groupService.setEntityManager(entityManager);
        
        // Act
        Group result = groupService.updateGroup(group, informacion, section);
        
        //Assert
        Assert.assertEquals(result, group);
        
    }
}
