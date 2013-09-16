/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import com.nanosl.lib.db.Manager;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Thilina Ranathunga
 */
@Entity
@Table(name = "item")
@NamedQueries({
    @NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i"),
    @NamedQuery(name = "Item.findByCode", query = "SELECT i FROM Item i WHERE i.code = :code"),
    @NamedQuery(name = "Item.findByDescription", query = "SELECT i FROM Item i WHERE i.description = :description"),
    @NamedQuery(name = "Item.findByBrand", query = "SELECT i FROM Item i WHERE i.brand = :brand"),
    @NamedQuery(name = "Item.findByPackSize", query = "SELECT i FROM Item i WHERE i.packSize = :packSize"),
    @NamedQuery(name = "Item.findByItemRefresh", query = "SELECT i FROM Item i WHERE i.itemRefresh = :itemRefresh"),
    @NamedQuery(name = "Item.findByProfitPersantage", query = "SELECT i FROM Item i WHERE i.profitPersantage = :profitPersantage"),
    @NamedQuery(name = "Item.findByCustomerProfitPersantage", query = "SELECT i FROM Item i WHERE i.customerProfitPersantage = :customerProfitPersantage"),
    @NamedQuery(name = "Item.findByRetailProfitPersantage", query = "SELECT i FROM Item i WHERE i.retailProfitPersantage = :retailProfitPersantage"),
    @NamedQuery(name = "Item.findByOperator", query = "SELECT i FROM Item i WHERE i.operator = :operator")})
public class Item implements Serializable, Comparable<Item> {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "item")
    private Collection<ItemHasPrice> itemHasPriceCollection;
    @JoinColumn(name = "item_type_type", referencedColumnName = "type")
    @ManyToOne(optional = false)
    private ItemType itemTypeType;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "code")
    private String code;
    @Column(name = "description")
    private String description;
    @Column(name = "brand")
    private String brand;
    @Column(name = "packSize")
    private Integer packSize;
    @Column(name = "itemRefresh")
    private Integer itemRefresh;
    @Column(name = "profitPersantage")
    private Double profitPersantage;
    @Column(name = "customerProfitPersantage")
    private Double customerProfitPersantage;
    @Column(name = "retailProfitPersantage")
    private Double retailProfitPersantage;
    @Column(name = "operator")
    private String operator;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "item")
    private Collection<RepStockChange> repStockChangeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "item")
    private Collection<StockTransfer> stockTransferCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "item")
    private Collection<CanceledInvoiceHasItem> canceledInvoiceHasItemCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "item")
    private Collection<StockChange> stockChangeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "item")
    private Collection<SaleInvoiceHasItem> saleInvoiceHasItemCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "item")
    private Stock stock;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "item")
    private Collection<DamageNotes> damageNotesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "item")
    private Collection<RepSale> repSaleCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "item")
    private Collection<PurchaseInvoiceHasItem> purchaseInvoiceHasItemCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "item")
    private DamageStock damageStock;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "item")
    private Collection<OldPrice> oldPriceCollection;
    @JoinColumn(name = "supplier_code", referencedColumnName = "code")
    @ManyToOne(optional = false)
    private Supplier supplier;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "item")
    private Collection<SrStock> srStockCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "item")
    private PriceList priceList;

    public Item() {
    }

    public Item(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getPackSize() {
        return packSize;
    }

    public void setPackSize(Integer packSize) {
        this.packSize = packSize;
    }

    public Integer getItemRefresh() {
        return itemRefresh;
    }

    public void setItemRefresh(Integer itemRefresh) {
        this.itemRefresh = itemRefresh;
    }

    public Double getProfitPersantage() {
        return profitPersantage;
    }

    public void setProfitPersantage(Double profitPersantage) {
        this.profitPersantage = profitPersantage;
    }

    public Double getCustomerProfitPersantage() {
        return customerProfitPersantage;
    }

    public void setCustomerProfitPersantage(Double customerProfitPersantage) {
        this.customerProfitPersantage = customerProfitPersantage;
    }

    public Double getRetailProfitPersantage() {
        return retailProfitPersantage;
    }

    public void setRetailProfitPersantage(Double retailProfitPersantage) {
        this.retailProfitPersantage = retailProfitPersantage;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Collection<RepStockChange> getRepStockChangeCollection() {
        return repStockChangeCollection;
    }

    public void setRepStockChangeCollection(Collection<RepStockChange> repStockChangeCollection) {
        this.repStockChangeCollection = repStockChangeCollection;
    }

    public Collection<StockTransfer> getStockTransferCollection() {
        return stockTransferCollection;
    }

    public void setStockTransferCollection(Collection<StockTransfer> stockTransferCollection) {
        this.stockTransferCollection = stockTransferCollection;
    }

    public Collection<CanceledInvoiceHasItem> getCanceledInvoiceHasItemCollection() {
        return canceledInvoiceHasItemCollection;
    }

    public void setCanceledInvoiceHasItemCollection(Collection<CanceledInvoiceHasItem> canceledInvoiceHasItemCollection) {
        this.canceledInvoiceHasItemCollection = canceledInvoiceHasItemCollection;
    }

    public Collection<StockChange> getStockChangeCollection() {
        return stockChangeCollection;
    }

    public void setStockChangeCollection(Collection<StockChange> stockChangeCollection) {
        this.stockChangeCollection = stockChangeCollection;
    }

    public Collection<SaleInvoiceHasItem> getSaleInvoiceHasItemCollection() {
        return saleInvoiceHasItemCollection;
    }

    public void setSaleInvoiceHasItemCollection(Collection<SaleInvoiceHasItem> saleInvoiceHasItemCollection) {
        this.saleInvoiceHasItemCollection = saleInvoiceHasItemCollection;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public Collection<DamageNotes> getDamageNotesCollection() {
        return damageNotesCollection;
    }

    public void setDamageNotesCollection(Collection<DamageNotes> damageNotesCollection) {
        this.damageNotesCollection = damageNotesCollection;
    }

    public Collection<RepSale> getRepSaleCollection() {
        return repSaleCollection;
    }

    public void setRepSaleCollection(Collection<RepSale> repSaleCollection) {
        this.repSaleCollection = repSaleCollection;
    }

    public Collection<PurchaseInvoiceHasItem> getPurchaseInvoiceHasItemCollection() {
        return purchaseInvoiceHasItemCollection;
    }

    public void setPurchaseInvoiceHasItemCollection(Collection<PurchaseInvoiceHasItem> purchaseInvoiceHasItemCollection) {
        this.purchaseInvoiceHasItemCollection = purchaseInvoiceHasItemCollection;
    }

    public DamageStock getDamageStock() {
        return damageStock;
    }

    public void setDamageStock(DamageStock damageStock) {
        this.damageStock = damageStock;
    }

    public Collection<OldPrice> getOldPriceCollection() {
        return oldPriceCollection;
    }

    public void setOldPriceCollection(Collection<OldPrice> oldPriceCollection) {
        this.oldPriceCollection = oldPriceCollection;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Collection<SrStock> getSrStockCollection() {
        return srStockCollection;
    }

    public void setSrStockCollection(Collection<SrStock> srStockCollection) {
        this.srStockCollection = srStockCollection;
    }

    public PriceList getPriceList() {
        double price = 0;
        if (priceList == null) {
            priceList = new PriceList(getCode());
            priceList.setCostPack(price);
            priceList.setCostUnit(price);
            priceList.setSellingPack(price);
            priceList.setSellingUnit(price);
            priceList.setItem(this);
            Manager.getInstance().update(priceList);
        } else if (priceList.getSellingPack() == null) {
            priceList.setSellingPack(price);
            Manager.getInstance().update(priceList);
        }

        return priceList;
    }

    public void setPriceList(PriceList priceList) {
        this.priceList = priceList;
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
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return code + " " + description + "\t [" + getPriceList().getSellingPack() + " | " + getPriceList().getCostPack() + "]";
    }

    @Override
    public int compareTo(Item o) {
        int result = code.compareTo(o.code);
//        try {
//            int c1 = Integer.parseInt(code);
//            int c2 = Integer.parseInt(o.code);
//            result = new Integer(c1).compareTo(new Integer(c2));

//        } catch (Exception e) {
//        }
        return result;
    }

    @XmlTransient
    public Collection<ItemHasPrice> getItemHasPriceCollection() {
        return itemHasPriceCollection;
    }

    public void setItemHasPriceCollection(Collection<ItemHasPrice> itemHasPriceCollection) {
        this.itemHasPriceCollection = itemHasPriceCollection;
    }

    public ItemType getItemTypeType() {
        return itemTypeType;
    }

    public void setItemTypeType(ItemType itemTypeType) {
        this.itemTypeType = itemTypeType;
    }
}
