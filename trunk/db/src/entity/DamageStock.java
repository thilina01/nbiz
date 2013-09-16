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
@Table(name = "damage_stock")
@NamedQueries({
    @NamedQuery(name = "DamageStock.findAll", query = "SELECT d FROM DamageStock d"),
    @NamedQuery(name = "DamageStock.findByQuantity", query = "SELECT d FROM DamageStock d WHERE d.quantity = :quantity"),
    @NamedQuery(name = "DamageStock.findByItemCode", query = "SELECT d FROM DamageStock d WHERE d.itemCode = :itemCode")})
public class DamageStock implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "quantity")
    private Double quantity;
    @Id
    @Basic(optional = false)
    @Column(name = "item_code")
    private String itemCode;
    @JoinColumn(name = "item_code", referencedColumnName = "code", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Item item;

    public DamageStock() {
    }

    public DamageStock(String itemCode) {
        this.itemCode = itemCode;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemCode != null ? itemCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DamageStock)) {
            return false;
        }
        DamageStock other = (DamageStock) object;
        if ((this.itemCode == null && other.itemCode != null) || (this.itemCode != null && !this.itemCode.equals(other.itemCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ent.DamageStock[itemCode=" + itemCode + "]";
    }

}
