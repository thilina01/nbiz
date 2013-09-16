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
public class PurchaseInvoicePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "inv_no")
    private String invNo;
    @Basic(optional = false)
    @Column(name = "supplier_code")
    private String supplierCode;

    public PurchaseInvoicePK() {
    }

    public PurchaseInvoicePK(String invNo, String supplierCode) {
        this.invNo = invNo;
        this.supplierCode = supplierCode;
    }

    public String getInvNo() {
        return invNo;
    }

    public void setInvNo(String invNo) {
        this.invNo = invNo;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invNo != null ? invNo.hashCode() : 0);
        hash += (supplierCode != null ? supplierCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PurchaseInvoicePK)) {
            return false;
        }
        PurchaseInvoicePK other = (PurchaseInvoicePK) object;
        if ((this.invNo == null && other.invNo != null) || (this.invNo != null && !this.invNo.equals(other.invNo))) {
            return false;
        }
        if ((this.supplierCode == null && other.supplierCode != null) || (this.supplierCode != null && !this.supplierCode.equals(other.supplierCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ent.PurchaseInvoicePK[invNo=" + invNo + ", supplierCode=" + supplierCode + "]";
    }

}
