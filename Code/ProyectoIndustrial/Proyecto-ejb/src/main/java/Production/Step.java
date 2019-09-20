package Production;


import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author daniel
 */
@Entity
@Table(name = "PASO")
@XmlRootElement
public class Step implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_paso")
    private Integer idStep;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String name;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String description;
    @Basic(optional = false)
    @Column(name = "etapa_id")
    private int StageId;

    public Step() {
    }

    public Step(Integer idStep) {
        this.idStep = idStep;
    }

    public Step(Integer idStep, String name, String description, int stageId) {
        this.idStep = idStep;
        this.name = name;
        this.description = description;
        this.StageId = stageId;
    }

    public Integer getIdStep() {
        return idStep;
    }

    public void setIdStep(Integer idStep) {
        this.idStep = idStep;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStageId() {
        return StageId;
    }

    public void setStageId(int StageId) {
        this.StageId = StageId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idStep != null ? idStep.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Step)) {
            return false;
        }
        Step other = (Step) object;
        if ((this.idStep == null && other.idStep != null) || (this.idStep != null && !this.idStep.equals(other.idStep))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.Industrial.Paso[ idPaso=" + idStep + " ]";
    }
    
}
