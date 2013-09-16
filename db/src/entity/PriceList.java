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
@Table(name = "price_list")
@NamedQueries({
    @NamedQuery(name = "PriceList.findAll", query = "SELECT p FROM PriceList p"),
    @NamedQuery(name = "PriceList.findByCostPack", query = "SELECT p FROM PriceList p WHERE p.costPack = :costPack"),
    @NamedQuery(name = "PriceList.findByCostUnit", query = "SELECT p FROM PriceList p WHERE p.costUnit = :costUnit"),
    @NamedQuery(name = "PriceList.findBySellingPack", query = "SELECT p FROM PriceList p WHERE p.sellingPack = :sellingPack"),
    @NamedQuery(name = "PriceList.findBySellingUnit", query = "SELECT p FROM PriceList p WHERE p.sellingUnit = :sellingUnit"),
    @NamedQuery(name = "PriceList.findByItemCode", query = "SELECT p FROM PriceList p WHERE p.itemCode = :itemCode")})
public class PriceList implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "cost_Pack")
    private Double costPack;
    @Column(name = "cost_Unit")
    private Double costUnit;
    @Column(name = "selling_Pack")
    private Double sellingPack;
    @Column(name = "selling_Unit")
    private Double sellingUnit;
    @Id
    @Basic(optional = false)
    @Column(name = "item_code")
    private String itemCode;
    @JoinColumn(name = "item_code", referencedColumnName = "code", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Item item;

    public PriceList() {
    }

    public PriceList(String itemCode) {
        this.itemCode = itemCode;
    }

    public Double getCostPack() {
        return costPack;
    }

    public void setCostPack(Double costPack) {
        this.costPack = costPack;
    }

    public Double getCostUnit() {
        return costUnit;
    }

    public void setCostUnit(Double costUnit) {
        this.costUnit = costUnit;
    }

    public Double getSellingPack() {
        return sellingPack;
    }

    public void setSellingPack(Double sellingPack) {
        this.sellingPack = sellingPack;
    }

    public Double getSellingUnit() {
        return sellingUnit;
    }

    public void setSellingUnit(Double sellingUnit) {
        this.sellingUnit = sellingUnit;
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
        if (!(object instanceof PriceList)) {
            return false;
        }
        PriceList other = (PriceList) object;
        if ((this.itemCode == null && other.itemCode != null) || (this.itemCode != null && !this.itemCode.equals(other.itemCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ent.PriceList[itemCode=" + itemCode + "]";
    }

}
