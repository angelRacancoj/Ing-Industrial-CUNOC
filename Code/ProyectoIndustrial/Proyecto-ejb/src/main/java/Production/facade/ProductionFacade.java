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

    @Override
    public void createProduction(Production production) throws MandatoryAttributeProductionException {
        productionService.create(production);
    }

    @Override
    public void editProduction(Production production) throws MandatoryAttributeProductionException {
        productionService.edit(production);
    }

    @Override
    public List<Production> AllProductions() {
        return productionRepository.AllProductions();
    }

    @Override
    public Optional<Production> getProductionById(Integer id) {
        return productionRepository.findByIdProduction(id);
    }
}
