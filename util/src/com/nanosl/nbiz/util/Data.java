package com.nanosl.nbiz.util;

import com.nanosl.lib.db.Manager;
import entity.Company;
import entity.Customer;
import entity.Employee;
import entity.EmployeePosition;
import entity.General;
import entity.Item;
import entity.ItemCategory;
import entity.ItemType;
import entity.Operator;
import entity.Person;
import entity.Supplier;
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

    static int userCount = 0;

    static {
        getUserCount();
    }

    public static Operator getOperator() {

        if (userCount == 0) {
            Data.initFirstUser();
//            first();
        }
        if (operator == null) {
            manager.clearCache();
            operator = manager.find(Operator.class, "");
//            operator = new Operator("admin");
//            operator.setPassword("n");
//            manager.update(operator);
        }
//        operator = manager.find(Operator.class, operator != null ? operator.getUsername() : "");
        return operator;
    }

    public static String getInvoiceNo() {
        manager.clearCache();
        General general = manager.findOne(General.class);

        System.out.println(general + " ***************** General******");
        if (general == null) {
            general = new General();
            general.setInvoiceNo("0");
            general.setReceiptNo("0");
            manager.update(general);
            general = manager.findOne(General.class);
        }
        System.out.println(general);
        return general.getInvoiceNo();
    }

    public static String getReceiptNo() {
        manager.clearCache();
        General general = manager.findOne(General.class);
        if (general == null) {
            general = new General();
            general.setInvoiceNo("0");
            general.setReceiptNo("0");
            manager.update(general);
            general = manager.findOne(General.class);
        }
        return general == null ? "000" : general.getReceiptNo();
    }

    public static void setReceiptNo(String lastReceiptNo) {
        try {
            int reciptNo = Integer.parseInt(lastReceiptNo);
            General general = manager.findOne(General.class);
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
            General general = manager.findOne(General.class);
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
            String companyName = getCompany().getName();
            String addressNumber = getCompany().getAddressNumber();
            String addressStreet = getCompany().getAddressStreet();
            String city = getCompany().getAddressCity();
            String contactOne = getCompany().getContactOne();
            String contactTwo = getCompany().getContactTwo();
            String email = getCompany().getEmail();
            String fax = getCompany().getFax();
            String web = getCompany().getWeb();
            params.put("company", companyName == null ? "" : companyName);
            params.put("address", (addressNumber == null ? "" : addressNumber) + " " + (addressStreet == null ? "" : addressStreet) + " " + (city == null ? "" : city));
            params.put("phone", (contactOne == null ? "" : contactOne) + " " + (contactTwo == null ? "" : contactTwo));
            params.put("email", email == null ? "" : email);
            params.put("fax", fax == null ? "" : fax);
            params.put("web", web == null ? "" : web);
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
        person.setName("ADMINISTRATOR");
        employee.setPerson(person);
        EmployeePosition employeePosition = new EmployeePosition("ADMIN");
        employee.setEmployeePosition(employeePosition);
        operator.setEmployee(employee);
        Collection<Operator> operators = new ArrayList<>();
        operators.add(operator);
        ViewPanel PermissionTopComponent = new ViewPanel("PermissionTopComponent");
        ViewPanel CompanyTopComponent = new ViewPanel("CompanyTopComponent");
        PermissionTopComponent.setOperatorCollection(operators);
        CompanyTopComponent.setOperatorCollection(operators);
        Collection<ViewPanel> viewPanels = new ArrayList<>();
        viewPanels.add(PermissionTopComponent);
        viewPanels.add(CompanyTopComponent);
        operator.setViewPanelCollection(viewPanels);
        List<Serializable> serializables = new ArrayList<>();
        serializables.add(person);
        serializables.add(employeePosition);
        serializables.add(employee);
        serializables.add(PermissionTopComponent);
        serializables.add(CompanyTopComponent);
        serializables.add(operator);
        manager.update(serializables);

            setOperator(manager.find(Operator.class, "admin"));
        getUserCount();
    }

    public static void initDefaults() {

        List<Serializable> serializables = new ArrayList<>();

        if (manager.find(ItemType.class).isEmpty()) {
            serializables.add(new ItemType("DEFAULT"));
        }

        if (manager.find(Item.class).isEmpty()) {
            serializables.add(new Item("DEFAULT"));
        }

        if (manager.find(Customer.class).isEmpty()) {
            serializables.add(new Customer("DEFAULT"));
        }

        if (manager.find(ItemCategory.class).isEmpty()) {
            serializables.add(new ItemCategory("DEFAULT"));
        }

        if (manager.find(Supplier.class).isEmpty()) {
            serializables.add(new Supplier("DEFAULT"));
        }

        if (manager.find(Company.class).isEmpty()) {
            WindowManager.getDefault().invokeWhenUIReady(new Runnable() {
                @Override
                public void run() {
                    TopComponent tc = WindowManager.getDefault().findTopComponent("CompanyTopComponent");
                    if (tc != null) {
                        tc.open();
                        tc.requestActive();
                    }
                }
            });
        }

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

    private static int getUserCount() {
        userCount = manager.count(Operator.class);
        return userCount;
    }
}
