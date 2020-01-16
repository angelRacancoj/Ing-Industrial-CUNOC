
package Supply.facade;

import Supply.Measure;
import Supply.Supply;
import Supply.exception.MandatoryAttributeSupplyException;
import Supply.repository.AvailabilityFilter;
import Supply.repository.ExpirationDateFilter;
import Supply.repository.MeasureRepository;
import Supply.repository.SupplyRepository;
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
    private SupplyRepository supplyRepository;
       
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
    
    /***
     * Obtiene una medida por medio de su id
     * @param measure Objeto de tipo measure que encapsulo el id a buscar
     * @return La medida con el id proporcionado
     * @throws MandatoryAttributeSupplyException Si hace falta algun atributo obligatorio
     */
    @Override
    public List<Measure> getMeasure(Measure measure) throws MandatoryAttributeSupplyException {
        return measureRepository.getMeasure(measure);
    }
    
    /***
     *Crea un nuevo Insumo en BD
     * @param newSupply Objeto Supply a crear en BD
     * @return El Objeto creado en la BD
     * @throws MandatoryAttributeSupplyException Si hace falta algun atributo obligatorio
     */
    @Override
    public Supply createSupply(Supply newSupply) throws MandatoryAttributeSupplyException {
        return supplyService.create(newSupply);
    }

    /***
     * Busca los Insumos que cumplan con los criterios de busqueda proporcionados
     * @param codeSupply codigo del Insumo a buscar
     * @param nameSupply Nombre del Insumo a buscar
     * @param availabilitySupply Disponibilidad del Insumo a Buscar
     * @param expirationDateSupply Fecha de Expiracion del Insumo a Buscar
     * @return 
     */
    @Override
    public List<Supply> searchSupplies(Integer codeSupply, String nameSupply, AvailabilityFilter availabilitySupply, ExpirationDateFilter expirationDateSupply) {
        return supplyRepository.getSupply(codeSupply, nameSupply, availabilitySupply, expirationDateSupply);
    }
}
