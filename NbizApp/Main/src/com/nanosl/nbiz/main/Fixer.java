/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.main;

import com.nanosl.lib.db.Manager;
import entity.Fix;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openide.util.Exceptions;

/**
 *
 * @author Thilina
 */
public class Fixer {

    static String x20150709a = "CREATE TABLE IF NOT EXISTS `issued_cheque_has_purchase_invoice` ("
            + " `issued_cheque_cheque_number` varchar(30) NOT NULL,"
            + " `purchase_invoice_inv_no` varchar(20) NOT NULL,"
            + " `purchase_invoice_supplier_code` varchar(10) NOT NULL,"
            + " PRIMARY KEY (`issued_cheque_cheque_number`,`purchase_invoice_inv_no`,`purchase_invoice_supplier_code`),"
            + " KEY `fk_issued_cheque_has_purchase_invoice_purchase_invoice1_idx` (`purchase_invoice_inv_no`,`purchase_invoice_supplier_code`),"
            + " KEY `fk_issued_cheque_has_purchase_invoice_issued_cheque1_idx` (`issued_cheque_cheque_number`),"
            + " CONSTRAINT `fk_issued_cheque_has_purchase_invoice_issued_cheque1` FOREIGN KEY (`issued_cheque_cheque_number`) REFERENCES `issued_cheque` (`cheque_number`) ON DELETE NO ACTION ON UPDATE NO ACTION,"
            + " CONSTRAINT `fk_issued_cheque_has_purchase_invoice_purchase_invoice1` FOREIGN KEY (`purchase_invoice_inv_no`, `purchase_invoice_supplier_code`) REFERENCES `purchase_invoice` (`inv_no`, `supplier_code`) ON DELETE NO ACTION ON UPDATE NO ACTION"
            + ") ENGINE=InnoDB DEFAULT CHARSET=latin1;";

//static String x = "CREATE TABLE IF NOT EXISTS`optional_component` ("
// + " `name` varchar(100) NOT NULL,"
// + " `status` int(11) DEFAULT NULL,"
// + " `view_panel_view_panel` varchar(100) NOT NULL,"
// + " PRIMARY KEY (`name`,`view_panel_view_panel`),"
// + " KEY `fk_optional_component_view_panel1_idx` (`view_panel_view_panel`),"
// + " CONSTRAINT `fk_optional_component_view_panel1` FOREIGN KEY (`view_panel_view_panel`) REFERENCES `view_panel` (`view_panel`) ON DELETE NO ACTION ON UPDATE NO ACTION"
// + ") ENGINE=InnoDB DEFAULT CHARSET=latin1;";
//
    static String x20150709b = "ALTER TABLE `issued_cheque` "
            + "CHANGE COLUMN `issued_date` `issued_date` DATETIME NULL DEFAULT NULL ;";

    static String createTableToolBarButton = "CREATE TABLE IF NOT EXISTS `tool_bar_button` ("
            + " `component_name` VARCHAR(150) NOT NULL,"
            + " `button_text` VARCHAR(45) NULL,"
            + " `icon_path` VARCHAR(1000) NULL,"
            + " `status` INT NULL,"
            + " PRIMARY KEY (`component_name`))"
            + " ENGINE = InnoDB";

    static String x20150711 = "ALTER TABLE `item` CHANGE COLUMN `disable` `status` INT(11) NULL DEFAULT '0' ;";
    static String CREATE_TABLE_FIX = "CREATE TABLE IF NOT EXISTS `fix` ("
            + " `fix_id` VARCHAR(100) NOT NULL,"
            + " PRIMARY KEY (`fix_id`))"
            + " ENGINE = InnoDB";

    static String ADD_paid_by_credit_card_TO_sale_invoice = "ALTER TABLE `sale_invoice` ADD COLUMN `paid_by_credit_card` double NULL AFTER `paid_amount`;";
    static String x20150712b = "ALTER TABLE `employee` ADD COLUMN `person_nic` VARCHAR(10) NOT NULL AFTER `code`;";
    static String x20150716a = "ALTER TABLE `supplier` ADD COLUMN `vat` VARCHAR(20) NULL;";
    static String x20150716b = "ALTER TABLE `supplier` ADD COLUMN `svat` VARCHAR(20) NULL;";
    static String x20150716c = "ALTER TABLE `company` ADD COLUMN `vat` VARCHAR(20) NULL;";
    static String x20150716d = "ALTER TABLE `company` ADD COLUMN `svat` VARCHAR(20) NULL;";
    static String addAccountAccountNoToSaleCheque = "ALTER TABLE `sale_cheque` ADD COLUMN `account_account_no` VARCHAR(50) NULL;";
    static String addAccountBankCodeToSaleCheque = "ALTER TABLE `sale_cheque` ADD COLUMN `account_bank_code` VARCHAR(30) NULL;";
    static String addcustomerCodeToCollectionReceipt = "ALTER TABLE `collection_receipt` ADD COLUMN `customer_code` VARCHAR(20) NULL;";
    static String addQuotation_noToGeneral = "ALTER TABLE `general` ADD COLUMN `quotation_no` VARCHAR(10) NULL;";
    static String addCreditToCustomer = "ALTER TABLE `customer` ADD COLUMN `credit` DOUBLE;";
    static String addAmountInCashToCollectionReceipt = "ALTER TABLE `collection_receipt` ADD COLUMN `amount_in_cash` DOUBLE;";
    static String addAccountAccountNoToIssuedCheque = "ALTER TABLE `issued_cheque` ADD COLUMN `account_account_no` VARCHAR(50) NULL;";
    static String addAccountBankCodeToIssuedCheque = "ALTER TABLE `issued_cheque` ADD COLUMN `account_bank_code` VARCHAR(30) NULL;";
    static String addFreeQuantityToPurchaseInvoiceHasItem = "ALTER TABLE `purchase_invoice_has_item` ADD COLUMN `free_quantity` DOUBLE;";
    static String x20150717a = "CREATE TABLE IF NOT EXISTS `svat` ("
            + " `serial_number` INT NOT NULL,"
            + " `svat_amount` DOUBLE NULL,"
            + " `purchasing_amount` DOUBLE NULL,"
            + " `issued_date` DATETIME NULL,"
            + " `ending_month` DATE NULL,"
            + " `supplier_code` VARCHAR(10) NOT NULL,"
            + " PRIMARY KEY (`serial_number`),"
            + " INDEX `fk_svat_supplier1_idx` (`supplier_code` ASC),"
            + " CONSTRAINT `fk_svat_supplier1`"
            + " FOREIGN KEY (`supplier_code`)"
            + " REFERENCES `supplier` (`code`)"
            + " ON DELETE NO ACTION"
            + " ON UPDATE NO ACTION)"
            + " ENGINE = InnoDB";
    static String CREATE_TABLE_PERSON = "CREATE TABLE IF NOT EXISTS `person` ("
            + "  `nic` VARCHAR(10) NOT NULL,"
            + "  `name` VARCHAR(250) NULL,"
            + "  `address` VARCHAR(150) NULL,"
            + "  `city` VARCHAR(60) NULL,"
            + "  `mobile` VARCHAR(10) NULL,"
            + "  `personcol` VARCHAR(45) NULL,"
            + "  `operator` VARCHAR(15) NULL,"
            + "  PRIMARY KEY (`nic`))"
            + "  ENGINE = InnoDB";

    static String CREATE_TABLE_QUOTATION = "CREATE TABLE IF NOT EXISTS `quotation` ("
            + "  `quotation_no` varchar(255) NOT NULL,"
            + "  `amount` double DEFAULT NULL,"
            + "  `discount` double DEFAULT NULL,"
            + "  `quotation_time` datetime DEFAULT NULL,"
            + "  `operator` varchar(255) DEFAULT NULL,"
            + "  `printed` int(11) DEFAULT NULL,"
            + "  `customer_code` varchar(255) DEFAULT NULL,"
            + "  `customer_name` varchar(150) DEFAULT NULL,"
            + "  `employee_code` varchar(255) DEFAULT NULL,"
            + "  PRIMARY KEY (`quotation_no`)"
            + ") ENGINE=InnoDB";
    static String CREATE_TABLE_quotation_has_item = "CREATE TABLE IF NOT EXISTS `quotation_has_item` ("
            + "  `cost` double DEFAULT NULL,"
            + "  `discount` double DEFAULT NULL,"
            + "  `quantity` double DEFAULT NULL,"
            + "  `rate` double NOT NULL,"
            + "  `quotation_quotation_no` varchar(255) NOT NULL,"
            + "  `item_code` varchar(255) NOT NULL,"
            + "  PRIMARY KEY (`quotation_quotation_no`,`item_code`)"
            + ") ENGINE=InnoDB";
    static String CREATE_TABLE_account = "CREATE TABLE IF NOT EXISTS `account` ("
            + "  `account_no` VARCHAR(50) NOT NULL,"
            + "  `balance` DOUBLE NULL,"
            + "  `bank_code` VARCHAR(30) NOT NULL,"
            + "  PRIMARY KEY (`account_no`, `bank_code`),"
            + "  INDEX `fk_account_bank1_idx` (`bank_code` ASC),"
            + "  CONSTRAINT `fk_account_bank1`"
            + "    FOREIGN KEY (`bank_code`)"
            + "    REFERENCES `bank` (`code`)"
            + "    ON DELETE NO ACTION"
            + "    ON UPDATE NO ACTION)"
            + "ENGINE = InnoDB";
    static String CREATE_TABLE_cash_box = "CREATE TABLE IF NOT EXISTS `cash_box` ("
            + "  `id` VARCHAR(10) NOT NULL,"
            + "  `description` VARCHAR(45) NULL,"
            + "  `balance` DOUBLE NULL,"
            + "  PRIMARY KEY (`id`))"
            + "ENGINE = InnoDB";
    static String CREATE_TABLE_cash_log = "CREATE TABLE IF NOT EXISTS `cash_log` ("
            + "  `log_time` DATETIME NOT NULL,"
            + "  `amount` DOUBLE NULL,"
            + "  `box_balance` DOUBLE NULL,"
            + "  `cash_box_id` VARCHAR(10) NOT NULL,"
            + "  `entity` VARCHAR(150) NULL,"
            + "  `entity_id` BLOB NULL,"
            + "  PRIMARY KEY (`log_time`, `cash_box_id`),"
            + "  INDEX `fk_cash_log_cash_box1_idx` (`cash_box_id` ASC),"
            + "  CONSTRAINT `fk_cash_log_cash_box1`"
            + "    FOREIGN KEY (`cash_box_id`)"
            + "    REFERENCES `cash_box` (`id`)"
            + "    ON DELETE NO ACTION"
            + "    ON UPDATE NO ACTION)"
            + "ENGINE = InnoDB";

    static String CREATE_TABLE_item_category = "CREATE TABLE  IF NOT EXISTS `item_category` ("
            + "  `category` varchar(255) NOT NULL, "
            + "  PRIMARY KEY (`category`)"
            + ") ENGINE=InnoDB";
    static String addItemCategoryCategoryToItemType = "ALTER TABLE `item_type` ADD COLUMN `item_category_category` VARCHAR(30) NULL;";

    static String addAccountNumberToSupplier = "ALTER TABLE `supplier` ADD COLUMN `account_number` VARCHAR(50) NULL;";
    static String addBankCodeToSupplier = "ALTER TABLE `supplier` ADD COLUMN `bank_code` VARCHAR(50) NULL;";
    static String addBankNameToSupplier = "ALTER TABLE `supplier` ADD COLUMN `bank_name` VARCHAR(50) NULL;";
    static String addBankBranchCodeToSupplier = "ALTER TABLE `supplier` ADD COLUMN `bank_branch_code` VARCHAR(50) NULL;";
    static String addBankBranchNameToSupplier = "ALTER TABLE `supplier` ADD COLUMN `bank_branch_name` VARCHAR(50) NULL;";
    static String addFinanceContactPersonToSupplier = "ALTER TABLE `supplier` ADD COLUMN `finance_contact_person` VARCHAR(50) NULL;";
    static String addFinanceContactEmailToSupplier = "ALTER TABLE `supplier` ADD COLUMN `finance_contact_email` VARCHAR(50) NULL;";
    static String addFinanceContactPhoneToSupplier = "ALTER TABLE `supplier` ADD COLUMN `finance_contact_phone` VARCHAR(50) NULL;";
    static String addSvatContactPersonToSupplier = "ALTER TABLE `supplier` ADD COLUMN `svat_contact_person` VARCHAR(50) NULL;";
    static String addSvatContactEmailToSupplier = "ALTER TABLE `supplier` ADD COLUMN `svat_contact_email` VARCHAR(50) NULL;";
    static String addSvatContactPhoneToSupplier = "ALTER TABLE `supplier` ADD COLUMN `svat_contact_phone` VARCHAR(50) NULL;";
    static String addMaxLimitToCashBox = "ALTER TABLE `cash_box` ADD COLUMN IF NOT EXISTS `max_limit` DOUBLE;";

    public static void applyFix() {
        Map<String, String> queryMap = new HashMap();
//        apply("x20150712", CREATE_TABLE_FIX);
////        queryMap.put("x20150712", CREATE_TABLE_FIX);
//        queryMap.put("x20150709a", x20150709a);
//        queryMap.put("CREATE_TABLE_PERSON", CREATE_TABLE_PERSON);
////        queryMap.put("ADD_paid_by_credit_card_TO_sale_invoice", ADD_paid_by_credit_card_TO_sale_invoice);
//        queryMap.put("x20150709b", x20150709b);
//        queryMap.put("createTableToolBarButton", createTableToolBarButton);
//        queryMap.put("x20150711", x20150711);
//        queryMap.put("x20150712b", x20150712b);
//        queryMap.put("x20150716a", x20150716a);
//        queryMap.put("x20150716b", x20150716b);
//        queryMap.put("x20150716c", x20150716c);
//        queryMap.put("x20150716d", x20150716d);
//        queryMap.put("x20150717a", x20150717a);
//        queryMap.put("CREATE_TABLE_QUOTATION", CREATE_TABLE_QUOTATION);
//        queryMap.put("addCreditToCustomer", addCreditToCustomer);
//        queryMap.put("CREATE_TABLE_quotation_has_item", CREATE_TABLE_quotation_has_item);
//        queryMap.put("addFreeQuantityToPurchaseInvoiceHasItem", addFreeQuantityToPurchaseInvoiceHasItem);
//        queryMap.put("addQuotation_noToGeneral", addQuotation_noToGeneral);
//        queryMap.put("addcustomerCodeToCollectionReceipt", addcustomerCodeToCollectionReceipt);
//        queryMap.put("addAccountAccountNoToSaleCheque", addAccountAccountNoToSaleCheque);
//        queryMap.put("addAccountBankCodeToSaleCheque", addAccountBankCodeToSaleCheque);
//        queryMap.put("CREATE_TABLE_account", CREATE_TABLE_account);
//        queryMap.put("addAmountInCashToCollectionReceipt", addAmountInCashToCollectionReceipt);
//        queryMap.put("CREATE_TABLE_cash_box", CREATE_TABLE_cash_box);
//        queryMap.put("CREATE_TABLE_cash_log", CREATE_TABLE_cash_log);
//        queryMap.put("addAccountAccountNoToIssuedCheque", addAccountAccountNoToIssuedCheque);
//        queryMap.put("addAccountBankCodeToIssuedCheque", addAccountBankCodeToIssuedCheque);
//        queryMap.put("CREATE_TABLE_item_category", CREATE_TABLE_item_category);
//        queryMap.put("addItemCategoryCategoryToItemType", addItemCategoryCategoryToItemType);
//        queryMap.put("addAccountNumberToSupplier", addAccountNumberToSupplier);
//        queryMap.put("addBankCodeToSupplier", addBankCodeToSupplier);
//        queryMap.put("addBankNameToSupplier", addBankNameToSupplier);
//        queryMap.put("addBankBranchCodeToSupplier", addBankBranchCodeToSupplier);
//        queryMap.put("addBankBranchNameToSupplier", addBankBranchNameToSupplier);
//        queryMap.put("addFinanceContactPersonToSupplier", addFinanceContactPersonToSupplier);
//        queryMap.put("addFinanceContactEmailToSupplier", addFinanceContactEmailToSupplier);
//        queryMap.put("addFinanceContactPhoneToSupplier", addFinanceContactPhoneToSupplier);
//        queryMap.put("addSvatContactPersonToSupplier", addSvatContactPersonToSupplier);
//        queryMap.put("addSvatContactEmailToSupplier", addSvatContactEmailToSupplier);
//        queryMap.put("addSvatContactPhoneToSupplier", addSvatContactPhoneToSupplier);
          queryMap.put("addMaxLimitToCashBox", addMaxLimitToCashBox);
        List<Fix> fixs = Manager.getInstance().find(Fix.class);
        for (Fix next : fixs) {
            queryMap.remove(next.getFixId());
        }
        queryMap.entrySet().stream().forEach((entrySet) -> {
            String key = entrySet.getKey();
            String value = entrySet.getValue();
            apply(key, value);
        });//
// String[] sqls = {x20150709a, x20150709b, createTableToolBarButton, x20150711, x20150712};
// for (String sql : sqls) {
//  try (PreparedStatement ps = manager.getConnection().prepareStatement(sql)) {
//  ps.executeUpdate();
//  System.out.println("Applied: " + sql);
//  } catch (SQLException ex) {
//  Exceptions.printStackTrace(ex);
//  }
// }
// try (PreparedStatement ps = manager.getConnection().prepareStatement(x20150709a)) {
//  ps.executeUpdate();
//  System.out.println("Applied: " + x20150709a);
// } catch (SQLException ex) {
//  Exceptions.printStackTrace(ex);
// }
// try (PreparedStatement ps = manager.getConnection().prepareStatement(x20150709b)) {
//  ps.executeUpdate();
//  System.out.println("Applied: " + x20150709b);
// } catch (SQLException ex) {
//  Exceptions.printStackTrace(ex);
// }
// try (PreparedStatement ps = manager.getConnection().prepareStatement(createTableToolBarButton)) {
//  ps.executeUpdate();
//  System.out.println("Applied: " + createTableToolBarButton);
// } catch (SQLException ex) {
//  Exceptions.printStackTrace(ex);
// }
//
// try (PreparedStatement ps = manager.getConnection().prepareStatement(x20150711)) {
//  ps.executeUpdate();
//  System.out.println("Applied: " + x20150711);
// } catch (SQLException ex) {
//  Exceptions.printStackTrace(ex);
// }
    }

    private static void apply(String key, String value) {
        try {
            Connection connection = Manager.getInstance().getConnection();
            if (connection == null) {
                new NullPointerException("Null connection, ").printStackTrace();
                System.exit(0);
            }
            System.out.println("Sending Fix: " + key);
            PreparedStatement ps = connection.prepareStatement(value);
            ps.executeUpdate();
            System.out.println("Applied: " + key);
            Manager.getInstance().update(new Fix(key));
        } catch (SQLException ex) {
            Exceptions.printStackTrace(ex);
            if (ex.getMessage().contains("Duplicate") || ex.getMessage().contains("Unknown")) {
                Manager.getInstance().update(new Fix(key));
            }
        } catch (Exception ex) {
            Exceptions.printStackTrace(ex);
        }

    }

}
