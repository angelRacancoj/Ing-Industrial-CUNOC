package User.service;

import User.Career;
import User.RolUser;
import User.User;
import User.exception.UserException;
import static config.Constants.PERSISTENCE_UNIT_NAME;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import static config.Constants.PERSISTENCE_UNIT_NAME;

@Stateless
@LocalBean
public class UserService {
    @PersistenceContext(name=PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;
    
    public void createUser(User user) throws UserException{
        if(user==null){
            throw new UserException("user is null");
        }
        entityManager.persist(user);
    }
    public void updateUser(User user) throws UserException{
        if(user==null){
            throw new UserException("rolUser is null");
        }
        User updateUser = entityManager.find(User.class, user.getCarnet());
        if(user.getName()!=null){
            updateUser.setName(user.getName());
        }
        if(user.getEmail()!=null){
            updateUser.setEmail(user.getEmail());
        }
        if(user.getPhone()!=null){
            updateUser.setPhone(user.getPhone()); 
        }
        if(user.getPassword()!=null){
            updateUser.setPassword(user.getPassword()); 
        }
        if(user.getRolUser()!=null){
            updateUser.setRolUser(user.getRolUser());
        }
        if(user.getCareer()!=null){
            updateUser.setCareer(user.getCareer());
        }
        
    }
    public void stateUser(Integer carnet,Boolean state){
        User user = entityManager.find(User.class, carnet);
        user.setState(state); 
    }
    

}
