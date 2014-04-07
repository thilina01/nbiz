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
public class CanceledInvoiceHasItemPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "canceled_invoice_inv_no")
    private String canceledInvoiceInvNo;
    @Basic(optional = false)
    @Column(name = "item_code")
    private String itemCode;

    public CanceledInvoiceHasItemPK() {
    }

    public CanceledInvoiceHasItemPK(String canceledInvoiceInvNo, String itemCode) {
        this.canceledInvoiceInvNo = canceledInvoiceInvNo;
        this.itemCode = itemCode;
    }

    public String getCanceledInvoiceInvNo() {
        return canceledInvoiceInvNo;
    }

    public void setCanceledInvoiceInvNo(String canceledInvoiceInvNo) {
        this.canceledInvoiceInvNo = canceledInvoiceInvNo;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (canceledInvoiceInvNo != null ? canceledInvoiceInvNo.hashCode() : 0);
        hash += (itemCode != null ? itemCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CanceledInvoiceHasItemPK)) {
            return false;
        }
        CanceledInvoiceHasItemPK other = (CanceledInvoiceHasItemPK) object;
        if ((this.canceledInvoiceInvNo == null && other.canceledInvoiceInvNo != null) || (this.canceledInvoiceInvNo != null && !this.canceledInvoiceInvNo.equals(other.canceledInvoiceInvNo))) {
            return false;
        }
        if ((this.itemCode == null && other.itemCode != null) || (this.itemCode != null && !this.itemCode.equals(other.itemCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return util.ToString.get(this);
    }

}
