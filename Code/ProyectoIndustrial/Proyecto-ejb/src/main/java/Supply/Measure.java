package Supply;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(
        name = "MEDIDA"
)
public class Measure {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "id_medida")
    private Integer idMeasure;
    @Column(name = "nombre", insertable = true, updatable = true)
    private String name;

    public Integer getIdMeasure() {
        return idMeasure;
    }

    public void setIdMeasure(Integer idMeasure) {
        this.idMeasure = idMeasure;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
