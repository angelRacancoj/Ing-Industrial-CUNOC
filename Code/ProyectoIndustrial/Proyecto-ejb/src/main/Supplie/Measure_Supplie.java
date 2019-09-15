 
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(
        name = "MEDIDA_INSUMO"
)
public class Measure_Supplie {
    
@EmbeddedId
private Measure_SuppliePK id;

    public Measure_SuppliePK getId() {
        return id;
    }

    public void setId(Measure_SuppliePK id) {
        this.id = id;
    }
    
}
