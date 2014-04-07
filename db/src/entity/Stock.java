/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Thilina Ranathunga
 */
@Entity
@Table(name = "stock")
@NamedQueries({
    @NamedQuery(name = "Stock.findAll", query = "SELECT s FROM Stock s"),
    @NamedQuery(name = "Stock.findByQuantity", query = "SELECT s FROM Stock s WHERE s.quantity = :quantity"),
    @NamedQuery(name = "Stock.findByBundles", query = "SELECT s FROM Stock s WHERE s.bundles = :bundles"),
    @NamedQuery(name = "Stock.findByItemCode", query = "SELECT s FROM Stock s WHERE s.itemCode = :itemCode")})
public class Stock implements Serializable, Comparable<Stock> {

    private static final long serialVersionUID = 1L;
    @Column(name = "quantity")
    private Double quantity;
    @Column(name = "bundles")
    private Double bundles;
    @Column(name = "min_limit")
    private Double minLimit;
    @Id
    @Basic(optional = false)
    @Column(name = "item_code")
    private String itemCode;
    @JoinColumn(name = "item_code", referencedColumnName = "code", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Item item;

    public Stock() {
    }

    public Stock(String itemCode) {
        this.itemCode = itemCode;
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

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Double getMinLimit() {
        return minLimit;
    }

    public void setMinLimit(Double min_limit) {
        this.minLimit = min_limit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemCode != null ? itemCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stock)) {
            return false;
        }
        Stock other = (Stock) object;
        if ((this.itemCode == null && other.itemCode != null) || (this.itemCode != null && !this.itemCode.equals(other.itemCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return util.ToString.get(this);
    }

    @Override
    public int compareTo(Stock o) {
        return itemCode.compareTo(o.getItemCode());
    }
}
