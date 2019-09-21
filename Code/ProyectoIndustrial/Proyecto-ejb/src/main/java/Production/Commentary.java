package Production;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(
        name = "COMENTARIO"
)

public class Commentary {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "id_comentario")
    private Integer idCommentary;
    @Column(name = "texto", insertable = true, updatable = true)
    private String text;
    

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
    
    
   
}
