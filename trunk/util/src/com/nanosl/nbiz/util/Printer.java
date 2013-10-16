/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.util;

import com.nanosl.lib.db.Manager;
import com.nanosl.lib.log.Loggings;
import com.nanosl.lib.print.JRViewer;
import java.net.URL;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import org.openide.util.Exceptions;
import org.openide.windows.WindowManager;

/**
 *
 * @author Thilina
 */
public class Printer {

    static Manager m = Manager.getInstance();

    public static void printInvoice(final Map<String, Object> params) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    PrintViewTopComponent tc = (PrintViewTopComponent) WindowManager.getDefault().findTopComponent("PrintViewTopComponent");
                    HashMap parameters = new HashMap();
                    parameters.put("first_date", " 00:00:00");
                    parameters.put("last_date", " 23:59:59");

                    URL url = getClass().getResource("/com/nanosl/nbiz/gui/jrxml/" + "report1" + ".jasper");
                    //            URL url = getClass().getResource("/com/nanosl/nbiz/gui/jrxml/" + fileName + ".jasper");
                    JasperReport report = (JasperReport) JRLoader.loadObject(url);//"src/com/nanosl/nbiz/gui/jrxml/report1.jasper"
                    tc.print(report, parameters);
                    tc.open();
                    tc.requestActive();
                    //                try {
                    //                    String reportSource = "src/rpt/invoice1.jrxml";
                    //                    
                    //                    JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
                    //                    Connection con = m.getConnection();
                    //                    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, con);
                    //                    JRViewer jRViewer = new JRViewer(jasperPrint, "Invoice");
                    //                } catch (Exception ex) {
                    //                }
                    //                }
                } catch (JRException ex) {
                    Exceptions.printStackTrace(ex);
                }
            }
        });
    }

    public static void printPosInvoice(final Map<String, Object> params) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    String reportSource = "src/rpt/posInvoice.jrxml";
                    JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
                    Connection con = m.getConnection();
                    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, con);
                    JasperPrintManager.printReport(jasperPrint, false);
//                    JRViewer jRViewer = new JRViewer(jasperPrint, "Invoice");
                } catch (Exception ex) {
                    Loggings.logError(Printer.class.getName(), ex);
                }
            }
        });
    }

    public static void printReceipt(final Map<String, Object> params) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    String reportSource = "src/rpt/receipt.jrxml";
                    JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
                    Connection con = m.getConnection();
                    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, con);
                    JRViewer jRViewer = new JRViewer(jasperPrint, "Receipt");
                } catch (Exception ex) {
                    Loggings.logError(Printer.class.getName(), ex);
                }
            }
        });
    }

    public static void printStock() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    Map<String, Object> params = Data.getParams();
                    String reportSource = "src/rpt/stock.jrxml";
                    JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
                    Connection con = m.getConnection();
                    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, con);
                    JRViewer jRViewer = new JRViewer(jasperPrint, "Stock");
                } catch (Exception ex) {
                    Loggings.logError(Printer.class.getName(), ex);
                }
            }
        });
    }
}
