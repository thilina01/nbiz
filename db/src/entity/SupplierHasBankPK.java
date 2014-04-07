/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Thilina Ranathunga
 */
@Embeddable
public class SupplierHasBankPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "supplier_code")
    private String supplierCode;
    @Basic(optional = false)
    @Column(name = "bank_code")
    private String bankCode;

    public SupplierHasBankPK() {
    }

    public SupplierHasBankPK(String supplierCode, String bankCode) {
        this.supplierCode = supplierCode;
        this.bankCode = bankCode;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (supplierCode != null ? supplierCode.hashCode() : 0);
        hash += (bankCode != null ? bankCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SupplierHasBankPK)) {
            return false;
        }
        SupplierHasBankPK other = (SupplierHasBankPK) object;
        if ((this.supplierCode == null && other.supplierCode != null) || (this.supplierCode != null && !this.supplierCode.equals(other.supplierCode))) {
            return false;
        }
        if ((this.bankCode == null && other.bankCode != null) || (this.bankCode != null && !this.bankCode.equals(other.bankCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return util.ToString.get(this);
    }

}
