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
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public void setPbkdf2PasswordHash(Pbkdf2PasswordHash pbkdf2PasswordHash) {
        this.pbkdf2PasswordHash = pbkdf2PasswordHash;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public User createUser(User user) throws UserException {
        if (user == null) {
            throw new UserException("User is null");
        }
        user.setPassword(encryptPass(user.getPassword()));
        try {
            entityManager.persist(user);
        } catch (Exception e) {
            System.out.println("erro persistencia");
        }
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
            updateUser.setPassword(encryptPass(user.getPassword()));
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

    public List<User> getAuthenticatedUser() throws UserException {
        String carnet = securityContext.getCallerPrincipal().getName();
        return userRepository.getUser(new User(Integer.parseInt(carnet), null, null, null, null, null, null, null));
    }

//    public Optional<User> getLoggedInUser() throws UserException {
//        String carnet = securityContext.getCallerPrincipal().getName();
//        return userRepository.getUserByCarnet(Integer.parseInt(carnet));
//    }
    public User resetPassword(User user) throws UserException, NoSuchAlgorithmException {

        System.out.println("----------");
        String[] symbols = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
        int length = 10;
        Random random = SecureRandom.getInstanceStrong(); // as of JDK 8, this should return the strongest algorithm available to the JVM
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int indexRandom = random.nextInt(symbols.length);
            sb.append(symbols[indexRandom]);
        }
        User userUpdate = new User();
        userUpdate.setCarnet(user.getCarnet());
        String password = encryptPass(sb.toString());
        userUpdate.setPassword(password);
        return updateUser(userUpdate);

    }

    /**
     * This method return a random password base o UUID, it most be unique
     *
     * @return
     */
    public String newPassword() {
        return UUID.randomUUID().toString();
    }

    private String encryptPass(String pass) {
        char passwordInput[] = pass.toCharArray();
        Map<String, String> map = new HashMap<>();
        map.put("Pbkdf2PasswordHash.Iterations", "3072");
        map.put("Pbkdf2PasswordHash.Algorithm", "PBKDF2WithHmacSHA256");
        map.put("Pbkdf2PasswordHash.SaltSizeBytes", "64");
        pbkdf2PasswordHash.initialize(map);
        return pbkdf2PasswordHash.generate(passwordInput);
    }

}
