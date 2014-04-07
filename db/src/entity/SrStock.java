/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
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
@Table(name = "sr_stock")
@NamedQueries({
    @NamedQuery(name = "SrStock.findAll", query = "SELECT s FROM SrStock s"),
    @NamedQuery(name = "SrStock.findByEmployeeCode", query = "SELECT s FROM SrStock s WHERE s.srStockPK.employeeCode = :employeeCode"),
    @NamedQuery(name = "SrStock.findByItemCode", query = "SELECT s FROM SrStock s WHERE s.srStockPK.itemCode = :itemCode"),
    @NamedQuery(name = "SrStock.findByQuantity", query = "SELECT s FROM SrStock s WHERE s.quantity = :quantity"),
    @NamedQuery(name = "SrStock.findByBundles", query = "SELECT s FROM SrStock s WHERE s.bundles = :bundles"),
    @NamedQuery(name = "SrStock.findByPackPrice", query = "SELECT s FROM SrStock s WHERE s.packPrice = :packPrice"),
    @NamedQuery(name = "SrStock.findByUnitPrice", query = "SELECT s FROM SrStock s WHERE s.unitPrice = :unitPrice")})
public class SrStock implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SrStockPK srStockPK;
    @Column(name = "quantity")
    private Double quantity;
    @Column(name = "bundles")
    private Double bundles;
    @Column(name = "pack_price")
    private Double packPrice;
    @Column(name = "unit_price")
    private Double unitPrice;
    @JoinColumn(name = "employee_code", referencedColumnName = "code", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Employee employee;
    @JoinColumn(name = "item_code", referencedColumnName = "code", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Item item;

    public SrStock() {
    }

    public SrStock(SrStockPK srStockPK) {
        this.srStockPK = srStockPK;
    }

    public SrStock(String employeeCode, String itemCode) {
        this.srStockPK = new SrStockPK(employeeCode, itemCode);
    }

    public SrStockPK getSrStockPK() {
        return srStockPK;
    }

    public void setSrStockPK(SrStockPK srStockPK) {
        this.srStockPK = srStockPK;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getBundles() {
        return bundles;
    }

    public void setBundles(Double bundles) {
        this.bundles = bundles;
    }

    public Double getPackPrice() {
        return packPrice;
    }

    public void setPackPrice(Double packPrice) {
        this.packPrice = packPrice;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
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
        hash += (srStockPK != null ? srStockPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SrStock)) {
            return false;
        }
        SrStock other = (SrStock) object;
        if ((this.srStockPK == null && other.srStockPK != null) || (this.srStockPK != null && !this.srStockPK.equals(other.srStockPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return util.ToString.get(this);
    }

}
