package Production.repository;

import Production.Product;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import static config.Constants.PERSISTENCE_UNIT_NAME;
import java.util.ArrayList;
import java.util.Optional;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Stateless
@LocalBean
public class ProductRepository {

    public static final String FIND_BY_ID = "SELECT g FROM Product g WHERE g.idProduct = :id";
    public static final String FIND_BY_NAME = "SELECT g FROM product g WHERE g.name = :name";
    public static final String GET_ALL = "SELECT g FROM Product g";
    
    private EntityManager entityManager;
    
    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

//    public Optional<Product> getProductById(Integer id){
//        TypedQuery<Product> typedQuery = entityManager.createQuery(FIND_BY_ID,Product.class).setParameter("id", id);
//        try {
//            return Optional.of(typedQuery.getSingleResult());
//        } catch (NoResultException e) {
//            return Optional.empty();
//        }
//    }
    public Optional<Product> getProductById(Integer id) {
        return Optional.of(entityManager.find(Product.class, id));
    }
    
    public Optional<Product> getProductByName(String name) {
        TypedQuery<Product> typedQuery = entityManager.createQuery(FIND_BY_NAME, Product.class).setParameter("name", name);
        try {
            return Optional.of(typedQuery.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }
    
    public Optional<List<Product>> getAll() {
        TypedQuery<Product> typedQuery = entityManager.createQuery(GET_ALL, Product.class);
        try {
            return Optional.of(typedQuery.getResultList());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }
}
