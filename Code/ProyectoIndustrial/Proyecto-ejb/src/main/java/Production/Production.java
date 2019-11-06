
package Production;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import Produce.History;
import java.time.LocalDate;

/**
 *
 * @author daniel
 */
@Entity
@Table(name = "production")
@XmlRootElement
public class Production implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_production")
    private Integer idProduction;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "state")
    private boolean state;
    @Basic(optional = false)
    @Column(name = "unity")
    private int unity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "qualification")
    private Double qualification;
    @Column(name = "price_lot")
    private Double priceLot;
    @Basic(optional = false)
    @Column(name = "creation_date")
    @Temporal(TemporalType.DATE)
    private LocalDate creationDate;
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "product_id", referencedColumnName = "id_product")
    @ManyToOne
    private Product productId;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "productionId")
    private List<History> historyList;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "productionId")
    private List<Stage> stageList;

    public Production() {
    }

    public Production(Integer idProduction) {
        this.idProduction = idProduction;
    }

    public Production(Integer idProduction, String name, boolean state, int unity, LocalDate creationDate) {
        this.idProduction = idProduction;
        this.name = name;
        this.state = state;
        this.unity = unity;
        this.creationDate = creationDate;
    }

    public Integer getIdProduction() {
        return idProduction;
    }

    public void setIdProduction(Integer idProduction) {
        this.idProduction = idProduction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public int getUnity() {
        return unity;
    }

    public void setUnity(int unity) {
        this.unity = unity;
    }

    public Double getQualification() {
        return qualification;
    }

    public void setQualification(Double qualification) {
        this.qualification = qualification;
    }

    public Double getPriceLot() {
        return priceLot;
    }

    public void setPriceLot(Double priceLot) {
        this.priceLot = priceLot;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    @XmlTransient
    public List<History> getHistoryList() {
        return historyList;
    }

    public void setHistoryList(List<History> historyList) {
        this.historyList = historyList;
    }

    @XmlTransient
    public List<Stage> getStageList() {
        return stageList;
    }

    public void setStageList(List<Stage> stageList) {
        this.stageList = stageList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProduction != null ? idProduction.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Production)) {
            return false;
        }
        Production other = (Production) object;
        if ((this.idProduction == null && other.idProduction != null) || (this.idProduction != null && !this.idProduction.equals(other.idProduction))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Production.Production[ idProduction=" + idProduction + " ]";
    }
    
}
