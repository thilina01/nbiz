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

/**
 *
 * @author Thilina Ranathunga
 */
@Entity
@Table(name = "menu")
@NamedQueries({
    @NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m"),
    @NamedQuery(name = "Menu.findByMenu", query = "SELECT m FROM Menu m WHERE m.menu = :menu"),
    @NamedQuery(name = "Menu.findByStatus", query = "SELECT m FROM Menu m WHERE m.status = :status")})
public class Menu implements Serializable, Comparable<Menu> {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "menu")
    private String menu;
    @Column(name = "status")
    private Integer status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "menu")
    private Collection<MenuItem> menuItemCollection;

    public Menu() {
    }

    public Menu(String menu) {
        this.menu = menu;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Collection<MenuItem> getMenuItemCollection() {
        return menuItemCollection;
    }

    public void setMenuItemCollection(Collection<MenuItem> menuItemCollection) {
        this.menuItemCollection = menuItemCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (menu != null ? menu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        if ((this.menu == null && other.menu != null) || (this.menu != null && !this.menu.equals(other.menu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return menu;
    }

    @Override
    public int compareTo(Menu o) {
        return menu.compareTo(o.getMenu());
    }

}
