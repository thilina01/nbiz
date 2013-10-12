/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.gui.report;

import com.nanosl.lib.date.JXDatePicker;
import query.Find;
import com.nanosl.nbiz.util.NTopComponent;
import entity.CollectionReceipt;
import entity.SaleCheque;
import entity.SaleInvoice;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
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
        dtd = "-//com.nanosl.nbiz.gui.report//CollectionReport//EN",
        autostore = false)
@TopComponent.Description(
        preferredID = "CollectionReportTopComponent",
        //iconBase="SET/PATH/TO/ICON/HERE", 
        persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@ActionID(category = "Window", id = "com.nanosl.nbiz.gui.report.CollectionReportTopComponent")
@ActionReference(path = "Menu/Report" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_CollectionReportAction",
        preferredID = "CollectionReportTopComponent")
@Messages({
    "CTL_CollectionReportAction=CollectionReport",
    "CTL_CollectionReportTopComponent=CollectionReport Window",
    "HINT_CollectionReportTopComponent=This is a CollectionReport window"
})
public final class CollectionReportTopComponent extends NTopComponent {

    public CollectionReportTopComponent() {
        onLoad();
        setName(Bundle.CTL_CollectionReportTopComponent());
        setToolTipText(Bundle.HINT_CollectionReportTopComponent());

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
        startDatePicker = new JXDatePicker();
        jLabel3 = new javax.swing.JLabel();
        cashTotalLabel = new javax.swing.JLabel();
        endDatePicker = new JXDatePicker();
        jScrollPane1 = new javax.swing.JScrollPane();
        chequeTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        chequeTableLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cashTable.setAutoCreateRowSorter(true);
        cashTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Date", "Code", "Customer", "Invoce", "Amount", "Receipt"
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
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cashTableMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cashTableMouseClicked(evt);
            }
        });
        cashTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cashTableKeyReleased(evt);
            }
        });
        masterScrollPane.setViewportView(cashTable);
        cashTable.getColumnModel().getColumn(0).setPreferredWidth(30);
        cashTable.getColumnModel().getColumn(0).setHeaderValue(org.openide.util.NbBundle.getMessage(CollectionReportTopComponent.class, "CollectionReportTopComponent.cashTable.columnModel.title0")); // NOI18N
        cashTable.getColumnModel().getColumn(1).setHeaderValue(org.openide.util.NbBundle.getMessage(CollectionReportTopComponent.class, "CollectionReportTopComponent.cashTable.columnModel.title1")); // NOI18N
        cashTable.getColumnModel().getColumn(2).setHeaderValue(org.openide.util.NbBundle.getMessage(CollectionReportTopComponent.class, "CollectionReportTopComponent.cashTable.columnModel.title2")); // NOI18N
        cashTable.getColumnModel().getColumn(3).setPreferredWidth(500);
        cashTable.getColumnModel().getColumn(3).setHeaderValue(org.openide.util.NbBundle.getMessage(CollectionReportTopComponent.class, "CollectionReportTopComponent.cashTable.columnModel.title3")); // NOI18N
        cashTable.getColumnModel().getColumn(4).setHeaderValue(org.openide.util.NbBundle.getMessage(CollectionReportTopComponent.class, "CollectionReportTopComponent.cashTable.columnModel.title4")); // NOI18N
        cashTable.getColumnModel().getColumn(5).setHeaderValue(org.openide.util.NbBundle.getMessage(CollectionReportTopComponent.class, "CollectionReportTopComponent.cashTable.columnModel.title5")); // NOI18N
        cashTable.getColumnModel().getColumn(5).setCellRenderer(rightAlignCell);
        cashTable.getColumnModel().getColumn(6).setHeaderValue(org.openide.util.NbBundle.getMessage(CollectionReportTopComponent.class, "CollectionReportTopComponent.cashTable.columnModel.title6")); // NOI18N
        cashTable.getColumnModel().getColumn(6).setCellRenderer(rightAlignCell);

        startDatePicker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startDatePickerActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(CollectionReportTopComponent.class, "CollectionReportTopComponent.jLabel3.text")); // NOI18N

        cashTotalLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cashTotalLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        org.openide.awt.Mnemonics.setLocalizedText(cashTotalLabel, org.openide.util.NbBundle.getMessage(CollectionReportTopComponent.class, "CollectionReportTopComponent.cashTotalLabel.text")); // NOI18N

        endDatePicker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endDatePickerActionPerformed(evt);
            }
        });

        chequeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Cheque Number", "Bank", "Banking Date", "amount", "Code", "Name", "Invoice"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(chequeTable);
        chequeTable.getColumnModel().getColumn(0).setPreferredWidth(30);
        chequeTable.getColumnModel().getColumn(0).setHeaderValue(org.openide.util.NbBundle.getMessage(CollectionReportTopComponent.class, "CollectionReportTopComponent.chequeTable.columnModel.title0")); // NOI18N
        chequeTable.getColumnModel().getColumn(1).setHeaderValue(org.openide.util.NbBundle.getMessage(CollectionReportTopComponent.class, "CollectionReportTopComponent.chequeTable.columnModel.title1")); // NOI18N
        chequeTable.getColumnModel().getColumn(2).setHeaderValue(org.openide.util.NbBundle.getMessage(CollectionReportTopComponent.class, "CollectionReportTopComponent.chequeTable.columnModel.title2")); // NOI18N
        chequeTable.getColumnModel().getColumn(3).setHeaderValue(org.openide.util.NbBundle.getMessage(CollectionReportTopComponent.class, "CollectionReportTopComponent.chequeTable.columnModel.title3")); // NOI18N
        chequeTable.getColumnModel().getColumn(4).setHeaderValue(org.openide.util.NbBundle.getMessage(CollectionReportTopComponent.class, "CollectionReportTopComponent.chequeTable.columnModel.title4")); // NOI18N
        chequeTable.getColumnModel().getColumn(4).setCellRenderer(rightAlignCell);
        chequeTable.getColumnModel().getColumn(5).setHeaderValue(org.openide.util.NbBundle.getMessage(CollectionReportTopComponent.class, "CollectionReportTopComponent.chequeTable.columnModel.title5")); // NOI18N
        chequeTable.getColumnModel().getColumn(6).setPreferredWidth(200);
        chequeTable.getColumnModel().getColumn(6).setHeaderValue(org.openide.util.NbBundle.getMessage(CollectionReportTopComponent.class, "CollectionReportTopComponent.chequeTable.columnModel.title6")); // NOI18N
        chequeTable.getColumnModel().getColumn(7).setHeaderValue(org.openide.util.NbBundle.getMessage(CollectionReportTopComponent.class, "CollectionReportTopComponent.chequeTable.columnModel.title7")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(CollectionReportTopComponent.class, "CollectionReportTopComponent.jLabel1.text")); // NOI18N

        chequeTableLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(chequeTableLabel, org.openide.util.NbBundle.getMessage(CollectionReportTopComponent.class, "CollectionReportTopComponent.chequeTableLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(CollectionReportTopComponent.class, "CollectionReportTopComponent.jLabel2.text")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(masterScrollPane)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 814, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(startDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(endDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cashTotalLabel))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(chequeTableLabel)))
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
                    .addComponent(cashTotalLabel)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chequeTableLabel)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
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
        Collection<CollectionReceipt> collectionReceipts = Find.collectionReceiptsByDates(startDate, endDate);
        if (collectionReceipts == null) {
            showError("No Collection Record Found!");
        }
        int i1 = 0, i2 = 0;
        for (Iterator<CollectionReceipt> it = collectionReceipts.iterator(); it.hasNext();) {
            CollectionReceipt collectionReceipt = it.next();
            SaleInvoice saleInvoice = collectionReceipt.getSaleInvoice();
            Object[] row = {
                ++i1,
                yyyy_MM_dd.format(collectionReceipt.getCollectedTime()),
                saleInvoice.getCustomer().getCode(),
                saleInvoice.getCustomer().getName(),
                saleInvoice.getInvNo(),
                nf2d.format(collectionReceipt.getSaleCash().getAmount()),
                collectionReceipt.getReceiptNumber()
            };
            cashTableModel.addRow(row);
            Collection<SaleCheque> saleCheques = collectionReceipt.getSaleChequeCollection();
            for (Iterator<SaleCheque> it1 = saleCheques.iterator(); it1.hasNext();) {
                SaleCheque saleCheque = it1.next();
                Object[] row1 = {
                    ++i2,
                    saleCheque.getSaleChequePK().getChequeNumber(),
                    saleCheque.getBank().getName(),
                    yyyy_MM_dd.format(saleCheque.getBankingDate()),
                    nf2d.format(saleCheque.getAmount()),
                    saleInvoice.getCustomer().getCode(),
                    saleInvoice.getCustomer().getName(),
                    saleInvoice.getInvNo()
                };
                chequeTableModel.addRow(row1);
            }
        }
//
//        Collection<SaleCheque> saleCheques = Find.saleChequeByDates(startDate, endDate);
//        if (saleCheques == null) {
//            setStatusMessage("No Cheque Record Found!", Color.red);
//        }
//        i = 0;
//        for (Iterator<SaleCheque> it = saleCheques.iterator(); it.hasNext();) {
//            SaleCheque saleCheque = it.next();
//            CollectionReceipt collectionReceipt = saleCheque.getCollectionReceipt();
//            SaleInvoice saleInvoice = collectionReceipt.getSaleInvoice();
//            Object[] row = {
//                ++i,
//                saleCheque.getSaleChequePK().getChequeNumber(),
//                saleCheque.getBank().getName(),
//                yyyy_MM_dd.format(saleCheque.getBankingDate()),
//                nf2d.format(saleCheque.getAmount()),
//                saleInvoice.getCustomer().getCode(),
//                saleInvoice.getCustomer().getName(),
//                saleInvoice.getInvNo()
//            };
//            chequeTableModel.addRow(row);
//        }
    }

    protected void onLoad() {
        initComponents();
        cashTableModel = (DefaultTableModel) cashTable.getModel();
        chequeTableModel = (DefaultTableModel) chequeTable.getModel();
        cashTable.setDefaultRenderer(Object.class, coloredCellRenderer);
        chequeTable.setDefaultRenderer(Object.class, coloredCellRenderer);
    }

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
        fill();
    }

    private void fill() {
        fillTable();
        calcTotal();
    }

    private void calcTotal() {
        double total = 0;
        for (int i = 0; i < cashTableModel.getRowCount(); i++) {
            total += Double.valueOf(cashTableModel.getValueAt(i, 5).toString());
        }
        cashTotalLabel.setText(nf2d.format(total));
        total = 0;
        for (int i = 0; i < chequeTableModel.getRowCount(); i++) {
            total += Double.valueOf(chequeTableModel.getValueAt(i, 4).toString());
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
