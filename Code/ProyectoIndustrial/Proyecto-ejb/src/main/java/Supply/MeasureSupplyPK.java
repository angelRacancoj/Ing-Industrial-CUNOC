package Supply;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MeasureSupplyPK implements Serializable{
    @Column(name = "codigo_insumo")
    private Integer codeSupply;
    @Column(name = "medida_id")
    private Integer idMeasure;

    public MeasureSupplyPK() {
    }

    public MeasureSupplyPK(Integer codeSupply, Integer idMeasure) {
        this.codeSupply = codeSupply;
        this.idMeasure = idMeasure;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.codeSupply);
        hash = 59 * hash + Objects.hashCode(this.idMeasure);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MeasureSupplyPK other = (MeasureSupplyPK) obj;
        if (!Objects.equals(this.idMeasure, other.idMeasure)) {
            return false;
        }
        if (!Objects.equals(this.codeSupply, other.codeSupply)) {
            return false;
        }
        return true;
    }

    public Integer getCodeSupply() {
        return codeSupply;
    }

    public void setCodeSupply(Integer codeSupply) {
        this.codeSupply = codeSupply;
    }

    public Integer getIdMeasure() {
        return idMeasure;
    }

    public void setIdMeasure(Integer idMeasure) {
        this.idMeasure = idMeasure;
    }
    
}