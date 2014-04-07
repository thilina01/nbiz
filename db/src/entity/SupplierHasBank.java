/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Thilina Ranathunga
 */
@Entity
@Table(name = "supplier_has_bank")
@NamedQueries({
    @NamedQuery(name = "SupplierHasBank.findAll", query = "SELECT s FROM SupplierHasBank s"),
    @NamedQuery(name = "SupplierHasBank.findBySupplierCode", query = "SELECT s FROM SupplierHasBank s WHERE s.supplierHasBankPK.supplierCode = :supplierCode"),
    @NamedQuery(name = "SupplierHasBank.findByBankCode", query = "SELECT s FROM SupplierHasBank s WHERE s.supplierHasBankPK.bankCode = :bankCode"),
    @NamedQuery(name = "SupplierHasBank.findByAccountNumber", query = "SELECT s FROM SupplierHasBank s WHERE s.accountNumber = :accountNumber")})
public class SupplierHasBank implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SupplierHasBankPK supplierHasBankPK;
    @Column(name = "account_number")
    private String accountNumber;
    @JoinColumn(name = "bank_code", referencedColumnName = "code", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Bank bank;
    @JoinColumn(name = "supplier_code", referencedColumnName = "code", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Supplier supplier;

    public SupplierHasBank() {
    }

    public SupplierHasBank(SupplierHasBankPK supplierHasBankPK) {
        this.supplierHasBankPK = supplierHasBankPK;
    }

    public SupplierHasBank(String supplierCode, String bankCode) {
        this.supplierHasBankPK = new SupplierHasBankPK(supplierCode, bankCode);
    }

    public SupplierHasBankPK getSupplierHasBankPK() {
        return supplierHasBankPK;
    }

    public void setSupplierHasBankPK(SupplierHasBankPK supplierHasBankPK) {
        this.supplierHasBankPK = supplierHasBankPK;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (supplierHasBankPK != null ? supplierHasBankPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SupplierHasBank)) {
            return false;
        }
        SupplierHasBank other = (SupplierHasBank) object;
        if ((this.supplierHasBankPK == null && other.supplierHasBankPK != null) || (this.supplierHasBankPK != null && !this.supplierHasBankPK.equals(other.supplierHasBankPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return util.ToString.get(this);
    }

}
