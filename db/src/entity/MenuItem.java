/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
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
@Table(name = "menu_item")
@NamedQueries({
    @NamedQuery(name = "MenuItem.findAll", query = "SELECT m FROM MenuItem m"),
    @NamedQuery(name = "MenuItem.findByMenuMenu", query = "SELECT m FROM MenuItem m WHERE m.menuItemPK.menuMenu = :menuMenu"),
    @NamedQuery(name = "MenuItem.findByMenuItem", query = "SELECT m FROM MenuItem m WHERE m.menuItemPK.menuItem = :menuItem"),
    @NamedQuery(name = "MenuItem.findByStatus", query = "SELECT m FROM MenuItem m WHERE m.status = :status")})
public class MenuItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MenuItemPK menuItemPK;
    @Column(name = "status")
    private Integer status;
    @JoinColumn(name = "menu_menu", referencedColumnName = "menu", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Menu menu;

    public MenuItem() {
    }

    public MenuItem(MenuItemPK menuItemPK) {
        this.menuItemPK = menuItemPK;
    }

    public MenuItem(String menuMenu, String menuItem) {
        this.menuItemPK = new MenuItemPK(menuMenu, menuItem);
    }

    public MenuItemPK getMenuItemPK() {
        return menuItemPK;
    }

    public void setMenuItemPK(MenuItemPK menuItemPK) {
        this.menuItemPK = menuItemPK;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (menuItemPK != null ? menuItemPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MenuItem)) {
            return false;
        }
        MenuItem other = (MenuItem) object;
        if ((this.menuItemPK == null && other.menuItemPK != null) || (this.menuItemPK != null && !this.menuItemPK.equals(other.menuItemPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return menuItemPK.getMenuItem();
    }
}
