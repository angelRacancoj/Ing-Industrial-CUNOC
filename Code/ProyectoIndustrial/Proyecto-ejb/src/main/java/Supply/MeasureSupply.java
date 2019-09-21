package Supply;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(
        name = "MEDIDA_INSUMO"
)
public class MeasureSupply implements Serializable {
    
@EmbeddedId
private MeasureSupplyPK id;

    public MeasureSupply() {
    }
    
    public MeasureSupply(MeasureSupplyPK id) {
        this.id = id;
    }

    public MeasureSupplyPK getId() {
        return id;
    }

    public void setId(MeasureSupplyPK id) {
        this.id = id;
    }
    
}
