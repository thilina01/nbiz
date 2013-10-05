/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.gui;

import com.nanosl.nbiz.util.NTopComponent;
import entity.Customer;
import java.util.Iterator;
import java.util.List;
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
        dtd = "-//com.nanosl.nbiz.gui//Customer//EN",
        autostore = false)
@TopComponent.Description(
        preferredID = "CustomerTopComponent",
        //iconBase="SET/PATH/TO/ICON/HERE", 
        persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@ActionID(category = "Window", id = "com.nanosl.nbiz.gui.CustomerTopComponent")
@ActionReference(path = "Menu/Sales" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_CustomerAction",
        preferredID = "CustomerTopComponent")
@Messages({
    "CTL_CustomerAction=Customer",
    "CTL_CustomerTopComponent=Customer Window",
    "HINT_CustomerTopComponent=This is a Customer window"
})
public final class CustomerTopComponent extends NTopComponent {

    public CustomerTopComponent() {
        onLoad();
        setName(Bundle.CTL_CustomerTopComponent());
        setToolTipText(Bundle.HINT_CustomerTopComponent());

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
        addressNumberLabel = new javax.swing.JLabel();
        addressStreetLabel = new javax.swing.JLabel();
        mobileLabel = new javax.swing.JLabel();
        fixedLineLabel = new javax.swing.JLabel();
        faxLabel = new javax.swing.JLabel();
        notesLabel = new javax.swing.JLabel();
        townCodeLabel = new javax.swing.JLabel();
        codeField = new javax.swing.JTextField();
        nameField = new javax.swing.JTextField();
        addressNumberField = new javax.swing.JTextField();
        addressStreetField = new javax.swing.JTextField();
        mobileField = new javax.swing.JTextField();
        fixedLineField = new javax.swing.JTextField();
        faxField = new javax.swing.JTextField();
        notesField = new javax.swing.JTextField();
        updateButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        cityField = new javax.swing.JTextField();

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        masterTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Code", "Name", "Mobile"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        masterTable.addMouseListener(new java.awt.event.MouseAdapter() {
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

        org.openide.awt.Mnemonics.setLocalizedText(codeLabel, org.openide.util.NbBundle.getMessage(CustomerTopComponent.class, "CustomerTopComponent.codeLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(nameLabel, org.openide.util.NbBundle.getMessage(CustomerTopComponent.class, "CustomerTopComponent.nameLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(addressNumberLabel, org.openide.util.NbBundle.getMessage(CustomerTopComponent.class, "CustomerTopComponent.addressNumberLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(addressStreetLabel, org.openide.util.NbBundle.getMessage(CustomerTopComponent.class, "CustomerTopComponent.addressStreetLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(mobileLabel, org.openide.util.NbBundle.getMessage(CustomerTopComponent.class, "CustomerTopComponent.mobileLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(fixedLineLabel, org.openide.util.NbBundle.getMessage(CustomerTopComponent.class, "CustomerTopComponent.fixedLineLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(faxLabel, org.openide.util.NbBundle.getMessage(CustomerTopComponent.class, "CustomerTopComponent.faxLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(notesLabel, org.openide.util.NbBundle.getMessage(CustomerTopComponent.class, "CustomerTopComponent.notesLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(townCodeLabel, org.openide.util.NbBundle.getMessage(CustomerTopComponent.class, "CustomerTopComponent.townCodeLabel.text")); // NOI18N

        codeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codeFieldActionPerformed(evt);
            }
        });

        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFieldActionPerformed(evt);
            }
        });

        addressNumberField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressNumberFieldActionPerformed(evt);
            }
        });

        addressStreetField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressStreetFieldActionPerformed(evt);
            }
        });

        mobileField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mobileFieldActionPerformed(evt);
            }
        });

        fixedLineField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fixedLineFieldActionPerformed(evt);
            }
        });

        faxField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                faxFieldActionPerformed(evt);
            }
        });

        notesField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notesFieldActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(updateButton, org.openide.util.NbBundle.getMessage(CustomerTopComponent.class, "CustomerTopComponent.updateButton.text")); // NOI18N
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(clearButton, org.openide.util.NbBundle.getMessage(CustomerTopComponent.class, "CustomerTopComponent.clearButton.text")); // NOI18N
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(deleteButton, org.openide.util.NbBundle.getMessage(CustomerTopComponent.class, "CustomerTopComponent.deleteButton.text")); // NOI18N
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        cityField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cityFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(codeLabel)
                        .addGap(58, 58, 58)
                        .addComponent(codeField, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameLabel)
                            .addComponent(addressNumberLabel)
                            .addComponent(addressStreetLabel)
                            .addComponent(townCodeLabel)
                            .addComponent(mobileLabel)
                            .addComponent(fixedLineLabel)
                            .addComponent(faxLabel)
                            .addComponent(notesLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(notesField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                            .addComponent(faxField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                            .addComponent(nameField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                            .addComponent(addressNumberField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                            .addComponent(addressStreetField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                            .addComponent(mobileField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                            .addComponent(fixedLineField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                            .addComponent(cityField, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(updateButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clearButton)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(masterScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codeLabel)
                    .addComponent(codeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addressNumberLabel)
                    .addComponent(addressNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addressStreetLabel)
                    .addComponent(addressStreetField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(townCodeLabel)
                    .addComponent(cityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mobileLabel)
                    .addComponent(mobileField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fixedLineLabel)
                    .addComponent(fixedLineField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(faxLabel)
                    .addComponent(faxField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(notesLabel)
                    .addComponent(notesField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void masterTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masterTableMouseReleased
        fill();
    }//GEN-LAST:event_masterTableMouseReleased

    private void masterTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_masterTableKeyReleased
        fill();
    }//GEN-LAST:event_masterTableKeyReleased

    private void codeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codeFieldActionPerformed
        if (!codeField.getText().trim().equals("")) {
            nameField.requestFocus();
        }
    }//GEN-LAST:event_codeFieldActionPerformed

    private void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFieldActionPerformed
        if (!nameField.getText().trim().equals("")) {
            addressNumberField.requestFocus();
        }
    }//GEN-LAST:event_nameFieldActionPerformed

    private void addressNumberFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressNumberFieldActionPerformed
        if (!addressNumberField.getText().trim().equals("")) {
            addressStreetField.requestFocus();
        }
    }//GEN-LAST:event_addressNumberFieldActionPerformed

    private void addressStreetFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressStreetFieldActionPerformed
        if (!addressStreetField.getText().trim().equals("")) {
            cityField.requestFocus();
        }
    }//GEN-LAST:event_addressStreetFieldActionPerformed

    private void mobileFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mobileFieldActionPerformed

        fixedLineField.requestFocus();
    }//GEN-LAST:event_mobileFieldActionPerformed

    private void fixedLineFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fixedLineFieldActionPerformed
        faxField.requestFocus();
    }//GEN-LAST:event_fixedLineFieldActionPerformed

    private void faxFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_faxFieldActionPerformed
        notesField.requestFocus();
    }//GEN-LAST:event_faxFieldActionPerformed

    private void notesFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notesFieldActionPerformed
        updateButton.requestFocus();
    }//GEN-LAST:event_notesFieldActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        update();
    }//GEN-LAST:event_updateButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        clear();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        delete();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void cityFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cityFieldActionPerformed
        if (!cityField.getText().trim().equals("")) {
            mobileField.requestFocus();
        }
    }//GEN-LAST:event_cityFieldActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressNumberField;
    private javax.swing.JLabel addressNumberLabel;
    private javax.swing.JTextField addressStreetField;
    private javax.swing.JLabel addressStreetLabel;
    private javax.swing.JTextField cityField;
    private javax.swing.JButton clearButton;
    private javax.swing.JTextField codeField;
    private javax.swing.JLabel codeLabel;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField faxField;
    private javax.swing.JLabel faxLabel;
    private javax.swing.JTextField fixedLineField;
    private javax.swing.JLabel fixedLineLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane masterScrollPane;
    private javax.swing.JTable masterTable;
    private javax.swing.JTextField mobileField;
    private javax.swing.JLabel mobileLabel;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField notesField;
    private javax.swing.JLabel notesLabel;
    private javax.swing.JLabel townCodeLabel;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
    DefaultTableModel tableModel;

    protected void onLoad() {
        initComponents();
        tableModel = (DefaultTableModel) masterTable.getModel();
        clear();
    }

    private void clear() {
        clearFields();
        fillTable();
    }

    private void fillTable() {
        List<Customer> customers = m.find(Customer.class);
        tableModel.setRowCount(0);
        int i = 0;
        for (Iterator<Customer> it = customers.iterator(); it.hasNext();) {
            Customer customer = it.next();
            Object[] row = {++i, customer.getCode(), customer.getName(), customer.getMobile()};
            tableModel.addRow(row);
        }
    }

    private void clearFields() {
        codeField.requestFocus();
        codeField.setText("");
        nameField.setText("");
        addressNumberField.setText("");
        addressStreetField.setText("");
        cityField.setText("");
        mobileField.setText("");
        fixedLineField.setText("");
        faxField.setText("");
        notesField.setText("");
    }

    private void fillData(Customer customer) {
        codeField.setText(customer.getCode());
        nameField.setText(customer.getName());
        addressNumberField.setText(customer.getAddressNumber());
        addressStreetField.setText(customer.getAddressStreet());
        cityField.setText(customer.getCity());
        mobileField.setText(customer.getMobile());
        fixedLineField.setText(customer.getFixedLine());
        faxField.setText(customer.getFax());
        notesField.setText(customer.getNotes());
    }

    private void fill() {
        clearFields();
        int row = masterTable.getSelectedRow();
        if (row > -1) {
            Customer customer = m.find(Customer.class, masterTable.getValueAt(row, 1));
            fillData(customer);
        }
    }

    private void delete() {
        String code = codeField.getText().trim();
        if (code.equals("")) {
            codeField.requestFocus();
            return;
        }
        if (m.delete(Customer.class, code)) {
            clear();
            return;
        }
        showError("Unable to delete " + code);
    }

    private void update() {
        String code = codeField.getText().trim();
        String name = nameField.getText().trim();
        if (code.equals("")) {
            codeField.requestFocus();
            return;
        }
        if (name.equals("")) {
            nameField.requestFocus();
            return;
        }

        String addressNumber = addressNumberField.getText().trim();
        String addressStreet = addressStreetField.getText().trim();
        String mobile = mobileField.getText().trim();
        String fixedLine = fixedLineField.getText().trim();
        String fax = faxField.getText().trim();
        String notes = notesField.getText().trim();
        String city = cityField.getText().trim();
        Customer customer = m.find(Customer.class, code);
        if (customer == null) {
            customer = new Customer(code);
        }
        customer.setName(name);
        customer.setAddressNumber(addressNumber);
        customer.setAddressStreet(addressStreet);
        customer.setFax(fax);
        customer.setFixedLine(fixedLine);
        customer.setMobile(mobile);
        customer.setNotes(notes);
        customer.setCity(city);
        if (m.update(customer)) {
            clear();
            codeField.requestFocus();
            return;
        }
        showError("Unable to update " + code);
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
