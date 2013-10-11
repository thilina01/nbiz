/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.gui;

import com.nanosl.lib.date.JXDatePicker;
import com.nanosl.nbiz.util.NTopComponent;
import entity.Employee;
import entity.Item;
import entity.PriceList;
import entity.SrStock;
import entity.SrStockPK;
import entity.Stock;
import entity.StockTransfer;
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
        dtd = "-//com.nanosl.nbiz.gui//StockTransfer//EN",
        autostore = false)
@TopComponent.Description(
        preferredID = "StockTransferTopComponent",
        //iconBase="SET/PATH/TO/ICON/HERE", 
        persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@ActionID(category = "Window", id = "com.nanosl.nbiz.gui.StockTransferTopComponent")
@ActionReference(path = "Menu/Distribution" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_StockTransferAction",
        preferredID = "StockTransferTopComponent")
@Messages({
    "CTL_StockTransferAction=StockTransfer",
    "CTL_StockTransferTopComponent=StockTransfer Window",
    "HINT_StockTransferTopComponent=This is a StockTransfer window"
})
public final class StockTransferTopComponent extends NTopComponent {

    public StockTransferTopComponent() {
        onLoad();
        setName(Bundle.CTL_StockTransferTopComponent());
        setToolTipText(Bundle.HINT_StockTransferTopComponent());

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
        table = new javax.swing.JTable();
        repComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        transferButton = new javax.swing.JButton();
        datePicker = new JXDatePicker();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        itemComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        quantityTextField = new javax.swing.JTextField();
        clearButton = new javax.swing.JButton();
        quantityLabel = new javax.swing.JLabel();

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        table.setAutoCreateRowSorter(true);
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Code", "Description", "Quantity", "Rate"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tableKeyReleased(evt);
            }
        });
        masterScrollPane.setViewportView(table);
        table.getColumnModel().getColumn(0).setHeaderValue(org.openide.util.NbBundle.getMessage(StockTransferTopComponent.class, "StockTransferTopComponent.table.columnModel.title0")); // NOI18N
        table.getColumnModel().getColumn(1).setHeaderValue(org.openide.util.NbBundle.getMessage(StockTransferTopComponent.class, "StockTransferTopComponent.table.columnModel.title1")); // NOI18N
        table.getColumnModel().getColumn(2).setHeaderValue(org.openide.util.NbBundle.getMessage(StockTransferTopComponent.class, "StockTransferTopComponent.table.columnModel.title2")); // NOI18N
        table.getColumnModel().getColumn(3).setHeaderValue(org.openide.util.NbBundle.getMessage(StockTransferTopComponent.class, "StockTransferTopComponent.table.columnModel.title3")); // NOI18N
        table.getColumnModel().getColumn(3).setCellRenderer(rightAlignCell);
        table.getColumnModel().getColumn(4).setHeaderValue(org.openide.util.NbBundle.getMessage(StockTransferTopComponent.class, "StockTransferTopComponent.table.columnModel.title4")); // NOI18N
        table.getColumnModel().getColumn(4).setCellRenderer(rightAlignCell);

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

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(StockTransferTopComponent.class, "StockTransferTopComponent.jLabel1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(transferButton, org.openide.util.NbBundle.getMessage(StockTransferTopComponent.class, "StockTransferTopComponent.transferButton.text")); // NOI18N
        transferButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transferButtonActionPerformed(evt);
            }
        });

        datePicker.setName("datePicker"); // NOI18N
        datePicker.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                datePickerKeyPressed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(StockTransferTopComponent.class, "StockTransferTopComponent.jLabel2.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(StockTransferTopComponent.class, "StockTransferTopComponent.jLabel3.text")); // NOI18N

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
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(StockTransferTopComponent.class, "StockTransferTopComponent.jLabel4.text")); // NOI18N

        quantityTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityTextFieldActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(clearButton, org.openide.util.NbBundle.getMessage(StockTransferTopComponent.class, "StockTransferTopComponent.clearButton.text")); // NOI18N
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(quantityLabel, org.openide.util.NbBundle.getMessage(StockTransferTopComponent.class, "StockTransferTopComponent.quantityLabel.text")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(repComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(10, 10, 10)
                                .addComponent(itemComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(quantityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(quantityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(datePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(transferButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(masterScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 8, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(repComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(datePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(quantityTextField)
                            .addComponent(quantityLabel)
                            .addComponent(itemComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)))
                .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clearButton)
                    .addComponent(transferButton))
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

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
    }//GEN-LAST:event_tableMouseClicked

    private void tableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseReleased
    }//GEN-LAST:event_tableMouseReleased

    private void tableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableKeyReleased
        if (evt.getKeyCode() == 127) {
            tableModel.removeRow(table.getSelectedRow());
        }
    }//GEN-LAST:event_tableKeyReleased

    private void repComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repComboBoxActionPerformed

    }//GEN-LAST:event_repComboBoxActionPerformed

    private void repComboBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_repComboBoxKeyPressed
        if (evt.getKeyCode() == 10) {
            datePicker.requestFocus();
        }
    }//GEN-LAST:event_repComboBoxKeyPressed

    private void transferButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transferButtonActionPerformed
        if (tableModel.getRowCount() > 0) {
            transfer();
        }
    }//GEN-LAST:event_transferButtonActionPerformed

    private void datePickerKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_datePickerKeyPressed
        if (evt.getKeyCode() == 10) {
            itemComboBox.requestFocus();
        }
    }//GEN-LAST:event_datePickerKeyPressed

    private void itemComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemComboBoxActionPerformed
        quantityLabel.setText("0");
        Item item = (Item) itemComboBox.getSelectedItem();
        Stock stock = item.getStock();
        if (stock == null) {
            stock = new Stock(item.getCode());
            stock.setBundles(0.0);
            stock.setItem(item);
            stock.setQuantity(0.0);
            item.setStock(stock);
            m.update(stock);
            m.update(item);
        }
        quantityLabel.setText(nf3d.format(stock.getQuantity()));
    }//GEN-LAST:event_itemComboBoxActionPerformed

    private void itemComboBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itemComboBoxKeyPressed
        if (evt.getKeyCode() == 10 && !quantityLabel.getText().equals("0")) {
            quantityTextField.requestFocus();
        }
    }//GEN-LAST:event_itemComboBoxKeyPressed

    private void quantityTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityTextFieldActionPerformed
        fillTable();
    }//GEN-LAST:event_quantityTextFieldActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        clear();
    }//GEN-LAST:event_clearButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearButton;
    private org.jdesktop.swingx.JXDatePicker datePicker;
    private javax.swing.JComboBox itemComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane masterScrollPane;
    private javax.swing.JLabel quantityLabel;
    private javax.swing.JTextField quantityTextField;
    private javax.swing.JComboBox repComboBox;
    private javax.swing.JTable table;
    private javax.swing.JButton transferButton;
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

    private void fillItems() {
        itemComboBox.setModel(new DefaultComboBoxModel(m.find(Item.class).toArray()));
    }

    private void fillReps() {
        repComboBox.setModel(new DefaultComboBoxModel(m.find(Employee.class).toArray()));
    }

    private void clear() {
        fillItems();
        fillReps();
        tableModel.setRowCount(0);
        quantityLabel.setText("0");
    }

    private void transfer() {
        Date date = datePicker.getDate();
        if (date == null) {
            showError("Date Required");
//            setStatusMessage("Date Required", Color.RED);
            return;
        }
        List<Serializable> serializables = new ArrayList<Serializable>();
        Employee rep = (Employee) repComboBox.getSelectedItem();
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            Item item = m.find(Item.class, tableModel.getValueAt(i, 1).toString());
            Stock stock = item.getStock();
            double quantity = Double.valueOf(tableModel.getValueAt(i, 3).toString());
            double rate = Double.valueOf(tableModel.getValueAt(i, 4).toString());
            stock.setQuantity(stock.getQuantity() - quantity);
            StockTransfer stockTransfer = new StockTransfer(rep.getCode(), item.getCode(), date);
            stockTransfer.setQuantity(quantity);
            stockTransfer.setEmployee(rep);
            stockTransfer.setItem(item);
            stockTransfer.setRate(rate);
            PriceList priceList = item.getPriceList();
            if (priceList == null) {
                priceList = new PriceList(item.getCode());
                priceList.setCostPack(0.0);
                priceList.setCostUnit(0.0);
                priceList.setItem(item);
                priceList.setSellingPack(0.0);
                priceList.setSellingUnit(0.0);
                serializables.add(priceList);
            }
            SrStockPK srStockPK = new SrStockPK(rep.getCode(), item.getCode());
            SrStock srStock = m.find(SrStock.class, srStockPK);
            if (srStock == null) {
                srStock = new SrStock(srStockPK);
                srStock.setItem(item);
                srStock.setEmployee(rep);
                srStock.setQuantity(quantity);
                srStock.setPackPrice(priceList.getSellingPack());
                srStock.setUnitPrice(priceList.getSellingUnit());
            } else {
                srStock.setQuantity(srStock.getQuantity() + quantity);
            }
            serializables.add(stock);
            serializables.add(stockTransfer);
            serializables.add(srStock);
        }
        if (m.update(serializables)) {
            showSuccess("Update Success");
//            setStatusMessage("Update Success");
            clear();
            return;
        }
        showError("Update Failed");
    }

    private void setQuantity() {
        quantityLabel.setText("0");
        Item item = (Item) itemComboBox.getSelectedItem();
        Stock stock = item.getStock();
        if (stock == null) {
            stock = new Stock(item.getCode());
            stock.setBundles(0.0);
            stock.setItem(item);
            stock.setQuantity(0.0);
            item.setStock(stock);
            m.update(stock);
            m.update(item);
        }
        quantityLabel.setText(nf3d.format(stock.getQuantity()));
    }
    DefaultTableModel tableModel;

    private void fillTable() {
        Item item = (Item) itemComboBox.getSelectedItem();
        if (item == null) {
            return;
        }
        String itemCode = item.getCode();
        double quantity = 0;
        for (int i = 0; i < table.getRowCount(); i++) {
            String code = table.getValueAt(i, 1).toString();
            if (code.equals(itemCode)) {
                showError("Item already added");
                return;
            }
        }
        try {
            quantity = Double.valueOf(quantityTextField.getText().trim());
            double availablaQuantity = Double.valueOf(quantityLabel.getText().trim());
            if (quantity > availablaQuantity) {
                showError("Quantity Not Enough");
//                setStatusMessage("Quantity Not Enough", Color.RED);
                return;
            }
        } catch (Exception e) {
            showError("Invalid Quantity Value");
//            setStatusMessage("Invalid Quantity Value", Color.RED);
            return;
        }
        Employee rep = (Employee) repComboBox.getSelectedItem();
        SrStockPK srStockPK = new SrStockPK(rep.getCode(), item.getCode());
        SrStock srStock = m.find(SrStock.class, srStockPK);
        if (srStock == null) {
            srStock = new SrStock(srStockPK);
            srStock.setBundles(0.0);
            srStock.setEmployee(rep);
            srStock.setItem(item);
            srStock.setPackPrice(item.getPriceList().getSellingPack());
            srStock.setQuantity(0.0);
            srStock.setUnitPrice(item.getPriceList().getSellingUnit());
            m.update(srStock);
            srStock = m.find(SrStock.class, srStockPK);
        }
        int i = tableModel.getRowCount();
        double rate = srStock.getPackPrice() == null ? 0.0 : srStock.getPackPrice();
        Object[] row = {++i, itemCode, item.getDescription(), nf3d.format(quantity), nf2d.format(rate)};
        tableModel.addRow(row);

        quantityTextField.setText("");
        itemComboBox.requestFocus();
    }

    protected void onLoad() {
        initComponents();
        tableModel = (DefaultTableModel) table.getModel();
        KeyAdapter();
        clear();
    }

    private void KeyAdapter() {
        AutoCompleteDecorator.decorate(repComboBox);
        AutoCompleteDecorator.decorate(itemComboBox);
        setComboBoxKeyAdapters(repComboBox);
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
}
