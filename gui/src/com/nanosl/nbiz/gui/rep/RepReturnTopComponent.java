/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.gui.rep;

import com.nanosl.lib.date.JXDatePicker;
import com.nanosl.nbiz.utility.NTopComponent;
import entity.DamageNotes;
import entity.DamageStock;
import entity.Employee;
import entity.Item;
import entity.SrStock;
import entity.SrStockPK;
import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.windows.TopComponent;
import org.openide.util.NbBundle.Messages;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
        dtd = "-//com.nanosl.nbiz.gui.rep//RepReturn//EN",
        autostore = false)
@TopComponent.Description(
        preferredID = "RepReturnTopComponent",
        //iconBase="SET/PATH/TO/ICON/HERE", 
        persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@ActionID(category = "Window", id = "com.nanosl.nbiz.gui.rep.RepReturnTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_RepReturnAction",
        preferredID = "RepReturnTopComponent")
@Messages({
    "CTL_RepReturnAction=RepReturn",
    "CTL_RepReturnTopComponent=RepReturn Window",
    "HINT_RepReturnTopComponent=This is a RepReturn window"
})
public final class RepReturnTopComponent extends NTopComponent {

    public RepReturnTopComponent() {
        initComponents();
        setName(Bundle.CTL_RepReturnTopComponent());
        setToolTipText(Bundle.HINT_RepReturnTopComponent());

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
        repComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        itemComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        returnTextField = new javax.swing.JTextField();
        totalTextField = new javax.swing.JTextField();
        processButton = new javax.swing.JButton();
        datePicker = new JXDatePicker();
        jLabel4 = new javax.swing.JLabel();

        masterTable.setAutoCreateRowSorter(true);
        masterTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Code", "Description", "Return", "Rate", "Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
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

        repComboBox.setName("repComboBox"); // NOI18N
        repComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repComboBoxActionPerformed(evt);
            }
        });
        repComboBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                repComboBoxKeyPressed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(RepReturnTopComponent.class, "RepReturnTopComponent.jLabel1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(RepReturnTopComponent.class, "RepReturnTopComponent.jLabel2.text")); // NOI18N

        itemComboBox.setName("itemComboBox"); // NOI18N
        itemComboBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                itemComboBoxKeyPressed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(RepReturnTopComponent.class, "RepReturnTopComponent.jLabel3.text")); // NOI18N

        returnTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnTextFieldActionPerformed(evt);
            }
        });

        totalTextField.setEditable(false);
        totalTextField.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        totalTextField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        totalTextField.setText(org.openide.util.NbBundle.getMessage(RepReturnTopComponent.class, "RepReturnTopComponent.totalTextField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(processButton, org.openide.util.NbBundle.getMessage(RepReturnTopComponent.class, "RepReturnTopComponent.processButton.text")); // NOI18N
        processButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processButtonActionPerformed(evt);
            }
        });

        datePicker.setName("datePicker"); // NOI18N
        datePicker.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                datePickerKeyPressed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(RepReturnTopComponent.class, "RepReturnTopComponent.jLabel4.text")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(repComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(itemComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(returnTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(datePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(processButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(totalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(masterScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 797, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(repComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(itemComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(returnTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(masterScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(processButton)
                    .addComponent(datePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void masterTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masterTableMouseClicked
    }//GEN-LAST:event_masterTableMouseClicked

    private void masterTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masterTableMouseReleased
    }//GEN-LAST:event_masterTableMouseReleased

    private void masterTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_masterTableKeyReleased
    }//GEN-LAST:event_masterTableKeyReleased

    private void repComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repComboBoxActionPerformed
        //        fillTable();
    }//GEN-LAST:event_repComboBoxActionPerformed

    private void repComboBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_repComboBoxKeyPressed
        if (evt.getKeyCode() == 10) {
            itemComboBox.requestFocus();
        }
    }//GEN-LAST:event_repComboBoxKeyPressed

    private void itemComboBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itemComboBoxKeyPressed
        if (evt.getKeyCode() == 10) {
            returnTextField.requestFocus();
        }
    }//GEN-LAST:event_itemComboBoxKeyPressed

    private void returnTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnTextFieldActionPerformed
        fillTable();
    }//GEN-LAST:event_returnTextFieldActionPerformed

    private void processButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processButtonActionPerformed
        process();
    }//GEN-LAST:event_processButtonActionPerformed

    private void datePickerKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_datePickerKeyPressed
        if (evt.getKeyCode() == 10) {
            processButton.requestFocus();
        }
    }//GEN-LAST:event_datePickerKeyPressed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXDatePicker datePicker;
    private javax.swing.JComboBox itemComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane masterScrollPane;
    private javax.swing.JTable masterTable;
    private javax.swing.JButton processButton;
    private javax.swing.JComboBox repComboBox;
    private javax.swing.JTextField returnTextField;
    private javax.swing.JTextField totalTextField;
    // End of variables declaration//GEN-END:variables
    DefaultTableModel tableModel;

    private void fillTable() {
        Employee employee = (Employee) repComboBox.getSelectedItem();
        Item item = (Item) itemComboBox.getSelectedItem();
        int i = tableModel.getRowCount();
        SrStock srStock = m.find(SrStock.class, new SrStockPK(employee.getCode(), item.getCode()));
        double returnQuantity = Double.parseDouble(returnTextField.getText().trim());
        double price = item.getPriceList().getSellingPack() == null ? 0.0 : item.getPriceList().getSellingPack();
        if (srStock != null) {
            if (srStock.getPackPrice() == null) {
                srStock.setPackPrice(price);
                m.update(srStock);
            }
            price = srStock.getPackPrice();
        }
        double amount = returnQuantity * price;
        Object[] row = {++i, item.getCode(), item.getDescription(), returnQuantity, price, nf2d.format(amount)};
        tableModel.addRow(row);
        fillItems();
        calcTotal();
    }

    protected void onLoad() {
        initComponents();
        tableModel = (DefaultTableModel) masterTable.getModel();
        KeyAdapter();
    }

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
        fillRep();
    }

    private void fillRep() {
        tableModel.setRowCount(0);
        repComboBox.setModel(new DefaultComboBoxModel(m.find(Employee.class).toArray()));
        fillItems();
    }

    private void fillItems() {
        itemComboBox.setModel(new DefaultComboBoxModel(m.find(Item.class).toArray()));
    }

    private void calcTotal() {
        double total = 0;
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            total += Double.valueOf(tableModel.getValueAt(i, 5).toString());
        }
        totalTextField.setText(nf2d.format(total));
    }

    private void process() {
        Date date = datePicker.getDate();
        Employee employee = (Employee) repComboBox.getSelectedItem();
        if (tableModel.getRowCount() == 0 || date == null) {
            return;
        }
        List<Serializable> serializables = new ArrayList<Serializable>();
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            Item item = m.find(Item.class, tableModel.getValueAt(i, 1).toString());
            double returnQuantity = Double.parseDouble(tableModel.getValueAt(i, 3).toString());
            SrStock srStock = m.find(SrStock.class, new SrStockPK(employee.getCode(), item.getCode()));
            DamageStock damageStock = item.getDamageStock();
            if (damageStock == null) {
                damageStock = new DamageStock(item.getCode());
                damageStock.setItem(item);
                damageStock.setQuantity(0.0);
            }
            damageStock.setQuantity(damageStock.getQuantity() + returnQuantity);
            serializables.add(damageStock);
            if (srStock != null && srStock.getQuantity() >= returnQuantity) {
                srStock.setQuantity(srStock.getQuantity() - returnQuantity);
                serializables.add(srStock);
            }
            DamageNotes damageNotes = new DamageNotes(date, item.getCode(), employee.getCode());
            damageNotes.setEmployee(employee);
            damageNotes.setItem(item);
            damageNotes.setQuantity(returnQuantity);
            damageNotes.setRate(srStock.getPackPrice());
            damageNotes.setReason(employee.getCode() + " " + employee.getFirstName());
            serializables.add(damageNotes);
        }
        if (m.update(serializables)) {
            showSuccess("Update success");
            fillRep();
            fillItems();
            calcTotal();
            returnTextField.setText("");
            return;
        }
        showError("Update Failed");
    }

    private void KeyAdapter() {

        AutoCompleteDecorator.decorate(itemComboBox);
        AutoCompleteDecorator.decorate(repComboBox);
        setComboBoxKeyAdapters(itemComboBox);
        setComboBoxKeyAdapters(repComboBox);
        setComboBoxKeyAdapters(datePicker);
    }

    private void setComboBoxKeyAdapters(JComponent comp) {
        String compName = comp.getName();
        Component component[] = comp.getComponents();
        for (int i = 0; i < component.length; i++) {
            if (compName.equals("repComboBox")) {
                component[i].addKeyListener(repComboBoxKeyAdapter);
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
    KeyAdapter itemComboBoxKeyAdapter = new java.awt.event.KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent evt) {
            itemComboBoxKeyPressed(evt);
        }
    };
    KeyAdapter repComboBoxKeyAdapter = new java.awt.event.KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent evt) {
            repComboBoxKeyPressed(evt);
        }
    };

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
