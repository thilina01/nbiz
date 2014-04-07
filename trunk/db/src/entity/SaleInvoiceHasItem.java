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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Thilina
 */
@Entity
@Table(name = "sale_invoice_has_item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SaleInvoiceHasItem.findAll", query = "SELECT s FROM SaleInvoiceHasItem s"),
    @NamedQuery(name = "SaleInvoiceHasItem.findBySaleInvoiceInvNo", query = "SELECT s FROM SaleInvoiceHasItem s WHERE s.saleInvoiceHasItemPK.saleInvoiceInvNo = :saleInvoiceInvNo"),
    @NamedQuery(name = "SaleInvoiceHasItem.findByItemCode", query = "SELECT s FROM SaleInvoiceHasItem s WHERE s.saleInvoiceHasItemPK.itemCode = :itemCode"),
    @NamedQuery(name = "SaleInvoiceHasItem.findByRate", query = "SELECT s FROM SaleInvoiceHasItem s WHERE s.rate = :rate"),
    @NamedQuery(name = "SaleInvoiceHasItem.findByQuantity", query = "SELECT s FROM SaleInvoiceHasItem s WHERE s.quantity = :quantity"),
    @NamedQuery(name = "SaleInvoiceHasItem.findByDiscount", query = "SELECT s FROM SaleInvoiceHasItem s WHERE s.discount = :discount"),
    @NamedQuery(name = "SaleInvoiceHasItem.findByCost", query = "SELECT s FROM SaleInvoiceHasItem s WHERE s.cost = :cost")})
public class SaleInvoiceHasItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SaleInvoiceHasItemPK saleInvoiceHasItemPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "rate")
    private Double rate;
    @Column(name = "quantity")
    private Double quantity;
    @Column(name = "discount")
    private Double discount;
    @Column(name = "cost")
    private Double cost;
    @JoinColumn(name = "sale_invoice_inv_no", referencedColumnName = "inv_no", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SaleInvoice saleInvoice;
    @JoinColumn(name = "item_code", referencedColumnName = "code", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Item item;

    public SaleInvoiceHasItem() {
    }

    public SaleInvoiceHasItem(SaleInvoiceHasItemPK saleInvoiceHasItemPK) {
        this.saleInvoiceHasItemPK = saleInvoiceHasItemPK;
    }

    public SaleInvoiceHasItem(String saleInvoiceInvNo, String itemCode) {
        this.saleInvoiceHasItemPK = new SaleInvoiceHasItemPK(saleInvoiceInvNo, itemCode);
    }

    public SaleInvoiceHasItemPK getSaleInvoiceHasItemPK() {
        return saleInvoiceHasItemPK;
    }

    public void setSaleInvoiceHasItemPK(SaleInvoiceHasItemPK saleInvoiceHasItemPK) {
        this.saleInvoiceHasItemPK = saleInvoiceHasItemPK;
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

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public SaleInvoice getSaleInvoice() {
        return saleInvoice;
    }

    public void setSaleInvoice(SaleInvoice saleInvoice) {
        this.saleInvoice = saleInvoice;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (saleInvoiceHasItemPK != null ? saleInvoiceHasItemPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SaleInvoiceHasItem)) {
            return false;
        }
        SaleInvoiceHasItem other = (SaleInvoiceHasItem) object;
        if ((this.saleInvoiceHasItemPK == null && other.saleInvoiceHasItemPK != null) || (this.saleInvoiceHasItemPK != null && !this.saleInvoiceHasItemPK.equals(other.saleInvoiceHasItemPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return util.ToString.get(this);
    }
    
}
