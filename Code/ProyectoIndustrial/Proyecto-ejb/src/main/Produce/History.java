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
        name = "HISTORIAL"
)

public class History {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "historial_id")
    private Integer history_id;
    @Column(name = "fecha_inicio", insertable = true, updatable = false)
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "fecha_fin", insertable = true, updatable = true)
    @Temporal(TemporalType.DATE)
    private Date endDate;
}