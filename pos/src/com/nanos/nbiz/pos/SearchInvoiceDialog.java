/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanos.nbiz.pos;

import com.nanosl.lib.date.JXDatePicker;
import com.nanosl.lib.db.Manager;
import static com.nanosl.nbiz.util.Cell.coloredCellRenderer;
import com.nanosl.nbiz.util.Format;
import static com.nanosl.nbiz.util.Format.nf2d;
import static com.nanosl.nbiz.util.Format.nf3p;
import entity.SaleInvoice;
import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import javax.swing.JComponent;
import javax.swing.table.DefaultTableModel;
import query.Find;

/**
 *
 * @author Thilina
 */
public class SearchInvoiceDialog extends javax.swing.JDialog {

    SaleInvoice saleInvoice;

    /**
     * Creates new form SearchCustomerDialog
     */
    public SearchInvoiceDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        invoiceTable.setDefaultRenderer(Object.class, coloredCellRenderer);
        invoiceTableModel = (DefaultTableModel) invoiceTable.getModel();
        setComboBoxKeyAdapters(datePicker);
//        getRootPane().setBorder( BorderFactory.createLineBorder(Color.blue) );
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        invoiceTable = new javax.swing.JTable();
        datePicker = new JXDatePicker();
        closeButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        invoiceNumberTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(SearchInvoiceDialog.class, "SearchInvoiceDialog.jLabel1.text")); // NOI18N

        invoiceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Number", "Time", "Amount", "Customer"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        invoiceTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                invoiceTableMouseClicked(evt);
            }
        });
        invoiceTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                invoiceTableKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                invoiceTableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(invoiceTable);
        if (invoiceTable.getColumnModel().getColumnCount() > 0) {
            invoiceTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            invoiceTable.getColumnModel().getColumn(0).setMaxWidth(80);
            invoiceTable.getColumnModel().getColumn(0).setHeaderValue(org.openide.util.NbBundle.getMessage(SearchInvoiceDialog.class, "SearchInvoiceDialog.invoiceTable.columnModel.title0")); // NOI18N
            invoiceTable.getColumnModel().getColumn(1).setPreferredWidth(70);
            invoiceTable.getColumnModel().getColumn(1).setHeaderValue(org.openide.util.NbBundle.getMessage(SearchInvoiceDialog.class, "SearchInvoiceDialog.invoiceTable.columnModel.title1")); // NOI18N
            invoiceTable.getColumnModel().getColumn(2).setPreferredWidth(150);
            invoiceTable.getColumnModel().getColumn(2).setHeaderValue(org.openide.util.NbBundle.getMessage(SearchInvoiceDialog.class, "SearchInvoiceDialog.invoiceTable.columnModel.title2")); // NOI18N
            invoiceTable.getColumnModel().getColumn(3).setPreferredWidth(70);
            invoiceTable.getColumnModel().getColumn(3).setHeaderValue(org.openide.util.NbBundle.getMessage(SearchInvoiceDialog.class, "SearchInvoiceDialog.invoiceTable.columnModel.title3")); // NOI18N
            invoiceTable.getColumnModel().getColumn(4).setPreferredWidth(200);
            invoiceTable.getColumnModel().getColumn(4).setHeaderValue(org.openide.util.NbBundle.getMessage(SearchInvoiceDialog.class, "SearchInvoiceDialog.invoiceTable.columnModel.title4_1")); // NOI18N
        }

        datePicker.setName("datePicker"); // NOI18N
        datePicker.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                datePickerKeyPressed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(closeButton, org.openide.util.NbBundle.getMessage(SearchInvoiceDialog.class, "SearchInvoiceDialog.closeButton.text")); // NOI18N
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(SearchInvoiceDialog.class, "SearchInvoiceDialog.jLabel2.text")); // NOI18N

        invoiceNumberTextField.setText(org.openide.util.NbBundle.getMessage(SearchInvoiceDialog.class, "SearchInvoiceDialog.invoiceNumberTextField.text")); // NOI18N
        invoiceNumberTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoiceNumberTextFieldActionPerformed(evt);
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(datePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(invoiceNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(closeButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(datePicker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(closeButton)
                    .addComponent(jLabel2)
                    .addComponent(invoiceNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void invoiceTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_invoiceTableMouseClicked
        if (evt.getClickCount() > 1) {
            saleInvoice = Manager.getInstance().find(SaleInvoice.class, invoiceTable.getValueAt(invoiceTable.getSelectedRow(), 1).toString());
            dispose();
        }
    }//GEN-LAST:event_invoiceTableMouseClicked

    private void invoiceTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_invoiceTableKeyReleased

    }//GEN-LAST:event_invoiceTableKeyReleased

    private void invoiceTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_invoiceTableKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            datePicker.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            saleInvoice = Manager.getInstance().find(SaleInvoice.class, invoiceTable.getValueAt(invoiceTable.getSelectedRow(), 1).toString());
            dispose();
        }
    }//GEN-LAST:event_invoiceTableKeyPressed

    private void datePickerKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_datePickerKeyPressed
        if (evt.getKeyCode() == 10) {
            if (evt.getKeyCode() == 27) {
                dispose();
                return;
            } else if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
                if (invoiceTable.getRowCount() > 0) {
                    invoiceTable.requestFocus();
                    invoiceTable.setRowSelectionInterval(0, 0);
                    return;
                }
            }
            invoiceTableModel.setRowCount(0);
            Date firstDate = datePicker.getDate();
            Calendar cal = Calendar.getInstance();
            cal.setTime(firstDate);
            cal.set(Calendar.HOUR_OF_DAY, 23);
            cal.set(Calendar.MINUTE, 59);
            cal.set(Calendar.SECOND, 59);
            cal.set(Calendar.MILLISECOND, 900);

            Date d = cal.getTime();
            if (firstDate != null) {
                Collection<SaleInvoice> saleInvoices = Find.saleInvoicesByDates(firstDate, cal.getTime());
                if (saleInvoices == null) {
                    return;
                }
                int i = 0;
                for (SaleInvoice saleInvoice1 : saleInvoices) {
                    Object[] row = {
                        nf3p.format(++i),
                        saleInvoice1.getInvNo(),
                        Format.yyyy_MM_dd_hh_mm_ss_a.format(saleInvoice1.getInvTime()),
                        nf2d.format(saleInvoice1.getAmount()),
                        saleInvoice1.getCustomerName()
                    };
                    invoiceTableModel.addRow(row);
                }
            }
        }
    }//GEN-LAST:event_datePickerKeyPressed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        dispose();
    }//GEN-LAST:event_closeButtonActionPerformed

    private void invoiceNumberTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoiceNumberTextFieldActionPerformed
        saleInvoice = Manager.getInstance().find(SaleInvoice.class, invoiceNumberTextField.getText().trim());
        dispose();
    }//GEN-LAST:event_invoiceNumberTextFieldActionPerformed
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SearchInvoiceDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchInvoiceDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchInvoiceDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchInvoiceDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                SearchInvoiceDialog dialog = new SearchInvoiceDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private org.jdesktop.swingx.JXDatePicker datePicker;
    private javax.swing.JTextField invoiceNumberTextField;
    private javax.swing.JTable invoiceTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    DefaultTableModel invoiceTableModel;

    private void setComboBoxKeyAdapters(JComponent comp) {
        String compName = comp.getName();
        if (compName == null) {
            return;
        }
        Component component[] = comp.getComponents();
        for (Component component1 : component) {
            switch (compName) {
                case "datePicker":
                    component1.addKeyListener(datePickerKeyAdapter);
                    break;
            }
        }
    }
    KeyAdapter datePickerKeyAdapter = new java.awt.event.KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent evt) {
            datePickerKeyPressed(evt);
        }
    };
}
