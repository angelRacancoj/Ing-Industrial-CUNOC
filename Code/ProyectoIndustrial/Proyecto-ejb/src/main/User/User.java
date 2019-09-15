import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(
        name = "USUARIO"
)
public class User {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "carnet")
    private Integer carnet;
    @Column(name = "nombre", insertable = true, updatable = true)
    private String name;
    @Column(name = "correo_electronico", insertable = true, updatable = true)
    private String email;
    @Column(name = "telefono", insertable = true, updatable = true)
    private Integer phone;
    @Column(name = "contrasenia", insertable = true, updatable = true)
    private String password;
    @Column(name = "estado", insertable = true, updatable = true)
    private Integer state;
    @ManytoOne
    private RolUser rolUser;
    @ManytoOne
    private Career career;

    public User(Integer carnet, String name, String email, Integer phone, String password, Integer state, RolUser rolUser, Career career) {
        this.carnet = carnet;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.state = state;
        this.rolUser = rolUser;
        this.career = career;
    }

        
    public Integer getCarnet() {
        return carnet;
    }

    public void setIdRol(Integer carnet) {
        this.carnet = carnet;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
    
}