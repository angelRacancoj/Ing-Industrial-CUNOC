
package gt.edu.usac.cunoc.ingenieria.supply.converter;

import Supply.Measure;
import Supply.Supply;
import Supply.exception.MandatoryAttributeSupplyException;
import Supply.facade.SupplyFacadeLocal;
import gt.edu.usac.cunoc.ingenieria.supply.supply.registerSupplyView;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "measureConverter", managed = true)

public class measureConverter implements Converter{
    
    @EJB
    private SupplyFacadeLocal supplyFacade;
    
    /*@Override
    public Measure getAsObject(FacesContext context, UIComponent component, String measureId) {
        try {
            Measure measure = supplyFacade.getMeasure(new Measure(Integer.parseInt(measureId),null,new ArrayList<Supply>())).get(0);
            return measure;              
        } catch (Exception e) {
            e.printStackTrace();
            return null; 
        }
    }*/
    
    
    @Override
    public Object getAsObject(FacesContext ctx, UIComponent uiComponent, String measureId) {
        try {
            ValueExpression vex =
                    ctx.getApplication().getExpressionFactory()
                            .createValueExpression(ctx.getELContext(),
                                    "#{registerSupplyView}", registerSupplyView.class);
            
            registerSupplyView measure = (registerSupplyView)vex.getValue(ctx.getELContext());
            return measure.searchMeasure(new Measure(Integer.valueOf(measureId), null, new ArrayList<Supply>()));
        } catch (MandatoryAttributeSupplyException ex) {
            ex.printStackTrace();
            return null; 
        }
    }
    
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object measure) {
        return ((Measure) measure).getIdMeasure().toString();
    }
    
}
