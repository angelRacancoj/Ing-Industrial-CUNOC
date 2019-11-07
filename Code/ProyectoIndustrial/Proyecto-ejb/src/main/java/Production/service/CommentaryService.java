package Production.service;

import Production.Commentary;
import Production.exceptions.MandatoryAttributeProductionException;
import static config.Constants.PERSISTENCE_UNIT_NAME;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class CommentaryService {
    
    @PersistenceContext(name=PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;
    
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    public Commentary createCommentary(Commentary commentary) throws MandatoryAttributeProductionException{
        if(commentary==null){
            throw new MandatoryAttributeProductionException("Commentary is null");
        }
        entityManager.persist(commentary);
        return commentary;
    }
    public Commentary updateCommentary(Commentary commentary, String text, Integer stageId) throws MandatoryAttributeProductionException{
        if(commentary==null){
            throw new MandatoryAttributeProductionException("Commentary is null");
        }
        Commentary updateCommentary = entityManager.find(Commentary.class, commentary.getIdCommentary());
        if(text!=null){
            updateCommentary.setText(commentary.getText());
        }
        if(stageId!=null){
            updateCommentary.setStageId(commentary.getStageId());
        }
        return updateCommentary;
    }
    
    
}
