
package gt.edu.usac.cunoc.ingenieria.supply.supply;

import Supply.Supply;
import Supply.facade.SupplyFacadeLocal;
import Supply.repository.AvailabilityFilter;
import Supply.repository.ExpirationDateFilter;
import gt.edu.usac.cunoc.ingenieria.utils.MessageUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class searchSupplyView implements Serializable{
    
    private static final String EMPTY_SEARCH = "No existen Insumos con esas caracteristicas";
    
    @EJB
    private SupplyFacadeLocal supplyFacade;
    
    List<Supply> supplies = new ArrayList<>();
    
    //Search Criterias
    Integer codeSearchCriteria;
    String nameSearchCriteria; 
    AvailabilityFilter availabilitySearchCriteria;
    ExpirationDateFilter expirationDateSearchCriteria;

    //Selected Supply
    Supply selectedSupply;

    public SupplyFacadeLocal getSupplyFacade() {
        return supplyFacade;
    }

    public void setSupplyFacade(final SupplyFacadeLocal supplyFacade) {
        this.supplyFacade = supplyFacade;
    }

    public List<Supply> getSupplies() {
        return supplies;
    }

    public void setSupplies(final List<Supply> supplies) {
        this.supplies = supplies;
    }

    public Integer getCodeSearchCriteria() {
        return codeSearchCriteria;
    }

    public void setCodeSearchCriteria(final Integer codeSearchCriteria) {
        this.codeSearchCriteria = codeSearchCriteria;
    }

    public String getNameSearchCriteria() {
        return nameSearchCriteria;
    }

    public void setNameSearchCriteria(final String nameSearchCriteria) {
        this.nameSearchCriteria = nameSearchCriteria;
    }

    public AvailabilityFilter getAvailabilitySearchCriteria() {
        return availabilitySearchCriteria;
    }

    public void setAvailabilitySearchCriteria(final AvailabilityFilter availabilitySearchCriteria) {
        this.availabilitySearchCriteria = availabilitySearchCriteria;
    }

    public ExpirationDateFilter getExpirationDateSearchCriteria() {
        return expirationDateSearchCriteria;
    }

    public void setExpirationDateSearchCriteria(final ExpirationDateFilter expirationDateSearchCriteria) {
        this.expirationDateSearchCriteria = expirationDateSearchCriteria;
    }
    
    public Supply getSelectedSupply() {
        if (selectedSupply == null){
            selectedSupply = new Supply();
        }
        return selectedSupply;
    }

    public void setSelectedSupply(final Supply selectedSupply) {
        this.selectedSupply = selectedSupply;
    }
    
    public void searchSupplies(){
        this.setSupplies(supplyFacade.searchSupplies(codeSearchCriteria, nameSearchCriteria, availabilitySearchCriteria, expirationDateSearchCriteria));
        if (getSupplies().isEmpty()){
            MessageUtils.addSuccessMessage(EMPTY_SEARCH);
        }
    }
}
