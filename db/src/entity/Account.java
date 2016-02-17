/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Thilina
 */
@Entity
@Table(name = "account")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a"),
    @NamedQuery(name = "Account.findByAccountNo", query = "SELECT a FROM Account a WHERE a.accountPK.accountNo = :accountNo"),
    @NamedQuery(name = "Account.findByBalance", query = "SELECT a FROM Account a WHERE a.balance = :balance"),
    @NamedQuery(name = "Account.findByBankCode", query = "SELECT a FROM Account a WHERE a.accountPK.bankCode = :bankCode")})
public class Account implements Serializable, Comparable<Account> {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AccountPK accountPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "balance")
    private Double balance;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "account")
    private Collection<SaleCheque> saleChequeCollection;
    @JoinColumn(name = "bank_code", referencedColumnName = "code", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Bank bank;

    public Account() {
    }

    public Account(AccountPK accountPK) {
        this.accountPK = accountPK;
    }

    public Account(String accountNo, String bankCode) {
        this.accountPK = new AccountPK(accountNo, bankCode);
    }

    public AccountPK getAccountPK() {
        return accountPK;
    }

    public void setAccountPK(AccountPK accountPK) {
        this.accountPK = accountPK;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @XmlTransient
    public Collection<SaleCheque> getSaleChequeCollection() {
        return saleChequeCollection;
    }

    public void setSaleChequeCollection(Collection<SaleCheque> saleChequeCollection) {
        this.saleChequeCollection = saleChequeCollection;
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
        hash += (accountPK != null ? accountPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.accountPK == null && other.accountPK != null) || (this.accountPK != null && !this.accountPK.equals(other.accountPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return util.ToString.get(this);
    }

    @Override
    public int compareTo(Account o) {
        return accountPK.getAccountNo().compareTo(o.getAccountPK().getAccountNo());
    }
}
