package gt.udu.usac.cunoc.ingenieria.inventory.view;

import Inventory.InventoryLocal;
import Supply.repository.AvailabilityFilter;
import Supply.repository.ExpirationDateFilter;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author angelrg
 */
@Named
@ViewScoped
public class inventoryView implements Serializable{
    
    @EJB
    private InventoryLocal inventoryLoca;
    
    Integer codeSupply;
    String nameSupply;
    AvailabilityFilter availabilitySupply;
    ExpirationDateFilter expirationDateSupply;
    
    
}
