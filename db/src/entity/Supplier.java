/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Thilina
 */
@Entity
@Table(name = "supplier")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Supplier.findAll", query = "SELECT s FROM Supplier s"),
    @NamedQuery(name = "Supplier.findByCode", query = "SELECT s FROM Supplier s WHERE s.code = :code"),
    @NamedQuery(name = "Supplier.findByName", query = "SELECT s FROM Supplier s WHERE s.name = :name"),
    @NamedQuery(name = "Supplier.findByAddressNumber", query = "SELECT s FROM Supplier s WHERE s.addressNumber = :addressNumber"),
    @NamedQuery(name = "Supplier.findByAddressStreet", query = "SELECT s FROM Supplier s WHERE s.addressStreet = :addressStreet"),
    @NamedQuery(name = "Supplier.findByCity", query = "SELECT s FROM Supplier s WHERE s.city = :city"),
    @NamedQuery(name = "Supplier.findByMobile", query = "SELECT s FROM Supplier s WHERE s.mobile = :mobile"),
    @NamedQuery(name = "Supplier.findByFixedLine", query = "SELECT s FROM Supplier s WHERE s.fixedLine = :fixedLine"),
    @NamedQuery(name = "Supplier.findByFax", query = "SELECT s FROM Supplier s WHERE s.fax = :fax"),
    @NamedQuery(name = "Supplier.findByNotes", query = "SELECT s FROM Supplier s WHERE s.notes = :notes"),
    @NamedQuery(name = "Supplier.findByVat", query = "SELECT s FROM Supplier s WHERE s.vat = :vat"),
    @NamedQuery(name = "Supplier.findBySvat", query = "SELECT s FROM Supplier s WHERE s.svat = :svat")})
public class Supplier implements Serializable, Comparable<Supplier> {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;
    @Column(name = "address_Number")
    private String addressNumber;
    @Column(name = "address_Street")
    private String addressStreet;
    @Column(name = "city")
    private String city;
    @Column(name = "mobile")
    private String mobile;
    @Column(name = "fixed_Line")
    private String fixedLine;
    @Column(name = "fax")
    private String fax;
    @Column(name = "notes")
    private String notes;
    @Column(name = "vat")
    private String vat;
    @Column(name = "svat")
    private String svat;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplier")
    private Collection<SupplierHasBank> supplierHasBankCollection;
    @JoinColumn(name = "town_code", referencedColumnName = "code")
    @ManyToOne(optional = false)
    private Town town;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplier")
    private Collection<Item> itemCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplier")
    private Collection<PurchaseInvoice> purchaseInvoiceCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplier")
    private Collection<Svat> svatCollection;

    public Supplier() {
    }

    public Supplier(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getFixedLine() {
        return fixedLine;
    }

    public void setFixedLine(String fixedLine) {
        this.fixedLine = fixedLine;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    public String getSvat() {
        return svat;
    }

    public void setSvat(String svat) {
        this.svat = svat;
    }

    @XmlTransient
    public Collection<SupplierHasBank> getSupplierHasBankCollection() {
        return supplierHasBankCollection;
    }

    public void setSupplierHasBankCollection(Collection<SupplierHasBank> supplierHasBankCollection) {
        this.supplierHasBankCollection = supplierHasBankCollection;
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    @XmlTransient
    public Collection<Item> getItemCollection() {
        return itemCollection;
    }

    public void setItemCollection(Collection<Item> itemCollection) {
        this.itemCollection = itemCollection;
    }

    @XmlTransient
    public Collection<PurchaseInvoice> getPurchaseInvoiceCollection() {
        return purchaseInvoiceCollection;
    }

    public void setPurchaseInvoiceCollection(Collection<PurchaseInvoice> purchaseInvoiceCollection) {
        this.purchaseInvoiceCollection = purchaseInvoiceCollection;
    }

    @XmlTransient
    public Collection<Svat> getSvatCollection() {
        return svatCollection;
    }

    public void setSvatCollection(Collection<Svat> svatCollection) {
        this.svatCollection = svatCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Supplier)) {
            return false;
        }
        Supplier other = (Supplier) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return util.ToString.get(this);
    }

    @Override
    public int compareTo(Supplier o) {
        int result = code.compareTo(o.code);
        try {
            int c1 = Integer.parseInt(code);
            int c2 = Integer.parseInt(o.code);
            result = new Integer(c1).compareTo(c2);
        } catch (NumberFormatException e) {
        }
        return result;
    }
}
