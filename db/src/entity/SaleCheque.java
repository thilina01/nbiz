/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Thilina Ranathunga
 */
@Entity
@Table(name = "sale_cheque")
/*
@NamedQueries({
    @NamedQuery(name = "SaleCheque.findAll", query = "SELECT s FROM SaleCheque s"),
    @NamedQuery(name = "SaleCheque.findByChequeNumber", query = "SELECT s FROM SaleCheque s WHERE s.saleChequePK.chequeNumber = :chequeNumber"),
    @NamedQuery(name = "SaleCheque.findByBankCode", query = "SELECT s FROM SaleCheque s WHERE s.saleChequePK.bankCode = :bankCode"),
    @NamedQuery(name = "SaleCheque.findByAmount", query = "SELECT s FROM SaleCheque s WHERE s.amount = :amount"),
    @NamedQuery(name = "SaleCheque.findByBankingDate", query = "SELECT s FROM SaleCheque s WHERE s.bankingDate = :bankingDate"),
    @NamedQuery(name = "SaleCheque.findByStatus", query = "SELECT s FROM SaleCheque s WHERE s.status = :status"),
    @NamedQuery(name = "SaleCheque.findByCollectionReceiptReceiptNumber", query = "SELECT s FROM SaleCheque s WHERE s.saleChequePK.collectionReceiptReceiptNumber = :collectionReceiptReceiptNumber")})
 */
public class SaleCheque implements Serializable, Comparable<SaleCheque> {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SaleChequePK saleChequePK;
    @Column(name = "amount")
    private Double amount;
    @Column(name = "banking_date")
    @Temporal(TemporalType.DATE)
    private Date bankingDate;
    @Column(name = "status")
    private Integer status;
    @JoinColumns({
        @JoinColumn(name = "account_account_no", referencedColumnName = "account_no"),
        @JoinColumn(name = "account_bank_code", referencedColumnName = "bank_code")})
    @ManyToOne(optional = false)
    private Account account;
    @JoinColumn(name = "collection_receipt_receipt_number", referencedColumnName = "receipt_number", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CollectionReceipt collectionReceipt;
    @JoinColumn(name = "bank_code", referencedColumnName = "code", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Bank bank;

    public SaleCheque() {
    }

    public SaleCheque(SaleChequePK saleChequePK) {
        this.saleChequePK = saleChequePK;
    }

    public SaleCheque(String chequeNumber, String bankCode, String collectionReceiptReceiptNumber) {
        this.saleChequePK = new SaleChequePK(chequeNumber, bankCode, collectionReceiptReceiptNumber);
    }

    public SaleChequePK getSaleChequePK() {
        return saleChequePK;
    }

    public void setSaleChequePK(SaleChequePK saleChequePK) {
        this.saleChequePK = saleChequePK;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getBankingDate() {
        return bankingDate;
    }

    public void setBankingDate(Date bankingDate) {
        this.bankingDate = bankingDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
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
        hash += (saleChequePK != null ? saleChequePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SaleCheque)) {
            return false;
        }
        SaleCheque other = (SaleCheque) object;
        if ((this.saleChequePK == null && other.saleChequePK != null) || (this.saleChequePK != null && !this.saleChequePK.equals(other.saleChequePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return util.ToString.get(this);
    }

    @Override
    public int compareTo(SaleCheque o) {
        return this.compareTo(o);
    }

}
