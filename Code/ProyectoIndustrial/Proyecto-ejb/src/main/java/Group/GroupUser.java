package Group;

import User.User;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author angelrg
 */

@Entity
@Table(
        name = "GRUPO_USUARIO"
)

public class GroupUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_grupo_usuario")
    private Integer idGroupUser;
    @ManyToOne(optional = false)
    private User user;
    @ManyToOne(optional = false)
    private Group group;
    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.DATE)
    private Date admissionDate;

    public GroupUser() {
    }

    public Integer getidGroupUser() {
        return idGroupUser;
    }

    public void setidGroupUser(Integer id_group_user) {
        this.idGroupUser = id_group_user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Date getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }

}
