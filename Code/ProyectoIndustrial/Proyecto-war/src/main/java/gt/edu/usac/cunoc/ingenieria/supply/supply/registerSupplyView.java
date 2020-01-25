
package gt.edu.usac.cunoc.ingenieria.supply.supply;

import Supply.Measure;
import Supply.Supply;
import Supply.exception.MandatoryAttributeSupplyException;
import Supply.facade.SupplyFacadeLocal;
import gt.edu.usac.cunoc.ingenieria.utils.MessageUtils;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class registerSupplyView implements Serializable{
    
    private static final String SUPPLY_CREATED = "Insumo Creado";
    
    @EJB
    private SupplyFacadeLocal supplyFacade;
    
    private Supply newSupply;
    private List<Measure> measures;
    
    @PostConstruct
    public void init(){
        getAllMeasure();
    }

    public List<Measure> getMeasures() {
        return measures;
    }

    public void setMeasures(List<Measure> measures) {
        this.measures = measures;
    }

    public Supply getNewSupply() {
        return newSupply;
    }

    public void setNewSupply(Supply newSupply) {
        this.newSupply = newSupply;
    }
        
    private void getAllMeasure(){
        measures = supplyFacade.getAllMeasures();
        newSupply = new Supply();
    }
    
    public Measure searchMeasure(Measure measure) throws MandatoryAttributeSupplyException{
        return supplyFacade.getMeasure(measure).get(0);
    }
    
    public void save(){
        try {
            supplyFacade.createSupply(this.newSupply);
            MessageUtils.addSuccessMessage(SUPPLY_CREATED);
            newSupply = new Supply();
        } catch (MandatoryAttributeSupplyException ex) {
            MessageUtils.addErrorMessage(ex.getMessage());
        }
    }
}
