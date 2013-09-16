/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Thilina Ranathunga
 */
@Embeddable
public class SrStockPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "employee_code")
    private String employeeCode;
    @Basic(optional = false)
    @Column(name = "item_code")
    private String itemCode;

    public SrStockPK() {
    }

    public SrStockPK(String employeeCode, String itemCode) {
        this.employeeCode = employeeCode;
        this.itemCode = itemCode;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeeCode != null ? employeeCode.hashCode() : 0);
        hash += (itemCode != null ? itemCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SrStockPK)) {
            return false;
        }
        SrStockPK other = (SrStockPK) object;
        if ((this.employeeCode == null && other.employeeCode != null) || (this.employeeCode != null && !this.employeeCode.equals(other.employeeCode))) {
            return false;
        }
        if ((this.itemCode == null && other.itemCode != null) || (this.itemCode != null && !this.itemCode.equals(other.itemCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ent.SrStockPK[employeeCode=" + employeeCode + ", itemCode=" + itemCode + "]";
    }

}
