package Supply;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(
        name = "SUPPLY"
)
public class Supply implements Serializable{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "code")
    private Integer code;
    @Column(name = "name")
    private String name;
    @Column(name = "expiration_date")
    @Temporal(TemporalType.DATE)
    private LocalDate expirationDate;
    @Column(name = "date_of_admission")
    @Temporal(TemporalType.DATE)
    private LocalDate dateOfAdmission;
    @Column(name = "cost",scale = 2)
    private double cost;
    @Column(name = "quantity",scale = 2)
    private double quantity;
    @Column(name = "availability")
    private boolean availability;
    @Column(name = "description")
    private String description;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "measure_id", referencedColumnName = "id_measure")
    private Supply supply;
    
    public Supply() {
    }

    public Supply(Integer code, String name, LocalDate expirationDate, LocalDate dateOfAdmission, double cost, double quantity, boolean availability, String description, Supply supply) {
        this.code = code;
        this.name = name;
        this.expirationDate = expirationDate;
        this.dateOfAdmission = dateOfAdmission;
        this.cost = cost;
        this.quantity = quantity;
        this.availability = availability;
        this.description = description;
        this.supply = supply;
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

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public LocalDate getDateOfAdmission() {
        return dateOfAdmission;
    }

    public void setDateOfAdmission(LocalDate dateOfAdmission) {
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

    public Supply getSupply() {
        return supply;
    }

    public void setSupply(Supply supply) {
        this.supply = supply;
    }
}