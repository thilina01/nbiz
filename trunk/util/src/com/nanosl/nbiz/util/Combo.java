/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.util;

import com.nanosl.lib.db.Manager;
import entity.Bank;
import entity.Customer;
import entity.Employee;
import entity.Item;
import entity.Supplier;
import entity.Town;
import java.util.Arrays;
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

    public static void fillSuppliers(final JComboBox comboBox) {
        SwingWorker<DefaultComboBoxModel, Supplier> comboBoxWorker = new SwingWorker<DefaultComboBoxModel, Supplier>() {
            @Override
            protected DefaultComboBoxModel doInBackground() throws Exception {
                return getSupplierComboBoxModel();
            }

            @Override
            protected void done() {
                try {
                    comboBox.setModel(get());
                } catch (InterruptedException ignore) {
                } catch (ExecutionException ignore) {
                }
            }
        };
        comboBoxWorker.execute();
    }

    public static void fillCustomers(final JComboBox comboBox) {
        SwingWorker<DefaultComboBoxModel, Customer> comboBoxWorker = new SwingWorker<DefaultComboBoxModel, Customer>() {
            @Override
            protected DefaultComboBoxModel doInBackground() throws Exception {
                return getCustomerComboBoxModel();
            }
            @Override
            protected void done() {
                try {
                    comboBox.setModel(get());
                } catch (InterruptedException ignore) {
                } catch (ExecutionException ignore) {
                }
            }
        };
        comboBoxWorker.execute();
    }

    public static void fillEmployees(JComboBox jcb) {
        List<Employee> employees = manager.find(Employee.class);
        if (employees != null) {
            Employee[] es = employees.toArray(new Employee[0]);
            Arrays.sort(es);
            jcb.setModel(new DefaultComboBoxModel(es));
        }
    }

    public static void fillItems(final JComboBox itemComboBox) {
        SwingWorker<DefaultComboBoxModel, Item> comboBoxWorker = new SwingWorker<DefaultComboBoxModel, Item>() {
            @Override
            protected DefaultComboBoxModel doInBackground() throws Exception {                
                return getItemComboBoxModel();
            }

            @Override
            protected void done() {
                try {
                    itemComboBox.setModel(get());
                } catch (InterruptedException ignore) {
                } catch (ExecutionException ignore) {
                }
            }
        };
        comboBoxWorker.execute();
    }

    public static void fillTowns(JComboBox jcb) {
        List<Town> towns = manager.find(Town.class);
        if (towns != null) {
            Town[] ts = towns.toArray(new Town[0]);
            Arrays.sort(ts);
            jcb.setModel(new DefaultComboBoxModel(ts));
        }
    }

    public static void fillBanks(JComboBox jcb) {
        List<Bank> banks = manager.find(Bank.class);
        if (banks != null) {
            Bank[] bs = banks.toArray(new Bank[0]);
            Arrays.sort(bs);
            jcb.setModel(new DefaultComboBoxModel(bs));
        }
    }

    public static DefaultComboBoxModel<Supplier> getSupplierComboBoxModel() {
        List<Supplier> suppliers = manager.find(Supplier.class);
        if (suppliers != null) {
            Supplier[] ses = suppliers.toArray(new Supplier[0]);
            Arrays.sort(ses);
            return new DefaultComboBoxModel(ses);
        }
        return new DefaultComboBoxModel();
    }

    public static DefaultComboBoxModel<Customer> getCustomerComboBoxModel() {
        List<Customer> customers = manager.find(Customer.class);
        if (customers != null) {
            Customer[] ses = customers.toArray(new Customer[0]);
            Arrays.sort(ses);
            return new DefaultComboBoxModel(ses);
        }
        return new DefaultComboBoxModel();
    }

    public static DefaultComboBoxModel<Item> getItemComboBoxModel() {
        List<Item> items = manager.find(Item.class);
        if (items != null) {
            Item[] ses = items.toArray(new Item[0]);
            Arrays.sort(ses);
            return new DefaultComboBoxModel<Item>(ses);
        }
        return new DefaultComboBoxModel();

    }
}
