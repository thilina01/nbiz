/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
public class TermPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "receipt")
    private String receipt;
    @Basic(optional = false)
    @Column(name = "loan_code")
    private String loanCode;

    public TermPK() {
    }

    public TermPK(String receipt, String loanCode) {
        this.receipt = receipt;
        this.loanCode = loanCode;
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    public String getLoanCode() {
        return loanCode;
    }

    public void setLoanCode(String loanCode) {
        this.loanCode = loanCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (receipt != null ? receipt.hashCode() : 0);
        hash += (loanCode != null ? loanCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TermPK)) {
            return false;
        }
        TermPK other = (TermPK) object;
        if ((this.receipt == null && other.receipt != null) || (this.receipt != null && !this.receipt.equals(other.receipt))) {
            return false;
        }
        if ((this.loanCode == null && other.loanCode != null) || (this.loanCode != null && !this.loanCode.equals(other.loanCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbr.entity.TermPK[ receipt=" + receipt + ", loanCode=" + loanCode + " ]";
    }
    
}
