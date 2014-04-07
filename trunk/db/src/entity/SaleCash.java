/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Thilina Ranathunga
 */
@Entity
@Table(name = "sale_cash")
@NamedQueries({
    @NamedQuery(name = "SaleCash.findAll", query = "SELECT s FROM SaleCash s"),
    @NamedQuery(name = "SaleCash.findByAmount", query = "SELECT s FROM SaleCash s WHERE s.amount = :amount"),
    @NamedQuery(name = "SaleCash.findByCollectionReceiptReceiptNumber", query = "SELECT s FROM SaleCash s WHERE s.collectionReceiptReceiptNumber = :collectionReceiptReceiptNumber")})
public class SaleCash implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "amount")
    private Double amount;
    @Id
    @Basic(optional = false)
    @Column(name = "collection_receipt_receipt_number")
    private String collectionReceiptReceiptNumber;
    @JoinColumn(name = "collection_receipt_receipt_number", referencedColumnName = "receipt_number", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private CollectionReceipt collectionReceipt;

    public SaleCash() {
    }

    public SaleCash(String collectionReceiptReceiptNumber) {
        this.collectionReceiptReceiptNumber = collectionReceiptReceiptNumber;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCollectionReceiptReceiptNumber() {
        return collectionReceiptReceiptNumber;
    }

    public void setCollectionReceiptReceiptNumber(String collectionReceiptReceiptNumber) {
        this.collectionReceiptReceiptNumber = collectionReceiptReceiptNumber;
    }

    public CollectionReceipt getCollectionReceipt() {
        return collectionReceipt;
    }

    public void setCollectionReceipt(CollectionReceipt collectionReceipt) {
        this.collectionReceipt = collectionReceipt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (collectionReceiptReceiptNumber != null ? collectionReceiptReceiptNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SaleCash)) {
            return false;
        }
        SaleCash other = (SaleCash) object;
        if ((this.collectionReceiptReceiptNumber == null && other.collectionReceiptReceiptNumber != null) || (this.collectionReceiptReceiptNumber != null && !this.collectionReceiptReceiptNumber.equals(other.collectionReceiptReceiptNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return util.ToString.get(this);
    }

}
