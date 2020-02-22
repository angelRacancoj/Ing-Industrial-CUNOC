/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Design;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author angelrg
 */
@Entity
@Table(name = "design_data")
public class DesignData implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "iddesign_data")
    private Integer iddesignData;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "designData")
    private List<Design> designList;

    public DesignData() {
    }

    public DesignData(Integer iddesignData) {
        this.iddesignData = iddesignData;
    }

    public DesignData(Integer iddesignData, String name) {
        this.iddesignData = iddesignData;
        this.name = name;
    }

    public Integer getIddesignData() {
        return iddesignData;
    }

    public void setIddesignData(Integer iddesignData) {
        this.iddesignData = iddesignData;
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
    public List<Design> getDesignList() {
        return designList;
    }

    public void setDesignList(List<Design> designList) {
        this.designList = designList;
    }

}
