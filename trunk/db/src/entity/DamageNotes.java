/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "damage_notes")
@NamedQueries({
    @NamedQuery(name = "DamageNotes.findAll", query = "SELECT d FROM DamageNotes d"),
    @NamedQuery(name = "DamageNotes.findByQuantity", query = "SELECT d FROM DamageNotes d WHERE d.quantity = :quantity"),
    @NamedQuery(name = "DamageNotes.findByReason", query = "SELECT d FROM DamageNotes d WHERE d.reason = :reason"),
    @NamedQuery(name = "DamageNotes.findByDateTime", query = "SELECT d FROM DamageNotes d WHERE d.damageNotesPK.dateTime = :dateTime"),
    @NamedQuery(name = "DamageNotes.findByItemCode", query = "SELECT d FROM DamageNotes d WHERE d.damageNotesPK.itemCode = :itemCode"),
    @NamedQuery(name = "DamageNotes.findByEmployeeCode", query = "SELECT d FROM DamageNotes d WHERE d.damageNotesPK.employeeCode = :employeeCode"),
    @NamedQuery(name = "DamageNotes.findByOperator", query = "SELECT d FROM DamageNotes d WHERE d.operator = :operator")})
public class DamageNotes implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DamageNotesPK damageNotesPK;
    @Column(name = "quantity")
    private Double quantity;
    @Column(name = "rate")
    private Double rate;
    @Column(name = "reason")
    private String reason;
    @Column(name = "operator")
    private String operator;
    @JoinColumn(name = "employee_code", referencedColumnName = "code", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Employee employee;
    @JoinColumn(name = "item_code", referencedColumnName = "code", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Item item;

    public DamageNotes() {
    }

    public DamageNotes(DamageNotesPK damageNotesPK) {
        this.damageNotesPK = damageNotesPK;
    }

    public DamageNotes(Date dateTime, String itemCode, String employeeCode) {
        this.damageNotesPK = new DamageNotesPK(dateTime, itemCode, employeeCode);
    }

    public DamageNotesPK getDamageNotesPK() {
        return damageNotesPK;
    }

    public void setDamageNotesPK(DamageNotesPK damageNotesPK) {
        this.damageNotesPK = damageNotesPK;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (damageNotesPK != null ? damageNotesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DamageNotes)) {
            return false;
        }
        DamageNotes other = (DamageNotes) object;
        if ((this.damageNotesPK == null && other.damageNotesPK != null) || (this.damageNotesPK != null && !this.damageNotesPK.equals(other.damageNotesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return util.ToString.get(this);
    }

    /**
     * @return the rate
     */
    public Double getRate() {
        return rate;
    }

    /**
     * @param rate the rate to set
     */
    public void setRate(Double rate) {
        this.rate = rate;
    }

}
