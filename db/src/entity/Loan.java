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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "loan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Loan.findAll", query = "SELECT l FROM Loan l"),
    @NamedQuery(name = "Loan.findByCode", query = "SELECT l FROM Loan l WHERE l.code = :code"),
    @NamedQuery(name = "Loan.findByAmount", query = "SELECT l FROM Loan l WHERE l.amount = :amount"),
    @NamedQuery(name = "Loan.findByInterestRate", query = "SELECT l FROM Loan l WHERE l.interestRate = :interestRate"),
    @NamedQuery(name = "Loan.findByTermAmount", query = "SELECT l FROM Loan l WHERE l.termAmount = :termAmount"),
    @NamedQuery(name = "Loan.findByNotes", query = "SELECT l FROM Loan l WHERE l.notes = :notes"),
    @NamedQuery(name = "Loan.findByStartDate", query = "SELECT l FROM Loan l WHERE l.startDate = :startDate"),
    @NamedQuery(name = "Loan.findByEndDate", query = "SELECT l FROM Loan l WHERE l.endDate = :endDate"),
    @NamedQuery(name = "Loan.findByPaid", query = "SELECT l FROM Loan l WHERE l.paid = :paid"),
    @NamedQuery(name = "Loan.findByInterestPaid", query = "SELECT l FROM Loan l WHERE l.interestPaid = :interestPaid")})
public class Loan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "code")
    private String code;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "amount")
    private Double amount;
    @Column(name = "interest_rate")
    private Double interestRate;
    @Column(name = "term_amount")
    private Double termAmount;
    @Column(name = "notes")
    private String notes;
    @Column(name = "start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "end_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Column(name = "paid")
    private Double paid;
    @Column(name = "interest_paid")
    private Double interestPaid;
    @JoinColumn(name = "bank_code", referencedColumnName = "code")
    @ManyToOne(optional = false)
    private Bank bankCode;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loan")
    private Collection<Term> termCollection;

    public Loan() {
    }

    public Loan(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public Double getTermAmount() {
        return termAmount;
    }

    public void setTermAmount(Double termAmount) {
        this.termAmount = termAmount;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Double getPaid() {
        return paid;
    }

    public void setPaid(Double paid) {
        this.paid = paid;
    }

    public Double getInterestPaid() {
        return interestPaid;
    }

    public void setInterestPaid(Double interestPaid) {
        this.interestPaid = interestPaid;
    }

    public Bank getBankCode() {
        return bankCode;
    }

    public void setBankCode(Bank bankCode) {
        this.bankCode = bankCode;
    }

    @XmlTransient
    public Collection<Term> getTermCollection() {
        return termCollection;
    }

    public void setTermCollection(Collection<Term> termCollection) {
        this.termCollection = termCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Loan)) {
            return false;
        }
        Loan other = (Loan) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbr.entity.Loan[ code=" + code + " ]";
    }
    
}
