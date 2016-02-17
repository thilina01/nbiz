/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Thilina
 */
@Entity
@Table(name = "term")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Term.findAll", query = "SELECT t FROM Term t"),
    @NamedQuery(name = "Term.findByReceipt", query = "SELECT t FROM Term t WHERE t.termPK.receipt = :receipt"),
    @NamedQuery(name = "Term.findByAmount", query = "SELECT t FROM Term t WHERE t.amount = :amount"),
    @NamedQuery(name = "Term.findByPaidDate", query = "SELECT t FROM Term t WHERE t.paidDate = :paidDate"),
    @NamedQuery(name = "Term.findByPremiumAmount", query = "SELECT t FROM Term t WHERE t.premiumAmount = :premiumAmount"),
    @NamedQuery(name = "Term.findByInterestAmount", query = "SELECT t FROM Term t WHERE t.interestAmount = :interestAmount"),
    @NamedQuery(name = "Term.findByLoanCode", query = "SELECT t FROM Term t WHERE t.termPK.loanCode = :loanCode")})
public class Term implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TermPK termPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "amount")
    private Double amount;
    @Column(name = "paid_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paidDate;
    @Column(name = "premium_amount")
    private Double premiumAmount;
    @Column(name = "interest_amount")
    private Double interestAmount;
    @JoinColumn(name = "loan_code", referencedColumnName = "code", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Loan loan;

    public Term() {
    }

    public Term(TermPK termPK) {
        this.termPK = termPK;
    }

    public Term(String receipt, String loanCode) {
        this.termPK = new TermPK(receipt, loanCode);
    }

    public TermPK getTermPK() {
        return termPK;
    }

    public void setTermPK(TermPK termPK) {
        this.termPK = termPK;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(Date paidDate) {
        this.paidDate = paidDate;
    }

    public Double getPremiumAmount() {
        return premiumAmount;
    }

    public void setPremiumAmount(Double premiumAmount) {
        this.premiumAmount = premiumAmount;
    }

    public Double getInterestAmount() {
        return interestAmount;
    }

    public void setInterestAmount(Double interestAmount) {
        this.interestAmount = interestAmount;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (termPK != null ? termPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Term)) {
            return false;
        }
        Term other = (Term) object;
        if ((this.termPK == null && other.termPK != null) || (this.termPK != null && !this.termPK.equals(other.termPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbr.entity.Term[ termPK=" + termPK + " ]";
    }
    
}
