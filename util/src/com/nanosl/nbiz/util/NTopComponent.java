/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.util;

import com.nanosl.lib.db.Manager;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.windows.TopComponent;

/**
 *
 * @author Thilina Ranathunga
 */
public class NTopComponent extends TopComponent implements Format {

    public DefaultTableCellRenderer rightAlignCell = new DefaultTableCellRenderer() {
        private DefaultTableCellRenderer DEFAULT_RENDERER = new DefaultTableCellRenderer();

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = DEFAULT_RENDERER.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            DEFAULT_RENDERER.setHorizontalAlignment(javax.swing.JLabel.RIGHT);

            if (isSelected) {
                c.setForeground(Color.WHITE);
                c.setBackground(Color.BLACK);
//                c.setForeground(row % 2 == 0 ? Color.BLACK : Color.BLUE);
            } else {
                c.setForeground(Color.BLACK);
                if (row % 2 == 0) {
                    c.setBackground(Color.WHITE);
                } else {
                    c.setBackground(new Color(200, 230, 250));
                }
            }
            return c;
        }
    };
    public DefaultTableCellRenderer coloredCellRenderer = new DefaultTableCellRenderer() {
        private DefaultTableCellRenderer DEFAULT_RENDERER = new DefaultTableCellRenderer();

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = DEFAULT_RENDERER.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            if (isSelected) {
                c.setForeground(Color.WHITE);
                c.setBackground(Color.BLACK);
//                c.setForeground(row % 2 == 0 ? Color.BLACK : Color.BLUE);
            } else {
                c.setForeground(Color.BLACK);
                if (row % 2 == 0) {
                    c.setBackground(Color.WHITE);
                } else {
                    c.setBackground(new Color(200, 230, 250));
                }
            }
            return c;
        }
    };
    public Manager manager;

    public NTopComponent() {
        this.manager = Manager.getInstance();
//        rightAlignCell.setHorizontalAlignment(javax.swing.JLabel.RIGHT);
    }

    /*
     public static final DateFormat dd_MMMM_yyyy = new SimpleDateFormat("dd - MMMM - yyyy");
     public static final DateFormat dd_MM_yyyy = new SimpleDateFormat("dd-MM-yyyy");
     public static final DateFormat yyyy_MM_dd = new SimpleDateFormat("yyyy-MM-dd");
     public static final NumberFormat nf3p = new DecimalFormat("#000");
     public static final NumberFormat nf4p = new DecimalFormat("#00000");
     public static final NumberFormat nf0d = new DecimalFormat("#0");
     public static final NumberFormat nf1d = new DecimalFormat("#0.0");
     public static final NumberFormat nf2d = new DecimalFormat("#0.00");
     public static final NumberFormat nf3d = new DecimalFormat("#0.000");
     */
    protected void showError(String string) {
        NotifyDescriptor d =
                new NotifyDescriptor.Message(string, NotifyDescriptor.ERROR_MESSAGE);
        DialogDisplayer.getDefault().notify(d);
    }

    protected void showSuccess(String string) {
        NotifyDescriptor d =
                new NotifyDescriptor.Message(string, NotifyDescriptor.INFORMATION_MESSAGE);
        DialogDisplayer.getDefault().notify(d);
    }
}
