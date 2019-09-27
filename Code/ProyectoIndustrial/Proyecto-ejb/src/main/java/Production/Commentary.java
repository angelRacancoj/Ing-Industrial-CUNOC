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
        name = "COMMENTARY"
)

public class Commentary implements Serializable{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "id_commentary")
    private Integer idCommentary;
    @Column(name = "text")
    private String text;
    @ManyToOne
    private Step paso;

    public Commentary() {
    }

    public Commentary(Integer idCommentary, String text, Step paso) {
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

    public Step getStep() {
        return paso;
    }

    public void setStep(Step paso) {
        this.paso = paso;
    }
    
    
   
}
