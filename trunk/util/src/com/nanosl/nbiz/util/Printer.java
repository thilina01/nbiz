/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.util;

import com.nanosl.lib.db.Manager;
import com.nanosl.lib.log.Loggings;
import com.nanosl.lib.print.JRViewer;
import java.sql.Connection;
import java.util.Map;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;

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
                    String reportSource = "src/rpt/invoice1.jrxml";
                    JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
                    Connection con = m.getConnection();
                    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, con);
                    JRViewer jRViewer = new JRViewer(jasperPrint, "Invoice");
                } catch (Exception ex) {
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
