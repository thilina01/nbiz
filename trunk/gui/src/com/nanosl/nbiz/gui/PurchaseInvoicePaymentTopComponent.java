/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.gui;

import com.nanosl.lib.date.JXDatePicker;
import com.nanosl.lib.log.Loggings;
import com.nanosl.nbiz.util.NTopComponent;
import entity.Bank;
import entity.IssuedCash;
import entity.IssuedCheque;
import entity.PurchaseInvoice;
import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.windows.TopComponent;
import org.openide.util.NbBundle.Messages;
import com.nanosl.nbiz.util.Combo;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
        dtd = "-//com.nanosl.nbiz.gui//PurchaseInvoicePayment//EN",
        autostore = false)
@TopComponent.Description(
        preferredID = "PurchaseInvoicePaymentTopComponent",
        //iconBase="SET/PATH/TO/ICON/HERE", 
        persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@ActionID(category = "Window", id = "com.nanosl.nbiz.gui.PurchaseInvoicePaymentTopComponent")
@ActionReference(path = "Menu/Purchase" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_PurchaseInvoicePaymentAction",
        preferredID = "PurchaseInvoicePaymentTopComponent")
@Messages({
    "CTL_PurchaseInvoicePaymentAction=PurchaseInvoicePayment",
    "CTL_PurchaseInvoicePaymentTopComponent=PurchaseInvoicePayment Window",
    "HINT_PurchaseInvoicePaymentTopComponent=This is a PurchaseInvoicePayment window"
})
public final class PurchaseInvoicePaymentTopComponent extends NTopComponent {

    public PurchaseInvoicePaymentTopComponent() {
        onLoad();
        setName(Bundle.CTL_PurchaseInvoicePaymentTopComponent());
        setToolTipText(Bundle.HINT_PurchaseInvoicePaymentTopComponent());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        invoiceTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        remainingAmountField = new javax.swing.JTextField();
        invoiceNumberField = new javax.swing.JTextField();
        supplierNameField = new javax.swing.JTextField();
        amountField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        invoiceDateField = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        paymentAmountTextField = new javax.swing.JTextField();
        chequeNumbertField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        bankingDatePicker = new JXDatePicker();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        paymentTable = new javax.swing.JTable();
        bankComboBox = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        processButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();

        invoiceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Invoice"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        invoiceTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                invoiceTableMouseReleased(evt);
            }
        });
        invoiceTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                invoiceTableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(invoiceTable);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(PurchaseInvoicePaymentTopComponent.class, "PurchaseInvoicePaymentTopComponent.jPanel2.border.title"))); // NOI18N

        remainingAmountField.setEditable(false);
        remainingAmountField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);

        invoiceNumberField.setEnabled(false);

        supplierNameField.setEnabled(false);

        amountField.setEditable(false);
        amountField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(PurchaseInvoicePaymentTopComponent.class, "PurchaseInvoicePaymentTopComponent.jLabel3.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(PurchaseInvoicePaymentTopComponent.class, "PurchaseInvoicePaymentTopComponent.jLabel1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(PurchaseInvoicePaymentTopComponent.class, "PurchaseInvoicePaymentTopComponent.jLabel4.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(PurchaseInvoicePaymentTopComponent.class, "PurchaseInvoicePaymentTopComponent.jLabel2.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel8, org.openide.util.NbBundle.getMessage(PurchaseInvoicePaymentTopComponent.class, "PurchaseInvoicePaymentTopComponent.jLabel8.text")); // NOI18N

        invoiceDateField.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(invoiceNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(amountField, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(remainingAmountField, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(invoiceDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(supplierNameField))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(invoiceNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(invoiceDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(supplierNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(amountField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(remainingAmountField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(PurchaseInvoicePaymentTopComponent.class, "PurchaseInvoicePaymentTopComponent.jPanel3.border.title"))); // NOI18N

        paymentAmountTextField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        paymentAmountTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentAmountTextFieldActionPerformed(evt);
            }
        });

        chequeNumbertField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chequeNumbertFieldActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel7, org.openide.util.NbBundle.getMessage(PurchaseInvoicePaymentTopComponent.class, "PurchaseInvoicePaymentTopComponent.jLabel7.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel6, org.openide.util.NbBundle.getMessage(PurchaseInvoicePaymentTopComponent.class, "PurchaseInvoicePaymentTopComponent.jLabel6.text")); // NOI18N

        bankingDatePicker.setName("bankingDatePicker"); // NOI18N
        bankingDatePicker.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bankingDatePickerKeyPressed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel5, org.openide.util.NbBundle.getMessage(PurchaseInvoicePaymentTopComponent.class, "PurchaseInvoicePaymentTopComponent.jLabel5.text")); // NOI18N

        paymentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Amount", "Cheque Number", "Banking Date", "Bank"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        paymentTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                paymentTableKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(paymentTable);

        bankComboBox.setName("bankComboBox"); // NOI18N
        bankComboBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bankComboBoxKeyPressed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel9, org.openide.util.NbBundle.getMessage(PurchaseInvoicePaymentTopComponent.class, "PurchaseInvoicePaymentTopComponent.jLabel9.text")); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(paymentAmountTextField)
                            .addComponent(chequeNumbertField, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bankingDatePicker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bankComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(chequeNumbertField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(bankingDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(paymentAmountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bankComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.openide.awt.Mnemonics.setLocalizedText(processButton, org.openide.util.NbBundle.getMessage(PurchaseInvoicePaymentTopComponent.class, "PurchaseInvoicePaymentTopComponent.processButton.text")); // NOI18N
        processButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(clearButton, org.openide.util.NbBundle.getMessage(PurchaseInvoicePaymentTopComponent.class, "PurchaseInvoicePaymentTopComponent.clearButton.text")); // NOI18N
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(clearButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(processButton)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(processButton)
                    .addComponent(clearButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void invoiceTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_invoiceTableMouseReleased
        fill();
    }//GEN-LAST:event_invoiceTableMouseReleased

    private void invoiceTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_invoiceTableKeyReleased
        fill();
    }//GEN-LAST:event_invoiceTableKeyReleased

    private void paymentAmountTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentAmountTextFieldActionPerformed
        addPay();
    }//GEN-LAST:event_paymentAmountTextFieldActionPerformed

    private void chequeNumbertFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chequeNumbertFieldActionPerformed
        bankingDatePicker.requestFocus();
    }//GEN-LAST:event_chequeNumbertFieldActionPerformed

    private void bankingDatePickerKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bankingDatePickerKeyPressed
        if (evt.getKeyCode() == 10) {
            paymentAmountTextField.requestFocus();
        }
    }//GEN-LAST:event_bankingDatePickerKeyPressed

    private void paymentTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_paymentTableKeyReleased
        if (evt.getKeyCode() == 127) {
            deletePaymentRow(paymentTable.getSelectedRow());
        }
    }//GEN-LAST:event_paymentTableKeyReleased

    private void bankComboBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bankComboBoxKeyPressed
        if (evt.getKeyCode() == 10) {
            amountField.requestFocus();
        }
    }//GEN-LAST:event_bankComboBoxKeyPressed

    private void processButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processButtonActionPerformed
        process();
    }//GEN-LAST:event_processButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        clearAll();
    }//GEN-LAST:event_clearButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amountField;
    private javax.swing.JComboBox bankComboBox;
    private org.jdesktop.swingx.JXDatePicker bankingDatePicker;
    private javax.swing.JTextField chequeNumbertField;
    private javax.swing.JButton clearButton;
    private javax.swing.JTextField invoiceDateField;
    private javax.swing.JTextField invoiceNumberField;
    private javax.swing.JTable invoiceTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField paymentAmountTextField;
    private javax.swing.JTable paymentTable;
    private javax.swing.JButton processButton;
    private javax.swing.JTextField remainingAmountField;
    private javax.swing.JTextField supplierNameField;
    // End of variables declaration//GEN-END:variables
    List<PurchaseInvoice> purchaseInvoices;
    List<Bank> banks;
    DefaultTableModel invoiceDtm;
    DefaultTableModel paymentDtm;
    PurchaseInvoice purchaseInvoice;

    protected void onLoad() {
        initComponents();
        invoiceDtm = (DefaultTableModel) invoiceTable.getModel();
        paymentDtm = (DefaultTableModel) paymentTable.getModel();
        KeyAdapter();
    }

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
        clearAll();
    }

    private void fillInvoiceTable() {
        invoiceDtm.setRowCount(0);
        paymentDtm.setRowCount(0);
        purchaseInvoices = m.find(PurchaseInvoice.class);
        for (Iterator<PurchaseInvoice> it = purchaseInvoices.iterator(); it.hasNext();) {
            PurchaseInvoice pi = it.next();
            double credit = pi.getCredit() == null ? 0 : pi.getCredit();
            if (credit > 0) {
                Object[] rowData = {pi};
                invoiceDtm.addRow(rowData);
            }
        }
    }

    private void fill() {
        int selectedRow = invoiceTable.getSelectedRow();
        if (selectedRow > -1) {
            fill((PurchaseInvoice) invoiceDtm.getValueAt(selectedRow, 0));
        }
    }

    public void fill(PurchaseInvoice pi) {
        clearAll();
        purchaseInvoice = m.find(PurchaseInvoice.class, pi.getPurchaseInvoicePK());
        invoiceNumberField.setText(purchaseInvoice.getPurchaseInvoicePK().getInvNo());
        invoiceDateField.setText(yyyy_MM_dd.format(purchaseInvoice.getInvDate()));
        supplierNameField.setText(purchaseInvoice.getSupplier().getName());
        amountField.setText(nf2d.format(purchaseInvoice.getAmount()));
        remainingAmountField.setText(nf2d.format(purchaseInvoice.getCredit()));
    }

    private void addPay() {
        if (purchaseInvoice == null) {
            return;
        }
        try {
            double paymentAmount = Double.valueOf(paymentAmountTextField.getText().trim());
            if (paymentAmount > 0) {
                String chequeNumber = chequeNumbertField.getText().trim();
                Date bankingDate = bankingDatePicker.getDate();
                Bank bank = (Bank) bankComboBox.getSelectedItem();

                Object[] row = {nf2d.format(paymentAmount), chequeNumber, yyyy_MM_dd.format(bankingDate), bank.getCode()};
                fillPaymentTable(row);
                clearPaymentFields();
                calcRemaining();
            }
        } catch (NumberFormatException e) {
        } catch (Exception e) {
            Loggings.logError(getName(), e);
        }
    }

    private void fillPaymentTable(Object[] row) {
        paymentDtm.addRow(row);
        clearPaymentFields();
        calcRemaining();
    }

    private void deletePaymentRow(int selectedRow) {
        if (selectedRow > -1) {
            paymentDtm.removeRow(selectedRow);
            calcRemaining();
        }
    }

    private void calcRemaining() {
        double remaining = purchaseInvoice.getCredit();
        int rowCount = paymentTable.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            remaining = remaining - Double.valueOf(paymentTable.getValueAt(i, 0).toString());
        }
        remainingAmountField.setText(nf2d.format(remaining));
    }

    private void clearPaymentFields() {
        chequeNumbertField.setText("");
        paymentAmountTextField.setText("");
    }

    private void clearAll() {
        purchaseInvoice = null;
        invoiceNumberField.setText("");
        invoiceDateField.setText("");
        supplierNameField.setText("");
        amountField.setText("");
        remainingAmountField.setText("");
        clearPaymentFields();
        paymentDtm.setRowCount(0);
        fillInvoiceTable();
        Combo.fillBanks(bankComboBox);
    }

    private void process() {
        int rowCount = paymentTable.getRowCount();
        if (purchaseInvoice == null || rowCount == 0) {
            return;
        }
        List<Serializable> serializables = new ArrayList<Serializable>();
        try {
            for (int i = 0; i < rowCount; i++) {
                Object o = paymentTable.getValueAt(i, 1);
                String chequeNumber = o == null ? "" : o.toString().trim();
                Bank bank = m.find(Bank.class, paymentTable.getValueAt(i, 3).toString());
                double amount = Double.valueOf(paymentTable.getValueAt(i, 0).toString());
                Date date = yyyy_MM_dd.parse(paymentTable.getValueAt(i, 2).toString());
                if (chequeNumber.equals("")) {
                    Calendar calendar = Calendar.getInstance();
                    Calendar calendar1 = Calendar.getInstance();
                    calendar1.setTime(date);
                    calendar.set(calendar1.get(Calendar.YEAR), calendar1.get(Calendar.MONTH), calendar1.get(Calendar.DATE));
                    IssuedCash issuedCash = new IssuedCash(calendar.getTime());
                    issuedCash.setAmount(amount);
                    issuedCash.setPurchaseInvoice(purchaseInvoice);
                    issuedCash.setBank(bank);
                    serializables.add(issuedCash);
                    purchaseInvoice.getIssuedCashCollection().add(issuedCash);
                } else {
                    IssuedCheque issuedCheque = new IssuedCheque(chequeNumber);
                    issuedCheque.setAmount(amount);
                    issuedCheque.setBank(bank);
                    issuedCheque.setBankingDate(date);
                    issuedCheque.setIssuedDate(new Date());
                    issuedCheque.setPurchaseInvoice(purchaseInvoice);
                    issuedCheque.setStatus(0);
                    serializables.add(issuedCheque);
                    purchaseInvoice.getIssuedChequeCollection().add(issuedCheque);
                }
            }
        } catch (ParseException ex) {
            showError("Problem with one of cheque banking date!");
            return;
        } catch (Exception ex) {
            showError("Unable to complete payment");
            return;
        }
        double remainingAmount = Double.valueOf(remainingAmountField.getText().trim());
        purchaseInvoice.setCredit(remainingAmount);
        serializables.add(purchaseInvoice);
        if (m.update(serializables)) {
            clearAll();
        } else {
            showError("Unable to complete payment!");
        }
    }

    private void KeyAdapter() {
        AutoCompleteDecorator.decorate(bankComboBox);
        setComboBoxKeyAdapters(bankComboBox);
        setComboBoxKeyAdapters(bankingDatePicker);
    }

    private void setComboBoxKeyAdapters(JComponent comp) {
        String compName = comp.getName();
        Component component[] = comp.getComponents();
        for (int i = 0; i < component.length; i++) {
            if (compName.equals("bankComboBox")) {
                component[i].addKeyListener(bankComboBoxKeyAdapter);
            } else if (compName.equals("bankingDatePicker")) {
                component[i].addKeyListener(bankingDatePickerKeyAdapter);
            }
        }
    }
    KeyAdapter bankComboBoxKeyAdapter = new java.awt.event.KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent evt) {
            bankComboBoxKeyPressed(evt);
        }
    };
    KeyAdapter bankingDatePickerKeyAdapter = new java.awt.event.KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent evt) {
            bankingDatePickerKeyPressed(evt);
        }
    };

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
