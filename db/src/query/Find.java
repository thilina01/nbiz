package query;

import com.nanosl.lib.db.Manager;
import entity.CollectionReceipt;
import entity.Customer;
import entity.DamageNotes;
import entity.Employee;
import entity.Expenses;
import entity.IssuedCash;
import entity.IssuedCheque;
import entity.Item;
import entity.Menu;
import entity.PurchaseInvoice;
import entity.PurchaseInvoiceHasItem;
import entity.SaleCheque;
import entity.SaleInvoice;
import entity.SaleInvoiceHasItem;
import entity.SrSalesPayments;
import entity.Stock;
import entity.StockTransfer;
import entity.Supplier;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Query;
import javax.persistence.Table;

/**
 *
 * @author t
 * @NamedQuery(name = "Bank.findAll", query = "SELECT b FROM Bank b"),
 * @NamedQuery(name = "Bank.findByCode", query = "SELECT b FROM Bank b WHERE
 * b.code = :code"),
 * @NamedQuery(name = "Bank.findByName", query = "SELECT b FROM Bank b WHERE
 * b.name = :name")
 */
@Entity
@Table(name = "find")
@NamedQueries({
    @NamedQuery(name = "Customer.findBy$", query = "SELECT c FROM Customer c WHERE  UPPER(c.code) LIKE UPPER(:text) OR UPPER(c.nic) LIKE UPPER(:text) OR UPPER(c.name) LIKE UPPER(:text) "),
    @NamedQuery(name = "DamageNotes.findByDateTimeAndEmployeeCode", query = "SELECT d FROM DamageNotes d WHERE d.damageNotesPK.dateTime = :dateTime AND d.damageNotesPK.employeeCode = :employeeCode"),
    @NamedQuery(name = "Item.findBy$", query = "SELECT i FROM Item i WHERE  UPPER(i.code) LIKE UPPER(:text) OR UPPER(i.description) LIKE UPPER(:text) OR UPPER(i.brand) LIKE UPPER(:text) "),
    @NamedQuery(name = "PurchaseInvoice.findByInvDates", query = "SELECT p FROM PurchaseInvoice p WHERE p.invDate BETWEEN :startDate AND :endDate"),
    @NamedQuery(name = "SaleInvoice.findByInvDates", query = "SELECT s FROM SaleInvoice s WHERE s.invTime BETWEEN :startDate AND :endDate"),
    @NamedQuery(name = "SaleInvoice.findByCard", query = "SELECT s FROM SaleInvoice s WHERE s.cardNumber = :card"),
    @NamedQuery(name = "SaleInvoice.findAllCards", query = "SELECT s FROM SaleInvoice s WHERE s.cardNumber IS NOT NULL"),
    @NamedQuery(name = "SaleInvoice.findActiveCardsByNic", query = "SELECT s FROM SaleInvoice s WHERE s.customer.nic = :nic AND s.cardNumber IS NOT NULL AND s.amount> s.receivedAmount"),
    @NamedQuery(name = "SaleInvoiceHasItem.findByItemAndInvDates", query = "SELECT s FROM SaleInvoiceHasItem s WHERE s.item = :item AND s.saleInvoice.invTime BETWEEN :startDate AND :endDate"),
    @NamedQuery(name = "SaleInvoiceHasItem.findByInvDates", query = "SELECT s FROM SaleInvoiceHasItem s WHERE s.saleInvoice.invTime BETWEEN :startDate AND :endDate GROUP BY s.saleInvoiceHasItemPK.itemCode, s.rate ORDER BY s.saleInvoiceHasItemPK.itemCode"),
    @NamedQuery(name = "Supplier.findByName", query = "SELECT s FROM Supplier s WHERE s.name = :name"),
    @NamedQuery(name = "Supplier.findBy$", query = "SELECT s FROM Supplier s WHERE  UPPER(s.code) LIKE UPPER(:text) OR UPPER(s.name) LIKE UPPER(:text)"),
    @NamedQuery(name = "PurchaseInvoiceHasItem.findByItemndInvDates", query = "SELECT p FROM PurchaseInvoiceHasItem p WHERE p.item = :item AND p.purchaseInvoice.invDate BETWEEN :startDate AND :endDate"),
    @NamedQuery(name = "MenuItem.findByMenuAndStatus", query = "SELECT m FROM MenuItem m WHERE m.menu = :menu AND m.status = :status"),
    @NamedQuery(name = "Stock.findLessMinLimit", query = "SELECT s FROM Stock s WHERE s.minLimit > s.quantity"),
    @NamedQuery(name = "Stock.findBySupplier", query = "SELECT s FROM Stock s WHERE s.item.supplier = :supplier"),
    @NamedQuery(name = "IssuedCash.findByDates", query = "SELECT i FROM IssuedCash i WHERE i.issuedTime BETWEEN :startDate AND :endDate"),
    @NamedQuery(name = "Expenses.findByDates", query = "SELECT e FROM Expenses e WHERE e.paidTime BETWEEN :startDate AND :endDate"),
    @NamedQuery(name = "CollectionReceipt.findByDates", query = "SELECT c FROM CollectionReceipt c WHERE c.collectedTime BETWEEN :startDate AND :endDate"),
    @NamedQuery(name = "IssuedCheque.findByDates", query = "SELECT i FROM IssuedCheque i WHERE i.issuedDate BETWEEN :startDate AND :endDate"),
    @NamedQuery(name = "SaleCheque.findByBankingDates", query = "SELECT s FROM SaleCheque s WHERE s.bankingDate BETWEEN :startDate AND :endDate"),
    @NamedQuery(name = "StockTransfer.findByItemAndTransferDates", query = "SELECT s FROM StockTransfer s WHERE s.stockTransferPK.itemCode = :item AND s.stockTransferPK.transferDate BETWEEN :startDate AND :endDate"),
    @NamedQuery(name = "SrSalesPayments.findByStatusAndEmployee", query = "SELECT s FROM SrSalesPayments s WHERE s.status = :status AND s.employee = :employee")
})
public class Find implements Serializable {

    public static Collection<PurchaseInvoice> purchaseInvoicesByDate(Date date) {
        Query qry = man.getEm().createNamedQuery("PurchaseInvoice.findByInvDate");
        qry.setParameter("invDate", date);
        return man.exNamedQueryParamResult(qry);
    }

    public static Collection<PurchaseInvoice> purchaseInvoicesByDates(Date startDate, Date endDate) {
        Query qry = man.getEm().createNamedQuery("PurchaseInvoice.findByInvDates");
        qry.setParameter("startDate", startDate);
        qry.setParameter("endDate", endDate);
        return man.exNamedQueryParamResult(qry);
    }

    public static Collection<SaleInvoice> saleInvoicesByDates(Date startDate, Date endDate) {
        Query qry = man.getEm().createNamedQuery("SaleInvoice.findByInvDates");
        qry.setParameter("startDate", startDate);
        qry.setParameter("endDate", endDate);
        return man.exNamedQueryParamResult(qry);
    }

    public static Collection<SaleInvoice> saleInvoicesByCard(String card) {
        Query qry = man.getEm().createNamedQuery("SaleInvoice.findByCard");
        qry.setParameter("card", card);
        return man.exNamedQueryParamResult(qry);
    }

    public static Collection<SaleInvoice> saleInvoicesAsActiveCardsByNic(String nic) {
        Query qry = man.getEm().createNamedQuery("SaleInvoice.findActiveCardsByNic");
        qry.setParameter("nic", nic);
        return man.exNamedQueryParamResult(qry);
    }

    public static Collection<SaleInvoice> saleInvoicesAsCard() {
        Query qry = man.getEm().createNamedQuery("SaleInvoice.findAllCards");
        return man.exNamedQueryParamResult(qry);
    }

    public static Collection<IssuedCash> issuedCashByDates(Date startDate, Date endDate) {
        Query qry = man.getEm().createNamedQuery("IssuedCash.findByDates");
        qry.setParameter("startDate", startDate);
        qry.setParameter("endDate", endDate);
        return man.exNamedQueryParamResult(qry);
    }

    public static Collection<CollectionReceipt> collectionReceiptsByDates(Date startDate, Date endDate) {
        Query qry = man.getEm().createNamedQuery("CollectionReceipt.findByDates");
        qry.setParameter("startDate", startDate);
        qry.setParameter("endDate", endDate);
        return man.exNamedQueryParamResult(qry);
    }

    public static Collection<IssuedCheque> issuedChequeByDates(Date startDate, Date endDate) {
        Query qry = man.getEm().createNamedQuery("IssuedCheque.findByDates");
        qry.setParameter("startDate", startDate);
        qry.setParameter("endDate", endDate);
        return man.exNamedQueryParamResult(qry);
    }

    public static Collection<Expenses> expensesByDates(Date startDate, Date endDate) {
        Query qry = man.getEm().createNamedQuery("Expenses.findByDates");
        qry.setParameter("startDate", startDate);
        qry.setParameter("endDate", endDate);
        return man.exNamedQueryParamResult(qry);
    }

    public static Collection<SrSalesPayments> pendingPaymentsByRef(Employee rep) {
        Query qry = man.getEm().createNamedQuery("SrSalesPayments.findByStatusAndEmployee");
        qry.setParameter("status", 0);
        qry.setParameter("employee", rep);
        return man.exNamedQueryParamResult(qry);
    }

    public static Collection<DamageNotes> damageNotesByDate(Date date) {
        Query qry = man.getEm().createNamedQuery("DamageNotes.findByDateTime");
        qry.setParameter("dateTime", date);
        return man.exNamedQueryParamResult(qry);
    }

    public static Collection<DamageNotes> damageNotesByDateAndRef(Date date, Employee e) {
        Query qry = man.getEm().createNamedQuery("DamageNotes.findByDateTimeAndEmployeeCode");
        qry.setParameter("dateTime", date);
        qry.setParameter("employeeCode", e.getCode());
        return man.exNamedQueryParamResult(qry);
    }

    public static Collection<SaleCheque> saleChequeByBankingDates(Date startDate, Date endDate) {
        Query qry = man.getEm().createNamedQuery("SaleCheque.findByBankingDates");
        qry.setParameter("startDate", startDate);
        qry.setParameter("endDate", endDate);
        return man.exNamedQueryParamResult(qry);
    }

    public static List<Menu> menuByStatus(int i) {
        Query qry = man.getEm().createNamedQuery("Menu.findByStatus");
        qry.setParameter("status", i);
        return man.exNamedQueryParamResult(qry);
    }

    public static List<Menu> menuItemByMenuAndStatus(Menu menu, int i) {
        Query qry = man.getEm().createNamedQuery("MenuItem.findByMenuAndStatus");
        qry.setParameter("menu", menu);
        qry.setParameter("status", i);
        return man.exNamedQueryParamResult(qry);
    }

    public static List<Stock> stockLessMinLimit() {
        Query qry = man.getEm().createNamedQuery("Stock.findLessMinLimit");
        return man.exNamedQueryParamResult(qry);
    }

    public static List<Stock> stockBySupplier(Supplier supplier) {
        Query qry = man.getEm().createNamedQuery("Stock.findBySupplier");
        qry.setParameter("supplier", supplier);
        return man.exNamedQueryParamResult(qry);
    }

//    public static List<SaleInvoice> saleInvoiceByDate(Date date) {
//        Query qry = man.getEm().createNamedQuery("SaleInvoice.findByDate");
//        qry.setParameter("date", date);
//        return man.exNamedQueryParamResult(qry);
//    }

    public static List<SaleInvoiceHasItem> saleInvoiceItemsByItemAndDates(Item item, Date startDate, Date endDate) {
        Query qry = man.getEm().createNamedQuery("SaleInvoiceHasItem.findByItemAndInvDates");
        qry.setParameter("item", item);
        qry.setParameter("startDate", startDate);
        qry.setParameter("endDate", endDate);
        return man.exNamedQueryParamResult(qry);
    }

    public static List<StockTransfer> stockTransferItemsByItemAndDates(Item item, Date startDate, Date endDate) {
        Query qry = man.getEm().createNamedQuery("StockTransfer.findByItemAndTransferDates");
        qry.setParameter("item", item.getCode());
        qry.setParameter("startDate", startDate);
        qry.setParameter("endDate", endDate);
        return man.exNamedQueryParamResult(qry);
    }

    public static List<PurchaseInvoiceHasItem> PurchaseInvoiceHasItemByItemAndDates(Item item, Date startDate, Date endDate) {
        Query qry = man.getEm().createNamedQuery("PurchaseInvoiceHasItem.findByItemndInvDates");
        qry.setParameter("item", item);
        qry.setParameter("startDate", startDate);
        qry.setParameter("endDate", endDate);
        return man.exNamedQueryParamResult(qry);
    }

    public static List<SaleInvoiceHasItem> saleInvoiceItemsByDates(Date startDate, Date endDate) {

        Query qry = man.getEm().createNamedQuery("SaleInvoiceHasItem.findByInvDates");
        qry.setParameter("startDate", startDate);
        qry.setParameter("endDate", endDate);
        return man.exNamedQueryParamResult(qry);
    }

    public static List<Customer> customerBy$(String text) {
        Query qry = man.getEm().createNamedQuery("Customer.findBy$");
        qry.setParameter("text", "%" + text + "%");
        return man.exNamedQueryParamResult(qry);
    }

    public static Supplier supplierByName(String name) {
        Query qry = man.getEm().createNamedQuery("Supplier.findByName");
        qry.setParameter("name", name);
        List<Supplier> suppliers = man.exNamedQueryParamResult(qry);
        return suppliers.size() > 0 ? suppliers.get(0) : null;
    }

    public static List<Item> itemBy$(String text) {
        Query qry = man.getEm().createNamedQuery("Item.findBy$");
        qry.setParameter("text", "%" + text + "%");
        return man.exNamedQueryParamResult(qry);
    }

    public static List<Supplier> supplierBy$(String text) {
        Query qry = man.getEm().createNamedQuery("Supplier.findBy$");
        qry.setParameter("text", "%" + text + "%");
        return man.exNamedQueryParamResult(qry);
    }

    @Id
    private Long id;
    private static final Manager man = Manager.getInstance();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
