package gt.edu.usac.cunoc.ingenieria.user.converter;

import User.RolUser;
import User.facade.UserFacade;
import User.facade.UserFacadeLocal;
import gt.edu.usac.cunoc.ingenieria.user.view.CreateUserView;
import javax.ejb.EJB;
import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "rolUserConverter", managed = true)
public class RolUserConverter implements Converter {
    @EJB
    private UserFacadeLocal userFacade;
    
    @Override
    public RolUser getAsObject(FacesContext context, UIComponent component, String rolUserId) {
        try {
            RolUser rolUser=userFacade.getRolUser(new RolUser(Integer.parseInt(rolUserId), null)).get(0);
            System.out.println("--------------"+rolUser);
            return rolUser;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object rolUser) {
        return ((RolUser) rolUser).getIdRolUser().toString();
    }

}
