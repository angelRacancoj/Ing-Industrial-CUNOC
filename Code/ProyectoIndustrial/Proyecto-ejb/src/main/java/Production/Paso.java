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
@Table(name = "PASO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paso.findAll", query = "SELECT p FROM Paso p"),
    @NamedQuery(name = "Paso.findByIdPaso", query = "SELECT p FROM Paso p WHERE p.idPaso = :idPaso"),
    @NamedQuery(name = "Paso.findByNombre", query = "SELECT p FROM Paso p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Paso.findByDescripcion", query = "SELECT p FROM Paso p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "Paso.findByEtapaId", query = "SELECT p FROM Paso p WHERE p.etapaId = :etapaId")})
public class Paso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_paso")
    private Integer idPaso;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "etapa_id")
    private int etapaId;

    public Paso() {
    }

    public Paso(Integer idPaso) {
        this.idPaso = idPaso;
    }

    public Paso(Integer idPaso, String nombre, String descripcion, int etapaId) {
        this.idPaso = idPaso;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.etapaId = etapaId;
    }

    public Integer getIdPaso() {
        return idPaso;
    }

    public void setIdPaso(Integer idPaso) {
        this.idPaso = idPaso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEtapaId() {
        return etapaId;
    }

    public void setEtapaId(int etapaId) {
        this.etapaId = etapaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPaso != null ? idPaso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paso)) {
            return false;
        }
        Paso other = (Paso) object;
        if ((this.idPaso == null && other.idPaso != null) || (this.idPaso != null && !this.idPaso.equals(other.idPaso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.Industrial.Paso[ idPaso=" + idPaso + " ]";
    }
    
}
