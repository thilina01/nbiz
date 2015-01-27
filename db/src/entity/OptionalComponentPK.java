/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Thilina
 */
@Embeddable
public class OptionalComponentPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "view_panel_view_panel")
    private String viewPanelViewPanel;

    public OptionalComponentPK() {
    }

    public OptionalComponentPK(String name, String viewPanelViewPanel) {
        this.name = name;
        this.viewPanelViewPanel = viewPanelViewPanel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getViewPanelViewPanel() {
        return viewPanelViewPanel;
    }

    public void setViewPanelViewPanel(String viewPanelViewPanel) {
        this.viewPanelViewPanel = viewPanelViewPanel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (name != null ? name.hashCode() : 0);
        hash += (viewPanelViewPanel != null ? viewPanelViewPanel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OptionalComponentPK)) {
            return false;
        }
        OptionalComponentPK other = (OptionalComponentPK) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        if ((this.viewPanelViewPanel == null && other.viewPanelViewPanel != null) || (this.viewPanelViewPanel != null && !this.viewPanelViewPanel.equals(other.viewPanelViewPanel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
    }
    
}
