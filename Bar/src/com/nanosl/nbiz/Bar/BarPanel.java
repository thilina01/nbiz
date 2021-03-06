/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.Bar;

import com.nanosl.lib.db.Manager;
import com.nanosl.nbiz.util.Data;
import com.nanosl.nbiz.util.FindMySql;
import entity.CollectionReceipt;
import entity.Customer;
import entity.Item;
import entity.SaleCash;
import entity.SaleInvoice;
import entity.SaleInvoiceHasItem;
import entity.SaleInvoiceHasItemPK;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.openide.util.Exceptions;

/**
 *
 * @author Thilina
 */
public class BarPanel extends javax.swing.JPanel {

    public static final NumberFormat nf2d = new DecimalFormat("#0.00");
    public static final DateFormat yyyy_MM_dd = new SimpleDateFormat("yyyy-MM-dd");
    DefaultTableModel tableModel;
    Manager manager = Manager.getInstance();
    Collection<Item> items;
    public DefaultTableCellRenderer rightAlignCell = new DefaultTableCellRenderer();

    /**
     * Creates new form BarPanel
     */
    public BarPanel() {
        initComponents();
        rightAlignCell.setHorizontalAlignment(javax.swing.JLabel.RIGHT);
        dateLabel.setText(yyyy_MM_dd.format(new Date()));
        items = manager.find(Item.class);
        tableModel = (DefaultTableModel) table.getModel();
        fillTable();
        codeRadioButton.setSelected(true);
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
        qKeyTextField = new javax.swing.JTextField();
        itemDetailLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        quantityTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        totalAmountTextField = new javax.swing.JTextField();
        totalQuantityTextField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        dateLabel = new javax.swing.JLabel();
        qKeyRadioButton = new javax.swing.JRadioButton();
        codeRadioButton = new javax.swing.JRadioButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        qKeyTextField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        qKeyTextField.setText(org.openide.util.NbBundle.getMessage(BarPanel.class, "BarPanel.jTextField4.text")); // NOI18N
        qKeyTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qKeyTextFieldActionPerformed(evt);
            }
        });

        itemDetailLabel.setBackground(new java.awt.Color(204, 255, 204));
        itemDetailLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        itemDetailLabel.setForeground(new java.awt.Color(255, 0, 51));
        itemDetailLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        org.openide.awt.Mnemonics.setLocalizedText(itemDetailLabel, org.openide.util.NbBundle.getMessage(BarPanel.class, "BarPanel.itemDetailLabel.text")); // NOI18N
        itemDetailLabel.setOpaque(true);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(BarPanel.class, "BarPanel.jLabel3.text")); // NOI18N

        quantityTextField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        quantityTextField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        quantityTextField.setText(org.openide.util.NbBundle.getMessage(BarPanel.class, "BarPanel.jTextField4.text")); // NOI18N
        quantityTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityTextFieldActionPerformed(evt);
            }
        });

        table.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Code", "Item", "Price", "Quantity", "Value"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setPreferredWidth(50);
            table.getColumnModel().getColumn(0).setHeaderValue(org.openide.util.NbBundle.getMessage(BarPanel.class, "BarPanel.table.columnModel.title0")); // NOI18N
            table.getColumnModel().getColumn(1).setPreferredWidth(100);
            table.getColumnModel().getColumn(1).setHeaderValue(org.openide.util.NbBundle.getMessage(BarPanel.class, "BarPanel.table.columnModel.title1")); // NOI18N
            table.getColumnModel().getColumn(2).setPreferredWidth(500);
            table.getColumnModel().getColumn(2).setHeaderValue(org.openide.util.NbBundle.getMessage(BarPanel.class, "BarPanel.table.columnModel.title2")); // NOI18N
            table.getColumnModel().getColumn(3).setHeaderValue(org.openide.util.NbBundle.getMessage(BarPanel.class, "BarPanel.jTable1.columnModel.title4")); // NOI18N
            table.getColumnModel().getColumn(3).setCellRenderer(rightAlignCell);
            table.getColumnModel().getColumn(4).setHeaderValue(org.openide.util.NbBundle.getMessage(BarPanel.class, "BarPanel.jTable1.columnModel.title3")); // NOI18N
            table.getColumnModel().getColumn(4).setCellRenderer(rightAlignCell);
            table.getColumnModel().getColumn(5).setHeaderValue(org.openide.util.NbBundle.getMessage(BarPanel.class, "BarPanel.table.columnModel.title5")); // NOI18N
            table.getColumnModel().getColumn(5).setCellRenderer(rightAlignCell);
        }

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(BarPanel.class, "BarPanel.jLabel4.text")); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel5, org.openide.util.NbBundle.getMessage(BarPanel.class, "BarPanel.jLabel5.text")); // NOI18N

        totalAmountTextField.setEditable(false);
        totalAmountTextField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        totalAmountTextField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        totalAmountTextField.setText(org.openide.util.NbBundle.getMessage(BarPanel.class, "BarPanel.jTextField4.text")); // NOI18N

        totalQuantityTextField.setEditable(false);
        totalQuantityTextField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        totalQuantityTextField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        totalQuantityTextField.setText(org.openide.util.NbBundle.getMessage(BarPanel.class, "BarPanel.totalQuantityTextField.text")); // NOI18N

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nanosl/nbiz/Bar/resources/accept.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jButton1, org.openide.util.NbBundle.getMessage(BarPanel.class, "BarPanel.jButton1.text")); // NOI18N

        dateLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        dateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        org.openide.awt.Mnemonics.setLocalizedText(dateLabel, org.openide.util.NbBundle.getMessage(BarPanel.class, "BarPanel.dateLabel.text")); // NOI18N

        buttonGroup1.add(qKeyRadioButton);
        qKeyRadioButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(qKeyRadioButton, org.openide.util.NbBundle.getMessage(BarPanel.class, "BarPanel.qKeyRadioButton.text")); // NOI18N

        buttonGroup1.add(codeRadioButton);
        codeRadioButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(codeRadioButton, org.openide.util.NbBundle.getMessage(BarPanel.class, "BarPanel.codeRadioButton.text")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(itemDetailLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(qKeyRadioButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(codeRadioButton)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(qKeyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(quantityTextField))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(totalAmountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(totalQuantityTextField))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(qKeyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(totalAmountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateLabel)
                    .addComponent(qKeyRadioButton)
                    .addComponent(codeRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(itemDetailLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(quantityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(totalQuantityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
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

    private void qKeyTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qKeyTextFieldActionPerformed
        itemDetailLabel.setText("Item Detail");
        String qKeyText = qKeyTextField.getText().trim();
        showItemDetail(selectItem(qKeyText));
    }//GEN-LAST:event_qKeyTextFieldActionPerformed

    private void quantityTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityTextFieldActionPerformed
        String itemCodeText = qKeyTextField.getText();
        String quantityText = quantityTextField.getText();
        if (quantityText.equals("")) {
            qKeyTextField.requestFocus();
            qKeyTextField.setSelectionStart(0);
            qKeyTextField.setSelectionEnd(itemCodeText.length());
        }
        itemCodeText = itemCodeText.trim();
        quantityText = quantityText.trim();
        double quantity = 0;
        try {
            quantity = Double.parseDouble(quantityText);
        } catch (NumberFormatException e) {
            return;
        }
        sellItem(selectItem(itemCodeText), quantity);

    }//GEN-LAST:event_quantityTextFieldActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton codeRadioButton;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JLabel itemDetailLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton qKeyRadioButton;
    private javax.swing.JTextField qKeyTextField;
    private javax.swing.JTextField quantityTextField;
    private javax.swing.JTable table;
    private javax.swing.JTextField totalAmountTextField;
    private javax.swing.JTextField totalQuantityTextField;
    // End of variables declaration//GEN-END:variables

    private void showItemDetail(Item item) {
        if (item != null) {
            double price = item.getPriceList().getSellingPack();
            itemDetailLabel.setText(item.getDescription() + " [ " + nf2d.format(price) + " ]");
            quantityTextField.requestFocus();
        } else {
            qKeyTextField.setSelectionStart(0);
            qKeyTextField.setSelectionEnd(qKeyTextField.getText().length());
        }
    }

    private Item selectItem(String qKeyText) {
        for (Item item : items) {
            if (codeRadioButton.isSelected()) {
                if (item.getCode().equals(qKeyText)) {
                    return item;
                }
            } else {
                try {
                    int qKey = item.getQkey() == null ? -1 : item.getQkey();
                    int qKeyInt = Integer.parseInt(qKeyText);
                    if (qKey == qKeyInt) {
                        return (item);
                    }
                } catch (NumberFormatException e) {
                }
            }
        }
        return null;
    }

    private void sellItem(Item item, double quantity) {

        String invoiceNumber = Data.getInvoiceNo();
        String ReceiptNumber = Data.getReceiptNo();
        double price = item.getPriceList().getSellingPack();
        double amount = price * quantity;

        String message = "<html><center> <h2> [  " + item.getDescription() + "  ]<br/> " + nf2d.format(price) + " X " + nf2d.format(quantity) + "<br/>  " + nf2d.format(amount) + " </h2></center></html>";

        int option = JOptionPane.showConfirmDialog(itemDetailLabel, message, nf2d.format(amount), JOptionPane.YES_NO_OPTION);
        if (option != JOptionPane.OK_OPTION) {
            clearFields();
            return;
        }
//        if (invoiceNumber.equals("")) {
//            invoiceNumberField.requestFocus();
//            return;
//        }
        Date date = new Date();
//        if (date == null) {
//            datePicker.requestFocus();
//            return;
//        }

        SaleInvoice saleInvoice = new SaleInvoice(invoiceNumber);
        Customer customer = new Customer("CASH");
        saleInvoice.setCustomer(customer);
        saleInvoice.setAmount(amount);
        saleInvoice.setCredit(0.0);
        saleInvoice.setDiscount(0.0);
        saleInvoice.setInvTime(date);
        saleInvoice.setReceivedAmount(0.0);
        saleInvoice.setEmployee(Data.getOperator().getEmployee());
        List<Serializable> serializables = new ArrayList<Serializable>();
//        for (int i = 0; i < rowCount; i++) {
//            Item item = m.find(Item.class, table.getValueAt(i, 1).toString());
//            double quantity = Double.valueOf(table.getValueAt(i, 4).toString());
//        double price = Double.valueOf(table.getValueAt(i, 3).toString());
//        double discount = Double.valueOf(table.getValueAt(i, 6).toString());
        SaleInvoiceHasItemPK saleInvoiceHasItemPK = new SaleInvoiceHasItemPK(invoiceNumber, item.getCode());
        SaleInvoiceHasItem sihi = new SaleInvoiceHasItem(saleInvoiceHasItemPK);
        sihi.setSaleInvoice(saleInvoice);
        sihi.setQuantity(quantity);
        sihi.setDiscount(0.0);
//        if (item.getStock() == null) {
//            return;
//        }
//        Stock stock = item.getStock();
//        quantity = stock.getQuantity() - quantity;
//        stock.setQuantity(quantity);
        sihi.setItem(item);
        sihi.setCost(item.getPriceList().getCostPack());
        sihi.setRate(price);
        serializables.add(sihi);
//        serializables.add(stock);

        serializables.add(saleInvoice);
//        String paidAmountText = paidAmountField.getText().trim();
//        paidAmountText = paidAmountText.equals("") ? "0" : paidAmountText;
//        double paidAmount = 0;
//        try {
//            paidAmount = Double.parseDouble(paidAmountText);
//        } catch (Exception e) {
//        }
//        if (paidAmount > 0) {
//            if (ReceiptNumber.equals("")) {
////                showError("Recipt Number Required!");
//                return;
//            }
        CollectionReceipt collectionReceipt = new CollectionReceipt(ReceiptNumber);
        collectionReceipt.setCollectedTime(date);
        collectionReceipt.setSaleInvoice(saleInvoice);
        collectionReceipt.setAmount(amount);
        SaleCash saleCash = new SaleCash(ReceiptNumber);
        saleCash.setAmount(amount);
        saleCash.setCollectionReceipt(collectionReceipt);
        collectionReceipt.setSaleCash(saleCash);
        saleInvoice.setReceivedAmount(amount);
        serializables.add(saleCash);
        serializables.add(collectionReceipt);
//        }

        if (manager.update(serializables)) {
//            SaleInvoicePaymentView.getInstance().fill(saleInvoice);
//            SaleInvoicePaymentView.display();
//            Map<String, Object> params = Data.getParams();
//            params.put("invoice", invoiceNumber);
//            Printer.printInvoice(params);
////            showSuccess("Update success");
            Data.setInvoiceNo(invoiceNumber);
            Data.setReceiptNo(ReceiptNumber);
            clear();
        } else {
//            showError("Update failed");
        }
    }

    private void clear() {
        clearFields();
        fillTable();
    }

    private void fillTable() {
        try {
            tableModel.setRowCount(0);
            totalAmountTextField.setText("0.00");
            totalQuantityTextField.setText("0.00");
            ResultSet resultSet = FindMySql.itemTotalSaleBetweenDates(new Date(), new Date());//113, 0, 1
            int rowNumber = 1;
            double totalQuantity = 0, totalAmount = 0;
            while (resultSet.next()) {
                totalQuantity += resultSet.getDouble("quantity");
                totalAmount += resultSet.getDouble("value");
                Object[] row = {
                    rowNumber++,
                    resultSet.getString("code"),
                    resultSet.getString("description"),
                    nf2d.format(resultSet.getDouble("price")),
                    nf2d.format(resultSet.getDouble("quantity")),
                    nf2d.format(resultSet.getDouble("value"))};
                tableModel.addRow(row);
            }

            totalAmountTextField.setText(nf2d.format(totalAmount));
            totalQuantityTextField.setText(nf2d.format(totalQuantity));
        } catch (SQLException ex) {
            Exceptions.printStackTrace(ex);
        }
    }

    private void clearFields() {
        qKeyTextField.setText("");
        quantityTextField.setText("");
        itemDetailLabel.setText("Item Detail");
        qKeyTextField.requestFocus();
    }
}
