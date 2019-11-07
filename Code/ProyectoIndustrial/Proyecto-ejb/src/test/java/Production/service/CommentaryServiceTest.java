package Production.service;

import Production.Commentary;
import Production.exceptions.MandatoryAttributeProductionException;
import javax.persistence.EntityManager;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CommentaryServiceTest {
    
    
    @Test
    public void createCommentaryTest() throws MandatoryAttributeProductionException{
        // Arrange
        Commentary commentary = new Commentary();
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        
        Mockito.doNothing().when(entityManager).persist(commentary);
                
        CommentaryService commentaryService = new CommentaryService();
        commentaryService.setEntityManager(entityManager);
        
        // Act
        Commentary result = commentaryService.createCommentary(commentary);
        
        // Assert
        Assert.assertEquals(result, commentary);
    }
    
    
    @Test
    public void updateCommentaryStageIdTest() throws MandatoryAttributeProductionException{
        // Arrange
        String text = null;
        Integer stage = 1;
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        Commentary commentary = Mockito.mock(Commentary.class);
        
        Mockito.when(
                entityManager.merge(commentary)
        ).thenReturn(commentary);
        
        CommentaryService commentaryService = new CommentaryService();
        commentaryService.setEntityManager(entityManager);
        
        // Act
        Commentary result = commentaryService.updateCommentary(commentary, text, stage);
        
        //Assert
        Assert.assertEquals(result, commentary);
        
    }
    
    
    @Test
    public void updateCommentaryTextTest() throws MandatoryAttributeProductionException{
        // Arrange
        String text = "a";
        Integer stage = null;
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        Commentary commentary = Mockito.mock(Commentary.class);
        
        Mockito.when(
                entityManager.merge(commentary)
        ).thenReturn(commentary);
        
        CommentaryService commentaryService = new CommentaryService();
        commentaryService.setEntityManager(entityManager);
        
        // Act
        Commentary result = commentaryService.updateCommentary(commentary, text, stage);
        
        //Assert
        Assert.assertEquals(result, commentary);
        
    }
    
}
