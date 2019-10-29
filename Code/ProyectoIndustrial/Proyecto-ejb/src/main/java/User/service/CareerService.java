package User.service;

import User.Career;
import User.exception.UserException;
import static config.Constants.PERSISTENCE_UNIT_NAME;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import static config.Constants.PERSISTENCE_UNIT_NAME;

@Stateless
@LocalBean
public class CareerService {
    @PersistenceContext(name=PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;

    public void createCareer(Career career) throws UserException{
        if(career==null){
             throw new UserException("career is null");
        }
        entityManager.persist(career);
    }

    public void updateCareer(Career career) throws UserException{
        if(career==null){
            throw new UserException("career is null");
        }
        Career updateCareer = entityManager.find(Career.class, career.getIdCareer());
        updateCareer.setName(career.getName());
    }
}
