package User;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(
        name = "CAREER"
)
public class Career implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_career")
    private Integer idCareer;
    @Column(name = "name_career")
    private String name;
    
    public Career(Integer idCareer, String name) {
        this.idCareer = idCareer;
        this.name = name;
    }
    public Career(){
    }
    public Career(String name){
        this.name=name;
    }
    
    public Integer getIdCareer() {
        return idCareer;
    }

    public void setIdCareer(Integer idCareer) {
        this.idCareer = idCareer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}