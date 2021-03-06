/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.gui.tool;

import com.nanosl.nbiz.util.Combo;
import com.nanosl.nbiz.util.NTopComponent;
import entity.Account;
import entity.AccountPK;
import entity.Bank;
import java.util.List;
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
        dtd = "-//com.nanosl.nbiz.gui.tool//Account//EN",
        autostore = false)
@TopComponent.Description(
        preferredID = "AccountTopComponent",
        //iconBase="SET/PATH/TO/ICON/HERE", 
        persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@ActionID(category = "Window", id = "com.nanosl.nbiz.gui.tool.AccountTopComponent")
@ActionReference(path = "Menu/Tools" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_AccountAction",
        preferredID = "AccountTopComponent")
@Messages({
    "CTL_AccountAction=Account",
    "CTL_AccountTopComponent=Account Window",
    "HINT_AccountTopComponent=This is a Account window"
})
public final class AccountTopComponent extends NTopComponent {

    public AccountTopComponent() {
        onLoad();
        setName(Bundle.CTL_AccountTopComponent());
        setToolTipText(Bundle.HINT_AccountTopComponent());

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
        codeLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        accountNumberField = new javax.swing.JTextField();
        balanceField = new javax.swing.JTextField();
        clearButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        bankComboBox = new javax.swing.JComboBox();

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        masterTable.setAutoCreateRowSorter(true);
        masterTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Account Number", "Bank", "Balance"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

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
            masterTable.getColumnModel().getColumn(0).setHeaderValue(org.openide.util.NbBundle.getMessage(AccountTopComponent.class, "AccountTopComponent.masterTable.columnModel.title0")); // NOI18N
            masterTable.getColumnModel().getColumn(1).setHeaderValue(org.openide.util.NbBundle.getMessage(AccountTopComponent.class, "AccountTopComponent.masterTable.columnModel.title1")); // NOI18N
            masterTable.getColumnModel().getColumn(2).setHeaderValue(org.openide.util.NbBundle.getMessage(AccountTopComponent.class, "AccountTopComponent.masterTable.columnModel.title2")); // NOI18N
            masterTable.getColumnModel().getColumn(3).setHeaderValue(org.openide.util.NbBundle.getMessage(AccountTopComponent.class, "AccountTopComponent.masterTable.columnModel.title3")); // NOI18N
            masterTable.getColumnModel().getColumn(3).setCellRenderer(null);
        }

        org.openide.awt.Mnemonics.setLocalizedText(codeLabel, org.openide.util.NbBundle.getMessage(AccountTopComponent.class, "AccountTopComponent.codeLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(nameLabel, org.openide.util.NbBundle.getMessage(AccountTopComponent.class, "AccountTopComponent.nameLabel.text")); // NOI18N

        accountNumberField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountNumberFieldActionPerformed(evt);
            }
        });

        balanceField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                balanceFieldActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(clearButton, org.openide.util.NbBundle.getMessage(AccountTopComponent.class, "AccountTopComponent.clearButton.text")); // NOI18N
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(updateButton, org.openide.util.NbBundle.getMessage(AccountTopComponent.class, "AccountTopComponent.updateButton.text")); // NOI18N
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(deleteButton, org.openide.util.NbBundle.getMessage(AccountTopComponent.class, "AccountTopComponent.deleteButton.text")); // NOI18N
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel9, org.openide.util.NbBundle.getMessage(AccountTopComponent.class, "AccountTopComponent.jLabel9.text")); // NOI18N

        bankComboBox.setName("bankCombo"); // NOI18N
        bankComboBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bankComboBoxKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(masterScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(codeLabel)
                                    .addComponent(nameLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(60, 60, 60)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(bankComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(updateButton)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(deleteButton)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(clearButton))
                                .addComponent(balanceField)
                                .addComponent(accountNumberField)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(masterScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codeLabel)
                    .addComponent(accountNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bankComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(balanceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clearButton)
                    .addComponent(deleteButton)
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

    private void masterTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masterTableMouseClicked
        fill();
    }//GEN-LAST:event_masterTableMouseClicked

    private void masterTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masterTableMouseReleased
        fill();
    }//GEN-LAST:event_masterTableMouseReleased

    private void masterTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_masterTableKeyReleased
        fill();
    }//GEN-LAST:event_masterTableKeyReleased

    private void accountNumberFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountNumberFieldActionPerformed
        if (!accountNumberField.getText().trim().equals("")) {
            bankComboBox.requestFocus();
        }
    }//GEN-LAST:event_accountNumberFieldActionPerformed

    private void balanceFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_balanceFieldActionPerformed

        update();
    }//GEN-LAST:event_balanceFieldActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        clear();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        update();
    }//GEN-LAST:event_updateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        delete();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void bankComboBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bankComboBoxKeyPressed
        if (evt.getKeyCode() == 10) {
            balanceField.requestFocus();
        }
    }//GEN-LAST:event_bankComboBoxKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField accountNumberField;
    private javax.swing.JTextField balanceField;
    private javax.swing.JComboBox bankComboBox;
    private javax.swing.JButton clearButton;
    private javax.swing.JLabel codeLabel;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane masterScrollPane;
    private javax.swing.JTable masterTable;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
//    List<Bank> banks;
    DefaultTableModel tableModel;

    private void clear() {
        clearFields();
        fillTable();
    }

    private void fillTable() {
        List<Account> accounts = manager.find(Account.class);
        tableModel.setRowCount(0);
        int i = 0;
        for (Account account : accounts) {
            Object[] row = {++i, account.getAccountPK().getAccountNo(), account.getBank(), nf2dComma.format(account.getBalance())};
            tableModel.addRow(row);
        }
    }

    protected void onLoad() {
        initComponents();
        tableModel = (DefaultTableModel) masterTable.getModel();
        masterTable.setDefaultRenderer(Object.class, coloredCellRenderer);
        clear();
    }

    private void update() {
        String accountNumber = accountNumberField.getText().trim();
        String balanceText = balanceField.getText().trim();
        double balance = 0;
        try {
            balance = Double.parseDouble(balanceText);
        } catch (NumberFormatException numberFormatException) {
            balanceField.requestFocus();
        }
        if (accountNumber.equals("")) {
            accountNumberField.requestFocus();
            return;
        }
        if (balanceText.equals("")) {
            balanceField.requestFocus();
            return;
        }

        Bank bank = (Bank) bankComboBox.getSelectedItem();
        Account account = new Account(accountNumber, bank.getCode());
        account.setBank(bank);
        account.setBalance(balance);
//        
//        int index = banks.indexOf(bank);
//        bank = index == -1 ? bank : banks.get(index);
//        bank.setName(balanceText);
        if (manager.update(account)) {
            clear();
            accountNumberField.requestFocus();
            return;
        }
        showError("Unable To Update!");
    }

    private void delete() {
        String accountNumber = accountNumberField.getText().trim();
        if (accountNumber.equals("")) {
            accountNumberField.requestFocus();
            return;
        }
        if (JOptionPane.YES_OPTION != JOptionPane.showConfirmDialog(deleteButton, "Account " + accountNumber + " ?", "sure?", JOptionPane.YES_NO_OPTION)) {
            return;
        }
        Bank bank = (Bank) bankComboBox.getSelectedItem();
        if (manager.delete(Account.class, new AccountPK(accountNumber, bank.getCode()))) {
            clear();
            return;
        }
        showError("Unable to delete " + accountNumber);
    }

    private void fill() {
        int row = masterTable.getSelectedRow();
        if (row > -1) {
            String accountNumber = masterTable.getValueAt(row, 1).toString();
            Bank bank = (Bank) masterTable.getValueAt(row, 2);
//            Account account = manager.find(Account.class, new AccountPK(accountNumber, bank.getCode()));
            accountNumberField.setText("" + accountNumber);
            bankComboBox.setSelectedItem(bank);
            balanceField.setText("" + masterTable.getValueAt(row, 3));
        }
    }

    private void clearFields() {
        accountNumberField.requestFocus();
        accountNumberField.setText("");
        balanceField.setText("");
    }

    @Override
    public void componentOpened() {
        accountNumberField.requestFocus();
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
}
