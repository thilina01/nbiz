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
@Table(name = "rep_sale_value")
@NamedQueries({
    @NamedQuery(name = "RepSaleValue.findAll", query = "SELECT r FROM RepSaleValue r"),
    @NamedQuery(name = "RepSaleValue.findBySaleDate", query = "SELECT r FROM RepSaleValue r WHERE r.repSaleValuePK.saleDate = :saleDate"),
    @NamedQuery(name = "RepSaleValue.findByAmount", query = "SELECT r FROM RepSaleValue r WHERE r.amount = :amount"),
    @NamedQuery(name = "RepSaleValue.findByEmployeeCode", query = "SELECT r FROM RepSaleValue r WHERE r.repSaleValuePK.employeeCode = :employeeCode")})
public class RepSaleValue implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RepSaleValuePK repSaleValuePK;
    @Column(name = "amount")
    private Double amount;
    @JoinColumn(name = "employee_code", referencedColumnName = "code", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Employee employee;

    public RepSaleValue() {
    }

    public RepSaleValue(RepSaleValuePK repSaleValuePK) {
        this.repSaleValuePK = repSaleValuePK;
    }

    public RepSaleValue(Date saleDate, String employeeCode) {
        this.repSaleValuePK = new RepSaleValuePK(saleDate, employeeCode);
    }

    public RepSaleValuePK getRepSaleValuePK() {
        return repSaleValuePK;
    }

    public void setRepSaleValuePK(RepSaleValuePK repSaleValuePK) {
        this.repSaleValuePK = repSaleValuePK;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
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
        hash += (repSaleValuePK != null ? repSaleValuePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RepSaleValue)) {
            return false;
        }
        RepSaleValue other = (RepSaleValue) object;
        if ((this.repSaleValuePK == null && other.repSaleValuePK != null) || (this.repSaleValuePK != null && !this.repSaleValuePK.equals(other.repSaleValuePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ent.RepSaleValue[repSaleValuePK=" + repSaleValuePK + "]";
    }

}
