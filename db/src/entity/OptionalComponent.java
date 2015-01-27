/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Thilina
 */
@Entity
@Table(name = "optional_component")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OptionalComponent.findAll", query = "SELECT o FROM OptionalComponent o"),
    @NamedQuery(name = "OptionalComponent.findByName", query = "SELECT o FROM OptionalComponent o WHERE o.optionalComponentPK.name = :name"),
    @NamedQuery(name = "OptionalComponent.findByStatus", query = "SELECT o FROM OptionalComponent o WHERE o.status = :status"),
    @NamedQuery(name = "OptionalComponent.findByViewPanelViewPanel", query = "SELECT o FROM OptionalComponent o WHERE o.optionalComponentPK.viewPanelViewPanel = :viewPanelViewPanel")})
public class OptionalComponent implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OptionalComponentPK optionalComponentPK;
    @Column(name = "status")
    private Integer status;
    @JoinColumn(name = "view_panel_view_panel", referencedColumnName = "view_panel", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ViewPanel viewPanel;

    public OptionalComponent() {
    }

    public OptionalComponent(OptionalComponentPK optionalComponentPK) {
        this.optionalComponentPK = optionalComponentPK;
    }

    public OptionalComponent(String name, String viewPanelViewPanel) {
        this.optionalComponentPK = new OptionalComponentPK(name, viewPanelViewPanel);
    }

    public OptionalComponentPK getOptionalComponentPK() {
        return optionalComponentPK;
    }

    public void setOptionalComponentPK(OptionalComponentPK optionalComponentPK) {
        this.optionalComponentPK = optionalComponentPK;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public ViewPanel getViewPanel() {
        return viewPanel;
    }

    public void setViewPanel(ViewPanel viewPanel) {
        this.viewPanel = viewPanel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (optionalComponentPK != null ? optionalComponentPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OptionalComponent)) {
            return false;
        }
        OptionalComponent other = (OptionalComponent) object;
        if ((this.optionalComponentPK == null && other.optionalComponentPK != null) || (this.optionalComponentPK != null && !this.optionalComponentPK.equals(other.optionalComponentPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return optionalComponentPK.getName() ;
    }
    
}
