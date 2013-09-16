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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Thilina Ranathunga
 */
@Entity
@Table(name = "old_price")
@NamedQueries({
    @NamedQuery(name = "OldPrice.findAll", query = "SELECT o FROM OldPrice o"),
    @NamedQuery(name = "OldPrice.findByChangeDate", query = "SELECT o FROM OldPrice o WHERE o.oldPricePK.changeDate = :changeDate"),
    @NamedQuery(name = "OldPrice.findByOldPrice", query = "SELECT o FROM OldPrice o WHERE o.oldPrice = :oldPrice"),
    @NamedQuery(name = "OldPrice.findByNewPrice", query = "SELECT o FROM OldPrice o WHERE o.newPrice = :newPrice"),
    @NamedQuery(name = "OldPrice.findByItemCode", query = "SELECT o FROM OldPrice o WHERE o.oldPricePK.itemCode = :itemCode")})
public class OldPrice implements Serializable {
    @JoinColumns({
        @JoinColumn(name = "item_has_price_item_code", referencedColumnName = "item_code", insertable = false, updatable = false),
        @JoinColumn(name = "item_has_price_price_type_type", referencedColumnName = "price_type_type", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private ItemHasPrice itemHasPrice;
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OldPricePK oldPricePK;
    @Column(name = "old_price")
    private Double oldPrice;
    @Column(name = "new_price")
    private Double newPrice;
    @JoinColumn(name = "item_code", referencedColumnName = "code", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Item item;

    public OldPrice() {
    }

    public OldPrice(OldPricePK oldPricePK) {
        this.oldPricePK = oldPricePK;
    }

    public OldPrice(Date changeDate, String itemCode) {
        this.oldPricePK = new OldPricePK(changeDate, itemCode);
    }

    public OldPricePK getOldPricePK() {
        return oldPricePK;
    }

    public void setOldPricePK(OldPricePK oldPricePK) {
        this.oldPricePK = oldPricePK;
    }

    public Double getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(Double oldPrice) {
        this.oldPrice = oldPrice;
    }

    public Double getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(Double newPrice) {
        this.newPrice = newPrice;
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
        hash += (oldPricePK != null ? oldPricePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OldPrice)) {
            return false;
        }
        OldPrice other = (OldPrice) object;
        if ((this.oldPricePK == null && other.oldPricePK != null) || (this.oldPricePK != null && !this.oldPricePK.equals(other.oldPricePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ent.OldPrice[oldPricePK=" + oldPricePK + "]";
    }

    public ItemHasPrice getItemHasPrice() {
        return itemHasPrice;
    }

    public void setItemHasPrice(ItemHasPrice itemHasPrice) {
        this.itemHasPrice = itemHasPrice;
    }

}
