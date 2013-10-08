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
        addButton("Purchase", "PurchaseInvoiceTopComponent");
        addButton("Sales", "SaleInvoiceTopComponent");
        addButton("Transfer", "StockTransferTopComponent");        
        addButton("Stock", "StockTopComponent");    
        addButton("Supplier", "SupplierTopComponent");
        
    }

    private void addButton(String text, final String componentName) {

        JButton button = new JButton(text);
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
