/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.gui.rep;

import com.nanosl.nbiz.util.NTopComponent;
import entity.Employee;
import entity.Item;
import entity.RepSale;
import entity.RepSalePK;
import entity.RepSaleValue;
import entity.SrStock;
import entity.SrStockPK;
import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
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
        dtd = "-//com.nanosl.nbiz.gui.rep//RepSale//EN",
        autostore = false)
@TopComponent.Description(
        preferredID = "RepSaleTopComponent",
        //iconBase="SET/PATH/TO/ICON/HERE", 
        persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@ActionID(category = "Window", id = "com.nanosl.nbiz.gui.rep.RepSaleTopComponent")
@ActionReference(path = "Menu/Distribution" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_RepSaleAction",
        preferredID = "RepSaleTopComponent")
@Messages({
    "CTL_RepSaleAction=RepSale",
    "CTL_RepSaleTopComponent=RepSale Window",
    "HINT_RepSaleTopComponent=This is a RepSale window"
})
public final class RepSaleTopComponent extends NTopComponent {

    public RepSaleTopComponent() {
        onLoad();
        setName(Bundle.CTL_RepSaleTopComponent());
        setToolTipText(Bundle.HINT_RepSaleTopComponent());

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
        soldTextField = new javax.swing.JTextField();
        totalTextField = new javax.swing.JTextField();
        processButton = new javax.swing.JButton();
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        jLabel4 = new javax.swing.JLabel();

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        masterTable.setAutoCreateRowSorter(true);
        masterTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Code", "Description", "Loaded", "Remaining", "Sold", "Rate", "Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
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
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                masterTableMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                masterTableMouseClicked(evt);
            }
        });
        masterTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                masterTableKeyReleased(evt);
            }
        });
        masterScrollPane.setViewportView(masterTable);
        masterTable.getColumnModel().getColumn(0).setHeaderValue(org.openide.util.NbBundle.getMessage(RepSaleTopComponent.class, "RepSaleTopComponent.masterTable.columnModel.title0")); // NOI18N
        masterTable.getColumnModel().getColumn(1).setHeaderValue(org.openide.util.NbBundle.getMessage(RepSaleTopComponent.class, "RepSaleTopComponent.masterTable.columnModel.title1")); // NOI18N
        masterTable.getColumnModel().getColumn(2).setHeaderValue(org.openide.util.NbBundle.getMessage(RepSaleTopComponent.class, "RepSaleTopComponent.masterTable.columnModel.title2")); // NOI18N
        masterTable.getColumnModel().getColumn(3).setHeaderValue(org.openide.util.NbBundle.getMessage(RepSaleTopComponent.class, "RepSaleTopComponent.masterTable.columnModel.title3")); // NOI18N
        masterTable.getColumnModel().getColumn(3).setCellRenderer(rightAlignCell);
        masterTable.getColumnModel().getColumn(4).setHeaderValue(org.openide.util.NbBundle.getMessage(RepSaleTopComponent.class, "RepSaleTopComponent.masterTable.columnModel.title4")); // NOI18N
        masterTable.getColumnModel().getColumn(4).setCellRenderer(rightAlignCell);
        masterTable.getColumnModel().getColumn(5).setHeaderValue(org.openide.util.NbBundle.getMessage(RepSaleTopComponent.class, "RepSaleTopComponent.masterTable.columnModel.title5")); // NOI18N
        masterTable.getColumnModel().getColumn(5).setCellRenderer(rightAlignCell);
        masterTable.getColumnModel().getColumn(6).setHeaderValue(org.openide.util.NbBundle.getMessage(RepSaleTopComponent.class, "RepSaleTopComponent.masterTable.columnModel.title6")); // NOI18N
        masterTable.getColumnModel().getColumn(6).setCellRenderer(rightAlignCell);
        masterTable.getColumnModel().getColumn(7).setHeaderValue(org.openide.util.NbBundle.getMessage(RepSaleTopComponent.class, "RepSaleTopComponent.masterTable.columnModel.title7")); // NOI18N
        masterTable.getColumnModel().getColumn(7).setCellRenderer(rightAlignCell);

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

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(RepSaleTopComponent.class, "RepSaleTopComponent.jLabel1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(RepSaleTopComponent.class, "RepSaleTopComponent.jLabel2.text")); // NOI18N

        itemComboBox.setName("itemComboBox"); // NOI18N
        itemComboBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                itemComboBoxKeyPressed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(RepSaleTopComponent.class, "RepSaleTopComponent.jLabel3.text")); // NOI18N

        soldTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                soldTextFieldActionPerformed(evt);
            }
        });

        totalTextField.setEditable(false);
        totalTextField.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        totalTextField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        totalTextField.setText(org.openide.util.NbBundle.getMessage(RepSaleTopComponent.class, "RepSaleTopComponent.totalTextField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(processButton, org.openide.util.NbBundle.getMessage(RepSaleTopComponent.class, "RepSaleTopComponent.processButton.text")); // NOI18N
        processButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(RepSaleTopComponent.class, "RepSaleTopComponent.jLabel4.text")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(processButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(masterScrollPane)
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
                        .addComponent(soldTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 158, Short.MAX_VALUE)))
                .addContainerGap())
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
                    .addComponent(soldTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(processButton)
                    .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
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

    private void masterTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masterTableMouseClicked
    }//GEN-LAST:event_masterTableMouseClicked

    private void masterTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masterTableMouseReleased
    }//GEN-LAST:event_masterTableMouseReleased

    private void masterTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_masterTableKeyReleased
    }//GEN-LAST:event_masterTableKeyReleased

    private void repComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repComboBoxActionPerformed
        fillTable();
    }//GEN-LAST:event_repComboBoxActionPerformed

    private void soldTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_soldTextFieldActionPerformed
        editTable();
    }//GEN-LAST:event_soldTextFieldActionPerformed

    private void processButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processButtonActionPerformed
        process();
    }//GEN-LAST:event_processButtonActionPerformed

    private void repComboBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_repComboBoxKeyPressed
        fillTable();
    }//GEN-LAST:event_repComboBoxKeyPressed

    private void itemComboBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itemComboBoxKeyPressed
        fillTable();
    }//GEN-LAST:event_itemComboBoxKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox itemComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    private javax.swing.JScrollPane masterScrollPane;
    private javax.swing.JTable masterTable;
    private javax.swing.JButton processButton;
    private javax.swing.JComboBox repComboBox;
    private javax.swing.JTextField soldTextField;
    private javax.swing.JTextField totalTextField;
    // End of variables declaration//GEN-END:variables
    DefaultTableModel tableModel;

    private void fillTable() {
        Employee employee = (Employee) repComboBox.getSelectedItem();
        int i = 0;
        tableModel.setRowCount(i);
        if (employee == null) {
            return;
        }
        for (SrStock srStock : employee.getSrStockCollection()) {
            Item item = srStock.getItem();
            double quantity = srStock.getQuantity();
            if (srStock.getPackPrice() == null) {
                srStock.setPackPrice(item.getPriceList().getSellingPack() == null ? 0.0 : item.getPriceList().getSellingPack());
                manager.update(srStock);
            }
            double price = srStock.getPackPrice();
            Object[] row = {++i, item.getCode(), item.getDescription(), quantity, quantity, 0.0, price, quantity * price};
            tableModel.addRow(row);
        }
        fillItems();
        calcTotal();
    }

    protected void onLoad() {
        initComponents();
        tableModel = (DefaultTableModel) masterTable.getModel();
        masterTable.setDefaultRenderer(Object.class, coloredCellRenderer);
        setKeyAdapter();
    }

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
        fillRep();
    }

    private void fillRep() {
        tableModel.setRowCount(0);
        repComboBox.setModel(new DefaultComboBoxModel(manager.find(Employee.class).toArray()));
        fillItems();
        fillTable();
    }

    private void fillItems() {
        itemComboBox.setModel(new DefaultComboBoxModel(manager.find(Item.class).toArray()));
    }

    private void editTable() {
        Item item = (Item) itemComboBox.getSelectedItem();
        double sold = 0;
        try {
            sold = Double.valueOf(soldTextField.getText().trim());
        } catch (NumberFormatException numberFormatException) {
            showError("Invalid Value");
            soldTextField.requestFocus();
            return;
        }
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            if (tableModel.getValueAt(i, 1).toString().equals(item.getCode())) {
                double previusSold = 0;
                try {
                    previusSold = Double.valueOf(tableModel.getValueAt(i, 5).toString());
                } catch (NumberFormatException numberFormatException) {
                }
                sold = sold + previusSold;
                tableModel.setValueAt(sold, i, 5);
                double loaded = Double.valueOf(tableModel.getValueAt(i, 3).toString());
                double remaining = loaded - sold;
                tableModel.setValueAt(remaining, i, 4);
                double rate = Double.valueOf(tableModel.getValueAt(i, 6).toString());
                tableModel.setValueAt(sold * rate, i, 7);
                calcTotal();
                soldTextField.setText("");
                itemComboBox.requestFocus();
                return;
            }
        }
        showError("Item not forund");
    }

    private void calcTotal() {
        double total = 0;
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            total += Double.valueOf(tableModel.getValueAt(i, 7).toString());
        }
        totalTextField.setText(nf2d.format(total));
    }

    private void process() {
        Date date = jXDatePicker1.getDate();
        Employee employee = (Employee) repComboBox.getSelectedItem();
        if (tableModel.getRowCount() == 0 || date == null) {
            return;
        }
        List<Serializable> serializables = new ArrayList<Serializable>();
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            Item item = manager.find(Item.class, tableModel.getValueAt(i, 1).toString());
            RepSalePK repSalePK = new RepSalePK(date, item.getCode(), employee.getCode());
            RepSale repSale = manager.find(RepSale.class, repSalePK);
            if (repSale != null) {
                showError("Can't update same item twice a day!" + repSalePK);
                return;
            }
            double loaded = Double.valueOf(tableModel.getValueAt(i, 3).toString());
            double remaining = Double.valueOf(tableModel.getValueAt(i, 4).toString());
            double rate = Double.valueOf(tableModel.getValueAt(i, 6).toString());
            repSale = new RepSale(repSalePK);
            repSale.setEmployee(employee);
            repSale.setItem(item);
            repSale.setLoaded(loaded);
            repSale.setRemaining(remaining);
            repSale.setRate(rate);
            serializables.add(repSale);

            SrStock srStock = manager.find(SrStock.class, new SrStockPK(employee.getCode(), item.getCode()));
            srStock.setQuantity(remaining);
            serializables.add(srStock);
        }
        RepSaleValue repSaleValue = new RepSaleValue(date, employee.getCode());
        repSaleValue.setAmount(Double.valueOf(totalTextField.getText().trim()));
        repSaleValue.setEmployee(employee);
        serializables.add(repSaleValue);
        if (manager.update(serializables)) {
            showSuccess("Update success");
            fillRep();
            fillItems();
            calcTotal();
            return;
        }
        showError("Update Failed");
    }

    private void setKeyAdapter() {
        AutoCompleteDecorator.decorate(itemComboBox);
        setComboBoxKeyAdapters(itemComboBox);
        AutoCompleteDecorator.decorate(repComboBox);
        setComboBoxKeyAdapters(repComboBox);
    }

    private void setComboBoxKeyAdapters(JComboBox comp) {
        String compName = comp.getName();
        Component component[] = comp.getComponents();
        for (int i = 0; i < component.length; i++) {
            if (compName.equals("itemComboBox")) {
                component[i].addKeyListener(itemComboBoxKeyAdapter);
            }
            if (compName.equals("repComboBox")) {
                component[i].addKeyListener(repComboBoxKeyAdapter);
            }
        }

    }
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
        repComboBox.requestFocus();
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
