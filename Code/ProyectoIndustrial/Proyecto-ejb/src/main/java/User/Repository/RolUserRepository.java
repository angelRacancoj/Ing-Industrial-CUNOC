package User.Repository;

import User.Career;
import User.RolUser;
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
public class RolUserRepository {
    @PersistenceContext(name=PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;
    
    public Optional<RolUser> findById(int id_rol){
        Query query=entityManager.createQuery("SELECT r FORM rol_user r WHERE :r.id_rol= :id_rol").setParameter("id_rol",id_rol);
        return query.getResultStream().findFirst();
    }
    
    public Optional<List<RolUser>> findByName(int id_rol){
        Query query=entityManager.createQuery("SELECT r FORM rol_user r WHERE :r.id_rol LIKE CONCAT('%',:id_rol,'%')").setParameter("id_rol",id_rol);
        List<RolUser> result = query.getResultList();
        return Optional.of(query.getResultList());
    }
    public Optional<List<RolUser>> findAll(){
        Query query=entityManager.createQuery("SELECT c FORM career c");
        return Optional.of(query.getResultList());
    }
}
