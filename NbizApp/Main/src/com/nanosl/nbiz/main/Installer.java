/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.main;

import com.nanosl.lib.db.Manager;
import com.nanosl.nbiz.util.Data;
import entity.Operator;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import org.openide.modules.ModuleInstall;
import org.openide.util.Exceptions;

public class Installer extends ModuleInstall {

    private static final String CONFFIGURATION_FILE_NAME = "NconfN";
    private static final File CONFFIGURATION_FILE = new File(CONFFIGURATION_FILE_NAME);
// int round = 0;
    Manager manager;

    @Override
    public void restored() {
        if (CONFFIGURATION_FILE.exists()) {
            connectToServer();
        } else {
            Configuration.display();
            restored();
        }
    }

    private void connectToServer() {
        String server = "127.0.0.1",
                dbName = "eis",
                username = "abc",
                password = "123";
        Config config = DatabaseConfigurationPanel.read();
        if (config == null) {
            Configuration.display();
            try {
                Thread.sleep(1000 * 2);
            } catch (InterruptedException ex) {
                Exceptions.printStackTrace(ex);
            }
            config = DatabaseConfigurationPanel.read();
            restored();
        }
        server = config.getServer() == null | config.getServer().equals("") ? server : config.getServer();
        dbName = config.getDatabase() == null | config.getDatabase().equals("") ? dbName : config.getDatabase();
        username = config.getUsername() == null | config.getUsername().equals("") ? username : config.getUsername();
        password = config.getPassword() == null | config.getPassword().equals("") ? password : config.getPassword();
//        Manager.init("dbPU", server, dbName);//cbis_batik
        Manager.init("dbPU", server, dbName, username, password);//cbis_batik
        manager = Manager.getInstance();
//  System.out.println("Database connection is: " + manager.isConnected());
        if (manager.isConnected()) {
            System.out.println(manager.getDatabase());
            try {
                Operator operator = manager.find(Operator.class, "admin");
                if (operator == null) {
                    Data.initFirstUser();
                }
                com.nanosl.nbiz.util.Data.setOperator(operator);
            } catch (NullPointerException e) {
//   if (round < 3) {
//   round++;
//   restored();
//   }
                System.exit(0);
            }
//            Fixer.applyFix(); // You may enable this ***** Importent ****
        } else {
            try {
                URI uri = Installer.class.getResource("db.sql").toURI();
                manager.createDatabase(uri);
                manager.initiateDatabase();
                manager = Manager.getInstance();
                Operator operator = manager.find(Operator.class, "admin");
                if (operator == null) {
                    Data.initFirstUser();
                }
            } catch (URISyntaxException ex) {
                Exceptions.printStackTrace(ex);
            }
        }
    }

}
