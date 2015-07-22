/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Thilina
 */
@Entity
@Table(name = "tool_bar_button")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ToolBarButton.findAll", query = "SELECT t FROM ToolBarButton t"),
    @NamedQuery(name = "ToolBarButton.findByComponentName", query = "SELECT t FROM ToolBarButton t WHERE t.componentName = :componentName"),
    @NamedQuery(name = "ToolBarButton.findByButtonText", query = "SELECT t FROM ToolBarButton t WHERE t.buttonText = :buttonText"),
    @NamedQuery(name = "ToolBarButton.findByIconPath", query = "SELECT t FROM ToolBarButton t WHERE t.iconPath = :iconPath"),
    @NamedQuery(name = "ToolBarButton.findByStatus", query = "SELECT t FROM ToolBarButton t WHERE t.status = :status")})
public class ToolBarButton implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "component_name")
    private String componentName;
    @Column(name = "button_text")
    private String buttonText;
    @Column(name = "icon_path")
    private String iconPath;
    @Column(name = "status")
    private Integer status;

    public ToolBarButton() {
    }

    public ToolBarButton(String componentName) {
        this.componentName = componentName;
    }

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public String getButtonText() {
        return buttonText;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (componentName != null ? componentName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ToolBarButton)) {
            return false;
        }
        ToolBarButton other = (ToolBarButton) object;
        if ((this.componentName == null && other.componentName != null) || (this.componentName != null && !this.componentName.equals(other.componentName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return componentName;
    }

}
