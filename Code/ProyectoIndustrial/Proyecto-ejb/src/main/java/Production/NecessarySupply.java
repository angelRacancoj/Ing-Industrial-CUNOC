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
        name = "INSUMO_NECESARIO"
)

public class NecessarySupply implements Serializable{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "id_insumo_necesario")
    private Integer idNecessarySupply;
    @ManyToOne
    private Production produccion;
    @ManyToOne
    private Supply supply;

    public NecessarySupply() {
    }

    public NecessarySupply(Integer idNecessarySupply, Production produccion, Supply supply) {
        this.idNecessarySupply = idNecessarySupply;
        this.produccion = produccion;
        this.supply = supply;
    }
    
    
    public Integer getIdNecessarySupply() {
        return idNecessarySupply;
    }

    public void setIdNecessarySupply(Integer idNecessarySupply) {
        this.idNecessarySupply = idNecessarySupply;
    }

    public Production getProduction() {
        return produccion;
    }

    public void setProduction(Production produccion) {
        this.produccion = produccion;
    }

    public Supply getSupply() {
        return supply;
    }

    public void setSupply(Supply supply) {
        this.supply = supply;
    }
    
    
    
}
