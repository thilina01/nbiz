/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.gui;

import com.nanosl.nbiz.quicklaunch.ToolBarManager;
import org.openide.modules.ModuleInstall;

public class Installer extends ModuleInstall {

    @Override
    public void restored() {
        initializeToolbar();
    }

    private void initializeToolbar() {
        ToolBarManager.registerToolBarButton("Transfer", "StockTransferTopComponent", "com/nanosl/nbiz/gui/resources/wire-transfer-icon.png");
        ToolBarManager.registerToolBarButton("Purchase", "PurchaseInvoiceTopComponent", "com/nanosl/nbiz/gui/resources/shopping_trolley.png");
        ToolBarManager.registerToolBarButton("Stock", "StockTopComponent", "com/nanosl/nbiz/gui/resources/box.png");
        ToolBarManager.registerToolBarButton("Supplier", "SupplierTopComponent", "com/nanosl/nbiz/gui/resources/company.png");
        ToolBarManager.registerToolBarButton("Item", "ItemTopComponent", "com/nanosl/nbiz/gui/resources/tv.png");
    }

}
