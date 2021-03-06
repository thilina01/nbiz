/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.util;

import com.nanosl.lib.db.Manager;
import com.nanosl.lib.er.Errors;
import entity.ItemType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author T
 */
public class FindMySql {

    public static final DateFormat yyyy_MM_dd = new SimpleDateFormat("yyyy-MM-dd");
    private static final String partPaymentCollectionsByDates = "SELECT "
            + "DATE_FORMAT(collection_receipt.collected_time,'%d-%m-%Y') AS 'Collected Time', "
            + "sale_invoice.inv_no AS 'Invoice Number', "
            + "customer.`code` AS 'Customer Code', "
            + "person.`name` AS 'Customer Name', "
            + "collection_receipt.receipt_number AS 'Receipt Number', "
            + "collection_receipt.amount AS 'Receipt Amount', "
            + "sale_invoice.amount AS 'Invoice Amount', "
            + "sale_invoice.received_amount AS 'Total Received', "
            + "sale_invoice.credit AS 'Remaining Credit'"
            + "FROM "
            + "collection_receipt "
            + "INNER JOIN sale_invoice ON collection_receipt.sale_invoice_inv_no = sale_invoice.inv_no "
            + "INNER JOIN customer ON sale_invoice.customer_code = customer.`code` "
            + "INNER JOIN person ON person.nic = customer.`person_nic` "
            + "WHERE collection_receipt.collected_time BETWEEN ? AND ? "
            + "AND collection_receipt.amount < sale_invoice.amount";

    private static final String quotationItemBetweenDates
            = "SELECT "
            + "item.`code` as 'Code', "
            + "item.description as 'Item', "
            + "Sum(quotation_has_item.quantity) AS Quantity, "
            + "quotation_has_item.rate AS Rate "
            + "FROM "
            + "quotation_has_item "
            + "INNER JOIN item ON item.`code` = quotation_has_item.item_code "
            + "INNER JOIN quotation ON quotation.quotation_no = quotation_has_item.quotation_quotation_no "
            + "WHERE "
            + "quotation.quotation_time BETWEEN ? AND ? "
            + "AND quotation.amount != 0 "
            + "GROUP BY quotation_has_item.item_code,quotation_has_item.rate ";

    private static final String saleItemProfitBetweenDates
            = "SELECT "
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
            + "AND sale_invoice.amount != 0 "
            + "GROUP BY sale_invoice_has_item.item_code, sale_invoice_has_item.rate, sale_invoice_has_item.cost ";

    private static final String quotationItemBySupplierBetweenDates
            = "SELECT "
            + "item.`code` as 'Code', "
            + "item.description as 'Item', "
            + "Sum(quotation_has_item.quantity) AS Quantity, "
            + "quotation_has_item.rate AS Rate "
            + "FROM "
            + "quotation_has_item "
            + "INNER JOIN item ON item.`code` = quotation_has_item.item_code "
            + "INNER JOIN quotation ON quotation.quotation_no = quotation_has_item.quotation_quotation_no "
            + "WHERE "
            + "quotation.quotation_time BETWEEN ? AND ? "
            + "AND item.supplier_code = ? "
            + "AND quotation.amount != 0 "
            + "GROUP BY quotation_has_item.item_code,quotation_has_item.rate ";

    private static final String saleItemProfitBySupplierBetweenDates
            = "SELECT "
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
            + "AND item.supplier_code = ? "
            + "AND sale_invoice.amount != 0 "
            + "GROUP BY sale_invoice_has_item.item_code,sale_invoice_has_item.rate,sale_invoice_has_item.cost ";
//

    private static final String quotationItemByItemTypeBetweenDates
            = "SELECT "
            + "item.`code` as 'Code', "
            + "item.description as 'Item', "
            + "Sum(quotation_has_item.quantity) AS Quantity, "
            + "quotation_has_item.rate AS Rate "
            + "FROM "
            + "quotation_has_item "
            + "INNER JOIN item ON item.`code` = quotation_has_item.item_code "
            + "INNER JOIN quotation ON quotation.quotation_no = quotation_has_item.quotation_quotation_no "
            + "WHERE "
            + "quotation.quotation_time BETWEEN ? AND ? "
            + "AND item.item_type_type = ? "
            + "AND quotation.amount != 0 "
            + "GROUP BY quotation_has_item.item_code,quotation_has_item.rate ";

    private static final String saleItemProfitByItemTypeBetweenDates
            = "SELECT "
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
            + "AND item.item_type_type = ? "
            + "AND sale_invoice.amount != 0 "
            + "GROUP BY sale_invoice_has_item.item_code,sale_invoice_has_item.rate, sale_invoice_has_item.cost ";

    //
    private static final String quotationItemBySupplierAndItemTypeBetweenDates
            = "SELECT "
            + "item.`code` as 'Code', "
            + "item.description as 'Item', "
            + "Sum(quotation_has_item.quantity) AS Quantity, "
            + "quotation_has_item.rate AS Rate "
            + "FROM "
            + "quotation_has_item "
            + "INNER JOIN item ON item.`code` = quotation_has_item.item_code "
            + "INNER JOIN quotation ON quotation.quotation_no = quotation_has_item.quotation_quotation_no "
            + "WHERE "
            + "quotation.quotation_time BETWEEN ? AND ? "
            + "AND item.supplier_code = ? "
            + "AND item.item_type_type = ? "
            + "AND quotation.amount != 0 "
            + "GROUP BY quotation_has_item.item_code,quotation_has_item.rate ";

    private static final String saleItemProfitBySupplierAndItemTypeBetweenDates
            = "SELECT "
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
            + "AND item.supplier_code = ? "
            + "AND item.item_type_type = ? "
            + "AND sale_invoice.amount != 0 "
            + "GROUP BY sale_invoice_has_item.item_code,sale_invoice_has_item.rate, sale_invoice_has_item.cost ";

    private static final String itemTotalSaleBetweenDates = "SELECT "
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
    private static final String totalSaleProfitBetweenDates
            = "SELECT SUM(Profit) as Profit"
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
    private static final String totalSaleSummeryBetweenDates
            = "SELECT SUM(Income) as Income, SUM(Cost) as Cost, SUM(Profit) as Profit "
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
    private static final String totalExpensesBetweenDates
            = "SELECT SUM( expenses.amount) AS Total "
            + "FROM expenses "
            + "WHERE expenses.paid_time  BETWEEN ? AND ? ";
    private static final String totalPaymentsBetweenDates
            = "SELECT SUM(issued_cash.amount) AS Total "
            + "FROM issued_cash "
            + "WHERE issued_cash.issued_time BETWEEN ? AND ? ";
    private static final String totalChequesBetweenDates
            = "SELECT SUM(issued_cheque.amount) AS Total "
            + "FROM issued_cheque "
            + "WHERE issued_cheque.issued_date BETWEEN ? AND ?";
    private static final String quantityByItem
            = "SELECT quantity "
            + "FROM stock "
            + "WHERE item_code = ?";
    private static final String totalSalesBetweenDates = "SELECT Sum(sale_invoice.amount) AS total "
            + "FROM "
            + "sale_invoice "
            + "WHERE "
            + "sale_invoice.inv_time BETWEEN ? AND ? ";
    private static final String item = "SELECT * from item";
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
//

    public static ResultSet quotationItemBetweenDates(Date startDate, Date endDate) {
        connect();
        try {
            preparedStatement = con.prepareStatement(quotationItemBetweenDates);
            preparedStatement.setString(1, yyyy_MM_dd.format(startDate) + " 00:00:00");
            preparedStatement.setString(2, yyyy_MM_dd.format(endDate) + " 23:59:59");
            res = preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Errors.reportError(ex);
        }
        return res;
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

    public static ResultSet quotationItemBySupplierBetweenDates(Date startDate, Date endDate, String supplierCode) {
        connect();
        try {
            preparedStatement = con.prepareStatement(quotationItemBySupplierBetweenDates);
            preparedStatement.setString(1, yyyy_MM_dd.format(startDate) + " 00:00:00");
            preparedStatement.setString(2, yyyy_MM_dd.format(endDate) + " 23:59:59");
            preparedStatement.setString(3, supplierCode);
            res = preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Errors.reportError(ex);
        }
        return res;
    }

    public static ResultSet saleItemProfitBySupplierBetweenDates(Date startDate, Date endDate, String supplierCode) {
        connect();
        try {
            preparedStatement = con.prepareStatement(saleItemProfitBySupplierBetweenDates);
            preparedStatement.setString(1, yyyy_MM_dd.format(startDate) + " 00:00:00");
            preparedStatement.setString(2, yyyy_MM_dd.format(endDate) + " 23:59:59");
            preparedStatement.setString(3, supplierCode);
            res = preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Errors.reportError(ex);
        }
        return res;
    }

    public static ResultSet saleItemProfitByItemTypeBetweenDates(Date startDate, Date endDate, ItemType itemType) {
        connect();
        try {
            preparedStatement = con.prepareStatement(saleItemProfitByItemTypeBetweenDates);
            preparedStatement.setString(1, yyyy_MM_dd.format(startDate) + " 00:00:00");
            preparedStatement.setString(2, yyyy_MM_dd.format(endDate) + " 23:59:59");
            preparedStatement.setString(3, itemType.getType());
            res = preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Errors.reportError(ex);
        }
        return res;
    }

    public static ResultSet quotationItemByItemTypeBetweenDates(Date startDate, Date endDate, ItemType itemType) {
        connect();
        try {
            preparedStatement = con.prepareStatement(quotationItemByItemTypeBetweenDates);
            preparedStatement.setString(1, yyyy_MM_dd.format(startDate) + " 00:00:00");
            preparedStatement.setString(2, yyyy_MM_dd.format(endDate) + " 23:59:59");
            preparedStatement.setString(3, itemType.getType());
            res = preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Errors.reportError(ex);
        }
        return res;
    }

//
    public static ResultSet quotationItemBySupplierAndItemTypeBetweenDates(Date startDate, Date endDate, String supplierCode, String itemType) {
        connect();
        try {
            preparedStatement = con.prepareStatement(quotationItemBySupplierAndItemTypeBetweenDates);
            preparedStatement.setString(1, yyyy_MM_dd.format(startDate) + " 00:00:00");
            preparedStatement.setString(2, yyyy_MM_dd.format(endDate) + " 23:59:59");
            preparedStatement.setString(3, supplierCode);
            preparedStatement.setString(4, itemType);
            res = preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Errors.reportError(ex);
        }
        return res;
    }

    public static ResultSet saleItemProfitBySupplierAndItemTypeBetweenDates(Date startDate, Date endDate, String supplierCode, String itemType) {
        connect();
        try {
            preparedStatement = con.prepareStatement(saleItemProfitBySupplierAndItemTypeBetweenDates);
            preparedStatement.setString(1, yyyy_MM_dd.format(startDate) + " 00:00:00");
            preparedStatement.setString(2, yyyy_MM_dd.format(endDate) + " 23:59:59");
            preparedStatement.setString(3, supplierCode);
            preparedStatement.setString(4, itemType);
            res = preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Errors.reportError(ex);
        }
        return res;
    }
    
    public static ResultSet saleItemProfitBySupplier$ItemType$ItemCategory$BetweenDates(Date startDate, Date endDate, String supplierCode, String itemType, String itemCategory) {
        connect();
        try {
            String sql 
            = "SELECT "
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
            + "INNER JOIN item_type ON item_type.`type` = item.item_type_type "
            + "INNER JOIN sale_invoice ON sale_invoice.inv_no = sale_invoice_has_item.sale_invoice_inv_no "
            + "WHERE "
            + "sale_invoice.inv_time BETWEEN ? AND ? ";
            
            sql += supplierCode!=null ?"AND item.supplier_code = '"+supplierCode+"' ":"";
            sql += itemType !=null ?"AND item.item_type_type = '"+itemType+"' ":"";
            sql += itemCategory != null ? "AND item_type.item_category_category = '"+itemCategory+"' ":"";
            
            sql += "AND sale_invoice.amount != 0 ";
            sql += "GROUP BY sale_invoice_has_item.item_code,sale_invoice_has_item.rate, sale_invoice_has_item.cost ";
            
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, yyyy_MM_dd.format(startDate) + " 00:00:00");
            preparedStatement.setString(2, yyyy_MM_dd.format(endDate) + " 23:59:59");
            res = preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Errors.reportError(ex);
        }
        return res;
    }

    public static ResultSet itemTotalSaleBetweenDates(Date startDate, Date endDate) {
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
            ex.printStackTrace();
//            Errors.reportError(ex);
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

    public static double totalSalesBetweenDates(Date startDate, Date endDate) {
        connect();
        double totalPayments = 0;
        try {
            preparedStatement = con.prepareStatement(totalSalesBetweenDates);
            preparedStatement.setString(1, yyyy_MM_dd.format(startDate) + " 00:00:00");
            preparedStatement.setString(2, yyyy_MM_dd.format(endDate) + " 23:59:59");
            res = preparedStatement.executeQuery();
            if (res.next()) {
                totalPayments = res.getDouble("total");
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
//

    public static double quantityByItemCode(String code) {

        connect();
        double quantity = 0;
        try {
            preparedStatement = con.prepareStatement(quantityByItem);
            preparedStatement.setString(1, code);
            res = preparedStatement.executeQuery();
            if (res.next()) {
                quantity = res.getDouble("quantity");
            }
            close();
        } catch (SQLException ex) {
            Errors.reportError(ex);
        }
        return quantity;
    }

    static ResultSet item() {
        connect();
        try {
            preparedStatement = con.prepareStatement(item);
            res = preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Errors.reportError(ex);
        }
        return res;
    }
}
