package Modify;

import Supplie.Supply;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author angelrg
 */

@Entity
@Table(
        name = "MODIFICACION_INSUMO"
)
public class modifySupplie {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "id_modificacion_insumo")
    private Integer idModifySupply;
    @ManyToOne(optional = false)
    private User user:
    @ManyToOne(optional = false)
    private Supply supply;
    @Column(columnDefinition = "ENUM('POR_FALTANTE','POR_ROBO','ATRIBUTOS')")
    @Enumerated(EnumType.STRING)
    private modifyType status;
    @Column(name = "cantidad")
    private Integer quantity;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "nota")
    private String nota;

    public Integer getIdModifySupply() {
        return idModifySupply;
    }

    public void setIdModifySupply(Integer idModifySupply) {
        this.idModifySupply = idModifySupply;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Supply getSupply() {
        return supply;
    }

    public void setSupply(Supply supply) {
        this.supply = supply;
    }

    public modifyType getStatus() {
        return status;
    }

    public void setStatus(modifyType status) {
        this.status = status;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }
    
    
}