/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Thilina Ranathunga
 */
@Embeddable
public class SrSalesPaymentsPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "payment_date")
    @Temporal(TemporalType.DATE)
    private Date paymentDate;
    @Basic(optional = false)
    @Column(name = "employee_code")
    private String employeeCode;

    public SrSalesPaymentsPK() {
    }

    public SrSalesPaymentsPK(Date paymentDate, String employeeCode) {
        this.paymentDate = paymentDate;
        this.employeeCode = employeeCode;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paymentDate != null ? paymentDate.hashCode() : 0);
        hash += (employeeCode != null ? employeeCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SrSalesPaymentsPK)) {
            return false;
        }
        SrSalesPaymentsPK other = (SrSalesPaymentsPK) object;
        if ((this.paymentDate == null && other.paymentDate != null) || (this.paymentDate != null && !this.paymentDate.equals(other.paymentDate))) {
            return false;
        }
        if ((this.employeeCode == null && other.employeeCode != null) || (this.employeeCode != null && !this.employeeCode.equals(other.employeeCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ent.SrSalesPaymentsPK[paymentDate=" + paymentDate + ", employeeCode=" + employeeCode + "]";
    }

}
