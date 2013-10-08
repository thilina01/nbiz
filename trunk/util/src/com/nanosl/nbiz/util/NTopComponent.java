/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.util;

import com.nanosl.lib.db.Manager;
import javax.swing.table.DefaultTableCellRenderer;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.windows.TopComponent;

/**
 *
 * @author Thilina Ranathunga
 */
public class NTopComponent extends TopComponent implements Format {

    public DefaultTableCellRenderer rightAlignCell = new DefaultTableCellRenderer();
    public Manager m = Manager.getInstance();

    public NTopComponent() {
        rightAlignCell.setHorizontalAlignment(javax.swing.JLabel.RIGHT);
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
