/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Thilina Ranathunga
 */
@Embeddable
public class MenuItemPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "menu_menu")
    private String menuMenu;
    @Basic(optional = false)
    @Column(name = "menu_item")
    private String menuItem;

    public MenuItemPK() {
    }

    public MenuItemPK(String menuMenu, String menuItem) {
        this.menuMenu = menuMenu;
        this.menuItem = menuItem;
    }

    public String getMenuMenu() {
        return menuMenu;
    }

    public void setMenuMenu(String menuMenu) {
        this.menuMenu = menuMenu;
    }

    public String getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(String menuItem) {
        this.menuItem = menuItem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (menuMenu != null ? menuMenu.hashCode() : 0);
        hash += (menuItem != null ? menuItem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MenuItemPK)) {
            return false;
        }
        MenuItemPK other = (MenuItemPK) object;
        if ((this.menuMenu == null && other.menuMenu != null) || (this.menuMenu != null && !this.menuMenu.equals(other.menuMenu))) {
            return false;
        }
        if ((this.menuItem == null && other.menuItem != null) || (this.menuItem != null && !this.menuItem.equals(other.menuItem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return util.ToString.get(this);
    }

}
