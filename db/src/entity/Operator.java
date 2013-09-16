/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "operator")
@NamedQueries({
    @NamedQuery(name = "Operator.findAll", query = "SELECT o FROM Operator o"),
    @NamedQuery(name = "Operator.findByUsername", query = "SELECT o FROM Operator o WHERE o.username = :username"),
    @NamedQuery(name = "Operator.findByPassword", query = "SELECT o FROM Operator o WHERE o.password = :password"),
    @NamedQuery(name = "Operator.findByPower", query = "SELECT o FROM Operator o WHERE o.power = :power"),
    @NamedQuery(name = "Operator.findByCreatedBy", query = "SELECT o FROM Operator o WHERE o.createdBy = :createdBy"),
    @NamedQuery(name = "Operator.findByCreatedDate", query = "SELECT o FROM Operator o WHERE o.createdDate = :createdDate")})
public class Operator implements Serializable, Comparable<Operator> {
    private static final long serialVersionUID = 1L;
    @Id
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
    @JoinTable(name = "operator_has_view_panel", joinColumns = {
        @JoinColumn(name = "operator_username", referencedColumnName = "username")}, inverseJoinColumns = {
        @JoinColumn(name = "view_panel_view_panel", referencedColumnName = "view_panel")})
    @ManyToMany
    private Collection<ViewPanel> viewPanelCollection;
    @JoinColumn(name = "employee_code", referencedColumnName = "code")
    @ManyToOne(optional = false)
    private Employee employee;

    public Operator() {
    }

    public Operator(String username) {
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

    public Collection<ViewPanel> getViewPanelCollection() {
        return viewPanelCollection;
    }

    public void setViewPanelCollection(Collection<ViewPanel> viewPanelCollection) {
        this.viewPanelCollection = viewPanelCollection;
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
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Operator)) {
            return false;
        }
        Operator other = (Operator) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return username;
    }

    @Override
    public int compareTo(Operator o) {
        return username.compareTo(o.getUsername());
    }

}
