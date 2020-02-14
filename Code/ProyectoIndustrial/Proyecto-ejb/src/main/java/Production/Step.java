
package Production;

import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author daniel
 */
@Entity
@Table(name = "step")
@XmlRootElement

public class Step implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_step")
    private Integer idStep;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "step_id")
    private List<NecessarySupply> necessarySupplyList;
    @JoinColumn(name = "stage_id", referencedColumnName = "id_stage")
    @ManyToOne(optional = false)
    private Stage stageId;

    public Step() {
    }

    public Step(Integer idStep) {
        this.idStep = idStep;
    }

    public Step(Integer idStep, String name, String description) {
        this.idStep = idStep;
        this.name = name;
        this.description = description;
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

    @XmlTransient
    public List<NecessarySupply> getNecessarySupplyList() {
        return necessarySupplyList;
    }

    public void setNecessarySupplyList(List<NecessarySupply> necessarySupplyList) {
        this.necessarySupplyList = necessarySupplyList;
    }

    public Stage getStageId() {
        return stageId;
    }

    public void setStageId(Stage stageId) {
        this.stageId = stageId;
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
        return "Production.Step[ idStep=" + idStep + " ]";
    }
    
}
