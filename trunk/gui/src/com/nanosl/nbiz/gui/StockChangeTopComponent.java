/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.gui;

import com.nanosl.nbiz.utility.NTopComponent;
import entity.Item;
import entity.Stock;
import entity.StockChange;
import entity.StockChangeSummery;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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
        dtd = "-//com.nanosl.nbiz.gui//StockChange//EN",
        autostore = false)
@TopComponent.Description(
        preferredID = "StockChangeTopComponent",
        //iconBase="SET/PATH/TO/ICON/HERE", 
        persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@ActionID(category = "Window", id = "com.nanosl.nbiz.gui.StockChangeTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_StockChangeAction",
        preferredID = "StockChangeTopComponent")
@Messages({
    "CTL_StockChangeAction=StockChange",
    "CTL_StockChangeTopComponent=StockChange Window",
    "HINT_StockChangeTopComponent=This is a StockChange window"
})
public final class StockChangeTopComponent extends NTopComponent {

    public StockChangeTopComponent() {
        onLoad();
        setName(Bundle.CTL_StockChangeTopComponent());
        setToolTipText(Bundle.HINT_StockChangeTopComponent());

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
        jLabel1 = new javax.swing.JLabel();
        itemComboBox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        actualQuantityTextField = new javax.swing.JTextField();
        processButton = new javax.swing.JButton();
        datePicker1 = new org.jdesktop.swingx.JXDatePicker();
        jLabel3 = new javax.swing.JLabel();
        totalLabel = new javax.swing.JLabel();
        resetButton = new javax.swing.JButton();

        masterTable.setAutoCreateRowSorter(true);
        masterTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Code", "Description", "Old Quantity", "Actual Quantity", "Deferent", "Rate", "Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
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

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(StockChangeTopComponent.class, "StockChangeTopComponent.jLabel1.text")); // NOI18N

        itemComboBox.setName("itemComboBox"); // NOI18N
        itemComboBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                itemComboBoxKeyPressed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(StockChangeTopComponent.class, "StockChangeTopComponent.jLabel2.text")); // NOI18N

        actualQuantityTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualQuantityTextFieldActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(processButton, org.openide.util.NbBundle.getMessage(StockChangeTopComponent.class, "StockChangeTopComponent.processButton.text")); // NOI18N
        processButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processButtonActionPerformed(evt);
            }
        });

        datePicker1.setName("datePicker1"); // NOI18N
        datePicker1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                datePicker1KeyPressed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(StockChangeTopComponent.class, "StockChangeTopComponent.jLabel3.text")); // NOI18N

        totalLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        totalLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        org.openide.awt.Mnemonics.setLocalizedText(totalLabel, org.openide.util.NbBundle.getMessage(StockChangeTopComponent.class, "StockChangeTopComponent.totalLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(resetButton, org.openide.util.NbBundle.getMessage(StockChangeTopComponent.class, "StockChangeTopComponent.resetButton.text")); // NOI18N
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
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
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(itemComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(actualQuantityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(datePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(processButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(resetButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(totalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(masterScrollPane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(itemComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(actualQuantityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(processButton)
                    .addComponent(datePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(resetButton)
                    .addComponent(totalLabel))
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

    private void masterTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masterTableMouseClicked
    }//GEN-LAST:event_masterTableMouseClicked

    private void masterTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masterTableMouseReleased
    }//GEN-LAST:event_masterTableMouseReleased

    private void masterTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_masterTableKeyReleased
    }//GEN-LAST:event_masterTableKeyReleased

    private void itemComboBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itemComboBoxKeyPressed
        if (evt.getKeyCode() == 10) {
            actualQuantityTextField.requestFocus();
        }
    }//GEN-LAST:event_itemComboBoxKeyPressed

    private void actualQuantityTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualQuantityTextFieldActionPerformed
        editTable();
        itemComboBox.requestFocus();
    }//GEN-LAST:event_actualQuantityTextFieldActionPerformed

    private void processButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processButtonActionPerformed
        process();
    }//GEN-LAST:event_processButtonActionPerformed

    private void datePicker1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_datePicker1KeyPressed
        if (evt.getKeyCode() == 10) {
            processButton.requestFocus();
        }
    }//GEN-LAST:event_datePicker1KeyPressed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        reset();
    }//GEN-LAST:event_resetButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField actualQuantityTextField;
    private org.jdesktop.swingx.JXDatePicker datePicker1;
    private javax.swing.JComboBox itemComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane masterScrollPane;
    private javax.swing.JTable masterTable;
    private javax.swing.JButton processButton;
    private javax.swing.JButton resetButton;
    private javax.swing.JLabel totalLabel;
    // End of variables declaration//GEN-END:variables

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

    private void reset() {
        fillTable();
        fillItems();
        calcTotal();
    }

    private void fillItems() {
        itemComboBox.setModel(new DefaultComboBoxModel(manager.find(Item.class).toArray()));
    }

    private void editTable() {
        double actualQuantity = 0;

        try {
            actualQuantity = Double.valueOf(actualQuantityTextField.getText().trim());
        } catch (NumberFormatException numberFormatException) {
            showError("Invalid number!");
//            setStatusMessage("Invalid number!", Color.RED);
            return;
        }

        Item item = (Item) itemComboBox.getSelectedItem();
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            if (masterTable.getValueAt(i, 1).equals(item.getCode())) {
                double oldQuantity = Double.valueOf(masterTable.getValueAt(i, 3).toString());
                masterTable.setValueAt(actualQuantity, i, 4);
                double deferent = oldQuantity - actualQuantity;
                masterTable.setValueAt(deferent, i, 5);
                double rate = Double.valueOf(masterTable.getValueAt(i, 6).toString());
                masterTable.setValueAt(deferent * rate, i, 7);
                calcTotal();
                actualQuantityTextField.setText("");
                itemComboBox.requestFocus();
                return;
            }
        }
    }

    private void calcTotal() {
        double total = 0;
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            total += Double.valueOf(tableModel.getValueAt(i, 7).toString());
        }
        totalLabel.setText(total + "");
    }

    private void process() {
        Date date = datePicker1.getDate();
        if (date == null) {
            showError("Select date");
//            setStatusMessage("Select date", Color.RED);
            return;
        }
        List<Serializable> serializables = new ArrayList<Serializable>();
        StockChangeSummery stockChangeSummery = new StockChangeSummery(date);
        stockChangeSummery.setDeferent(Double.valueOf(totalLabel.getText().trim()));
        serializables.add(stockChangeSummery);
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            Item item = manager.find(Item.class, masterTable.getValueAt(i, 1));
            Stock stock = item.getStock();
            double oldQuantity = stock.getQuantity();
            double actualQuantity = Double.valueOf(masterTable.getValueAt(i, 4).toString());
            double rate = Double.valueOf(masterTable.getValueAt(i, 6).toString());
            stock.setQuantity(actualQuantity);
            serializables.add(stock);

            StockChange stockChange = new StockChange(item.getCode(), date);
            stockChange.setActualQuantity(actualQuantity);
            stockChange.setItem(item);
            stockChange.setOldQuantity(oldQuantity);
            stockChange.setRate(rate);
            stockChange.setStockChangeSummery(stockChangeSummery);
            serializables.add(stockChange);
        }
        if (manager.update(serializables)) {
            showSuccess("Update success");
//            setStatusMessage("Update success");
            reset();
        }
    }

    private void KeyAdapter() {
        AutoCompleteDecorator.decorate(itemComboBox);
        setComboBoxKeyAdapters(itemComboBox);
        setComboBoxKeyAdapters(datePicker1);

    }

    private void setComboBoxKeyAdapters(JComponent comp) {
        String compName = comp.getName();
        Component component[] = comp.getComponents();
        for (int i = 0; i < component.length; i++) {
            if (compName.equals("itemComboBox")) {
                component[i].addKeyListener(itemComboBoxKeyAdapter);
            } else if (compName.equals("datePicker1")) {
                component[i].addKeyListener(datePicker1KeyAdapter);
            }
        }
    }
    KeyAdapter itemComboBoxKeyAdapter = new java.awt.event.KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent evt) {
            itemComboBoxKeyPressed(evt);
        }
    };
    private KeyListener datePicker1KeyAdapter = new java.awt.event.KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent evt) {
            datePicker1KeyPressed(evt);
        }
    };
    DefaultTableModel tableModel;

    private void fillTable() {
        tableModel.setRowCount(0);
        int i = tableModel.getRowCount();
        for (Iterator<Stock> it = manager.find(Stock.class).iterator(); it.hasNext();) {
            Stock stock = it.next();
            Item item = stock.getItem();
            double quantity = stock.getQuantity() == null ? 0 : stock.getQuantity();
            double cost = item.getPriceList() == null ? 0 : item.getPriceList().getCostPack();
            Object[] row = {++i, item.getCode(), item.getDescription(), quantity, quantity, 0, cost, 0};
            tableModel.addRow(row);
        }
    }

    protected void onLoad() {
        initComponents();
        tableModel = (DefaultTableModel) masterTable.getModel();
        KeyAdapter();
        reset();
    }
}
