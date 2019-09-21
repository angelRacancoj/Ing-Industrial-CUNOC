package User;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(
        name = "USUARIO"
)
public class User implements Serializable{
    @Id
    @Column(name = "carnet")
    private Integer carnet;
    @Column(name = "nombre")
    private String name;
    @Column(name = "correo_electronico")
    private String email;
    @Column(name = "telefono")
    private Integer phone;
    @Column(name = "contrasenia")
    private String password;
    @Column(name = "estado")
    private Integer state;
    @ManyToOne
    private RolUser rolUser;
    @ManyToOne
    private Career career;
    
    public User(){
    }
    
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

    public void setCarnet(Integer carnet) {
        this.carnet = carnet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public RolUser getRolUser() {
        return rolUser;
    }

    public void setRolUser(RolUser rolUser) {
        this.rolUser = rolUser;
    }

    public Career getCareer() {
        return career;
    }

    public void setCareer(Career career) {
        this.career = career;
    }

    
    
}