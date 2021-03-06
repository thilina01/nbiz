/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.gui.tool;

import com.nanosl.nbiz.util.Combo;
import com.nanosl.nbiz.util.Convert;
import com.nanosl.nbiz.util.NTopComponent;
import entity.Account;
import entity.AccountPK;
import entity.Bank;
import entity.CashBox;
import entity.CashLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.TopComponent;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
        dtd = "-//com.nanosl.nbiz.gui.tool//Deposit//EN",
        autostore = false)
@TopComponent.Description(
        preferredID = "DepositTopComponent",
        //iconBase="SET/PATH/TO/ICON/HERE", 
        persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@ActionID(category = "Window", id = "com.nanosl.nbiz.gui.tool.DepositTopComponent")
@ActionReference(path = "Menu/Tools" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_DepositAction",
        preferredID = "DepositTopComponent")
@Messages({
    "CTL_DepositAction=Deposit",
    "CTL_DepositTopComponent=Deposit Window",
    "HINT_DepositTopComponent=This is a Deposit window"
})
public final class DepositTopComponent extends NTopComponent {

    public DepositTopComponent() {
        onLoad();
        setName(Bundle.CTL_DepositTopComponent());
        setToolTipText(Bundle.HINT_DepositTopComponent());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        codeLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        amountField = new javax.swing.JTextField();
        clearButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        bankComboBox = new javax.swing.JComboBox();
        accountComboBox = new javax.swing.JComboBox();
        codeLabel1 = new javax.swing.JLabel();
        cashBoxComboBox = new javax.swing.JComboBox();

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        org.openide.awt.Mnemonics.setLocalizedText(codeLabel, org.openide.util.NbBundle.getMessage(DepositTopComponent.class, "DepositTopComponent.codeLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(nameLabel, org.openide.util.NbBundle.getMessage(DepositTopComponent.class, "DepositTopComponent.nameLabel.text")); // NOI18N

        amountField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amountFieldActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(clearButton, org.openide.util.NbBundle.getMessage(DepositTopComponent.class, "DepositTopComponent.clearButton.text")); // NOI18N
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(updateButton, org.openide.util.NbBundle.getMessage(DepositTopComponent.class, "DepositTopComponent.updateButton.text")); // NOI18N
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel9, org.openide.util.NbBundle.getMessage(DepositTopComponent.class, "DepositTopComponent.jLabel9.text")); // NOI18N

        bankComboBox.setName("bankCombo"); // NOI18N
        bankComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bankComboBoxActionPerformed(evt);
            }
        });
        bankComboBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bankComboBoxKeyPressed(evt);
            }
        });

        accountComboBox.setName("bankCombo"); // NOI18N
        accountComboBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                accountComboBoxKeyPressed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(codeLabel1, org.openide.util.NbBundle.getMessage(DepositTopComponent.class, "DepositTopComponent.codeLabel1.text")); // NOI18N

        cashBoxComboBox.setName("bankCombo"); // NOI18N
        cashBoxComboBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cashBoxComboBoxKeyPressed(evt);
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(codeLabel)
                            .addComponent(codeLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(bankComboBox, 0, 199, Short.MAX_VALUE)
                            .addComponent(accountComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cashBoxComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(nameLabel)
                        .addGap(46, 46, 46)
                        .addComponent(amountField))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(updateButton)
                        .addGap(75, 75, 75)
                        .addComponent(clearButton)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bankComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(accountComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cashBoxComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codeLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(amountField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clearButton)
                    .addComponent(updateButton))
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

    private void amountFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amountFieldActionPerformed

        update();
    }//GEN-LAST:event_amountFieldActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        clear();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        update();
    }//GEN-LAST:event_updateButtonActionPerformed

    private void bankComboBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bankComboBoxKeyPressed
        if (evt.getKeyCode() == 10) {
            accountComboBox.requestFocus();
        }
    }//GEN-LAST:event_bankComboBoxKeyPressed

    private void accountComboBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_accountComboBoxKeyPressed
        if (evt.getKeyCode() == 10) {
            cashBoxComboBox.requestFocus();
        }
    }//GEN-LAST:event_accountComboBoxKeyPressed

    private void cashBoxComboBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cashBoxComboBoxKeyPressed
        if (evt.getKeyCode() == 10) {
            amountField.requestFocus();
        }
    }//GEN-LAST:event_cashBoxComboBoxKeyPressed

    private void bankComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bankComboBoxActionPerformed
        fillAccounts();
    }//GEN-LAST:event_bankComboBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox accountComboBox;
    private javax.swing.JTextField amountField;
    private javax.swing.JComboBox bankComboBox;
    private javax.swing.JComboBox cashBoxComboBox;
    private javax.swing.JButton clearButton;
    private javax.swing.JLabel codeLabel;
    private javax.swing.JLabel codeLabel1;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
//    List<Bank> banks;
//    DefaultTableModel tableModel;

    private void clear() {
        clearFields();
        fillCombo();
    }

    private void fillCombo() {
        Combo.fillCashBoxes(cashBoxComboBox);
        Combo.fillBanks(bankComboBox);
    }

    protected void onLoad() {
        initComponents();
//        tableModel = (DefaultTableModel) masterTable.getModel();
//        masterTable.setDefaultRenderer(Object.class, coloredCellRenderer);
        clear();
    }

    private void update() {
        Account account = (Account) accountComboBox.getSelectedItem();
        if (account == null) {
            return;
        }
        String amountText = amountField.getText().trim();
        double amount = 0;
        try {
            amount = Double.parseDouble(amountText);
        } catch (NumberFormatException numberFormatException) {
            amountField.requestFocus();
        }
        if (amountText.equals("")) {
            amountField.requestFocus();
            return;
        }

        CashBox cashBox = (CashBox) cashBoxComboBox.getSelectedItem();
        cashBox = manager.find(CashBox.class, cashBox.getId());
        double oldBalance = cashBox.getBalance();
        cashBox.setBalance(oldBalance - amount);
        CashLog cashLog = new CashLog(new Date(), cashBox.getId());
        cashLog.setAmount(0 - amount);
        cashLog.setCashBox(cashBox);
        cashLog.setBoxBalance(oldBalance);
        cashLog.setEntity(Account.class.getName());
        cashLog.setEntityId(Convert.toBytes(account.getAccountPK()));

        List<Serializable> serializables = new ArrayList<>();
        serializables.add(cashBox);
        serializables.add(cashLog);

//        Bank bank = (Bank) bankComboBox.getSelectedItem();
//        Account account = new Account(account, bank.getCode());
//        account.setBank(bank);
        account.setBalance(account.getBalance() + amount);
        serializables.add(account);
//        
//        int index = banks.indexOf(bank);
//        bank = index == -1 ? bank : banks.get(index);
//        bank.setName(balanceText);

        if (manager.update(serializables)) {
            clear();
            bankComboBox.requestFocus();
            return;
        }
        showError("Unable To Update!");
    }

//    private void delete() {
//        String accountNumber = accountNumberField.getText().trim();
//        if (accountNumber.equals("")) {
//            accountNumberField.requestFocus();
//            return;
//        }
//        if (JOptionPane.YES_OPTION != JOptionPane.showConfirmDialog(deleteButton, "Account " + accountNumber + " ?", "sure?", JOptionPane.YES_NO_OPTION)) {
//            return;
//        }
//        Bank bank = (Bank) bankComboBox.getSelectedItem();
//        if (manager.delete(Account.class, new AccountPK(accountNumber, bank.getCode()))) {
//            clear();
//            return;
//        }
//        showError("Unable to delete " + accountNumber);
//    }
//
//    private void fill() {
//        int row = masterTable.getSelectedRow();
//        if (row > -1) {
//            String accountNumber = masterTable.getValueAt(row, 1).toString();
//            Bank bank = (Bank) masterTable.getValueAt(row, 2);
////            Account account = manager.find(Account.class, new AccountPK(accountNumber, bank.getCode()));
//            accountNumberField.setText("" + accountNumber);
//            bankComboBox.setSelectedItem(bank);
//            amountField.setText("" + masterTable.getValueAt(row, 3));
//        }
//    }
    private void clearFields() {
//        accountNumberField.requestFocus();
//        accountNumberField.setText("");
        amountField.setText("");
    }

    @Override
    public void componentOpened() {
        bankComboBox.requestFocus();
        // TODO add custom code on component opening
    }

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
        Combo.fillBanks(bankComboBox);
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

    private void fillAccounts() {
        Bank bank = (Bank) bankComboBox.getSelectedItem();
        List<Account> accounts = (List<Account>) bank.getAccountCollection();;
        if (accounts != null) {
            Account[] as = accounts.toArray(new Account[0]);
            Arrays.sort(as);
            accountComboBox.setModel(new DefaultComboBoxModel<>(as));
        }

    }
}
