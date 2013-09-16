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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Thilina
 */
@Entity
@Table(name = "sale_invoice")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SaleInvoice.findAll", query = "SELECT s FROM SaleInvoice s"),
    @NamedQuery(name = "SaleInvoice.findByInvNo", query = "SELECT s FROM SaleInvoice s WHERE s.invNo = :invNo"),
    @NamedQuery(name = "SaleInvoice.findByInvTime", query = "SELECT s FROM SaleInvoice s WHERE s.invTime = :invTime"),
    @NamedQuery(name = "SaleInvoice.findByAmount", query = "SELECT s FROM SaleInvoice s WHERE s.amount = :amount"),
    @NamedQuery(name = "SaleInvoice.findByReceivedAmount", query = "SELECT s FROM SaleInvoice s WHERE s.receivedAmount = :receivedAmount"),
    @NamedQuery(name = "SaleInvoice.findByDiscount", query = "SELECT s FROM SaleInvoice s WHERE s.discount = :discount"),
    @NamedQuery(name = "SaleInvoice.findByCredit", query = "SELECT s FROM SaleInvoice s WHERE s.credit = :credit"),
    @NamedQuery(name = "SaleInvoice.findByPrinted", query = "SELECT s FROM SaleInvoice s WHERE s.printed = :printed"),
    @NamedQuery(name = "SaleInvoice.findByOperator", query = "SELECT s FROM SaleInvoice s WHERE s.operator = :operator")})
public class SaleInvoice implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "inv_no")
    private String invNo;
    @Column(name = "inv_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date invTime;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "amount")
    private Double amount;
    @Column(name = "received_amount")
    private Double receivedAmount;
    @Column(name = "discount")
    private Double discount;
    @Column(name = "credit")
    private Double credit;
    @Column(name = "printed")
    private Integer printed;
    @Column(name = "operator")
    private String operator;
    @JoinColumn(name = "employee_code", referencedColumnName = "code")
    @ManyToOne(optional = false)
    private Employee employee;
    @JoinColumn(name = "customer_code", referencedColumnName = "code")
    @ManyToOne(optional = false)
    private Customer customer;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "saleInvoice")
    private Collection<CollectionReceipt> collectionReceiptCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "saleInvoice")
    private Collection<SaleInvoiceHasItem> saleInvoiceHasItemCollection;

    public SaleInvoice() {
    }

    public SaleInvoice(String invNo) {
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

    public Integer getPrinted() {
        return printed;
    }

    public void setPrinted(Integer printed) {
        this.printed = printed;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @XmlTransient
    public Collection<CollectionReceipt> getCollectionReceiptCollection() {
        return collectionReceiptCollection;
    }

    public void setCollectionReceiptCollection(Collection<CollectionReceipt> collectionReceiptCollection) {
        this.collectionReceiptCollection = collectionReceiptCollection;
    }

    @XmlTransient
    public Collection<SaleInvoiceHasItem> getSaleInvoiceHasItemCollection() {
        return saleInvoiceHasItemCollection;
    }

    public void setSaleInvoiceHasItemCollection(Collection<SaleInvoiceHasItem> saleInvoiceHasItemCollection) {
        this.saleInvoiceHasItemCollection = saleInvoiceHasItemCollection;
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
        if (!(object instanceof SaleInvoice)) {
            return false;
        }
        SaleInvoice other = (SaleInvoice) object;
        if ((this.invNo == null && other.invNo != null) || (this.invNo != null && !this.invNo.equals(other.invNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ent.SaleInvoice[ invNo=" + invNo + " ]";
    }
    
}
