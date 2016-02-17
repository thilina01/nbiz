package com.nanosl.nbiz.util;

import com.nanosl.lib.db.Manager;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFTable;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openide.util.Exceptions;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.*;

public class Export {

    public static void exportToExcel(String tableName, ArrayList<String> columns) {
        try {
            String sqlString = " SELECT ";
            sqlString = columns.stream().map((next) -> next + "  ,").reduce(sqlString, String::concat);
            sqlString = sqlString.substring(0, sqlString.length() - 1);
            sqlString += " FROM " + tableName + " ;";

            ResultSet rs = Manager.getInstance().executeSqlQuery(sqlString);//"SELECT * FROM " + tableName + ";"
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet(tableName + "s");
            HSSFRow rowhead = sheet.createRow(0);

            HSSFCellStyle style = workbook.createCellStyle();//Create style
            Font font = workbook.createFont();//Create font
            font.setBoldweight(Font.BOLDWEIGHT_BOLD);//Make font bold
            style.setFont(font);//set it to bold .

            for (int i = 1; i <= columnCount; i++) {
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
                    for (int i = 1; i <= columnCount; i++) {
                        HSSFCell cell = rowhead2.createCell(i);
                        cell.setCellValue(rsmd.getColumnName(i).toUpperCase());
                        cell.setCellStyle(style);
                    }
                    sheet.createFreezePane(0, 1);
                    i1 = 1;
                }
                HSSFRow row = sheet.createRow(i1);
                for (int i2 = 1; i2 <= columnCount; i2++) {
                    row.createCell(i2).setCellValue(rs.getString(i2));
                }
                i0++;
                i1++;
            }

            for (int columnNumber = 0; columnNumber < columnCount; columnNumber++) {
                sheet.autoSizeColumn(columnNumber);
            }
            String userHomeFolder = System.getProperty("user.home");
            String exportFolder = userHomeFolder + File.separator + "Export";
            new File(exportFolder).mkdir();
            String yemi = exportFolder + File.separator + tableName + (System.currentTimeMillis() / 1000) + ".xls";
            try (FileOutputStream fileOut = new FileOutputStream(yemi)) {
                workbook.write(fileOut);
                System.out.println("Written to: " + yemi);
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(new File(exportFolder));
                }
//                Runtime.getRuntime().exec(exportFolder);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public static void toExcel(JTable jTable, String pageName, String saveName) {

//        HSSFWorkbook workbook = new HSSFWorkbook();
//        Sheet sheet = workbook.createSheet(pageName); //WorkSheet
//        Row row = sheet.createRow(2); //Row created at line 3
        TableModel model = jTable.getModel(); //Table model
        int columnCount = model.getColumnCount(); // Number of columns in table
        int rowCount = model.getRowCount(); // Number of rows in table
        if (rowCount == 0) {
            return;
        }
        /**
         * **************************************************
         */

        XSSFWorkbook xSSFWorkbook = new XSSFWorkbook();
        XSSFSheet xSSFSheet = (XSSFSheet) xSSFWorkbook.createSheet(pageName);

        //Create 
        XSSFTable xSSFTable = xSSFSheet.createTable();
        xSSFTable.setDisplayName("Test");
        CTTable cttable = xSSFTable.getCTTable();

        //Style configurations
        CTTableStyleInfo cTTableStyleInfo = cttable.addNewTableStyleInfo();
        cTTableStyleInfo.setName("TableStyleMedium2");
        cTTableStyleInfo.setShowColumnStripes(false);
        cTTableStyleInfo.setShowRowStripes(true);

        //Set which area the table should be placed in
        AreaReference areaReference = new AreaReference(new CellReference(0, 0), new CellReference(rowCount, columnCount - 1));
        cttable.setRef(areaReference.formatAsString());
        cttable.setId(1);
        cttable.setName("Test");

        CTTableColumns cTTableColumns = cttable.addNewTableColumns();
        cTTableColumns.setCount(columnCount);
        CTTableColumn cTTableColumn;
        XSSFRow xSSFRow;
        XSSFCell xSSFCell;

        for (int i = 0; i < columnCount; i++) {
            //Create column
            cTTableColumn = cTTableColumns.addNewTableColumn();
            cTTableColumn.setName("Column");
            cTTableColumn.setId(i + 1);
        }

        //Create row
        xSSFRow = xSSFSheet.createRow(0);
        for (int j = 0; j < columnCount; j++) {
            //Create cell
            xSSFCell = xSSFRow.createCell(j);
            xSSFCell.setCellValue(model.getColumnName(j));
        }

        for (int x = 0; x < rowCount; x++) {
            xSSFRow = xSSFSheet.createRow(x + 1);
            for (int j = 0; j < columnCount; j++) {
                //Create cell
                xSSFCell = xSSFRow.createCell(j);
                Object value = model.getValueAt(x, j);
                xSSFCell.setCellValue(value == null ? "" : value.toString()); //Write value
            }
        }
        for (int columnNumber = 0; columnNumber < columnCount; columnNumber++) {
            xSSFSheet.autoSizeColumn(columnNumber);
        }
//            //Create row
//            row = sheet.createRow(i);
//            for (int j = 0; j < columnCount; j++) {
//                //Create cell
//                cell = row.createCell(j);
//                if (i == 0) {
//                    cell.setCellValue(model.getColumnName(j));
//                } else {
////                    cell.setCellValue("0");
//                    Object value = model.getValueAt(i, j);
//                    cell.setCellValue(value == null ? "" : value.toString()); //Write value
////            
//                }
//            }
//        }
//        

//        FileOutputStream fileOut = new FileOutputStream("ooxml-table.xlsx");
//        workbook.write(fileOut);
//        fileOut.close();
        /**
         * **************************************************
         */
//        Row headerRow = sheet.createRow(0); //Create row at line 0
//        for (int headings = 0; headings < columnCount; headings++) { //For each column
//            headerRow.createCell(headings).setCellValue(model.getColumnName(headings));//Write column name
//        }
//        for (int rowNumber = 0; rowNumber < rowCount; rowNumber++) { //For each table row
//            //Set the row to the next one in the sequence 
//            row = sheet.createRow((rowNumber + 3));
//            for (int cols = 0; cols < jTable.getColumnCount(); cols++) { //For each table column
//                Object value = model.getValueAt(rowNumber, cols);
//                row.createCell(cols).setCellValue(value == null ? "" : value.toString()); //Write value
//            }
//
//        }
//        for (int columnNumber = 0; columnNumber < columnCount; columnNumber++) {
//            sheet.autoSizeColumn(columnNumber);
//        }
        String userHomeFolder = System.getProperty("user.home");
        String exportFolder = userHomeFolder + File.separator + "Export";
        new File(exportFolder).mkdir();
        String yemi = exportFolder + File.separator + saveName + " on " + Format.yyyy_MM_dd_hh_mm_ss_a_Space.format(new Date()) + ".xlsx";
        try (FileOutputStream fileOut = new FileOutputStream(yemi)) {
            xSSFWorkbook.write(fileOut);
            System.out.println("Written to: " + yemi);
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(new File(exportFolder));
            }
//                Runtime.getRuntime().exec(exportFolder);
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
    }
}
