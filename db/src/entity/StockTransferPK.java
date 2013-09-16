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
public class StockTransferPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "employee_code")
    private String employeeCode;
    @Basic(optional = false)
    @Column(name = "item_code")
    private String itemCode;
    @Basic(optional = false)
    @Column(name = "transfer_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transferDate;

    public StockTransferPK() {
    }

    public StockTransferPK(String employeeCode, String itemCode, Date transferDate) {
        this.employeeCode = employeeCode;
        this.itemCode = itemCode;
        this.transferDate = transferDate;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public Date getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(Date transferDate) {
        this.transferDate = transferDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeeCode != null ? employeeCode.hashCode() : 0);
        hash += (itemCode != null ? itemCode.hashCode() : 0);
        hash += (transferDate != null ? transferDate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StockTransferPK)) {
            return false;
        }
        StockTransferPK other = (StockTransferPK) object;
        if ((this.employeeCode == null && other.employeeCode != null) || (this.employeeCode != null && !this.employeeCode.equals(other.employeeCode))) {
            return false;
        }
        if ((this.itemCode == null && other.itemCode != null) || (this.itemCode != null && !this.itemCode.equals(other.itemCode))) {
            return false;
        }
        if ((this.transferDate == null && other.transferDate != null) || (this.transferDate != null && !this.transferDate.equals(other.transferDate))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ent.StockTransferPK[employeeCode=" + employeeCode + ", itemCode=" + itemCode + ", transferDate=" + transferDate + "]";
    }

}
