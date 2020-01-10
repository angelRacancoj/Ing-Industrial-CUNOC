/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.udu.usac.cunoc.ingenieria.inventory.view;

import Production.Production;
import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author angelrg
 */
@FacesConverter(value = "productionConverter")
public class productionConverter implements Converter<Production>{

    @Override
    public Production getAsObject(FacesContext context, UIComponent component, String value) {
        ValueExpression vex = context.getApplication().getExpressionFactory().createValueExpression(context.getELContext(), "#{supplyCalculatorView}", Production.class);
        supplyCalculatorView supplyCalculator = (supplyCalculatorView)vex.getValue(context.getELContext());
        return supplyCalculator.getPoductionById(Integer.parseInt(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Production value) {
        return value.getIdProduction().toString();
    }


    
}
