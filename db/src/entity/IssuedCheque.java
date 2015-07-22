/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "issued_cheque")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IssuedCheque.findAll", query = "SELECT i FROM IssuedCheque i"),
    @NamedQuery(name = "IssuedCheque.findByChequeNumber", query = "SELECT i FROM IssuedCheque i WHERE i.chequeNumber = :chequeNumber"),
    @NamedQuery(name = "IssuedCheque.findByIssuedDate", query = "SELECT i FROM IssuedCheque i WHERE i.issuedDate = :issuedDate"),
    @NamedQuery(name = "IssuedCheque.findByBankingDate", query = "SELECT i FROM IssuedCheque i WHERE i.bankingDate = :bankingDate"),
    @NamedQuery(name = "IssuedCheque.findByAmount", query = "SELECT i FROM IssuedCheque i WHERE i.amount = :amount"),
    @NamedQuery(name = "IssuedCheque.findByStatus", query = "SELECT i FROM IssuedCheque i WHERE i.status = :status"),
    @NamedQuery(name = "IssuedCheque.findByOperator", query = "SELECT i FROM IssuedCheque i WHERE i.operator = :operator")})
public class IssuedCheque implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cheque_number")
    private String chequeNumber;
    @Column(name = "issued_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date issuedDate;
    @Column(name = "banking_date")
    @Temporal(TemporalType.DATE)
    private Date bankingDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "amount")
    private Double amount;
    @Column(name = "status")
    private Integer status;
    @Column(name = "operator")
    private String operator;
    @JoinTable(name = "issued_cheque_has_purchase_invoice", joinColumns = {
        @JoinColumn(name = "issued_cheque_cheque_number", referencedColumnName = "cheque_number")}, inverseJoinColumns = {
        @JoinColumn(name = "purchase_invoice_inv_no", referencedColumnName = "inv_no"),
        @JoinColumn(name = "purchase_invoice_supplier_code", referencedColumnName = "supplier_code")})
    @ManyToMany
    private Collection<PurchaseInvoice> purchaseInvoiceCollection;
    @JoinColumn(name = "bank_code", referencedColumnName = "code")
    @ManyToOne(optional = false)
    private Bank bank;

    public IssuedCheque() {
    }

    public IssuedCheque(String chequeNumber) {
        this.chequeNumber = chequeNumber;
    }

    public String getChequeNumber() {
        return chequeNumber;
    }

    public void setChequeNumber(String chequeNumber) {
        this.chequeNumber = chequeNumber;
    }

    public Date getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }

    public Date getBankingDate() {
        return bankingDate;
    }

    public void setBankingDate(Date bankingDate) {
        this.bankingDate = bankingDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @XmlTransient
    public Collection<PurchaseInvoice> getPurchaseInvoiceCollection() {
        return purchaseInvoiceCollection;
    }

    public void setPurchaseInvoiceCollection(Collection<PurchaseInvoice> purchaseInvoiceCollection) {
        this.purchaseInvoiceCollection = purchaseInvoiceCollection;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (chequeNumber != null ? chequeNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IssuedCheque)) {
            return false;
        }
        IssuedCheque other = (IssuedCheque) object;
        if ((this.chequeNumber == null && other.chequeNumber != null) || (this.chequeNumber != null && !this.chequeNumber.equals(other.chequeNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.IssuedCheque[ chequeNumber=" + chequeNumber + " ]";
    }
    
}
