
package Supply.facade;

import Supply.Measure;
import Supply.Supply;
import Supply.exception.MandatoryAttributeSupplyException;
import Supply.repository.MeasureRepository;
import Supply.service.SupplyServices;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class SupplyFacade implements SupplyFacadeLocal{

    @EJB
    private MeasureRepository measureRepository;
    
    @EJB
    private SupplyServices supplyService;
       
    @EJB
    public void setMeasureRepository(MeasureRepository measureRepository) {
        this.measureRepository = measureRepository;
    }
    
    @EJB
    public void setSupplyService(SupplyServices supplyService) {
        this.supplyService = supplyService;
    }
        
    /**
     *Obtiene todas las medidas
     * @return Lista de medidas
     */
    @Override
    public List<Measure> getAllMeasures(){
        return measureRepository.getAllMeasures();
    }
    
    @Override
    public List<Measure> getMeasure(Measure measure) throws MandatoryAttributeSupplyException {
        return measureRepository.getMeasure(measure);
    }
    
    @Override
    public Supply createSupply(Supply newSupply) throws MandatoryAttributeSupplyException {
        return supplyService.create(newSupply);
    }
}
