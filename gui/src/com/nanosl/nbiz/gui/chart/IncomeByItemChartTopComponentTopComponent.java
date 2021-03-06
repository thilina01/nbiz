/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.gui.chart;

import com.nanosl.lib.date.JXDatePicker;
import com.nanosl.nbiz.util.Combo;
import static com.nanosl.nbiz.util.Format.nf2d;
import static com.nanosl.nbiz.util.Format.yyyy_MM_dd;
import com.nanosl.nbiz.util.NTopComponent;
import entity.Supplier;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.embed.swing.JFXPanel;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.transform.Scale;
import javax.swing.JComponent;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.TopComponent;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
        dtd = "-//com.nanosl.nbiz.gui//IncomeByItemChartTopComponent//EN",
        autostore = false
)
@TopComponent.Description(
        preferredID = "IncomeByItemChartTopComponentTopComponent",
        //iconBase="SET/PATH/TO/ICON/HERE", 
        persistenceType = TopComponent.PERSISTENCE_ALWAYS
)
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@ActionID(category = "Window", id = "com.nanosl.nbiz.gui.IncomeByItemChartTopComponentTopComponent")
@ActionReference(path = "Menu/Chart" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_IncomeByItemChartTopComponentAction",
        preferredID = "IncomeByItemChartTopComponentTopComponent"
)
@Messages({
    "CTL_IncomeByItemChartTopComponentAction=IncomeByItemChartTopComponent",
    "CTL_IncomeByItemChartTopComponentTopComponent=IncomeByItemChartTopComponent Window",
    "HINT_IncomeByItemChartTopComponentTopComponent=This is a IncomeByItemChartTopComponent window"
})
public final class IncomeByItemChartTopComponentTopComponent extends NTopComponent {

    public IncomeByItemChartTopComponentTopComponent() {
        onLoad();
        setName(Bundle.CTL_IncomeByItemChartTopComponentTopComponent());
        setToolTipText(Bundle.HINT_IncomeByItemChartTopComponentTopComponent());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        datePicker = new JXDatePicker();
        datePicker1 = new JXDatePicker();
        jLabel1 = new javax.swing.JLabel();
        topTextField = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        supplierCheckBox = new javax.swing.JCheckBox();
        supplierComboBox = new javax.swing.JComboBox();
        printButton = new javax.swing.JButton();

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

        datePicker1.setName("datePicker"); // NOI18N
        datePicker1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datePicker1ActionPerformed(evt);
            }
        });
        datePicker1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                datePicker1KeyPressed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(IncomeByItemChartTopComponentTopComponent.class, "IncomeByItemChartTopComponentTopComponent.jLabel1.text")); // NOI18N

        topTextField.setText(org.openide.util.NbBundle.getMessage(IncomeByItemChartTopComponentTopComponent.class, "IncomeByItemChartTopComponentTopComponent.topTextField.text")); // NOI18N
        topTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                topTextFieldActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new java.awt.BorderLayout());

        org.openide.awt.Mnemonics.setLocalizedText(supplierCheckBox, org.openide.util.NbBundle.getMessage(IncomeByItemChartTopComponentTopComponent.class, "IncomeByItemChartTopComponentTopComponent.supplierCheckBox.text")); // NOI18N
        supplierCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplierCheckBoxActionPerformed(evt);
            }
        });

        supplierComboBox.setName("supplierComboBox"); // NOI18N
        supplierComboBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                supplierComboBoxKeyPressed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(printButton, org.openide.util.NbBundle.getMessage(IncomeByItemChartTopComponentTopComponent.class, "IncomeByItemChartTopComponentTopComponent.printButton.text")); // NOI18N
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(datePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(datePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(topTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(supplierCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(supplierComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addComponent(printButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(datePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(datePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(topTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(supplierCheckBox)
                    .addComponent(supplierComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(printButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void datePickerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datePickerActionPerformed
        createChartScene();
    }//GEN-LAST:event_datePickerActionPerformed

    private void datePickerKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_datePickerKeyPressed

    }//GEN-LAST:event_datePickerKeyPressed

    private void datePicker1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datePicker1ActionPerformed
        createChartScene();
    }//GEN-LAST:event_datePicker1ActionPerformed

    private void datePicker1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_datePicker1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_datePicker1KeyPressed

    private void topTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_topTextFieldActionPerformed
        createChartScene();
    }//GEN-LAST:event_topTextFieldActionPerformed

    private void supplierComboBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_supplierComboBoxKeyPressed
        if (evt.getKeyCode() == 10) {
            createChartScene();
        }
    }//GEN-LAST:event_supplierComboBoxKeyPressed

    private void supplierCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplierCheckBoxActionPerformed
        createChartScene();
    }//GEN-LAST:event_supplierCheckBoxActionPerformed

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
//        Node node = new Circle(100, 200, 200);
        if (node == null) {
            return;
        }
        Platform.runLater(new Runnable() {
            @Override
            public void run() {

                Printer printer = Printer.getDefaultPrinter();
                PageLayout pageLayout = printer.createPageLayout(Paper.A4, PageOrientation.LANDSCAPE, Printer.MarginType.HARDWARE_MINIMUM);
                double scaleX = pageLayout.getPrintableWidth() / node.getBoundsInParent().getWidth();
                double scaleY = pageLayout.getPrintableHeight() / node.getBoundsInParent().getHeight();
                System.out.println("==========="+scaleX+" x "+scaleY);
                double original_width = node.getBoundsInParent().getWidth();
                double original_height = node.getBoundsInParent().getHeight();
                double bound_width = pageLayout.getPrintableWidth();
                double bound_height = pageLayout.getPrintableHeight();
                double new_width = original_width;
                double new_height = original_height;

                // first check if we need to scale width
                if (original_width > bound_width) {
                    //scale width to fit
                    new_width = bound_width;
                    //scale height to maintain aspect ratio
                    new_height = (new_width * original_height) / original_width;
                }

                // then check if we need to scale even with the new height
                if (new_height > bound_height) {
                    //scale height to fit instead
                    new_height = bound_height;
                    //scale width to maintain aspect ratio
                    new_width = (new_height * original_width) / original_height;
                }

                System.out.println("==========="+new_height+" x "+new_width);
                double x = new_height/original_height;
                double y = new_width/original_width;
                
                System.out.println("==========="+x+" x "+y);
                node.getTransforms().add(new Scale(x, y));
                PrinterJob job = PrinterJob.createPrinterJob(printer);
                if (job != null) {
                    System.out.println("Job created!");
                    boolean success = job.printPage(pageLayout, node);
                    if (success) {
                        System.out.println("Job successfully finished!");
                        job.endJob();
                    } else {
                        System.out.println("Job NOT successful!");
                    }
                }

                /////////////////////////////
//                PrinterJob job = PrinterJob.createPrinterJob();
//
//                if (job != null && node != null) {
//                    boolean success = job.printPage(node);
//                    if (success) {
//                        job.endJob();
//                    }
//                }
            }
        });
    }//GEN-LAST:event_printButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXDatePicker datePicker;
    private org.jdesktop.swingx.JXDatePicker datePicker1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton printButton;
    private javax.swing.JCheckBox supplierCheckBox;
    private javax.swing.JComboBox supplierComboBox;
    private javax.swing.JTextField topTextField;
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

    final JFXPanel panel = new JFXPanel();

    private void onLoad() {
        initComponents();
        final Calendar c1 = Calendar.getInstance();
        c1.setTime(new Date());
        c1.set(Calendar.DATE, 1);
        datePicker.setDate(c1.getTime());
        createChartScene();
        jPanel1.add(panel, BorderLayout.CENTER);
        setComboBoxKeyAdapters(supplierComboBox);

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

            }
        }
    }
    KeyAdapter supplierComboBoxKeyAdapter = new java.awt.event.KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent evt) {
            supplierComboBoxKeyPressed(evt);
        }
    };

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
        Combo.fillSuppliers(supplierComboBox, null);
    }

    private void createChartScene() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Supplier supplier = (Supplier) supplierComboBox.getSelectedItem();
                String x = "SELECT item.description, "
                        + "Sum(sale_invoice_has_item.quantity*sale_invoice_has_item.rate) AS total "
                        + "FROM "
                        + "sale_invoice_has_item "
                        + "INNER JOIN sale_invoice ON sale_invoice_has_item.sale_invoice_inv_no = sale_invoice.inv_no "
                        + "INNER JOIN item ON sale_invoice_has_item.item_code = item.`code` "
                        + "WHERE "
                        + "sale_invoice.inv_time BETWEEN '" + yyyy_MM_dd.format(makeStartDate(datePicker.getDate())) + " 00:00:00' AND '" + yyyy_MM_dd.format(makeEndDate(datePicker1.getDate())) + " 23:59:59' AND item.description != 'OTHER' "
                        + (supplierCheckBox.isSelected() ? "AND item.supplier_code='" + supplier.getCode() + "' " : "")
                        + "GROUP BY item.description "
                        + "ORDER BY total DESC LIMIT " + Integer.parseInt(topTextField.getText().trim());
//        System.out.println(x);
                ArrayList<PieChart.Data> pieChartData = new ArrayList<>();
                try (PreparedStatement ps = manager.getConnection().prepareStatement(x)) {
                    ResultSet resultSet = ps.executeQuery();
                    while (resultSet.next()) {
//                System.out.print(resultSet.getString("date_only") + " = ");
//                        System.out.println(nf2d.format(resultSet.getDouble("total")));

//                table.getColumns().add(new TableColumn(resultSet.getString("date_only").substring(resultSet.getString("date_only").lastIndexOf("-") + 1)));
                        pieChartData.add(new PieChart.Data(resultSet.getString("description") + " " + nf2d.format(resultSet.getDouble("total")), resultSet.getDouble("total")));
                    }
                } catch (SQLException ex) {
                    Exceptions.printStackTrace(ex);
                }
                final PieChart chart = new PieChart(FXCollections.observableArrayList(pieChartData));
                chart.setTitle("Income by Item - " + yyyy_MM_dd.format(makeStartDate(datePicker.getDate())) + " to " + yyyy_MM_dd.format(makeEndDate(datePicker1.getDate())));
                node = chart;
                Scene scene = new Scene(chart);
                panel.setScene(scene);
            }
        });
    }
    Node node;
}
