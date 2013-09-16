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
 * @author Thilina
 */
@Embeddable
public class SaleInvoiceHasItemPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "sale_invoice_inv_no")
    private String saleInvoiceInvNo;
    @Basic(optional = false)
    @Column(name = "item_code")
    private String itemCode;

    public SaleInvoiceHasItemPK() {
    }

    public SaleInvoiceHasItemPK(String saleInvoiceInvNo, String itemCode) {
        this.saleInvoiceInvNo = saleInvoiceInvNo;
        this.itemCode = itemCode;
    }

    public String getSaleInvoiceInvNo() {
        return saleInvoiceInvNo;
    }

    public void setSaleInvoiceInvNo(String saleInvoiceInvNo) {
        this.saleInvoiceInvNo = saleInvoiceInvNo;
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
        hash += (saleInvoiceInvNo != null ? saleInvoiceInvNo.hashCode() : 0);
        hash += (itemCode != null ? itemCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SaleInvoiceHasItemPK)) {
            return false;
        }
        SaleInvoiceHasItemPK other = (SaleInvoiceHasItemPK) object;
        if ((this.saleInvoiceInvNo == null && other.saleInvoiceInvNo != null) || (this.saleInvoiceInvNo != null && !this.saleInvoiceInvNo.equals(other.saleInvoiceInvNo))) {
            return false;
        }
        if ((this.itemCode == null && other.itemCode != null) || (this.itemCode != null && !this.itemCode.equals(other.itemCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ent.SaleInvoiceHasItemPK[ saleInvoiceInvNo=" + saleInvoiceInvNo + ", itemCode=" + itemCode + " ]";
    }
    
}
