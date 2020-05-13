package gt.edu.usac.cunoc.ingenieria.production.production.view;

import Design.Design;
import Group.GroupIndustrial;
import Group.facade.GroupFacadelocal;
import Production.Production;
import Production.facade.ProductionFacadeLocal;
import User.exception.UserException;
import gt.edu.usac.cunoc.ingenieria.utils.MessageUtils;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.annotation.PostConstruct;
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
public class searchProduction implements Serializable {

    @EJB
    private ProductionFacadeLocal productionFacade;

    @EJB
    private GroupFacadelocal groupFacade;

    List<Production> productions;
    List<Design> designs;
    List<GroupIndustrial> groups;

    Production selectedProduction = new Production();

    // criteria search
    Integer idProduction;
    String name;
    LocalDate startDate;
    LocalDate endDate;
    boolean editable = false;

//    @PostConstruct
//    public void init() {
//        getInitData();
//    }
    /**
     * Use idProduction, name, dataRange and editable, to find the productions
     */
    public void searchProduction() {
        getInitData();
        setProductions(productionFacade.findProduction(idProduction, name, startDate, endDate, editable));
    }

    public void saveChanges(final String modalIdToClose) {
        try {
            if (selectedProduction != null) {
                productionFacade.updateProduction(selectedProduction);
                MessageUtils.addSuccessMessage("Se actualizo la Producción");
            } else {
                MessageUtils.addErrorMessage("Debe seleccionarse una Producción");
            }
        } catch (UserException e) {
            MessageUtils.addErrorMessage(e.getMessage());
        }
        cleanSelectedProduction();
        PrimeFaces.current().executeScript("PF('" + modalIdToClose + "').hide()");

    }

    public List<Production> getProductions() {
        return productions;
    }

    public void setProductions(List<Production> productions) {
        this.productions = productions;
    }

    public List<Design> getDesigns() {
        return designs;
    }

    public void setDesigns(List<Design> designs) {
        this.designs = designs;
    }

    public List<GroupIndustrial> getGroups() {
        return groups;
    }

    public void setGroups(List<GroupIndustrial> groups) {
        this.groups = groups;
    }

    public Production getSelectedProduction() {
        if (selectedProduction == null) {
            selectedProduction = new Production();
        }
        return selectedProduction;
    }

    public void setSelectedProduction(Production selectedProduction) {
        this.selectedProduction = selectedProduction;
    }

    private void getInitData() {
        setDesigns(productionFacade.AllDesigns());
        setGroups(groupFacade.getAll());
    }

    public Integer getIdProduction() {
        return idProduction;
    }

    public void setIdProduction(Integer idProduction) {
        this.idProduction = idProduction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public void cleanCriteriaSearch() {
        setIdProduction(null);
        setName(null);
        setStartDate(null);
        setEndDate(null);
        setEditable(false);
    }

    public void cleanSearchResult() {
        setProductions(null);
    }

    public void cleanSelectedProduction() {
        setSelectedProduction(null);
    }

}
