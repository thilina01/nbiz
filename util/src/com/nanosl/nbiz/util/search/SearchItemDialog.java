/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.util.search;

import com.nanosl.lib.db.Manager;
import static com.nanosl.nbiz.util.Cell.coloredCellRenderer;
import com.nanosl.nbiz.util.Format;
import entity.Item;
import entity.PriceList;
import entity.Stock;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;
import query.Find;

/**
 *
 * @author Thilina
 */
public class SearchItemDialog extends javax.swing.JDialog {

    private Item item;

    /**
     * Creates new form SearchCustomerDialog
     *
     * @param parent
     * @param modal
     * @param c
     */
    public SearchItemDialog(java.awt.Frame parent, boolean modal, String c) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        //Temporarily hiding quantity column [to do: do not hide column for admin]
        TableColumnModel tcm = itemTable.getColumnModel();
        tcm.removeColumn(tcm.getColumn(4));

        itemTable.setDefaultRenderer(Object.class, coloredCellRenderer);
        itemTableModel = (DefaultTableModel) itemTable.getModel();
//        getRootPane().setBorder( BorderFactory.createLineBorder(Color.blue) );
        setLocationRelativeTo(null);
        searchTextField.setText(c + "");
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        searchTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        itemTable = new javax.swing.JTable();
        addButton = new javax.swing.JButton();
        startingRadioButton = new javax.swing.JRadioButton();
        containsRadioButton = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        limitTextField = new javax.swing.JTextField();
        closeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(SearchItemDialog.class, "SearchItemDialog.jLabel1.text")); // NOI18N

        searchTextField.setText(org.openide.util.NbBundle.getMessage(SearchItemDialog.class, "SearchItemDialog.searchTextField.text")); // NOI18N
        searchTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTextFieldActionPerformed(evt);
            }
        });
        searchTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchTextFieldKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTextFieldKeyReleased(evt);
            }
        });

        itemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Code", "Description", "Cost", "Selling", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        itemTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itemTableMouseClicked(evt);
            }
        });
        itemTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                itemTableKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                itemTableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(itemTable);
        if (itemTable.getColumnModel().getColumnCount() > 0) {
            itemTable.getColumnModel().getColumn(0).setPreferredWidth(70);
            itemTable.getColumnModel().getColumn(0).setMaxWidth(80);
            itemTable.getColumnModel().getColumn(0).setHeaderValue(org.openide.util.NbBundle.getMessage(SearchItemDialog.class, "SearchItemDialog.itemTable.columnModel.title0")); // NOI18N
            itemTable.getColumnModel().getColumn(1).setPreferredWidth(200);
            itemTable.getColumnModel().getColumn(1).setHeaderValue(org.openide.util.NbBundle.getMessage(SearchItemDialog.class, "SearchItemDialog.itemTable.columnModel.title1")); // NOI18N
            itemTable.getColumnModel().getColumn(2).setPreferredWidth(70);
            itemTable.getColumnModel().getColumn(2).setHeaderValue(org.openide.util.NbBundle.getMessage(SearchItemDialog.class, "SearchItemDialog.itemTable.columnModel.title2")); // NOI18N
            itemTable.getColumnModel().getColumn(3).setPreferredWidth(70);
            itemTable.getColumnModel().getColumn(3).setHeaderValue(org.openide.util.NbBundle.getMessage(SearchItemDialog.class, "SearchItemDialog.itemTable.columnModel.title3")); // NOI18N
            itemTable.getColumnModel().getColumn(4).setPreferredWidth(70);
            itemTable.getColumnModel().getColumn(4).setHeaderValue(org.openide.util.NbBundle.getMessage(SearchItemDialog.class, "SearchItemDialog.itemTable.columnModel.title4")); // NOI18N
        }

        org.openide.awt.Mnemonics.setLocalizedText(addButton, org.openide.util.NbBundle.getMessage(SearchItemDialog.class, "SearchItemDialog.addButton.text")); // NOI18N
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(startingRadioButton);
        startingRadioButton.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(startingRadioButton, org.openide.util.NbBundle.getMessage(SearchItemDialog.class, "SearchItemDialog.startingRadioButton.text")); // NOI18N

        buttonGroup1.add(containsRadioButton);
        org.openide.awt.Mnemonics.setLocalizedText(containsRadioButton, org.openide.util.NbBundle.getMessage(SearchItemDialog.class, "SearchItemDialog.containsRadioButton.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(SearchItemDialog.class, "SearchItemDialog.jLabel2.text")); // NOI18N

        limitTextField.setText(org.openide.util.NbBundle.getMessage(SearchItemDialog.class, "SearchItemDialog.limitTextField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(closeButton, org.openide.util.NbBundle.getMessage(SearchItemDialog.class, "SearchItemDialog.closeButton.text")); // NOI18N
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(startingRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(containsRadioButton)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(limitTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(closeButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addButton)
                    .addComponent(startingRadioButton)
                    .addComponent(containsRadioButton)
                    .addComponent(jLabel2)
                    .addComponent(limitTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(closeButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextFieldKeyPressed

    }//GEN-LAST:event_searchTextFieldKeyPressed

    private void itemTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemTableMouseClicked
        if (evt.getClickCount() > 1) {
            setItem(Manager.getInstance().find(Item.class, itemTable.getValueAt(itemTable.getSelectedRow(), 0).toString()));
            dispose();
        }
    }//GEN-LAST:event_itemTableMouseClicked

    private void searchTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTextFieldActionPerformed
        if (itemTable.getRowCount() > 0 && searchTextField.getText().trim().length() > 0) {
            int selectedRow = itemTable.getSelectedRow();
            setItem(Manager.getInstance().find(Item.class, itemTable.getValueAt(selectedRow < 0 ? 0 : selectedRow, 0).toString()));
            dispose();
        } else if (itemTable.getRowCount() == 0 && searchTextField.getText().trim().length() == 0) {
            setItem(null);
            dispose();
        }
    }//GEN-LAST:event_searchTextFieldActionPerformed

    private void searchTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextFieldKeyReleased
        String text = searchTextField.getText().trim();
        if (evt.getKeyCode() == 27) {
            dispose();
            return;
        } else if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            if (itemTable.getRowCount() > 0) {
                itemTable.requestFocus();
                itemTable.setRowSelectionInterval(0, 0);
                return;
            }
        }
        itemTableModel.setRowCount(0);
        int length = text.length();

        if (length < 3) {
            List<Item> items = Find.itemBy$(text, 1);
            fillTable(items);
            selectRow();
        } else {
            int limit = 10;
            try {
                limit = Integer.parseInt(limitTextField.getText().trim());
            } catch (NumberFormatException numberFormatException) {
            }
            List<Item> items = Find.itemBy$(startingRadioButton.isSelected() ? text + "%" : "%" + text + "%", limit);
            Item exactMatchItem = Manager.getInstance().find(Item.class, text);
            if (exactMatchItem != null && !items.contains(exactMatchItem)) {
                items.add(0, exactMatchItem);
            }
            fillTable(items);
            selectRow();
        }


    }//GEN-LAST:event_searchTextFieldKeyReleased

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        TopComponent tc = WindowManager.getDefault().findTopComponent("ItemTopComponent");
        if (tc != null) {
            tc.open();
            tc.requestActive();
        }
        dispose();
    }//GEN-LAST:event_addButtonActionPerformed

    private void itemTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itemTableKeyReleased

    }//GEN-LAST:event_itemTableKeyReleased

    private void itemTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itemTableKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            searchTextField.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            setItem(Manager.getInstance().find(Item.class, itemTable.getValueAt(itemTable.getSelectedRow(), 0).toString()));
            dispose();
        }
    }//GEN-LAST:event_itemTableKeyPressed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_closeButtonActionPerformed
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SearchItemDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchItemDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchItemDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchItemDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                SearchItemDialog dialog = new SearchItemDialog(new javax.swing.JFrame(), true, "");
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton closeButton;
    private javax.swing.JRadioButton containsRadioButton;
    private javax.swing.JTable itemTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField limitTextField;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JRadioButton startingRadioButton;
    // End of variables declaration//GEN-END:variables

    DefaultTableModel itemTableModel;

    private void fillTable(List<Item> items) {
        items.stream().forEach((item1) -> {
            addRow(item1);
        });
    }

    /**
     * @return the item
     */
    public Item getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(Item item) {
        this.item = item;
    }

    private void selectRow() {
        int rowCount = itemTable.getRowCount();
        String searchText = searchTextField.getText().trim();
        for (int i = 0; i < rowCount; i++) {
            if (searchText.equalsIgnoreCase(itemTable.getValueAt(i, 0).toString())) {
                itemTable.setRowSelectionInterval(i, i);
            }
        }
    }

    private void addRow(Item item1) {
        PriceList priceList = item1.getPriceList();
        Stock stock = item1.getStock();
        Object[] row = {
            item1.getCode(),
            item1.getDescription(),
            Format.nf2d.format(priceList == null ? 0 : priceList.getCostPack()),
            Format.nf2d.format(priceList == null ? 0 : priceList.getSellingPack()),
            Format.nf2d.format(stock == null ? 0 : stock.getQuantity())
        };
        itemTableModel.addRow(row);
    }
}
