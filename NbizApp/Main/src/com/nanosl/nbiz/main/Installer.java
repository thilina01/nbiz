/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.main;

import com.nanosl.lib.db.Manager;
import entity.Operator;
import java.awt.Window;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import org.openide.modules.ModuleInstall;

public class Installer extends ModuleInstall {

    private static final String fileName = "Nconf";
    private static final File file = new File(fileName);

    @Override
    public void restored() {
        String dbName = "cbisfsw";
        if (file.exists()) {
            String temp = read();
            dbName = temp == null ? dbName : temp.equals("") ? dbName : temp;
            System.out.println(dbName);
        } else {
            write();
        }
//            Manager.setPu("dbPU");
        Manager.init("dbPU", "localhost", dbName);//cbis_batik
//        Manager.setDatabase("cbisfsw");
        try {
            com.nanosl.nbiz.util.Data.setOperator(Manager.getInstance().find(Operator.class, "admin"));
        } catch (NullPointerException e) {
            System.exit(0);
        }
    }

    private static String read() {

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Map<String, String> readObjects = (Map) ois.readObject();
//                for (Object object : readObjects) {
//                    // prove we have read them successfully
//                    System.out.println(object);
//                }
            if (readObjects.size() == 1) {

//                System.out.println(readObjects.values().iterator().next());
                return readObjects.values().iterator().next();
            }
            final JComboBox jcb = new JComboBox(readObjects.keySet().toArray());
            jcb.requestFocus();

            jcb.addKeyListener(new java.awt.event.KeyAdapter() {
                @Override
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    if (evt.getKeyCode() == 10) {
                        Window w = SwingUtilities.getWindowAncestor(jcb);

                        if (w != null) {
                            w.setVisible(false);
                        }
                    }
                }
            });
            JOptionPane.showOptionDialog(null, jcb, "select system", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{}, null);

            return readObjects.get(jcb.getSelectedItem().toString());
        } catch (StreamCorruptedException sce) {
            write();
            return read();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Installer.class.getName()).log(Level.SEVERE, null, ex);
            write();
            return read();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Installer.class.getName()).log(Level.SEVERE, null, ex);
            write();
            return read();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(Installer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private static void write() {

        FileOutputStream fout = null;
        try {
            HashMap<String, String> objects = new HashMap<>();
            String conf = JOptionPane.showInputDialog("Configurations");
            if (conf == null) {
                return;
            }
            String[] options = conf.split(",");
            for (String option : options) {
                String[] strings = option.trim().split("-");
                objects.put(strings[0].trim(), strings[1].trim());
            }
//            for (int ii = 0; ii < 10; ii++) {
//                objects.add("Object to file: " + ii);
//            }
            fout = new FileOutputStream(file);
            ObjectOutputStream oos;

            oos = new ObjectOutputStream(fout);
            oos.writeObject(objects);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Installer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Installer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (fout != null) {
                    fout.close();
                    read();
                }
            } catch (IOException ex) {
                Logger.getLogger(Installer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
