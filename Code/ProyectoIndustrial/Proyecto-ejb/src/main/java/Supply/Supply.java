package Supply;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
    private LocalDate expirationDate;
    @Column(name = "date_of_admission")
    private LocalDate dateOfAdmission;
    @Column(name = "cost",scale = 2)
    private Double cost;
    @Column(name = "quantity",scale = 2)
    private Double quantity;
    @Column(name = "availability")
    private Boolean availability;
    @Column(name = "description")
    private String description;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_measure", referencedColumnName = "id_measure")
    private Measure measure;
    
    public Supply() {
    }

    public Supply(Integer code, String name, LocalDate expirationDate, LocalDate dateOfAdmission, Double cost, Double quantity, boolean availability, String description, Measure measure) {
        this.code = code;
        this.name = name;
        this.expirationDate = expirationDate;
        this.dateOfAdmission = dateOfAdmission;
        this.cost = cost;
        this.quantity = quantity;
        this.availability = availability;
        this.description = description;
        this.measure = measure;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Supply)) return false;
        Supply supply = (Supply) o;
        return Objects.equals(getCode(), supply.getCode());
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(getCode());
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

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
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

    public Measure getMeasure() {
        return measure;
    }

    public void setMeasure(Measure measure) {
        this.measure = measure;
    }
}