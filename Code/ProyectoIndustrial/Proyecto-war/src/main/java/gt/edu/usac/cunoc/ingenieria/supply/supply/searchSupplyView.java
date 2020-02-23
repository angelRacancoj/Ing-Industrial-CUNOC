package gt.edu.usac.cunoc.ingenieria.supply.supply;

import Supply.Measure;
import Supply.Supply;
import Supply.facade.SupplyFacadeLocal;
import Supply.repository.AvailabilityFilter;
import Supply.repository.ExpirationDateFilter;
import User.exception.UserException;
import gt.edu.usac.cunoc.ingenieria.utils.MessageUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.PrimeFaces;

@Named
@ViewScoped
public class searchSupplyView implements Serializable {

    private static final String EMPTY_SEARCH = "No existen Insumos con esas caracteristicas";

    @EJB
    private SupplyFacadeLocal supplyFacade;

    List<Supply> supplies = new ArrayList<>();
    List<Measure> measures = new ArrayList<>();

    //Search Criterias
    Integer codeSearchCriteria;
    String nameSearchCriteria;
    AvailabilityFilter availabilitySearchCriteria;
    ExpirationDateFilter expirationDateSearchCriteria;

    //Selected Supply
    Supply selectedSupply = new Supply();

    @PostConstruct
    public void init() {
        getAllMeasure();
    }

    public void updateSupply(final String modalIdToClose) throws UserException {
        if (selectedSupply != null) {
            supplyFacade.modifySupply(selectedSupply);
            MessageUtils.addSuccessMessage("Se actualizo el Insumo");
        }
        cleanActualSupply();
        PrimeFaces.current().executeScript("PF('" + modalIdToClose + "').hide()");
    }

    public Supply getSelectedSupply() {
        if (selectedSupply == null) {
            selectedSupply = new Supply();
        }
        return selectedSupply;
    }

    public void setSelectedSupply(final Supply selectedSupply) {
        this.selectedSupply = selectedSupply;
    }

    public void searchSupplies() {
        System.out.println("Inicia la busqueda");
        this.setSupplies(supplyFacade.searchSupplies(codeSearchCriteria, nameSearchCriteria, availabilitySearchCriteria, expirationDateSearchCriteria));
        if (getSupplies().isEmpty()) {
            MessageUtils.addSuccessMessage(EMPTY_SEARCH);
        }
    }

    public void cleanCriteria() {
        codeSearchCriteria = null;
        nameSearchCriteria = null;
        availabilitySearchCriteria = null;
        expirationDateSearchCriteria = null;
    }

    public void cleanActualSupply() {
        setSelectedSupply(null);
    }

    private void getAllMeasure() {
        measures = supplyFacade.getAllMeasures();
    }

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

    public List<Measure> getMeasures() {
        return measures;
    }

    public void setMeasures(List<Measure> measures) {
        this.measures = measures;
    }
}
