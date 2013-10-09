/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.gui;

import com.nanosl.lib.date.JXDatePicker;
import com.nanosl.nbiz.util.NTopComponent;
import entity.Item;
import entity.LastCode;
import entity.PriceList;
import entity.PurchaseInvoice;
import entity.PurchaseInvoiceHasItem;
import entity.PurchaseInvoicePK;
import entity.Stock;
import entity.Supplier;
import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.windows.TopComponent;
import org.openide.util.NbBundle.Messages;
import com.nanosl.nbiz.util.Combo;
import javax.swing.SwingWorker;
import org.openide.awt.StatusDisplayer;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
        dtd = "-//com.nanosl.nbiz.gui//PurchaseInvoice//EN",
        autostore = false)
@TopComponent.Description(
        preferredID = "PurchaseInvoiceTopComponent",
        //iconBase="SET/PATH/TO/ICON/HERE", 
        persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@ActionID(category = "Window", id = "com.nanosl.nbiz.gui.PurchaseInvoiceTopComponent")
@ActionReference(path = "Menu/Purchase" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_PurchaseInvoiceAction",
        preferredID = "PurchaseInvoiceTopComponent")
@Messages({
    "CTL_PurchaseInvoiceAction=PurchaseInvoice",
    "CTL_PurchaseInvoiceTopComponent=PurchaseInvoice Window",
    "HINT_PurchaseInvoiceTopComponent=This is a PurchaseInvoice window"
})
public final class PurchaseInvoiceTopComponent extends NTopComponent {

    static PurchaseInvoiceTopComponent instance;

    static void display() {
        instance.setVisible(true);
    }

    public PurchaseInvoiceTopComponent() {
        if (instance == null) {
            onLoad();
            setName(Bundle.CTL_PurchaseInvoiceTopComponent());
            setToolTipText(Bundle.HINT_PurchaseInvoiceTopComponent());
            instance = this;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        datePicker = new JXDatePicker();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        invoiceNumberField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        supplierComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        itemComboBox = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        quantityField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        valueField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        totalAmountLabel = new javax.swing.JLabel();
        processButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        discountField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        totalDiscountLabel = new javax.swing.JLabel();

        datePicker.setName("datePicker"); // NOI18N
        datePicker.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                datePickerKeyPressed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(PurchaseInvoiceTopComponent.class, "PurchaseInvoiceTopComponent.jLabel1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(PurchaseInvoiceTopComponent.class, "PurchaseInvoiceTopComponent.jLabel2.text")); // NOI18N

        invoiceNumberField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoiceNumberFieldActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(PurchaseInvoiceTopComponent.class, "PurchaseInvoiceTopComponent.jLabel3.text")); // NOI18N

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
            public void keyReleased(java.awt.event.KeyEvent evt) {
                supplierComboBoxKeyReleased(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(PurchaseInvoiceTopComponent.class, "PurchaseInvoiceTopComponent.jLabel4.text")); // NOI18N

        itemComboBox.setName("itemComboBox"); // NOI18N
        itemComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemComboBoxActionPerformed(evt);
            }
        });
        itemComboBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                itemComboBoxKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                itemComboBoxKeyReleased(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel5, org.openide.util.NbBundle.getMessage(PurchaseInvoiceTopComponent.class, "PurchaseInvoiceTopComponent.jLabel5.text")); // NOI18N

        quantityField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                quantityFieldMouseClicked(evt);
            }
        });
        quantityField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityFieldActionPerformed(evt);
            }
        });
        quantityField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                quantityFieldFocusGained(evt);
            }
        });
        quantityField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                quantityFieldKeyPressed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel6, org.openide.util.NbBundle.getMessage(PurchaseInvoiceTopComponent.class, "PurchaseInvoiceTopComponent.jLabel6.text")); // NOI18N

        valueField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                valueFieldMouseClicked(evt);
            }
        });
        valueField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valueFieldActionPerformed(evt);
            }
        });
        valueField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                valueFieldFocusGained(evt);
            }
        });
        valueField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                valueFieldKeyPressed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Code", "Description", "Value", "Quantity", "Net", "Discount", "D%", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(table);
        table.getColumnModel().getColumn(0).setHeaderValue(org.openide.util.NbBundle.getMessage(PurchaseInvoiceTopComponent.class, "PurchaseInvoiceTopComponent.table.columnModel.title0")); // NOI18N
        table.getColumnModel().getColumn(1).setHeaderValue(org.openide.util.NbBundle.getMessage(PurchaseInvoiceTopComponent.class, "PurchaseInvoiceTopComponent.table.columnModel.title1")); // NOI18N
        table.getColumnModel().getColumn(2).setHeaderValue(org.openide.util.NbBundle.getMessage(PurchaseInvoiceTopComponent.class, "PurchaseInvoiceTopComponent.table.columnModel.title2")); // NOI18N
        table.getColumnModel().getColumn(3).setHeaderValue(org.openide.util.NbBundle.getMessage(PurchaseInvoiceTopComponent.class, "PurchaseInvoiceTopComponent.table.columnModel.title3")); // NOI18N
        table.getColumnModel().getColumn(3).setCellRenderer(rightAlignCell);
        table.getColumnModel().getColumn(4).setHeaderValue(org.openide.util.NbBundle.getMessage(PurchaseInvoiceTopComponent.class, "PurchaseInvoiceTopComponent.table.columnModel.title4")); // NOI18N
        table.getColumnModel().getColumn(4).setCellRenderer(rightAlignCell);
        table.getColumnModel().getColumn(5).setHeaderValue(org.openide.util.NbBundle.getMessage(PurchaseInvoiceTopComponent.class, "PurchaseInvoiceTopComponent.table.columnModel.title5")); // NOI18N
        table.getColumnModel().getColumn(5).setCellRenderer(rightAlignCell);
        table.getColumnModel().getColumn(6).setHeaderValue(org.openide.util.NbBundle.getMessage(PurchaseInvoiceTopComponent.class, "PurchaseInvoiceTopComponent.table.columnModel.title6")); // NOI18N
        table.getColumnModel().getColumn(6).setCellRenderer(rightAlignCell);
        table.getColumnModel().getColumn(7).setHeaderValue(org.openide.util.NbBundle.getMessage(PurchaseInvoiceTopComponent.class, "PurchaseInvoiceTopComponent.table.columnModel.title7")); // NOI18N
        table.getColumnModel().getColumn(7).setCellRenderer(rightAlignCell);
        table.getColumnModel().getColumn(8).setHeaderValue(org.openide.util.NbBundle.getMessage(PurchaseInvoiceTopComponent.class, "PurchaseInvoiceTopComponent.table.columnModel.title8")); // NOI18N
        table.getColumnModel().getColumn(8).setCellRenderer(rightAlignCell);

        org.openide.awt.Mnemonics.setLocalizedText(jLabel8, org.openide.util.NbBundle.getMessage(PurchaseInvoiceTopComponent.class, "PurchaseInvoiceTopComponent.jLabel8.text")); // NOI18N

        totalAmountLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        totalAmountLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        totalAmountLabel.setMaximumSize(new java.awt.Dimension(6, 20));
        totalAmountLabel.setMinimumSize(new java.awt.Dimension(6, 20));
        totalAmountLabel.setPreferredSize(null);

        org.openide.awt.Mnemonics.setLocalizedText(processButton, org.openide.util.NbBundle.getMessage(PurchaseInvoiceTopComponent.class, "PurchaseInvoiceTopComponent.processButton.text")); // NOI18N
        processButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(clearButton, org.openide.util.NbBundle.getMessage(PurchaseInvoiceTopComponent.class, "PurchaseInvoiceTopComponent.clearButton.text")); // NOI18N
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel7, org.openide.util.NbBundle.getMessage(PurchaseInvoiceTopComponent.class, "PurchaseInvoiceTopComponent.jLabel7.text")); // NOI18N

        discountField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discountFieldActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel9, org.openide.util.NbBundle.getMessage(PurchaseInvoiceTopComponent.class, "PurchaseInvoiceTopComponent.jLabel9.text")); // NOI18N

        totalDiscountLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        totalDiscountLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(processButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(clearButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(totalDiscountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(totalAmountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(supplierComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(itemComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(invoiceNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(datePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(quantityField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(valueField, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(discountField, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 128, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(invoiceNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(supplierComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(datePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(itemComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(quantityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(valueField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(discountField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(totalAmountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(totalDiscountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(processButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(clearButton)))
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

    private void datePickerKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_datePickerKeyPressed
        if (evt.getKeyCode() == 10) {
            itemComboBox.requestFocus();
        }
    }//GEN-LAST:event_datePickerKeyPressed

    private void invoiceNumberFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoiceNumberFieldActionPerformed
        if (!invoiceNumberField.getText().trim().equals("")) {
            datePicker.requestFocus();
        }
    }//GEN-LAST:event_invoiceNumberFieldActionPerformed

    private void supplierComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplierComboBoxActionPerformed
        fillItems();
    }//GEN-LAST:event_supplierComboBoxActionPerformed

    private void supplierComboBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_supplierComboBoxKeyPressed
        if (evt.getKeyCode() == 10) {
            invoiceNumberField.requestFocus();
        }
    }//GEN-LAST:event_supplierComboBoxKeyPressed

    private void supplierComboBoxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_supplierComboBoxKeyReleased
    }//GEN-LAST:event_supplierComboBoxKeyReleased

    private void itemComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemComboBoxActionPerformed
        fillCost();
    }//GEN-LAST:event_itemComboBoxActionPerformed

    private void itemComboBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itemComboBoxKeyPressed
        if (evt.getKeyCode() == 10) {
            fillCost();
            quantityField.requestFocus();
        }
    }//GEN-LAST:event_itemComboBoxKeyPressed

    private void itemComboBoxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itemComboBoxKeyReleased
    }//GEN-LAST:event_itemComboBoxKeyReleased

    private void quantityFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quantityFieldMouseClicked
        if (evt.getButton() == 3) {
            dozToItem();
        }
    }//GEN-LAST:event_quantityFieldMouseClicked

    private void quantityFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityFieldActionPerformed
        try {
            double quantity = Double.valueOf(quantityField.getText().trim());
            if (quantity > 0) {
                valueField.setSelectionStart(0);
                valueField.requestFocus();
            }
        } catch (NumberFormatException numberFormatException) {
        }
    }//GEN-LAST:event_quantityFieldActionPerformed

    private void quantityFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_quantityFieldFocusGained
        StatusDisplayer.getDefault().setStatusText("Hint: F2 for DOZ");
    }//GEN-LAST:event_quantityFieldFocusGained

    private void quantityFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantityFieldKeyPressed
        if (evt.getKeyCode() == 113) {
            dozToItem();
        }
    }//GEN-LAST:event_quantityFieldKeyPressed

    private void valueFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_valueFieldMouseClicked
        //        System.out.println(evt.getButton());
        if (evt.getButton() == 3) {
            dozPriceToItemPrice();
        }
    }//GEN-LAST:event_valueFieldMouseClicked

    private void valueFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valueFieldActionPerformed
        discountField.requestFocus();
    }//GEN-LAST:event_valueFieldActionPerformed

    private void valueFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valueFieldFocusGained
        StatusDisplayer.getDefault().setStatusText("Hint: F2 for DOZ");
    }//GEN-LAST:event_valueFieldFocusGained

    private void valueFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_valueFieldKeyPressed
        //        System.out.println(evt.getKeyCode());
        if (evt.getKeyCode() == 113) {
            dozPriceToItemPrice();
        }
    }//GEN-LAST:event_valueFieldKeyPressed

    private void tableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableKeyReleased
        if (evt.getKeyCode() == 127) {
            if (table.getSelectedRow() > -1) {
                dtm.removeRow(table.getSelectedRow());
                calcTotal();
            }
        }
    }//GEN-LAST:event_tableKeyReleased

    private void processButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processButtonActionPerformed
        process();
    }//GEN-LAST:event_processButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        clear();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void discountFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discountFieldActionPerformed
        addToTable();
    }//GEN-LAST:event_discountFieldActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearButton;
    private org.jdesktop.swingx.JXDatePicker datePicker;
    private javax.swing.JTextField discountField;
    private javax.swing.JTextField invoiceNumberField;
    private javax.swing.JComboBox itemComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton processButton;
    private javax.swing.JTextField quantityField;
    private javax.swing.JComboBox supplierComboBox;
    private javax.swing.JTable table;
    private javax.swing.JLabel totalAmountLabel;
    private javax.swing.JLabel totalDiscountLabel;
    private javax.swing.JTextField valueField;
    // End of variables declaration//GEN-END:variables
    DefaultTableModel dtm;
    DefaultComboBoxModel<Supplier> supplierComboBoxModel;
    DefaultComboBoxModel<Supplier> itemComboBoxModel;
    SwingWorker<DefaultComboBoxModel, Supplier> supplierComboBoxWorker = new SwingWorker<DefaultComboBoxModel, Supplier>() {
        @Override
        protected DefaultComboBoxModel doInBackground() throws Exception {
            return Combo.getSupplierComboBoxModel();
        }

        @Override
        protected void done() {
            try {
                supplierComboBox.setModel(get());
            } catch (Exception ignore) {
            }
        }
    };
    SwingWorker<DefaultComboBoxModel, Supplier> itemComboBoxWorker = new SwingWorker<DefaultComboBoxModel, Supplier>() {
        @Override
        protected DefaultComboBoxModel doInBackground() throws Exception {
            return Combo.getSupplierComboBoxModel();
        }

        @Override
        protected void done() {
            try {
                supplierComboBox.setModel(get());
            } catch (Exception ignore) {
            }
        }
    };

    protected void onLoad() {
        initComponents();
        datePicker.setFormats(yyyy_MM_dd);
        KeyAdapter();
        dtm = (DefaultTableModel) table.getModel();
        clear();
//        Utilities.attachInitJob(supplierComboBox, new AsyncGUIJob() {
//            @Override
//            public void construct() {
//                supplierComboBoxModel = Combo.getSupplierComboBoxModel();
//            }
//
//            @Override
//            public void finished() {
//                supplierComboBox.setModel(supplierComboBoxModel);
//            }
//        });
    }

    private void clear() {
        dtm.setRowCount(0);
//        Combo.fillSuppliers(supplierComboBox);
        supplierComboBoxWorker.execute();
        clearFields();
    }

    private void fillItems() {
        Supplier supplier = (Supplier) supplierComboBox.getSelectedItem();
        supplier = m.find(Supplier.class, supplier.getCode());
        if (supplier.getCode().equals("000")) {
            LastCode lastCode = m.find(LastCode.class, "SUPPLIERINVOICE");
            if (lastCode == null) {
                lastCode = new LastCode("SUPPLIERINVOICE");
                lastCode.setCode("000");
                m.update(lastCode);
            }
            lastCode = m.find(LastCode.class, "SUPPLIERINVOICE");
            invoiceNumberField.setText(lastCode.getCode());
        }
        itemComboBox.setModel(new DefaultComboBoxModel(supplier.getItemCollection().toArray()));
    }

    private void calcTotal() {
        double totalDiscount = 0;
        double totalAmount = 0;
        for (int i = 0; i < table.getRowCount(); i++) {
            totalDiscount += Double.valueOf(table.getValueAt(i, 6).toString());
            totalAmount += Double.valueOf(table.getValueAt(i, 8).toString());
        }
        totalDiscountLabel.setText(nf2d.format(totalDiscount));
        totalAmountLabel.setText(nf2d.format(totalAmount));
    }

    private void process() {
        int rowCount = table.getRowCount();
        if (rowCount == 0) {
            return;
        }
        String invoiceNumber = invoiceNumberField.getText().trim();
        if (invoiceNumber.equals("")) {
            invoiceNumber = "000";
        }
        Date date = datePicker.getDate();
        if (date == null) {
            datePicker.requestFocus();
            showError("Invoice Date Required");
            return;
        }
        Supplier supplier = (Supplier) supplierComboBox.getSelectedItem();
        PurchaseInvoice purchaseInvoice = m.find(PurchaseInvoice.class, new PurchaseInvoicePK(invoiceNumber, supplier.getCode()));//new PurchaseInvoice(invoiceNumber, supplier.getCode());
        if (purchaseInvoice != null) {
            showError("Invoice Already Updated!");
            return;
        }
        double invoiveAmount = Double.valueOf(totalAmountLabel.getText());
        double invoiceDiscount = Double.valueOf(totalDiscountLabel.getText());
        purchaseInvoice = new PurchaseInvoice(invoiceNumber, supplier.getCode());
        purchaseInvoice.setSupplier(supplier);
        purchaseInvoice.setAmount(invoiveAmount);
        purchaseInvoice.setCredit(invoiveAmount);
        purchaseInvoice.setDiscount(invoiceDiscount);
        purchaseInvoice.setInvDate(date);
        purchaseInvoice.setPurchaseInvoiceHasItemCollection(new ArrayList<PurchaseInvoiceHasItem>());

        List<Serializable> serializables = new ArrayList<Serializable>();
        for (int i = 0; i < rowCount; i++) {
            Item item = m.find(Item.class, table.getValueAt(i, 1).toString());
            double value = Double.valueOf(table.getValueAt(i, 3).toString());
            double quantity = Double.valueOf(table.getValueAt(i, 4).toString());
            double discount = Double.valueOf(table.getValueAt(i, 7).toString());
            double cost = value - (value * discount / 100);
            PurchaseInvoiceHasItem pihi = new PurchaseInvoiceHasItem(invoiceNumber, supplier.getCode(), item.getCode());
            pihi.setPurchaseInvoice(purchaseInvoice);
            pihi.setItem(item);
            pihi.setCost(cost);
            pihi.setQuantity(quantity);
            pihi.setDiscount(discount);
            Stock stock = item.getStock();
            if (stock == null) {
                stock = new Stock(item.getCode());
                stock.setQuantity(0.0);
            }
            quantity = stock.getQuantity() == 0 ? quantity : stock.getQuantity() + quantity;
            stock.setQuantity(quantity);
            item.setStock(stock);
            pihi.setItem(item);
            purchaseInvoice.getPurchaseInvoiceHasItemCollection().add(pihi);
            PriceList priceList = item.getPriceList();
            priceList = priceList == null ? new PriceList(item.getCode()) : priceList;
            priceList.setCostPack(cost);
            serializables.add(priceList);
            serializables.add(item);
            serializables.add(pihi);
            serializables.add(stock);
        }
        if (supplier.getCode().equals("000")) {
            LastCode lastCode = m.find(LastCode.class, "SUPPLIERINVOICE");
            lastCode.setCode(invoiceNumber);
            serializables.add(lastCode);
        }
        serializables.add(purchaseInvoice);
        if (m.update(serializables)) {
            clear();
            showSuccess("Update Success");
        }
    }

    private void clearFields() {
        invoiceNumberField.setText("");
        quantityField.setText("");
        valueField.setText("");
        totalAmountLabel.setText("");
        totalDiscountLabel.setText("");
    }

    private void addToTable() {
        double quantity = 0;
        double value = 0;
        double discount = 0;
        Item item = (Item) itemComboBox.getSelectedItem();
        try {
            quantity = Double.valueOf(quantityField.getText());
            value = Double.valueOf(valueField.getText().trim());
            discount = Double.valueOf(discountField.getText().trim());
        } catch (Exception e) {
        }
        if (quantity == 0) {
            showError("Quantity Required");
            return;
        }
        if (value == 0) {
            showError("No cost value");
            showError("No cost value");
            return;
        }
        double net = value * quantity;
        double discountAmount = net * discount / 100;
        double amount = net - discountAmount;
        int i = dtm.getRowCount();
        Object[] rowData = {++i,
            item.getCode(),
            item.getDescription(),
            nf2d.format(value),
            nf3d.format(quantity),
            nf2d.format(net),
            nf2d.format(discountAmount),
            nf2d.format(discount),
            nf2d.format(amount)};
        dtm.addRow(rowData);
        quantityField.setText("");
        valueField.setText("");
        discountField.setText("");
        itemComboBox.requestFocus();
        calcTotal();
    }

    private void KeyAdapter() {
        AutoCompleteDecorator.decorate(supplierComboBox);
        AutoCompleteDecorator.decorate(itemComboBox);
        setComboBoxKeyAdapters(supplierComboBox);
        setComboBoxKeyAdapters(itemComboBox);
        setComboBoxKeyAdapters(datePicker);
    }

    private void setComboBoxKeyAdapters(JComponent comp) {
        String compName = comp.getName();
        if (compName == null) {
            return;
        }
        Component component[] = comp.getComponents();
        for (int i = 0; i < component.length; i++) {
            if (compName.equals("supplierComboBox")) {
                component[i].addKeyListener(supplierComboBoxKeyAdapter);
            } else if (compName.equals("itemComboBox")) {
                component[i].addKeyListener(itemComboBoxKeyAdapter);
            } else if (compName.equals("datePicker")) {
                component[i].addKeyListener(datePickerKeyAdapter);
            }
        }
    }
    KeyAdapter datePickerKeyAdapter = new java.awt.event.KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent evt) {
            datePickerKeyPressed(evt);
        }
    };
    KeyAdapter supplierComboBoxKeyAdapter = new java.awt.event.KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent evt) {
            supplierComboBoxKeyPressed(evt);
        }
    };
    KeyAdapter itemComboBoxKeyAdapter = new java.awt.event.KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent evt) {
            itemComboBoxKeyPressed(evt);
        }
    };

    private void fillCost() {
        Object o = itemComboBox.getSelectedItem();
        if (o != null && o instanceof Item) {
            Item item = (Item) o;
            PriceList priceList = item.getPriceList();
            double cost = 0.0;
            if (priceList != null && priceList.getCostPack() != null) {
                cost = priceList.getCostPack();
            }
            valueField.setText(cost + "");
        }
    }

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
        Combo.fillSuppliers(supplierComboBox);
    }

    private void dozPriceToItemPrice() {
        String dozPriceText = JOptionPane.showInputDialog(this, "DOZ Price");
        try {
            double dozPrice = Double.parseDouble(dozPriceText);
            valueField.setText((nf2d.format(dozPrice / 12)) + "");
        } catch (Exception e) {
        }
    }

    private void dozToItem() {
        String dozText = JOptionPane.showInputDialog(this, "DOZ Count");
        try {
            double doz = Double.parseDouble(dozText);
            quantityField.setText((nf2d.format(doz * 12)) + "");
        } catch (Exception e) {
        }
    }

    @Override
    public void componentOpened() {
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
