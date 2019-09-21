package Modify;

import Supply.Supply;
import User.User;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author angelrg
 */
@Entity
@Table(
        name = "MODIFY_SUPPLY"
)
public class ModifySupply implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_modify_supply")
    private Integer idModifySupply;
    @ManyToOne(optional = false)
    private User user;
    @ManyToOne(optional = false)
    private Supply supply;
    @Column(columnDefinition = "ENUM('POR_FALTANTE','POR_ROBO','ATRIBUTOS')")
    @Enumerated(EnumType.STRING)
    private ModificationType modifyType;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "note")
    private String note;

    public ModifySupply() {
    }

    public ModifySupply(Integer idModifySupply, User user, Supply supply, ModificationType modifyType, Integer quantity, Date date, String note) {
        this.idModifySupply = idModifySupply;
        this.user = user;
        this.supply = supply;
        this.modifyType = modifyType;
        this.quantity = quantity;
        this.date = date;
        this.note = note;
    }

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

    public ModificationType getmodifyType() {
        return modifyType;
    }

    public void setmodifyType(ModificationType modifyType) {
        this.modifyType = modifyType;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}
