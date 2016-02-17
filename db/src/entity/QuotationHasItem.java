/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
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
@Table(name = "quotation_has_item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QuotationHasItem.findAll", query = "SELECT q FROM QuotationHasItem q"),
    @NamedQuery(name = "QuotationHasItem.findByCost", query = "SELECT q FROM QuotationHasItem q WHERE q.cost = :cost"),
    @NamedQuery(name = "QuotationHasItem.findByDiscount", query = "SELECT q FROM QuotationHasItem q WHERE q.discount = :discount"),
    @NamedQuery(name = "QuotationHasItem.findByQuantity", query = "SELECT q FROM QuotationHasItem q WHERE q.quantity = :quantity"),
    @NamedQuery(name = "QuotationHasItem.findByRate", query = "SELECT q FROM QuotationHasItem q WHERE q.rate = :rate"),
    @NamedQuery(name = "QuotationHasItem.findByQuotationQuotationNo", query = "SELECT q FROM QuotationHasItem q WHERE q.quotationHasItemPK.quotationQuotationNo = :quotationQuotationNo"),
    @NamedQuery(name = "QuotationHasItem.findByItemCode", query = "SELECT q FROM QuotationHasItem q WHERE q.quotationHasItemPK.itemCode = :itemCode")})
public class QuotationHasItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected QuotationHasItemPK quotationHasItemPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cost")
    private Double cost;
    @Column(name = "discount")
    private Double discount;
    @Column(name = "quantity")
    private Double quantity;
    @Basic(optional = false)
    @Column(name = "rate")
    private double rate;
    @JoinColumn(name = "item_code", referencedColumnName = "code", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Item item;
    @JoinColumn(name = "quotation_quotation_no", referencedColumnName = "quotation_no", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Quotation quotation;

    public QuotationHasItem() {
    }

    public QuotationHasItem(QuotationHasItemPK quotationHasItemPK) {
        this.quotationHasItemPK = quotationHasItemPK;
    }

    public QuotationHasItem(QuotationHasItemPK quotationHasItemPK, double rate) {
        this.quotationHasItemPK = quotationHasItemPK;
        this.rate = rate;
    }

    public QuotationHasItem(String quotationQuotationNo, String itemCode) {
        this.quotationHasItemPK = new QuotationHasItemPK(quotationQuotationNo, itemCode);
    }

    public QuotationHasItemPK getQuotationHasItemPK() {
        return quotationHasItemPK;
    }

    public void setQuotationHasItemPK(QuotationHasItemPK quotationHasItemPK) {
        this.quotationHasItemPK = quotationHasItemPK;
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

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Quotation getQuotation() {
        return quotation;
    }

    public void setQuotation(Quotation quotation) {
        this.quotation = quotation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (quotationHasItemPK != null ? quotationHasItemPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QuotationHasItem)) {
            return false;
        }
        QuotationHasItem other = (QuotationHasItem) object;
        if ((this.quotationHasItemPK == null && other.quotationHasItemPK != null) || (this.quotationHasItemPK != null && !this.quotationHasItemPK.equals(other.quotationHasItemPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbr.entity.QuotationHasItem[ quotationHasItemPK=" + quotationHasItemPK + " ]";
    }
    
}
