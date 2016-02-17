/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.gui;

import com.nanosl.nbiz.util.Shared;
import org.openide.modules.ModuleInstall;

public class Installer extends ModuleInstall {

    @Override
    public void restored() {
        initializeToolbar();
    }

    private void initializeToolbar() {
        Shared.registerToolBarButton("Transfer", "StockTransferTopComponent", "com/nanosl/nbiz/gui/resources/wire-transfer-icon.png");
        Shared.registerToolBarButton("Purchase", "PurchaseInvoiceTopComponent", "com/nanosl/nbiz/gui/resources/shopping_trolley.png");
        Shared.registerToolBarButton("Stock", "StockTopComponent", "com/nanosl/nbiz/gui/resources/box.png");
        Shared.registerToolBarButton("Supplier", "SupplierTopComponent", "com/nanosl/nbiz/gui/resources/company.png");
        Shared.registerToolBarButton("Item", "ItemTopComponent", "com/nanosl/nbiz/gui/resources/tv.png");
        Shared.registerToolBarButton("Customer", "CustomerTopComponent", "com/nanosl/nbiz/gui/resources/customer36.png");
    }

}
