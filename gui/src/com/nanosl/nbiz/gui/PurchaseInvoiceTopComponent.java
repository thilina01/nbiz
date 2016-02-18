/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.gui;

import com.nanosl.lib.date.JXDatePicker;
import com.nanosl.nbiz.util.Combo;
import com.nanosl.nbiz.util.FindMySql;
import static com.nanosl.nbiz.util.Format.nf2d;
import com.nanosl.nbiz.util.NTopComponent;
import com.nanosl.nbiz.util.search.SearchItemDialog;
import entity.Item;
import entity.LastCode;
import entity.PriceList;
import entity.PurchaseInvoice;
import entity.PurchaseInvoiceHasItem;
import entity.PurchaseInvoicePK;
import entity.Stock;
import entity.Supplier;
import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.StatusDisplayer;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.TopComponent;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
        dtd = "-//com.nanosl.nbiz.gui//PurchaseInvoice//EN",
        autostore = false)
@TopComponent.Description(
        preferredID = "PurchaseInvoiceTopComponent",
        //iconBase="SET/PATH/TO/ICON/HERE", 
        persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@ActionID(category = "Window", id = "com.nanosl.nbiz.gui.PurchaseInvoiceTopComponent")
@ActionReference(path = "Menu/Purchase" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_PurchaseInvoiceAction",
        preferredID = "PurchaseInvoiceTopComponent")
@Messages({
    "CTL_PurchaseInvoiceAction=PurchaseInvoice",
    "CTL_PurchaseInvoiceTopComponent=PurchaseInvoice Window",
    "HINT_PurchaseInvoiceTopComponent=This is a PurchaseInvoice window"
})
public final class PurchaseInvoiceTopComponent extends NTopComponent {

    static PurchaseInvoiceTopComponent instance;

//    public static PurchaseInvoiceTopComponent getInstance() {
//        if (instance == null) {
//            instance = new PurchaseInvoiceTopComponent();
//        }
//        return instance;
//    }
    static void display() {
        instance.setVisible(true);
    }

    public void fill(String invoiceNumber, String supperCode) {
        PurchaseInvoice purchaseInvoice = manager.find(PurchaseInvoice.class, new PurchaseInvoicePK(invoiceNumber, supperCode));
        if (purchaseInvoice == null) {
            return;
        }
        supplier = purchaseInvoice.getSupplier();
//
//        System.out.println("at fill " + supplier);
        supplierComboBox.setSelectedItem(supplier);
//        System.out.println("at fill after set " + supplier);
//        System.out.println("at fill after set confirm " + supplierComboBox.getSelectedItem());
        dtm.setRowCount(0);
        clearFields();
        for (PurchaseInvoiceHasItem purchaseInvoiceHasItem : purchaseInvoice.getPurchaseInvoiceHasItemCollection()) {
            Item item = purchaseInvoiceHasItem.getItem();
            double cost = purchaseInvoiceHasItem.getCost();
            double quantity = purchaseInvoiceHasItem.getQuantity();
            double freeQuantity = purchaseInvoiceHasItem.getFreeQuantity() == null ? 0 : purchaseInvoiceHasItem.getFreeQuantity();
            double discount = purchaseInvoiceHasItem.getDiscount();
            double sellingPrice = item.getPriceList().getSellingPack();
            double net = cost * quantity;
            double discountAmount = net * discount / 100;
            double amount = net - discountAmount;
            int i = dtm.getRowCount();
            Object[] rowData = {++i,
                item.getCode(),
                item.getDescription(),
                nf2d.format(cost),
                nf3d.format(quantity),
                nf2d.format(net),
                nf2d.format(discountAmount),
                nf2d.format(discount),
                nf2d.format(amount),
                nf2d.format(sellingPrice),
                nf2d.format(freeQuantity)};
            dtm.addRow(rowData);
        }

        invoiceNumberField.setText(invoiceNumber);
        totalAmountLabel.setText(nf2d.format(purchaseInvoice.getAmount()));
        totalDiscountTextField.setText(nf2d.format(purchaseInvoice.getDiscount()));
//        supplierComboBox.setSelectedItem(supplier);

    }

    public PurchaseInvoiceTopComponent() {
        if (instance == null) {
            onLoad();
            setName(Bundle.CTL_PurchaseInvoiceTopComponent());
            setToolTipText(Bundle.HINT_PurchaseInvoiceTopComponent());
            instance = this;
        }
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
        datePicker = new JXDatePicker();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        invoiceNumberField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        supplierComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        itemComboBox = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        quantityField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        costField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        totalAmountLabel = new javax.swing.JLabel();
        processButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        discountField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        stockLabel = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        sellingTextField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        addToExistingRadioButton = new javax.swing.JRadioButton();
        setNewValueRadioButton = new javax.swing.JRadioButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        totalDiscountTextField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        freeField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();

        datePicker.setName("datePicker"); // NOI18N
        datePicker.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                datePickerKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(PurchaseInvoiceTopComponent.class, "PurchaseInvoiceTopComponent.jLabel1.text")); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(PurchaseInvoiceTopComponent.class, "PurchaseInvoiceTopComponent.jLabel2.text")); // NOI18N

        invoiceNumberField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        invoiceNumberField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoiceNumberFieldActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(PurchaseInvoiceTopComponent.class, "PurchaseInvoiceTopComponent.jLabel3.text")); // NOI18N

        supplierComboBox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        supplierComboBox.setName("supplierComboBox"); // NOI18N
        supplierComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplierComboBoxActionPerformed(evt);
            }
        });
        supplierComboBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                supplierComboBoxFocusGained(evt);
            }
        });
        supplierComboBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                supplierComboBoxKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                supplierComboBoxKeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(PurchaseInvoiceTopComponent.class, "PurchaseInvoiceTopComponent.jLabel4.text")); // NOI18N

        itemComboBox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
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
            public void keyReleased(java.awt.event.KeyEvent evt) {
                itemComboBoxKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel5, org.openide.util.NbBundle.getMessage(PurchaseInvoiceTopComponent.class, "PurchaseInvoiceTopComponent.jLabel5.text")); // NOI18N

        quantityField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        quantityField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                quantityFieldMouseClicked(evt);
            }
        });
        quantityField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityFieldActionPerformed(evt);
            }
        });
        quantityField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                quantityFieldFocusGained(evt);
            }
        });
        quantityField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                quantityFieldKeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel6, org.openide.util.NbBundle.getMessage(PurchaseInvoiceTopComponent.class, "PurchaseInvoiceTopComponent.jLabel6.text")); // NOI18N

        costField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        costField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                costFieldMouseClicked(evt);
            }
        });
        costField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                costFieldActionPerformed(evt);
            }
        });
        costField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                costFieldFocusGained(evt);
            }
        });
        costField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                costFieldKeyPressed(evt);
            }
        });

        table.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Code", "Description", "Cost", "Quantity", "Net", "Discount", "D%", "Amount", "Selling", "Free"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setPreferredWidth(30);
            table.getColumnModel().getColumn(0).setHeaderValue(org.openide.util.NbBundle.getMessage(PurchaseInvoiceTopComponent.class, "PurchaseInvoiceTopComponent.table.columnModel.title0")); // NOI18N
            table.getColumnModel().getColumn(1).setHeaderValue(org.openide.util.NbBundle.getMessage(PurchaseInvoiceTopComponent.class, "PurchaseInvoiceTopComponent.table.columnModel.title1")); // NOI18N
            table.getColumnModel().getColumn(2).setPreferredWidth(300);
            table.getColumnModel().getColumn(2).setHeaderValue(org.openide.util.NbBundle.getMessage(PurchaseInvoiceTopComponent.class, "PurchaseInvoiceTopComponent.table.columnModel.title2")); // NOI18N
            table.getColumnModel().getColumn(3).setHeaderValue(org.openide.util.NbBundle.getMessage(PurchaseInvoiceTopComponent.class, "PurchaseInvoiceTopComponent.table.columnModel.title3")); // NOI18N
            table.getColumnModel().getColumn(3).setCellRenderer(rightAlignCell);
            table.getColumnModel().getColumn(4).setHeaderValue(org.openide.util.NbBundle.getMessage(PurchaseInvoiceTopComponent.class, "PurchaseInvoiceTopComponent.table.columnModel.title4")); // NOI18N
            table.getColumnModel().getColumn(4).setCellRenderer(rightAlignCell);
            table.getColumnModel().getColumn(5).setHeaderValue(org.openide.util.NbBundle.getMessage(PurchaseInvoiceTopComponent.class, "PurchaseInvoiceTopComponent.table.columnModel.title5")); // NOI18N
            table.getColumnModel().getColumn(5).setCellRenderer(rightAlignCell);
            table.getColumnModel().getColumn(6).setHeaderValue(org.openide.util.NbBundle.getMessage(PurchaseInvoiceTopComponent.class, "PurchaseInvoiceTopComponent.table.columnModel.title6")); // NOI18N
            table.getColumnModel().getColumn(6).setCellRenderer(rightAlignCell);
            table.getColumnModel().getColumn(7).setHeaderValue(org.openide.util.NbBundle.getMessage(PurchaseInvoiceTopComponent.class, "PurchaseInvoiceTopComponent.table.columnModel.title7")); // NOI18N
            table.getColumnModel().getColumn(7).setCellRenderer(rightAlignCell);
            table.getColumnModel().getColumn(8).setHeaderValue(org.openide.util.NbBundle.getMessage(PurchaseInvoiceTopComponent.class, "PurchaseInvoiceTopComponent.table.columnModel.title8")); // NOI18N
            table.getColumnModel().getColumn(8).setCellRenderer(rightAlignCell);
            table.getColumnModel().getColumn(9).setHeaderValue(org.openide.util.NbBundle.getMessage(PurchaseInvoiceTopComponent.class, "PurchaseInvoiceTopComponent.table.columnModel.title9")); // NOI18N
            table.getColumnModel().getColumn(9).setCellRenderer(rightAlignCell);
            table.getColumnModel().getColumn(10).setHeaderValue(org.openide.util.NbBundle.getMessage(PurchaseInvoiceTopComponent.class, "PurchaseInvoiceTopComponent.table.columnModel.title10")); // NOI18N
        }

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel8, org.openide.util.NbBundle.getMessage(PurchaseInvoiceTopComponent.class, "PurchaseInvoiceTopComponent.jLabel8.text")); // NOI18N

        totalAmountLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        totalAmountLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        totalAmountLabel.setMaximumSize(new java.awt.Dimension(6, 20));
        totalAmountLabel.setMinimumSize(new java.awt.Dimension(6, 20));
        totalAmountLabel.setPreferredSize(null);

        processButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(processButton, org.openide.util.NbBundle.getMessage(PurchaseInvoiceTopComponent.class, "PurchaseInvoiceTopComponent.processButton.text")); // NOI18N
        processButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processButtonActionPerformed(evt);
            }
        });

        clearButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(clearButton, org.openide.util.NbBundle.getMessage(PurchaseInvoiceTopComponent.class, "PurchaseInvoiceTopComponent.clearButton.text")); // NOI18N
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel7, org.openide.util.NbBundle.getMessage(PurchaseInvoiceTopComponent.class, "PurchaseInvoiceTopComponent.jLabel7.text")); // NOI18N

        discountField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        discountField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discountFieldActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel9, org.openide.util.NbBundle.getMessage(PurchaseInvoiceTopComponent.class, "PurchaseInvoiceTopComponent.jLabel9.text")); // NOI18N

        stockLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(stockLabel, org.openide.util.NbBundle.getMessage(PurchaseInvoiceTopComponent.class, "PurchaseInvoiceTopComponent.stockLabel.text")); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel10, org.openide.util.NbBundle.getMessage(PurchaseInvoiceTopComponent.class, "PurchaseInvoiceTopComponent.jLabel10.text")); // NOI18N

        sellingTextField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sellingTextField.setText(org.openide.util.NbBundle.getMessage(PurchaseInvoiceTopComponent.class, "PurchaseInvoiceTopComponent.sellingTextField.text")); // NOI18N
        sellingTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sellingTextFieldActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel11, org.openide.util.NbBundle.getMessage(PurchaseInvoiceTopComponent.class, "PurchaseInvoiceTopComponent.jLabel11.text")); // NOI18N

        buttonGroup1.add(addToExistingRadioButton);
        addToExistingRadioButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(addToExistingRadioButton, org.openide.util.NbBundle.getMessage(PurchaseInvoiceTopComponent.class, "PurchaseInvoiceTopComponent.addToExistingRadioButton.text")); // NOI18N

        buttonGroup1.add(setNewValueRadioButton);
        setNewValueRadioButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(setNewValueRadioButton, org.openide.util.NbBundle.getMessage(PurchaseInvoiceTopComponent.class, "PurchaseInvoiceTopComponent.setNewValueRadioButton.text")); // NOI18N

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton1, org.openide.util.NbBundle.getMessage(PurchaseInvoiceTopComponent.class, "PurchaseInvoiceTopComponent.jRadioButton1.text")); // NOI18N
        jRadioButton1.setEnabled(false);

        totalDiscountTextField.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        totalDiscountTextField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        totalDiscountTextField.setText(org.openide.util.NbBundle.getMessage(PurchaseInvoiceTopComponent.class, "PurchaseInvoiceTopComponent.totalDiscountTextField.text")); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel12, org.openide.util.NbBundle.getMessage(PurchaseInvoiceTopComponent.class, "PurchaseInvoiceTopComponent.jLabel12.text")); // NOI18N

        freeField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        freeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                freeFieldActionPerformed(evt);
            }
        });

        searchButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(searchButton, org.openide.util.NbBundle.getMessage(PurchaseInvoiceTopComponent.class, "PurchaseInvoiceTopComponent.searchButton.text")); // NOI18N
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(itemComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(409, 409, 409))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(supplierComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(invoiceNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(datePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(277, 277, 277))))
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(processButton)
                        .addGap(18, 18, 18)
                        .addComponent(clearButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(totalDiscountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(totalAmountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(stockLabel)
                                .addGap(18, 18, 18)
                                .addComponent(searchButton))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel11)
                                    .addGap(22, 22, 22)
                                    .addComponent(addToExistingRadioButton)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(setNewValueRadioButton)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jRadioButton1))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(quantityField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(costField, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel10)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(sellingTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel7)
                                    .addGap(18, 18, 18)
                                    .addComponent(discountField, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel12)
                                    .addGap(18, 18, 18)
                                    .addComponent(freeField, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {discountField, sellingTextField});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(invoiceNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(supplierComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(datePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(itemComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(searchButton)
                        .addComponent(stockLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(freeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(discountField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(sellingTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(quantityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(costField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(addToExistingRadioButton)
                    .addComponent(setNewValueRadioButton)
                    .addComponent(jRadioButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(totalAmountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(processButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(clearButton))
                    .addComponent(totalDiscountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
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

    private void datePickerKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_datePickerKeyPressed
        if (evt.getKeyCode() == 10) {
            itemComboBox.requestFocus();
        }
    }//GEN-LAST:event_datePickerKeyPressed

    private void invoiceNumberFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoiceNumberFieldActionPerformed
        if (!invoiceNumberField.getText().trim().equals("")) {
            datePicker.requestFocus();
            Supplier selectedSupplier = (Supplier) supplierComboBox.getSelectedItem();
            fill(invoiceNumberField.getText().trim(), selectedSupplier.getCode());
        }
    }//GEN-LAST:event_invoiceNumberFieldActionPerformed

    private void supplierComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplierComboBoxActionPerformed
        fillItems();
        Object o = supplierComboBox.getSelectedItem();
        if (o instanceof Supplier) {
            supplier = (Supplier) o;
        }
    }//GEN-LAST:event_supplierComboBoxActionPerformed

    private void supplierComboBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_supplierComboBoxKeyPressed
        if (evt.getKeyCode() == 10) {
            invoiceNumberField.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_F2) {
            searchSupplier();
        }
    }//GEN-LAST:event_supplierComboBoxKeyPressed

    private void supplierComboBoxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_supplierComboBoxKeyReleased
    }//GEN-LAST:event_supplierComboBoxKeyReleased

    private void itemComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemComboBoxActionPerformed
        Item item = (Item) itemComboBox.getSelectedItem();
        if (item == null) {
            return;
        }
        PriceList priceList = item.getPriceList();
        manager.clearCache();
//        Stock stock = manager.find(Stock.class, item.getCode());
        double quantity = FindMySql.quantityByItemCode(item.getCode());
//        double quantity = stock.getQuantity() == null ? 0 : item.getStock().getQuantity();
        stockLabel.setText(nf2d.format(quantity));
        fillPrice();
    }//GEN-LAST:event_itemComboBoxActionPerformed

    private void itemComboBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itemComboBoxKeyPressed
        if (evt.getKeyCode() == 10) {
            fillPrice();
            quantityField.selectAll();
            quantityField.requestFocus();
        }
    }//GEN-LAST:event_itemComboBoxKeyPressed

    private void itemComboBoxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itemComboBoxKeyReleased
    }//GEN-LAST:event_itemComboBoxKeyReleased

    private void quantityFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quantityFieldMouseClicked
        if (evt.getButton() == 3) {
            dozToItem();
        }
    }//GEN-LAST:event_quantityFieldMouseClicked

    private void quantityFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityFieldActionPerformed
        try {
            double quantity = Double.valueOf(quantityField.getText().trim());
            if (quantity != 0) {
                costField.selectAll();
                costField.requestFocus();
            }
        } catch (NumberFormatException numberFormatException) {
        }
    }//GEN-LAST:event_quantityFieldActionPerformed

    private void quantityFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_quantityFieldFocusGained
        StatusDisplayer.getDefault().setStatusText("Hint: F2 for DOZ");
    }//GEN-LAST:event_quantityFieldFocusGained

    private void quantityFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantityFieldKeyPressed
        if (evt.getKeyCode() == 113) {
            dozToItem();
        }
    }//GEN-LAST:event_quantityFieldKeyPressed

    private void costFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_costFieldMouseClicked
        //        System.out.println(evt.getButton());
        if (evt.getButton() == 3) {
            dozPriceToItemPrice();
        }
    }//GEN-LAST:event_costFieldMouseClicked

    private void costFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_costFieldActionPerformed
        sellingTextField.selectAll();
        sellingTextField.requestFocus();
    }//GEN-LAST:event_costFieldActionPerformed

    private void costFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_costFieldFocusGained
        StatusDisplayer.getDefault().setStatusText("Hint: F2 for DOZ");
    }//GEN-LAST:event_costFieldFocusGained

    private void costFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_costFieldKeyPressed
        //        System.out.println(evt.getKeyCode());
        if (evt.getKeyCode() == 113) {
            dozPriceToItemPrice();
        }
    }//GEN-LAST:event_costFieldKeyPressed

    private void tableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableKeyReleased
        if (evt.getKeyCode() == 127) {
            if (table.getSelectedRow() > -1) {
                dtm.removeRow(table.getSelectedRow());
                calcTotal();
            }
        }
    }//GEN-LAST:event_tableKeyReleased

    private void processButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processButtonActionPerformed
        process();
    }//GEN-LAST:event_processButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        clear();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void discountFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discountFieldActionPerformed
        addToTable();
    }//GEN-LAST:event_discountFieldActionPerformed

    private void sellingTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sellingTextFieldActionPerformed
        addToTable();
    }//GEN-LAST:event_sellingTextFieldActionPerformed

    private void supplierComboBoxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_supplierComboBoxFocusGained
//        searchSupplier();
    }//GEN-LAST:event_supplierComboBoxFocusGained

    private void freeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_freeFieldActionPerformed
        addToTable();
    }//GEN-LAST:event_freeFieldActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        searchItem("");
    }//GEN-LAST:event_searchButtonActionPerformed
    private void searchItem(String c) {
        SearchItemDialog searchItemDialog = new SearchItemDialog(null, true, c + "");
        Item item = searchItemDialog.getItem();
        if (item != null) {
            itemComboBox.setSelectedItem(item);
            quantityField.requestFocus();
        } else {
            itemComboBox.requestFocus();
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton addToExistingRadioButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton clearButton;
    private javax.swing.JTextField costField;
    private org.jdesktop.swingx.JXDatePicker datePicker;
    private javax.swing.JTextField discountField;
    private javax.swing.JTextField freeField;
    private javax.swing.JTextField invoiceNumberField;
    private javax.swing.JComboBox itemComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton processButton;
    private javax.swing.JTextField quantityField;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField sellingTextField;
    private javax.swing.JRadioButton setNewValueRadioButton;
    private javax.swing.JLabel stockLabel;
    private javax.swing.JComboBox supplierComboBox;
    private javax.swing.JTable table;
    private javax.swing.JLabel totalAmountLabel;
    private javax.swing.JTextField totalDiscountTextField;
    // End of variables declaration//GEN-END:variables
    DefaultTableModel dtm;
    DefaultComboBoxModel<Supplier> supplierComboBoxModel;
    DefaultComboBoxModel<Supplier> itemComboBoxModel;
//    SwingWorker<DefaultComboBoxModel, Supplier> supplierComboBoxWorker = new SwingWorker<DefaultComboBoxModel, Supplier>() {
//        @Override
//        protected DefaultComboBoxModel doInBackground() throws Exception {
//            return Combo.getSupplierComboBoxModel();
//        }
//
//        @Override
//        protected void done() {
//            try {
//                supplierComboBox.setModel(get());
//            } catch (InterruptedException | ExecutionException ignore) {
//            }
//        }
//    };
//    SwingWorker<DefaultComboBoxModel, Supplier> itemComboBoxWorker = new SwingWorker<DefaultComboBoxModel, Supplier>() {
//        @Override
//        protected DefaultComboBoxModel doInBackground() throws Exception {
//            return Combo.getSupplierComboBoxModel();
//        }
//
//        @Override
//        protected void done() {
//            try {
//                supplierComboBox.setModel(get());
//            } catch (InterruptedException | ExecutionException ignore) {
//            }
//        }
//    };

    protected void onLoad() {
        initComponents();
        datePicker.setFormats(yyyy_MM_dd);
        KeyAdapter();
        dtm = (DefaultTableModel) table.getModel();
        table.setDefaultRenderer(Object.class, coloredCellRenderer);
        clear();
//        Utilities.attachInitJob(supplierComboBox, new AsyncGUIJob() {
//            @Override
//            public void construct() {
//                supplierComboBoxModel = Combo.getSupplierComboBoxModel();
//            }
//
//            @Override
//            public void finished() {
//                supplierComboBox.setModel(supplierComboBoxModel);
//            }
//        });
    }

    private void clear() {
        dtm.setRowCount(0);
//        Combo.fillSuppliers(supplierComboBox, null);
//        supplierComboBoxWorker.execute();
        clearFields();
        processButton.setEnabled(true);
    }

    private void fillItems() {
        Supplier supplier = (Supplier) supplierComboBox.getSelectedItem();
        supplier = manager.find(Supplier.class, supplier.getCode());
        if (supplier.getCode().equals("000")) {
            LastCode lastCode = manager.find(LastCode.class, "SUPPLIERINVOICE");
            if (lastCode == null) {
                lastCode = new LastCode("SUPPLIERINVOICE");
                lastCode.setCode("000");
                manager.update(lastCode);
            }
            lastCode = manager.find(LastCode.class, "SUPPLIERINVOICE");
            invoiceNumberField.setText(lastCode.getCode());
        }
        itemComboBox.setModel(new DefaultComboBoxModel(supplier.getItemCollection().toArray()));
    }

    private void calcTotal() {
        double totalDiscount = 0;
        double totalAmount = 0;
        for (int i = 0; i < table.getRowCount(); i++) {
            totalDiscount += Double.valueOf(table.getValueAt(i, 6).toString());
            totalAmount += Double.valueOf(table.getValueAt(i, 8).toString());
        }
        totalDiscountTextField.setText(nf2d.format(totalDiscount));
        totalAmountLabel.setText(nf2d.format(totalAmount));
    }

    private void process() {
        int rowCount = table.getRowCount();
        if (rowCount == 0) {
            return;
        }
        String invoiceNumber = invoiceNumberField.getText().trim();
        if (invoiceNumber.equals("")) {
            invoiceNumber = "000";
        }
        Date date = datePicker.getDate();
        if (date == null) {
            datePicker.requestFocus();
            showError("Invoice Date Required");
            return;
        }
        Supplier supplier = (Supplier) supplierComboBox.getSelectedItem();
        PurchaseInvoice purchaseInvoice = manager.find(PurchaseInvoice.class, new PurchaseInvoicePK(invoiceNumber, supplier.getCode()));//new PurchaseInvoice(invoiceNumber, supplier.getCode());
        if (purchaseInvoice != null) {
            showError("Invoice Already Updated!");
            return;
        }
        double invoiveAmount = Double.valueOf(totalAmountLabel.getText());
        double invoiceDiscount = Double.valueOf(totalDiscountTextField.getText());
        purchaseInvoice = new PurchaseInvoice(invoiceNumber, supplier.getCode());
        purchaseInvoice.setSupplier(supplier);
        purchaseInvoice.setAmount(invoiveAmount);
        purchaseInvoice.setCredit(invoiveAmount);
        purchaseInvoice.setDiscount(invoiceDiscount);
        purchaseInvoice.setInvDate(date);
        purchaseInvoice.setPurchaseInvoiceHasItemCollection(new ArrayList<PurchaseInvoiceHasItem>());

        List<Serializable> serializables = new ArrayList<>();
        for (int i = 0; i < rowCount; i++) {
            Item item = manager.find(Item.class, table.getValueAt(i, 1).toString());
            double value = Double.valueOf(table.getValueAt(i, 3).toString());
            double quantity = Double.valueOf(table.getValueAt(i, 4).toString());
            double freeQuantity = Double.valueOf(table.getValueAt(i, 10).toString());
            double discount = Double.valueOf(table.getValueAt(i, 7).toString());
            double selling = Double.valueOf(table.getValueAt(i, 9).toString());
            double cost = value - (value * discount / 100);
            PurchaseInvoiceHasItem pihi = new PurchaseInvoiceHasItem(invoiceNumber, supplier.getCode(), item.getCode());
            pihi.setPurchaseInvoice(purchaseInvoice);
            pihi.setItem(item);
            pihi.setCost(cost);
            pihi.setQuantity(quantity);
            pihi.setFreeQuantity(freeQuantity);
            pihi.setDiscount(discount);
            Stock stock = item.getStock();
            if (stock == null) {
                stock = new Stock(item.getCode());
                stock.setQuantity(0.0);
            }
            quantity = stock.getQuantity() == 0 ? quantity + freeQuantity : stock.getQuantity() + quantity + freeQuantity;
            stock.setQuantity(quantity);
            item.setStock(stock);
            pihi.setItem(item);
            purchaseInvoice.getPurchaseInvoiceHasItemCollection().add(pihi);
            PriceList priceList = item.getPriceList();
            priceList = priceList == null ? new PriceList(item.getCode()) : priceList;
            priceList.setCostPack(cost);
            priceList.setSellingPack(selling);
            serializables.add(priceList);
            serializables.add(item);
            serializables.add(pihi);
            serializables.add(stock);
        }
        if (supplier.getCode().equals("000")) {
            LastCode lastCode = manager.find(LastCode.class, "SUPPLIERINVOICE");
            lastCode.setCode(invoiceNumber);
            serializables.add(lastCode);
        }
        serializables.add(purchaseInvoice);
        if (manager.update(serializables)) {
            clear();
            showSuccess("Update Success");
        }
    }

    private void clearFields() {
        invoiceNumberField.setText("");
        quantityField.setText("");
        costField.setText("");
        totalAmountLabel.setText("");
        totalDiscountTextField.setText("");
        stockLabel.setText("stock");
        datePicker.setDate(new Date());
    }

    private void addToTable() {
        double quantity = 0;
        double cost = 0;
        double discount = 0;
        double sellingPrice = 0;
        double free = 0;
        Item item = (Item) itemComboBox.getSelectedItem();

        if (item == null) {
            return;
        }
        String code = item.getCode();
        String description = item.getDescription();
        try {
            quantity = Double.valueOf(quantityField.getText());
        } catch (NumberFormatException e) {
        }
        try {
            free = Double.valueOf(freeField.getText());
        } catch (NumberFormatException e) {
        }
        try {
            cost = Double.valueOf(costField.getText().trim());
        } catch (NumberFormatException e) {
        }
        for (int i = 0; i < table.getRowCount(); i++) {

            if (description.equalsIgnoreCase("OTHER")) {
                break;
            }
            if (code.equals(table.getValueAt(i, 1))) {
                if (setNewValueRadioButton.isSelected()) {
                    dtm.removeRow(i);
                } else if (addToExistingRadioButton.isSelected()) {
                    double existingCost = Double.parseDouble(table.getValueAt(i, 3).toString());
                    double existingQuantity = Double.parseDouble(table.getValueAt(i, 4).toString());
                    cost = ((existingCost * existingQuantity) + (cost * quantity)) / (quantity + existingQuantity);
                    quantity += existingQuantity;
                    dtm.removeRow(i);
                } else {
                    showError("Select option for duplictes");
                    return;
                }
                break;
            }
        }
        try {
            discount = Double.valueOf(discountField.getText().trim());
        } catch (NumberFormatException e) {
        }
        try {
            sellingPrice = Double.valueOf(sellingTextField.getText().trim());
        } catch (NumberFormatException e) {
        }
        if (quantity == 0) {
            showError("Quantity Required");
            return;
        }
        if (cost == 0) {
            showError("No cost value");
            showError("No cost value");
            return;
        }
        double net = cost * quantity;
        double discountAmount = net * discount / 100;
        double amount = net - discountAmount;
        int i = dtm.getRowCount();
        Object[] rowData = {++i,
            item.getCode(),
            item.getDescription(),
            nf2d.format(cost),
            nf3d.format(quantity),
            nf2d.format(net),
            nf2d.format(discountAmount),
            nf2d.format(discount),
            nf2d.format(amount),
            nf2d.format(sellingPrice),
            nf2d.format(free)};
        dtm.addRow(rowData);
        quantityField.setText("");
        costField.setText("");
        sellingTextField.setText("");
        discountField.setText("");
        freeField.setText("");
        itemComboBox.requestFocus();
        calcTotal();
    }

    private void KeyAdapter() {
        AutoCompleteDecorator.decorate(supplierComboBox);
        AutoCompleteDecorator.decorate(itemComboBox);
        setComboBoxKeyAdapters(supplierComboBox);
        setComboBoxKeyAdapters(itemComboBox);
        setComboBoxKeyAdapters(datePicker);
    }

    private void setComboBoxKeyAdapters(JComponent comp) {
        String compName = comp.getName();
        if (compName == null) {
            return;
        }
        Component component[] = comp.getComponents();
        for (Component component1 : component) {
            switch (compName) {
                case "supplierComboBox":
                    component1.addKeyListener(supplierComboBoxKeyAdapter);
                    break;
                case "itemComboBox":
                    component1.addKeyListener(itemComboBoxKeyAdapter);
                    break;
                case "datePicker":
                    component1.addKeyListener(datePickerKeyAdapter);
                    break;
            }
        }
    }
    KeyAdapter datePickerKeyAdapter = new java.awt.event.KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent evt) {
            datePickerKeyPressed(evt);
        }
    };
    KeyAdapter supplierComboBoxKeyAdapter = new java.awt.event.KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent evt) {
            supplierComboBoxKeyPressed(evt);
        }
    };
    KeyAdapter itemComboBoxKeyAdapter = new java.awt.event.KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent evt) {
            itemComboBoxKeyPressed(evt);
        }
    };

    private void fillPrice() {
        Object o = itemComboBox.getSelectedItem();
        if (o != null && o instanceof Item) {
            Item item = (Item) o;
            PriceList priceList = item.getPriceList();
            double cost = 0.0, selling = 0.0;
            if (priceList != null) {
                if (priceList.getCostPack() != null) {
                    cost = priceList.getCostPack();
                }
                if (priceList.getSellingPack() != null) {
                    selling = priceList.getSellingPack();
                }
                costField.setText(cost + "");
                sellingTextField.setText(selling + "");
            }
        }
    }

    private void searchSupplier() {
        SearchSupplierDialog searchSupplierDialog = new SearchSupplierDialog(null, true);
        Supplier localSupplier = searchSupplierDialog.suppllier;
        if (localSupplier != null) {
            supplierComboBox.setSelectedItem(localSupplier);
            invoiceNumberField.requestFocus();
        } else {
            supplierComboBox.requestFocus();
        }
    }
    Supplier supplier;

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
//        if (!b) {
//            Object o = supplierComboBox.getSelectedItem();
//            supplier = o instanceof Supplier ? (Supplier) o : null;
//            System.out.println("at setvisible !b " + supplier);
//        }
//        System.out.println("at setvisible " + supplier);
        Combo.fillSuppliers(supplierComboBox, supplier);
        if (supplier != null) {
//            supplier = manager.find(Supplier.class, supplier.getCode());
            supplierComboBox.setSelectedItem(supplier);
            itemComboBox.setModel(new DefaultComboBoxModel(supplier.getItemCollection().toArray()));
        }
    }

    private void dozPriceToItemPrice() {
        String dozPriceText = JOptionPane.showInputDialog(this, "DOZ Price");
        try {
            double dozPrice = Double.parseDouble(dozPriceText);
            costField.setText((nf2d.format(dozPrice / 12)) + "");
        } catch (Exception e) {
        }
    }

    private void dozToItem() {
        String dozText = JOptionPane.showInputDialog(this, "DOZ Count");
        try {
            double doz = Double.parseDouble(dozText);
            quantityField.setText((nf2d.format(doz * 12)) + "");
        } catch (Exception e) {
        }
    }

    @Override
    public void componentOpened() {
        supplierComboBox.requestFocus();
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
//
//    public void fillInvoice(String invoiceNumber, String supplierCode) {
//        PurchaseInvoice existingPurchaseInvoice = manager.find(PurchaseInvoice.class, new PurchaseInvoicePK(invoiceNumber, supplierCode));
//        if (existingPurchaseInvoice != null) {
//            datePicker.setDate(existingPurchaseInvoice.getInvDate());
//            totalAmountLabel.setText(nf2d.format(existingPurchaseInvoice.getAmount()));
//            totalDiscountTextField.setText(nf2d.format(existingPurchaseInvoice.getDiscount()));
//            Collection<PurchaseInvoiceHasItem> purchaseInvoiceHasItems = existingPurchaseInvoice.getPurchaseInvoiceHasItemCollection();
//            dtm.setRowCount(0);
//            int r = 0;
//            for (PurchaseInvoiceHasItem purchaseInvoiceHasItem : purchaseInvoiceHasItems) {
//                double cost = purchaseInvoiceHasItem.getCost();
//                double quantity = purchaseInvoiceHasItem.getQuantity();
//                double net = cost * quantity;
//                double discount = purchaseInvoiceHasItem.getDiscount();
//                double amount = net - discount;
//                double selling = purchaseInvoiceHasItem.getItem().getPriceList().getSellingPack();
//
//                Object[] row = {
//                    nf3p.format(++r),
//                    purchaseInvoiceHasItem.getItem().getCode(),
//                    purchaseInvoiceHasItem.getItem().getDescription(),
//                    nf2d.format(cost),
//                    nf2d.format(quantity),
//                    nf2d.format(net),
//                    nf2d.format(discount),
//                    nf2d.format(discount / amount * 100),
//                    nf2d.format(amount),
//                    nf2d.format(selling)
//
//                };
//                dtm.addRow(row);
//            }
//        }
//    }
}
