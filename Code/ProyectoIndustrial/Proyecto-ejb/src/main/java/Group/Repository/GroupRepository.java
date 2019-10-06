/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Group.Repository;

import Group.Group;
import static config.Constants.PERSISTENCE_UNIT_NAME;
import java.util.List;
import java.util.Optional;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author angelrg
 */

@Stateless
@LocalBean
public class GroupRepository {
    
    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;
    
    public Optional<Group> findById(Integer id){
        Query query = entityManager.createQuery("SELECT g FROM Group g WHERE g.idGroup = :id").setParameter("id", id);
        return query.getResultStream().findFirst();
        
//        try {
//            return Optional.of((Group) query.getSingleResult());
//        } catch (Exception e) {
//            return Optional.empty();
//        }
        
//        List<Group> result = query.getResultList();
//        if (result.size() > 0) {
//            return Optional.of(result.get(0));
//        }
//        return null;
    }
    
    
    
}
