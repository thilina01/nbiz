/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.gui.report;

import com.nanosl.lib.date.JXDatePicker;
import static com.nanosl.nbiz.util.Cell.coloredCellRenderer;
import com.nanosl.nbiz.util.Combo;
import com.nanosl.nbiz.util.Export;
import static com.nanosl.nbiz.util.Format.nf2d;
import static com.nanosl.nbiz.util.Format.yyyy_MM_dd;
import com.nanosl.nbiz.util.NTopComponent;
import entity.Employee;
import entity.SaleInvoice;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;
import query.Find;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
        dtd = "-//com.nanosl.nbiz.gui.report//SalesByInvoiceReport//EN",
        autostore = false
)
@TopComponent.Description(
        preferredID = "SalesByInvoiceReportTopComponent",
        //iconBase="SET/PATH/TO/ICON/HERE", 
        persistenceType = TopComponent.PERSISTENCE_ALWAYS
)
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@ActionID(category = "Window", id = "com.nanosl.nbiz.gui.report.SalesByInvoiceReportTopComponent")
@ActionReference(path = "Menu/Report" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_SalesByInvoiceReportTopComponentAction",
        preferredID = "SalesByInvoiceReportTopComponent"
)
@Messages({
    "CTL_SalesByInvoiceReportTopComponentAction=SalesByInvoiceReport",
    "CTL_SalesByInvoiceReportTopComponent=SalesByInvoiceReport Window",
    "HINT_SalesByInvoiceReportTopComponent=This is a SalesByInvoiceReport window"
})
public final class SalesByInvoiceReportTopComponent extends NTopComponent {

    public SalesByInvoiceReportTopComponent() {
        onLoad();
        setName(Bundle.CTL_SalesByInvoiceReportTopComponent());
        setToolTipText(Bundle.HINT_SalesByInvoiceReportTopComponent());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        totalLabel = new javax.swing.JLabel();
        startDatePicker = new JXDatePicker();
        endDatePicker = new JXDatePicker();
        fillButton = new javax.swing.JButton();
        employeeCheckBox = new javax.swing.JCheckBox();
        employeeComboBox = new javax.swing.JComboBox();
        freeCheckBox = new javax.swing.JCheckBox();
        updateButton = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(SalesByInvoiceReportTopComponent.class, "SalesByInvoiceReportTopComponent.jLabel2.text")); // NOI18N

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Date", "Invoice", "Amount", "Discount", "Credit Card"
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
        });
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setPreferredWidth(30);
            table.getColumnModel().getColumn(0).setHeaderValue(org.openide.util.NbBundle.getMessage(SalesByInvoiceReportTopComponent.class, "SalesByInvoiceReportTopComponent.table.columnModel.title0")); // NOI18N
            table.getColumnModel().getColumn(1).setPreferredWidth(100);
            table.getColumnModel().getColumn(1).setHeaderValue(org.openide.util.NbBundle.getMessage(SalesByInvoiceReportTopComponent.class, "SalesByInvoiceReportTopComponent.table.columnModel.title1")); // NOI18N
            table.getColumnModel().getColumn(2).setPreferredWidth(50);
            table.getColumnModel().getColumn(2).setHeaderValue(org.openide.util.NbBundle.getMessage(SalesByInvoiceReportTopComponent.class, "SalesByInvoiceReportTopComponent.table.columnModel.title2")); // NOI18N
            table.getColumnModel().getColumn(3).setPreferredWidth(100);
            table.getColumnModel().getColumn(3).setHeaderValue(org.openide.util.NbBundle.getMessage(SalesByInvoiceReportTopComponent.class, "SalesByInvoiceReportTopComponent.table.columnModel.title3")); // NOI18N
            table.getColumnModel().getColumn(3).setCellRenderer(rightAlignCell);
            table.getColumnModel().getColumn(4).setHeaderValue(org.openide.util.NbBundle.getMessage(SalesByInvoiceReportTopComponent.class, "SalesByInvoiceReportTopComponent.table.columnModel.title4_1")); // NOI18N
            table.getColumnModel().getColumn(4).setCellRenderer(rightAlignCell);
            table.getColumnModel().getColumn(5).setHeaderValue(org.openide.util.NbBundle.getMessage(SalesByInvoiceReportTopComponent.class, "SalesByInvoiceReportTopComponent.table.columnModel.title5_1")); // NOI18N
            table.getColumnModel().getColumn(5).setCellRenderer(rightAlignCell);
        }

        totalLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(totalLabel, org.openide.util.NbBundle.getMessage(SalesByInvoiceReportTopComponent.class, "SalesByInvoiceReportTopComponent.totalLabel.text")); // NOI18N

        startDatePicker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startDatePickerActionPerformed(evt);
            }
        });

        endDatePicker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endDatePickerActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(fillButton, org.openide.util.NbBundle.getMessage(SalesByInvoiceReportTopComponent.class, "SalesByInvoiceReportTopComponent.fillButton.text")); // NOI18N
        fillButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fillButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(employeeCheckBox, org.openide.util.NbBundle.getMessage(SalesByInvoiceReportTopComponent.class, "SalesByInvoiceReportTopComponent.employeeCheckBox.text")); // NOI18N
        employeeCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeCheckBoxActionPerformed(evt);
            }
        });

        employeeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeComboBoxActionPerformed(evt);
            }
        });
        employeeComboBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                employeeComboBoxKeyPressed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(freeCheckBox, org.openide.util.NbBundle.getMessage(SalesByInvoiceReportTopComponent.class, "SalesByInvoiceReportTopComponent.freeCheckBox.text")); // NOI18N
        freeCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                freeCheckBoxActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(updateButton, org.openide.util.NbBundle.getMessage(SalesByInvoiceReportTopComponent.class, "SalesByInvoiceReportTopComponent.updateButton.text")); // NOI18N
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(updateButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(totalLabel))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 822, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(startDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(endDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fillButton)
                        .addGap(18, 18, 18)
                        .addComponent(employeeCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(employeeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(freeCheckBox)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(startDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(endDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fillButton)
                    .addComponent(employeeCheckBox)
                    .addComponent(employeeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(freeCheckBox))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalLabel)
                    .addComponent(updateButton))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
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

    private void startDatePickerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startDatePickerActionPerformed

    }//GEN-LAST:event_startDatePickerActionPerformed

    private void endDatePickerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endDatePickerActionPerformed

    }//GEN-LAST:event_endDatePickerActionPerformed

    private void fillButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillButtonActionPerformed
        fill();
    }//GEN-LAST:event_fillButtonActionPerformed

    private void employeeCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_employeeCheckBoxActionPerformed

    private void employeeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeComboBoxActionPerformed

    }//GEN-LAST:event_employeeComboBoxActionPerformed

    private void employeeComboBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_employeeComboBoxKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_employeeComboBoxKeyPressed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        if (evt.getClickCount() > 1) {
            TopComponent tc = WindowManager.getDefault().findTopComponent("POSTopComponent");
            if (tc != null) {
                try {
                    //String parameter
                    Class[] paramString = new Class[1];
                    paramString[0] = String.class;
                    tc.getClass().getMethod("fillInvoice", paramString).invoke(tc, table.getValueAt(table.getSelectedRow(), 2).toString());
                    tc.open();
                    tc.requestActive();
//                if (tc instanceof com.nanos.nbiz.pos.POSTopComponent) {
//                    com.nanos.nbiz.pos.POSTopComponent ptc = (com.nanos.nbiz.pos.POSTopComponent) tc;
//                    ptc.fillInvoice(table.getValueAt(table.getSelectedRow(), 2).toString());
//                    ptc.open();
//                    ptc.requestActive();
//                }
                } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                    Exceptions.printStackTrace(ex);
                }
            }
        }
    }//GEN-LAST:event_tableMouseClicked

    private void freeCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_freeCheckBoxActionPerformed
        fill();
    }//GEN-LAST:event_freeCheckBoxActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        Export.toExcel(table, yyyy_MM_dd.format(makeStartDate(startDatePicker.getDate())) + " to " + yyyy_MM_dd.format(makeEndDate(endDatePicker.getDate())), getName().replace(" Window", ""));
           // TODO add your handling code here:
    }//GEN-LAST:event_updateButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox employeeCheckBox;
    private javax.swing.JComboBox employeeComboBox;
    private org.jdesktop.swingx.JXDatePicker endDatePicker;
    private javax.swing.JButton fillButton;
    private javax.swing.JCheckBox freeCheckBox;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXDatePicker startDatePicker;
    private javax.swing.JTable table;
    private javax.swing.JLabel totalLabel;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
     DefaultTableModel tableModel;

    private void fillTable() {
        tableModel.setRowCount(0);
        totalLabel.setText(nf2d.format(0));
        Date startDate = startDatePicker.getDate();
        Date endDate = endDatePicker.getDate();
        double totalSale = 0;
        Collection<SaleInvoice> saleInvoices;
        Object o = employeeComboBox.getSelectedItem();
        Employee employee = o instanceof Employee ? (Employee) o : null;
        if (employeeCheckBox.isSelected() && employee != null) {
            saleInvoices = Find.saleInvoicesByDatesAndEmployee(startDate, makeEndDate(endDate), employee);
        } else {
            saleInvoices = Find.saleInvoicesByDates(startDate, makeEndDate(endDate));
        }
        int rowNumber = 0;
        for (SaleInvoice saleInvoice : saleInvoices) {
            if (saleInvoice.getAmount() != 0 && freeCheckBox.isSelected()) {
                continue;
            }
            Object[] row = {
                ++rowNumber,
                yyyy_MM_dd_hh_mm_ss_a.format(saleInvoice.getInvTime()),
                saleInvoice.getInvNo(),
                nf2d.format(saleInvoice.getAmount()),
                nf2d.format(saleInvoice.getDiscount()),
                nf2d.format(saleInvoice.getPaidByCreditCard() != null ? saleInvoice.getPaidByCreditCard() : 0)
            };
            totalSale += saleInvoice.getAmount();
            tableModel.addRow(row);
        }
        totalLabel.setText(nf2d.format(totalSale));
    }

    protected void onLoad() {
        initComponents();
        tableModel = (DefaultTableModel) table.getModel();
        table.setDefaultRenderer(Object.class, coloredCellRenderer);
    }

    private void fill() {
        fillTable();
        calcTotal();
    }

    private void calcTotal() {
//        double totalProfit = 0;
        double totalIncome = 0, totalCreditCardPayment = 0,totalDiscount = 0;
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            totalDiscount += Double.valueOf(tableModel.getValueAt(i, 4).toString());
            totalIncome += Double.valueOf(tableModel.getValueAt(i, 3).toString());
            totalCreditCardPayment += Double.valueOf(tableModel.getValueAt(i, 5).toString());
        }
        totalLabel.setText("Total: Income " + nf2d.format(totalIncome) + " Credit Card: " + nf2d.format(totalCreditCardPayment)+ " Discount: " + nf2d.format(totalDiscount));//+ " & Profit " + nf2d.format(totalProfit));
    }

    @Override
    public void componentOpened() {
        Combo.fillEmployees(employeeComboBox);
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
