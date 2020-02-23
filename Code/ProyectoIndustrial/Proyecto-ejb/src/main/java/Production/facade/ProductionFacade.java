package Production.facade;


import Production.Product;
import Production.Production;
import Production.Step;
import Production.exceptions.MandatoryAttributeProductionException;
import Production.repository.ProductRepository;
import Production.repository.ProductionRepository;
import Production.repository.StepRepository;
import Production.service.ProductionService;
import Production.service.StepService;
import java.util.List;
import java.util.Optional;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author daniel
 */
@Stateless
public class ProductionFacade implements ProductionFacadeLocal {
    private ProductionService productionService ;
    private ProductionRepository productionRepository;
    private ProductRepository productRepository;
    private StepService stepService;
    private StepRepository stepRepository;

    
    @EJB
    public void setStepService(StepService stepService) {
        this.stepService = stepService;
    }
    @EJB
    public void setStepRepository(StepRepository stepRepository) {
        this.stepRepository = stepRepository;
    }

    
    
    @EJB
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    
    
    @EJB
    public void setProductionService(ProductionService service) {
        productionService = service;
    }

    @EJB
    public void setProductionRepository(ProductionRepository  productionRepository) {
        this.productionRepository = productionRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void createProduction(Production production) throws MandatoryAttributeProductionException {
        productionService.create(production);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void editProduction(Production production) throws MandatoryAttributeProductionException {
        productionService.edit(production);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Production> AllProductions() {
        return productionRepository.AllProductions();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Production> getProductionById(Integer id) {
        return productionRepository.findByIdProduction(id);
    }
    
    public List<Product> getProduct(){
        Optional<List<Product>> lista = productRepository.getAll();      
        return lista.get();
    }
    
    
    
}
