package gt.udu.usac.cunoc.ingenieria.inventory.view;

import Inventory.InventoryLocal;
import Supply.Supply;
import Supply.repository.AvailabilityFilter;
import Supply.repository.ExpirationDateFilter;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author angelrg
 */
@Named
@ViewScoped
public class inventoryView implements Serializable {

    @EJB
    private InventoryLocal inventoryLocal;

    Integer codeSupply;
    String nameSupply;
    AvailabilityFilter availabilitySupply;
    ExpirationDateFilter expirationDateSupply;
    List<Supply> searchResult;

    Supply actualSupply;

    public Integer getCodeSupply() {
        return codeSupply;
    }

    public void setCodeSupply(Integer codeSupply) {
        this.codeSupply = codeSupply;
    }

    public String getNameSupply() {
        return nameSupply;
    }

    public void setNameSupply(String nameSupply) {
        this.nameSupply = nameSupply;
    }

    public AvailabilityFilter getAvailabilitySupply() {
        return availabilitySupply;
    }

    public void setAvailabilitySupply(AvailabilityFilter availabilitySupply) {
        this.availabilitySupply = availabilitySupply;
    }

    public ExpirationDateFilter getExpirationDateSupply() {
        return expirationDateSupply;
    }

    public void setExpirationDateSupply(ExpirationDateFilter expirationDateSupply) {
        this.expirationDateSupply = expirationDateSupply;
    }

    public List<Supply> getSearchResult() {
        return searchResult;
    }

    public void setSearchResult(List<Supply> searchResult) {
        this.searchResult = searchResult;
    }

    public void searchSupply() {
        setSearchResult(inventoryLocal.getSupply(codeSupply, nameSupply, availabilitySupply, expirationDateSupply));
    }

    public Supply getSelectedSupply() {
        if (actualSupply == null) {
            actualSupply = new Supply();
        }
        return actualSupply;
    }
}
