/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.main;

import com.nanosl.lib.db.Manager;
import entity.Operator;
import entity.ViewPanel;
import java.io.File;
import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.openide.modules.ModuleInstall;
import org.openide.util.Exceptions;

public class Installer extends ModuleInstall {

    private static final String confFileName = "NconfN";
    private static final File file = new File(confFileName);
    int round = 0;
    Manager manager;

    @Override
    public void restored() {
        String dbName = "cbisfsw", server = "127.0.0.1";
        if (file.exists()) {
            Config config = Configuration.read();
            dbName = config == null ? dbName : config.getDatabase().equals("") ? dbName : config.getDatabase();
            server = config == null ? server : config.getServer().equals("") ? server : config.getServer();
            Manager.init("dbPU", server, dbName);//cbis_batik
            manager = Manager.getInstance();
            if (manager.isConnected()) {
                System.out.println(manager.getDatabase());
                try {
                    Operator operator = manager.find(Operator.class, "admin");
                    com.nanosl.nbiz.util.Data.setOperator(operator);
                } catch (NullPointerException e) {
                    if (round < 3) {
                        round++;
                        restored();
                    }
                    System.exit(0);
                }
            } else {
                try {
//                    JOptionPane.showMessageDialog(null, "Database not found", "Sorry", JOptionPane.ERROR_MESSAGE);
                    URI uri = getClass().getResource("db").toURI();
                    manager.createDatabase(uri);
//                    System.out.println("cp1");
                    manager.initiateDatabase();
//                    System.out.println("cp2");
                    manager = Manager.getInstance();
//                    System.out.println("cp3");
                    Operator operator = manager.find(Operator.class, "admin");
                    if (operator != null) {
                        return;
                    }
                    operator = new Operator("admin");
                    operator.setPassword("n");
                    ViewPanel viewPanel = new ViewPanel("PermissionTopComponent");
                    Collection<Operator> operators = new ArrayList<>();
                    operators.add(operator);
                    viewPanel.setOperatorCollection(operators);
                    Collection<ViewPanel> viewPanels = new ArrayList<>();
                    viewPanels.add(viewPanel);
                    operator.setViewPanelCollection(viewPanels);
                    List<Serializable> serializables = new ArrayList<>();
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
//    String x = "CREATE TABLE IF NOT EXISTS`optional_component` ("
//            + "  `name` varchar(100) NOT NULL,"
//            + "  `status` int(11) DEFAULT NULL,"
//            + "  `view_panel_view_panel` varchar(100) NOT NULL,"
//            + "  PRIMARY KEY (`name`,`view_panel_view_panel`),"
//            + "  KEY `fk_optional_component_view_panel1_idx` (`view_panel_view_panel`),"
//            + "  CONSTRAINT `fk_optional_component_view_panel1` FOREIGN KEY (`view_panel_view_panel`) REFERENCES `view_panel` (`view_panel`) ON DELETE NO ACTION ON UPDATE NO ACTION"
//            + ") ENGINE=InnoDB DEFAULT CHARSET=latin1;";
//
//    private void applyFix() {
//        try (PreparedStatement ps = manager.getConnection().prepareStatement(x)) {
//            ps.executeUpdate();
//        } catch (SQLException ex) {
//            Exceptions.printStackTrace(ex);
//        }
//    }
}
