package Production;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
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
        name = "COMMENTARY"
)

public class Commentary implements Serializable{
    
    
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_commentary")
    private Integer idCommentary;
    @Basic(optional = false)
    @Column(name = "commentary")
    private String text;
    @JoinColumn(name = "stage_id", referencedColumnName = "id_stage")
    @ManyToOne(optional = false)
    private Stage stageId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Commentary)) return false;
        Commentary commentary = (Commentary) o;
        return Objects.equals(getIdCommentary(), commentary.getIdCommentary());
        //return idCommentary != null && idCommentary.equals(commentary.getIdCommentary());
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(getIdCommentary());
        //return 1;
    }

    public Commentary() {
    }

    public Commentary(Integer idCommentary, String text, Stage stageId) {
        this.idCommentary = idCommentary;
        this.text = text;
        this.stageId = stageId;
    }
    
    public Commentary(String text, Stage stageId) {
        this.text = text;
        this.stageId = stageId;
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

    public Stage getStageId() {
        return stageId;
    }

    public void setStageId(Stage stageId) {
        this.stageId = stageId;
    }
    
    
   
}
