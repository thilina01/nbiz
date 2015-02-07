/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.gui.chart;

//import com.nanosl.nbiz.gui.Bundle;
import com.nanosl.nbiz.util.NTopComponent;
import java.awt.BorderLayout;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.DatePicker;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
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
@ActionReference(path = "Menu/Chart" /*, position = 333 */)
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
//        final Calendar c1 = Calendar.getInstance();
//        c1.setTime(new java.util.Date());
//        c1.set(Calendar.DATE, 1);
//        datePicker.setDate(c1.getTime());
//        datePicker.setMonthView(new JXMonthView());
        setName(Bundle.CTL_MonthSalesChartTopComponent());
        setToolTipText(Bundle.HINT_MonthSalesChartTopComponent());
//        jPanel1.setLayout(new BorderLayout());
//        Platform.setImplicitExit(false);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                panel2.setScene(createCalenderScene());
                panel.setScene(createChartScene());
            }

        });
//        Platform.runLater(() -> {
//            panel.setScene(createScene());
//        });

        jPanel1.add(panel, BorderLayout.CENTER);
        jPanel2.add(panel2, BorderLayout.SOUTH);
    }

    DatePicker endDatePicker = new DatePicker();
    DatePicker startDatePicker = new DatePicker();

    private Scene createCalenderScene() {
        VBox vbox = new VBox(20);
        vbox.setStyle("-fx-padding: 10;");
//        Scene scene = new Scene(vbox, 400, 400);
        EventHandler eventHandler = new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        panel.setScene(createChartScene());
                    }

                });
                event.consume();
            }
        };
        endDatePicker.setValue(LocalDate.now());
        endDatePicker.setOnAction(eventHandler);
        startDatePicker.setOnAction(eventHandler);
        startDatePicker.setValue(endDatePicker.getValue().minusDays(endDatePicker.getValue().getDayOfMonth()-1));
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
//
//        Label checkInlabel = new Label("Check-In Date:");
        gridPane.add(startDatePicker, 0, 0);
        gridPane.add(endDatePicker, 1, 0);
//
//        GridPane.setHalignment(checkInlabel, HPos.LEFT);
//        gridPane.add(checkInDatePicker, 0, 1);
        vbox.getChildren().add(gridPane);
        return new Scene(vbox);

    }
    LineChart<String, Number> lineChart;

    private Scene createChartScene() {
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        lineChart = new LineChart<>(xAxis, yAxis);
        xAxis.setLabel("Date of Month");
        //creating the chart

        lineChart.setTitle("Sales Monitoring - " + yyyy_MM_dd.format(makeStartDate(Date.valueOf(startDatePicker.getValue()))) + " to " + yyyy_MM_dd.format(makeEndDate(Date.valueOf(endDatePicker.getValue()))));
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
                + "WHERE sale_invoice.inv_time BETWEEN '" + yyyy_MM_dd.format(makeStartDate(Date.valueOf(startDatePicker.getValue()))) + " 00:00:00' AND '" + yyyy_MM_dd.format(Date.valueOf(endDatePicker.getValue())) + " 23:59:59'"
                + "GROUP BY "
                + "date_only "
                + "ORDER BY date_only;";
//        System.out.println(x);
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
        jPanel2 = new javax.swing.JPanel();

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
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
