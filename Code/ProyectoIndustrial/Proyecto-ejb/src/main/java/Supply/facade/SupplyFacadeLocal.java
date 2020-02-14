
package Supply.facade;

import Supply.Supply;
import java.util.List;
import javax.ejb.Local;

@Local
public interface SupplyFacadeLocal {
    public List<Supply> getSupplyAvailable() ;
    
}
