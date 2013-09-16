/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Thilina Ranathunga
 */
@Entity
@Table(name = "stock_change_summery")
@NamedQueries({
    @NamedQuery(name = "StockChangeSummery.findAll", query = "SELECT s FROM StockChangeSummery s"),
    @NamedQuery(name = "StockChangeSummery.findByDeferent", query = "SELECT s FROM StockChangeSummery s WHERE s.deferent = :deferent"),
    @NamedQuery(name = "StockChangeSummery.findByChangeDate", query = "SELECT s FROM StockChangeSummery s WHERE s.changeDate = :changeDate")})
public class StockChangeSummery implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "deferent")
    private Double deferent;
    @Id
    @Basic(optional = false)
    @Column(name = "change_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date changeDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stockChangeSummery")
    private Collection<StockChange> stockChangeCollection;

    public StockChangeSummery() {
    }

    public StockChangeSummery(Date changeDate) {
        this.changeDate = changeDate;
    }

    public Double getDeferent() {
        return deferent;
    }

    public void setDeferent(Double deferent) {
        this.deferent = deferent;
    }

    public Date getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
    }

    public Collection<StockChange> getStockChangeCollection() {
        return stockChangeCollection;
    }

    public void setStockChangeCollection(Collection<StockChange> stockChangeCollection) {
        this.stockChangeCollection = stockChangeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (changeDate != null ? changeDate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StockChangeSummery)) {
            return false;
        }
        StockChangeSummery other = (StockChangeSummery) object;
        if ((this.changeDate == null && other.changeDate != null) || (this.changeDate != null && !this.changeDate.equals(other.changeDate))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ent.StockChangeSummery[changeDate=" + changeDate + "]";
    }

}
