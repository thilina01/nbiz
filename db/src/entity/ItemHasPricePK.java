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
 * @author Thilina
 */
@Embeddable
public class ItemHasPricePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "item_code")
    private String itemCode;
    @Basic(optional = false)
    @Column(name = "price_type_type")
    private String priceTypeType;

    public ItemHasPricePK() {
    }

    public ItemHasPricePK(String itemCode, String priceTypeType) {
        this.itemCode = itemCode;
        this.priceTypeType = priceTypeType;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getPriceTypeType() {
        return priceTypeType;
    }

    public void setPriceTypeType(String priceTypeType) {
        this.priceTypeType = priceTypeType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemCode != null ? itemCode.hashCode() : 0);
        hash += (priceTypeType != null ? priceTypeType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemHasPricePK)) {
            return false;
        }
        ItemHasPricePK other = (ItemHasPricePK) object;
        if ((this.itemCode == null && other.itemCode != null) || (this.itemCode != null && !this.itemCode.equals(other.itemCode))) {
            return false;
        }
        if ((this.priceTypeType == null && other.priceTypeType != null) || (this.priceTypeType != null && !this.priceTypeType.equals(other.priceTypeType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return util.ToString.get(this);
    }
    
}
