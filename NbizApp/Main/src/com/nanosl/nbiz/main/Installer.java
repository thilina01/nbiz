/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.main;

import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;
import com.nanosl.lib.db.Manager;
import entity.Employee;
import entity.EmployeePosition;
import entity.Fix;
import entity.Operator;
import entity.Person;
import entity.ViewPanel;
import java.io.File;
import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openide.modules.ModuleInstall;
import org.openide.util.Exceptions;

public class Installer extends ModuleInstall {

    private static final String confFileName = "NconfN";
    private static final File file = new File(confFileName);
// int round = 0;
    Manager manager;

    @Override
    public void restored() {
        String dbName = "eis", server = "127.0.0.1";
        if (file.exists()) {
            Config config = Configuration.read();
            dbName = config == null ? dbName : config.getDatabase().equals("") ? dbName : config.getDatabase();
            server = config == null ? server : config.getServer().equals("") ? server : config.getServer();
            Manager.init("dbPU", server, dbName);//cbis_batik
            manager = Manager.getInstance();
//  System.out.println("Database connection is: " + manager.isConnected());
            if (manager.isConnected()) {
                System.out.println(manager.getDatabase());
                try {
                    Operator operator = manager.find(Operator.class, "admin");
                    com.nanosl.nbiz.util.Data.setOperator(operator);
                } catch (NullPointerException e) {
//   if (round < 3) {
//   round++;
//   restored();
//   }
                    System.exit(0);
                }
                applyFix();
            } else {
                try {
                    URI uri = getClass().getResource("db.sql").toURI();
                    manager.createDatabase(uri);
                    manager.initiateDatabase();
                    manager = Manager.getInstance();
                    Operator operator = manager.find(Operator.class, "admin");
                    if (operator != null) {
                        return;
                    }
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
                } catch (URISyntaxException ex) {
                    Exceptions.printStackTrace(ex);
                }
            }
        } else {
            Configuration.display();
            restored();
        }

    }
    String x20150709a = "CREATE TABLE IF NOT EXISTS `issued_cheque_has_purchase_invoice` ("
            + " `issued_cheque_cheque_number` varchar(30) NOT NULL,"
            + " `purchase_invoice_inv_no` varchar(20) NOT NULL,"
            + " `purchase_invoice_supplier_code` varchar(10) NOT NULL,"
            + " PRIMARY KEY (`issued_cheque_cheque_number`,`purchase_invoice_inv_no`,`purchase_invoice_supplier_code`),"
            + " KEY `fk_issued_cheque_has_purchase_invoice_purchase_invoice1_idx` (`purchase_invoice_inv_no`,`purchase_invoice_supplier_code`),"
            + " KEY `fk_issued_cheque_has_purchase_invoice_issued_cheque1_idx` (`issued_cheque_cheque_number`),"
            + " CONSTRAINT `fk_issued_cheque_has_purchase_invoice_issued_cheque1` FOREIGN KEY (`issued_cheque_cheque_number`) REFERENCES `issued_cheque` (`cheque_number`) ON DELETE NO ACTION ON UPDATE NO ACTION,"
            + " CONSTRAINT `fk_issued_cheque_has_purchase_invoice_purchase_invoice1` FOREIGN KEY (`purchase_invoice_inv_no`, `purchase_invoice_supplier_code`) REFERENCES `purchase_invoice` (`inv_no`, `supplier_code`) ON DELETE NO ACTION ON UPDATE NO ACTION"
            + ") ENGINE=InnoDB DEFAULT CHARSET=latin1;";

// String x = "CREATE TABLE IF NOT EXISTS`optional_component` ("
// + " `name` varchar(100) NOT NULL,"
// + " `status` int(11) DEFAULT NULL,"
// + " `view_panel_view_panel` varchar(100) NOT NULL,"
// + " PRIMARY KEY (`name`,`view_panel_view_panel`),"
// + " KEY `fk_optional_component_view_panel1_idx` (`view_panel_view_panel`),"
// + " CONSTRAINT `fk_optional_component_view_panel1` FOREIGN KEY (`view_panel_view_panel`) REFERENCES `view_panel` (`view_panel`) ON DELETE NO ACTION ON UPDATE NO ACTION"
// + ") ENGINE=InnoDB DEFAULT CHARSET=latin1;";
//
    String x20150709b = "ALTER TABLE `issued_cheque` "
            + "CHANGE COLUMN `issued_date` `issued_date` DATETIME NULL DEFAULT NULL ;";

    String createTableToolBarButton = "CREATE TABLE IF NOT EXISTS `tool_bar_button` ("
            + " `component_name` VARCHAR(150) NOT NULL,"
            + " `button_text` VARCHAR(45) NULL,"
            + " `icon_path` VARCHAR(1000) NULL,"
            + " `status` INT NULL,"
            + " PRIMARY KEY (`component_name`))"
            + " ENGINE = InnoDB";

    String x20150711 = "ALTER TABLE `item` CHANGE COLUMN `disable` `status` INT(11) NULL DEFAULT '0' ;";
    String CREATE_TABLE_FIX = "CREATE TABLE IF NOT EXISTS `fix` ("
            + " `fix_id` VARCHAR(100) NOT NULL,"
            + " PRIMARY KEY (`fix_id`))"
            + " ENGINE = InnoDB";

    String ADD_paid_by_credit_card_TO_sale_invoice = "ALTER TABLE `sale_invoice` ADD COLUMN `paid_by_credit_card` double NULL AFTER `paid_amount`;";
    String x20150712b = "ALTER TABLE `employee` ADD COLUMN `person_nic` VARCHAR(10) NOT NULL AFTER `code`;";
    String x20150716a = "ALTER TABLE `supplier` ADD COLUMN `vat` VARCHAR(20) NULL;";
    String x20150716b = "ALTER TABLE `supplier` ADD COLUMN `svat` VARCHAR(20) NULL;";
    String x20150716c = "ALTER TABLE `company` ADD COLUMN `vat` VARCHAR(20) NULL;";
    String x20150716d = "ALTER TABLE `company` ADD COLUMN `svat` VARCHAR(20) NULL;";
    String x20150717a = "CREATE TABLE IF NOT EXISTS `svat` ("
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

    private void applyFix() {
        Map<String, String> queryMap = new HashMap();
        apply("x20150712", CREATE_TABLE_FIX);
        queryMap.put("x20150712", CREATE_TABLE_FIX);
        queryMap.put("x20150709a", x20150709a);
        queryMap.put("ADD_paid_by_credit_card_TO_sale_invoice", ADD_paid_by_credit_card_TO_sale_invoice);
        queryMap.put("x20150709b", x20150709b);
        queryMap.put("createTableToolBarButton", createTableToolBarButton);
        queryMap.put("x20150711", x20150711);
        queryMap.put("x20150712b", x20150712b);
        queryMap.put("x20150716a", x20150716a);
        queryMap.put("x20150716b", x20150716b);
        queryMap.put("x20150716c", x20150716c);
        queryMap.put("x20150716d", x20150716d);
        queryMap.put("x20150717a", x20150717a);
        List<Fix> fixs = new ArrayList<>();

        fixs = manager.find(Fix.class);
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

    private void apply(String key, String value) {
        try (PreparedStatement ps = manager.getConnection().prepareStatement(value)) {
            ps.executeUpdate();
            System.out.println("Applied: " + key);
            manager.update(new Fix(key));
        } catch (MySQLSyntaxErrorException ex) {
            manager.update(new Fix(key));
        } catch (SQLException ex) {
            Exceptions.printStackTrace(ex);
        }
    }
}
