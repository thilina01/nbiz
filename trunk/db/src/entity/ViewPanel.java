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
import javax.persistence.ManyToMany;
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
@Table(name = "view_panel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ViewPanel.findAll", query = "SELECT v FROM ViewPanel v"),
    @NamedQuery(name = "ViewPanel.findByViewPanel", query = "SELECT v FROM ViewPanel v WHERE v.viewPanel = :viewPanel")})
public class ViewPanel implements Serializable {
    @ManyToMany(mappedBy = "viewPanelCollection")
    private Collection<Operator> operatorCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "view_panel")
    private String viewPanel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "viewPanel")
    private Collection<OptionalComponent> optionalComponentCollection;

    public ViewPanel() {
    }

    public ViewPanel(String viewPanel) {
        this.viewPanel = viewPanel;
    }

    public String getViewPanel() {
        return viewPanel;
    }

    public void setViewPanel(String viewPanel) {
        this.viewPanel = viewPanel;
    }

    @XmlTransient
    public Collection<OptionalComponent> getOptionalComponentCollection() {
        return optionalComponentCollection;
    }

    public void setOptionalComponentCollection(Collection<OptionalComponent> optionalComponentCollection) {
        this.optionalComponentCollection = optionalComponentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (viewPanel != null ? viewPanel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ViewPanel)) {
            return false;
        }
        ViewPanel other = (ViewPanel) object;
        if ((this.viewPanel == null && other.viewPanel != null) || (this.viewPanel != null && !this.viewPanel.equals(other.viewPanel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return viewPanel;
    }

    @XmlTransient
    public Collection<Operator> getOperatorCollection() {
        return operatorCollection;
    }

    public void setOperatorCollection(Collection<Operator> operatorCollection) {
        this.operatorCollection = operatorCollection;
    }
    
}
