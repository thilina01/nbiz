/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.gui.rep;

import com.nanosl.nbiz.util.NTopComponent;
import entity.Employee;
import entity.Item;
import entity.RepStockChange;
import entity.SrStock;
import entity.SrStockPK;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
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
        dtd = "-//com.nanosl.nbiz.gui.rep//RepStockChange//EN",
        autostore = false)
@TopComponent.Description(
        preferredID = "RepStockChangeTopComponent",
        //iconBase="SET/PATH/TO/ICON/HERE", 
        persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@ActionID(category = "Window", id = "com.nanosl.nbiz.gui.rep.RepStockChangeTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_RepStockChangeAction",
        preferredID = "RepStockChangeTopComponent")
@Messages({
    "CTL_RepStockChangeAction=RepStockChange",
    "CTL_RepStockChangeTopComponent=RepStockChange Window",
    "HINT_RepStockChangeTopComponent=This is a RepStockChange window"
})
public final class RepStockChangeTopComponent extends NTopComponent {

    public RepStockChangeTopComponent() {
        onLoad();
        setName(Bundle.CTL_RepStockChangeTopComponent());
        setToolTipText(Bundle.HINT_RepStockChangeTopComponent());

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
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        jLabel3 = new javax.swing.JLabel();
        totalLabel = new javax.swing.JLabel();
        resetButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        repComboBox = new javax.swing.JComboBox();

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

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(RepStockChangeTopComponent.class, "RepStockChangeTopComponent.jLabel1.text")); // NOI18N

        itemComboBox.setName("itemComboBox"); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(RepStockChangeTopComponent.class, "RepStockChangeTopComponent.jLabel2.text")); // NOI18N

        actualQuantityTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualQuantityTextFieldActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(processButton, org.openide.util.NbBundle.getMessage(RepStockChangeTopComponent.class, "RepStockChangeTopComponent.processButton.text")); // NOI18N
        processButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(RepStockChangeTopComponent.class, "RepStockChangeTopComponent.jLabel3.text")); // NOI18N

        totalLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        totalLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        org.openide.awt.Mnemonics.setLocalizedText(totalLabel, org.openide.util.NbBundle.getMessage(RepStockChangeTopComponent.class, "RepStockChangeTopComponent.totalLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(resetButton, org.openide.util.NbBundle.getMessage(RepStockChangeTopComponent.class, "RepStockChangeTopComponent.resetButton.text")); // NOI18N
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(RepStockChangeTopComponent.class, "RepStockChangeTopComponent.jLabel4.text")); // NOI18N

        repComboBox.setName("repComboBox"); // NOI18N
        repComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(masterScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 839, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(processButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(resetButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(totalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(repComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(itemComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(actualQuantityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(repComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(itemComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(actualQuantityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(processButton)
                    .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(totalLabel)
                    .addComponent(resetButton))
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

    private void actualQuantityTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualQuantityTextFieldActionPerformed
        editTable();
    }//GEN-LAST:event_actualQuantityTextFieldActionPerformed

    private void processButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processButtonActionPerformed
        process();
    }//GEN-LAST:event_processButtonActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        reset();
    }//GEN-LAST:event_resetButtonActionPerformed

    private void repComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repComboBoxActionPerformed
        reLoad();
    }//GEN-LAST:event_repComboBoxActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField actualQuantityTextField;
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
    private javax.swing.JButton resetButton;
    private javax.swing.JLabel totalLabel;
    // End of variables declaration//GEN-END:variables
    DefaultTableModel tableModel;

    private void fillTable(Collection<SrStock> srStocks) {
        tableModel.setRowCount(0);
        int i = tableModel.getRowCount();
        for (Iterator<SrStock> it = srStocks.iterator(); it.hasNext();) {
            SrStock srStock = it.next();
            Item item = srStock.getItem();
            double quantity = srStock.getQuantity() == null ? 0 : srStock.getQuantity();
            double cost = item.getPriceList() == null ? 0 : item.getPriceList().getCostPack();
            Object[] row = {++i, item.getCode(), item.getDescription(), quantity, quantity, 0, cost, 0};
            tableModel.addRow(row);
        }
    }

    protected void onLoad() {
        initComponents();
        tableModel = (DefaultTableModel) masterTable.getModel();
//        AutoCompleteDecorator.decorate(itemComboBox);
//        AutoCompleteDecorator.decorate(repComboBox);
        reset();
    }

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
        fillReps();
    }

    private void reset() {
//        fillTable();
        fillItems();
        calcTotal();
    }

    private void fillItems() {
        itemComboBox.setModel(new DefaultComboBoxModel(m.find(Item.class).toArray()));
    }

    private void editTable() {
        double actualQuantity = 0;

        try {
            actualQuantity = Double.valueOf(actualQuantityTextField.getText().trim());
        } catch (NumberFormatException numberFormatException) {
            showError("Invalid number!");
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
        Date date = jXDatePicker1.getDate();
        if (date == null) {
            showError("Select date");
            return;
        }
        List<Serializable> serializables = new ArrayList<Serializable>();
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            Employee employee = (Employee) repComboBox.getSelectedItem();
            SrStock srStock = m.find(SrStock.class, new SrStockPK(employee.getCode(), masterTable.getValueAt(i, 1).toString()));
            Item item = m.find(Item.class, masterTable.getValueAt(i, 1));
            double oldQuantity = srStock.getQuantity();
            double actualQuantity = Double.valueOf(masterTable.getValueAt(i, 4).toString());
            double rate = Double.valueOf(masterTable.getValueAt(i, 6).toString());
            srStock.setQuantity(actualQuantity);
            serializables.add(srStock);

            RepStockChange repStockChange = new RepStockChange(item.getCode(), date, employee.getCode());
            repStockChange.setActualQuantity(actualQuantity);
            repStockChange.setItem(item);
            repStockChange.setOldQuantity(oldQuantity);
            repStockChange.setRate(rate);
            serializables.add(repStockChange);
        }
        if (m.update(serializables)) {
            showSuccess("Update success");
            reset();
        }
    }

    private void reLoad() {
        reset();
        Employee employee = (Employee) repComboBox.getSelectedItem();
        Collection<SrStock> stocks = employee.getSrStockCollection();
        fillTable(stocks);

    }

    private void fillReps() {
        repComboBox.setModel(new DefaultComboBoxModel(m.find(Employee.class).toArray()));
    }

    private void KeyAdapter() {

        AutoCompleteDecorator.decorate(itemComboBox);
        setComboBoxKeyAdapters(itemComboBox);
        AutoCompleteDecorator.decorate(repComboBox);
        setComboBoxKeyAdapters(repComboBox);


    }

    private void setComboBoxKeyAdapters(JComboBox comp) {
        String compName = comp.getName();
        Component component[] = comp.getComponents();
        for (int i = 0; i < component.length; i++) {
            if (comp.equals("itemComboBox")) {
                component[i].addKeyListener(itemComboBoxKeyAdapter);
            }
            if (comp.equals("repComboBox")) {
                component[i].addKeyListener(repComboBoxKeyAdapter);
            }
        }

    }
    KeyAdapter itemComboBoxKeyAdapter = new java.awt.event.KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent evt) {
            itemComboBoxKeyAdapter.keyPressed(evt);
        }
    };
    KeyAdapter repComboBoxKeyAdapter = new java.awt.event.KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent evt) {
            repComboBoxKeyAdapter.keyPressed(evt);
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
