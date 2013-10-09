/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.util;

import com.nanosl.lib.db.Manager;
import com.nanosl.lib.er.Errors;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author T
 */
public class FindMySql {

    public static final DateFormat yyyy_MM_dd = new SimpleDateFormat("yyyy-MM-dd");
    private static String partPaymentCollectionsByDates = "SELECT "
            + "DATE_FORMAT(collection_receipt.collected_time,'%d-%m-%Y') AS 'Collected Time', "
            + "sale_invoice.inv_no AS 'Invoice Number', "
            + "customer.`code` AS 'Customer Code', "
            + "customer.`name` AS 'Customer Name', "
            + "collection_receipt.receipt_number AS 'Receipt Number', "
            + "collection_receipt.cash AS 'Receipt Amount', "
            + "sale_invoice.amount AS 'Invoice Amount', "
            + "sale_invoice.received_amount AS 'Total Received', "
            + "sale_invoice.credit AS 'Remaining Credit'"
            + "FROM "
            + "collection_receipt "
            + "INNER JOIN sale_invoice ON collection_receipt.sale_invoice_inv_no = sale_invoice.inv_no "
            + "INNER JOIN customer ON sale_invoice.customer_code = customer.`code` "
            + "WHERE collection_receipt.collected_time BETWEEN ? AND ? "
            + "AND collection_receipt.cash < sale_invoice.amount";
    private static String saleItemProfitBetweenDates =
            "SELECT "
            + "item.`code` as 'Code', "
            + "item.description as 'Item', "
            + "Sum(sale_invoice_has_item.quantity) AS Quantity, "
            + "sale_invoice_has_item.rate AS Rate,"
            + "( Rate *  SUM(sale_invoice_has_item.quantity) ) AS Income, "
            + "sale_invoice_has_item.cost AS `Item Cost`, "
            + "( Cost *  SUM(sale_invoice_has_item.quantity) ) AS `Total Cost`, "
            + "( Rate *  SUM(sale_invoice_has_item.quantity) ) - ( Cost *  SUM(sale_invoice_has_item.quantity) ) AS Profit "
            + "FROM "
            + "sale_invoice_has_item "
            + "INNER JOIN item ON item.`code` = sale_invoice_has_item.item_code "
            + "INNER JOIN sale_invoice ON sale_invoice.inv_no = sale_invoice_has_item.sale_invoice_inv_no "
            + "WHERE "
            + "sale_invoice.inv_time BETWEEN ? AND ? "
            + "GROUP BY sale_invoice_has_item.item_code,sale_invoice_has_item.rate ";
    private static String itemTotalSaleBetweenDates = "SELECT "
            + "sale_invoice_has_item.item_code as 'code', "
            + "item.description as 'description', "
            + "Sum(sale_invoice_has_item.quantity) as'quantity', "
            + "sale_invoice_has_item.rate as 'price', "
            + "sale_invoice_has_item.rate * Sum(sale_invoice_has_item.quantity) as 'value', "
            + "sale_invoice_has_item.cost as 'cost' "
            + "FROM "
            + "sale_invoice_has_item "
            + "INNER JOIN sale_invoice ON sale_invoice_has_item.sale_invoice_inv_no = sale_invoice.inv_no "
            + "INNER JOIN item ON item.`code` = sale_invoice_has_item.item_code "
            + "WHERE "
            + "sale_invoice.inv_time BETWEEN ? AND ? "
            + "GROUP BY sale_invoice_has_item.item_code ";
    private static String totalSaleProfitBetweenDates =
            "SELECT SUM(Profit) as Profit"
            + "FROM ( "
            + "SELECT "
            + "((sale_invoice_has_item.rate *  SUM(sale_invoice_has_item.quantity) ) "
            + "- "
            + "( sale_invoice_has_item.cost *  SUM(sale_invoice_has_item.quantity) )) AS Profit "
            + "FROM sale_invoice_has_item "
            + "INNER JOIN item ON item.`code` = sale_invoice_has_item.item_code "
            + "INNER JOIN sale_invoice ON sale_invoice.inv_no = sale_invoice_has_item.sale_invoice_inv_no "
            + "WHERE "
            + "sale_invoice.inv_time BETWEEN ? AND ? "
            + "GROUP BY sale_invoice_has_item.item_code,sale_invoice_has_item.rate ) AS Profit";
    private static String totalSaleSummeryBetweenDates =
            "SELECT SUM(Income) as Income, SUM(Cost) as Cost, SUM(Profit) as Profit "
            + "FROM "
            + "(SELECT "
            + "(sale_invoice_has_item.rate *  SUM(sale_invoice_has_item.quantity) ) AS Income, "
            + "(sale_invoice_has_item.cost *  SUM(sale_invoice_has_item.quantity) ) AS Cost, "
            + "(sale_invoice_has_item.rate *  SUM(sale_invoice_has_item.quantity)   -  sale_invoice_has_item.cost *  SUM(sale_invoice_has_item.quantity)  )AS Profit "
            + "FROM sale_invoice_has_item "
            + "INNER JOIN item ON item.`code` = sale_invoice_has_item.item_code "
            + "INNER JOIN sale_invoice ON sale_invoice.inv_no = sale_invoice_has_item.sale_invoice_inv_no "
            + "WHERE sale_invoice.inv_time BETWEEN ? AND ? "
            + "GROUP BY sale_invoice_has_item.item_code,sale_invoice_has_item.rate) AS R";
    private static String totalExpensesBetweenDates =
            "SELECT SUM( expenses.amount) AS Total "
            + "FROM expenses "
            + "WHERE expenses.paid_time  BETWEEN ? AND ? ";
    private static String totalPaymentsBetweenDates =
            "SELECT SUM(issued_cash.amount) AS Total "
            + "FROM issued_cash "
            + "WHERE issued_cash.issued_time BETWEEN ? AND ? ";
    private static String totalChequesBetweenDates =
            "SELECT SUM(issued_cheque.amount) AS Total "
            + "FROM issued_cheque "
            + "WHERE issued_cheque.issued_date BETWEEN ? AND ?";
    private static Manager man;
    private static Connection con;
    private static Statement st;
    private static ResultSet res;
    private static PreparedStatement preparedStatement;

    private static void connect() {
        try {
            man = Manager.getInstance();//new Manager("cbisPU");
            con = man.getConnection();
            st = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(FindMySql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static {
//        connect();
    }

    public static void main(String[] args) {
//        try {
//            preparedStatement = con.prepareStatement(saleItemProfitBetweenDates);
//            preparedStatement.setString(1, "2012-01-01");
//            preparedStatement.setString(2, "2012-01-31");
////            ResultSet res = st.executeQuery(saleProfitBetweenDates);
//            ResultSet res = preparedStatement.executeQuery();
//
//            while (res.next()) {
//                String code = res.getString("Code");
//                String item = res.getString("Item");
//                System.out.println(code + "\t\t" + item);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(FindMySql.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    public static ResultSet saleItemProfitBetweenDates(Date startDate, Date endDate) {
        connect();
        try {
            preparedStatement = con.prepareStatement(saleItemProfitBetweenDates);
            preparedStatement.setString(1, yyyy_MM_dd.format(startDate) + " 00:00:00");
            preparedStatement.setString(2, yyyy_MM_dd.format(endDate) + " 23:59:59");
            res = preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Errors.reportError(ex);
        }
        return res;
    }

    public static ResultSet itemTotalSaleBetweenDates(Date startDate,Date endDate) {
        connect();
        try {
            preparedStatement = con.prepareStatement(itemTotalSaleBetweenDates);
            preparedStatement.setString(1, yyyy_MM_dd.format(startDate) + " 00:00:00");
            preparedStatement.setString(2, yyyy_MM_dd.format(endDate) + " 23:59:59");
            res = preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Errors.reportError(ex);
        }
        return res;
    }

    public static ResultSet partPaymentCollectionsByDates(Date startDate, Date endDate) {
        connect();
        try {
            preparedStatement = con.prepareStatement(partPaymentCollectionsByDates);
            preparedStatement.setString(1, yyyy_MM_dd.format(startDate) + " 00:00:00");
            preparedStatement.setString(2, yyyy_MM_dd.format(endDate) + " 23:59:59");
            res = preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Errors.reportError(ex);
        }
        return res;
    }

    public static double totalSaleProfitBetweenDates(Date startDate, Date endDate) {
        connect();
        double totalSaleProfit = 0;
        try {
            preparedStatement = con.prepareStatement(totalSaleProfitBetweenDates);
            preparedStatement.setString(1, yyyy_MM_dd.format(startDate) + " 00:00:00");
            preparedStatement.setString(2, yyyy_MM_dd.format(endDate) + " 23:59:59");
            res = preparedStatement.executeQuery();
            if (res.next()) {
                totalSaleProfit = res.getDouble("Profit");
            }
            close();
        } catch (SQLException ex) {
            Errors.reportError(ex);
        }
        return totalSaleProfit;
    }

    public static double totalExpensesBetweenDates(Date startDate, Date endDate) {
        connect();
        double totalExpenses = 0;
        try {
            preparedStatement = con.prepareStatement(totalExpensesBetweenDates);
            preparedStatement.setString(1, yyyy_MM_dd.format(startDate) + " 00:00:00");
            preparedStatement.setString(2, yyyy_MM_dd.format(endDate) + " 23:59:59");
            res = preparedStatement.executeQuery();
            if (res.next()) {
                totalExpenses = res.getDouble("Total");
            }
            close();
        } catch (SQLException ex) {
            Errors.reportError(ex);
        }
        return totalExpenses;
    }

    public static double totalPaymentsBetweenDates(Date startDate, Date endDate) {
        connect();
        double totalPayments = 0;
        try {
            preparedStatement = con.prepareStatement(totalPaymentsBetweenDates);
            preparedStatement.setString(1, yyyy_MM_dd.format(startDate) + " 00:00:00");
            preparedStatement.setString(2, yyyy_MM_dd.format(endDate) + " 23:59:59");
            res = preparedStatement.executeQuery();
            if (res.next()) {
                totalPayments = res.getDouble("Total");
            }
            close();
        } catch (SQLException ex) {
            Errors.reportError(ex);
        }
        return totalPayments;
    }

    public static double totalChequesBetweenDates(Date startDate, Date endDate) {
        connect();
        double totalPayments = 0;
        try {
            preparedStatement = con.prepareStatement(totalChequesBetweenDates);
            preparedStatement.setString(1, yyyy_MM_dd.format(startDate) + " 00:00:00");
            preparedStatement.setString(2, yyyy_MM_dd.format(endDate) + " 23:59:59");
            res = preparedStatement.executeQuery();
            if (res.next()) {
                totalPayments = res.getDouble("Total");
            }
            close();
        } catch (SQLException ex) {
            Errors.reportError(ex);
        }
        return totalPayments;
    }

    public static double[] totalSaleSummeryBetweenDates(Date startDate, Date endDate) {
        connect();
        double[] totals = new double[3];
        try {
            preparedStatement = con.prepareStatement(totalSaleSummeryBetweenDates);
            preparedStatement.setString(1, yyyy_MM_dd.format(startDate) + " 00:00:00");
            preparedStatement.setString(2, yyyy_MM_dd.format(endDate) + " 23:59:59");
            res = preparedStatement.executeQuery();
            if (res.next()) {
                totals[0] = res.getDouble("Income");
                totals[1] = res.getDouble("Cost");
                totals[2] = res.getDouble("Profit");
            }
            close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return totals;
    }

    public static void close() {
        try {

            if (st != null) {
                st.close();
            }
            if (res != null) {
                res.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            Errors.reportError(ex);
        }
    }
}
