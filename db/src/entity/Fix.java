/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Thilina
 */
@Entity
@Table(name = "fix")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fix.findAll", query = "SELECT f FROM Fix f"),
    @NamedQuery(name = "Fix.findByFixId", query = "SELECT f FROM Fix f WHERE f.fixId = :fixId")})
public class Fix implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "fix_id")
    private String fixId;

    public Fix() {
    }

    public Fix(String fixId) {
        this.fixId = fixId;
    }

    public String getFixId() {
        return fixId;
    }

    public void setFixId(String fixId) {
        this.fixId = fixId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fixId != null ? fixId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fix)) {
            return false;
        }
        Fix other = (Fix) object;
        if ((this.fixId == null && other.fixId != null) || (this.fixId != null && !this.fixId.equals(other.fixId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Fix[ fixId=" + fixId + " ]";
    }
    
}
