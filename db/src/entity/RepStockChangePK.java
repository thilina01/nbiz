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
public class RepStockChangePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "item_code")
    private String itemCode;
    @Basic(optional = false)
    @Column(name = "change_date")
    @Temporal(TemporalType.DATE)
    private Date changeDate;
    @Basic(optional = false)
    @Column(name = "employee_code")
    private String employeeCode;

    public RepStockChangePK() {
    }

    public RepStockChangePK(String itemCode, Date changeDate, String employeeCode) {
        this.itemCode = itemCode;
        this.changeDate = changeDate;
        this.employeeCode = employeeCode;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public Date getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
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
        hash += (itemCode != null ? itemCode.hashCode() : 0);
        hash += (changeDate != null ? changeDate.hashCode() : 0);
        hash += (employeeCode != null ? employeeCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RepStockChangePK)) {
            return false;
        }
        RepStockChangePK other = (RepStockChangePK) object;
        if ((this.itemCode == null && other.itemCode != null) || (this.itemCode != null && !this.itemCode.equals(other.itemCode))) {
            return false;
        }
        if ((this.changeDate == null && other.changeDate != null) || (this.changeDate != null && !this.changeDate.equals(other.changeDate))) {
            return false;
        }
        if ((this.employeeCode == null && other.employeeCode != null) || (this.employeeCode != null && !this.employeeCode.equals(other.employeeCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return util.ToString.get(this);
    }

}
