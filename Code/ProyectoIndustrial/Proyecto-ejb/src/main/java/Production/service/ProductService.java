package Production.service;


import Production.Product;
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
    
    public void createProduct(Integer idProduct,String name,String description){ 
        Product product = new Product(idProduct, name, description);
        entityManager.persist(product);
    }
    
    public void updateProduct(Integer idProduct, String name,String description){
        Product product = entityManager.find(Product.class, name);
        if(idProduct!=null){
            product.setIdProduct(idProduct);
        }
        if(name!=null){
            product.setName(name);
        }
        if(description!=null){
            product.setDescription(description);
        }
        
    }
    

}