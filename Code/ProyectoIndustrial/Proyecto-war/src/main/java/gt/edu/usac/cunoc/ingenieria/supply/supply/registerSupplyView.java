
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
public class registerSupplyView implements Serializable{
       
    @EJB
    private SupplyFacadeLocal supplyFacade;
    
    private Supply newSupply;
    private List<Measure> measures;
    
    @PostConstruct
    public void init(){
        getAllMeasure();
    }
    
    public String getName() {
        return newSupply.getName();
    }

    public void setName(String name) {
        this.newSupply.setName(name);
    }

    public LocalDate getExpirationDate() {
        return this.newSupply.getExpirationDate();
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.newSupply.setExpirationDate(expirationDate);
    }

    public Double getQuantity() {
        return this.newSupply.getQuantity();
    }

    public void setQuantity(Double quantity) {
        this.newSupply.setQuantity(quantity);
    }

    public Double getCost() {
        return this.newSupply.getCost();
    }

    public void setCost(Double cost) {
        this.newSupply.setCost(cost);
    }

    public Measure getMeasure() {
        return this.newSupply.getMeasure();
    }

    public void setMeasure(Measure measure) {
        this.newSupply.setMeasure(measure);
    }

    public String getDescription() {
        return this.newSupply.getDescription();
    }

    public void setDescription(String description) {
        this.newSupply.setDescription(description);
    }

    public List<Measure> getMeasures() {
        return measures;
    }

    public void setMeasures(List<Measure> measures) {
        this.measures = measures;
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
            //MessageUtils.addSuccessLocalizedMessage("Insumo Creado");
        } catch (MandatoryAttributeSupplyException ex) {
            //MessageUtils.addSuccessLocalizedMessage(ex.getMessage());
        }
    }
}
