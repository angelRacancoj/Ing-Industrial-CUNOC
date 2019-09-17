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
@Table(name = "ETAPA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Etapa.findAll", query = "SELECT e FROM Etapa e"),
    @NamedQuery(name = "Etapa.findByIdEtapa", query = "SELECT e FROM Etapa e WHERE e.idEtapa = :idEtapa"),
    @NamedQuery(name = "Etapa.findByNombre", query = "SELECT e FROM Etapa e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Etapa.findByDescripcion", query = "SELECT e FROM Etapa e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "Etapa.findByLineaDeProduccionId", query = "SELECT e FROM Etapa e WHERE e.lineaDeProduccionId = :lineaDeProduccionId"),
    @NamedQuery(name = "Etapa.findByTiempoMinutos", query = "SELECT e FROM Etapa e WHERE e.tiempoMinutos = :tiempoMinutos")})
public class Etapa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_etapa")
    private Integer idEtapa;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "linea_de_produccion_id")
    private int lineaDeProduccionId;
    @Basic(optional = false)
    @Column(name = "tiempo_minutos")
    private int tiempoMinutos;

    public Etapa() {
    }

    public Etapa(Integer idEtapa) {
        this.idEtapa = idEtapa;
    }

    public Etapa(Integer idEtapa, String nombre, String descripcion, int lineaDeProduccionId, int tiempoMinutos) {
        this.idEtapa = idEtapa;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.lineaDeProduccionId = lineaDeProduccionId;
        this.tiempoMinutos = tiempoMinutos;
    }

    public Integer getIdEtapa() {
        return idEtapa;
    }

    public void setIdEtapa(Integer idEtapa) {
        this.idEtapa = idEtapa;
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

    public int getLineaDeProduccionId() {
        return lineaDeProduccionId;
    }

    public void setLineaDeProduccionId(int lineaDeProduccionId) {
        this.lineaDeProduccionId = lineaDeProduccionId;
    }

    public int getTiempoMinutos() {
        return tiempoMinutos;
    }

    public void setTiempoMinutos(int tiempoMinutos) {
        this.tiempoMinutos = tiempoMinutos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEtapa != null ? idEtapa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Etapa)) {
            return false;
        }
        Etapa other = (Etapa) object;
        if ((this.idEtapa == null && other.idEtapa != null) || (this.idEtapa != null && !this.idEtapa.equals(other.idEtapa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.Industrial.Etapa[ idEtapa=" + idEtapa + " ]";
    }
    
}
