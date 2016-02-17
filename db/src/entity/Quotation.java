/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
@Table(name = "quotation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Quotation.findAll", query = "SELECT q FROM Quotation q"),
    @NamedQuery(name = "Quotation.findByQuotationNo", query = "SELECT q FROM Quotation q WHERE q.quotationNo = :quotationNo"),
    @NamedQuery(name = "Quotation.findByAmount", query = "SELECT q FROM Quotation q WHERE q.amount = :amount"),
    @NamedQuery(name = "Quotation.findByDiscount", query = "SELECT q FROM Quotation q WHERE q.discount = :discount"),
    @NamedQuery(name = "Quotation.findByQuotationTime", query = "SELECT q FROM Quotation q WHERE q.quotationTime = :quotationTime"),
    @NamedQuery(name = "Quotation.findByOperator", query = "SELECT q FROM Quotation q WHERE q.operator = :operator"),
    @NamedQuery(name = "Quotation.findByPrinted", query = "SELECT q FROM Quotation q WHERE q.printed = :printed"),
    @NamedQuery(name = "Quotation.findByCustomerName", query = "SELECT q FROM Quotation q WHERE q.customerName = :customerName"),
    @NamedQuery(name = "Quotation.findByEmployeeCode", query = "SELECT q FROM Quotation q WHERE q.employeeCode = :employeeCode")})
public class Quotation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "quotation_no")
    private String quotationNo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "amount")
    private Double amount;
    @Column(name = "discount")
    private Double discount;
    @Column(name = "quotation_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date quotationTime;
    @Column(name = "operator")
    private String operator;
    @Column(name = "printed")
    private Integer printed;
    @Column(name = "customer_name")
    private String customerName;
    @Column(name = "employee_code")
    private String employeeCode;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "quotation")
    private Collection<QuotationHasItem> quotationHasItemCollection;
    @JoinColumn(name = "customer_code", referencedColumnName = "code")
    @ManyToOne
    private Customer customer;

    public Quotation() {
    }

    public Quotation(String quotationNo) {
        this.quotationNo = quotationNo;
    }

    public String getQuotationNo() {
        return quotationNo;
    }

    public void setQuotationNo(String quotationNo) {
        this.quotationNo = quotationNo;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Date getQuotationTime() {
        return quotationTime;
    }

    public void setQuotationTime(Date quotationTime) {
        this.quotationTime = quotationTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Integer getPrinted() {
        return printed;
    }

    public void setPrinted(Integer printed) {
        this.printed = printed;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    @XmlTransient
    public Collection<QuotationHasItem> getQuotationHasItemCollection() {
        return quotationHasItemCollection;
    }

    public void setQuotationHasItemCollection(Collection<QuotationHasItem> quotationHasItemCollection) {
        this.quotationHasItemCollection = quotationHasItemCollection;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (quotationNo != null ? quotationNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Quotation)) {
            return false;
        }
        Quotation other = (Quotation) object;
        if ((this.quotationNo == null && other.quotationNo != null) || (this.quotationNo != null && !this.quotationNo.equals(other.quotationNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbr.entity.Quotation[ quotationNo=" + quotationNo + " ]";
    }
    
}
