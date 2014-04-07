/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Thilina Ranathunga
 */
@Entity
@Table(name = "company")
@NamedQueries({
    @NamedQuery(name = "Company.findAll", query = "SELECT c FROM Company c"),
    @NamedQuery(name = "Company.findByCode", query = "SELECT c FROM Company c WHERE c.code = :code"),
    @NamedQuery(name = "Company.findByName", query = "SELECT c FROM Company c WHERE c.name = :name"),
    @NamedQuery(name = "Company.findBySloganOne", query = "SELECT c FROM Company c WHERE c.sloganOne = :sloganOne"),
    @NamedQuery(name = "Company.findBySloganTwo", query = "SELECT c FROM Company c WHERE c.sloganTwo = :sloganTwo"),
    @NamedQuery(name = "Company.findByAddressNumber", query = "SELECT c FROM Company c WHERE c.addressNumber = :addressNumber"),
    @NamedQuery(name = "Company.findByAddressStreet", query = "SELECT c FROM Company c WHERE c.addressStreet = :addressStreet"),
    @NamedQuery(name = "Company.findByAddressCity", query = "SELECT c FROM Company c WHERE c.addressCity = :addressCity"),
    @NamedQuery(name = "Company.findByContactOne", query = "SELECT c FROM Company c WHERE c.contactOne = :contactOne"),
    @NamedQuery(name = "Company.findByContactTwo", query = "SELECT c FROM Company c WHERE c.contactTwo = :contactTwo"),
    @NamedQuery(name = "Company.findByFax", query = "SELECT c FROM Company c WHERE c.fax = :fax"),
    @NamedQuery(name = "Company.findByEmail", query = "SELECT c FROM Company c WHERE c.email = :email"),
    @NamedQuery(name = "Company.findByWeb", query = "SELECT c FROM Company c WHERE c.web = :web")})
public class Company implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "code")
    private String code;
    @Column(name = "Name")
    private String name;
    @Column(name = "slogan_one")
    private String sloganOne;
    @Column(name = "slogan_two")
    private String sloganTwo;
    @Column(name = "address_number")
    private String addressNumber;
    @Column(name = "address_street")
    private String addressStreet;
    @Column(name = "address_city")
    private String addressCity;
    @Column(name = "contact_one")
    private String contactOne;
    @Column(name = "contact_two")
    private String contactTwo;
    @Column(name = "fax")
    private String fax;
    @Column(name = "email")
    private String email;
    @Column(name = "web")
    private String web;

    public Company() {
    }

    public Company(String code) {
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

    public String getSloganOne() {
        return sloganOne;
    }

    public void setSloganOne(String sloganOne) {
        this.sloganOne = sloganOne;
    }

    public String getSloganTwo() {
        return sloganTwo;
    }

    public void setSloganTwo(String sloganTwo) {
        this.sloganTwo = sloganTwo;
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

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getContactOne() {
        return contactOne;
    }

    public void setContactOne(String contactOne) {
        this.contactOne = contactOne;
    }

    public String getContactTwo() {
        return contactTwo;
    }

    public void setContactTwo(String contactTwo) {
        this.contactTwo = contactTwo;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
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
        if (!(object instanceof Company)) {
            return false;
        }
        Company other = (Company) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return util.ToString.get(this);
    }

}
