/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.gui.controller;

import com.nanosl.lib.db.Manager;
import entity.Supplier;
import entity.Town;
import java.util.Collections;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Thilina Ranathunga
 */
public class SupplierController {

    Manager m = Manager.getInstance();

    public void fillTable(DefaultTableModel tableModel) {
        int i = 0;
        tableModel.setRowCount(i);
        List<Supplier> suppliers = m.find(Supplier.class);
        Collections.sort(suppliers);
        for (Supplier supplier : suppliers) {
            if (supplier == null) {
                return;
            }
            Town town = supplier.getTown();
            String townName = "";

            if (town != null) {
                townName = town.getName() != null ? town.getName() : "";
            }
            Object[] row = {++i, supplier.getCode(), supplier.getName(), townName};
            tableModel.addRow(row);
        }
    }

    public Supplier getSuppllier(String code) {
        return m.find(Supplier.class, code);
    }

    public boolean update(Supplier supplier) {
        return m.update(supplier);
    }

    public boolean delete(String code) {
        return m.delete(Supplier.class, code);
    }
}
