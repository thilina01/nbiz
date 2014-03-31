/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.gui;

import com.nanosl.nbiz.util.Combo;
import static com.nanosl.nbiz.util.Format.nf2d;
import com.nanosl.nbiz.util.NTopComponent;
import entity.Item;
import entity.ItemType;
import entity.LastCode;
import entity.PriceList;
import entity.Stock;
import entity.Supplier;
import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.netbeans.api.progress.ProgressHandle;
import org.netbeans.api.progress.ProgressHandleFactory;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.windows.TopComponent;
import org.openide.util.NbBundle.Messages;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
        dtd = "-//com.nanosl.nbiz.gui//Item//EN",
        autostore = false)
@TopComponent.Description(
        preferredID = "ItemTopComponent",
        //iconBase="SET/PATH/TO/ICON/HERE", 
        persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@ActionID(category = "Window", id = "com.nanosl.nbiz.gui.ItemTopComponent")
@ActionReference(path = "Menu/Main" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_ItemAction",
        preferredID = "ItemTopComponent")
@Messages({
    "CTL_ItemAction=Item",
    "CTL_ItemTopComponent=Item Window",
    "HINT_ItemTopComponent=This is a Item window"
})
public final class ItemTopComponent extends NTopComponent {

    public ItemTopComponent() {
        onLoad();
        setName(Bundle.CTL_ItemTopComponent());
        setToolTipText(Bundle.HINT_ItemTopComponent());

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
        jPanel2 = new javax.swing.JPanel();
        brandField = new javax.swing.JTextField();
        descriptionField = new javax.swing.JTextField();
        descriptionLabel = new javax.swing.JLabel();
        supplierComboBox = new javax.swing.JComboBox();
        codeField = new javax.swing.JTextField();
        supplierLabel = new javax.swing.JLabel();
        codeLabel = new javax.swing.JLabel();
        brandLabel = new javax.swing.JLabel();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        minimumLimitTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        itemTypeComboBox = new javax.swing.JComboBox();
        disableCheckBox = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        costTextField = new javax.swing.JTextField();
        sellingPriceTextField = new javax.swing.JTextField();
        quantityTextField = new javax.swing.JTextField();

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        masterTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Code", "Description", "Quantity", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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
        if (masterTable.getColumnModel().getColumnCount() > 0) {
            masterTable.getColumnModel().getColumn(0).setPreferredWidth(30);
            masterTable.getColumnModel().getColumn(0).setHeaderValue(org.openide.util.NbBundle.getMessage(ItemTopComponent.class, "ItemTopComponent.masterTable.columnModel.title0")); // NOI18N
            masterTable.getColumnModel().getColumn(1).setHeaderValue(org.openide.util.NbBundle.getMessage(ItemTopComponent.class, "ItemTopComponent.masterTable.columnModel.title1")); // NOI18N
            masterTable.getColumnModel().getColumn(2).setPreferredWidth(500);
            masterTable.getColumnModel().getColumn(2).setHeaderValue(org.openide.util.NbBundle.getMessage(ItemTopComponent.class, "ItemTopComponent.masterTable.columnModel.title2")); // NOI18N
            masterTable.getColumnModel().getColumn(3).setHeaderValue(org.openide.util.NbBundle.getMessage(ItemTopComponent.class, "ItemTopComponent.masterTable.columnModel.title3")); // NOI18N
            masterTable.getColumnModel().getColumn(3).setCellRenderer(rightAlignCell);
            masterTable.getColumnModel().getColumn(4).setHeaderValue(org.openide.util.NbBundle.getMessage(ItemTopComponent.class, "ItemTopComponent.masterTable.columnModel.title4")); // NOI18N
            masterTable.getColumnModel().getColumn(4).setCellRenderer(rightAlignCell);
        }

        brandField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brandFieldActionPerformed(evt);
            }
        });

        descriptionField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descriptionFieldActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(descriptionLabel, org.openide.util.NbBundle.getMessage(ItemTopComponent.class, "ItemTopComponent.descriptionLabel.text")); // NOI18N

        supplierComboBox.setName("supplierComboBox"); // NOI18N
        supplierComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplierComboBoxActionPerformed(evt);
            }
        });
        supplierComboBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                supplierComboBoxKeyPressed(evt);
            }
        });

        codeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codeFieldActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(supplierLabel, org.openide.util.NbBundle.getMessage(ItemTopComponent.class, "ItemTopComponent.supplierLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(codeLabel, org.openide.util.NbBundle.getMessage(ItemTopComponent.class, "ItemTopComponent.codeLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(brandLabel, org.openide.util.NbBundle.getMessage(ItemTopComponent.class, "ItemTopComponent.brandLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(updateButton, org.openide.util.NbBundle.getMessage(ItemTopComponent.class, "ItemTopComponent.updateButton.text")); // NOI18N
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(deleteButton, org.openide.util.NbBundle.getMessage(ItemTopComponent.class, "ItemTopComponent.deleteButton.text")); // NOI18N
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(clearButton, org.openide.util.NbBundle.getMessage(ItemTopComponent.class, "ItemTopComponent.clearButton.text")); // NOI18N
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(ItemTopComponent.class, "ItemTopComponent.jLabel1.text")); // NOI18N

        minimumLimitTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minimumLimitTextFieldActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(ItemTopComponent.class, "ItemTopComponent.jLabel2.text")); // NOI18N

        itemTypeComboBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                itemTypeComboBoxKeyPressed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(disableCheckBox, org.openide.util.NbBundle.getMessage(ItemTopComponent.class, "ItemTopComponent.disableCheckBox.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(ItemTopComponent.class, "ItemTopComponent.jLabel3.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(ItemTopComponent.class, "ItemTopComponent.jLabel4.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel5, org.openide.util.NbBundle.getMessage(ItemTopComponent.class, "ItemTopComponent.jLabel5.text")); // NOI18N

        costTextField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        costTextField.setText(org.openide.util.NbBundle.getMessage(ItemTopComponent.class, "ItemTopComponent.costTextField.text")); // NOI18N
        costTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                costTextFieldActionPerformed(evt);
            }
        });

        sellingPriceTextField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        sellingPriceTextField.setText(org.openide.util.NbBundle.getMessage(ItemTopComponent.class, "ItemTopComponent.sellingPriceTextField.text")); // NOI18N
        sellingPriceTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sellingPriceTextFieldActionPerformed(evt);
            }
        });

        quantityTextField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        quantityTextField.setText(org.openide.util.NbBundle.getMessage(ItemTopComponent.class, "ItemTopComponent.quantityTextField.text")); // NOI18N
        quantityTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(410, 410, 410)
                        .addComponent(disableCheckBox))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(28, 28, 28)
                            .addComponent(minimumLimitTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(updateButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(deleteButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(clearButton))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(codeLabel)
                                .addComponent(descriptionLabel)
                                .addComponent(supplierLabel)
                                .addComponent(brandLabel))
                            .addGap(39, 39, 39)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(descriptionField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(codeField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(itemTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(supplierComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(brandField))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(costTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(sellingPriceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(quantityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codeLabel)
                    .addComponent(codeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(itemTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(disableCheckBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descriptionLabel)
                    .addComponent(descriptionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(sellingPriceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(supplierLabel)
                    .addComponent(supplierComboBox)
                    .addComponent(jLabel3)
                    .addComponent(costTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(brandLabel)
                    .addComponent(brandField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(quantityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(minimumLimitTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearButton)
                    .addComponent(deleteButton)
                    .addComponent(updateButton))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(masterScrollPane)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 79, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void masterTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masterTableMouseReleased
        fill();
    }//GEN-LAST:event_masterTableMouseReleased

    private void masterTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_masterTableKeyReleased
        fill();
    }//GEN-LAST:event_masterTableKeyReleased

    private void brandFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brandFieldActionPerformed
        supplierComboBox.requestFocus();
    }//GEN-LAST:event_brandFieldActionPerformed

    private void descriptionFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descriptionFieldActionPerformed
        brandField.requestFocus();
    }//GEN-LAST:event_descriptionFieldActionPerformed

    private void supplierComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplierComboBoxActionPerformed
    }//GEN-LAST:event_supplierComboBoxActionPerformed

    private void supplierComboBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_supplierComboBoxKeyPressed
        if (evt.getKeyCode() == 10) {
            minimumLimitTextField.requestFocus();
            minimumLimitTextField.selectAll();
        }
    }//GEN-LAST:event_supplierComboBoxKeyPressed

    private void codeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codeFieldActionPerformed
        String code = codeField.getText().trim();
        if (!code.equals("")) {
            fill(manager.find(Item.class, code));
            itemTypeComboBox.requestFocus();
        }
    }//GEN-LAST:event_codeFieldActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        update();
    }//GEN-LAST:event_updateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        delete();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        clear();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void minimumLimitTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimumLimitTextFieldActionPerformed
        sellingPriceTextField.requestFocus();
        sellingPriceTextField.selectAll();
    }//GEN-LAST:event_minimumLimitTextFieldActionPerformed

    private void itemTypeComboBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itemTypeComboBoxKeyPressed
        if (evt.getKeyCode() == 10) {
            descriptionField.requestFocus();
        }
    }//GEN-LAST:event_itemTypeComboBoxKeyPressed

    private void costTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_costTextFieldActionPerformed
        quantityTextField.requestFocus();
        quantityTextField.selectAll();
    }//GEN-LAST:event_costTextFieldActionPerformed

    private void sellingPriceTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sellingPriceTextFieldActionPerformed
        codeField.requestFocus();
        codeField.selectAll();
    }//GEN-LAST:event_sellingPriceTextFieldActionPerformed

    private void quantityTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityTextFieldActionPerformed
        updateButton.requestFocus();
    }//GEN-LAST:event_quantityTextFieldActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField brandField;
    private javax.swing.JLabel brandLabel;
    private javax.swing.JButton clearButton;
    private javax.swing.JTextField codeField;
    private javax.swing.JLabel codeLabel;
    private javax.swing.JTextField costTextField;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField descriptionField;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JCheckBox disableCheckBox;
    private javax.swing.JComboBox itemTypeComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane masterScrollPane;
    private javax.swing.JTable masterTable;
    private javax.swing.JTextField minimumLimitTextField;
    private javax.swing.JTextField quantityTextField;
    private javax.swing.JTextField sellingPriceTextField;
    private javax.swing.JComboBox supplierComboBox;
    private javax.swing.JLabel supplierLabel;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
    DefaultTableModel tableModel;

    private void fill() {
        clearFields();
        int row = masterTable.getSelectedRow();
        if (row > -1) {
            Item item = manager.find(Item.class, masterTable.getValueAt(row, 1));
            fill(item);
        }
    }

    private void update() {
        String code = codeField.getText().trim();
        String description = descriptionField.getText().trim();
        if (code.equals("")) {
            codeField.requestFocus();
            return;
        }
        if (description.equals("")) {
            descriptionField.requestFocus();
            return;
        }
        String brand = brandField.getText().trim();

        try {
            String minLimText = minimumLimitTextField.getText().trim();
            minLimText = minLimText.isEmpty() ? "0.0" : minLimText;
            double minimumLimit = Double.parseDouble(minLimText);

            String costString = costTextField.getText().trim();
            costString = costString.isEmpty() ? "0.0" : costString;
            double cost = Double.parseDouble(costString);

            String sellingPriceString = sellingPriceTextField.getText().trim();
            sellingPriceString = sellingPriceString.isEmpty() ? "0.0" : sellingPriceString;
            double sellingPrice = Double.parseDouble(sellingPriceString);

            String quantityString = quantityTextField.getText().trim();
            quantityString = quantityString.isEmpty() ? "0.0" : quantityString;
            double quantity = Double.parseDouble(quantityString);

            Supplier supplier = (Supplier) supplierComboBox.getSelectedItem();
            Item item = manager.find(Item.class, code);
            List<Serializable> serializables = new ArrayList<>();
            if (item == null) {
                item = new Item(code);
                LastCode lastCode = manager.find(LastCode.class, "Item");
                lastCode = lastCode == null ? new LastCode("Item") : lastCode;
                lastCode.setCode(code);
                serializables.add(lastCode);
            }
            item.setDisable(disableCheckBox.isSelected() ? 1 : 0);
            item.setDescription(description);
            item.setBrand(brand);
            item.setSupplier(supplier);
            ItemType itemType = (ItemType) itemTypeComboBox.getSelectedItem();
            item.setItemTypeType(itemType);
            Stock stock = item.getStock();
            if (stock == null) {
                stock = new Stock(code);
                stock.setBundles(0.0);
                stock.setItem(item);
                item.setStock(stock);
            }
            stock.setQuantity(quantity);
            stock.setMinLimit(minimumLimit);
            serializables.add(stock);
            supplier.getItemCollection().add(item);
            PriceList priceList = manager.find(PriceList.class, code);
            priceList = priceList == null ? new PriceList(code) : priceList;
            priceList.setCostPack(cost);
            priceList.setItem(item);
            priceList.setSellingPack(sellingPrice);
            item.setPriceList(priceList);
            serializables.add(supplier);
            serializables.add(item);
            serializables.add(priceList);

            if (manager.update(serializables)) {
                clear();
                codeField.requestFocus();
                return;
            }
            showError("Unable to update " + code);
        } catch (NumberFormatException e) {
            showError("Check values again");
        }
    }

    private void delete() {
        String code = codeField.getText().trim();
        if (code.equals("")) {
            codeField.requestFocus();
            return;
        }
        if (JOptionPane.YES_OPTION != JOptionPane.showConfirmDialog(deleteButton, "Delete " + code + " ?", "sure?", JOptionPane.YES_NO_OPTION)) {
            return;
        }
        if (manager.delete(Item.class, code)) {
            clear();
            return;
//            showSuccess("Item Deleted");

        }
        showError("Unable to delete " + code);
    }

    private void clear() {
        fillTable();
        Combo.fillSuppliers(supplierComboBox);
//        fillSuppliers();
        fillItemTypes();
        clearFields();
        codeField.requestFocus();
    }

    private void clearFields() {
        codeField.setText("");
        descriptionField.setText("");
        brandField.setText("");
        minimumLimitTextField.setText("");
        costTextField.setText("");
        sellingPriceTextField.setText("");
        quantityTextField.setText("");
        disableCheckBox.setSelected(false);
        if (supplierComboBox.getItemCount() > 0) {
            supplierComboBox.setSelectedIndex(0);
        }
    }

    private void fillTable() {
        tableModel.setRowCount(0);
        SwingWorker<DefaultTableModel, Object[]> worker = new SwingWorker<DefaultTableModel, Object[]>() {
            @Override
            protected DefaultTableModel doInBackground() throws Exception {

                Runnable run = new Runnable() {
                    @Override
                    public void run() {
                        ProgressHandle p = ProgressHandleFactory.createHandle("Loading...");
                        p.start();

                        int i = 0;
                        List<Serializable> serializables = new ArrayList<>();
                        List<Item> items = manager.find(Item.class);
                        Collections.sort(items);
                        for (Item item : items) {
                            Stock stock = item.getStock();
                            if (stock == null) {
                                stock = new Stock(item.getCode());
                                stock.setBundles(0.0);
                                stock.setItem(item);
                                stock.setQuantity(0.0);
                                item.setStock(stock);
                                serializables.add(stock);
                            }
                            PriceList priceList = item.getPriceList();

                            if (priceList == null) {
                                priceList = new PriceList(item.getCode());
                                priceList.setCostPack(0.0);
                                priceList.setCostUnit(0.0);
                                priceList.setSellingPack(0.0);
                                priceList.setSellingUnit(0.0);
                                priceList.setItem(item);
                                item.setPriceList(priceList);
                                serializables.add(priceList);
                            }
                            manager.update(serializables);
                            double paymentAmount = priceList.getSellingPack() != null ? priceList.getSellingPack() : 0;
                            Object[] row = {++i, item.getCode(), item.getDescription(), stock.getQuantity(), nf2d.format(paymentAmount)};
                            publish(row);
                        }
                        p.finish();
                    }
                };
                Thread t = new Thread(run);
                t.start(); // start the task and progress visualisation

                return tableModel;
            }

            @Override
            protected void process(List<Object[]> chunks) {
                for (Iterator<Object[]> it = chunks.iterator(); it.hasNext();) {
                    tableModel.addRow(it.next());
                }
            }
        };
        worker.execute();
    }

    protected void onLoad() {
        initComponents();
        KeyAdapter();
        tableModel = (DefaultTableModel) masterTable.getModel();
        masterTable.setDefaultRenderer(Object.class, coloredCellRenderer);
        clear();
    }

    private void KeyAdapter() {
        AutoCompleteDecorator.decorate(supplierComboBox);
        setComboBoxKeyAdapters(supplierComboBox);
    }

//    private void fillSuppliers() {
//        supplierComboBox.setModel(new DefaultComboBoxModel(manager.find(Supplier.class).toArray()));
//    }

    private void fillItemTypes() {
        List<ItemType> itemTypes = manager.find(ItemType.class);
        if (itemTypes.isEmpty()) {
            manager.update(new ItemType("ITEM"));
            manager.update(new ItemType("METERIAL"));
        }
        itemTypes = manager.find(ItemType.class);
        itemTypeComboBox.setModel(new DefaultComboBoxModel(itemTypes.toArray()));
    }
    KeyAdapter supplierComboBoxKeyAdapter = new java.awt.event.KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent evt) {
            supplierComboBoxKeyPressed(evt);
        }
    };

    private void setComboBoxKeyAdapters(JComboBox supp) {
        String compName = supp.getName();
        Component component[] = supp.getComponents();
        for (Component component1 : component) {
            if (compName.equals("supplierComboBox")) {
                component1.addKeyListener(supplierComboBoxKeyAdapter);
            }
        }
    }

    private void fill(Item item) {
        if (item == null) {
            return;
        }
        codeField.setText(item.getCode());
        disableCheckBox.setSelected(item.getDisable() != null ? item.getDisable() == 1 : false);
        descriptionField.setText(item.getDescription());
        brandField.setText(item.getBrand());
        supplierComboBox.setSelectedItem(item.getSupplier());
        itemTypeComboBox.setSelectedItem(item.getItemTypeType());
        Stock stock = item.getStock();
        minimumLimitTextField.setText(stock != null ? stock.getMinLimit() != null ? stock.getMinLimit() + "" : "" : "0");
        quantityTextField.setText(stock != null ? stock.getQuantity() != null ? stock.getQuantity() + "" : "" : "0");
        PriceList priceList = item.getPriceList();
        costTextField.setText(priceList != null ? priceList.getCostPack() != null ? priceList.getCostPack() + "" : "" : "0");
        sellingPriceTextField.setText(priceList != null ? priceList.getSellingPack() != null ? priceList.getSellingPack() + "" : "" : "0");
    }

    @Override
    public void componentOpened() {
        codeField.requestFocus();
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
