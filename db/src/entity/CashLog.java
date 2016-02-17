/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Thilina
 */
@Entity
@Table(name = "cash_log")
@NamedQueries({
    @NamedQuery(name = "CashLog.findAll", query = "SELECT c FROM CashLog c"),
    @NamedQuery(name = "CashLog.findByLogTime", query = "SELECT c FROM CashLog c WHERE c.cashLogPK.logTime = :logTime"),
    @NamedQuery(name = "CashLog.findByAmount", query = "SELECT c FROM CashLog c WHERE c.amount = :amount"),
    @NamedQuery(name = "CashLog.findByCashBoxId", query = "SELECT c FROM CashLog c WHERE c.cashLogPK.cashBoxId = :cashBoxId"),
    @NamedQuery(name = "CashLog.findByEntity", query = "SELECT c FROM CashLog c WHERE c.entity = :entity")})
public class CashLog implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CashLogPK cashLogPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "amount")
    private Double amount;
    @Column(name = "box_balance")
    private Double boxBalance;
    @Column(name = "entity")
    private String entity;
    @Lob
    @Column(name = "entity_id")
    private byte[] entityId;
    @JoinColumn(name = "cash_box_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CashBox cashBox;

    public CashLog() {
    }

    public CashLog(CashLogPK cashLogPK) {
        this.cashLogPK = cashLogPK;
    }

    public CashLog(Date logTime, String cashBoxId) {
        this.cashLogPK = new CashLogPK(logTime, cashBoxId);
    }

    public CashLogPK getCashLogPK() {
        return cashLogPK;
    }

    public void setCashLogPK(CashLogPK cashLogPK) {
        this.cashLogPK = cashLogPK;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public byte[] getEntityId() {
        return entityId;
    }

    public void setEntityId(byte[] entityId) {
        this.entityId = entityId;
    }

    public CashBox getCashBox() {
        return cashBox;
    }

    public void setCashBox(CashBox cashBox) {
        this.cashBox = cashBox;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cashLogPK != null ? cashLogPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CashLog)) {
            return false;
        }
        CashLog other = (CashLog) object;
        if ((this.cashLogPK == null && other.cashLogPK != null) || (this.cashLogPK != null && !this.cashLogPK.equals(other.cashLogPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbr.entity.CashLog[ cashLogPK=" + cashLogPK + " ]";
    }

    /**
     * @return the boxBalance
     */
    public Double getBoxBalance() {
        return boxBalance;
    }

    /**
     * @param boxBalance the boxBalance to set
     */
    public void setBoxBalance(Double boxBalance) {
        this.boxBalance = boxBalance;
    }
    
}
