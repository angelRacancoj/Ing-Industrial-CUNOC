package Production;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(
        name = "COMENTARIO"
)

public class Commentary implements Serializable{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "id_comentario")
    private Integer idCommentary;
    @Column(name = "texto")
    private String text;
    @ManyToOne
    private Paso paso;

    public Commentary() {
    }

    public Commentary(Integer idCommentary, String text, Paso paso) {
        this.idCommentary = idCommentary;
        this.text = text;
        this.paso = paso;
    }
    
    
    

    public Integer getIdCommentary() {
        return idCommentary;
    }

    public void setIdCommentary(Integer idCommentary) {
        this.idCommentary = idCommentary;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Paso getPaso() {
        return paso;
    }

    public void setPaso(Paso paso) {
        this.paso = paso;
    }
    
    
   
}
