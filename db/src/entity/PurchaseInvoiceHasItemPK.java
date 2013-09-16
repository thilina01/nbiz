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
public class PurchaseInvoiceHasItemPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "purchase_invoice_inv_no")
    private String purchaseInvoiceInvNo;
    @Basic(optional = false)
    @Column(name = "purchase_invoice_supplier_code")
    private String purchaseInvoiceSupplierCode;
    @Basic(optional = false)
    @Column(name = "item_code")
    private String itemCode;

    public PurchaseInvoiceHasItemPK() {
    }

    public PurchaseInvoiceHasItemPK(String purchaseInvoiceInvNo, String purchaseInvoiceSupplierCode, String itemCode) {
        this.purchaseInvoiceInvNo = purchaseInvoiceInvNo;
        this.purchaseInvoiceSupplierCode = purchaseInvoiceSupplierCode;
        this.itemCode = itemCode;
    }

    public String getPurchaseInvoiceInvNo() {
        return purchaseInvoiceInvNo;
    }

    public void setPurchaseInvoiceInvNo(String purchaseInvoiceInvNo) {
        this.purchaseInvoiceInvNo = purchaseInvoiceInvNo;
    }

    public String getPurchaseInvoiceSupplierCode() {
        return purchaseInvoiceSupplierCode;
    }

    public void setPurchaseInvoiceSupplierCode(String purchaseInvoiceSupplierCode) {
        this.purchaseInvoiceSupplierCode = purchaseInvoiceSupplierCode;
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
        hash += (purchaseInvoiceInvNo != null ? purchaseInvoiceInvNo.hashCode() : 0);
        hash += (purchaseInvoiceSupplierCode != null ? purchaseInvoiceSupplierCode.hashCode() : 0);
        hash += (itemCode != null ? itemCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PurchaseInvoiceHasItemPK)) {
            return false;
        }
        PurchaseInvoiceHasItemPK other = (PurchaseInvoiceHasItemPK) object;
        if ((this.purchaseInvoiceInvNo == null && other.purchaseInvoiceInvNo != null) || (this.purchaseInvoiceInvNo != null && !this.purchaseInvoiceInvNo.equals(other.purchaseInvoiceInvNo))) {
            return false;
        }
        if ((this.purchaseInvoiceSupplierCode == null && other.purchaseInvoiceSupplierCode != null) || (this.purchaseInvoiceSupplierCode != null && !this.purchaseInvoiceSupplierCode.equals(other.purchaseInvoiceSupplierCode))) {
            return false;
        }
        if ((this.itemCode == null && other.itemCode != null) || (this.itemCode != null && !this.itemCode.equals(other.itemCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ent.PurchaseInvoiceHasItemPK[purchaseInvoiceInvNo=" + purchaseInvoiceInvNo + ", purchaseInvoiceSupplierCode=" + purchaseInvoiceSupplierCode + ", itemCode=" + itemCode + "]";
    }

}
