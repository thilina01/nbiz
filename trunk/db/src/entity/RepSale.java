/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Thilina Ranathunga
 */
@Entity
@Table(name = "rep_sale")
@NamedQueries({
    @NamedQuery(name = "RepSale.findAll", query = "SELECT r FROM RepSale r"),
    @NamedQuery(name = "RepSale.findBySaleDate", query = "SELECT r FROM RepSale r WHERE r.repSalePK.saleDate = :saleDate"),
    @NamedQuery(name = "RepSale.findByItemCode", query = "SELECT r FROM RepSale r WHERE r.repSalePK.itemCode = :itemCode"),
    @NamedQuery(name = "RepSale.findByEmployeeCode", query = "SELECT r FROM RepSale r WHERE r.repSalePK.employeeCode = :employeeCode"),
    @NamedQuery(name = "RepSale.findByLoaded", query = "SELECT r FROM RepSale r WHERE r.loaded = :loaded"),
    @NamedQuery(name = "RepSale.findByRemaining", query = "SELECT r FROM RepSale r WHERE r.remaining = :remaining"),
    @NamedQuery(name = "RepSale.findByRate", query = "SELECT r FROM RepSale r WHERE r.rate = :rate"),
    @NamedQuery(name = "RepSale.findByLoadedBundles", query = "SELECT r FROM RepSale r WHERE r.loadedBundles = :loadedBundles"),
    @NamedQuery(name = "RepSale.findByRemainingBundles", query = "SELECT r FROM RepSale r WHERE r.remainingBundles = :remainingBundles")})
public class RepSale implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RepSalePK repSalePK;
    @Column(name = "loaded")
    private Double loaded;
    @Column(name = "remaining")
    private Double remaining;
    @Column(name = "rate")
    private Double rate;
    @Column(name = "loaded_Bundles")
    private Double loadedBundles;
    @Column(name = "remaining_Bundles")
    private Double remainingBundles;
    @JoinColumn(name = "employee_code", referencedColumnName = "code", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Employee employee;
    @JoinColumn(name = "item_code", referencedColumnName = "code", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Item item;

    public RepSale() {
    }

    public RepSale(RepSalePK repSalePK) {
        this.repSalePK = repSalePK;
    }

    public RepSale(Date saleDate, String itemCode, String employeeCode) {
        this.repSalePK = new RepSalePK(saleDate, itemCode, employeeCode);
    }

    public RepSalePK getRepSalePK() {
        return repSalePK;
    }

    public void setRepSalePK(RepSalePK repSalePK) {
        this.repSalePK = repSalePK;
    }

    public Double getLoaded() {
        return loaded;
    }

    public void setLoaded(Double loaded) {
        this.loaded = loaded;
    }

    public Double getRemaining() {
        return remaining;
    }

    public void setRemaining(Double remaining) {
        this.remaining = remaining;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Double getLoadedBundles() {
        return loadedBundles;
    }

    public void setLoadedBundles(Double loadedBundles) {
        this.loadedBundles = loadedBundles;
    }

    public Double getRemainingBundles() {
        return remainingBundles;
    }

    public void setRemainingBundles(Double remainingBundles) {
        this.remainingBundles = remainingBundles;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (repSalePK != null ? repSalePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RepSale)) {
            return false;
        }
        RepSale other = (RepSale) object;
        if ((this.repSalePK == null && other.repSalePK != null) || (this.repSalePK != null && !this.repSalePK.equals(other.repSalePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ent.RepSale[repSalePK=" + repSalePK + "]";
    }

}
