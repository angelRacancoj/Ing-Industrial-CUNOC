package User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(
        name = "CARRERA"
)
public class Career {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "id_carrera")
    private Integer idCareer;
    @Column(name = "nombre_carrera")
    private String name;

    public Career(Integer idCareer, String name) {
        this.idCareer = idCareer;
        this.name = name;
    }
    
    public Integer getIdCareer() {
        return idCareer;
    }

    public void setIdCareer(Integer idCareer) {
        this.idCareer = idCareer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}