package Supplie;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(
        name = "MEDIDA_INSUMO"
)
public class MeasureSupply {
    
@EmbeddedId
private MeasureSupplyPK id;

    public MeasureSupplyPK getId() {
        return id;
    }

    public void setId(MeasureSupplyPK id) {
        this.id = id;
    }
    
}
