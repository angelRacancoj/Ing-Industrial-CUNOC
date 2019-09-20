package Group;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author angelrg
 */
@Entity
@Table(
        name = "GRUPO"
)
public class Group implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_grupo")
    private Integer idGroup;
    @Column(name = "informacion")
    private String infomation;
    @Column(name = "seccion", length = 2)
    private String section;

    public Group() {
    }

    public Group(Integer idGroup, String infomation, String section) {
        this.idGroup = idGroup;
        this.infomation = infomation;
        this.section = section;
    }

    public Integer getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(Integer idGroup) {
        this.idGroup = idGroup;
    }

    public String getInfomation() {
        return infomation;
    }

    public void setInfomation(String infomation) {
        this.infomation = infomation;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

}
