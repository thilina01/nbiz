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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Thilina Ranathunga
 */
@Entity
@Table(name = "sr_sales_payments")
@NamedQueries({
    @NamedQuery(name = "SrSalesPayments.findAll", query = "SELECT s FROM SrSalesPayments s"),
    @NamedQuery(name = "SrSalesPayments.findByPaymentDate", query = "SELECT s FROM SrSalesPayments s WHERE s.srSalesPaymentsPK.paymentDate = :paymentDate"),
    @NamedQuery(name = "SrSalesPayments.findByAmount", query = "SELECT s FROM SrSalesPayments s WHERE s.amount = :amount"),
    @NamedQuery(name = "SrSalesPayments.findByStatus", query = "SELECT s FROM SrSalesPayments s WHERE s.status = :status"),
    @NamedQuery(name = "SrSalesPayments.findBySettledAmount", query = "SELECT s FROM SrSalesPayments s WHERE s.settledAmount = :settledAmount"),
    @NamedQuery(name = "SrSalesPayments.findByNotes", query = "SELECT s FROM SrSalesPayments s WHERE s.notes = :notes"),
    @NamedQuery(name = "SrSalesPayments.findByEmployeeCode", query = "SELECT s FROM SrSalesPayments s WHERE s.srSalesPaymentsPK.employeeCode = :employeeCode")})
public class SrSalesPayments implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SrSalesPaymentsPK srSalesPaymentsPK;
    @Column(name = "amount")
    private Double amount;
    @Column(name = "status")
    private Integer status;
    @Column(name = "settled_Amount")
    private Double settledAmount;
    @Column(name = "notes")
    private String notes;
    @JoinColumn(name = "employee_code", referencedColumnName = "code", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Employee employee;

    public SrSalesPayments() {
    }

    public SrSalesPayments(SrSalesPaymentsPK srSalesPaymentsPK) {
        this.srSalesPaymentsPK = srSalesPaymentsPK;
    }

    public SrSalesPayments(Date paymentDate, String employeeCode) {
        this.srSalesPaymentsPK = new SrSalesPaymentsPK(paymentDate, employeeCode);
    }

    public SrSalesPaymentsPK getSrSalesPaymentsPK() {
        return srSalesPaymentsPK;
    }

    public void setSrSalesPaymentsPK(SrSalesPaymentsPK srSalesPaymentsPK) {
        this.srSalesPaymentsPK = srSalesPaymentsPK;
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

    public Double getSettledAmount() {
        return settledAmount;
    }

    public void setSettledAmount(Double settledAmount) {
        this.settledAmount = settledAmount;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (srSalesPaymentsPK != null ? srSalesPaymentsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SrSalesPayments)) {
            return false;
        }
        SrSalesPayments other = (SrSalesPayments) object;
        if ((this.srSalesPaymentsPK == null && other.srSalesPaymentsPK != null) || (this.srSalesPaymentsPK != null && !this.srSalesPaymentsPK.equals(other.srSalesPaymentsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ent.SrSalesPayments[srSalesPaymentsPK=" + srSalesPaymentsPK + "]";
    }

}
