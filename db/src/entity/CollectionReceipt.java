/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Thilina
 */
@Entity
@Table(name = "collection_receipt")
@NamedQueries({
    @NamedQuery(name = "CollectionReceipt.findAll", query = "SELECT c FROM CollectionReceipt c"),
    @NamedQuery(name = "CollectionReceipt.findByReceiptNumber", query = "SELECT c FROM CollectionReceipt c WHERE c.receiptNumber = :receiptNumber"),
    @NamedQuery(name = "CollectionReceipt.findByCollectedTime", query = "SELECT c FROM CollectionReceipt c WHERE c.collectedTime = :collectedTime"),
    @NamedQuery(name = "CollectionReceipt.findByOperator", query = "SELECT c FROM CollectionReceipt c WHERE c.operator = :operator"),
    @NamedQuery(name = "CollectionReceipt.findByAmount", query = "SELECT c FROM CollectionReceipt c WHERE c.amount = :amount")})
public class CollectionReceipt implements Serializable, Comparable<CollectionReceipt>  {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "receipt_number")
    private String receiptNumber;
    @Column(name = "collected_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date collectedTime;
    @Column(name = "operator")
    private String operator;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
//    @Column(name = "cash")
//    private Double cash; 
    @Column(name = "amount")
    private Double amount;
    @Column(name = "amount_in_cash")
    private Double amountInCash;
    @JoinColumn(name = "sale_invoice_inv_no", referencedColumnName = "inv_no")
    @ManyToOne(optional = false)
    private SaleInvoice saleInvoice;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "collectionReceipt")
    private Collection<SaleCheque> saleChequeCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "collectionReceipt")
    private SaleCash saleCash;
    @JoinColumn(name = "customer_code", referencedColumnName = "code")
    @ManyToOne
    private Customer customer;

    public CollectionReceipt() {
    }

    public CollectionReceipt(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public String getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public Date getCollectedTime() {
        return collectedTime;
    }

    public void setCollectedTime(Date collectedTime) {
        this.collectedTime = collectedTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

//    public Double getCash() {
//        return cash;
//    }
//
//    public void setCash(Double cash) {
//        this.cash = cash;
//    }

    public SaleInvoice getSaleInvoice() {
        return saleInvoice;
    }

    public void setSaleInvoice(SaleInvoice saleInvoice) {
        this.saleInvoice = saleInvoice;
    }
    
    public Collection<SaleCheque> getSaleChequeCollection() {
        return saleChequeCollection;
    }

    public void setSaleChequeCollection(Collection<SaleCheque> saleChequeCollection) {
        this.saleChequeCollection = saleChequeCollection;
    }

    public SaleCash getSaleCash() {
        return saleCash;
    }

    public void setSaleCash(SaleCash saleCash) {
        this.saleCash = saleCash;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (receiptNumber != null ? receiptNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CollectionReceipt)) {
            return false;
        }
        CollectionReceipt other = (CollectionReceipt) object;
        if ((this.receiptNumber == null && other.receiptNumber != null) || (this.receiptNumber != null && !this.receiptNumber.equals(other.receiptNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return util.ToString.get(this);
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * @return the amountInCash
     */
    public Double getAmountInCash() {
        return amountInCash;
    }

    /**
     * @param amountInCash the amountInCash to set
     */
    public void setAmountInCash(Double amountInCash) {
        this.amountInCash = amountInCash;
    }

    
    @Override
    public int compareTo(CollectionReceipt o) {
        return receiptNumber.compareTo(o.getReceiptNumber());
    }
    
}
