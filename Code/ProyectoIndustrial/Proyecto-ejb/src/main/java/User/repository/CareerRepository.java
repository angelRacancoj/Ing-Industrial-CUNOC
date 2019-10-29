package User.repository;

import User.Career;
import User.RolUser;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import static config.Constants.PERSISTENCE_UNIT_NAME;

@Stateless
@LocalBean
public class CareerRepository {

    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Career> getCareer(Integer id_career, String name) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Career> criteriaQuery = criteriaBuilder.createQuery(Career.class);
        Root<Career> Career = criteriaQuery.from(Career.class);
        List<Predicate> predicates = new ArrayList<>();
        if (id_career != null) {
            predicates.add(criteriaBuilder.equal(Career.get("id_career"), id_career));
        }
        if (name != null) {
            predicates.add(criteriaBuilder.like(Career.get("name"), "%" + name + "%"));
        }
        criteriaQuery.where(predicates.stream().toArray(Predicate[]::new));
        TypedQuery<Career> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
