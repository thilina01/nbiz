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
public class QuotationHasItemPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "quotation_quotation_no")
    private String quotationQuotationNo;
    @Basic(optional = false)
    @Column(name = "item_code")
    private String itemCode;

    public QuotationHasItemPK() {
    }

    public QuotationHasItemPK(String quotationQuotationNo, String itemCode) {
        this.quotationQuotationNo = quotationQuotationNo;
        this.itemCode = itemCode;
    }

    public String getQuotationQuotationNo() {
        return quotationQuotationNo;
    }

    public void setQuotationQuotationNo(String quotationQuotationNo) {
        this.quotationQuotationNo = quotationQuotationNo;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (quotationQuotationNo != null ? quotationQuotationNo.hashCode() : 0);
        hash += (itemCode != null ? itemCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QuotationHasItemPK)) {
            return false;
        }
        QuotationHasItemPK other = (QuotationHasItemPK) object;
        if ((this.quotationQuotationNo == null && other.quotationQuotationNo != null) || (this.quotationQuotationNo != null && !this.quotationQuotationNo.equals(other.quotationQuotationNo))) {
            return false;
        }
        if ((this.itemCode == null && other.itemCode != null) || (this.itemCode != null && !this.itemCode.equals(other.itemCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbr.entity.QuotationHasItemPK[ quotationQuotationNo=" + quotationQuotationNo + ", itemCode=" + itemCode + " ]";
    }
    
}
