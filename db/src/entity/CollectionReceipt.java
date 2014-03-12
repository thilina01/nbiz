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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Thilina
 */
@Entity
@Table(name = "collection_receipt")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CollectionReceipt.findAll", query = "SELECT c FROM CollectionReceipt c"),
    @NamedQuery(name = "CollectionReceipt.findByReceiptNumber", query = "SELECT c FROM CollectionReceipt c WHERE c.receiptNumber = :receiptNumber"),
    @NamedQuery(name = "CollectionReceipt.findByCollectedTime", query = "SELECT c FROM CollectionReceipt c WHERE c.collectedTime = :collectedTime"),
    @NamedQuery(name = "CollectionReceipt.findByOperator", query = "SELECT c FROM CollectionReceipt c WHERE c.operator = :operator"),
    @NamedQuery(name = "CollectionReceipt.findByCash", query = "SELECT c FROM CollectionReceipt c WHERE c.cash = :cash")})
public class CollectionReceipt implements Serializable {
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
    @Column(name = "cash")
    private Double cash; 
    @Column(name = "amount")
    private Double amount;
    @JoinColumn(name = "sale_invoice_inv_no", referencedColumnName = "inv_no")
    @ManyToOne(optional = false)
    private SaleInvoice saleInvoice;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "collectionReceipt")
    private Collection<SaleCheque> saleChequeCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "collectionReceipt")
    private SaleCash saleCash;

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

    public Double getCash() {
        return cash;
    }

    public void setCash(Double cash) {
        this.cash = cash;
    }

    public SaleInvoice getSaleInvoice() {
        return saleInvoice;
    }

    public void setSaleInvoice(SaleInvoice saleInvoice) {
        this.saleInvoice = saleInvoice;
    }

    @XmlTransient
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
        return "ent.CollectionReceipt[ receiptNumber=" + receiptNumber + " ]";
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
    
}
