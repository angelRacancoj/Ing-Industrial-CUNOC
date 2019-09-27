package Group;

import User.User;
import java.io.Serializable;
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
import javax.persistence.JoinColumn;

/**
 *
 * @author angelrg
 */
@Entity
@Table(
        name = "GROUP_USER"
)

public class GroupUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_group_user")
    private Integer idGroupUser;
    @ManyToOne(optional = false)
    @JoinColumn(name = "carnet_user", referencedColumnName = "carnet")
    private User user;
    @ManyToOne(optional = false)
    @JoinColumn(name = "group_id", referencedColumnName = "id_group")
    private Group group;
    @Column(name = "admission_date")
    @Temporal(TemporalType.DATE)
    private Date admissionDate;

    public GroupUser() {
    }

    public GroupUser(Integer idGroupUser, User user, Group group, Date admissionDate) {
        this.idGroupUser = idGroupUser;
        this.user = user;
        this.group = group;
        this.admissionDate = admissionDate;
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
