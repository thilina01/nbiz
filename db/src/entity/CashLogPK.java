/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
 * @author Thilina
 */
@Embeddable
public class CashLogPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "log_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date logTime;
    @Basic(optional = false)
    @Column(name = "cash_box_id")
    private String cashBoxId;

    public CashLogPK() {
    }

    public CashLogPK(Date logTime, String cashBoxId) {
        this.logTime = logTime;
        this.cashBoxId = cashBoxId;
    }

    public Date getLogTime() {
        return logTime;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

    public String getCashBoxId() {
        return cashBoxId;
    }

    public void setCashBoxId(String cashBoxId) {
        this.cashBoxId = cashBoxId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (logTime != null ? logTime.hashCode() : 0);
        hash += (cashBoxId != null ? cashBoxId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CashLogPK)) {
            return false;
        }
        CashLogPK other = (CashLogPK) object;
        if ((this.logTime == null && other.logTime != null) || (this.logTime != null && !this.logTime.equals(other.logTime))) {
            return false;
        }
        if ((this.cashBoxId == null && other.cashBoxId != null) || (this.cashBoxId != null && !this.cashBoxId.equals(other.cashBoxId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbr.entity.CashLogPK[ logTime=" + logTime + ", cashBoxId=" + cashBoxId + " ]";
    }
    
}
