package User.facade;

import User.Career;
import User.RolUser;
import User.User;
import User.exception.UserException;
import User.repository.CareerRepository;
import User.repository.RolUserRepository;
import User.repository.UserRepository;
import User.service.CareerService;
import User.service.RolUserService;
import User.service.UserService;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

@Stateless
@LocalBean
public class UserFacade implements UserFacadeLocal {

    private UserService userService;
    private UserRepository userRepository;
    @EJB
    private CareerService careerService;
    @EJB
    private CareerRepository careerRepository;
    private RolUserService rolUserService;
    @EJB
    private RolUserRepository rolUserRepository;
    
    @EJB
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @EJB
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @EJB
    public void setCareerService(CareerService careerService) {
        this.careerService = careerService;
    }

    @EJB
    public void setCareerRepository(CareerRepository careerRepository) {
        this.careerRepository = careerRepository;
    }

    @EJB
    public void setRolUserService(RolUserService rolUserService) {
        this.rolUserService = rolUserService;
    }

    @EJB
    public void setRolUserRepository(RolUserRepository rolUserRepository) {
        this.rolUserRepository = rolUserRepository;
    }
    
    @Override
    public List<User> getAuthenticatedUser() throws UserException{
        return userService.getAuthenticatedUser();
    }
    
    @Override
    public User createUser(User user) throws UserException {
        return userService.createUser(user);
    }

    @Override
    public User updateUser(User user) throws UserException {
        return userService.updateUser(user);
    }

    @Override
    public List<User> getUser(User user) throws UserException {
        return userRepository.getUser(user);
    }

    @Override
    public Career createCareer(Career career) throws UserException {
        return careerService.createCareer(career);
    }

    @Override
    public Career updateCareer(Career career) throws UserException {
        return careerService.updateCareer(career);
    }

    @Override
    public List<Career> getCareer(Career career) throws UserException {
        return careerRepository.getCareer(career);
    }

    @Override
    public RolUser createRolUser(RolUser rolUser) throws UserException {
        return rolUserService.createRolUser(rolUser);
    }

    @Override
    public RolUser updateRolUser(RolUser rolUser) throws UserException {
        return rolUserService.updateRolUser(rolUser);
    }

    @Override
    public List<RolUser> getRolUser(RolUser rolUser) throws UserException {
        return rolUserRepository.getRolUser(rolUser);
    }
    
    @Override
    public List<User> getUserEstudent() throws UserException {
        User user = new User();
        Optional<RolUser> rolUser =  rolUserRepository.findByIdRolUser(1);
        user.setRolUser(rolUser.get());
        
        return userRepository.getUser(user);
    }

    @Override
    public List<Career> getAllCareer(){
        return careerRepository.getAllCareer();
    }
    
    @Override
    public List<RolUser> getAllRolUser(){
        return rolUserRepository.getAllRolUser();
    }
    
    @Override
    public User resetPassword(User user) throws UserException,NoSuchAlgorithmException{
        return userService.resetPassword(user);
    }
}
