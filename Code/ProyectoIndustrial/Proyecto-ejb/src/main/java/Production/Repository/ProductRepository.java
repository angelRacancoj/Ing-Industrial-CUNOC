package Production.Repository;


import Production.Product;
import static config.Constants.PERSISTENCE_UNIT_NAME;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Stateless
@LocalBean
public class ProductRepository {

    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;

    public ProductRepository() {

    }

        public List<Product> getProduct(Integer idProduct, String name){       
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> criteriaQuery = criteriaBuilder.createQuery(Product.class);
        Root<Product> product = criteriaQuery.from(Product.class);
        Predicate idProductPredicate = criteriaBuilder.like(product.get("id"), "%" + idProduct + "%");
        Predicate nameProductPredicate = criteriaBuilder.like(product.get("name"), "%" + name + "%");
        criteriaQuery.where(idProductPredicate, nameProductPredicate);
        TypedQuery<Product> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}

