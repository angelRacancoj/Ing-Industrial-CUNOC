package Production.repository;


import static Produce.repository.HistoryRespository.GET_ALL;
import Production.Commentary;
import static Production.repository.CommentaryRepository.FIND_BY_STAGE_ID;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CommentaryRepositoryTest {
    
    
    @Test
    public void getCommentaryByIdResult() {
        // Arrange
        int id = 1;
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        Commentary commentary = new Commentary();
        Mockito.when(
                entityManager.find(Commentary.class, id)
        ).thenReturn(commentary);
        CommentaryRepository commentaryRepository = new CommentaryRepository();
        commentaryRepository.setEntityManager(entityManager);

        // Act
        Optional<Commentary> result = commentaryRepository.getCommentaryById(id);

        // Assert
        Assert.assertEquals(result.get(), commentary);
    }
    
    public void getCommentaryByStageTest() {
        
        // Arrange
        int idStage = 1;
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        Query query = Mockito.mock(Query.class);
        
        Mockito.when(
                entityManager.createQuery(FIND_BY_STAGE_ID)
        ).thenReturn(query);
        Mockito.when(
                query.setParameter("stageId", idStage)
        ).thenReturn(query);
        
        List<Commentary> Commentaries = new LinkedList<Commentary>();
        Mockito.when(query.getResultList()).thenReturn(Commentaries);
        
        CommentaryRepository commentaryRepository = new CommentaryRepository();
        commentaryRepository.setEntityManager(entityManager);
        
        // Act
        Optional<Commentary> result = commentaryRepository.getCommentaryByStage(idStage);
        
        // Assert
        Assert.assertEquals(result, Commentaries);
    }
    
    
    public void getAllTest(){
        // Arrange
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        Query query = Mockito.mock(Query.class);
        
        Mockito.when(
                entityManager.createQuery(GET_ALL)
        ).thenReturn(query);
        
        List<Commentary> commentary = new LinkedList<Commentary>();
        Mockito.when(
                query.getResultList()
        ).thenReturn(commentary);
        
        CommentaryRepository commentaryRepository = new CommentaryRepository();
        commentaryRepository.setEntityManager(entityManager);
        
        // Act
        List<Commentary> result = commentaryRepository.getAll();
        
        //Assert
        Assert.assertEquals(result, commentary);
    }
    
    
}
