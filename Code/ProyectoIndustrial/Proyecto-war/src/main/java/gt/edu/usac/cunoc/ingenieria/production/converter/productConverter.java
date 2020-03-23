package gt.edu.usac.cunoc.ingenieria.production.converter;

import Production.Product;
import Production.facade.ProductionFacadeLocal;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "productConverter", managed = true)
public class productConverter implements Converter {

    @EJB
    private ProductionFacadeLocal productionFacade;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String productId) {
        try {
            Product product = productionFacade.getProductById(Integer.parseInt(productId)).get();
            return product;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object product) {
        return ((Product) product).getIdProduct().toString();
    }

}
