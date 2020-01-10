
package Supply.facade;

import Supply.Measure;
import Supply.Supply;
import Supply.exception.MandatoryAttributeSupplyException;
import java.util.List;
import javax.ejb.Local;

@Local
public interface SupplyFacadeLocal {
    public List<Measure> getAllMeasures();
    
    public List<Measure> getMeasure(Measure measure) throws MandatoryAttributeSupplyException; 
    
    public Supply createSupply(Supply newSupply) throws MandatoryAttributeSupplyException;
}
