package Production;

import Supply.Supply;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(
        name = "NECESSARY_SUPPLY"
)

public class NecessarySupply implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "id_necessary_supply")
    private Integer idNecessarySupply;
    @JoinColumn(name = "step_id", referencedColumnName = "id_step")
    @ManyToOne(optional = false)
    private Step step_id;
    @JoinColumn(name = "supply_code", referencedColumnName = "code")
    @ManyToOne(optional = false)
    private Supply supply_code;
    @Column(name = "quantity", scale = 2)
    private Double quantity;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof NecessarySupply)) {
            return false;
        }
        NecessarySupply necessarySupply = (NecessarySupply) o;
        return Objects.equals(getIdNecessarySupply(), necessarySupply.getIdNecessarySupply());

    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdNecessarySupply());

    }

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

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

}
