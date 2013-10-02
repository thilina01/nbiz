package com.nanosl.nbiz.util;

import com.nanosl.lib.db.Manager;
import entity.Company;
import entity.General;
import entity.Operator;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.JOptionPane;
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
        return general.getReceiptNo();
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

    public static Map<String, Object> getParams() {
        Map<String, Object> params = new LinkedHashMap<String, Object>();
        try {
            Company company = m.find(Company.class).get(0);
            params.put("company", company.getName());
            params.put("address", company.getAddressNumber() + " " + company.getAddressStreet() + " " + company.getAddressCity());
            params.put("phone", company.getContactOne() + " " + company.getContactTwo());
            params.put("email", company.getEmail());
            params.put("fax", company.getFax());
            params.put("web", company.getWeb());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Update Your Company Information");
//            CompanyView.display();
        }
        return params;
    }
}
