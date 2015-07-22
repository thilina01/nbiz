package com.nanosl.nbiz.util;

import com.nanosl.lib.db.Manager;
import entity.Company;
import entity.General;
import entity.Operator;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;
//import ui.CompanyView;

/**
 *
 * @author t
 */
public class Data {

    private static Operator operator;
    private static String version = "0.a.0";
    static Manager m = Manager.getInstance();

    public static Operator getOperator() {
        m.clearCache();
        if (operator == null) {
            operator = new Operator("admin");
            operator.setPassword("n");
            m.update(operator);
        }
        return m.find(Operator.class, operator.getUsername());
    }

    public static String getInvoiceNo() {
        m.clearCache();
        General general = m.find(General.class, 1);
        if (general == null) {
            general = new General();
            general.setInvoiceNo("0");
            general.setReceiptNo("0");
            m.update(general);
            general = m.find(General.class, 1);
        }
        return general.getInvoiceNo();
    }

    public static String getReceiptNo() {
        m.clearCache();
        General general = m.find(General.class, 1);
        if (general == null) {
            general = new General();
            general.setInvoiceNo("0");
            general.setReceiptNo("0");
            m.update(general);
            general = m.find(General.class, 1);
        }
        return general == null ? "000" : general.getReceiptNo();
    }

    public static void setReceiptNo(String lastReceiptNo) {
        try {
            int reciptNo = Integer.parseInt(lastReceiptNo);
            General general = m.find(General.class, 1);
            if (general == null) {
                general = new General();
                general.setInvoiceNo("0");
            }
            general.setReceiptNo(++reciptNo + "");
            m.update(general);
        } catch (Exception e) {
        }
        m.clearCache();
    }

    public static void setInvoiceNo(String lastInvoiceNo) {
        try {
            int invoiceNo = Integer.parseInt(lastInvoiceNo);
            General general = m.find(General.class, 1);
            if (general == null) {
                general = new General();
                general.setReceiptNo("0");
            }
            general.setInvoiceNo(++invoiceNo + "");
            m.update(general);
        } catch (Exception e) {
        }
        m.clearCache();
    }

    /**
     * @param aOperator the operator to set
     */
    public static void setOperator(Operator aOperator) {
        operator = aOperator;
        MenuManager.restore();
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
            company = m.findOne(Company.class);
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

    public static void updateSales() {
        new Thread(() -> {
            try {
                String companyCode = getCompanyCode();
                double total = FindMySql.totalSalesBetweenDates(new Date(), new Date());
                String path = "http://nanosl.com/nbiz/updater.php?id=" + companyCode + "&amount=" + total;
                URL url = new URL(path);
                System.out.println(path);
                URLConnection yc = url.openConnection();
                yc.getInputStream();
            } catch (MalformedURLException ex) {
//            Exceptions.printStackTrace(ex);
            } catch (IOException ex) {
//            Exceptions.printStackTrace(ex);
            }
        }).start();

    }
}
