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
import java.util.Collections;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author Thilina Ranathunga
 */
public class Combo {

    private static Manager m = Manager.getInstance();

    public static void fillSuppliers(JComboBox jcb) {
        List<Supplier> suppliers = m.find(Supplier.class);
        if (suppliers != null) {
            Supplier[] ses = suppliers.toArray(new Supplier[0]);
            Arrays.sort(ses);
            jcb.setModel(new DefaultComboBoxModel(ses));
        }
    }

    public static void fillCustomers(JComboBox jcb) {
        List<Customer> customers = m.find(Customer.class);
        if (customers != null) {
            Customer[] cs = customers.toArray(new Customer[0]);
            Arrays.sort(cs);
            jcb.setModel(new DefaultComboBoxModel(cs));
        }
    }

    public static void fillEmployees(JComboBox jcb) {
        List<Employee> employees = m.find(Employee.class);
        if (employees != null) {
            Employee[] es = employees.toArray(new Employee[0]);
            Arrays.sort(es);
            jcb.setModel(new DefaultComboBoxModel(es));
        }
    }

    public static void fillItems(JComboBox jcb) {
        List<Item> items = m.find(Item.class);
        if (items != null) {
            Collections.sort(items);
            Item[] is = items.toArray(new Item[0]);
//            Arrays.sort(is);
            jcb.setModel(new DefaultComboBoxModel(is));
        }
    }

    public static void fillTowns(JComboBox jcb) {
        List<Town> towns = m.find(Town.class);
        if (towns != null) {
            Town[] ts = towns.toArray(new Town[0]);
            Arrays.sort(ts);
            jcb.setModel(new DefaultComboBoxModel(ts));
        }
    }

    public static void fillBanks(JComboBox jcb) {
        List<Bank> banks = m.find(Bank.class);
        if (banks != null) {
            Bank[] bs = banks.toArray(new Bank[0]);
            Arrays.sort(bs);
            jcb.setModel(new DefaultComboBoxModel(bs));
        }
    }
}
