package Production;

import Supply.Supply;
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
        name = "NECESSARYSUPPLY"
)

public class NecessarySupply implements Serializable{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "idNecessarySupply")
    private Integer idNecessarySupply;
    @ManyToOne
    private Production production;
    @ManyToOne
    private Supply supply;

    public NecessarySupply() {
    }

    public NecessarySupply(Integer idNecessarySupply, Production production, Supply supply) {
        this.idNecessarySupply = idNecessarySupply;
        this.production = production;
        this.supply = supply;
    }
    
    
    public Integer getIdNecessarySupply() {
        return idNecessarySupply;
    }

    public void setIdNecessarySupply(Integer idNecessarySupply) {
        this.idNecessarySupply = idNecessarySupply;
    }

    public Production getProduction() {
        return production;
    }

    public void setProduction(Production produccion) {
        this.production = produccion;
    }

    public Supply getSupply() {
        return supply;
    }

    public void setSupply(Supply supply) {
        this.supply = supply;
    }
    
    
    
}
