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
@Table(name = "sub_dealer")
@NamedQueries({
    @NamedQuery(name = "SubDealer.findAll", query = "SELECT s FROM SubDealer s"),
    @NamedQuery(name = "SubDealer.findByCode", query = "SELECT s FROM SubDealer s WHERE s.code = :code"),
    @NamedQuery(name = "SubDealer.findByName", query = "SELECT s FROM SubDealer s WHERE s.name = :name"),
    @NamedQuery(name = "SubDealer.findByOwner", query = "SELECT s FROM SubDealer s WHERE s.owner = :owner"),
    @NamedQuery(name = "SubDealer.findByAddress", query = "SELECT s FROM SubDealer s WHERE s.address = :address"),
    @NamedQuery(name = "SubDealer.findByStreet", query = "SELECT s FROM SubDealer s WHERE s.street = :street"),
    @NamedQuery(name = "SubDealer.findByContact", query = "SELECT s FROM SubDealer s WHERE s.contact = :contact")})
public class SubDealer implements Serializable, Comparable<SubDealer> {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;
    @Column(name = "owner")
    private String owner;
    @Column(name = "address")
    private String address;
    @Column(name = "street")
    private String street;
    @Column(name = "contact")
    private String contact;
    @JoinColumn(name = "town_code", referencedColumnName = "code")
    @ManyToOne(optional = false)
    private Town town;

    public SubDealer() {
    }

    public SubDealer(String code) {
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

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
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
        if (!(object instanceof SubDealer)) {
            return false;
        }
        SubDealer other = (SubDealer) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ent.SubDealer[code=" + code + "]";
    }

    @Override
    public int compareTo(SubDealer o) {
        return code.compareTo(o.getCode());
    }

}
