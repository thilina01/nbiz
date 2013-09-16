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
public class RepSaleValuePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "sale_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date saleDate;
    @Basic(optional = false)
    @Column(name = "employee_code")
    private String employeeCode;

    public RepSaleValuePK() {
    }

    public RepSaleValuePK(Date saleDate, String employeeCode) {
        this.saleDate = saleDate;
        this.employeeCode = employeeCode;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
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
        hash += (saleDate != null ? saleDate.hashCode() : 0);
        hash += (employeeCode != null ? employeeCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RepSaleValuePK)) {
            return false;
        }
        RepSaleValuePK other = (RepSaleValuePK) object;
        if ((this.saleDate == null && other.saleDate != null) || (this.saleDate != null && !this.saleDate.equals(other.saleDate))) {
            return false;
        }
        if ((this.employeeCode == null && other.employeeCode != null) || (this.employeeCode != null && !this.employeeCode.equals(other.employeeCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ent.RepSaleValuePK[saleDate=" + saleDate + ", employeeCode=" + employeeCode + "]";
    }

}
