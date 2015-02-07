package com.nanosl.nbiz.util;

import com.nanosl.lib.db.Manager;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Font;

public class Export {

    public static void exportToExcel(String tableName, ArrayList<String> columns) {
        try {
            String sqlString = " SELECT ";
            sqlString = columns.stream().map((next) -> next + "  ,").reduce(sqlString, String::concat);
            sqlString = sqlString.substring(0, sqlString.length() - 1);
            sqlString += " FROM " + tableName + " ;";

            ResultSet rs = Manager.getInstance().executeSqlQuery(sqlString);//"SELECT * FROM " + tableName + ";"
            ResultSetMetaData rsmd = rs.getMetaData();
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet(tableName + "s");
            HSSFRow rowhead = sheet.createRow(0);

            HSSFCellStyle style = workbook.createCellStyle();//Create style
            Font font = workbook.createFont();//Create font
            font.setBoldweight(Font.BOLDWEIGHT_BOLD);//Make font bold
            style.setFont(font);//set it to bold .

            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                HSSFCell cell = rowhead.createCell(i);
                cell.setCellValue(rsmd.getColumnName(i).toUpperCase());
                cell.setCellStyle(style);
            }
            sheet.createFreezePane(0, 1);
            int i0 = 1, i1 = 1;
            while (rs.next()) {
                if ((i0 % 65535) == 0) {
                    sheet = workbook.createSheet(i0 + "");
                    HSSFRow rowhead2 = sheet.createRow(0);
                    for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                        HSSFCell cell = rowhead2.createCell(i);
                        cell.setCellValue(rsmd.getColumnName(i).toUpperCase());
                        cell.setCellStyle(style);
                    }
                    sheet.createFreezePane(0, 1);
                    i1 = 1;
                }
                HSSFRow row = sheet.createRow(i1);
                for (int i2 = 1; i2 <= rsmd.getColumnCount(); i2++) {
                    row.createCell(i2).setCellValue(rs.getString(i2));
                }
                i0++;
                i1++;
            }
            String yemi = "C:/Users/Thilina/Desktop/" + tableName + (System.currentTimeMillis() / 1000) + ".xls";
            try (FileOutputStream fileOut = new FileOutputStream(yemi)) {
                workbook.write(fileOut);
            }
        } catch (SQLException e1) {
        } catch (FileNotFoundException e1) {
        } catch (IOException e1) {
        }
    }
}
