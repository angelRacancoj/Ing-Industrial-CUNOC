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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author daniel
 */
@Entity
@Table(name = "PRODUCCION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produccion.findAll", query = "SELECT p FROM Produccion p"),
    @NamedQuery(name = "Produccion.findByIdLineaProduccion", query = "SELECT p FROM Produccion p WHERE p.idLineaProduccion = :idLineaProduccion"),
    @NamedQuery(name = "Produccion.findByNombre", query = "SELECT p FROM Produccion p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Produccion.findByEstado", query = "SELECT p FROM Produccion p WHERE p.estado = :estado"),
    @NamedQuery(name = "Produccion.findByUnidades", query = "SELECT p FROM Produccion p WHERE p.unidades = :unidades"),
    @NamedQuery(name = "Produccion.findByCalificacion", query = "SELECT p FROM Produccion p WHERE p.calificacion = :calificacion"),
    @NamedQuery(name = "Produccion.findByPrecioLote", query = "SELECT p FROM Produccion p WHERE p.precioLote = :precioLote"),
    @NamedQuery(name = "Produccion.findByProductoId", query = "SELECT p FROM Produccion p WHERE p.productoId = :productoId")})
public class Produccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_linea_produccion")
    private Integer idLineaProduccion;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "estado")
    private boolean estado;
    @Basic(optional = false)
    @Column(name = "unidades")
    private int unidades;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "calificacion")
    private Double calificacion;
    @Column(name = "precio_lote")
    private Double precioLote;
    @Basic(optional = false)
    @Column(name = "producto_id")
    private int productoId;

    public Produccion() {
    }

    public Produccion(Integer idLineaProduccion) {
        this.idLineaProduccion = idLineaProduccion;
    }

    public Produccion(Integer idLineaProduccion, String nombre, boolean estado, int unidades, int productoId) {
        this.idLineaProduccion = idLineaProduccion;
        this.nombre = nombre;
        this.estado = estado;
        this.unidades = unidades;
        this.productoId = productoId;
    }

    public Integer getIdLineaProduccion() {
        return idLineaProduccion;
    }

    public void setIdLineaProduccion(Integer idLineaProduccion) {
        this.idLineaProduccion = idLineaProduccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public Double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Double calificacion) {
        this.calificacion = calificacion;
    }

    public Double getPrecioLote() {
        return precioLote;
    }

    public void setPrecioLote(Double precioLote) {
        this.precioLote = precioLote;
    }

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLineaProduccion != null ? idLineaProduccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produccion)) {
            return false;
        }
        Produccion other = (Produccion) object;
        if ((this.idLineaProduccion == null && other.idLineaProduccion != null) || (this.idLineaProduccion != null && !this.idLineaProduccion.equals(other.idLineaProduccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.Industrial.Produccion[ idLineaProduccion=" + idLineaProduccion + " ]";
    }
    
}
