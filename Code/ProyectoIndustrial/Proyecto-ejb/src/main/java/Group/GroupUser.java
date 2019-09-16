package Group;

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
        name = "GRUPO_USUARIO"
)

public class GroupUser {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "id_grupo_usuario")
    private Integer id_group_user;
    @ManytoOne(optional = false)
    private User user;
    @ManytoOne(optional = false)
    private GroupI group;
    @Column(name = "fecha_ingreso", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date admissionDate;

    public GroupUser() {
    }

    public Integer getId_group_user() {
        return id_group_user;
    }

    public void setId_group_user(Integer id_group_user) {
        this.id_group_user = id_group_user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public GroupI getGroup() {
        return group;
    }

    public void setGroup(GroupI group) {
        this.group = group;
    }

    public Date getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }    
    
}