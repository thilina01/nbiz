/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.gui.report;

import com.nanosl.nbiz.util.NTopComponent;
import entity.Item;
import entity.PurchaseInvoice;
import entity.PurchaseInvoiceHasItem;
import java.util.Calendar;
import java.util.Collection;
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
        dtd = "-//com.nanosl.nbiz.gui.report//AveragePrice//EN",
        autostore = false)
@TopComponent.Description(
        preferredID = "AveragePriceTopComponent",
        //iconBase="SET/PATH/TO/ICON/HERE", 
        persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@ActionID(category = "Window", id = "com.nanosl.nbiz.gui.report.AveragePriceTopComponent")
@ActionReference(path = "Menu/Report" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_AveragePriceAction",
        preferredID = "AveragePriceTopComponent")
@Messages({
    "CTL_AveragePriceAction=AveragePrice",
    "CTL_AveragePriceTopComponent=AveragePrice Window",
    "HINT_AveragePriceTopComponent=This is a AveragePrice window"
})
public final class AveragePriceTopComponent extends NTopComponent {

    public AveragePriceTopComponent() {
        onLoad();
        setName(Bundle.CTL_AveragePriceTopComponent());
        setToolTipText(Bundle.HINT_AveragePriceTopComponent());

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
        datePicker = new org.jdesktop.swingx.JXDatePicker();
        jLabel2 = new javax.swing.JLabel();

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        masterTable.setAutoCreateRowSorter(true);
        masterTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Code", "Description", "Min", "Max", "Average"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

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

        datePicker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datePickerActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(AveragePriceTopComponent.class, "AveragePriceTopComponent.jLabel2.text")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 884, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(datePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(datePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
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

    private void datePickerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datePickerActionPerformed
        fillTable();
    }//GEN-LAST:event_datePickerActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXDatePicker datePicker;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane masterScrollPane;
    private javax.swing.JTable masterTable;
    // End of variables declaration//GEN-END:variables
    DefaultTableModel tableModel;

    private void fillTable() {
        Date date = datePicker.getDate();
        Calendar firstCalendar = Calendar.getInstance();
        Calendar lastCalendar = Calendar.getInstance();
        firstCalendar.setTime(date);
        firstCalendar.set(Calendar.DATE, 1);
        lastCalendar.setTime(date);
        lastCalendar.set(Calendar.DATE, lastCalendar.getMaximum(Calendar.DATE));
        lastCalendar.set(Calendar.HOUR, 23);

        tableModel.setRowCount(0);
        int i = 0;
        double tot = 0;
//        Query qry = man.getEm().createQuery("SELECT i FROM Item i");
//        qry.setParameter("invDate", date);
        Collection<Item> items = m.find(Item.class);
        for (Iterator<Item> it = items.iterator(); it.hasNext();) {
            Item item = it.next();
            Collection<PurchaseInvoiceHasItem> purchaseInvoiceHasItems = item.getPurchaseInvoiceHasItemCollection();
            double max, min;
            max = 0;
            min = Double.MAX_VALUE;
            for (Iterator<PurchaseInvoiceHasItem> it1 = purchaseInvoiceHasItems.iterator(); it1.hasNext();) {
                PurchaseInvoiceHasItem purchaseInvoiceHasItem = it1.next();
                PurchaseInvoice purchaseInvoice = purchaseInvoiceHasItem.getPurchaseInvoice();
                Date invoiceDate = purchaseInvoice.getInvDate();
                if (invoiceDate.after(firstCalendar.getTime()) && invoiceDate.before(lastCalendar.getTime())) {
                    double costPrice = purchaseInvoiceHasItem.getCost();
                    if (max < costPrice) {
                        max = costPrice;
                    }
                    if (min > costPrice) {
                        min = costPrice;
                    }
                }
            }
            Object[] row = {++i, item.getCode(), item.getDescription(), nf2d.format(min == Double.MAX_VALUE ? 0 : min), nf2d.format(max), nf2d.format(max == 0 || min == Double.MAX_VALUE ? max + min == Double.MAX_VALUE ? 0 : min : (max + min) / 2)};//
            tableModel.addRow(row);
        }
//        Collection<StockTransfer> stockTransfers = employee.getStockTransferCollection();

//        for (Iterator<StockTransfer> it = stockTransfers.iterator(); it.hasNext();) {
//            StockTransfer stockTransfer = it.next();
//            if (yyyy_MM_dd.format(stockTransfer.getStockTransferPK().getTransferDate()).equals(yyyy_MM_dd.format(date))) {
//                Item item = stockTransfer.getItem();
//                PriceList priceList = item.getPriceList();
//                double selling = priceList == null ? 0.0 : priceList.getSellingPack() == null ? 0.0 : priceList.getSellingPack();
//                tot += selling;
//                double qty = stockTransfer.getQuantity();
//                Object[] row = {++i, item.getCode(), stockTransfer.getItem().getDescription(), nf3d.format(qty), nf2d.format(selling), nf2d.format(qty * selling)};
//                tableModel.addRow(row);
//            }
//        }
    }

    protected void onLoad() {
        initComponents();
        tableModel = (DefaultTableModel) masterTable.getModel();
    }

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
        clear();

    }

    private void clear() {
        tableModel.setRowCount(0);
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
