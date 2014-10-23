/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanos.nbiz.pos;

import com.nanosl.lib.db.Manager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Thilina
 */
class Fix {

//    static Manager manager = Manager.getInstance();
    static Connection connection = Manager.getInstance().getConnection();

    static void e20140911() {
        String tableName = "sale_invoice";
        String columnName = "paid_amount";
        try {
            ResultSet resultSet = connection.getMetaData().getColumns(null, null, tableName, "%");
            boolean found = false;
            while (resultSet.next()) {
                String s = resultSet.getString(4);
                if (columnName.equalsIgnoreCase(s)) {
                    found = true;
                }
            }
            if (!found) {
                try (PreparedStatement ps = connection.prepareStatement("ALTER TABLE " + tableName + " ADD COLUMN  `" + columnName + "` double DEFAULT NULL;")) {
                    ps.executeUpdate();
                }
            }
        } catch (SQLException ex) {
//            Exceptions.printStackTrace(ex);
            System.out.println(ex.getLocalizedMessage());
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
        }
    }

}

/*
 ResultSet resultSet = Manager.getInstance().getConnection().getMetaData().getColumns(null, null, "sale_invoice", "%");
 //             = FindMySql.listColumnsOfTable("sale_invoice");
 //            System.out.println(resultSet.gets);
 int cc = resultSet.getMetaData().getColumnCount();
 System.out.println("===========================================================");
 boolean found = false;
 while (resultSet.next()) {
 //                for (int i = 1; i < = cc; i++) {
 String s = resultSet.getString(4);
 if ("paid_amount".equalsIgnoreCase(s)) {
 found = true;
 }
 System.out.println(s + " # ");
 //                }
 //                System.out.println("");
 }
 if (!found) {
 PreparedStatement ps = Manager.getInstance().getConnection().prepareStatement("ALTER TABLE sale_invoice ADD COLUMN  `paid_amount` double DEFAULT NULL;");
 ps.executeUpdate();
 ps.close();
 }
 } catch (SQLException ex) {
 Exceptions.printStackTrace(ex);
 }

 */
