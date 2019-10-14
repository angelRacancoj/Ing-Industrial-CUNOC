package User;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.criteria.Expression;

@Entity
@Table(
        name = "ROL_USER"
)
public class RolUser implements Serializable{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private Integer idRol;
    @Column(name = "name_rol")
    private String name;
    
    public RolUser(){
    }
    
    public RolUser(Integer idRol,String name){
        this.idRol=idRol;
        this.name=name;
    }

    public Integer getIdRolUser() {
        return idRol;
    }

    public void setIdRolUser(Integer idRol) {
        this.idRol = idRol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}