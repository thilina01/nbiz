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
@Table(name = "expenses")
@NamedQueries({
    @NamedQuery(name = "Expenses.findAll", query = "SELECT e FROM Expenses e"),
    @NamedQuery(name = "Expenses.findByAmount", query = "SELECT e FROM Expenses e WHERE e.amount = :amount"),
    @NamedQuery(name = "Expenses.findByNotes", query = "SELECT e FROM Expenses e WHERE e.notes = :notes"),
    @NamedQuery(name = "Expenses.findByPaidTime", query = "SELECT e FROM Expenses e WHERE e.paidTime = :paidTime")})
public class Expenses implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "amount")
    private Double amount;
    @Column(name = "notes")
    private String notes;
    @Id
    @Basic(optional = false)
    @Column(name = "paid_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paidTime;
    @JoinColumn(name = "expenses_type_code", referencedColumnName = "code")
    @ManyToOne(optional = false)
    private ExpensesType expensesType;

    public Expenses() {
    }

    public Expenses(Date paidTime) {
        this.paidTime = paidTime;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Date getPaidTime() {
        return paidTime;
    }

    public void setPaidTime(Date paidTime) {
        this.paidTime = paidTime;
    }

    public ExpensesType getExpensesType() {
        return expensesType;
    }

    public void setExpensesType(ExpensesType expensesType) {
        this.expensesType = expensesType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paidTime != null ? paidTime.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Expenses)) {
            return false;
        }
        Expenses other = (Expenses) object;
        if ((this.paidTime == null && other.paidTime != null) || (this.paidTime != null && !this.paidTime.equals(other.paidTime))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ent.Expenses[paidTime=" + paidTime + "]";
    }

}
