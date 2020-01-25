package Modify;

import Supply.Supply;
import User.User;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

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
    @JoinColumn(name = "carnet_user", referencedColumnName = "carnet")
    private User user;
    @ManyToOne(optional = false)
    @JoinColumn(name = "supply_id", referencedColumnName = "code")
    private Supply supply;
    @Column(columnDefinition = "ENUM('POR_FALTANTE','POR_ROBO','ATRIBUTOS')")
    @Enumerated(EnumType.STRING)
    private ModificationType modifyType;
    @Column(name = "quantity")
    private Double quantity;
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "note")
    private String note;

    public ModifySupply() {
    }

    public ModifySupply(Integer idModifySupply, User user, Supply supply, ModificationType modifyType, Double quantity, LocalDate date, String note) {
        this.idModifySupply = idModifySupply;
        this.user = user;
        this.supply = supply;
        this.modifyType = modifyType;
        this.quantity = quantity;
        this.date = date;
        this.note = note;
    }

    public ModifySupply(User user, Supply supply, ModificationType modifyType, Double quantity, LocalDate date, String note) {
        this.user = user;
        this.supply = supply;
        this.modifyType = modifyType;
        this.quantity = quantity;
        this.date = date;
        this.note = note;
    }
    
    public ModifySupply(User user, Supply supply, ModificationType modifyType, Double quantity, LocalDate date) {
        this.user = user;
        this.supply = supply;
        this.modifyType = modifyType;
        this.quantity = quantity;
        this.date = date;
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

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}
