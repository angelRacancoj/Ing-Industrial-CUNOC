package User.service;

import User.RolUser;
import User.exception.UserException;
import static config.Constants.PERSISTENCE_UNIT_NAME;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class RolUserService {
    @PersistenceContext(name=PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;
    
    public void createRolUser(RolUser rolUser) throws UserException{
        if(rolUser==null){
            throw new UserException("rolUser is null");
        }
        entityManager.persist(rolUser);
    }
    
    public void updateRolUser(RolUser rolUser) throws UserException{
        if(rolUser==null){
            throw new UserException("rolUser is null");
        }
        RolUser updateRolUser = entityManager.find(RolUser.class, rolUser.getIdRolUser());
        updateRolUser.setName(rolUser.getName());
    }
   
}