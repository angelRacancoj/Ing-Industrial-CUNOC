package User;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author angelrg
 */
@Entity
@Table(name = "career")
public class Career implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_career")
    private Integer idCareer;
    @Column(name = "name_career")
    private String nameCareer;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCareer")
    private List<User> userList;

    public Career() {
    }

    public Career(Integer idCareer) {
        this.idCareer = idCareer;
    }

    public Career(Integer idCareer, String nameCareer) {
        this.idCareer = idCareer;
        this.nameCareer = nameCareer;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Career)) return false;
        Career career = (Career) o;
        return Objects.equals(getIdCareer(), career.getIdCareer());
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(getIdCareer());
    }
    
    public Integer getIdCareer() {
        return idCareer;
    }

    public void setIdCareer(Integer idCareer) {
        this.idCareer = idCareer;
    }

    public String getNameCareer() {
        return nameCareer;
    }

    public void setNameCareer(String nameCareer) {
        this.nameCareer = nameCareer;
    }

    @XmlTransient
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
    
}
