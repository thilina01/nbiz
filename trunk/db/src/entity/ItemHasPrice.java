/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Thilina
 */
@Entity
@Table(name = "item_has_price")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemHasPrice.findAll", query = "SELECT i FROM ItemHasPrice i"),
    @NamedQuery(name = "ItemHasPrice.findByItemCode", query = "SELECT i FROM ItemHasPrice i WHERE i.itemHasPricePK.itemCode = :itemCode"),
    @NamedQuery(name = "ItemHasPrice.findByPriceTypeType", query = "SELECT i FROM ItemHasPrice i WHERE i.itemHasPricePK.priceTypeType = :priceTypeType"),
    @NamedQuery(name = "ItemHasPrice.findByPrice", query = "SELECT i FROM ItemHasPrice i WHERE i.price = :price"),
    @NamedQuery(name = "ItemHasPrice.findByUnits", query = "SELECT i FROM ItemHasPrice i WHERE i.units = :units")})
public class ItemHasPrice implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ItemHasPricePK itemHasPricePK;
    @Basic(optional = false)
    @Column(name = "price")
    private double price;
    @Basic(optional = false)
    @Column(name = "units")
    private int units;
    @JoinColumn(name = "price_type_type", referencedColumnName = "type", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PriceType priceType;
    @JoinColumn(name = "item_code", referencedColumnName = "code", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Item item;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemHasPrice")
    private Collection<OldPrice> oldPriceCollection;

    public ItemHasPrice() {
    }

    public ItemHasPrice(ItemHasPricePK itemHasPricePK) {
        this.itemHasPricePK = itemHasPricePK;
    }

    public ItemHasPrice(ItemHasPricePK itemHasPricePK, double price, int units) {
        this.itemHasPricePK = itemHasPricePK;
        this.price = price;
        this.units = units;
    }

    public ItemHasPrice(String itemCode, String priceTypeType) {
        this.itemHasPricePK = new ItemHasPricePK(itemCode, priceTypeType);
    }

    public ItemHasPricePK getItemHasPricePK() {
        return itemHasPricePK;
    }

    public void setItemHasPricePK(ItemHasPricePK itemHasPricePK) {
        this.itemHasPricePK = itemHasPricePK;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public PriceType getPriceType() {
        return priceType;
    }

    public void setPriceType(PriceType priceType) {
        this.priceType = priceType;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @XmlTransient
    public Collection<OldPrice> getOldPriceCollection() {
        return oldPriceCollection;
    }

    public void setOldPriceCollection(Collection<OldPrice> oldPriceCollection) {
        this.oldPriceCollection = oldPriceCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemHasPricePK != null ? itemHasPricePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemHasPrice)) {
            return false;
        }
        ItemHasPrice other = (ItemHasPrice) object;
        if ((this.itemHasPricePK == null && other.itemHasPricePK != null) || (this.itemHasPricePK != null && !this.itemHasPricePK.equals(other.itemHasPricePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ent.ItemHasPrice[ itemHasPricePK=" + itemHasPricePK + " ]";
    }
    
}
