/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Thilina Ranathunga
 */
@Entity
@Table(name = "view_panel")
@NamedQueries({
    @NamedQuery(name = "ViewPanel.findAll", query = "SELECT v FROM ViewPanel v"),
    @NamedQuery(name = "ViewPanel.findByViewPanel", query = "SELECT v FROM ViewPanel v WHERE v.viewPanel = :viewPanel")})
public class ViewPanel implements Serializable, Comparable<ViewPanel> {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "view_panel")
    private String viewPanel;
    @ManyToMany(mappedBy = "viewPanelCollection")
    private Collection<Operator> operatorCollection;

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

    public Collection<Operator> getOperatorCollection() {
        return operatorCollection;
    }

    public void setOperatorCollection(Collection<Operator> operatorCollection) {
        this.operatorCollection = operatorCollection;
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

    @Override
    public int compareTo(ViewPanel o) {
        return viewPanel.compareTo(o.getViewPanel());
    }

}
