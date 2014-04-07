/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Thilina Ranathunga
 */
@Entity
@Table(name = "issued_cash")
@NamedQueries({
    @NamedQuery(name = "IssuedCash.findAll", query = "SELECT i FROM IssuedCash i"),
    @NamedQuery(name = "IssuedCash.findByAmount", query = "SELECT i FROM IssuedCash i WHERE i.amount = :amount"),
    @NamedQuery(name = "IssuedCash.findByIssuedTime", query = "SELECT i FROM IssuedCash i WHERE i.issuedTime = :issuedTime"),
    @NamedQuery(name = "IssuedCash.findByOperator", query = "SELECT i FROM IssuedCash i WHERE i.operator = :operator")})
public class IssuedCash implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "amount")
    private double amount;
    @Id
    @Basic(optional = false)
    @Column(name = "issued_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date issuedTime;
    @Column(name = "operator")
    private String operator;
    @JoinColumn(name = "bank_code", referencedColumnName = "code")
    @ManyToOne(optional = false)
    private Bank bank;
    @JoinColumns({
        @JoinColumn(name = "purchase_invoice_inv_no", referencedColumnName = "inv_no"),
        @JoinColumn(name = "purchase_invoice_supplier_code", referencedColumnName = "supplier_code")})
    @ManyToOne(optional = false)
    private PurchaseInvoice purchaseInvoice;

    public IssuedCash() {
    }

    public IssuedCash(Date issuedTime) {
        this.issuedTime = issuedTime;
    }

    public IssuedCash(Date issuedTime, double amount) {
        this.issuedTime = issuedTime;
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getIssuedTime() {
        return issuedTime;
    }

    public void setIssuedTime(Date issuedTime) {
        this.issuedTime = issuedTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
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
        hash += (issuedTime != null ? issuedTime.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IssuedCash)) {
            return false;
        }
        IssuedCash other = (IssuedCash) object;
        if ((this.issuedTime == null && other.issuedTime != null) || (this.issuedTime != null && !this.issuedTime.equals(other.issuedTime))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return util.ToString.get(this);
    }

}
