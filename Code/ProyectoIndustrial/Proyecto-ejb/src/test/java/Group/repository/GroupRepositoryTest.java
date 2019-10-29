/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Group.repository;

import Group.Group;
import static Group.repository.GroupRepository.FIND_BY_ID;
import static Group.repository.GroupRepository.GET_ALL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author angelrg
 */
public class GroupRepositoryTest {

    @Test
    public void findByIdWithResult() {
        // Arrange
        int groupId = 1;
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        TypedQuery<Group> typeQuery = Mockito.mock(TypedQuery.class);
        Mockito.when(
                entityManager.createQuery(FIND_BY_ID, Group.class)
        ).thenReturn(typeQuery);
        Mockito.when(
                typeQuery.setParameter("id", groupId)
        ).thenReturn(typeQuery);

        Group group = new Group();
        Mockito.when(typeQuery.getSingleResult()).thenReturn(group);

        GroupRepository groupRepository = new GroupRepository();
        groupRepository.setEntityManager(entityManager);

        // Act
        Optional<Group> result = groupRepository.findById(groupId);

        // Assert
        Assert.assertEquals(result.get(), group);
    }

    @Test
    public void findByIdWithNoResult() {
        // Arrange
        int groupId = 1;
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        TypedQuery<Group> typeQuery = Mockito.mock(TypedQuery.class);
        Mockito.when(
                entityManager.createQuery(FIND_BY_ID, Group.class)
        ).thenReturn(typeQuery);
        Mockito.when(
                typeQuery.setParameter("id", groupId)
        ).thenReturn(typeQuery);
        
        Mockito.when(typeQuery.getSingleResult()).thenThrow(new NoResultException());

        GroupRepository groupRepository = new GroupRepository();
        groupRepository.setEntityManager(entityManager);

        // Act
        Optional<Group> result = groupRepository.findById(groupId);

        // Assert
        Assert.assertFalse(result.isPresent(), "Expected optional empty");
    }
    
    @Test
    public void getAllWithResult(){
        // Arrange
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        TypedQuery<Group> typedQuery = Mockito.mock(TypedQuery.class);
        Mockito.when(
                entityManager.createQuery(GET_ALL, Group.class)
        ).thenReturn(typedQuery);
        List<Group> list = new ArrayList<Group>();
        Group group = new Group();
        list.add(group);
        Mockito.when(typedQuery.getResultList()).thenReturn(list);
        
        GroupRepository groupRepository = new GroupRepository();
        groupRepository.setEntityManager(entityManager);
        
        // Act
        List<Group> result = groupRepository.getAll();
        
        // Assert
        Assert.assertEquals(result, list);
    }
    
    @Test
    public void getAllEmptyResult(){
        // Arrange
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        TypedQuery<Group> typedQuery = Mockito.mock(TypedQuery.class);
        Mockito.when(
                entityManager.createQuery(GET_ALL, Group.class)
        ).thenReturn(typedQuery);
        List<Group> list = new ArrayList<Group>();
        Mockito.when(typedQuery.getResultList()).thenReturn(list);
        
        GroupRepository groupRepository = new GroupRepository();
        groupRepository.setEntityManager(entityManager);
        
        // Act
        List<Group> result = groupRepository.getAll();
        
        // Assert
        Assert.assertEquals(result, list);
    }
}
