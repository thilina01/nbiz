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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Thilina Ranathunga
 */
@Entity
@Table(name = "bank")
@NamedQueries({
    @NamedQuery(name = "Bank.findAll", query = "SELECT b FROM Bank b"),
    @NamedQuery(name = "Bank.findByCode", query = "SELECT b FROM Bank b WHERE b.code = :code"),
    @NamedQuery(name = "Bank.findByName", query = "SELECT b FROM Bank b WHERE b.name = :name")})
public class Bank implements Serializable, Comparable<Bank> {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bank")
    private Collection<SaleCheque> saleChequeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bank")
    private Collection<SupplierHasBank> supplierHasBankCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bank")
    private Collection<IssuedCash> issuedCashCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bank")
    private Collection<IssuedCheque> issuedChequeCollection;

    public Bank() {
    }

    public Bank(String code) {
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

    public Collection<SaleCheque> getSaleChequeCollection() {
        return saleChequeCollection;
    }

    public void setSaleChequeCollection(Collection<SaleCheque> saleChequeCollection) {
        this.saleChequeCollection = saleChequeCollection;
    }

    public Collection<SupplierHasBank> getSupplierHasBankCollection() {
        return supplierHasBankCollection;
    }

    public void setSupplierHasBankCollection(Collection<SupplierHasBank> supplierHasBankCollection) {
        this.supplierHasBankCollection = supplierHasBankCollection;
    }

    public Collection<IssuedCash> getIssuedCashCollection() {
        return issuedCashCollection;
    }

    public void setIssuedCashCollection(Collection<IssuedCash> issuedCashCollection) {
        this.issuedCashCollection = issuedCashCollection;
    }

    public Collection<IssuedCheque> getIssuedChequeCollection() {
        return issuedChequeCollection;
    }

    public void setIssuedChequeCollection(Collection<IssuedCheque> issuedChequeCollection) {
        this.issuedChequeCollection = issuedChequeCollection;
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
        if (!(object instanceof Bank)) {
            return false;
        }
        Bank other = (Bank) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return code;
    }

    @Override
    public int compareTo(Bank o) {
        return code.compareTo(o.getCode());
    }

}
