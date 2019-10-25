package User.service;

import User.Career;
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

    public void createCareer(String name) {
        Career career = new Career(name);
        entityManager.persist(career);
    }

    public void updateCareer(Integer idCareer,String name) {
        Career career = entityManager.find(Career.class, idCareer);
        career.setName(name);
    }
}
