/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nbiz_test;

import com.nanosl.lib.db.Manager;
import entity.Customer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Thilina
 */
public class Main {

    private static final String fileName = "testFile";
    private static final File file = new File(fileName);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        m2();
    }

    private static void m1() {
        Manager.setPu("dbPU");
        Manager.init("dbPU", "localhost", "eis");//cbis_batik
        Manager manager = Manager.getInstance();
        Collection<Customer> customers = manager.find(Customer.class);
        List<Serializable> customersEdited = new ArrayList<>();
        for (Customer customer : customers) {
            String nic = customer.getNic() != null ? customer.getNic().trim() : "";
            if (nic.length() == 10) {
                customer.setNotes(nic);
                customersEdited.add(customer);
            }
        }
        manager.update(customersEdited);
    }

    private static void m2() {

        if (file.exists()) {
            read();
        } else {
            write();
        }
    }

    private static void read() {

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList readObjects = (ArrayList) ois.readObject();
//                for (Object object : readObjects) {
//                    // prove we have read them successfully
//                    System.out.println(object);
//                }
            JComboBox jcb = new JComboBox(readObjects.toArray());
//                jcb.setEditable(true);
            JOptionPane.showMessageDialog(null, jcb, "select system", JOptionPane.QUESTION_MESSAGE);
            System.out.println(jcb.getSelectedItem());
        } catch (StreamCorruptedException sce) {
            write();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private static void write() {

        FileOutputStream fout = null;
        try {
            ArrayList<String> objects = new ArrayList<>();
            for (int ii = 0; ii < 10; ii++) {
                objects.add("Object to file: " + ii);
            }
            fout = new FileOutputStream(file);
            ObjectOutputStream oos;

            oos = new ObjectOutputStream(fout);
            oos.writeObject(objects);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (fout != null) {
                    fout.close();
                    read();
                }
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
