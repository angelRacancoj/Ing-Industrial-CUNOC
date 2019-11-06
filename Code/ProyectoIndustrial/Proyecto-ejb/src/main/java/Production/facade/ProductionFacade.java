
package Production.facade;


import Production.Production;
import Production.exceptions.MandatoryAttributeProductionException;
import Production.service.ProductionService;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author daniel
 */
@Stateless
public class ProductionFacade implements ProductionFacadeLocal {
    private ProductionService productionService ;


    @EJB
    public  void setProductionService(ProductionService service){
        productionService = service;
    }

    public void createProduction(Production production)throws MandatoryAttributeProductionException{
        productionService.create(production);
    }
    
    public void editProduction(Production production)throws MandatoryAttributeProductionException{
        productionService.edit(production);
    }
}
