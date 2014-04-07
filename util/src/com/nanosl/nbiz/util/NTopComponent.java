/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.util;

import com.nanosl.lib.db.Manager;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.awt.NotificationDisplayer;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;

/**
 *
 * @author Thilina Ranathunga
 */
public class NTopComponent extends TopComponent implements Format, Cell {

    public Manager manager;
    protected static PrintViewTopComponent printViewTopComponent = (PrintViewTopComponent) WindowManager.getDefault().findTopComponent("PrintViewTopComponent");

    public NTopComponent() {
        this.manager = Manager.getInstance();
//        rightAlignCell.setHorizontalAlignment(javax.swing.JLabel.RIGHT);
    }

    public Date makeEndDate(Date endDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(endDate);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 900);
        return calendar.getTime();
    }
    public Date makeStartDate(Date startDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        calendar.set(Calendar.HOUR_OF_DAY, 00);
        calendar.set(Calendar.MINUTE, 00);
        calendar.set(Calendar.SECOND, 00);
        calendar.set(Calendar.MILLISECOND, 00);
        return calendar.getTime();
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
        NotifyDescriptor d
                = new NotifyDescriptor.Message(string, NotifyDescriptor.ERROR_MESSAGE);
        DialogDisplayer.getDefault().notify(d);
    }

    protected void showSuccess(String string) {
        NotifyDescriptor d
                = new NotifyDescriptor.Message(string, NotifyDescriptor.INFORMATION_MESSAGE);
        DialogDisplayer.getDefault().notify(d);
    }

    protected void showMessage(String string) {
        NotifyDescriptor d
                = new NotifyDescriptor.Message(string, NotifyDescriptor.PLAIN_MESSAGE);
        DialogDisplayer.getDefault().notify(d);
    }

    protected void showNotification(String title, String details) {
        ImageIcon imageIcon = new javax.swing.ImageIcon(NTopComponent.class.getResource("/com/nanosl/nbiz/util/resources/accept16.png"));
        NotificationDisplayer.getDefault().notify(title, imageIcon, details, null);
    }
}
