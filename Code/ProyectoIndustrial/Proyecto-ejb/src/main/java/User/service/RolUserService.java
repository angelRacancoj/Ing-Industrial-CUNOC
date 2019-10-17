package User.service;

import User.RolUser;
import static config.Constants.PERSISTENCE_UNIT_NAME;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class RolUserService {
    @PersistenceContext(name=PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;
    
    public void createRolUser(String name){
        RolUser rolUser=new RolUser(name);
        entityManager.persist(rolUser);
    }
    
    public void updateRolUser(Integer idRolUser,String name){
        RolUser rolUser = entityManager.find(RolUser.class, idRolUser);
        rolUser.setName(name);
    }
   
}