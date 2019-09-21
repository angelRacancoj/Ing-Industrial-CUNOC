package Production;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(
        name = "INSUMO_NECESARIO"
)

public class NecessarySupply {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "id_insumo_necesario")
    private Integer idNecessarySupply;

    public Integer getIdNecessarySupply() {
        return idNecessarySupply;
    }

    public void setIdNecessarySupply(Integer idNecessarySupply) {
        this.idNecessarySupply = idNecessarySupply;
    }
    
    
    
}
