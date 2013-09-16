/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Thilina Ranathunga
 */
@Entity
@Table(name = "operator_deleted")
@NamedQueries({
    @NamedQuery(name = "OperatorDeleted.findAll", query = "SELECT o FROM OperatorDeleted o"),
    @NamedQuery(name = "OperatorDeleted.findByUsername", query = "SELECT o FROM OperatorDeleted o WHERE o.username = :username"),
    @NamedQuery(name = "OperatorDeleted.findByPassword", query = "SELECT o FROM OperatorDeleted o WHERE o.password = :password"),
    @NamedQuery(name = "OperatorDeleted.findByPower", query = "SELECT o FROM OperatorDeleted o WHERE o.power = :power"),
    @NamedQuery(name = "OperatorDeleted.findByCreatedBy", query = "SELECT o FROM OperatorDeleted o WHERE o.createdBy = :createdBy"),
    @NamedQuery(name = "OperatorDeleted.findByCreatedDate", query = "SELECT o FROM OperatorDeleted o WHERE o.createdDate = :createdDate"),
    @NamedQuery(name = "OperatorDeleted.findByDeletedBy", query = "SELECT o FROM OperatorDeleted o WHERE o.deletedBy = :deletedBy"),
    @NamedQuery(name = "OperatorDeleted.findByDeletedDate", query = "SELECT o FROM OperatorDeleted o WHERE o.deletedDate = :deletedDate")})
public class OperatorDeleted implements Serializable, Comparable<OperatorDeleted> {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "power")
    private Integer power;
    @Column(name = "created_By")
    private String createdBy;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "deleted_by")
    private String deletedBy;
    @Id
    @Basic(optional = false)
    @Column(name = "deleted_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedDate;
    @JoinColumn(name = "employee_code", referencedColumnName = "code")
    @ManyToOne(optional = false)
    private Employee employee;

    public OperatorDeleted() {
    }

    public OperatorDeleted(Date deletedDate) {
        this.deletedDate = deletedDate;
    }

    public OperatorDeleted(Date deletedDate, String username) {
        this.deletedDate = deletedDate;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(String deletedBy) {
        this.deletedBy = deletedBy;
    }

    public Date getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(Date deletedDate) {
        this.deletedDate = deletedDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (deletedDate != null ? deletedDate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OperatorDeleted)) {
            return false;
        }
        OperatorDeleted other = (OperatorDeleted) object;
        if ((this.deletedDate == null && other.deletedDate != null) || (this.deletedDate != null && !this.deletedDate.equals(other.deletedDate))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ent.OperatorDeleted[deletedDate=" + deletedDate + "]";
    }

    @Override
    public int compareTo(OperatorDeleted o) {
        return username.compareTo(o.getUsername());
    }

}
