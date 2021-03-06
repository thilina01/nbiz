/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.gui;

import com.nanosl.nbiz.util.Combo;
import com.nanosl.nbiz.util.Data;
import com.nanosl.nbiz.util.Export;
import static com.nanosl.nbiz.util.Format.nf2d;
import query.Find;
import com.nanosl.nbiz.util.NTopComponent;
import entity.Item;
import entity.ItemType;
import entity.PriceList;
import entity.Stock;
import entity.Supplier;
import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.netbeans.api.progress.ProgressHandle;
import org.netbeans.api.progress.ProgressHandleFactory;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.util.Exceptions;
import org.openide.windows.TopComponent;
import org.openide.util.NbBundle.Messages;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
        dtd = "-//com.nanosl.nbiz.gui//Stock//EN",
        autostore = false)
@TopComponent.Description(
        preferredID = "StockTopComponent",
        //iconBase="SET/PATH/TO/ICON/HERE", 
        persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@ActionID(category = "Window", id = "com.nanosl.nbiz.gui.StockTopComponent")
@ActionReference(path = "Menu/Main" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_StockAction",
        preferredID = "StockTopComponent")
@Messages({
    "CTL_StockAction=Stock",
    "CTL_StockTopComponent=Stock Window",
    "HINT_StockTopComponent=This is a Stock window"
})
public final class StockTopComponent extends NTopComponent {

    public StockTopComponent() {
        onLoad();
        setName(Bundle.CTL_StockTopComponent());
        setToolTipText(Bundle.HINT_StockTopComponent());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        masterScrollPane = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        reloadButton = new javax.swing.JButton();
        totalLabel = new javax.swing.JLabel();
        allRadioButton = new javax.swing.JRadioButton();
        minimumRadioButton = new javax.swing.JRadioButton();
        printButton = new javax.swing.JButton();
        typeCheckBox = new javax.swing.JCheckBox();
        itemTypeComboBox = new javax.swing.JComboBox();
        supplierCheckBox = new javax.swing.JCheckBox();
        supplierComboBox = new javax.swing.JComboBox();
        selectedRadioButton = new javax.swing.JRadioButton();
        countTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        minusRadioButton = new javax.swing.JRadioButton();
        exportButton = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        table.setAutoCreateRowSorter(true);
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Code", "Description", "Type", "Brand", "Quantity", "Cost", "Total Cost", "Selling", "Total Selling", "Profit"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
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
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setPreferredWidth(30);
            table.getColumnModel().getColumn(0).setHeaderValue(org.openide.util.NbBundle.getMessage(StockTopComponent.class, "StockTopComponent.table.columnModel.title0")); // NOI18N
            table.getColumnModel().getColumn(1).setHeaderValue(org.openide.util.NbBundle.getMessage(StockTopComponent.class, "StockTopComponent.table.columnModel.title1")); // NOI18N
            table.getColumnModel().getColumn(2).setPreferredWidth(300);
            table.getColumnModel().getColumn(2).setHeaderValue(org.openide.util.NbBundle.getMessage(StockTopComponent.class, "StockTopComponent.table.columnModel.title2")); // NOI18N
            table.getColumnModel().getColumn(3).setPreferredWidth(150);
            table.getColumnModel().getColumn(3).setHeaderValue(org.openide.util.NbBundle.getMessage(StockTopComponent.class, "StockTopComponent.table.columnModel.title9")); // NOI18N
            table.getColumnModel().getColumn(4).setHeaderValue(org.openide.util.NbBundle.getMessage(StockTopComponent.class, "StockTopComponent.table.columnModel.title10")); // NOI18N
            table.getColumnModel().getColumn(5).setHeaderValue(org.openide.util.NbBundle.getMessage(StockTopComponent.class, "StockTopComponent.table.columnModel.title3")); // NOI18N
            table.getColumnModel().getColumn(5).setCellRenderer(rightAlignCell);
            table.getColumnModel().getColumn(6).setHeaderValue(org.openide.util.NbBundle.getMessage(StockTopComponent.class, "StockTopComponent.table.columnModel.title4")); // NOI18N
            table.getColumnModel().getColumn(6).setCellRenderer(rightAlignCell);
            table.getColumnModel().getColumn(7).setHeaderValue(org.openide.util.NbBundle.getMessage(StockTopComponent.class, "StockTopComponent.table.columnModel.title5")); // NOI18N
            table.getColumnModel().getColumn(7).setCellRenderer(rightAlignCell);
            table.getColumnModel().getColumn(8).setHeaderValue(org.openide.util.NbBundle.getMessage(StockTopComponent.class, "StockTopComponent.table.columnModel.title6")); // NOI18N
            table.getColumnModel().getColumn(8).setCellRenderer(rightAlignCell);
            table.getColumnModel().getColumn(9).setHeaderValue(org.openide.util.NbBundle.getMessage(StockTopComponent.class, "StockTopComponent.table.columnModel.title7")); // NOI18N
            table.getColumnModel().getColumn(9).setCellRenderer(rightAlignCell);
            table.getColumnModel().getColumn(10).setHeaderValue(org.openide.util.NbBundle.getMessage(StockTopComponent.class, "StockTopComponent.table.columnModel.title8")); // NOI18N
            table.getColumnModel().getColumn(10).setCellRenderer(rightAlignCell);
        }

        org.openide.awt.Mnemonics.setLocalizedText(reloadButton, org.openide.util.NbBundle.getMessage(StockTopComponent.class, "StockTopComponent.reloadButton.text")); // NOI18N
        reloadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reloadButtonActionPerformed(evt);
            }
        });

        totalLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(totalLabel, org.openide.util.NbBundle.getMessage(StockTopComponent.class, "StockTopComponent.totalLabel.text")); // NOI18N

        buttonGroup1.add(allRadioButton);
        org.openide.awt.Mnemonics.setLocalizedText(allRadioButton, org.openide.util.NbBundle.getMessage(StockTopComponent.class, "StockTopComponent.allRadioButton.text")); // NOI18N
        allRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(minimumRadioButton);
        org.openide.awt.Mnemonics.setLocalizedText(minimumRadioButton, org.openide.util.NbBundle.getMessage(StockTopComponent.class, "StockTopComponent.minimumRadioButton.text")); // NOI18N
        minimumRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minimumRadioButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(printButton, org.openide.util.NbBundle.getMessage(StockTopComponent.class, "StockTopComponent.printButton.text")); // NOI18N
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(typeCheckBox, org.openide.util.NbBundle.getMessage(StockTopComponent.class, "StockTopComponent.typeCheckBox.text")); // NOI18N
        typeCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeCheckBoxActionPerformed(evt);
            }
        });

        itemTypeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemTypeComboBoxActionPerformed(evt);
            }
        });
        itemTypeComboBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                itemTypeComboBoxKeyPressed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(supplierCheckBox, org.openide.util.NbBundle.getMessage(StockTopComponent.class, "StockTopComponent.supplierCheckBox.text")); // NOI18N
        supplierCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplierCheckBoxActionPerformed(evt);
            }
        });

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

        buttonGroup1.add(selectedRadioButton);
        org.openide.awt.Mnemonics.setLocalizedText(selectedRadioButton, org.openide.util.NbBundle.getMessage(StockTopComponent.class, "StockTopComponent.selectedRadioButton.text")); // NOI18N

        countTextField.setText(org.openide.util.NbBundle.getMessage(StockTopComponent.class, "StockTopComponent.countTextField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(StockTopComponent.class, "StockTopComponent.jLabel1.text")); // NOI18N

        buttonGroup1.add(minusRadioButton);
        org.openide.awt.Mnemonics.setLocalizedText(minusRadioButton, org.openide.util.NbBundle.getMessage(StockTopComponent.class, "StockTopComponent.minusRadioButton.text")); // NOI18N
        minusRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minusRadioButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(exportButton, org.openide.util.NbBundle.getMessage(StockTopComponent.class, "StockTopComponent.exportButton.text")); // NOI18N
        exportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(masterScrollPane)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(allRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(minimumRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(minusRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectedRadioButton)
                        .addGap(6, 6, 6)
                        .addComponent(supplierCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(supplierComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(typeCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(itemTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(countTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(reloadButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(printButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(exportButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(totalLabel)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(allRadioButton)
                    .addComponent(minimumRadioButton)
                    .addComponent(typeCheckBox)
                    .addComponent(itemTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(supplierCheckBox)
                    .addComponent(supplierComboBox)
                    .addComponent(selectedRadioButton)
                    .addComponent(countTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(minusRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reloadButton)
                    .addComponent(totalLabel)
                    .addComponent(printButton)
                    .addComponent(exportButton))
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        if (evt.getClickCount() > 1) {
            String itemCode = table.getValueAt(table.getSelectedRow(), 1).toString();
            String quantity = table.getValueAt(table.getSelectedRow(), 5).toString();
            String cost = table.getValueAt(table.getSelectedRow(), 6).toString();
            String selling = table.getValueAt(table.getSelectedRow(), 7).toString();

            String newQuantity = JOptionPane.showInputDialog(this, "Quantity for " + itemCode, quantity);
            String newCost = JOptionPane.showInputDialog(this, "Cost for " + itemCode, cost);
            String newSelling = JOptionPane.showInputDialog(this, "Selling for " + itemCode, selling);

            if (quantity != newQuantity || cost != newCost || selling != newSelling) {
                Item item = manager.find(Item.class, itemCode);
                PriceList priceList = item.getPriceList();
                Stock stock = item.getStock();

                priceList.setCostPack(Double.parseDouble(newCost));
                priceList.setSellingPack(Double.parseDouble(newSelling));

                stock.setQuantity(Double.parseDouble(newQuantity));

                manager.update(priceList);
                manager.update(stock);

                fillTable();
            }

            //showMessage("Selected: " + itemCode);
        }
    }//GEN-LAST:event_tableMouseClicked

    private void tableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseReleased
    }//GEN-LAST:event_tableMouseReleased

    private void tableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableKeyReleased
    }//GEN-LAST:event_tableKeyReleased

    private void reloadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reloadButtonActionPerformed
        fillTable();
    }//GEN-LAST:event_reloadButtonActionPerformed

    private void allRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allRadioButtonActionPerformed
        supplierCheckBox.setSelected(false);
        typeCheckBox.setSelected(false);
        fillTable();
    }//GEN-LAST:event_allRadioButtonActionPerformed

    private void minimumRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimumRadioButtonActionPerformed
        fillTable();
    }//GEN-LAST:event_minimumRadioButtonActionPerformed

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
        printStock();
    }//GEN-LAST:event_printButtonActionPerformed

    private void typeCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeCheckBoxActionPerformed
        selectedRadioButton.setSelected(true);
        fillTable();
    }//GEN-LAST:event_typeCheckBoxActionPerformed

    private void itemTypeComboBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itemTypeComboBoxKeyPressed
//        if (evt.getKeyCode() == 10) {
//            fillTable();
//        }
    }//GEN-LAST:event_itemTypeComboBoxKeyPressed

    private void itemTypeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemTypeComboBoxActionPerformed
        if (typeCheckBox.isSelected()) {
            fillTable();
        }
    }//GEN-LAST:event_itemTypeComboBoxActionPerformed

    private void supplierComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplierComboBoxActionPerformed
        if (supplierCheckBox.isSelected()) {
            fillTable();
        }
    }//GEN-LAST:event_supplierComboBoxActionPerformed

    private void supplierComboBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_supplierComboBoxKeyPressed
//        if (evt.getKeyCode() == 10) {
//            fillTable();
//        }
    }//GEN-LAST:event_supplierComboBoxKeyPressed

    private void supplierCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplierCheckBoxActionPerformed
        selectedRadioButton.setSelected(true);
        fillTable();
    }//GEN-LAST:event_supplierCheckBoxActionPerformed

    private void minusRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minusRadioButtonActionPerformed
        fillTable();
    }//GEN-LAST:event_minusRadioButtonActionPerformed

    private void exportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportButtonActionPerformed
        Export.toExcel(table, "on " + yyyy_MM_dd_hh_mm_ss_a_Space.format(new Date()), getName().replace(" Window", ""));
    }//GEN-LAST:event_exportButtonActionPerformed
//    private void searchSupplier() {
//        SearchSupplierDialog searchSupplierDialog = new SearchSupplierDialog(null, true);
//        supplier = searchSupplierDialog.suppllier;
//        if (supplier != null) {
//            fillTable();
//        }
//    }
//    Supplier supplier = null;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton allRadioButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField countTextField;
    private javax.swing.JButton exportButton;
    private javax.swing.JComboBox itemTypeComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane masterScrollPane;
    private javax.swing.JRadioButton minimumRadioButton;
    private javax.swing.JRadioButton minusRadioButton;
    private javax.swing.JButton printButton;
    private javax.swing.JButton reloadButton;
    private javax.swing.JRadioButton selectedRadioButton;
    private javax.swing.JCheckBox supplierCheckBox;
    private javax.swing.JComboBox supplierComboBox;
    private javax.swing.JTable table;
    private javax.swing.JLabel totalLabel;
    private javax.swing.JCheckBox typeCheckBox;
    // End of variables declaration//GEN-END:variables

    @Override
    public void componentOpened() {
        fillItemTypes();
        Combo.fillSuppliers(supplierComboBox, null);
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
    DefaultTableModel tableModel;

    private void fillTable() {
        tableModel.setRowCount(0);
        totalLabel.setText("0.00");
        SwingWorker<DefaultTableModel, Object[]> worker = new SwingWorker<DefaultTableModel, Object[]>() {
            double totalCost = 0, totalSelling = 0;

            @Override
            protected DefaultTableModel doInBackground() throws Exception {

                Runnable run = new Runnable() {

                    @Override
                    public void run() {
                        ProgressHandle p = ProgressHandleFactory.createHandle("Loading...");
                        p.start();
                        int i = 0;
                        manager.clearCache();
                        List<Stock> stocks = null;
                        if (allRadioButton.isSelected()) {
                            stocks = manager.find(Stock.class);
                        } else if (minimumRadioButton.isSelected()) {
                            stocks = Find.stockLessMinLimit();
                        } else if (minusRadioButton.isSelected()) {
                            stocks = Find.stockLessThan(0);
                        } else if (supplierCheckBox.isSelected()) {
                            Object o = supplierComboBox.getSelectedItem();
                            Supplier supplier;
                            if (o instanceof Supplier) {
                                supplier = (Supplier) o;
                            } else {
                                p.finish();
                                return;
                            }
                            if (typeCheckBox.isSelected()) {
                                o = itemTypeComboBox.getSelectedItem();
                                ItemType itemType;
                                if (o instanceof ItemType) {
                                    itemType = (ItemType) o;
                                } else {
                                    p.finish();
                                    return;
                                }
                                stocks = Find.stockBySupplierAndItemType(supplier, itemType);
                            } else {
                                stocks = Find.stockBySupplier(supplier);
                            }
                        } else if (typeCheckBox.isSelected()) {
                            Object o = itemTypeComboBox.getSelectedItem();
                            ItemType itemType;
                            if (o instanceof ItemType) {
                                itemType = (ItemType) o;
                            } else {
                                p.finish();
                                return;
                            }
                            stocks = Find.stockByItemType(itemType);
                        } else {
                            stocks = null;
                        }
                        if (stocks == null) {
                            p.finish();
                            return;
                        }
                        Comparator<Stock> c = new Comparator<Stock>() {

                            @Override
                            public int compare(Stock o1, Stock o2) {
                                String typeOne = o1.getItem().getItemTypeType() == null ? "" : o1.getItem().getItemTypeType().getType();
                                String typeTwo = o2.getItem().getItemTypeType() == null ? "" : o2.getItem().getItemTypeType().getType();
                                return typeOne.compareTo(typeTwo);
                            }
                        };
                        Collections.sort(stocks, c);
                        for (Stock stock : stocks) {
                            Item item = stock.getItem();
                            if (item == null) {
                                showError("Item Not Found!");
                                p.finish();
                                return;
                            }
                            double quantity = stock.getQuantity();
                            double cost = item.getPriceList() != null ? item.getPriceList().getCostPack() != null ? item.getPriceList().getCostPack() : 0.0 : 0.0;
                            totalCost += (quantity * cost);
                            double selling = item.getPriceList() != null ? item.getPriceList().getSellingPack() != null ? item.getPriceList().getSellingPack() : 0.0 : 0.0;
                            totalSelling += (quantity * selling);
                            Object[] row = {
                                nf4p.format(++i),
                                item.getCode(),
                                item.getDescription(),
                                item.getItemTypeType() == null ? "" : item.getItemTypeType().getType(),
                                item.getBrand(),
                                nf2d.format(quantity),
                                nf2d.format(cost),
                                nf2d.format(quantity * cost),
                                nf2d.format(selling),
                                nf2d.format(quantity * selling),
                                nf2d.format((quantity * selling) - (quantity * cost))
                            };
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
                totalLabel.setText(nf2d.format(totalSelling) + " - " + nf2d.format(totalCost) + " = " + nf2d.format(totalSelling - totalCost));
            }
        };
        worker.execute();
    }

    private void KeyAdapter() {
        AutoCompleteDecorator.decorate(supplierComboBox);
        setComboBoxKeyAdapters(supplierComboBox);
    }

    private void setComboBoxKeyAdapters(JComboBox supp) {
        String compName = supp.getName();
        Component component[] = supp.getComponents();
        for (Component component1 : component) {
            if (compName.equals("supplierComboBox")) {
                component1.addKeyListener(supplierComboBoxKeyAdapter);
            }
        }
    }
    KeyAdapter supplierComboBoxKeyAdapter = new java.awt.event.KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent evt) {
            supplierComboBoxKeyPressed(evt);
        }
    };

    private void fillItemTypes() {
        // List<ItemType> itemTypes = manager.find(ItemType.class);
        // if (itemTypes.isEmpty()) {
        //     manager.update(new ItemType("ITEM"));
        //     manager.update(new ItemType("METERIAL"));
        // }
        List<ItemType> itemTypes = manager.find(ItemType.class);
        itemTypeComboBox.setModel(new DefaultComboBoxModel(itemTypes.toArray()));
    }

    protected void onLoad() {
        initComponents();
        tableModel = (DefaultTableModel) table.getModel();
        table.setDefaultRenderer(Object.class, coloredCellRenderer);
        fillItemTypes();
        KeyAdapter();
    }

    private void printStock() {
        try {
            String fileName = supplierCheckBox.isSelected() ? typeCheckBox.isSelected() ? "stockBySupplierAndItemType" : "stockBySupplier" :typeCheckBox.isSelected() ?"stockByItemType"  : "stock";
            URL url = getClass().getResource("/com/nanosl/nbiz/gui/jrxml/" + fileName + ".jasper");

            Map<String, Object> params = Data.getParams();
            if (supplierCheckBox.isSelected()) {
                Object o = supplierComboBox.getSelectedItem();
                if (o instanceof Supplier) {
                    Supplier supplier = (Supplier) o;
                    params.put("supplierCode", supplier.getCode());
                }
            }
            if (typeCheckBox.isSelected()) {
                Object o = itemTypeComboBox.getSelectedItem();
                if (o instanceof ItemType) {
                    ItemType itemType = (ItemType) o;
                    params.put("itemTypeType", itemType.getType());
                }
            }

            Object object = JRLoader.loadObject(url);//"src/com/nanosl/nbiz/gui/jrxml/report1.jasper"
            if (object == null) {
                showError("Unable to print");
                return;
            }
            JasperReport report = (JasperReport) object;

            printViewTopComponent.print(report, params);

        } catch (JRException ex) {
            Exceptions.printStackTrace(ex);
        }
    }
}
