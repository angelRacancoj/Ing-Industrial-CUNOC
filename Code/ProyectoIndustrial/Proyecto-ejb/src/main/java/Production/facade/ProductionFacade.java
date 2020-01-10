package Production.facade;

import Production.Production;
import Production.exceptions.MandatoryAttributeProductionException;
import Production.repository.ProductionRepository;
import Production.service.ProductionService;
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

    @EJB
    public void setProductionService(ProductionService service) {
        productionService = service;
    }

    @EJB
    public void setProductionRepository(ProductionRepository productionRepository) {
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
}
