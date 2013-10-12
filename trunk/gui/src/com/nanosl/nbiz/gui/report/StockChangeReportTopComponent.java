/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.gui.report;

import com.nanosl.nbiz.util.NTopComponent;
import entity.Item;
import entity.StockChange;
import entity.StockChangeSummery;
import java.util.Date;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.windows.TopComponent;
import org.openide.util.NbBundle.Messages;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
        dtd = "-//com.nanosl.nbiz.gui.report//StockChangeReport//EN",
        autostore = false)
@TopComponent.Description(
        preferredID = "StockChangeReportTopComponent",
        //iconBase="SET/PATH/TO/ICON/HERE", 
        persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@ActionID(category = "Window", id = "com.nanosl.nbiz.gui.report.StockChangeReportTopComponent")
@ActionReference(path = "Menu/Report" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_StockChangeReportAction",
        preferredID = "StockChangeReportTopComponent")
@Messages({
    "CTL_StockChangeReportAction=StockChangeReport",
    "CTL_StockChangeReportTopComponent=StockChangeReport Window",
    "HINT_StockChangeReportTopComponent=This is a StockChangeReport window"
})
public final class StockChangeReportTopComponent extends NTopComponent {

    public StockChangeReportTopComponent() {
        onLoad();
        setName(Bundle.CTL_StockChangeReportTopComponent());
        setToolTipText(Bundle.HINT_StockChangeReportTopComponent());

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
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        jLabel3 = new javax.swing.JLabel();
        totalLabel = new javax.swing.JLabel();

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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
        masterTable.getColumnModel().getColumn(0).setPreferredWidth(30);
        masterTable.getColumnModel().getColumn(0).setHeaderValue(org.openide.util.NbBundle.getMessage(StockChangeReportTopComponent.class, "StockChangeReportTopComponent.masterTable.columnModel.title0")); // NOI18N
        masterTable.getColumnModel().getColumn(1).setHeaderValue(org.openide.util.NbBundle.getMessage(StockChangeReportTopComponent.class, "StockChangeReportTopComponent.masterTable.columnModel.title1")); // NOI18N
        masterTable.getColumnModel().getColumn(2).setPreferredWidth(150);
        masterTable.getColumnModel().getColumn(2).setHeaderValue(org.openide.util.NbBundle.getMessage(StockChangeReportTopComponent.class, "StockChangeReportTopComponent.masterTable.columnModel.title2")); // NOI18N
        masterTable.getColumnModel().getColumn(3).setHeaderValue(org.openide.util.NbBundle.getMessage(StockChangeReportTopComponent.class, "StockChangeReportTopComponent.masterTable.columnModel.title3")); // NOI18N
        masterTable.getColumnModel().getColumn(3).setCellRenderer(rightAlignCell);
        masterTable.getColumnModel().getColumn(4).setHeaderValue(org.openide.util.NbBundle.getMessage(StockChangeReportTopComponent.class, "StockChangeReportTopComponent.masterTable.columnModel.title4")); // NOI18N
        masterTable.getColumnModel().getColumn(4).setCellRenderer(rightAlignCell);
        masterTable.getColumnModel().getColumn(5).setHeaderValue(org.openide.util.NbBundle.getMessage(StockChangeReportTopComponent.class, "StockChangeReportTopComponent.masterTable.columnModel.title5")); // NOI18N
        masterTable.getColumnModel().getColumn(5).setCellRenderer(rightAlignCell);
        masterTable.getColumnModel().getColumn(6).setHeaderValue(org.openide.util.NbBundle.getMessage(StockChangeReportTopComponent.class, "StockChangeReportTopComponent.masterTable.columnModel.title6")); // NOI18N
        masterTable.getColumnModel().getColumn(6).setCellRenderer(rightAlignCell);
        masterTable.getColumnModel().getColumn(7).setHeaderValue(org.openide.util.NbBundle.getMessage(StockChangeReportTopComponent.class, "StockChangeReportTopComponent.masterTable.columnModel.title7")); // NOI18N
        masterTable.getColumnModel().getColumn(7).setCellRenderer(rightAlignCell);

        jXDatePicker1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXDatePicker1ActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(StockChangeReportTopComponent.class, "StockChangeReportTopComponent.jLabel3.text")); // NOI18N

        totalLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        totalLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        org.openide.awt.Mnemonics.setLocalizedText(totalLabel, org.openide.util.NbBundle.getMessage(StockChangeReportTopComponent.class, "StockChangeReportTopComponent.totalLabel.text")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(totalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 849, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(totalLabel)
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

    private void jXDatePicker1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXDatePicker1ActionPerformed
        fill();
    }//GEN-LAST:event_jXDatePicker1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    private javax.swing.JScrollPane masterScrollPane;
    private javax.swing.JTable masterTable;
    private javax.swing.JLabel totalLabel;
    // End of variables declaration//GEN-END:variables
  
    DefaultTableModel tableModel;

    private void fillTable() {
        tableModel.setRowCount(0);
        Date date = jXDatePicker1.getDate();
        StockChangeSummery stockChangeSummery = m.find(StockChangeSummery.class, date);
        if (stockChangeSummery == null) {
            return;

        }
        int i = 0;
        for (Iterator<StockChange> it = stockChangeSummery.getStockChangeCollection().iterator(); it.hasNext();) {
            StockChange stockChange = it.next();
            Item item = stockChange.getItem();
            double oldQuantity = stockChange.getOldQuantity() == null ? 0 : stockChange.getOldQuantity();
            double actualQuantity = stockChange.getActualQuantity() == null ? 0 : stockChange.getActualQuantity();
            double rate = stockChange.getRate() == null ? 0 : stockChange.getRate();
            double deferent = oldQuantity - actualQuantity;
            Object[] row = {++i, item.getCode(), item.getDescription(), oldQuantity, actualQuantity, deferent, rate, nf2d.format(deferent * rate)};
            tableModel.addRow(row);
        }
        calcTotal();
    }

    protected void onLoad() {
        initComponents();
        tableModel = (DefaultTableModel) masterTable.getModel();
        masterTable.setDefaultRenderer(Object.class, coloredCellRenderer);
       
    }

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
    }

    private void fill() {
        fillTable();
        calcTotal();
    }

    private void calcTotal() {
        double total = 0;
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            total += Double.valueOf(tableModel.getValueAt(i, 7).toString());
        }
        totalLabel.setText(total + "");
    }
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
