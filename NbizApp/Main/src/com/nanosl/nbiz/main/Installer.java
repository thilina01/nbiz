/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.main;

import com.nanosl.lib.db.Manager;
import entity.Operator;
import java.io.File;
import org.openide.modules.ModuleInstall;

public class Installer extends ModuleInstall {

    private static final String confFileName = "NconfN";
    private static final File file = new File(confFileName);
    int round = 0;

    @Override
    public void restored() {
        String dbName = "cbisfsw";
        if (file.exists()) {
            Config config = Configuration.read();
            dbName = config == null ? dbName : config.getDatabase().equals("") ? dbName : config.getDatabase();
            Manager.init("dbPU", config.getServer(), dbName);//cbis_batik
            System.out.println(dbName);
        } else {
            Configuration.display();
        }
////            Manager.setPu("dbPU");
//        Manager.setDatabase("cbisfsw");
        try {
            com.nanosl.nbiz.util.Data.setOperator(Manager.getInstance().find(Operator.class, "admin"));
        } catch (NullPointerException e) {
//            System.out.println("-----------------------> ");
            if (round < 3) {
                round++;
                restored();
            }
            System.exit(0);
        }
    }
//
//    private static String read() {
//
//        FileInputStream fis = null;
//        try {
//            fis = new FileInputStream(file);
//            ObjectInputStream ois = new ObjectInputStream(fis);
//            Map<String, String> readObjects = (Map) ois.readObject();
////                for (Object object : readObjects) {
////                    // prove we have read them successfully
////                    System.out.println(object);
////                }
//            if (readObjects.size() == 1) {
//
////                System.out.println(readObjects.values().iterator().next());
//                return readObjects.values().iterator().next();
//            }
//            final JComboBox jcb = new JComboBox(readObjects.keySet().toArray());
//            jcb.requestFocus();
//
//            jcb.addKeyListener(new java.awt.event.KeyAdapter() {
//                @Override
//                public void keyPressed(java.awt.event.KeyEvent evt) {
//                    if (evt.getKeyCode() == 10) {
//                        Window w = SwingUtilities.getWindowAncestor(jcb);
//
//                        if (w != null) {
//                            w.setVisible(false);
//                        }
//                    }
//                }
//            });
//            JOptionPane.showOptionDialog(null, jcb, "select system", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{}, null);
//
//            return readObjects.get(jcb.getSelectedItem().toString());
//        } catch (StreamCorruptedException sce) {
//            write();
//            return read();
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(Installer.class.getName()).log(Level.SEVERE, null, ex);
//            write();
//            return read();
//        } catch (IOException | ClassNotFoundException ex) {
//            Logger.getLogger(Installer.class.getName()).log(Level.SEVERE, null, ex);
//            write();
//            return read();
//        } finally {
//            try {
//                if (fis != null) {
//                    fis.close();
//                }
//            } catch (IOException ex) {
//                Logger.getLogger(Installer.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }
//
//    private static void write() {
//
//        FileOutputStream fout = null;
//        try {
//            HashMap<String, String> objects = new HashMap<>();
//            String conf = JOptionPane.showInputDialog("Configurations");
//            if (conf == null) {
//                return;
//            }
//            String[] options = conf.split(",");
//            for (String option : options) {
//                String[] strings = option.trim().split("-");
//                objects.put(strings[0].trim(), strings[1].trim());
//            }
////            for (int ii = 0; ii < 10; ii++) {
////                objects.add("Object to file: " + ii);
////            }
//            fout = new FileOutputStream(file);
//            ObjectOutputStream oos;
//
//            oos = new ObjectOutputStream(fout);
//            oos.writeObject(objects);
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(Installer.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(Installer.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                if (fout != null) {
//                    fout.close();
//                    read();
//                }
//            } catch (IOException ex) {
//                Logger.getLogger(Installer.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }
//
//    private String readServer() {
//        BufferedReader reader = new BufferedReader(new FileReader("/path/to/file.txt"));
//        String line = null;
//        while ((line = reader.readLine()) != null) {
//    // ...
//        }
//        return "localhost";
//    }
}
