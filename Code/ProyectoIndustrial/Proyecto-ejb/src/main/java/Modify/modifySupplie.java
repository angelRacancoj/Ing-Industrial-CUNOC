package Modify;

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
        name = "MODIFICACION_INSUMO"
)
public class modifySupplie {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "id_modificacion_insumo")
    private Integer idModifySupplie;
    @ManyToOne(optional = false)
    private User user:
    @ManyToOne(optional = false)
    private Supply supply:
    @Column(columnDefinition = "ENUM('POR_FALTANTE','POR_ROBO','ATRIBUTOS')", nullable = false)
    @Enumerated(EnumType.STRING)
    private modifyType status;
    @Column(name = "cantidad", nullable = false)
    private Integer quantity;
    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "nota", insertable = true, updatable = true)
    private String nota;
    
}