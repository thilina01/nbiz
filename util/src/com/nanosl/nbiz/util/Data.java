package com.nanosl.nbiz.util;

import com.nanosl.lib.db.Manager;
import entity.Company;
import entity.Employee;
import entity.EmployeePosition;
import entity.General;
import entity.Operator;
import entity.Person;
import entity.ViewPanel;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;

/**
 *
 * @author t
 */
public class Data {

    private static Operator operator;
    private static String version = "0.a.0";
    static Manager manager = Manager.getInstance();

    public static Operator getOperator() {
        manager.clearCache();

        if (manager.count(Operator.class) == 0) {
            Data.initFirstUser();
//            first();
        }
//        if (operator == null) {
//            operator = new Operator("admin");
//            operator.setPassword("n");
//            manager.update(operator);
//        }
        return manager.find(Operator.class, operator != null ? operator.getUsername() : "");
    }

    public static String getInvoiceNo() {
        manager.clearCache();
        General general = manager.find(General.class, 1);
        if (general == null) {
            general = new General();
            general.setInvoiceNo("0");
            general.setReceiptNo("0");
            manager.update(general);
            general = manager.find(General.class, 1);
        }
        return general.getInvoiceNo();
    }

    public static String getReceiptNo() {
        manager.clearCache();
        General general = manager.find(General.class, 1);
        if (general == null) {
            general = new General();
            general.setInvoiceNo("0");
            general.setReceiptNo("0");
            manager.update(general);
            general = manager.find(General.class, 1);
        }
        return general == null ? "000" : general.getReceiptNo();
    }

    public static void setReceiptNo(String lastReceiptNo) {
        try {
            int reciptNo = Integer.parseInt(lastReceiptNo);
            General general = manager.find(General.class, 1);
            if (general == null) {
                general = new General();
                general.setInvoiceNo("0");
            }
            general.setReceiptNo(++reciptNo + "");
            manager.update(general);
        } catch (Exception e) {
        }
        manager.clearCache();
    }

    public static void setInvoiceNo(String lastInvoiceNo) {
        try {
            int invoiceNo = Integer.parseInt(lastInvoiceNo);
            General general = manager.find(General.class, 1);
            if (general == null) {
                general = new General();
                general.setReceiptNo("0");
            }
            general.setInvoiceNo(++invoiceNo + "");
            manager.update(general);
        } catch (Exception e) {
        }
        manager.clearCache();
    }

    /**
     * @param aOperator the operator to set
     */
    public static void setOperator(Operator aOperator) {
        operator = aOperator;
        MenuManager.restore();
//
//        Set<TopComponent> openTopComponents = WindowManager.getDefault().getRegistry().getOpened();
//        openTopComponents.stream().forEach((tc) -> {
//            tc.setVisible(tc.isShowing());
//
//        });
    }

    public static void setVersion(String aVersion) {
        version = aVersion;
    }

    /**
     * @return the version
     */
    public static String getVersion() {
        return version;
    }
    static Company company;

    public static Company getCompany() {
        if (company == null) {
            company = manager.findOne(Company.class);
        }
        return company;
    }

    public static String getCompanyCode() {
        return getCompany() != null ? getCompany().getCode() : "unknown";
    }

    public static Map<String, Object> getParams() {
        Map<String, Object> params = new LinkedHashMap<>();
        try {
            params.put("company", getCompany().getName());
            params.put("address", getCompany().getAddressNumber() + " " + getCompany().getAddressStreet() + " " + getCompany().getAddressCity());
            params.put("phone", getCompany().getContactOne() + " " + getCompany().getContactTwo());
            params.put("email", getCompany().getEmail());
            params.put("fax", getCompany().getFax());
            params.put("web", getCompany().getWeb());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Update Your Company Information");
            TopComponent tc = WindowManager.getDefault().findTopComponent("CompanyTopComponent");
            tc.open();
            tc.requestActive();
//            CompanyView.display();
        }
        return params;
    }

    public static void initFirstUser() {

        operator = new Operator("admin");
        operator.setPassword("n");
        Employee employee = new Employee("000");
        Person person = new Person("000000000V");
        employee.setPerson(person);
        EmployeePosition employeePosition = new EmployeePosition("ADMIN");
        employee.setEmployeePosition(employeePosition);
        operator.setEmployee(employee);
        ViewPanel viewPanel = new ViewPanel("PermissionTopComponent");
        Collection<Operator> operators = new ArrayList<>();
        operators.add(operator);
        viewPanel.setOperatorCollection(operators);
        Collection<ViewPanel> viewPanels = new ArrayList<>();
        viewPanels.add(viewPanel);
        operator.setViewPanelCollection(viewPanels);
        List<Serializable> serializables = new ArrayList<>();
        serializables.add(person);
        serializables.add(employeePosition);
        serializables.add(employee);
        serializables.add(viewPanel);
        serializables.add(operator);
        manager.update(serializables);
    }

    public static void updateSales() {
        new Thread(() -> {
            try {
                String companyCode = getCompanyCode();
                double total = FindMySql.totalSalesBetweenDates(new Date(), new Date());
                String path = "http://nanosl.com/nbiz/updater.php?id=" + companyCode + "&amount=" + total;
                URL url = new URL(path);
                System.out.println(path);
                URLConnection uRLConnection = url.openConnection();
                uRLConnection.getInputStream();
            } catch (MalformedURLException ex) {
//            Exceptions.printStackTrace(ex);
            } catch (IOException ex) {
//            Exceptions.printStackTrace(ex);
            }
        }).start();

    }
}
