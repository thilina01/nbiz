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
import javax.swing.JComponent;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.JXDatePicker;
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
        dtd = "-//com.nanosl.nbiz.gui.rep//RepRemainingStock//EN",
        autostore = false)
@TopComponent.Description(
        preferredID = "RepRemainingStockTopComponent",
        //iconBase="SET/PATH/TO/ICON/HERE", 
        persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@ActionID(category = "Window", id = "com.nanosl.nbiz.gui.rep.RepRemainingStockTopComponent")
@ActionReference(path = "Menu/Distribution" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_RepRemainingStockAction",
        preferredID = "RepRemainingStockTopComponent")
@Messages({
    "CTL_RepRemainingStockAction=RepRemainingStock",
    "CTL_RepRemainingStockTopComponent=RepRemainingStock Window",
    "HINT_RepRemainingStockTopComponent=This is a RepRemainingStock window"
})
public final class RepRemainingStockTopComponent extends NTopComponent {

    public RepRemainingStockTopComponent() {
        onLoad();
        setName(Bundle.CTL_RepRemainingStockTopComponent());
        setToolTipText(Bundle.HINT_RepRemainingStockTopComponent());

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
        remainingTextField = new javax.swing.JTextField();
        totalTextField = new javax.swing.JTextField();
        processButton = new javax.swing.JButton();
        jXDatePicker1 = new JXDatePicker();
        jLabel4 = new javax.swing.JLabel();

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

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(RepRemainingStockTopComponent.class, "RepRemainingStockTopComponent.jLabel1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(RepRemainingStockTopComponent.class, "RepRemainingStockTopComponent.jLabel2.text")); // NOI18N

        itemComboBox.setName("itemComboBox"); // NOI18N
        itemComboBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                itemComboBoxKeyPressed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(RepRemainingStockTopComponent.class, "RepRemainingStockTopComponent.jLabel3.text")); // NOI18N

        remainingTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remainingTextFieldActionPerformed(evt);
            }
        });

        totalTextField.setEditable(false);
        totalTextField.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        totalTextField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        totalTextField.setText(org.openide.util.NbBundle.getMessage(RepRemainingStockTopComponent.class, "RepRemainingStockTopComponent.totalTextField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(processButton, org.openide.util.NbBundle.getMessage(RepRemainingStockTopComponent.class, "RepRemainingStockTopComponent.processButton.text")); // NOI18N
        processButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(RepRemainingStockTopComponent.class, "RepRemainingStockTopComponent.jLabel4.text")); // NOI18N

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
                        .addComponent(remainingTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(remainingTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(masterScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        fillTable();
    }//GEN-LAST:event_repComboBoxActionPerformed

    private void repComboBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_repComboBoxKeyPressed
        if (evt.getKeyCode() == 10) {
            itemComboBox.requestFocus();
        }
    }//GEN-LAST:event_repComboBoxKeyPressed

    private void itemComboBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itemComboBoxKeyPressed
        if (evt.getKeyCode() == 10) {
            remainingTextField.requestFocus();
        }
    }//GEN-LAST:event_itemComboBoxKeyPressed

    private void remainingTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remainingTextFieldActionPerformed
        editTable();
    }//GEN-LAST:event_remainingTextFieldActionPerformed

    private void processButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processButtonActionPerformed
        process();
    }//GEN-LAST:event_processButtonActionPerformed
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
    private javax.swing.JTextField remainingTextField;
    private javax.swing.JComboBox repComboBox;
    private javax.swing.JTextField totalTextField;
    // End of variables declaration//GEN-END:variables
    DefaultTableModel tableModel;

    private void fillTable() {
        Employee employee = (Employee) repComboBox.getSelectedItem();
        int i = 0;
        tableModel.setRowCount(i);
        for (Iterator<SrStock> it = employee.getSrStockCollection().iterator(); it.hasNext();) {
            SrStock srStock = it.next();
            Item item = srStock.getItem();
            double quantity = srStock.getQuantity();
            if (srStock.getPackPrice() == null) {
                srStock.setPackPrice(item.getPriceList().getSellingPack() == null ? 0.0 : item.getPriceList().getSellingPack());
                m.update(srStock);
            }
            double price = srStock.getPackPrice();
            Object[] row = {++i, item.getCode(), item.getDescription(), quantity, 0.0, quantity, price, quantity * price};
            tableModel.addRow(row);
        }
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
        fillTable();
    }

    private void fillItems() {
        itemComboBox.setModel(new DefaultComboBoxModel(m.find(Item.class).toArray()));
    }

    private void editTable() {
        Item item = (Item) itemComboBox.getSelectedItem();
        double remaining = 0;
        try {
            remaining = Double.valueOf(remainingTextField.getText().trim());
        } catch (NumberFormatException numberFormatException) {
            showError("Invalid Value");
            remainingTextField.requestFocus();
            return;
        }
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            if (tableModel.getValueAt(i, 1).toString().equals(item.getCode())) {
                double previusRemaining = 0;
                try {
                    previusRemaining = Double.valueOf(tableModel.getValueAt(i, 4).toString());
                } catch (NumberFormatException numberFormatException) {
                }
                remaining = remaining + previusRemaining;
                tableModel.setValueAt(remaining, i, 4);
                double loaded = Double.valueOf(tableModel.getValueAt(i, 3).toString());
                double sold = loaded - remaining;
                tableModel.setValueAt(sold, i, 5);
                double rate = Double.valueOf(tableModel.getValueAt(i, 6).toString());
                tableModel.setValueAt(sold * rate, i, 7);
                calcTotal();
                remainingTextField.setText("");
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
            Item item = m.find(Item.class, tableModel.getValueAt(i, 1).toString());
            RepSalePK repSalePK = new RepSalePK(date, item.getCode(), employee.getCode());
            RepSale repSale = m.find(RepSale.class, repSalePK);
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

            SrStock srStock = m.find(SrStock.class, new SrStockPK(employee.getCode(), item.getCode()));
            srStock.setQuantity(remaining);
            serializables.add(srStock);
        }
        RepSaleValue repSaleValue = new RepSaleValue(date, employee.getCode());
        repSaleValue.setAmount(Double.valueOf(totalTextField.getText().trim()));
        repSaleValue.setEmployee(employee);
        serializables.add(repSaleValue);
        if (m.update(serializables)) {
            showSuccess("Update success");
            fillRep();
            fillItems();
            calcTotal();
            return;
        }
        showError("Update Failed");
    }

    private void KeyAdapter() {

        AutoCompleteDecorator.decorate(itemComboBox);
        AutoCompleteDecorator.decorate(repComboBox);
        setComboBoxKeyAdapters(itemComboBox);
        setComboBoxKeyAdapters(repComboBox);


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
