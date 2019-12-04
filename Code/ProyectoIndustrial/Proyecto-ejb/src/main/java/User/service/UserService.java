package User.service;

import User.User;
import User.exception.UserException;
import User.repository.UserRepository;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import static config.Constants.PERSISTENCE_UNIT_NAME;
import static config.SecurityConstants.PBKDF_ITERATIONS;
import static config.SecurityConstants.PBKDF_SALT_SIZE;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.inject.Inject;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;

@Stateless
@LocalBean
public class UserService {

    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;

    @Resource
    SessionContext securityContext;

    @Inject
    private Pbkdf2PasswordHash pbkdf2PasswordHash;

    @EJB
    UserRepository userRepository;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public User createUser(User user) throws UserException {
        if (user == null) {
            throw new UserException("User is null");
        }
        char passwordInput[] = user.getPassword().toCharArray();
        Map<String, String> map = new HashMap<>();
        map.put("Pbkdf2PasswordHash.Iterations", "3072");
        map.put("Pbkdf2PasswordHash.Algorithm", "PBKDF2WithHmacSHA256");
        map.put("Pbkdf2PasswordHash.SaltSizeBytes", "64");
        pbkdf2PasswordHash.initialize(map);
        String passwordOutput = pbkdf2PasswordHash.generate(passwordInput);
        user.setPassword(passwordOutput);
        entityManager.persist(user);
        return user;
    }

    public User updateUser(User user) throws UserException {
        if (user == null) {
            throw new UserException("User is null");
        }
        User updateUser = entityManager.find(User.class, user.getCarnet());
        if (user.getName() != null) {
            updateUser.setName(user.getName());
        }
        if (user.getEmail() != null) {
            updateUser.setEmail(user.getEmail());
        }
        if (user.getPhone() != null) {
            updateUser.setPhone(user.getPhone());
        }
        if (user.getPassword() != null) {
            updateUser.setPassword(user.getPassword());
        }
        if (user.getState() != null) {
            updateUser.setState(user.getState());
        }
        if (user.getRolUser() != null) {
            updateUser.setRolUser(user.getRolUser());
        }
        if (user.getCareer() != null) {
            updateUser.setCareer(user.getCareer());
        }

        return updateUser;
    }

    public Optional<User> getAuthenticatedUser() {
        String carnet = securityContext.getCallerPrincipal().getName();
        return userRepository.getUserByCarnet(Integer.parseInt(carnet));
    }

}
