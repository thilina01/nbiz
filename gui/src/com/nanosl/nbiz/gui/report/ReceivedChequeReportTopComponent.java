/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.gui.report;

import com.nanosl.lib.date.JXDatePicker;
import com.nanosl.nbiz.util.Combo;
import com.nanosl.nbiz.util.Export;
import static com.nanosl.nbiz.util.Format.yyyy_MM_dd;
import com.nanosl.nbiz.util.NTopComponent;
import entity.Account;
import entity.CollectionReceipt;
import entity.SaleCheque;
import entity.SaleChequePK;
import entity.SaleInvoice;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.TopComponent;
import query.Find;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
        dtd = "-//com.nanosl.nbiz.gui.report//ReceivedChequeReport//EN",
        autostore = false)
@TopComponent.Description(
        preferredID = "ReceivedChequeReportTopComponent",
        //iconBase="SET/PATH/TO/ICON/HERE", 
        persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@ActionID(category = "Window", id = "com.nanosl.nbiz.gui.report.ReceivedChequeReportTopComponent")
@ActionReference(path = "Menu/Report" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_ReceivedChequeReportAction",
        preferredID = "ReceivedChequeReportTopComponent")
@Messages({
    "CTL_ReceivedChequeReportAction=ReceivedChequeReport",
    "CTL_ReceivedChequeReportTopComponent=ReceivedChequeReport Window",
    "HINT_ReceivedChequeReportTopComponent=This is a ReceivedChequeReport window"
})
public final class ReceivedChequeReportTopComponent extends NTopComponent {

    public ReceivedChequeReportTopComponent() {
        onLoad();
        setName(Bundle.CTL_ReceivedChequeReportTopComponent());
        setToolTipText(Bundle.HINT_ReceivedChequeReportTopComponent());

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
        startDatePicker = new JXDatePicker();
        jLabel3 = new javax.swing.JLabel();
        totalLabel = new javax.swing.JLabel();
        endDatePicker = new JXDatePicker();
        jLabel4 = new javax.swing.JLabel();
        fillStatusComboBox = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        chequeNumberTextField = new javax.swing.JTextField();
        setStatusComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        updateButton = new javax.swing.JButton();
        codeLabel = new javax.swing.JLabel();
        accountComboBox = new javax.swing.JComboBox();
        exportButton = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        table.setAutoCreateRowSorter(true);
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Number", "Amount", "Received Date", "Banking Date", "Status", "Bank", "Invoice", "Receipt", "Customer"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
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
            table.getColumnModel().getColumn(0).setHeaderValue(org.openide.util.NbBundle.getMessage(ReceivedChequeReportTopComponent.class, "ReceivedChequeReportTopComponent.table.columnModel.title0")); // NOI18N
            table.getColumnModel().getColumn(1).setHeaderValue(org.openide.util.NbBundle.getMessage(ReceivedChequeReportTopComponent.class, "ReceivedChequeReportTopComponent.table.columnModel.title1")); // NOI18N
            table.getColumnModel().getColumn(2).setHeaderValue(org.openide.util.NbBundle.getMessage(ReceivedChequeReportTopComponent.class, "ReceivedChequeReportTopComponent.table.columnModel.title2")); // NOI18N
            table.getColumnModel().getColumn(2).setCellRenderer(rightAlignCell);
            table.getColumnModel().getColumn(3).setHeaderValue(org.openide.util.NbBundle.getMessage(ReceivedChequeReportTopComponent.class, "ReceivedChequeReportTopComponent.table.columnModel.title3")); // NOI18N
            table.getColumnModel().getColumn(4).setHeaderValue(org.openide.util.NbBundle.getMessage(ReceivedChequeReportTopComponent.class, "ReceivedChequeReportTopComponent.table.columnModel.title4")); // NOI18N
            table.getColumnModel().getColumn(5).setHeaderValue(org.openide.util.NbBundle.getMessage(ReceivedChequeReportTopComponent.class, "ReceivedChequeReportTopComponent.masterTable.columnModel.title9")); // NOI18N
            table.getColumnModel().getColumn(6).setHeaderValue(org.openide.util.NbBundle.getMessage(ReceivedChequeReportTopComponent.class, "ReceivedChequeReportTopComponent.masterTable.columnModel.title5")); // NOI18N
            table.getColumnModel().getColumn(7).setHeaderValue(org.openide.util.NbBundle.getMessage(ReceivedChequeReportTopComponent.class, "ReceivedChequeReportTopComponent.masterTable.columnModel.title6")); // NOI18N
            table.getColumnModel().getColumn(8).setHeaderValue(org.openide.util.NbBundle.getMessage(ReceivedChequeReportTopComponent.class, "ReceivedChequeReportTopComponent.masterTable.columnModel.title7")); // NOI18N
            table.getColumnModel().getColumn(9).setPreferredWidth(150);
            table.getColumnModel().getColumn(9).setHeaderValue(org.openide.util.NbBundle.getMessage(ReceivedChequeReportTopComponent.class, "ReceivedChequeReportTopComponent.masterTable.columnModel.title8")); // NOI18N
        }

        startDatePicker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startDatePickerActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(ReceivedChequeReportTopComponent.class, "ReceivedChequeReportTopComponent.jLabel3.text")); // NOI18N

        totalLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        totalLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        org.openide.awt.Mnemonics.setLocalizedText(totalLabel, org.openide.util.NbBundle.getMessage(ReceivedChequeReportTopComponent.class, "ReceivedChequeReportTopComponent.totalLabel.text")); // NOI18N

        endDatePicker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endDatePickerActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(ReceivedChequeReportTopComponent.class, "ReceivedChequeReportTopComponent.jLabel4.text")); // NOI18N

        fillStatusComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pending", "Cleared", "Returned", "All" }));
        fillStatusComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fillStatusComboBoxActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(ReceivedChequeReportTopComponent.class, "ReceivedChequeReportTopComponent.jLabel2.text")); // NOI18N

        chequeNumberTextField.setEditable(false);

        setStatusComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pending", "Cleared", "Returned" }));

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(ReceivedChequeReportTopComponent.class, "ReceivedChequeReportTopComponent.jLabel1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(updateButton, org.openide.util.NbBundle.getMessage(ReceivedChequeReportTopComponent.class, "ReceivedChequeReportTopComponent.updateButton.text")); // NOI18N
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(codeLabel, org.openide.util.NbBundle.getMessage(ReceivedChequeReportTopComponent.class, "ReceivedChequeReportTopComponent.codeLabel.text")); // NOI18N

        accountComboBox.setName("bankCombo"); // NOI18N
        accountComboBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                accountComboBoxKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chequeNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(setStatusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(codeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(accountComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(updateButton)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(accountComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(codeLabel))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(chequeNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(setStatusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(updateButton)))
                .addContainerGap())
        );

        org.openide.awt.Mnemonics.setLocalizedText(exportButton, org.openide.util.NbBundle.getMessage(ReceivedChequeReportTopComponent.class, "ReceivedChequeReportTopComponent.exportButton.text")); // NOI18N
        exportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(masterScrollPane)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(startDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(endDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fillStatusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 530, Short.MAX_VALUE)
                        .addComponent(totalLabel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exportButton)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(startDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(endDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(fillStatusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(totalLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exportButton))
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
        loadCheque();
    }//GEN-LAST:event_tableMouseClicked

    private void tableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseReleased
    }//GEN-LAST:event_tableMouseReleased

    private void tableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableKeyReleased
        loadCheque();
    }//GEN-LAST:event_tableKeyReleased

    private void startDatePickerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startDatePickerActionPerformed
        fill();
    }//GEN-LAST:event_startDatePickerActionPerformed

    private void endDatePickerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endDatePickerActionPerformed
        fill();
    }//GEN-LAST:event_endDatePickerActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        updat();
    }//GEN-LAST:event_updateButtonActionPerformed

    private void fillStatusComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillStatusComboBoxActionPerformed
        fill();
    }//GEN-LAST:event_fillStatusComboBoxActionPerformed

    private void accountComboBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_accountComboBoxKeyPressed
        if (evt.getKeyCode() == 10) {
            updateButton.requestFocus();
        }
    }//GEN-LAST:event_accountComboBoxKeyPressed

    private void exportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportButtonActionPerformed
        export();
    }//GEN-LAST:event_exportButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox accountComboBox;
    private javax.swing.JTextField chequeNumberTextField;
    private javax.swing.JLabel codeLabel;
    private org.jdesktop.swingx.JXDatePicker endDatePicker;
    private javax.swing.JButton exportButton;
    private javax.swing.JComboBox fillStatusComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane masterScrollPane;
    private javax.swing.JComboBox setStatusComboBox;
    private org.jdesktop.swingx.JXDatePicker startDatePicker;
    private javax.swing.JTable table;
    private javax.swing.JLabel totalLabel;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
    DefaultTableModel tableModel;
    SaleCheque saleCheque;

    private void fillTable() {
        tableModel.setRowCount(0);
        Date startDate = startDatePicker.getDate();
        Date endDate = endDatePicker.getDate();
        int fillStatus = fillStatusComboBox.getSelectedIndex();
        //ALTER TABLE `sgm`.`purchase_invoice` CHANGE COLUMN `inv_time` `inv_date` DATE NULL DEFAULT NULL  ;

        Collection<SaleCheque> saleCheques = Find.saleChequeByBankingDates(startDate, endDate);
        if (saleCheques == null) {
            showError("No Record Found!");
            return;
        }
        int i = 0;
        for (Iterator<SaleCheque> it = saleCheques.iterator(); it.hasNext();) {
            SaleCheque localSaleCheque = it.next();
            int chequeStatus = localSaleCheque.getStatus();
            if (fillStatus == 3 | chequeStatus == fillStatus) {
                CollectionReceipt collectionReceipt = localSaleCheque.getCollectionReceipt();
                SaleInvoice saleInvoice = collectionReceipt.getSaleInvoice();
                Object[] row = {++i,
                    localSaleCheque.getSaleChequePK().getChequeNumber(),
                    nf2d.format(localSaleCheque.getAmount()),
                    yyyy_MM_dd.format(collectionReceipt.getCollectedTime()),
                    yyyy_MM_dd.format(localSaleCheque.getBankingDate()),
                    chequeStatus == 0 ? "Pending" : chequeStatus == 1 ? "Cleared" : "Returned",
                    localSaleCheque.getBank().getCode(),
                    saleInvoice != null ? saleInvoice.getInvNo() : "",
                    collectionReceipt.getReceiptNumber(),
                    saleInvoice != null ? saleInvoice.getCustomerName() : collectionReceipt.getCustomer().getName()};
                tableModel.addRow(row);
            }
        }
        calcTotal();
    }

    protected void onLoad() {
        initComponents();
        tableModel = (DefaultTableModel) table.getModel();
        table.setDefaultRenderer(Object.class, coloredCellRenderer);
    }

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
        fill();
        clear();
    }

    private void fill() {
        fillTable();
        calcTotal();
        Combo.fillAccounts(accountComboBox);
    }

    private void calcTotal() {
        double total = 0;
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            total += Double.valueOf(tableModel.getValueAt(i, 2).toString());
        }
        totalLabel.setText(nf2d.format(total));
    }

    private void loadCheque() {
        clear();
        if (tableModel.getRowCount() > 0) {
            int row = table.getSelectedRow();
            String chequeNumber = tableModel.getValueAt(row, 1).toString();
            String bankCode = tableModel.getValueAt(row, 6).toString();
            String ReceiptNumber = tableModel.getValueAt(row, 8).toString();
            saleCheque = manager.find(SaleCheque.class, new SaleChequePK(chequeNumber, bankCode, ReceiptNumber));
            if (saleCheque != null) {
                chequeNumberTextField.setText(chequeNumber);
            }
        }
    }

    private void updat() {
        if (saleCheque == null) {
            showError("No Cheque Selected.");
            return;
        }

        int existingStatus = saleCheque.getStatus();
        int newStatus = setStatusComboBox.getSelectedIndex();
        if (existingStatus == newStatus) {
            showMessage("Cheque " + saleCheque.getSaleChequePK().getChequeNumber() + " Nothing to update.");
        } else if (existingStatus == 0 && newStatus == 1) {
            List<Serializable> serializables = new ArrayList<>();
            Account account = (Account) accountComboBox.getSelectedItem();
            saleCheque.setStatus(newStatus);
            saleCheque.setAccount(account);
            account.setBalance(account.getBalance() + saleCheque.getAmount());
            serializables.add(account);
            serializables.add(saleCheque);
            if (manager.update(serializables)) {
                showSuccess("Cheque " + saleCheque.getSaleChequePK().getChequeNumber() + " Cleared.");
                chequeNumberTextField.setText("");
                fill();
            }
        } else if (existingStatus == 0 && newStatus == 2) {
            saleCheque.setStatus(newStatus);
            if (manager.update(saleCheque)) {
                showSuccess("Cheque " + saleCheque.getSaleChequePK().getChequeNumber() + " Returned.");
                chequeNumberTextField.setText("");
                fill();
            }
        } else {
            showMessage("Operation not supported");
        }
    }

    private void clear() {
        saleCheque = null;
        chequeNumberTextField.setText("");
    }

    private void export() {
        Export.toExcel(table, yyyy_MM_dd.format(makeStartDate(startDatePicker.getDate())) + " to " + yyyy_MM_dd.format(makeEndDate(endDatePicker.getDate())), getName().replace(" Window", ""));
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
