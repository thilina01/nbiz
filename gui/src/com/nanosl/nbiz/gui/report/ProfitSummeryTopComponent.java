/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.gui.report;

import com.nanosl.lib.date.JXDatePicker;
import com.nanosl.nbiz.util.FindMySql;
import com.nanosl.nbiz.util.NTopComponent;
import java.util.Date;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.windows.TopComponent;
import org.openide.util.NbBundle.Messages;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
        dtd = "-//com.nanosl.nbiz.gui.report//ProfitSummery//EN",
        autostore = false)
@TopComponent.Description(
        preferredID = "ProfitSummeryTopComponent",
        //iconBase="SET/PATH/TO/ICON/HERE", 
        persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@ActionID(category = "Window", id = "com.nanosl.nbiz.gui.report.ProfitSummeryTopComponent")
@ActionReference(path = "Menu/Report" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_ProfitSummeryAction",
        preferredID = "ProfitSummeryTopComponent")
@Messages({
    "CTL_ProfitSummeryAction=ProfitSummery",
    "CTL_ProfitSummeryTopComponent=ProfitSummery Window",
    "HINT_ProfitSummeryTopComponent=This is a ProfitSummery window"
})
public final class ProfitSummeryTopComponent extends NTopComponent {

    public ProfitSummeryTopComponent() {
        onLoad();
        setName(Bundle.CTL_ProfitSummeryTopComponent());
        setToolTipText(Bundle.HINT_ProfitSummeryTopComponent());

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
        startDatePicker = new JXDatePicker();
        endDatePicker = new JXDatePicker();
        fillButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        totalSaleIncomeTextField = new javax.swing.JTextField();
        totalSaleCostTextField = new javax.swing.JTextField();
        totalSaleProfitTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        totalPaidExpensesTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        totalPaymentsTextField = new javax.swing.JTextField();
        totalChequesTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(ProfitSummeryTopComponent.class, "ProfitSummeryTopComponent.jLabel2.text")); // NOI18N

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

        org.openide.awt.Mnemonics.setLocalizedText(fillButton, org.openide.util.NbBundle.getMessage(ProfitSummeryTopComponent.class, "ProfitSummeryTopComponent.fillButton.text")); // NOI18N
        fillButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fillButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(ProfitSummeryTopComponent.class, "ProfitSummeryTopComponent.jLabel1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(ProfitSummeryTopComponent.class, "ProfitSummeryTopComponent.jLabel3.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(ProfitSummeryTopComponent.class, "ProfitSummeryTopComponent.jLabel4.text")); // NOI18N

        totalSaleIncomeTextField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        totalSaleIncomeTextField.setEnabled(false);

        totalSaleCostTextField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        totalSaleCostTextField.setEnabled(false);

        totalSaleProfitTextField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        totalSaleProfitTextField.setEnabled(false);

        org.openide.awt.Mnemonics.setLocalizedText(jLabel5, org.openide.util.NbBundle.getMessage(ProfitSummeryTopComponent.class, "ProfitSummeryTopComponent.jLabel5.text")); // NOI18N

        totalPaidExpensesTextField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        totalPaidExpensesTextField.setEnabled(false);

        org.openide.awt.Mnemonics.setLocalizedText(jLabel6, org.openide.util.NbBundle.getMessage(ProfitSummeryTopComponent.class, "ProfitSummeryTopComponent.jLabel6.text")); // NOI18N

        totalPaymentsTextField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        totalPaymentsTextField.setEnabled(false);

        totalChequesTextField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        totalChequesTextField.setEnabled(false);

        org.openide.awt.Mnemonics.setLocalizedText(jLabel7, org.openide.util.NbBundle.getMessage(ProfitSummeryTopComponent.class, "ProfitSummeryTopComponent.jLabel7.text")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalChequesTextField)
                    .addComponent(totalPaymentsTextField)
                    .addComponent(totalSaleIncomeTextField)
                    .addComponent(totalSaleCostTextField)
                    .addComponent(totalSaleProfitTextField)
                    .addComponent(totalPaidExpensesTextField))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(startDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(endDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fillButton)
                .addGap(10, 10, 10))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(startDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(endDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fillButton))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(totalSaleCostTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(totalSaleIncomeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(totalSaleProfitTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(totalPaidExpensesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(totalPaymentsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(totalChequesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void startDatePickerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startDatePickerActionPerformed

    }//GEN-LAST:event_startDatePickerActionPerformed

    private void endDatePickerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endDatePickerActionPerformed

    }//GEN-LAST:event_endDatePickerActionPerformed

    private void fillButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillButtonActionPerformed
        fill();
    }//GEN-LAST:event_fillButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXDatePicker endDatePicker;
    private javax.swing.JButton fillButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private org.jdesktop.swingx.JXDatePicker startDatePicker;
    private javax.swing.JTextField totalChequesTextField;
    private javax.swing.JTextField totalPaidExpensesTextField;
    private javax.swing.JTextField totalPaymentsTextField;
    private javax.swing.JTextField totalSaleCostTextField;
    private javax.swing.JTextField totalSaleIncomeTextField;
    private javax.swing.JTextField totalSaleProfitTextField;
    // End of variables declaration//GEN-END:variables
     private void onLoad() {

        initComponents();
    }

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
        clear();
    }

    private void clear() {
        totalSaleIncomeTextField.setText(nf2d.format(0));
        totalSaleCostTextField.setText(nf2d.format(0));
        totalSaleProfitTextField.setText(nf2d.format(0));
        totalPaidExpensesTextField.setText(nf2d.format(0));
        totalPaymentsTextField.setText(nf2d.format(0));
        totalChequesTextField.setText(nf2d.format(0));

    }

    private void fill() {
        clear();
        Date startDate = startDatePicker.getDate();
        Date endDate = endDatePicker.getDate();
        double[] res = FindMySql.totalSaleSummeryBetweenDates(startDate, endDate);

        double totalSaleIncome = res[0];
        double totalSaleCost = res[1];
        double totalSaleProfit = res[2];

        double totalPaidExpenses = FindMySql.totalExpensesBetweenDates(startDate, endDate);
        double totalPayments = FindMySql.totalPaymentsBetweenDates(startDate, endDate);
        double totalCheques = FindMySql.totalChequesBetweenDates(startDate, endDate);

        totalSaleIncomeTextField.setText(nf2d.format(totalSaleIncome));
        totalSaleCostTextField.setText(nf2d.format(totalSaleCost));
        totalSaleProfitTextField.setText(nf2d.format(totalSaleProfit));
        totalPaidExpensesTextField.setText(nf2d.format(totalPaidExpenses));
        totalPaymentsTextField.setText(nf2d.format(totalPayments));
        totalChequesTextField.setText(nf2d.format(totalCheques));


    }
    
    @Override
    public void componentOpened() {
        // codeField.requestFocus();
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
