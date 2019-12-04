package gt.edu.usac.cunoc.ingenieria.user.converter;

import User.Career;
import User.facade.UserFacade;
import User.facade.UserFacadeLocal;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;


@FacesConverter(value = "careerConverter", managed = true)
public class CareerConverter implements Converter {
    @EJB
    private UserFacadeLocal userFacade;
    
    @Override
    public Career getAsObject(FacesContext context, UIComponent component, String careerId) {
        try {
            System.out.println("----------------------------------------Facade:----------"+userFacade);
            Career career = userFacade.getCareer(new Career(Integer.parseInt(careerId),null)).get(0);
            return career;              
        } catch (Exception e) {
            e.printStackTrace();
            return null; 
        }
}

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object career) {
        return ((Career) career).getIdCareer().toString();
    }

}
