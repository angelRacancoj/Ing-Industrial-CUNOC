package Production;

import Design.Design;
import Group.GroupIndustrial;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;
import java.time.LocalDate;

/**
 *
 * @author daniel
 * @edit angelrg
 */
@Entity
@Table(name = "production")
public class Production implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "id_production")
    private Integer idProduction;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private LocalDate startDate;
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private LocalDate endDate;
    @Basic(optional = false)
    @Column(name = "state")
    private boolean state;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "qualification")
    private Double qualification;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "init_cost")
    private Double initCost;
    @Column(name = "final_cost")
    private Double finalCost;
    @JoinColumn(name = "design_id", referencedColumnName = "id_design")
    @ManyToOne(optional = false)
    private Design designId;
    @JoinColumn(name = "post_design", referencedColumnName = "id_design")
    @ManyToOne(optional = false)
    private Design postDesign;
    @JoinColumn(name = "group_id", referencedColumnName = "id_group")
    @ManyToOne(optional = false)
    private GroupIndustrial groupId;
    @JoinColumn(name = "product_id", referencedColumnName = "id_product")
    @ManyToOne(optional = false)
    private Product productId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productionId")
    private List<Stage> stageList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProduction")
    private List<ExtraCost> extraCostList;

    public Production() {
    }

    public Production(Integer idProduction) {
        this.idProduction = idProduction;
    }

    public Production(Integer idProduction, String name, LocalDate startDate, boolean state) {
        this.idProduction = idProduction;
        this.name = name;
        this.startDate = startDate;
        this.state = state;
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public Double getQualification() {
        return qualification;
    }

    public void setQualification(Double qualification) {
        this.qualification = qualification;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getInitCost() {
        return initCost;
    }

    public void setInitCost(Double initCost) {
        this.initCost = initCost;
    }

    public Double getFinalCost() {
        return finalCost;
    }

    public void setFinalCost(Double finalCost) {
        this.finalCost = finalCost;
    }

    public Design getDesignId() {
        return designId;
    }

    public void setDesignId(Design designId) {
        this.designId = designId;
    }

    public Design getPostDesign() {
        return postDesign;
    }

    public void setPostDesign(Design postDesign) {
        this.postDesign = postDesign;
    }

    public GroupIndustrial getGroupId() {
        return groupId;
    }

    public void setGroupId(GroupIndustrial groupId) {
        this.groupId = groupId;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    @XmlTransient
    public List<Stage> getStageList() {
        return stageList;
    }

    public void setStageList(List<Stage> stageList) {
        this.stageList = stageList;
    }

    @XmlTransient
    public List<ExtraCost> getExtraCostList() {
        return extraCostList;
    }

    public void setExtraCostList(List<ExtraCost> extraCostList) {
        this.extraCostList = extraCostList;
    }
}
