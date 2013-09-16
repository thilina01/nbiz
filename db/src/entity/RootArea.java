/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Thilina Ranathunga
 */
@Entity
@Table(name = "root_area")
@NamedQueries({
    @NamedQuery(name = "RootArea.findAll", query = "SELECT r FROM RootArea r"),
    @NamedQuery(name = "RootArea.findByCode", query = "SELECT r FROM RootArea r WHERE r.code = :code"),
    @NamedQuery(name = "RootArea.findByName", query = "SELECT r FROM RootArea r WHERE r.name = :name")})
public class RootArea implements Serializable, Comparable<RootArea> {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;
    @ManyToMany(mappedBy = "rootAreaCollection")
    private Collection<Employee> employeeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rootArea")
    private Collection<Town> townCollection;

    public RootArea() {
    }

    public RootArea(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Employee> getEmployeeCollection() {
        return employeeCollection;
    }

    public void setEmployeeCollection(Collection<Employee> employeeCollection) {
        this.employeeCollection = employeeCollection;
    }

    public Collection<Town> getTownCollection() {
        return townCollection;
    }

    public void setTownCollection(Collection<Town> townCollection) {
        this.townCollection = townCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RootArea)) {
            return false;
        }
        RootArea other = (RootArea) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(RootArea o) {
        return code.compareTo(o.getCode());
    }

}
