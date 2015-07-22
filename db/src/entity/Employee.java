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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "employee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e"),
    @NamedQuery(name = "Employee.findByCode", query = "SELECT e FROM Employee e WHERE e.code = :code"),
    @NamedQuery(name = "Employee.findByFixedLine", query = "SELECT e FROM Employee e WHERE e.fixedLine = :fixedLine"),
    @NamedQuery(name = "Employee.findByNotes", query = "SELECT e FROM Employee e WHERE e.notes = :notes"),
    @NamedQuery(name = "Employee.findBySource", query = "SELECT e FROM Employee e WHERE e.source = :source")})
public class Employee implements Serializable, Comparable<Employee> {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "code")
    private String code;
    @Column(name = "Fixed_Line")
    private String fixedLine;
    @Column(name = "notes")
    private String notes;
    @Column(name = "source")
    private Integer source;
    @JoinTable(name = "employee_has_root_area", joinColumns = {
        @JoinColumn(name = "employee_code", referencedColumnName = "code")}, inverseJoinColumns = {
        @JoinColumn(name = "root_area_code", referencedColumnName = "code")})
    @ManyToMany
    private Collection<RootArea> rootAreaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    private Collection<RepSale> repSaleCollection;
    @JoinColumn(name = "employee_position_code", referencedColumnName = "code")
    @ManyToOne(optional = false)
    private EmployeePosition employeePosition;
    @JoinColumn(name = "person_nic", referencedColumnName = "nic")
    @ManyToOne(optional = false)
    private Person person;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    private Collection<Operator> operatorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    private Collection<SrSalesPayments> srSalesPaymentsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    private Collection<RepStockChange> repStockChangeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    private Collection<StockTransfer> stockTransferCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    private Collection<OperatorDeleted> operatorDeletedCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    private Collection<RepSaleValue> repSaleValueCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    private Collection<SrStock> srStockCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    private Collection<SaleInvoice> saleInvoiceCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    private Collection<DamageNotes> damageNotesCollection;

    public Employee() {
    }

    public Employee(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFixedLine() {
        return fixedLine;
    }

    public void setFixedLine(String fixedLine) {
        this.fixedLine = fixedLine;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    @XmlTransient
    public Collection<RootArea> getRootAreaCollection() {
        return rootAreaCollection;
    }

    public void setRootAreaCollection(Collection<RootArea> rootAreaCollection) {
        this.rootAreaCollection = rootAreaCollection;
    }

    @XmlTransient
    public Collection<RepSale> getRepSaleCollection() {
        return repSaleCollection;
    }

    public void setRepSaleCollection(Collection<RepSale> repSaleCollection) {
        this.repSaleCollection = repSaleCollection;
    }

    public EmployeePosition getEmployeePosition() {
        return employeePosition;
    }

    public void setEmployeePosition(EmployeePosition employeePosition) {
        this.employeePosition = employeePosition;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @XmlTransient
    public Collection<Operator> getOperatorCollection() {
        return operatorCollection;
    }

    public void setOperatorCollection(Collection<Operator> operatorCollection) {
        this.operatorCollection = operatorCollection;
    }

    @XmlTransient
    public Collection<SrSalesPayments> getSrSalesPaymentsCollection() {
        return srSalesPaymentsCollection;
    }

    public void setSrSalesPaymentsCollection(Collection<SrSalesPayments> srSalesPaymentsCollection) {
        this.srSalesPaymentsCollection = srSalesPaymentsCollection;
    }

    @XmlTransient
    public Collection<RepStockChange> getRepStockChangeCollection() {
        return repStockChangeCollection;
    }

    public void setRepStockChangeCollection(Collection<RepStockChange> repStockChangeCollection) {
        this.repStockChangeCollection = repStockChangeCollection;
    }

    @XmlTransient
    public Collection<StockTransfer> getStockTransferCollection() {
        return stockTransferCollection;
    }

    public void setStockTransferCollection(Collection<StockTransfer> stockTransferCollection) {
        this.stockTransferCollection = stockTransferCollection;
    }

    @XmlTransient
    public Collection<OperatorDeleted> getOperatorDeletedCollection() {
        return operatorDeletedCollection;
    }

    public void setOperatorDeletedCollection(Collection<OperatorDeleted> operatorDeletedCollection) {
        this.operatorDeletedCollection = operatorDeletedCollection;
    }

    @XmlTransient
    public Collection<RepSaleValue> getRepSaleValueCollection() {
        return repSaleValueCollection;
    }

    public void setRepSaleValueCollection(Collection<RepSaleValue> repSaleValueCollection) {
        this.repSaleValueCollection = repSaleValueCollection;
    }

    @XmlTransient
    public Collection<SrStock> getSrStockCollection() {
        return srStockCollection;
    }

    public void setSrStockCollection(Collection<SrStock> srStockCollection) {
        this.srStockCollection = srStockCollection;
    }

    @XmlTransient
    public Collection<SaleInvoice> getSaleInvoiceCollection() {
        return saleInvoiceCollection;
    }

    public void setSaleInvoiceCollection(Collection<SaleInvoice> saleInvoiceCollection) {
        this.saleInvoiceCollection = saleInvoiceCollection;
    }

    @XmlTransient
    public Collection<DamageNotes> getDamageNotesCollection() {
        return damageNotesCollection;
    }

    public void setDamageNotesCollection(Collection<DamageNotes> damageNotesCollection) {
        this.damageNotesCollection = damageNotesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return util.ToString.get(this);
    }

    @Override
    public int compareTo(Employee o) {
        if (person == null) {
            return code.compareTo(o.code);
        }
        return person.getName().compareTo(o.getPerson().getName());
    }
}
