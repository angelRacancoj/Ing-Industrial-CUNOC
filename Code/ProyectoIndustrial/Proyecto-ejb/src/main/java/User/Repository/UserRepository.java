package User.Repository;

import User.RolUser;
import User.User;
import static config.Constants.PERSISTENCE_UNIT_NAME;
import java.util.List;
import java.util.Optional;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
@LocalBean
public class UserRepository {
    @PersistenceContext(name=PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;
    
    public Optional<User> findByCarnet(int carnet){
        Query query=entityManager.createQuery("SELECT u FORM user u WHERE :u.carnet= :carnet").setParameter("carnet",carnet);
        return query.getResultStream().findFirst();
    }
    public Optional<List<User>> findByName(String name){
        Query query=entityManager.createQuery("SELECT u FORM user u WHERE :u.name LIKE CONCAT('%',:name,'%')").setParameter("name",name);
        return Optional.of(query.getResultList());
    }
    public Optional<List<User>> findByState(int state){
        Query query=entityManager.createQuery("SELECT u FORM user u WHERE :u.state=:state").setParameter("state",state);
        return Optional.of(query.getResultList());
    }
    public Optional<List<User>> findById_career(int id_career){
        Query query=entityManager.createQuery("SELECT u FORM user u WHERE :u.id_career=:id_career").setParameter("id_career",id_career);
        return Optional.of(query.getResultList());
    }
    
    public Optional<List<User>> findAll(){
        Query query=entityManager.createQuery("SELECT u FORM user u");
        return Optional.of(query.getResultList()); 
    }
    
    
}
