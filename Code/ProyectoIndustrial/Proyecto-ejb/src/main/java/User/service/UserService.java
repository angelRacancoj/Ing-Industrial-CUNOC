package User.service;

import User.Career;
import User.RolUser;
import User.User;
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
    
    public void createUser(Integer carnet,String name,String email,Integer phone,String password,Boolean state,RolUser rolUser,Career career){ 
        User user = new User(carnet, name, email, phone, password, state, rolUser, career); 
        entityManager.persist(user);
    }
    public void updateUser(Integer carnet,String name,String email,Integer phone,String password,Boolean state,RolUser rolUser,Career career){
        User user = entityManager.find(User.class, carnet);
        if(name!=null){
            user.setName(name);
        }
        if(email!=null){
            user.setEmail(email);
        }
        if(phone!=null){
            user.setPhone(phone); 
        }
        if(password!=null){
            user.setPassword(password); 
        }
        if(rolUser!=null){
            user.setRolUser(rolUser);
        }
        if(career!=null){
            user.setCareer(career);
        }
        
    }
    public void stateUser(Integer carnet,Boolean state){
        User user = entityManager.find(User.class, carnet);
        user.setState(state); 
    }
    

}
