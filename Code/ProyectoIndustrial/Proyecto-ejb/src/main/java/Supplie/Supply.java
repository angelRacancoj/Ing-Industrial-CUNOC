
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(
        name = "INSUMO"
)
public class Supply {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Integer code;
    @Column(name = "nombre", insertable = true, updatable = true)
    private String name;
    @Column(name = "fecha_caducidad", insertable = true, updatable = true)
    @Temporal(TemporalType.DATE)
    private Date expirationDate;
    @Column(name = "fecha_ingreso", insertable = true, updatable = true)
    @Temporal(TemporalType.DATE)
    private Date dateOfAdmission;
    @Column(name = "costo",scale = 2, insertable = true, updatable = true)
    private double cost;
    @Column(name = "cantidad",scale = 2, insertable = true, updatable = true)
    private double quantity;
    @Column(name = "disponibilidad", insertable = true, updatable = true)
    private boolean availability;
    @Column(name = "descripcion", insertable = true, updatable = true)
    private String description;

    public Supply() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Date getDateOfAdmission() {
        return dateOfAdmission;
    }

    public void setDateOfAdmission(Date dateOfAdmission) {
        this.dateOfAdmission = dateOfAdmission;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
