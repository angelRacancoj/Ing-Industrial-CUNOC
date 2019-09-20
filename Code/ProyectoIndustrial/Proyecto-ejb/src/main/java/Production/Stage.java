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
@Table(name = "ETAPA")
@XmlRootElement
public class Stage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_etapa")
    private Integer idStage;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String name;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String description;
    @Basic(optional = false)
    @Column(name = "linea_de_produccion_id")
    private int lineProductionId;
    @Basic(optional = false)
    @Column(name = "tiempo_minutos")
    private int timeMinutes;

    public Stage() {
    }

    public Stage(Integer idStage) {
        this.idStage = idStage;
    }

    public Stage(Integer idStage, String name, String description, int lineProductionId, int timeMinutes) {
        this.idStage = idStage;
        this.name = name;
        this.description = description;
        this.lineProductionId = lineProductionId;
        this.timeMinutes = timeMinutes;
    }

    public Integer getIdStage() {
        return idStage;
    }

    public void setIdStage(Integer idStage) {
        this.idStage = idStage;
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

    public int getLineProductionId() {
        return lineProductionId;
    }

    public void setLineProductionId(int lineProductionId) {
        this.lineProductionId = lineProductionId;
    }

    public int getTimeMinutes() {
        return timeMinutes;
    }

    public void setTimeMinutes(int timeMinutes) {
        this.timeMinutes = timeMinutes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idStage != null ? idStage.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stage)) {
            return false;
        }
        Stage other = (Stage) object;
        if ((this.idStage == null && other.idStage != null) || (this.idStage != null && !this.idStage.equals(other.idStage))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.Industrial.Etapa[ idEtapa=" + idStage + " ]";
    }
    
}
