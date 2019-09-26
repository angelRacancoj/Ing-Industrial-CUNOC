package Supply;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(
        name = "MEASURE"
)
public class Measure implements Serializable{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "id_measure")
    private Integer idMeasure;
    @Column(name = "name")
    private String name;
    
    @OneToMany(mappedBy = "measure_id")
    private Collection<Supply> SupplyCollection;

    public Measure() {
    }

    public Measure(Integer idMeasure, String name, Collection<Supply> SupplyCollection) {
        this.idMeasure = idMeasure;
        this.name = name;
        this.SupplyCollection = SupplyCollection;
    }

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

    public Collection<Supply> getSupplyCollection() {
        return SupplyCollection;
    }

    public void setSupplyCollection(Collection<Supply> SupplyCollection) {
        this.SupplyCollection = SupplyCollection;
    }    
}