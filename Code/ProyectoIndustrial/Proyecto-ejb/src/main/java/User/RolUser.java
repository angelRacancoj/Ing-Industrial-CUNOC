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
        name = "ROL_USUARIO"
)
public class RolUser implements Serializable{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private Integer idRol;
    @Column(name = "nombre")
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