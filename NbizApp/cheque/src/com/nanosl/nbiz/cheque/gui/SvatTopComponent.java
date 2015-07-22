/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.cheque.gui;

import com.nanosl.lib.date.JXDatePicker;
import com.nanosl.nbiz.cheque.NumberToWordsConverter;
import com.nanosl.nbiz.util.Combo;
import com.nanosl.nbiz.util.Data;
import static com.nanosl.nbiz.util.Format.nf2d;
import static com.nanosl.nbiz.util.Format.nf2dComma;
import static com.nanosl.nbiz.util.Format.yyyy_MM_dd;
import com.nanosl.nbiz.util.NTopComponent;
import com.nanosl.nbiz.util.Printer;
import entity.Company;
import entity.Supplier;
import entity.Svat;
import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.JComponent;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.TopComponent;
import query.Find;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
        dtd = "-//com.nanosl.nbiz.cheque.gui//Svat//EN",
        autostore = false
)
@TopComponent.Description(
        preferredID = "SvatTopComponent",
        //iconBase="SET/PATH/TO/ICON/HERE", 
        persistenceType = TopComponent.PERSISTENCE_ALWAYS
)
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@ActionID(category = "Window", id = "com.nanosl.nbiz.cheque.gui.SvatTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_SvatAction",
        preferredID = "SvatTopComponent"
)
@Messages({
    "CTL_SvatAction=Svat",
    "CTL_SvatTopComponent=Svat Window",
    "HINT_SvatTopComponent=This is a Svat window"
})
public final class SvatTopComponent extends NTopComponent {

    public SvatTopComponent() {
        onLoad();
    }

    private void onLoad() {

        initComponents();
        setName(Bundle.CTL_SvatTopComponent());
        setToolTipText(Bundle.HINT_SvatTopComponent());
        KeyAdapter();
        tableModel = (DefaultTableModel) masterTable.getModel();
        masterTable.setDefaultRenderer(Object.class, coloredCellRenderer);
    }

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
//        if (!b) {
//            Object o = supplierComboBox.getSelectedItem();
//            supplier = o instanceof Supplier ? (Supplier) o : null;
//            System.out.println("at setvisible !b " + supplier);
//        }
//        System.out.println("at setvisible " + supplier);
        Combo.fillSuppliers(supplierComboBox, null);
        fill();
    }
    DefaultTableModel tableModel;

    private void KeyAdapter() {
        AutoCompleteDecorator.decorate(supplierComboBox);
        setComboBoxKeyAdapters(datePicker);
        setComboBoxKeyAdapters(supplierComboBox);
    }

    private void setComboBoxKeyAdapters(JComponent comp) {
        String compName = comp.getName();
        Component component[] = comp.getComponents();
        for (Component component1 : component) {
            switch (compName) {

                case "datePicker":
                    component1.addKeyListener(datePickerKeyAdapter);
                    break;
                case "supplierComboBox":
                    component1.addKeyListener(supplierComboBoxKeyAdapter);
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        masterScrollPane = new javax.swing.JScrollPane();
        masterTable = new javax.swing.JTable();
        startDatePicker = new JXDatePicker();
        jLabel4 = new javax.swing.JLabel();
        totalLabel = new javax.swing.JLabel();
        endDatePicker = new JXDatePicker();
        printButton = new javax.swing.JButton();
        allSimpleCheckBox = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        datePicker = new JXDatePicker();
        jLabel2 = new javax.swing.JLabel();
        svatAmountTextField = new javax.swing.JTextField();
        issueButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        serialNumbertField = new javax.swing.JTextField();
        supplierComboBox = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        purchasingAmountTextField = new javax.swing.JTextField();

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        masterTable.setAutoCreateRowSorter(true);
        masterTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Serial Number", "SVAT Amount", "Purchasing Amount", "Issuing Date", "Supplier"
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
        if (masterTable.getColumnModel().getColumnCount() > 0) {
            masterTable.getColumnModel().getColumn(0).setPreferredWidth(20);
            masterTable.getColumnModel().getColumn(0).setHeaderValue(org.openide.util.NbBundle.getMessage(SvatTopComponent.class, "SvatTopComponent.masterTable.columnModel.title0")); // NOI18N
            masterTable.getColumnModel().getColumn(1).setHeaderValue(org.openide.util.NbBundle.getMessage(SvatTopComponent.class, "SvatTopComponent.masterTable.columnModel.title1")); // NOI18N
            masterTable.getColumnModel().getColumn(2).setHeaderValue(org.openide.util.NbBundle.getMessage(SvatTopComponent.class, "SvatTopComponent.masterTable.columnModel.title2")); // NOI18N
            masterTable.getColumnModel().getColumn(3).setHeaderValue(org.openide.util.NbBundle.getMessage(SvatTopComponent.class, "SvatTopComponent.masterTable.columnModel.title3")); // NOI18N
            masterTable.getColumnModel().getColumn(4).setHeaderValue(org.openide.util.NbBundle.getMessage(SvatTopComponent.class, "SvatTopComponent.masterTable.columnModel.title4")); // NOI18N
            masterTable.getColumnModel().getColumn(5).setPreferredWidth(200);
            masterTable.getColumnModel().getColumn(5).setHeaderValue(org.openide.util.NbBundle.getMessage(SvatTopComponent.class, "SvatTopComponent.masterTable.columnModel.title7")); // NOI18N
        }

        startDatePicker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startDatePickerActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(SvatTopComponent.class, "SvatTopComponent.jLabel4.text")); // NOI18N

        totalLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        totalLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        org.openide.awt.Mnemonics.setLocalizedText(totalLabel, org.openide.util.NbBundle.getMessage(SvatTopComponent.class, "SvatTopComponent.totalLabel.text")); // NOI18N

        endDatePicker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endDatePickerActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(printButton, org.openide.util.NbBundle.getMessage(SvatTopComponent.class, "SvatTopComponent.printButton.text")); // NOI18N
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(allSimpleCheckBox, org.openide.util.NbBundle.getMessage(SvatTopComponent.class, "SvatTopComponent.allSimpleCheckBox.text")); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(startDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(endDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(printButton)
                        .addGap(18, 18, 18)
                        .addComponent(allSimpleCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(totalLabel))
                    .addComponent(masterScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 856, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(endDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalLabel)
                    .addComponent(printButton)
                    .addComponent(allSimpleCheckBox))
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(SvatTopComponent.class, "SvatTopComponent.jLabel3.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(SvatTopComponent.class, "SvatTopComponent.jLabel1.text")); // NOI18N

        datePicker.setName("datePicker"); // NOI18N
        datePicker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datePickerActionPerformed(evt);
            }
        });
        datePicker.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                datePickerKeyPressed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(SvatTopComponent.class, "SvatTopComponent.jLabel2.text")); // NOI18N

        svatAmountTextField.setText(org.openide.util.NbBundle.getMessage(SvatTopComponent.class, "SvatTopComponent.svatAmountTextField.text")); // NOI18N
        svatAmountTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                svatAmountTextFieldActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(issueButton, org.openide.util.NbBundle.getMessage(SvatTopComponent.class, "SvatTopComponent.issueButton.text")); // NOI18N
        issueButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                issueButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel6, org.openide.util.NbBundle.getMessage(SvatTopComponent.class, "SvatTopComponent.jLabel6.text")); // NOI18N

        serialNumbertField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serialNumbertFieldActionPerformed(evt);
            }
        });

        supplierComboBox.setName("supplierComboBox"); // NOI18N
        supplierComboBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                supplierComboBoxFocusGained(evt);
            }
        });
        supplierComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplierComboBoxActionPerformed(evt);
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

        org.openide.awt.Mnemonics.setLocalizedText(jLabel5, org.openide.util.NbBundle.getMessage(SvatTopComponent.class, "SvatTopComponent.jLabel5.text")); // NOI18N

        purchasingAmountTextField.setText(org.openide.util.NbBundle.getMessage(SvatTopComponent.class, "SvatTopComponent.purchasingAmountTextField.text")); // NOI18N
        purchasingAmountTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchasingAmountTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(datePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(svatAmountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(serialNumbertField, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(purchasingAmountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(issueButton))
                        .addComponent(supplierComboBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {datePicker, purchasingAmountTextField, serialNumbertField, svatAmountTextField});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(serialNumbertField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(datePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(supplierComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(svatAmountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(purchasingAmountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(issueButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void masterTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masterTableMouseClicked

    }//GEN-LAST:event_masterTableMouseClicked

    private void masterTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masterTableMouseReleased

    }//GEN-LAST:event_masterTableMouseReleased

    private void masterTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_masterTableKeyReleased

    }//GEN-LAST:event_masterTableKeyReleased

    private void startDatePickerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startDatePickerActionPerformed
        fill();
    }//GEN-LAST:event_startDatePickerActionPerformed

    private void endDatePickerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endDatePickerActionPerformed
        fill();
    }//GEN-LAST:event_endDatePickerActionPerformed

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed

        try {
            int selectedRow = masterTable.getSelectedRow();
            if (selectedRow >= 0) {
                URL url = getClass().getResource("/com/nanosl/nbiz/cheque/jrxml/svat.jasper");
                Object object = JRLoader.loadObject(url);//"src/com/nanosl/nbiz/gui/jrxml/report1.jasper"
                if (object == null) {
                    showError("Unable to print");
                    return;
                }
                JasperReport report = (JasperReport) object;

                String ISSUE_DATE = masterTable.getValueAt(selectedRow, 4).toString();
                Company COMPANY = Data.getCompany();
                String COMPANY_VAT = COMPANY.getVat();
                String COMPANY_SVAT = COMPANY.getSvat();
                Supplier SUPPLIER = (Supplier) masterTable.getValueAt(selectedRow, 5);
                String SUPPLIER_VAT = SUPPLIER.getVat();
                String SUPPLIER_SVAT = SUPPLIER.getSvat();
                String NET_SVAT = masterTable.getValueAt(selectedRow, 3).toString();
                String SUSPENDED_VAT = masterTable.getValueAt(selectedRow, 2).toString();
                String NET_SVAT_IN_TEXT = NumberToWordsConverter.convert(Double.valueOf(NET_SVAT.replace(",", "")));
                String SUSPENDED_VAT_IN_TEXT = NumberToWordsConverter.convert(Double.valueOf(SUSPENDED_VAT.replace(",", "")));

                Map<String, Object> params = new LinkedHashMap<>();
                params.put("ISSUE_DATE", ISSUE_DATE);
                params.put("COMPANY", COMPANY.getName());
                params.put("COMPANY_VAT", COMPANY_VAT);
                params.put("COMPANY_SVAT", COMPANY_SVAT);
                params.put("SUPPLIER", allSimpleCheckBox.isSelected() ? SUPPLIER.getName().toLowerCase() : SUPPLIER.getName());
                params.put("SUPPLIER_VAT", SUPPLIER_VAT);
                params.put("SUPPLIER_SVAT", SUPPLIER_SVAT);
                params.put("NET_SVAT_IN_TEXT", NET_SVAT_IN_TEXT);
                params.put("NET_SVAT", NET_SVAT);
                params.put("SUSPENDED_VAT_IN_TEXT", SUSPENDED_VAT_IN_TEXT);
                params.put("SUSPENDED_VAT", SUSPENDED_VAT);

                Date convertedDate = yyyy_MM_dd.parse(ISSUE_DATE);
                Calendar c = Calendar.getInstance();
                c.setTime(convertedDate);
                c.roll(Calendar.MONTH, false);
                c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
                String[] dateParts = dd_MMMM_yy.format(c.getTime()).split("-");

                params.put("ENDING_DAY", dateParts[0]);
                params.put("ENDING_MONTH", dateParts[1]);
                params.put("ENDING_YEAR", dateParts[2]);

                Printer.printSatic(report, params);
            }
        } catch (JRException | ParseException ex) {
            Exceptions.printStackTrace(ex);
        }
    }//GEN-LAST:event_printButtonActionPerformed

    private void datePickerKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_datePickerKeyPressed
        if (evt.getKeyCode() == 10) {
            supplierComboBox.requestFocus();
        }
    }//GEN-LAST:event_datePickerKeyPressed

    private void svatAmountTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_svatAmountTextFieldActionPerformed
        purchasingAmountTextField.requestFocus();        // TODO add your handling code here:
        double svatAmount = Double.parseDouble(svatAmountTextField.getText().trim());
        purchasingAmountTextField.setText(nf2d.format(svatAmount / 11 * 100));
    }//GEN-LAST:event_svatAmountTextFieldActionPerformed

    private void issueButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_issueButtonActionPerformed
        issue();
    }//GEN-LAST:event_issueButtonActionPerformed

    private void serialNumbertFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serialNumbertFieldActionPerformed
        if (serialNumbertField.getText().trim().length() > 0) {
            datePicker.requestFocus();
        }
    }//GEN-LAST:event_serialNumbertFieldActionPerformed

    private void supplierComboBoxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_supplierComboBoxFocusGained
        //        searchSupplier();
    }//GEN-LAST:event_supplierComboBoxFocusGained

    private void supplierComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplierComboBoxActionPerformed
        //        fillItems();
        //        Object o = supplierComboBox.getSelectedItem();
        //        if (o instanceof Supplier) {
        //            supplier = (Supplier) o;
        //        }
    }//GEN-LAST:event_supplierComboBoxActionPerformed

    private void supplierComboBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_supplierComboBoxKeyPressed
        if (evt.getKeyCode() == 10) {
            svatAmountTextField.requestFocus();
        }
        //        else if (evt.getKeyCode() == KeyEvent.VK_F2) {
        //            searchSupplier();
        //        }
    }//GEN-LAST:event_supplierComboBoxKeyPressed

    private void supplierComboBoxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_supplierComboBoxKeyReleased

    }//GEN-LAST:event_supplierComboBoxKeyReleased

    private void purchasingAmountTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchasingAmountTextFieldActionPerformed
        issue();
    }//GEN-LAST:event_purchasingAmountTextFieldActionPerformed

    private void datePickerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datePickerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_datePickerActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox allSimpleCheckBox;
    private org.jdesktop.swingx.JXDatePicker datePicker;
    private org.jdesktop.swingx.JXDatePicker endDatePicker;
    private javax.swing.JButton issueButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane masterScrollPane;
    private javax.swing.JTable masterTable;
    private javax.swing.JButton printButton;
    private javax.swing.JTextField purchasingAmountTextField;
    private javax.swing.JTextField serialNumbertField;
    private org.jdesktop.swingx.JXDatePicker startDatePicker;
    private javax.swing.JComboBox supplierComboBox;
    private javax.swing.JTextField svatAmountTextField;
    private javax.swing.JLabel totalLabel;
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

    private void issue() {

        String serialNumberText = serialNumbertField.getText().trim();
        int serialNumber = Integer.parseInt(serialNumberText);
        double svatAmount = Double.valueOf(svatAmountTextField.getText().trim());
        double purchasingAmount = Double.valueOf(purchasingAmountTextField.getText().trim());
        Date date = datePicker.getDate();
        Supplier supplier = (Supplier) supplierComboBox.getSelectedItem();

        //=====================================
//        String chequeNumber = chequeNumbertField.getText().trim();
        Svat svat = new Svat(serialNumber);
        svat.setIssuedDate(date);
        svat.setPurchasingAmount(purchasingAmount);
        svat.setSupplier(supplier);
        svat.setSvatAmount(svatAmount);
//        svat.setIssuedDate(new Date());
//            issuedCheque.set
//        ArrayList<PurchaseInvoice> purchaseInvoicesOfCheque = new ArrayList<>();
//        purchaseInvoicesOfCheque.add(new PurchaseInvoice(chequeNumber, supplier.getCode()));
//        svat.setPurchaseInvoiceCollection(purchaseInvoicesOfCheque);
//        svat.setStatus(0);
        manager.update(svat);
        fill();
//            serializables.add(issuedCheque);
//            purchaseInvoice.getIssuedChequeCollection().add(issuedCheque);

    }

    private void fillTable() {
        tableModel.setRowCount(0);
        Date startDate = startDatePicker.getDate();
        Date endDate = endDatePicker.getDate();
        //ALTER TABLE `sgm`.`purchase_invoice` CHANGE COLUMN `inv_time` `inv_date` DATE NULL DEFAULT NULL  ;
//        manager.clearCache();

        Collection<Svat> svats = Find.svatByDates(makeStartDate(startDate), makeEndDate(endDate));
        if (svats == null) {
            showSuccess("No Record Found!");
            return;
        }
        int i = 0;
        for (Svat svat : svats) {
//            Collection<PurchaseInvoice> purchaseInvoices = svat.getPurchaseInvoiceCollection();
//            String invoiceNumbers = "";
//            String supplierName = "";
//            boolean flag = true;
//            for (PurchaseInvoice purchaseInvoice : purchaseInvoices) {
//                if (invoiceNumbers.length() > 0) {
//                    invoiceNumbers += ", ";
//                }
//                if (flag) {
//                    supplierName = purchaseInvoice != null ? purchaseInvoice.getSupplier() != null ? purchaseInvoice.getSupplier().getName() != null ? purchaseInvoice.getSupplier().getName() : "" : "" : "";
//                    flag = false;
//                }
//                invoiceNumbers += purchaseInvoice.getPurchaseInvoicePK().getInvNo();
//            }
            Object[] row = {
                ++i,
                svat.getSerialNumber(),
                nf2dComma.format(svat.getSvatAmount()),
                nf2dComma.format(svat.getPurchasingAmount()),
                yyyy_MM_dd.format(svat.getIssuedDate()),
                svat.getSupplier()
            };
            tableModel.addRow(row);
        }
        calcTotal();
    }

    private void fill() {
        fillTable();
        calcTotal();
    }

    private void calcTotal() {
        double total = 0;
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            total += Double.valueOf(tableModel.getValueAt(i, 2).toString().replace(",", ""));
        }
        totalLabel.setText(nf2d.format(total));
    }

}
