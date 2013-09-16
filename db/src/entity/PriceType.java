/*
 * To change this template, choose Tools | Templates
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
@Table(name = "price_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PriceType.findAll", query = "SELECT p FROM PriceType p"),
    @NamedQuery(name = "PriceType.findByType", query = "SELECT p FROM PriceType p WHERE p.type = :type")})
public class PriceType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "type")
    private String type;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "priceType")
    private Collection<ItemHasPrice> itemHasPriceCollection;

    public PriceType() {
    }

    public PriceType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @XmlTransient
    public Collection<ItemHasPrice> getItemHasPriceCollection() {
        return itemHasPriceCollection;
    }

    public void setItemHasPriceCollection(Collection<ItemHasPrice> itemHasPriceCollection) {
        this.itemHasPriceCollection = itemHasPriceCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (type != null ? type.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PriceType)) {
            return false;
        }
        PriceType other = (PriceType) object;
        if ((this.type == null && other.type != null) || (this.type != null && !this.type.equals(other.type))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ent.PriceType[ type=" + type + " ]";
    }
    
}
