/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Thilina
 */
@Entity
@Table(name = "cash_box")
@NamedQueries({
    @NamedQuery(name = "CashBox.findAll", query = "SELECT c FROM CashBox c"),
    @NamedQuery(name = "CashBox.findById", query = "SELECT c FROM CashBox c WHERE c.id = :id"),
    @NamedQuery(name = "CashBox.findByDescription", query = "SELECT c FROM CashBox c WHERE c.description = :description"),
    @NamedQuery(name = "CashBox.findByBalance", query = "SELECT c FROM CashBox c WHERE c.balance = :balance")})
public class CashBox implements Serializable, Comparable<CashBox> {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Column(name = "description")
    private String description;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "balance")
    private Double balance;
    @Column(name = "max_limit")
    private Double maxLimit;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cashBox")
    private Collection<CashLog> cashLogCollection;

    public CashBox() {
    }

    public CashBox(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Collection<CashLog> getCashLogCollection() {
        return cashLogCollection;
    }

    public void setCashLogCollection(Collection<CashLog> cashLogCollection) {
        this.cashLogCollection = cashLogCollection;
    }

    public Double getMaxLimit() {
        return maxLimit != null ? maxLimit : 0;
    }

    public void setMaxLimit(Double maxLimit) {
        this.maxLimit = maxLimit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CashBox)) {
            return false;
        }
        CashBox other = (CashBox) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return util.ToString.get(this);
    }

    @Override
    public int compareTo(CashBox o) {
        return id.compareTo(o.getId());
    }

}
