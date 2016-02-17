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
 * @author Thilina Ranathunga
 */
@Embeddable
public class SaleChequePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "cheque_number")
    private String chequeNumber;
    @Basic(optional = false)
    @Column(name = "bank_code")
    private String bankCode;
    @Basic(optional = false)
    @Column(name = "collection_receipt_receipt_number")
    private String collectionReceiptReceiptNumber;

    public SaleChequePK() {
    }

    public SaleChequePK(String chequeNumber, String bankCode, String collectionReceiptReceiptNumber) {
        this.chequeNumber = chequeNumber;
        this.bankCode = bankCode;
        this.collectionReceiptReceiptNumber = collectionReceiptReceiptNumber;
    }

    public String getChequeNumber() {
        return chequeNumber;
    }

    public void setChequeNumber(String chequeNumber) {
        this.chequeNumber = chequeNumber;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getCollectionReceiptReceiptNumber() {
        return collectionReceiptReceiptNumber;
    }

    public void setCollectionReceiptReceiptNumber(String collectionReceiptReceiptNumber) {
        this.collectionReceiptReceiptNumber = collectionReceiptReceiptNumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (chequeNumber != null ? chequeNumber.hashCode() : 0);
        hash += (bankCode != null ? bankCode.hashCode() : 0);
        hash += (collectionReceiptReceiptNumber != null ? collectionReceiptReceiptNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SaleChequePK)) {
            return false;
        }
        SaleChequePK other = (SaleChequePK) object;
        if ((this.chequeNumber == null && other.chequeNumber != null) || (this.chequeNumber != null && !this.chequeNumber.equals(other.chequeNumber))) {
            return false;
        }
        if ((this.bankCode == null && other.bankCode != null) || (this.bankCode != null && !this.bankCode.equals(other.bankCode))) {
            return false;
        }
        if ((this.collectionReceiptReceiptNumber == null && other.collectionReceiptReceiptNumber != null) || (this.collectionReceiptReceiptNumber != null && !this.collectionReceiptReceiptNumber.equals(other.collectionReceiptReceiptNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return util.ToString.get(this);
    }

}
