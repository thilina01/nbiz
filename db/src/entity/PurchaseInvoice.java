/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Thilina Ranathunga
 */
@Entity
@Table(name = "purchase_invoice")
@NamedQueries({
    @NamedQuery(name = "PurchaseInvoice.findAll", query = "SELECT p FROM PurchaseInvoice p"),
    @NamedQuery(name = "PurchaseInvoice.findByInvNo", query = "SELECT p FROM PurchaseInvoice p WHERE p.purchaseInvoicePK.invNo = :invNo"),
    @NamedQuery(name = "PurchaseInvoice.findBySupplierCode", query = "SELECT p FROM PurchaseInvoice p WHERE p.purchaseInvoicePK.supplierCode = :supplierCode"),
    @NamedQuery(name = "PurchaseInvoice.findByInvDate", query = "SELECT p FROM PurchaseInvoice p WHERE p.invDate = :invDate"),
    @NamedQuery(name = "PurchaseInvoice.findByAmount", query = "SELECT p FROM PurchaseInvoice p WHERE p.amount = :amount"),
    @NamedQuery(name = "PurchaseInvoice.findByCredit", query = "SELECT p FROM PurchaseInvoice p WHERE p.credit = :credit"),
    @NamedQuery(name = "PurchaseInvoice.findByDiscount", query = "SELECT p FROM PurchaseInvoice p WHERE p.discount = :discount"),
    @NamedQuery(name = "PurchaseInvoice.findByOperator", query = "SELECT p FROM PurchaseInvoice p WHERE p.operator = :operator")})
public class PurchaseInvoice implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PurchaseInvoicePK purchaseInvoicePK;
    @Column(name = "inv_date")
    @Temporal(TemporalType.DATE)
    private Date invDate;
    @Column(name = "amount")
    private Double amount;
    @Column(name = "credit")
    private Double credit;
    @Column(name = "discount")
    private Double discount;
    @Column(name = "operator")
    private String operator;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "purchaseInvoice")
    private Collection<PurchaseInvoiceHasItem> purchaseInvoiceHasItemCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "purchaseInvoice")
    private Collection<IssuedCash> issuedCashCollection;
    @JoinColumn(name = "supplier_code", referencedColumnName = "code", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Supplier supplier;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "purchaseInvoice")
    private Collection<IssuedCheque> issuedChequeCollection;

    public PurchaseInvoice() {
    }

    public PurchaseInvoice(PurchaseInvoicePK purchaseInvoicePK) {
        this.purchaseInvoicePK = purchaseInvoicePK;
    }

    public PurchaseInvoice(String invNo, String supplierCode) {
        this.purchaseInvoicePK = new PurchaseInvoicePK(invNo, supplierCode);
    }

    public PurchaseInvoicePK getPurchaseInvoicePK() {
        return purchaseInvoicePK;
    }

    public void setPurchaseInvoicePK(PurchaseInvoicePK purchaseInvoicePK) {
        this.purchaseInvoicePK = purchaseInvoicePK;
    }

    public Date getInvDate() {
        return invDate;
    }

    public void setInvDate(Date invDate) {
        this.invDate = invDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Collection<PurchaseInvoiceHasItem> getPurchaseInvoiceHasItemCollection() {
        return purchaseInvoiceHasItemCollection;
    }

    public void setPurchaseInvoiceHasItemCollection(Collection<PurchaseInvoiceHasItem> purchaseInvoiceHasItemCollection) {
        this.purchaseInvoiceHasItemCollection = purchaseInvoiceHasItemCollection;
    }

    public Collection<IssuedCash> getIssuedCashCollection() {
        return issuedCashCollection;
    }

    public void setIssuedCashCollection(Collection<IssuedCash> issuedCashCollection) {
        this.issuedCashCollection = issuedCashCollection;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Collection<IssuedCheque> getIssuedChequeCollection() {
        return issuedChequeCollection;
    }

    public void setIssuedChequeCollection(Collection<IssuedCheque> issuedChequeCollection) {
        this.issuedChequeCollection = issuedChequeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (purchaseInvoicePK != null ? purchaseInvoicePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PurchaseInvoice)) {
            return false;
        }
        PurchaseInvoice other = (PurchaseInvoice) object;
        if ((this.purchaseInvoicePK == null && other.purchaseInvoicePK != null) || (this.purchaseInvoicePK != null && !this.purchaseInvoicePK.equals(other.purchaseInvoicePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return purchaseInvoicePK.getInvNo();
    }

}
