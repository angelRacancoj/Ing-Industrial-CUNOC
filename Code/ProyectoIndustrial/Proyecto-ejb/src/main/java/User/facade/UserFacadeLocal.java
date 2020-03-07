package User.facade;

import User.Career;
import User.RolUser;
import User.User;
import User.exception.UserException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.ejb.Local;

@Local
public interface UserFacadeLocal {

    public List<User> getAuthenticatedUser() throws UserException;

    public User createUser(User user) throws UserException;

    public User updateUser(User user) throws UserException;

    public List<User> getUser(User user) throws UserException;

    public Career createCareer(Career career) throws UserException;

    public Career updateCareer(Career career) throws UserException;

    public List<Career> getCareer(Career career) throws UserException;

    public RolUser createRolUser(RolUser rolUser) throws UserException;

    public RolUser updateRolUser(RolUser rolUser) throws UserException;

    public List<RolUser> getRolUser(RolUser rolUser) throws UserException;

    public RolUser getRolUserById(int rolUser) throws UserException;

    public User resetPassword(User user) throws UserException, NoSuchAlgorithmException;

    public List<Career> getAllCareer();

    public List<RolUser> getAllRolUser();

    public List<User> getUserEstudent() throws UserException;
}
