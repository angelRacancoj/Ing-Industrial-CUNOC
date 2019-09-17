package Group;

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
public class Group {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "id_grupo")
    private Integer idGroup;
    @Column(name = "informacion")
    private String infomation;
    @Column(name = "seccion", lenght = 2)
    private String section;

    public Group() {
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
