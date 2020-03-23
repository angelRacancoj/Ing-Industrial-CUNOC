package gt.edu.usac.cunoc.ingenieria.supply.supply;

import Supply.Measure;
import Supply.Supply;
import Supply.exception.MandatoryAttributeSupplyException;
import Supply.facade.SupplyFacadeLocal;
import gt.edu.usac.cunoc.ingenieria.utils.MessageUtils;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class registerSupplyView implements Serializable {

    private static final String SUPPLY_CREATED = "Insumo Creado";

    @EJB
    private SupplyFacadeLocal supplyFacade;

    private Supply newSupply;
    private List<Measure> measures;

    @PostConstruct
    public void init() {
        getAllMeasure();
    }

    public List<Measure> getMeasures() {
        return measures;
    }

    public void setMeasures(List<Measure> measures) {
        this.measures = measures;
    }

    public Supply getNewSupply() {
        if (newSupply == null) {
            return new Supply();
        }
        return newSupply;
    }

    public void setNewSupply(Supply newSupply) {
        this.newSupply = newSupply;
    }

    private void getAllMeasure() {
        measures = supplyFacade.getAllMeasures();
        newSupply = new Supply();
    }

    public String todayDate() {
        return LocalDate.now().toString();
    }

    public void save() {
        try {
            supplyFacade.createSupply(this.newSupply);
            MessageUtils.addSuccessMessage(SUPPLY_CREATED);
            cleanSupply();
        } catch (MandatoryAttributeSupplyException ex) {
            MessageUtils.addErrorMessage(ex.getMessage());
        }
    }
    
    private void cleanSupply(){
        newSupply = null;
    }
}
