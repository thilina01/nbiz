/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.gui;

import com.nanosl.lib.date.JXDatePicker;
import com.nanosl.nbiz.util.NTopComponent;
import java.awt.BorderLayout;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.transform.Scale;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.util.Exceptions;
import org.openide.windows.TopComponent;
import org.openide.util.NbBundle.Messages;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
        dtd = "-//com.nanosl.nbiz.gui//MonthSalesChart//EN",
        autostore = false
)
@TopComponent.Description(
        preferredID = "MonthSalesChartTopComponent",
        //iconBase="SET/PATH/TO/ICON/HERE", 
        persistenceType = TopComponent.PERSISTENCE_ALWAYS
)
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@ActionID(category = "Window", id = "com.nanosl.nbiz.gui.MonthSalesChartTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_MonthSalesChartAction",
        preferredID = "MonthSalesChartTopComponent"
)
@Messages({
    "CTL_MonthSalesChartAction=MonthSalesChart",
    "CTL_MonthSalesChartTopComponent=MonthSalesChart Window",
    "HINT_MonthSalesChartTopComponent=This is a MonthSalesChart window"
})
public final class MonthSalesChartTopComponent extends NTopComponent {

    final JFXPanel panel = new JFXPanel();
    final JFXPanel panel2 = new JFXPanel();

    public MonthSalesChartTopComponent() {
        initComponents();
        final Calendar c1 = Calendar.getInstance();
        c1.setTime(new Date());
        c1.set(Calendar.DATE, 1);
        datePicker.setDate(c1.getTime());
//        datePicker.setMonthView(new JXMonthView());
        setName(Bundle.CTL_MonthSalesChartTopComponent());
        setToolTipText(Bundle.HINT_MonthSalesChartTopComponent());
//        jPanel1.setLayout(new BorderLayout());
//        Platform.setImplicitExit(false);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                panel.setScene(createChartScene());
            }

        });
//        Platform.runLater(() -> {
//            panel.setScene(createScene());
//        });

        jPanel1.add(panel, BorderLayout.CENTER);
        jPanel1.add(panel2, BorderLayout.SOUTH);
    }
    LineChart<String, Number> lineChart;

    private Scene createChartScene() {
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        lineChart = new LineChart<>(xAxis, yAxis);
        xAxis.setLabel("Date of Month");
        //creating the chart

        lineChart.setTitle("Sales Monitoring - " + yyyy_MM_dd.format(makeStartDate(datePicker.getDate())) + " to " + yyyy_MM_dd.format(makeEndDate(datePicker1.getDate())));
        //defining a series
        XYChart.Series series = new XYChart.Series();
        series.setName("Total Sales of the day");

//        lineChart.setCursor(Cursor.CROSSHAIR);
        //----------------------------------------
//        TableView table = new TableView();
        //----------------------------------------
        String x = "SELECT "
                + "DATE(sale_invoice.inv_time) as date_only, "
                + "sum(sale_invoice.amount) as date_sum "
                + "FROM "
                + "sale_invoice "
                + "WHERE sale_invoice.inv_time BETWEEN '" + yyyy_MM_dd.format(makeStartDate(datePicker.getDate())) + " 00:00:00' AND '" + yyyy_MM_dd.format(makeEndDate(datePicker1.getDate())) + " 23:59:59'"
                + "GROUP BY "
                + "date_only "
                + "ORDER BY date_only;";
        System.out.println(x);
        try (PreparedStatement ps = manager.getConnection().prepareStatement(x)) {
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
//                System.out.print(resultSet.getString("date_only") + " = ");
//                System.out.println(nf2d.format(resultSet.getDouble("date_sum")));

//                table.getColumns().add(new TableColumn(resultSet.getString("date_only").substring(resultSet.getString("date_only").lastIndexOf("-") + 1)));
                series.getData().add(new XYChart.Data(resultSet.getString("date_only").substring(resultSet.getString("date_only").lastIndexOf("-") + 1) + " (" + resultSet.getDouble("date_sum") + ")", resultSet.getDouble("date_sum")));
            }
        } catch (SQLException ex) {
            Exceptions.printStackTrace(ex);
        }

        //populating the series with data
//        series.getData().add(new XYChart.Data(1, 23));
//        series.getData().add(new XYChart.Data(2, 14));
//        series.getData().add(new XYChart.Data(3, 15));
//        series.getData().add(new XYChart.Data(4, 24));
//        series.getData().add(new XYChart.Data(5, 34));
//        series.getData().add(new XYChart.Data(6, 36));
//        series.getData().add(new XYChart.Data(7, 22));
//        series.getData().add(new XYChart.Data(8, 45));
//        series.getData().add(new XYChart.Data(9, 43));
//        series.getData().add(new XYChart.Data(10, 17));
//        series.getData().add(new XYChart.Data(11, 29));
//        series.getData().add(new XYChart.Data(12, 25));
        Scene scene = new Scene(lineChart);//, 800, 600
//        Scene scene2 = new Scene(table);//, 800, 600
//        panel2.setScene(scene2);
        lineChart.getData().add(series);
        return scene;
    }

    public static Scene createScene() {
        Text text = new Text("Hello World");
        text.setFont(new Font(24.0));
        //text setFont(new Font(24));
        text.setEffect(new Reflection());

        BorderPane pane = new BorderPane();
        pane.setCenter(text);
        Scene scene = new Scene(pane);

        return scene;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        datePicker = new JXDatePicker();
        datePicker1 = new JXDatePicker();

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new java.awt.BorderLayout());

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
                        .addGap(0, 166, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(datePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(datePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void datePickerKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_datePickerKeyPressed

    }//GEN-LAST:event_datePickerKeyPressed

    private void datePickerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datePickerActionPerformed
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                panel.setScene(createChartScene());
            }

        });

    }//GEN-LAST:event_datePickerActionPerformed

    private void datePicker1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datePicker1ActionPerformed
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                panel.setScene(createChartScene());
            }

        });
    }//GEN-LAST:event_datePicker1ActionPerformed

    private void datePicker1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_datePicker1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_datePicker1KeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXDatePicker datePicker;
    private org.jdesktop.swingx.JXDatePicker datePicker1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
    @Override
    public void componentOpened() {
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
