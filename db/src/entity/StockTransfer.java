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
@Table(name = "stock_transfer")
@NamedQueries({
    @NamedQuery(name = "StockTransfer.findAll", query = "SELECT s FROM StockTransfer s"),
    @NamedQuery(name = "StockTransfer.findByEmployeeCode", query = "SELECT s FROM StockTransfer s WHERE s.stockTransferPK.employeeCode = :employeeCode"),
    @NamedQuery(name = "StockTransfer.findByItemCode", query = "SELECT s FROM StockTransfer s WHERE s.stockTransferPK.itemCode = :itemCode"),
    @NamedQuery(name = "StockTransfer.findByQuantity", query = "SELECT s FROM StockTransfer s WHERE s.quantity = :quantity"),
    @NamedQuery(name = "StockTransfer.findByTransferDate", query = "SELECT s FROM StockTransfer s WHERE s.stockTransferPK.transferDate = :transferDate"),
    @NamedQuery(name = "StockTransfer.findByRate", query = "SELECT s FROM StockTransfer s WHERE s.rate = :rate")})
public class StockTransfer implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StockTransferPK stockTransferPK;
    @Column(name = "quantity")
    private Double quantity;
    @Column(name = "rate")
    private Double rate;
    @JoinColumn(name = "item_code", referencedColumnName = "code", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Item item;
    @JoinColumn(name = "employee_code", referencedColumnName = "code", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Employee employee;

    public StockTransfer() {
    }

    public StockTransfer(StockTransferPK stockTransferPK) {
        this.stockTransferPK = stockTransferPK;
    }

    public StockTransfer(String employeeCode, String itemCode, Date transferDate) {
        this.stockTransferPK = new StockTransferPK(employeeCode, itemCode, transferDate);
    }

    public StockTransferPK getStockTransferPK() {
        return stockTransferPK;
    }

    public void setStockTransferPK(StockTransferPK stockTransferPK) {
        this.stockTransferPK = stockTransferPK;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
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
        hash += (stockTransferPK != null ? stockTransferPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StockTransfer)) {
            return false;
        }
        StockTransfer other = (StockTransfer) object;
        if ((this.stockTransferPK == null && other.stockTransferPK != null) || (this.stockTransferPK != null && !this.stockTransferPK.equals(other.stockTransferPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return util.ToString.get(this);
    }

}
