package gt.udu.usac.cunoc.ingenieria.inventory.view;

import Inventory.facade.InventoryLocal;
import Inventory.objects.productionCost;
import Supply.Supply;
import Supply.exception.MandatoryAttributeSupplyException;
import Supply.facade.SupplyFacadeLocal;
import Supply.repository.AvailabilityFilter;
import Supply.repository.ExpirationDateFilter;
import User.exception.UserException;
import User.facade.UserFacadeLocal;
import gt.edu.usac.cunoc.ingenieria.utils.MessageUtils;
import java.io.Serializable;
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

    @EJB
    private UserFacadeLocal userFacade;

    Integer codeSupply;
    String nameSupply;
    AvailabilityFilter availabilitySupply;
    ExpirationDateFilter expirationDateSupply;
    List<Supply> searchResult;
    List<productionCost> productionCostList;

    Supply actualSupply;
    Double quantity;
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

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Supply getActualSupply() {
        return actualSupply;
    }

    public void setActualSupply(Supply actualSupply) {
        this.actualSupply = actualSupply;
    }

    public List<productionCost> getProductionCostList() {
        return productionCostList;
    }

    public void setProductionCostList(List<productionCost> productionCostList) {
        this.productionCostList = productionCostList;
    }

    public void searchSupply() {
//        setSearchResult(inventoryLocal.getSupply(codeSupply, nameSupply, availabilitySupply, expirationDateSupply));
    }

    public Supply getSelectedSupply() {
        if (actualSupply == null) {
            actualSupply = new Supply();
        }
        return actualSupply;
    }

    public void saveChangesByMissing(final String modalIdToClose) {
        try {
            if (actualSupply != null && !userFacade.getAuthenticatedUser().isEmpty() && (userFacade.getAuthenticatedUser().size() == 1)) {
                supplyFacadeLocal.modifyByMissing(actualSupply, quantity, userFacade.getAuthenticatedUser().get(0), note);
            }
            cleanActualSupply();
            PrimeFaces.current().executeScript("PF('" + modalIdToClose + ").hide()");
        } catch (MandatoryAttributeSupplyException ex) {
            Logger.getLogger(inventoryView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UserException e) {
            MessageUtils.addErrorMessage("Usuario Invalido o nulo");
        }
    }

    public void saveChangesTheft(final String modalIdToClose) {
        try {
            if (actualSupply != null && !userFacade.getAuthenticatedUser().isEmpty() && (userFacade.getAuthenticatedUser().size() == 1)) {

            }
            supplyFacadeLocal.modifyByTheft(actualSupply, userFacade.getAuthenticatedUser().get(0), note);
            cleanActualSupply();
            PrimeFaces.current().executeScript("PF('" + modalIdToClose + ").hide()");
        } catch (UserException e) {
            MessageUtils.addErrorMessage("Usuario Invalido o nulo");
        }
    }

    public void getBestProductionOnAvalaibleMaterial() {
        setProductionCostList(inventoryLocal.getBestProductsBaseOnAvailableMaterial());
    }

    public void cleanActualSupply() {
        setActualSupply(null);
    }
}
