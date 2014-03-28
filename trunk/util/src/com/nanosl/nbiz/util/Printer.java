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

    public static void printInvoice(final JasperReport report,final Map<String, Object> params) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                PrintViewTopComponent tc = (PrintViewTopComponent) WindowManager.getDefault().findTopComponent("PrintViewTopComponent");
                HashMap<String,Object> parameters = new HashMap<>();
                parameters.put("first_date", " 00:00:00");
                parameters.put("last_date", " 23:59:59");
                tc.print(report, parameters);
                tc.open();
                tc.requestActive();
            }
        });
    }

    public static void printPosInvoice(final JasperReport report, final Map<String, Object> params) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
//                    String reportSource = "src/rpt/posInvoice.jrxml";
//                    JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
                    Connection con = m.getConnection();
                    JasperPrint jasperPrint = JasperFillManager.fillReport(report, params, con);
//                    jasperPrint.setPageHeight(100);
//                    jasperPrint.setPageWidth(80);
//                    jasperPrint.setOrientation(report.getOrientationValue().LANDSCAPE);
                    JasperPrintManager.printReport(jasperPrint, false);
//                    JRViewer jRViewer = new JRViewer(jasperPrint, "Invoice");
                } catch (JRException ex) {
                    Loggings.logError(Printer.class.getName(), ex);
                }
            }
        });
    }

    public static void printPosInvoice(final Map<String, Object> params) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
//                    String reportSource = "src/com/nanos/nbiz/pos/jrxml/posInvoice.jrxml";
//                    JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
                    
                    URL url = getClass().getResource("/com/nanosl/nbiz/gui/jrxml/" + "posInvoice" + ".jasper");
                    JasperReport report = (JasperReport) JRLoader.loadObject(url);
                    printPosInvoice(report, params);
//                    Connection con = m.getConnection();
//                    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, con);
//                    JasperPrintManager.printReport(jasperPrint, false);
////                    JRViewer jRViewer = new JRViewer(jasperPrint, "Invoice");
                } catch (JRException ex) {
                    Loggings.logError(Printer.class.getName(), ex);
                }
            }
        });
    }

    public static void printReceipt(final JasperReport report,final Map<String, Object> params) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
//                    String reportSource = "src/rpt/receipt.jrxml";
//                    JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
                    
//                    URL url = getClass().getResource("/com/nanosl/nbiz/gui/jrxml/" + "receipt" + ".jasper");
//                    JasperReport report = (JasperReport) JRLoader.loadObject(url);
                    Connection con = m.getConnection();
                    JasperPrint jasperPrint = JasperFillManager.fillReport(report, params, con);
                    JRViewer jRViewer = new JRViewer(jasperPrint, "Receipt");
                } catch (JRException ex) {
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
//                    String reportSource = "src/rpt/stock.jrxml";
                    
                    URL url = getClass().getResource("/com/nanosl/nbiz/gui/jrxml/" + "stock" + ".jasper");
                    JasperReport report = (JasperReport) JRLoader.loadObject(url);
//                    JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
                    Connection con = m.getConnection();
                    JasperPrint jasperPrint = JasperFillManager.fillReport(report, params, con);
                    JRViewer jRViewer = new JRViewer(jasperPrint, "Stock");
                } catch (Exception ex) {
                    Loggings.logError(Printer.class.getName(), ex);
                }
            }
        });
    }
}
