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
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Thilina
 */
@Entity
@Table(name = "svat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Svat.findAll", query = "SELECT s FROM Svat s"),
    @NamedQuery(name = "Svat.findBySerialNumber", query = "SELECT s FROM Svat s WHERE s.serialNumber = :serialNumber"),
    @NamedQuery(name = "Svat.findBySvatAmount", query = "SELECT s FROM Svat s WHERE s.svatAmount = :svatAmount"),
    @NamedQuery(name = "Svat.findByPurchasingAmount", query = "SELECT s FROM Svat s WHERE s.purchasingAmount = :purchasingAmount"),
    @NamedQuery(name = "Svat.findByIssuedDate", query = "SELECT s FROM Svat s WHERE s.issuedDate = :issuedDate"),
    @NamedQuery(name = "Svat.findByEndingMonth", query = "SELECT s FROM Svat s WHERE s.endingMonth = :endingMonth")})
public class Svat implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "serial_number")
    private Integer serialNumber;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "svat_amount")
    private Double svatAmount;
    @Column(name = "purchasing_amount")
    private Double purchasingAmount;
    @Column(name = "issued_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date issuedDate;
    @Column(name = "ending_month")
    @Temporal(TemporalType.DATE)
    private Date endingMonth;
    @JoinColumn(name = "supplier_code", referencedColumnName = "code")
    @ManyToOne(optional = false)
    private Supplier supplier;

    public Svat() {
    }

    public Svat(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Double getSvatAmount() {
        return svatAmount;
    }

    public void setSvatAmount(Double svatAmount) {
        this.svatAmount = svatAmount;
    }

    public Double getPurchasingAmount() {
        return purchasingAmount;
    }

    public void setPurchasingAmount(Double purchasingAmount) {
        this.purchasingAmount = purchasingAmount;
    }

    public Date getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }

    public Date getEndingMonth() {
        return endingMonth;
    }

    public void setEndingMonth(Date endingMonth) {
        this.endingMonth = endingMonth;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (serialNumber != null ? serialNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Svat)) {
            return false;
        }
        Svat other = (Svat) object;
        if ((this.serialNumber == null && other.serialNumber != null) || (this.serialNumber != null && !this.serialNumber.equals(other.serialNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Svat[ serialNumber=" + serialNumber + " ]";
    }
    
}
