/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.gui;

import com.nanosl.nbiz.ctrl.SupplierCTRL;
import com.nanosl.nbiz.util.Combo;
import com.nanosl.nbiz.util.NTopComponent;
import entity.Supplier;
import entity.Town;
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
        dtd = "-//com.nanosl.nbiz.gui//Supplier//EN",
        autostore = false)
@TopComponent.Description(
        preferredID = "SupplierTopComponent",
        //iconBase="SET/PATH/TO/ICON/HERE", 
        persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@ActionID(category = "Window", id = "com.nanosl.nbiz.gui.SupplierTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_SupplierAction",
        preferredID = "SupplierTopComponent")
@Messages({
    "CTL_SupplierAction=Supplier",
    "CTL_SupplierTopComponent=Supplier Window",
    "HINT_SupplierTopComponent=This is a Supplier window"
})
public final class SupplierTopComponent extends NTopComponent {

    SupplierCTRL controller = new SupplierCTRL();

    public SupplierTopComponent() {
        initComponents();
        setName(Bundle.CTL_SupplierTopComponent());
        setToolTipText(Bundle.HINT_SupplierTopComponent());
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
        townLabel = new javax.swing.JLabel();
        codeField = new javax.swing.JTextField();
        nameField = new javax.swing.JTextField();
        addressNumberField = new javax.swing.JTextField();
        addressStreetField = new javax.swing.JTextField();
        mobileField = new javax.swing.JTextField();
        fixedLineField = new javax.swing.JTextField();
        faxField = new javax.swing.JTextField();
        notesField = new javax.swing.JTextField();
        clearButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        townComboBox = new javax.swing.JComboBox();
        addTownButton = new javax.swing.JButton();

        masterTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Code", "Name", "Town"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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

        org.openide.awt.Mnemonics.setLocalizedText(codeLabel, org.openide.util.NbBundle.getMessage(SupplierTopComponent.class, "SupplierTopComponent.codeLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(nameLabel, org.openide.util.NbBundle.getMessage(SupplierTopComponent.class, "SupplierTopComponent.nameLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(addressNumberLabel, org.openide.util.NbBundle.getMessage(SupplierTopComponent.class, "SupplierTopComponent.addressNumberLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(addressStreetLabel, org.openide.util.NbBundle.getMessage(SupplierTopComponent.class, "SupplierTopComponent.addressStreetLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(mobileLabel, org.openide.util.NbBundle.getMessage(SupplierTopComponent.class, "SupplierTopComponent.mobileLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(fixedLineLabel, org.openide.util.NbBundle.getMessage(SupplierTopComponent.class, "SupplierTopComponent.fixedLineLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(faxLabel, org.openide.util.NbBundle.getMessage(SupplierTopComponent.class, "SupplierTopComponent.faxLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(notesLabel, org.openide.util.NbBundle.getMessage(SupplierTopComponent.class, "SupplierTopComponent.notesLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(townLabel, org.openide.util.NbBundle.getMessage(SupplierTopComponent.class, "SupplierTopComponent.townLabel.text")); // NOI18N

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

        org.openide.awt.Mnemonics.setLocalizedText(clearButton, org.openide.util.NbBundle.getMessage(SupplierTopComponent.class, "SupplierTopComponent.clearButton.text")); // NOI18N
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(updateButton, org.openide.util.NbBundle.getMessage(SupplierTopComponent.class, "SupplierTopComponent.updateButton.text")); // NOI18N
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(deleteButton, org.openide.util.NbBundle.getMessage(SupplierTopComponent.class, "SupplierTopComponent.deleteButton.text")); // NOI18N
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        townComboBox.setName("townComboBox"); // NOI18N
        townComboBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                townComboBoxKeyPressed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(addTownButton, org.openide.util.NbBundle.getMessage(SupplierTopComponent.class, "SupplierTopComponent.addTownButton.text")); // NOI18N
        addTownButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTownButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(codeLabel)
                                    .addComponent(nameLabel)
                                    .addComponent(addressNumberLabel)
                                    .addComponent(addressStreetLabel)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(townLabel))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(mobileLabel)
                                    .addComponent(fixedLineLabel)
                                    .addComponent(faxLabel)
                                    .addComponent(notesLabel))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(codeField, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                            .addComponent(addressStreetField, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                            .addComponent(mobileField, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                            .addComponent(nameField, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                            .addComponent(addressNumberField, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                            .addComponent(notesField, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                            .addComponent(fixedLineField, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                            .addComponent(faxField, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(townComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(addTownButton)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 408, Short.MAX_VALUE)
                                .addComponent(updateButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(clearButton)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                .addGap(18, 18, 18)
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
                    .addComponent(townLabel)
                    .addComponent(townComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addTownButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                .addContainerGap())
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
        addressNumberField.requestFocus();
    }//GEN-LAST:event_nameFieldActionPerformed

    private void addressNumberFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressNumberFieldActionPerformed
        addressStreetField.requestFocus();
    }//GEN-LAST:event_addressNumberFieldActionPerformed

    private void addressStreetFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressStreetFieldActionPerformed
        townComboBox.requestFocus();
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

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        clear();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        update();
    }//GEN-LAST:event_updateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        delete();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void townComboBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_townComboBoxKeyPressed
        if (evt.getKeyCode() == 10) {
            mobileField.requestFocus();
        }
    }//GEN-LAST:event_townComboBoxKeyPressed

    private void addTownButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTownButtonActionPerformed
//        TownView.display();
    }//GEN-LAST:event_addTownButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addTownButton;
    private javax.swing.JTextField addressNumberField;
    private javax.swing.JLabel addressNumberLabel;
    private javax.swing.JTextField addressStreetField;
    private javax.swing.JLabel addressStreetLabel;
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
    private javax.swing.JComboBox townComboBox;
    private javax.swing.JLabel townLabel;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
    DefaultTableModel tableModel;

    @Override
    public void componentOpened() {
        tableModel = (DefaultTableModel) masterTable.getModel();
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

    private void fill() {
        clearFields();
        int row = masterTable.getSelectedRow();
        if (row > -1) {
            Supplier supplier = controller.getSuppllier(masterTable.getValueAt(row, 1).toString());
            codeField.setText(supplier.getCode());
            nameField.setText(supplier.getName());
            addressNumberField.setText(supplier.getAddressNumber());
            addressStreetField.setText(supplier.getAddressStreet());
            mobileField.setText(supplier.getMobile());
            fixedLineField.setText(supplier.getFixedLine());
            faxField.setText(supplier.getFax());
            notesField.setText(supplier.getNotes());
            townComboBox.setSelectedItem(supplier.getTown());
        }
    }

    private void clear() {
        controller.fillTable(tableModel);
        Combo.fillTowns(townComboBox);
        clearFields();
        codeField.requestFocus();
    }

    private void clearFields() {

        codeField.setText("");
        nameField.setText("");
        addressNumberField.setText("");
        addressStreetField.setText("");
        mobileField.setText("");
        fixedLineField.setText("");
        faxField.setText("");
        notesField.setText("");
        if (townComboBox.getItemCount() > 0) {
            townComboBox.setSelectedIndex(0);
        }
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
        Supplier supplier = new Supplier(code);
        supplier.setName(name);
        supplier.setAddressNumber(addressNumber);
        supplier.setAddressStreet(addressStreet);
        supplier.setFax(fax);
        supplier.setFixedLine(fixedLine);
        supplier.setMobile(mobile);
        supplier.setNotes(notes);
        supplier.setTown((Town) townComboBox.getSelectedItem());
//        supplier.setBank((Bank) bankComboBox.getSelectedItem());
        if (controller.update(supplier)) {
            clear();
            return;
        }
        showError("Unable to update " + code);
    }

    private void delete() {
        String code = codeField.getText().trim();
        if (code.equals("")) {
            codeField.requestFocus();
            return;
        }
        if (controller.delete(code)) {
            clear();
            return;
        }
        showError("Unable to delete " + code);
    }
}
