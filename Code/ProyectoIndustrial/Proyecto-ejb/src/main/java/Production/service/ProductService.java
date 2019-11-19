package Production.service;


import Production.Product;
import Production.exceptions.MandatoryAttributeProductionException;
import static config.Constants.PERSISTENCE_UNIT_NAME;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class ProductService {
    @PersistenceContext(name=PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;
    
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    public Product createProduct(Product product) throws MandatoryAttributeProductionException{
        if(product==null){
            throw new MandatoryAttributeProductionException("Product is null");
        }
        entityManager.persist(product);
        return product;
    }
    public Product updateProduct(Product product, String name, String descripcion) throws MandatoryAttributeProductionException{
        if ((name != null)&& (!name.isEmpty())) {
            product.setName(name);
        }
        if ((descripcion != null)&& (!descripcion.isEmpty())) {
            product.setDescription(descripcion);
        }

        return entityManager.merge(product);
    }
    

}