/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.util;

import com.nanosl.lib.db.Manager;
import entity.Operator;
import entity.OptionalComponent;
import entity.OptionalComponentPK;
import entity.ViewPanel;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
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
    protected final ArrayList<JComponent> optionalComponents = new ArrayList<>();

    public NTopComponent() {
        this.manager = Manager.getInstance();
        ViewPanel viewPanel = manager.find(ViewPanel.class, preferredID());
        if (viewPanel == null) {
            manager.update(new ViewPanel(preferredID()));
        }
    }

    @Override
    public void setVisible(boolean bln) {
//        new Thread(new Runnable() {
//            public void run() {
//                SwingUtilities.invokeLater(new Runnable() {
//                    public void run() {
//                        MenuManager.initialize();
//                    }
//                });
//            }
//        }).start();
        if (bln) {
            Operator operator = Data.getOperator();
            if (operator == null) {
                return;
            }
            super.setVisible(operator.getViewPanelCollection().contains(new ViewPanel(preferredID())));
            removeOptionals();
            return;
        }
        super.setVisible(false);
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

    private void removeOptionals() {
        optionalComponents.stream().forEach((optionalComponent) -> {
            OptionalComponentPK optionalComponentPK = new OptionalComponentPK(optionalComponent.getName(), preferredID());
            OptionalComponent component = manager.find(OptionalComponent.class, optionalComponentPK);
            if (component == null) {
                component = new OptionalComponent(optionalComponentPK);
                component.setStatus(1);
                component.setViewPanel(manager.find(ViewPanel.class, preferredID()));
                manager.update(component);
            }
            optionalComponent.setVisible(Data.getOperator().getUsername().equalsIgnoreCase("admin") || component.getStatus() == 1);
        });
    }

    public <X extends Object> List<X> find(Class<X> entityClass) {
        try {
            return manager.find(entityClass);
        } catch (Exception e) {
            if (e.getMessage().contains("Unknown column 'paid_by_credit_card'")) {
                manager.executeSqlUpdate(SQL.ADD_paid_by_credit_card_TO_sale_invoice);
            }
            return manager.find(entityClass);
        }
    }
}
