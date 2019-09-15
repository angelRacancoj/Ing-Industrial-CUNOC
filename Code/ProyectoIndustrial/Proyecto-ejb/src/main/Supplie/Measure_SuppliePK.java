
import java.util.Objects;
import javax.persistence.Embeddable;

@Embeddable
public class Measure_SuppliePK {
    private Integer codeSupplie;
    private Integer idMeasure;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.codeSupplie);
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
        final Measure_SuppliePK other = (Measure_SuppliePK) obj;
        if (!Objects.equals(this.idMeasure, other.idMeasure)) {
            return false;
        }
        if (!Objects.equals(this.codeSupplie, other.codeSupplie)) {
            return false;
        }
        return true;
    }

    public Integer getCodeSupplie() {
        return codeSupplie;
    }

    public void setCodeSupplie(Integer codeSupplie) {
        this.codeSupplie = codeSupplie;
    }

    public Integer getIdMeasure() {
        return idMeasure;
    }

    public void setIdMeasure(Integer idMeasure) {
        this.idMeasure = idMeasure;
    }
    
}
