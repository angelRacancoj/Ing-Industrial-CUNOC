package Production.service;

import Production.Commentary;
import Production.Step;
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
    
    public void createCommentary(String text, Step step){ 
        Commentary commentary = new Commentary(text, step);
        entityManager.persist(commentary);
    }
    public void updateCommentary(Integer id_commentary, String text, Step step){
        Commentary commentary = entityManager.find(Commentary.class, id_commentary);
        
        if(text!=null){
            commentary.setText(text);
        }
        if(step!=null){
            commentary.setStep(step);
        }
        
    }
    
    
}
