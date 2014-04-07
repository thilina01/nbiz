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
@Table(name = "stock_change")
@NamedQueries({
    @NamedQuery(name = "StockChange.findAll", query = "SELECT s FROM StockChange s"),
    @NamedQuery(name = "StockChange.findByOldQuantity", query = "SELECT s FROM StockChange s WHERE s.oldQuantity = :oldQuantity"),
    @NamedQuery(name = "StockChange.findByActualQuantity", query = "SELECT s FROM StockChange s WHERE s.actualQuantity = :actualQuantity"),
    @NamedQuery(name = "StockChange.findByRate", query = "SELECT s FROM StockChange s WHERE s.rate = :rate"),
    @NamedQuery(name = "StockChange.findByItemCode", query = "SELECT s FROM StockChange s WHERE s.stockChangePK.itemCode = :itemCode"),
    @NamedQuery(name = "StockChange.findByStockChangeSummeryChangeDate", query = "SELECT s FROM StockChange s WHERE s.stockChangePK.stockChangeSummeryChangeDate = :stockChangeSummeryChangeDate")})
public class StockChange implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StockChangePK stockChangePK;
    @Column(name = "old_quantity")
    private Double oldQuantity;
    @Column(name = "actual_quantity")
    private Double actualQuantity;
    @Column(name = "rate")
    private Double rate;
    @JoinColumn(name = "stock_change_summery_change_date", referencedColumnName = "change_date", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private StockChangeSummery stockChangeSummery;
    @JoinColumn(name = "item_code", referencedColumnName = "code", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Item item;

    public StockChange() {
    }

    public StockChange(StockChangePK stockChangePK) {
        this.stockChangePK = stockChangePK;
    }

    public StockChange(String itemCode, Date stockChangeSummeryChangeDate) {
        this.stockChangePK = new StockChangePK(itemCode, stockChangeSummeryChangeDate);
    }

    public StockChangePK getStockChangePK() {
        return stockChangePK;
    }

    public void setStockChangePK(StockChangePK stockChangePK) {
        this.stockChangePK = stockChangePK;
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

    public StockChangeSummery getStockChangeSummery() {
        return stockChangeSummery;
    }

    public void setStockChangeSummery(StockChangeSummery stockChangeSummery) {
        this.stockChangeSummery = stockChangeSummery;
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
        hash += (stockChangePK != null ? stockChangePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StockChange)) {
            return false;
        }
        StockChange other = (StockChange) object;
        if ((this.stockChangePK == null && other.stockChangePK != null) || (this.stockChangePK != null && !this.stockChangePK.equals(other.stockChangePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return util.ToString.get(this);
    }

}
