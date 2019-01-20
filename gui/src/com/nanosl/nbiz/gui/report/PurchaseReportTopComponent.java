/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.gui.report;

import com.nanosl.nbiz.gui.PurchaseInvoiceTopComponent;
import com.nanosl.nbiz.util.Combo;
import com.nanosl.nbiz.util.Export;
import static com.nanosl.nbiz.util.Format.yyyy_MM_dd;
import com.nanosl.nbiz.util.NTopComponent;
import entity.Item;
import entity.PurchaseInvoice;
import entity.PurchaseInvoiceHasItem;
import entity.PurchaseInvoicePK;
import entity.Stock;
import entity.Supplier;
import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;
import query.Find;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
        dtd = "-//com.nanosl.nbiz.gui.report//PurchaseReport//EN",
        autostore = false)
@TopComponent.Description(
        preferredID = "PurchaseReportTopComponent",
        //iconBase="SET/PATH/TO/ICON/HERE", 
        persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@ActionID(category = "Window", id = "com.nanosl.nbiz.gui.report.PurchaseReportTopComponent")
@ActionReference(path = "Menu/Report" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_PurchaseReportAction",
        preferredID = "PurchaseReportTopComponent")
@Messages({
    "CTL_PurchaseReportAction=PurchaseReport",
    "CTL_PurchaseReportTopComponent=PurchaseReport Window",
    "HINT_PurchaseReportTopComponent=This is a PurchaseReport window"
})
public final class PurchaseReportTopComponent extends NTopComponent {

    public PurchaseReportTopComponent() {
        onLoad();
        setName(Bundle.CTL_PurchaseReportTopComponent());
        setToolTipText(Bundle.HINT_PurchaseReportTopComponent());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        masterScrollPane = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        startDatePicker = new org.jdesktop.swingx.JXDatePicker();
        jLabel3 = new javax.swing.JLabel();
        totalLabel = new javax.swing.JLabel();
        endDatePicker = new org.jdesktop.swingx.JXDatePicker();
        fillButton = new javax.swing.JButton();
        supplierCheckBox = new javax.swing.JCheckBox();
        supplierComboBox = new javax.swing.JComboBox();
        exportButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        exportForBarcodeButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        labelsPerRowTextField = new javax.swing.JTextField();

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        table.setAutoCreateRowSorter(true);
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Date", "Code", "Supplier", "Invoce", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableMouseReleased(evt);
            }
        });
        table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tableKeyReleased(evt);
            }
        });
        masterScrollPane.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setPreferredWidth(30);
            table.getColumnModel().getColumn(0).setHeaderValue(org.openide.util.NbBundle.getMessage(PurchaseReportTopComponent.class, "PurchaseReportTopComponent.table.columnModel.title0")); // NOI18N
            table.getColumnModel().getColumn(1).setHeaderValue(org.openide.util.NbBundle.getMessage(PurchaseReportTopComponent.class, "PurchaseReportTopComponent.table.columnModel.title1")); // NOI18N
            table.getColumnModel().getColumn(2).setHeaderValue(org.openide.util.NbBundle.getMessage(PurchaseReportTopComponent.class, "PurchaseReportTopComponent.table.columnModel.title2")); // NOI18N
            table.getColumnModel().getColumn(3).setPreferredWidth(150);
            table.getColumnModel().getColumn(3).setHeaderValue(org.openide.util.NbBundle.getMessage(PurchaseReportTopComponent.class, "PurchaseReportTopComponent.table.columnModel.title3")); // NOI18N
            table.getColumnModel().getColumn(4).setHeaderValue(org.openide.util.NbBundle.getMessage(PurchaseReportTopComponent.class, "PurchaseReportTopComponent.table.columnModel.title4")); // NOI18N
            table.getColumnModel().getColumn(5).setHeaderValue(org.openide.util.NbBundle.getMessage(PurchaseReportTopComponent.class, "PurchaseReportTopComponent.table.columnModel.title5")); // NOI18N
            table.getColumnModel().getColumn(5).setCellRenderer(rightAlignCell);
        }

        startDatePicker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startDatePickerActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(PurchaseReportTopComponent.class, "PurchaseReportTopComponent.jLabel3.text")); // NOI18N

        totalLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        totalLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        org.openide.awt.Mnemonics.setLocalizedText(totalLabel, org.openide.util.NbBundle.getMessage(PurchaseReportTopComponent.class, "PurchaseReportTopComponent.totalLabel.text")); // NOI18N

        endDatePicker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endDatePickerActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(fillButton, org.openide.util.NbBundle.getMessage(PurchaseReportTopComponent.class, "PurchaseReportTopComponent.fillButton.text")); // NOI18N
        fillButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fillButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(supplierCheckBox, org.openide.util.NbBundle.getMessage(PurchaseReportTopComponent.class, "PurchaseReportTopComponent.supplierCheckBox.text")); // NOI18N

        supplierComboBox.setName("supplierComboBox"); // NOI18N
        supplierComboBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                supplierComboBoxKeyPressed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(exportButton, org.openide.util.NbBundle.getMessage(PurchaseReportTopComponent.class, "PurchaseReportTopComponent.exportButton.text")); // NOI18N
        exportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(deleteButton, org.openide.util.NbBundle.getMessage(PurchaseReportTopComponent.class, "PurchaseReportTopComponent.deleteButton.text")); // NOI18N
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(exportForBarcodeButton, org.openide.util.NbBundle.getMessage(PurchaseReportTopComponent.class, "PurchaseReportTopComponent.exportForBarcodeButton.text")); // NOI18N
        exportForBarcodeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportForBarcodeButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(PurchaseReportTopComponent.class, "PurchaseReportTopComponent.jLabel1.text")); // NOI18N

        labelsPerRowTextField.setText(org.openide.util.NbBundle.getMessage(PurchaseReportTopComponent.class, "PurchaseReportTopComponent.labelsPerRowTextField.text")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(startDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(endDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fillButton)
                        .addGap(18, 18, 18)
                        .addComponent(supplierCheckBox)
                        .addGap(18, 18, 18)
                        .addComponent(supplierComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deleteButton))
                    .addComponent(masterScrollPane, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(exportButton)
                        .addGap(18, 18, 18)
                        .addComponent(exportForBarcodeButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelsPerRowTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(totalLabel)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(endDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fillButton)
                    .addComponent(supplierCheckBox)
                    .addComponent(supplierComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalLabel)
                    .addComponent(exportButton)
                    .addComponent(exportForBarcodeButton)
                    .addComponent(jLabel1)
                    .addComponent(labelsPerRowTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        if (evt.getClickCount() > 1 & table.getRowCount() > 0) {
            int row = table.getSelectedRow();
            String invoiceNumber = table.getValueAt(row, 4).toString();
            String supperCode = table.getValueAt(row, 2).toString();
            TopComponent tc = WindowManager.getDefault().findTopComponent("PurchaseInvoiceTopComponent");
            if (tc != null) {
                ((PurchaseInvoiceTopComponent) tc).fill(invoiceNumber, supperCode);
                tc.open();
                tc.requestActive();
            }
//            PurchaseInvoiceTopComponent.getInstance().
//            PurchaseInvoice purchaseInvoice = manager.find(PurchaseInvoice.class, new PurchaseInvoicePK(invoiceNumber, supperCode));
//            String message = "<html><table >";
//            message += "<tr><td> Item </td><td align = 'right'> Quantity </td></tr>";
//
//            for (PurchaseInvoiceHasItem purchaseInvoiceHasItem : purchaseInvoice.getPurchaseInvoiceHasItemCollection()) {
//                message += "<tr><td>" + purchaseInvoiceHasItem.getItem() + " </td><td align = 'right'>" + nf2d.format(purchaseInvoiceHasItem.getQuantity()) + "</td></tr>";
//            }
//            message += "</table> </html>";
//            JOptionPane.showMessageDialog(null, message, "Invoice Data: " + supperCode + " - " + invoiceNumber, JOptionPane.PLAIN_MESSAGE, null);
////            new PurchaseInvoiceView(invoiceNumber, supperCode);
        }
    }//GEN-LAST:event_tableMouseClicked

    private void tableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseReleased

    }//GEN-LAST:event_tableMouseReleased

    private void tableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableKeyReleased

    }//GEN-LAST:event_tableKeyReleased

    private void startDatePickerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startDatePickerActionPerformed
        fill();
    }//GEN-LAST:event_startDatePickerActionPerformed

    private void endDatePickerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endDatePickerActionPerformed
        fill();
    }//GEN-LAST:event_endDatePickerActionPerformed

    private void fillButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillButtonActionPerformed
        fill();
    }//GEN-LAST:event_fillButtonActionPerformed

    private void supplierComboBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_supplierComboBoxKeyPressed
        if (evt.getKeyCode() == 10) {
            fill();
        }
    }//GEN-LAST:event_supplierComboBoxKeyPressed

    private void exportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportButtonActionPerformed
        Export.toExcel(table, yyyy_MM_dd.format(makeStartDate(startDatePicker.getDate())) + " to " + yyyy_MM_dd.format(makeEndDate(endDatePicker.getDate())), getName().replace(" Window", ""));
    }//GEN-LAST:event_exportButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int row = table.getSelectedRow();
        if (row >= 0 && JOptionPane.showConfirmDialog(this, "Are you sure to delete invoice????") == JOptionPane.YES_OPTION) {
            String invoiceNumber = table.getValueAt(row, 4).toString();
            String supperCode = table.getValueAt(row, 2).toString();
            PurchaseInvoice purchaseInvoice = manager.find(PurchaseInvoice.class, new PurchaseInvoicePK(invoiceNumber, supperCode));
            Collection<PurchaseInvoiceHasItem> purchaseInvoiceHasItems = purchaseInvoice.getPurchaseInvoiceHasItemCollection();
            List<Serializable> serializables = new ArrayList<>();
//            System.out.println("purchaseInvoiceHasItems.size "+purchaseInvoiceHasItems.size());
            for (PurchaseInvoiceHasItem purchaseInvoiceHasItem : purchaseInvoiceHasItems) {
                Stock stock = purchaseInvoiceHasItem.getItem().getStock();
//                System.out.println("stock.getQuantity " + stock.getQuantity());
//                System.out.println("next.getQuantity " + purchaseInvoiceHasItem.getQuantity());
//                System.out.println("next.getFreeQuantity " + purchaseInvoiceHasItem.getFreeQuantity());
                stock.setQuantity(stock.getQuantity() - (purchaseInvoiceHasItem.getQuantity() + purchaseInvoiceHasItem.getFreeQuantity()));
                serializables.add(stock);
            }
            manager.update(serializables);
            manager.delete(purchaseInvoice);
            fill();
        }
//        purchaseInvoice.setPurchaseInvoiceHasItemCollection(new ArrayList<>());
//        manager.update(purchaseInvoice);
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void exportForBarcodeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportForBarcodeButtonActionPerformed
        int selectedRow = table.getSelectedRow();
        int labelsPerRow = Integer.valueOf(labelsPerRowTextField.getText().trim());
        if (selectedRow >= 0) {
            String invoiceNumber = table.getValueAt(selectedRow, 4).toString();
            String supperCode = table.getValueAt(selectedRow, 2).toString();
            PurchaseInvoice purchaseInvoice = manager.find(PurchaseInvoice.class, new PurchaseInvoicePK(invoiceNumber, supperCode));

            String purchaseDate = yyyy_MM_dd.format(purchaseInvoice.getInvDate());
            Collection<PurchaseInvoiceHasItem> purchaseInvoiceHasItems = purchaseInvoice.getPurchaseInvoiceHasItemCollection();
            List<String> columnNames = Arrays.asList("code", "name", "price", "purchase_date");
            List<List<String>> rows = new ArrayList<>();

            for (PurchaseInvoiceHasItem purchaseInvoiceHasItem : purchaseInvoiceHasItems) {
                Item item = purchaseInvoiceHasItem.getItem();
                int quantity = (int) (purchaseInvoiceHasItem.getQuantity() + purchaseInvoiceHasItem.getFreeQuantity());
                int repeat = (quantity / labelsPerRow);
                repeat += repeat % labelsPerRow > 0 ? 1 : 0;
                for (int i = 0; i < repeat; i++) {
                    List<String> row = Arrays.asList(
                            item.getCode(),
                            item.getDescription(),
                            item.getPriceList().getSellingPack() + "",
                            purchaseDate);
                    System.out.println(row);
                    rows.add(row);

                }
            }
            Export.toExcel(columnNames, rows, purchaseDate + "-" + supperCode);
        }
    }//GEN-LAST:event_exportForBarcodeButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteButton;
    private org.jdesktop.swingx.JXDatePicker endDatePicker;
    private javax.swing.JButton exportButton;
    private javax.swing.JButton exportForBarcodeButton;
    private javax.swing.JButton fillButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField labelsPerRowTextField;
    private javax.swing.JScrollPane masterScrollPane;
    private org.jdesktop.swingx.JXDatePicker startDatePicker;
    private javax.swing.JCheckBox supplierCheckBox;
    private javax.swing.JComboBox supplierComboBox;
    private javax.swing.JTable table;
    private javax.swing.JLabel totalLabel;
    // End of variables declaration//GEN-END:variables
     DefaultTableModel tableModel;

    private void fillTable() {
        tableModel.setRowCount(0);
        Date startDate = startDatePicker.getDate();
        Date endDate = endDatePicker.getDate();
        Supplier supplier = (Supplier) supplierComboBox.getSelectedItem();
        //ALTER TABLE `sgm`.`purchase_invoice` CHANGE COLUMN `inv_time` `inv_date` DATE NULL DEFAULT NULL  ;

        Collection<PurchaseInvoice> purchaseInvoices;
        purchaseInvoices = supplierCheckBox.isSelected() ? Find.purchaseInvoicesByDatesAndSupplier(startDate, endDate, supplier) : Find.purchaseInvoicesByDates(startDate, endDate);
        if (purchaseInvoices == null) {
            showError("No Record Found!");
            return;
        }
        int i = 0;
        for (PurchaseInvoice purchaseInvoice : purchaseInvoices) {
            Object[] row = {nf3p.format(++i), yyyy_MM_dd.format(purchaseInvoice.getInvDate()), purchaseInvoice.getSupplier().getCode(), purchaseInvoice.getSupplier().getName(), purchaseInvoice.getPurchaseInvoicePK().getInvNo(), nf2d.format(purchaseInvoice.getAmount())};
            tableModel.addRow(row);
        }
        calcTotal();
    }

    protected void onLoad() {
        initComponents();
        tableModel = (DefaultTableModel) table.getModel();
        table.setDefaultRenderer(Object.class, coloredCellRenderer);
        AutoCompleteDecorator.decorate(supplierComboBox);
        setComboBoxKeyAdapters(supplierComboBox);

    }

    private void setComboBoxKeyAdapters(JComponent comp) {
        String compName = comp.getName();
        if (compName == null) {
            return;
        }
        Component component[] = comp.getComponents();
        for (Component component1 : component) {
            switch (compName) {
                case "supplierComboBox":
                    component1.addKeyListener(supplierComboBoxKeyAdapter);
                    break;

            }
        }
    }
    KeyAdapter supplierComboBoxKeyAdapter = new java.awt.event.KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent evt) {
            supplierComboBoxKeyPressed(evt);
        }
    };

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
        Combo.fillSuppliers(supplierComboBox, null);
    }

    private void fill() {
        fillTable();
        calcTotal();
    }

    private void calcTotal() {
        double total = 0;
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            total += Double.valueOf(tableModel.getValueAt(i, 5).toString());
        }
        totalLabel.setText(nf2d.format(total));
    }

    @Override
    public void componentOpened() {
        // TODO add custom code on component opening
    }

    @Override
    public void componentClosed() {
        // TODO add custom code on component closing
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    void readProperties(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }
}
