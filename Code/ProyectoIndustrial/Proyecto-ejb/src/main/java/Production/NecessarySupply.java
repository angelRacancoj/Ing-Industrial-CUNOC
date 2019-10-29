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
    private Step step_id;
    @ManyToOne
    private Supply supply_code;

    public NecessarySupply() {
    }

    public NecessarySupply(Integer idNecessarySupply, Step step_id, Supply supply_code) {
        this.idNecessarySupply = idNecessarySupply;
        this.step_id = step_id;
        this.supply_code = supply_code;
    }
    
    public NecessarySupply(Step step_id, Supply supply_code) {
        this.idNecessarySupply = idNecessarySupply;
        this.step_id = step_id;
        this.supply_code = supply_code;
    }
    
    
    public Integer getIdNecessarySupply() {
        return idNecessarySupply;
    }

    public void setIdNecessarySupply(Integer idNecessarySupply) {
        this.idNecessarySupply = idNecessarySupply;
    }

    public Step getStep() {
        return step_id;
    }

    public void setStep(Step step_id) {
        this.step_id = step_id;
    }

    public Supply getSupplyCode() {
        return supply_code;
    }

    public void setSupplyCode(Supply supply_code) {
        this.supply_code = supply_code;
    }
    
    
    
}
