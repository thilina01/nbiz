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
@Table(name = "canceled_invoice_has_item")
@NamedQueries({
    @NamedQuery(name = "CanceledInvoiceHasItem.findAll", query = "SELECT c FROM CanceledInvoiceHasItem c"),
    @NamedQuery(name = "CanceledInvoiceHasItem.findByCanceledInvoiceInvNo", query = "SELECT c FROM CanceledInvoiceHasItem c WHERE c.canceledInvoiceHasItemPK.canceledInvoiceInvNo = :canceledInvoiceInvNo"),
    @NamedQuery(name = "CanceledInvoiceHasItem.findByItemCode", query = "SELECT c FROM CanceledInvoiceHasItem c WHERE c.canceledInvoiceHasItemPK.itemCode = :itemCode"),
    @NamedQuery(name = "CanceledInvoiceHasItem.findByRate", query = "SELECT c FROM CanceledInvoiceHasItem c WHERE c.rate = :rate"),
    @NamedQuery(name = "CanceledInvoiceHasItem.findByQuantity", query = "SELECT c FROM CanceledInvoiceHasItem c WHERE c.quantity = :quantity"),
    @NamedQuery(name = "CanceledInvoiceHasItem.findByDiscount", query = "SELECT c FROM CanceledInvoiceHasItem c WHERE c.discount = :discount")})
public class CanceledInvoiceHasItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CanceledInvoiceHasItemPK canceledInvoiceHasItemPK;
    @Column(name = "rate")
    private Double rate;
    @Column(name = "quantity")
    private Double quantity;
    @Column(name = "discount")
    private Double discount;
    @JoinColumn(name = "item_code", referencedColumnName = "code", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Item item;
    @JoinColumn(name = "canceled_invoice_inv_no", referencedColumnName = "inv_no", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CanceledInvoice canceledInvoice;

    public CanceledInvoiceHasItem() {
    }

    public CanceledInvoiceHasItem(CanceledInvoiceHasItemPK canceledInvoiceHasItemPK) {
        this.canceledInvoiceHasItemPK = canceledInvoiceHasItemPK;
    }

    public CanceledInvoiceHasItem(String canceledInvoiceInvNo, String itemCode) {
        this.canceledInvoiceHasItemPK = new CanceledInvoiceHasItemPK(canceledInvoiceInvNo, itemCode);
    }

    public CanceledInvoiceHasItemPK getCanceledInvoiceHasItemPK() {
        return canceledInvoiceHasItemPK;
    }

    public void setCanceledInvoiceHasItemPK(CanceledInvoiceHasItemPK canceledInvoiceHasItemPK) {
        this.canceledInvoiceHasItemPK = canceledInvoiceHasItemPK;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public CanceledInvoice getCanceledInvoice() {
        return canceledInvoice;
    }

    public void setCanceledInvoice(CanceledInvoice canceledInvoice) {
        this.canceledInvoice = canceledInvoice;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (canceledInvoiceHasItemPK != null ? canceledInvoiceHasItemPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CanceledInvoiceHasItem)) {
            return false;
        }
        CanceledInvoiceHasItem other = (CanceledInvoiceHasItem) object;
        if ((this.canceledInvoiceHasItemPK == null && other.canceledInvoiceHasItemPK != null) || (this.canceledInvoiceHasItemPK != null && !this.canceledInvoiceHasItemPK.equals(other.canceledInvoiceHasItemPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ent.CanceledInvoiceHasItem[canceledInvoiceHasItemPK=" + canceledInvoiceHasItemPK + "]";
    }

}
