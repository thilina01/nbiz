/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Thilina Ranathunga
 */
@Embeddable
public class StockChangePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "item_code")
    private String itemCode;
    @Basic(optional = false)
    @Column(name = "stock_change_summery_change_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date stockChangeSummeryChangeDate;

    public StockChangePK() {
    }

    public StockChangePK(String itemCode, Date stockChangeSummeryChangeDate) {
        this.itemCode = itemCode;
        this.stockChangeSummeryChangeDate = stockChangeSummeryChangeDate;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public Date getStockChangeSummeryChangeDate() {
        return stockChangeSummeryChangeDate;
    }

    public void setStockChangeSummeryChangeDate(Date stockChangeSummeryChangeDate) {
        this.stockChangeSummeryChangeDate = stockChangeSummeryChangeDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemCode != null ? itemCode.hashCode() : 0);
        hash += (stockChangeSummeryChangeDate != null ? stockChangeSummeryChangeDate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StockChangePK)) {
            return false;
        }
        StockChangePK other = (StockChangePK) object;
        if ((this.itemCode == null && other.itemCode != null) || (this.itemCode != null && !this.itemCode.equals(other.itemCode))) {
            return false;
        }
        if ((this.stockChangeSummeryChangeDate == null && other.stockChangeSummeryChangeDate != null) || (this.stockChangeSummeryChangeDate != null && !this.stockChangeSummeryChangeDate.equals(other.stockChangeSummeryChangeDate))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return util.ToString.get(this);
    }

}
