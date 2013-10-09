/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.gui;

import com.nanosl.nbiz.quicklaunch.SideBarPanel;
import javax.swing.JButton;
import org.openide.modules.ModuleInstall;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;

public class Installer extends ModuleInstall {

    @Override
    public void restored() {
        initializeToolbar();
    }

    private void initializeToolbar() {
        addButton("Purchase", "PurchaseInvoiceTopComponent","shopping_trolley");
        addButton("Sales", "SaleInvoiceTopComponent","specials-offers-save-sale");
        addButton("Transfer", "StockTransferTopComponent","wire-transfer-icon");
        addButton("Stock", "StockTopComponent","box");
        addButton("Supplier", "SupplierTopComponent","company");
        addButton("Item", "ItemTopComponent","tv");
    }

    private void addButton(String text, final String componentName, String icon) {

        JButton button = new JButton(text);
        if (!icon.equals("")) {
            button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nanosl/nbiz/gui/resources/" + icon + ".png"))); // NOI18N
        }
        button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TopComponent tc = WindowManager.getDefault().findTopComponent(componentName);
                tc.open();
                tc.requestActive();
            }
        });
        SideBarPanel.addButton(button);
    }
}
