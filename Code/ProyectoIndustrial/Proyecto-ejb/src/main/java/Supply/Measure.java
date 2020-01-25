package Supply;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
    
    @OneToMany(mappedBy = "measure")
    private List<Supply> SupplyCollection = new ArrayList<Supply>();

    public Measure() {
    }

    public Measure(Integer idMeasure, String name, ArrayList<Supply> SupplyCollection) {
        this.idMeasure = idMeasure;
        this.name = name;
        this.SupplyCollection.addAll(SupplyCollection);
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

    public List<Supply> getSupplyCollection() {
        return SupplyCollection;
    }

    public void setSupplyCollection(ArrayList<Supply> SupplyCollection) {
        this.SupplyCollection = SupplyCollection;
    }
}