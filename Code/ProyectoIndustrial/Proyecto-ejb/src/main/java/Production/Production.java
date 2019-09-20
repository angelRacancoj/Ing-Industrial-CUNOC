package Production;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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
@Table(name = "PRODUCCION")
@XmlRootElement
public class Production implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_linea_produccion")
    private Integer idLineProduction;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String name;
    @Basic(optional = false)
    @Column(name = "estado")
    private boolean state;
    @Basic(optional = false)
    @Column(name = "unidades")
    private int unity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "calificacion")
    private Double qualification;
    @Column(name = "precio_lote")
    private Double lotPrice;
    @Basic(optional = false)
    @Column(name = "producto_id")
    private int productId;

    public Production() {
    }

    public Production(Integer idLineaProduccion) {
        this.idLineProduction = idLineaProduccion;
    }

    public Production(Integer idLineaProduccion, String nombre, boolean estado, int unidades, int productoId) {
        this.idLineProduction = idLineaProduccion;
        this.name = nombre;
        this.state = estado;
        this.unity = unidades;
        this.productId = productoId;
    }

    public Integer getIdLineProduction() {
        return idLineProduction;
    }

    public void setIdLineProduction(Integer idLineProduction) {
        this.idLineProduction = idLineProduction;
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

    public Double getLotPrice() {
        return lotPrice;
    }

    public void setLotPrice(Double lotPrice) {
        this.lotPrice = lotPrice;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLineProduction != null ? idLineProduction.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Production)) {
            return false;
        }
        Production other = (Production) object;
        if ((this.idLineProduction == null && other.idLineProduction != null) || (this.idLineProduction != null && !this.idLineProduction.equals(other.idLineProduction))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.Industrial.Produccion[ idLineaProduccion=" + idLineProduction + " ]";
    }
    
}
