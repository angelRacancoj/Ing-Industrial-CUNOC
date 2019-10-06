package Production;

import java.io.Serializable;
import java.util.List;
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
@Table(name = "stage")
@XmlRootElement

public class Stage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_stage")
    private Integer idStage;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stageId")
    private List<Commentary> commentaryList;
    @JoinColumn(name = "production_id", referencedColumnName = "id_production")
    @ManyToOne(optional = false)
    private Production productionId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stageId")
    private List<Step> stepList;

    public Stage() {
    }

    public Stage(Integer idStage) {
        this.idStage = idStage;
    }

    public Stage(Integer idStage, String name, String description) {
        this.idStage = idStage;
        this.name = name;
        this.description = description;
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

    @XmlTransient
    public List<Commentary> getCommentaryList() {
        return commentaryList;
    }

    public void setCommentaryList(List<Commentary> commentaryList) {
        this.commentaryList = commentaryList;
    }

    public Production getProductionId() {
        return productionId;
    }

    public void setProductionId(Production productionId) {
        this.productionId = productionId;
    }

    @XmlTransient
    public List<Step> getStepList() {
        return stepList;
    }

    public void setStepList(List<Step> stepList) {
        this.stepList = stepList;
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
        return "Production.Stage[ idStage=" + idStage + " ]";
    }
    
}
