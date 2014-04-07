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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "canceled_invoice")
@NamedQueries({
    @NamedQuery(name = "CanceledInvoice.findAll", query = "SELECT c FROM CanceledInvoice c"),
    @NamedQuery(name = "CanceledInvoice.findByInvNo", query = "SELECT c FROM CanceledInvoice c WHERE c.invNo = :invNo"),
    @NamedQuery(name = "CanceledInvoice.findByInvTime", query = "SELECT c FROM CanceledInvoice c WHERE c.invTime = :invTime"),
    @NamedQuery(name = "CanceledInvoice.findByAmount", query = "SELECT c FROM CanceledInvoice c WHERE c.amount = :amount"),
    @NamedQuery(name = "CanceledInvoice.findByReceivedAmount", query = "SELECT c FROM CanceledInvoice c WHERE c.receivedAmount = :receivedAmount"),
    @NamedQuery(name = "CanceledInvoice.findByDiscount", query = "SELECT c FROM CanceledInvoice c WHERE c.discount = :discount"),
    @NamedQuery(name = "CanceledInvoice.findByCredit", query = "SELECT c FROM CanceledInvoice c WHERE c.credit = :credit"),
    @NamedQuery(name = "CanceledInvoice.findByOperator", query = "SELECT c FROM CanceledInvoice c WHERE c.operator = :operator")})
public class CanceledInvoice implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "inv_no")
    private String invNo;
    @Column(name = "inv_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date invTime;
    @Column(name = "amount")
    private Double amount;
    @Column(name = "received_amount")
    private Double receivedAmount;
    @Column(name = "discount")
    private Double discount;
    @Column(name = "credit")
    private Double credit;
    @Column(name = "operator")
    private String operator;
    @JoinColumn(name = "customer_code", referencedColumnName = "code")
    @ManyToOne(optional = false)
    private Customer customer;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "canceledInvoice")
    private Collection<CanceledInvoiceHasItem> canceledInvoiceHasItemCollection;

    public CanceledInvoice() {
    }

    public CanceledInvoice(String invNo) {
        this.invNo = invNo;
    }

    public String getInvNo() {
        return invNo;
    }

    public void setInvNo(String invNo) {
        this.invNo = invNo;
    }

    public Date getInvTime() {
        return invTime;
    }

    public void setInvTime(Date invTime) {
        this.invTime = invTime;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getReceivedAmount() {
        return receivedAmount;
    }

    public void setReceivedAmount(Double receivedAmount) {
        this.receivedAmount = receivedAmount;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Collection<CanceledInvoiceHasItem> getCanceledInvoiceHasItemCollection() {
        return canceledInvoiceHasItemCollection;
    }

    public void setCanceledInvoiceHasItemCollection(Collection<CanceledInvoiceHasItem> canceledInvoiceHasItemCollection) {
        this.canceledInvoiceHasItemCollection = canceledInvoiceHasItemCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invNo != null ? invNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CanceledInvoice)) {
            return false;
        }
        CanceledInvoice other = (CanceledInvoice) object;
        if ((this.invNo == null && other.invNo != null) || (this.invNo != null && !this.invNo.equals(other.invNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return util.ToString.get(this);
    }

}
