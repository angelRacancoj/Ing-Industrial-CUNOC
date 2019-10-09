package User.Repository;

import User.Career;
import static config.Constants.PERSISTENCE_UNIT_NAME;
import java.util.List;
import java.util.Optional;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

@Stateless
@LocalBean
public class CareerRepository{
    
    @PersistenceContext(name=PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;
    
    
    public Optional<Career> findById(int id_career){
        Query query=entityManager.createQuery("SELECT c FORM career c WHERE :c.id_career= :id_career").setParameter("id_career", id_career); 
        return query.getResultStream().findFirst();
    }
    public Optional<List<Career>> findByName(String name_career){
        Query query=entityManager.createQuery("SELECT c FORM career c WHERE :c.name_career LIKE CONCAT('%',:name_career,'%')").setParameter("name_career",name_career);
        return Optional.of(query.getResultList());
    }
    public Optional<List<Career>> findAll(){
        Query query=entityManager.createQuery("SELECT c FORM career c");
        return Optional.of(query.getResultList());
    }
}
