/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.gui.report;

import com.nanosl.nbiz.utility.Find;
import com.nanosl.nbiz.utility.NTopComponent;
import entity.IssuedCash;
import entity.IssuedCheque;
import java.awt.Color;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.windows.TopComponent;
import org.openide.util.NbBundle.Messages;
import static util.Format.nf2d;
import static util.Format.yyyy_MM_dd;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
        dtd = "-//com.nanosl.nbiz.gui.report//PaymentReport//EN",
        autostore = false)
@TopComponent.Description(
        preferredID = "PaymentReportTopComponent",
        //iconBase="SET/PATH/TO/ICON/HERE", 
        persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@ActionID(category = "Window", id = "com.nanosl.nbiz.gui.report.PaymentReportTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_PaymentReportAction",
        preferredID = "PaymentReportTopComponent")
@Messages({
    "CTL_PaymentReportAction=PaymentReport",
    "CTL_PaymentReportTopComponent=PaymentReport Window",
    "HINT_PaymentReportTopComponent=This is a PaymentReport window"
})
public final class PaymentReportTopComponent extends NTopComponent {

    public PaymentReportTopComponent() {
        onLoad();
        setName(Bundle.CTL_PaymentReportTopComponent());
        setToolTipText(Bundle.HINT_PaymentReportTopComponent());

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
        cashTable = new javax.swing.JTable();
        startDatePicker = new org.jdesktop.swingx.JXDatePicker();
        jLabel3 = new javax.swing.JLabel();
        cashTotalLabel = new javax.swing.JLabel();
        endDatePicker = new org.jdesktop.swingx.JXDatePicker();
        jScrollPane1 = new javax.swing.JScrollPane();
        chequeTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        chequeTableLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        cashTable.setAutoCreateRowSorter(true);
        cashTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Date", "Code", "Supplier", "Invoce", "Bank", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        cashTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cashTableMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cashTableMouseReleased(evt);
            }
        });
        cashTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cashTableKeyReleased(evt);
            }
        });
        masterScrollPane.setViewportView(cashTable);

        startDatePicker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startDatePickerActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(PaymentReportTopComponent.class, "PaymentReportTopComponent.jLabel3.text")); // NOI18N

        cashTotalLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cashTotalLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        org.openide.awt.Mnemonics.setLocalizedText(cashTotalLabel, org.openide.util.NbBundle.getMessage(PaymentReportTopComponent.class, "PaymentReportTopComponent.cashTotalLabel.text")); // NOI18N

        endDatePicker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endDatePickerActionPerformed(evt);
            }
        });

        chequeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Cheque Number", "Bank", "Issued Date", "Banking Date", "amount", "Code", "Name", "Invoice"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(chequeTable);

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(PaymentReportTopComponent.class, "PaymentReportTopComponent.jLabel1.text")); // NOI18N

        chequeTableLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(chequeTableLabel, org.openide.util.NbBundle.getMessage(PaymentReportTopComponent.class, "PaymentReportTopComponent.chequeTableLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(PaymentReportTopComponent.class, "PaymentReportTopComponent.jLabel2.text")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(startDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(endDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(cashTotalLabel))
                            .addComponent(masterScrollPane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 789, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(chequeTableLabel)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 789, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(startDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(endDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cashTotalLabel)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(masterScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chequeTableLabel)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cashTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cashTableMouseClicked

    }//GEN-LAST:event_cashTableMouseClicked

    private void cashTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cashTableMouseReleased

    }//GEN-LAST:event_cashTableMouseReleased

    private void cashTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cashTableKeyReleased

    }//GEN-LAST:event_cashTableKeyReleased

    private void startDatePickerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startDatePickerActionPerformed

    }//GEN-LAST:event_startDatePickerActionPerformed

    private void endDatePickerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endDatePickerActionPerformed
        fill();
    }//GEN-LAST:event_endDatePickerActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable cashTable;
    private javax.swing.JLabel cashTotalLabel;
    private javax.swing.JTable chequeTable;
    private javax.swing.JLabel chequeTableLabel;
    private org.jdesktop.swingx.JXDatePicker endDatePicker;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane masterScrollPane;
    private org.jdesktop.swingx.JXDatePicker startDatePicker;
    // End of variables declaration//GEN-END:variables
      DefaultTableModel cashTableModel;
    DefaultTableModel chequeTableModel;

    private void fillTable() {
        cashTableModel.setRowCount(0);
        chequeTableModel.setRowCount(0);
        Date startDate = startDatePicker.getDate();
        Date endDate = endDatePicker.getDate();
        endDate.setTime(endDate.getTime() + 1000 * 60 * 60 * 24 - 1);
        Collection<IssuedCash> issuedCashs = Find.issuedCashByDates(startDate, endDate);
        if (issuedCashs == null) {
            showError("No Cash Record Found!");
        }
        int i = 0;
        for (Iterator<IssuedCash> it = issuedCashs.iterator(); it.hasNext();) {
            IssuedCash issuedCash = it.next();
            Object[] row = {
                ++i,
                yyyy_MM_dd.format(issuedCash.getIssuedTime()),
                issuedCash.getPurchaseInvoice().getSupplier().getCode(),
                issuedCash.getPurchaseInvoice().getSupplier().getName(),
                issuedCash.getPurchaseInvoice().getPurchaseInvoicePK().getInvNo(),
                issuedCash.getBank().getName(),
                nf2d.format(issuedCash.getAmount())
            };
            cashTableModel.addRow(row);
        }

        Collection<IssuedCheque> issuedCheques = Find.issuedChequeByDates(startDate, endDate);
        if (issuedCheques == null) {
            showError("No Cheque Record Found!");
        }
        i = 0;
        for (Iterator<IssuedCheque> it = issuedCheques.iterator(); it.hasNext();) {
            IssuedCheque issuedCheque = it.next();
            Object[] row = {
                ++i,
                issuedCheque.getChequeNumber(),
                issuedCheque.getBank().getName(),
                yyyy_MM_dd.format(issuedCheque.getIssuedDate()),
                yyyy_MM_dd.format(issuedCheque.getBankingDate()),
                nf2d.format(issuedCheque.getAmount()),
                issuedCheque.getPurchaseInvoice().getSupplier().getCode(),
                issuedCheque.getPurchaseInvoice().getSupplier().getName(),
                issuedCheque.getPurchaseInvoice().getPurchaseInvoicePK().getInvNo()
            };
            chequeTableModel.addRow(row);
        }
    }

    protected void onLoad() {
        initComponents();
        cashTableModel = (DefaultTableModel) cashTable.getModel();
        chequeTableModel = (DefaultTableModel) chequeTable.getModel();
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
        for (int i = 0; i < cashTableModel.getRowCount(); i++) {
            total += Double.valueOf(cashTableModel.getValueAt(i, 6).toString());
        }
        cashTotalLabel.setText(nf2d.format(total));
        total = 0;
        for (int i = 0; i < chequeTableModel.getRowCount(); i++) {
            total += Double.valueOf(chequeTableModel.getValueAt(i, 5).toString());
        }
        chequeTableLabel.setText(nf2d.format(total));
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
