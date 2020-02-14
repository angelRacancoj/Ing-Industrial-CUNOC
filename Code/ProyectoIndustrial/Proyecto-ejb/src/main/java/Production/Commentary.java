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

public class Commentary implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_commentary")
    private Integer idCommentary;
    @Basic(optional = false)
    @Column(name = "commentary")
    private String text;
    @JoinColumn(name = "id_step", referencedColumnName = "id_step")
    @ManyToOne(optional = false)
    private Step stepId;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Commentary)) {
            return false;
        }
        Commentary commentary = (Commentary) o;
        return Objects.equals(getIdCommentary(), commentary.getIdCommentary());

    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdCommentary());

    }

    public Commentary() {
    }

    public Commentary(String text, Stage stageId) {
        this.text = text;
        this.stepId = stepId;
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

    public Step getStepId() {
        return stepId;
    }

    public void setStepId(Step stepId) {
        this.stepId = stepId;
    }
    

}
