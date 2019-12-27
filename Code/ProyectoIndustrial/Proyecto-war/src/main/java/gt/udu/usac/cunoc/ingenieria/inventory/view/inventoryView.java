package gt.udu.usac.cunoc.ingenieria.inventory.view;

import Inventory.InventoryLocal;
import Modify.ModificationType;
import static Modify.ModificationType.POR_FALTANTE;
import static Modify.ModificationType.ATRIBUTOS;
import static Modify.ModificationType.POR_ROBO;
import Supply.Supply;
import Supply.exception.MandatoryAttributeSupplyException;
import Supply.facade.SupplyFacadeLocal;
import Supply.repository.AvailabilityFilter;
import Supply.repository.ExpirationDateFilter;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.PrimeFaces;

/**
 *
 * @author angelrg
 */
@Named
@ViewScoped
public class inventoryView implements Serializable {

    @EJB
    private InventoryLocal inventoryLocal;

    @EJB
    private SupplyFacadeLocal supplyFacadeLocal;

    Integer codeSupply;
    String nameSupply;
    AvailabilityFilter availabilitySupply;
    ExpirationDateFilter expirationDateSupply;
    List<Supply> searchResult;

    Supply actualSupply;
    Integer quantity;
    String note;

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Supply getActualSupply() {
        return actualSupply;
    }

    public void setActualSupply(Supply actualSupply) {
        this.actualSupply = actualSupply;
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

    public void saveChangesByMissing(final String modalIdToClose) {
        try {
            supplyFacadeLocal.modifyByMissing(actualSupply, quantity, null, note);
            cleanActualSupply();
            PrimeFaces.current().executeScript("PF('" + modalIdToClose + ").hide()");
        } catch (MandatoryAttributeSupplyException ex) {
            Logger.getLogger(inventoryView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void saveChangesTheft(final String modalIdToClose) {
        supplyFacadeLocal.modifyByTheft(actualSupply, null, note);
        cleanActualSupply();
        PrimeFaces.current().executeScript("PF('" + modalIdToClose + ").hide()");
    }

    public void cleanActualSupply() {
        setActualSupply(null);
    }
}
