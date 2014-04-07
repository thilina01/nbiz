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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Thilina Ranathunga
 */
@Entity
@Table(name = "purchase_invoice_has_item")
@NamedQueries({
    @NamedQuery(name = "PurchaseInvoiceHasItem.findAll", query = "SELECT p FROM PurchaseInvoiceHasItem p"),
    @NamedQuery(name = "PurchaseInvoiceHasItem.findByPurchaseInvoiceInvNo", query = "SELECT p FROM PurchaseInvoiceHasItem p WHERE p.purchaseInvoiceHasItemPK.purchaseInvoiceInvNo = :purchaseInvoiceInvNo"),
    @NamedQuery(name = "PurchaseInvoiceHasItem.findByPurchaseInvoiceSupplierCode", query = "SELECT p FROM PurchaseInvoiceHasItem p WHERE p.purchaseInvoiceHasItemPK.purchaseInvoiceSupplierCode = :purchaseInvoiceSupplierCode"),
    @NamedQuery(name = "PurchaseInvoiceHasItem.findByItemCode", query = "SELECT p FROM PurchaseInvoiceHasItem p WHERE p.purchaseInvoiceHasItemPK.itemCode = :itemCode"),
    @NamedQuery(name = "PurchaseInvoiceHasItem.findByQuantity", query = "SELECT p FROM PurchaseInvoiceHasItem p WHERE p.quantity = :quantity"),
    @NamedQuery(name = "PurchaseInvoiceHasItem.findByCost", query = "SELECT p FROM PurchaseInvoiceHasItem p WHERE p.cost = :cost"),
    @NamedQuery(name = "PurchaseInvoiceHasItem.findByDiscount", query = "SELECT p FROM PurchaseInvoiceHasItem p WHERE p.discount = :discount")})
public class PurchaseInvoiceHasItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PurchaseInvoiceHasItemPK purchaseInvoiceHasItemPK;
    @Column(name = "quantity")
    private Double quantity;
    @Column(name = "cost")
    private Double cost;
    @Column(name = "discount")
    private Double discount;
    @JoinColumn(name = "item_code", referencedColumnName = "code", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Item item;
    @JoinColumns({
        @JoinColumn(name = "purchase_invoice_inv_no", referencedColumnName = "inv_no", insertable = false, updatable = false),
        @JoinColumn(name = "purchase_invoice_supplier_code", referencedColumnName = "supplier_code", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private PurchaseInvoice purchaseInvoice;

    public PurchaseInvoiceHasItem() {
    }

    public PurchaseInvoiceHasItem(PurchaseInvoiceHasItemPK purchaseInvoiceHasItemPK) {
        this.purchaseInvoiceHasItemPK = purchaseInvoiceHasItemPK;
    }

    public PurchaseInvoiceHasItem(String purchaseInvoiceInvNo, String purchaseInvoiceSupplierCode, String itemCode) {
        this.purchaseInvoiceHasItemPK = new PurchaseInvoiceHasItemPK(purchaseInvoiceInvNo, purchaseInvoiceSupplierCode, itemCode);
    }

    public PurchaseInvoiceHasItemPK getPurchaseInvoiceHasItemPK() {
        return purchaseInvoiceHasItemPK;
    }

    public void setPurchaseInvoiceHasItemPK(PurchaseInvoiceHasItemPK purchaseInvoiceHasItemPK) {
        this.purchaseInvoiceHasItemPK = purchaseInvoiceHasItemPK;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
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

    public PurchaseInvoice getPurchaseInvoice() {
        return purchaseInvoice;
    }

    public void setPurchaseInvoice(PurchaseInvoice purchaseInvoice) {
        this.purchaseInvoice = purchaseInvoice;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (purchaseInvoiceHasItemPK != null ? purchaseInvoiceHasItemPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PurchaseInvoiceHasItem)) {
            return false;
        }
        PurchaseInvoiceHasItem other = (PurchaseInvoiceHasItem) object;
        if ((this.purchaseInvoiceHasItemPK == null && other.purchaseInvoiceHasItemPK != null) || (this.purchaseInvoiceHasItemPK != null && !this.purchaseInvoiceHasItemPK.equals(other.purchaseInvoiceHasItemPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return util.ToString.get(this);
    }

}
