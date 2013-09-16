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
@Table(name = "rep_stock_change")
@NamedQueries({
    @NamedQuery(name = "RepStockChange.findAll", query = "SELECT r FROM RepStockChange r"),
    @NamedQuery(name = "RepStockChange.findByOldQuantity", query = "SELECT r FROM RepStockChange r WHERE r.oldQuantity = :oldQuantity"),
    @NamedQuery(name = "RepStockChange.findByActualQuantity", query = "SELECT r FROM RepStockChange r WHERE r.actualQuantity = :actualQuantity"),
    @NamedQuery(name = "RepStockChange.findByRate", query = "SELECT r FROM RepStockChange r WHERE r.rate = :rate"),
    @NamedQuery(name = "RepStockChange.findByItemCode", query = "SELECT r FROM RepStockChange r WHERE r.repStockChangePK.itemCode = :itemCode"),
    @NamedQuery(name = "RepStockChange.findByChangeDate", query = "SELECT r FROM RepStockChange r WHERE r.repStockChangePK.changeDate = :changeDate"),
    @NamedQuery(name = "RepStockChange.findByEmployeeCode", query = "SELECT r FROM RepStockChange r WHERE r.repStockChangePK.employeeCode = :employeeCode"),
    @NamedQuery(name = "RepStockChange.findByOperator", query = "SELECT r FROM RepStockChange r WHERE r.operator = :operator")})
public class RepStockChange implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RepStockChangePK repStockChangePK;
    @Column(name = "old_quantity")
    private Double oldQuantity;
    @Column(name = "actual_quantity")
    private Double actualQuantity;
    @Column(name = "rate")
    private Double rate;
    @Column(name = "operator")
    private String operator;
    @JoinColumn(name = "employee_code", referencedColumnName = "code", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Employee employee;
    @JoinColumn(name = "item_code", referencedColumnName = "code", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Item item;

    public RepStockChange() {
    }

    public RepStockChange(RepStockChangePK repStockChangePK) {
        this.repStockChangePK = repStockChangePK;
    }

    public RepStockChange(String itemCode, Date changeDate, String employeeCode) {
        this.repStockChangePK = new RepStockChangePK(itemCode, changeDate, employeeCode);
    }

    public RepStockChangePK getRepStockChangePK() {
        return repStockChangePK;
    }

    public void setRepStockChangePK(RepStockChangePK repStockChangePK) {
        this.repStockChangePK = repStockChangePK;
    }

    public Double getOldQuantity() {
        return oldQuantity;
    }

    public void setOldQuantity(Double oldQuantity) {
        this.oldQuantity = oldQuantity;
    }

    public Double getActualQuantity() {
        return actualQuantity;
    }

    public void setActualQuantity(Double actualQuantity) {
        this.actualQuantity = actualQuantity;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (repStockChangePK != null ? repStockChangePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RepStockChange)) {
            return false;
        }
        RepStockChange other = (RepStockChange) object;
        if ((this.repStockChangePK == null && other.repStockChangePK != null) || (this.repStockChangePK != null && !this.repStockChangePK.equals(other.repStockChangePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ent.RepStockChange[repStockChangePK=" + repStockChangePK + "]";
    }

}
