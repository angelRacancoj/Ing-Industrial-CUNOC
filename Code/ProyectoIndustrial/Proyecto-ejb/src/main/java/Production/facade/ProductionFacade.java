package Production.facade;

import Design.Design;
import Design.DesignData;
import Production.NecessarySupply;
import Production.Product;
import Production.Production;
import Production.Step;
import Production.exceptions.MandatoryAttributeProductionException;
import Production.repository.DesignRepository;
import Production.repository.ProductRepository;
import Production.repository.ProductionRepository;
import Production.repository.StepRepository;
import Production.service.DesignService;
import Production.service.ProductionService;
import Production.service.StepService;
import java.util.ArrayList;
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

    private ProductionService productionService;
    private ProductionRepository productionRepository;
    private ProductRepository productRepository;
    private StepService stepService;
    private StepRepository stepRepository;
    private DesignRepository designRepository;

    private DesignService designService;

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
    public void setProductionRepository(ProductionRepository productionRepository) {
        this.productionRepository = productionRepository;
    }

    @EJB
    public void setDesignService(DesignService designService) {
        this.designService = designService;
    }

    @EJB
    public void setDesignRepository(DesignRepository designRepository) {
        this.designRepository = designRepository;
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
    public List<Product> getProduct() {
        Optional<List<Product>> lista = productRepository.getAll();
        return lista.get();
    }

    @Override
    public void createDesign(Design design, DesignData designData, List<NecessarySupply> necessarySupplys) {
        designService.createDesign(design, designData, necessarySupplys);
    }
    
    @Override
    public Design editDesign(Design design) throws MandatoryAttributeProductionException{
        return designService.editDesign(design);
    }

    @Override
    public List<Design> AllDesigns() {
        List<Design> list = new ArrayList<>();
        list = designRepository.AllDesigns();
        return list;
    }

    @Override
    public Optional<Production> getProductionById(Integer id) {
        return productionRepository.findByIdProduction(id);
    }

    @Override
    public Optional<Product> getProductById(Integer id) {
        return productRepository.getProductById(id);
    }

}
