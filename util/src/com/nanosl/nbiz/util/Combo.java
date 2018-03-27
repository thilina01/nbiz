/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.util;

import com.nanosl.lib.db.Manager;
import entity.Account;
import entity.Bank;
import entity.CashBox;
import entity.Customer;
import entity.Employee;
import entity.ExpensesType;
import entity.Item;
import entity.ItemCategory;
import entity.ItemType;
import entity.SaleInvoice;
import entity.Supplier;
import entity.Town;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.SwingWorker;

/**
 *
 * @author Thilina Ranathunga
 */
public class Combo {

    private static final Manager manager = Manager.getInstance();

    public static void fillSuppliers(final JComboBox<Supplier> comboBox, final Supplier toSelect) {
        SwingWorker<DefaultComboBoxModel<Supplier>, Supplier> comboBoxWorker = new SwingWorker<DefaultComboBoxModel<Supplier>, Supplier>() {
            @Override
            protected DefaultComboBoxModel<Supplier> doInBackground() throws Exception {
                return getSupplierComboBoxModel();
            }

            @Override
            protected void done() {
                try {
                    comboBox.setModel(get());
                    if (toSelect != null) {
                        comboBox.setSelectedItem(toSelect);
                    }
                } catch (InterruptedException | ExecutionException ignore) {
                }
            }
        };
        comboBoxWorker.execute();
    }

    public static void fillCustomers(final JComboBox<Customer> comboBox) {
        SwingWorker<DefaultComboBoxModel<Customer>, Customer> comboBoxWorker = new SwingWorker<DefaultComboBoxModel<Customer>, Customer>() {
            @Override
            protected DefaultComboBoxModel<Customer> doInBackground() throws Exception {
                return getCustomerComboBoxModel();
            }

            @Override
            protected void done() {
                try {
                    comboBox.setModel(get());
                } catch (InterruptedException | ExecutionException ignore) {
                }
            }
        };
        comboBoxWorker.execute();
    }

    public static void fillEmployees(JComboBox<Employee> jcb) {
        List<Employee> employees = manager.find(Employee.class);
        if (employees != null) {
            Employee[] es = employees.toArray(new Employee[0]);
            Arrays.sort(es);
            jcb.setModel(new DefaultComboBoxModel<>(es));
        }
    }

    public static void fillItems(final JComboBox<Item> itemComboBox) {
        SwingWorker<DefaultComboBoxModel<Item>, Item> comboBoxWorker = new SwingWorker<DefaultComboBoxModel<Item>, Item>() {
            @Override
            protected DefaultComboBoxModel<Item> doInBackground() throws Exception {
                return getItemComboBoxModel();
            }

            @Override
            protected void done() {
                try {
                    itemComboBox.setModel(get());
                } catch (InterruptedException | ExecutionException ignore) {
                }
            }
        };
        comboBoxWorker.execute();
    }

    public static void fillItemTypes(final JComboBox<ItemType> comboBox, final ItemType toSelect) {
        SwingWorker<DefaultComboBoxModel<ItemType>, ItemType> comboBoxWorker = new SwingWorker<DefaultComboBoxModel<ItemType>, ItemType>() {
            @Override
            protected DefaultComboBoxModel<ItemType> doInBackground() throws Exception {
                return getItemTypeComboBoxModel();
            }

            @Override
            protected void done() {
                try {
                    comboBox.setModel(get());
                    if (toSelect != null) {
                        comboBox.setSelectedItem(toSelect);
                    }
                } catch (InterruptedException | ExecutionException ignore) {
                }
            }
        };
        comboBoxWorker.execute();
    }

    public static void fillItemCategories(final JComboBox<ItemCategory> comboBox, final ItemCategory toSelect) {
        SwingWorker<DefaultComboBoxModel<ItemCategory>, ItemCategory> comboBoxWorker = new SwingWorker<DefaultComboBoxModel<ItemCategory>, ItemCategory>() {
            @Override
            protected DefaultComboBoxModel<ItemCategory> doInBackground() throws Exception {
                return getItemCategoryComboBoxModel();
            }

            @Override
            protected void done() {
                try {
                    comboBox.setModel(get());
                    if (toSelect != null) {
                        comboBox.setSelectedItem(toSelect);
                    }
                } catch (InterruptedException | ExecutionException ignore) {
                }
            }
        };
        comboBoxWorker.execute();
    }

    public static void fillTowns(JComboBox<Town> jcb) {
        List<Town> towns = manager.find(Town.class);
        if (towns != null) {
            Town[] ts = towns.toArray(new Town[0]);
            Arrays.sort(ts);
            jcb.setModel(new DefaultComboBoxModel<>(ts));
        }
    }

    public static void fillBanks(JComboBox<Bank> jcb) {
        List<Bank> banks = manager.find(Bank.class);
        if (banks != null) {
            Bank[] bs = banks.toArray(new Bank[0]);
            Arrays.sort(bs);
            jcb.setModel(new DefaultComboBoxModel<>(bs));
        }
    }

    public static void fillCashBoxes(JComboBox<CashBox> jcb) {
        List<CashBox> cashBoxes = manager.find(CashBox.class);
        if (cashBoxes != null) {
            CashBox[] bs = cashBoxes.toArray(new CashBox[0]);
            Arrays.sort(bs);
            jcb.setModel(new DefaultComboBoxModel<>(bs));
        }
    }

    public static DefaultComboBoxModel<Supplier> getSupplierComboBoxModel() {
        List<Supplier> suppliers = manager.find(Supplier.class);
        if (suppliers != null) {
            Supplier[] ses = suppliers.toArray(new Supplier[0]);
            Arrays.sort(ses);
            return new DefaultComboBoxModel<>(ses);
        }
        return new DefaultComboBoxModel<>();
    }

    public static DefaultComboBoxModel<Customer> getCustomerComboBoxModel() {
        List<Customer> customers = manager.find(Customer.class);
        if (customers != null) {
            Customer[] ses = customers.toArray(new Customer[0]);
            Arrays.sort(ses);
            return new DefaultComboBoxModel<>(ses);
        }
        return new DefaultComboBoxModel<>();
    }

    public static DefaultComboBoxModel<Item> getItemComboBoxModel() {
        long startTime = System.currentTimeMillis();
        List<Item> items = manager.find(Item.class);
        long loadedTime = System.currentTimeMillis();
//        ResultSet resultSet = FindMySql.item();

        if (items != null) {
            Item[] ses = items.toArray(new Item[0]);
            Arrays.sort(ses);
            long sortedTime = System.currentTimeMillis();

            System.out.println("Thilina: loading = " + (loadedTime - startTime));
            System.out.println("Thilina: sorting = " + (sortedTime - loadedTime));
            System.out.println("Thilina: total = " + (sortedTime - startTime));

            return new DefaultComboBoxModel<>(ses);
        }
        return new DefaultComboBoxModel<>();

    }

    public static DefaultComboBoxModel<ItemType> getItemTypeComboBoxModel() {
        List<ItemType> itemTypes = manager.find(ItemType.class);
        if (itemTypes != null) {
            ItemType[] ses = itemTypes.toArray(new ItemType[0]);
            Arrays.sort(ses);
            return new DefaultComboBoxModel<>(ses);
        }
        return new DefaultComboBoxModel<>();
    }

    public static DefaultComboBoxModel<ItemCategory> getItemCategoryComboBoxModel() {
        List<ItemCategory> itemCategoryList = manager.find(ItemCategory.class);
        if (itemCategoryList != null) {
            ItemCategory[] ses = itemCategoryList.toArray(new ItemCategory[0]);
            Arrays.sort(ses);
            return new DefaultComboBoxModel<>(ses);
        }
        return new DefaultComboBoxModel<>();
    }

    public static void fillSaleInvoice(final JComboBox<SaleInvoice> comboBox, final SaleInvoice toSelect) {

        SwingWorker<DefaultComboBoxModel<SaleInvoice>, SaleInvoice> comboBoxWorker = new SwingWorker<DefaultComboBoxModel<SaleInvoice>, SaleInvoice>() {
            @Override
            protected DefaultComboBoxModel<SaleInvoice> doInBackground() throws Exception {
                List<SaleInvoice> saleInvoices = manager.findLimitOrderByDec(SaleInvoice.class, 50, "invTime");
                SaleInvoice[] saleInvoicesArray = new SaleInvoice[saleInvoices.size()];
                saleInvoices.toArray(saleInvoicesArray);
                Comparator<SaleInvoice> comparator = new Comparator<SaleInvoice>() {

                    @Override
                    public int compare(SaleInvoice o1, SaleInvoice o2) {
                        Date o2Date = o2.getInvTime() == null ? new Date() : o2.getInvTime();
                        return o2Date.compareTo(o1.getInvTime() == null ? new Date() : o1.getInvTime());
                    }
                };
                Arrays.sort(saleInvoicesArray, comparator);
                return new DefaultComboBoxModel(saleInvoicesArray);
            }

            @Override
            protected void done() {
                try {
                    comboBox.setModel(get());
                    if (toSelect != null) {
                        comboBox.setSelectedItem(toSelect);
                    }
                } catch (InterruptedException | ExecutionException ignore) {
                }
            }
        };
        comboBoxWorker.execute();
    }

    public static void fillAccounts(JComboBox jcb) {
        List<Account> entities = manager.find(Account.class);
        if (entities != null) {
            Account[] bs = entities.toArray(new Account[0]);
            Arrays.sort(bs);
            jcb.setModel(new DefaultComboBoxModel<>(bs));
        }
    }

    public static void fillExpensesTypes(JComboBox jcb) {
        List<ExpensesType> entities = manager.find(ExpensesType.class);
        if (entities != null) {
            ExpensesType[] bs = entities.toArray(new ExpensesType[0]);
            Arrays.sort(bs);
            jcb.setModel(new DefaultComboBoxModel<>(bs));
        }
    }

}
