package gt.edu.usac.cunoc.ingenieria.login.view;

import User.User;
import User.exception.UserException;
import User.facade.UserFacadeLocal;
import static config.Constants.ADMINISTRADOR;
import static config.Constants.ESTUDIANTE;
import static config.Constants.DOCENTE;
import static config.Constants.MAIN_PAGE;
import gt.edu.usac.cunoc.ingenieria.utils.MessageUtils;
import java.io.IOException;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.SecurityContext;
import javax.security.enterprise.authentication.mechanism.http.AuthenticationParameters;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.Password;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author teodoro
 */
@Named
@ViewScoped
public class LoginView implements Serializable {

    @EJB
    private UserFacadeLocal userFacade;

    @Inject
    private SecurityContext securityContext;

    @Inject
    private ExternalContext externalContext;

    @Inject
    private FacesContext facesContext;

    private String carnet;
    private String password;

    public String getUserCarnet() {
        return carnet;
    }

    public void setUserCarnet(final String userName) {
        this.carnet = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public void login() throws IOException, UserException {
        Credential credential = new UsernamePasswordCredential(carnet, new Password(password));
        AuthenticationStatus status = securityContext.authenticate(
                getRequest(),
                getResponse(),
                AuthenticationParameters.withParams().credential(credential));
        switch (status) {
            case SEND_CONTINUE:
                facesContext.responseComplete();
                break;
            case SEND_FAILURE:
                MessageUtils.addErrorMessage("Usuario no encontrado");
                break;
            case SUCCESS:
                redirectToIndex();
            case NOT_DONE:
        }
    }

    private HttpServletRequest getRequest() {
        return (HttpServletRequest) externalContext.getRequest();
    }

    private HttpServletResponse getResponse() {
        return (HttpServletResponse) externalContext.getResponse();
    }

    private void redirectToIndex() throws IOException, UserException {
        User currentUser = userFacade.getAuthenticatedUser().get(0);
        switch (currentUser.getRolUser().getName()) {
            case ADMINISTRADOR:
            case ESTUDIANTE:
            case DOCENTE:
                externalContext.redirect(externalContext.getRequestContextPath() + MAIN_PAGE);
                break;
            default:
        }
    }

}
