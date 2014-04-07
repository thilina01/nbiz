/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.gui.report;

import query.Find;
import com.nanosl.nbiz.util.NTopComponent;
import entity.PurchaseInvoice;
import entity.PurchaseInvoiceHasItem;
import entity.PurchaseInvoicePK;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.windows.TopComponent;
import org.openide.util.NbBundle.Messages;

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
        masterTable = new javax.swing.JTable();
        startDatePicker = new org.jdesktop.swingx.JXDatePicker();
        jLabel3 = new javax.swing.JLabel();
        totalLabel = new javax.swing.JLabel();
        endDatePicker = new org.jdesktop.swingx.JXDatePicker();
        fillButton = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        masterTable.setAutoCreateRowSorter(true);
        masterTable.setModel(new javax.swing.table.DefaultTableModel(
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
        masterTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                masterTableMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                masterTableMouseReleased(evt);
            }
        });
        masterTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                masterTableKeyReleased(evt);
            }
        });
        masterScrollPane.setViewportView(masterTable);
        if (masterTable.getColumnModel().getColumnCount() > 0) {
            masterTable.getColumnModel().getColumn(0).setPreferredWidth(30);
            masterTable.getColumnModel().getColumn(0).setHeaderValue(org.openide.util.NbBundle.getMessage(PurchaseReportTopComponent.class, "PurchaseReportTopComponent.masterTable.columnModel.title0")); // NOI18N
            masterTable.getColumnModel().getColumn(1).setHeaderValue(org.openide.util.NbBundle.getMessage(PurchaseReportTopComponent.class, "PurchaseReportTopComponent.masterTable.columnModel.title1")); // NOI18N
            masterTable.getColumnModel().getColumn(2).setHeaderValue(org.openide.util.NbBundle.getMessage(PurchaseReportTopComponent.class, "PurchaseReportTopComponent.masterTable.columnModel.title2")); // NOI18N
            masterTable.getColumnModel().getColumn(3).setPreferredWidth(150);
            masterTable.getColumnModel().getColumn(3).setHeaderValue(org.openide.util.NbBundle.getMessage(PurchaseReportTopComponent.class, "PurchaseReportTopComponent.masterTable.columnModel.title3")); // NOI18N
            masterTable.getColumnModel().getColumn(4).setHeaderValue(org.openide.util.NbBundle.getMessage(PurchaseReportTopComponent.class, "PurchaseReportTopComponent.masterTable.columnModel.title4")); // NOI18N
            masterTable.getColumnModel().getColumn(5).setHeaderValue(org.openide.util.NbBundle.getMessage(PurchaseReportTopComponent.class, "PurchaseReportTopComponent.masterTable.columnModel.title5")); // NOI18N
            masterTable.getColumnModel().getColumn(5).setCellRenderer(rightAlignCell);
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
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(masterScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 812, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
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
                    .addComponent(fillButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalLabel)
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

    private void masterTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masterTableMouseClicked
        if (evt.getClickCount() > 1 & masterTable.getRowCount() > 0) {
            int row = masterTable.getSelectedRow();
            String invoiceNumber = masterTable.getValueAt(row, 4).toString();
            String supperCode = masterTable.getValueAt(row, 2).toString();
            PurchaseInvoice purchaseInvoice = manager.find(PurchaseInvoice.class, new PurchaseInvoicePK(invoiceNumber, supperCode));
            String message = "<html><table >";
            message += "<tr><td> Item </td><td align = 'right'> Quantity </td></tr>";

            for (PurchaseInvoiceHasItem purchaseInvoiceHasItem : purchaseInvoice.getPurchaseInvoiceHasItemCollection()) {
                message += "<tr><td>" + purchaseInvoiceHasItem.getItem() + " </td><td align = 'right'>" + nf2d.format(purchaseInvoiceHasItem.getQuantity()) + "</td></tr>";
            }
            message += "</table> </html>";
            JOptionPane.showMessageDialog(null, message, "Invoice Data: " + supperCode + " - " + invoiceNumber, JOptionPane.PLAIN_MESSAGE, null);
//            new PurchaseInvoiceView(invoiceNumber, supperCode);
        }
    }//GEN-LAST:event_masterTableMouseClicked

    private void masterTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masterTableMouseReleased

    }//GEN-LAST:event_masterTableMouseReleased

    private void masterTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_masterTableKeyReleased

    }//GEN-LAST:event_masterTableKeyReleased

    private void startDatePickerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startDatePickerActionPerformed
        fill();
    }//GEN-LAST:event_startDatePickerActionPerformed

    private void endDatePickerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endDatePickerActionPerformed
        fill();
    }//GEN-LAST:event_endDatePickerActionPerformed

    private void fillButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillButtonActionPerformed
        fill();
    }//GEN-LAST:event_fillButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXDatePicker endDatePicker;
    private javax.swing.JButton fillButton;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane masterScrollPane;
    private javax.swing.JTable masterTable;
    private org.jdesktop.swingx.JXDatePicker startDatePicker;
    private javax.swing.JLabel totalLabel;
    // End of variables declaration//GEN-END:variables
     DefaultTableModel tableModel;

    private void fillTable() {
        tableModel.setRowCount(0);
        Date startDate = startDatePicker.getDate();
        Date endDate = endDatePicker.getDate();
        //ALTER TABLE `sgm`.`purchase_invoice` CHANGE COLUMN `inv_time` `inv_date` DATE NULL DEFAULT NULL  ;

        Collection<PurchaseInvoice> purchaseInvoices = Find.purchaseInvoicesByDates(startDate, endDate);
        if (purchaseInvoices == null) {
            showError("No Record Found!");
            return;
        }
        int i = 0;
        for (Iterator<PurchaseInvoice> it = purchaseInvoices.iterator(); it.hasNext();) {
            PurchaseInvoice purchaseInvoice = it.next();
            Object[] row = {++i, yyyy_MM_dd.format(purchaseInvoice.getInvDate()), purchaseInvoice.getSupplier().getCode(), purchaseInvoice.getSupplier().getName(), purchaseInvoice.getPurchaseInvoicePK().getInvNo(), nf2d.format(purchaseInvoice.getAmount())};
            tableModel.addRow(row);
        }
        calcTotal();
    }

    protected void onLoad() {
        initComponents();
        tableModel = (DefaultTableModel) masterTable.getModel();
        masterTable.setDefaultRenderer(Object.class, coloredCellRenderer);

    }

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
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
