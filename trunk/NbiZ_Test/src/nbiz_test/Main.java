/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nbiz_test;

import com.nanosl.lib.db.Manager;
import entity.Customer;
import entity.Item;
import entity.ItemType;
import entity.PriceList;
import entity.PurchaseInvoice;
import entity.Stock;
import entity.Supplier;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import query.Find;

/**
 *
 * @author Thilina
 */
public class Main {

    private static final String fileName = "testFile";
    final static File file = new File(fileName);
    private static Manager manager;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Manager.setPu("dbPU");
        Manager.init("dbPU", "localhost", "eis_batik");//cbis_batik
        manager = Manager.getInstance();
//        m3();
//        Object o = new Main();
////        System.out.println(o.getClass());
//        String canonicalName = o.getClass().getName();
//        System.out.println(canonicalName.substring(canonicalName.lastIndexOf(".") + 1));
//        m4();

        List<? extends Object> objects = manager.find(PurchaseInvoice.class);
        for (Object object : objects) {
            System.out.println(object);
        }
//        Reflections reflections = new Reflections("nbiz_test");
//
//        Set<Class<? extends Object>> allClasses = reflections.getSubTypesOf(Object.class);
//        for (Class<? extends Object> class1 : allClasses) {
//            System.out.println(class1);
//        }
//         EntityManagerFactory  emf = manager.getEm().getEntityManagerFactory();
//         PersistenceUnitUtil persistenceUnitUtil = emf.getPersistenceUnitUtil();
//         Map<String,Object> map = emf.getProperties();
//         for (Map.Entry<String, Object> entry : map.entrySet()) {
//            String string = entry.getKey();
//            Object object = entry.getValue();
//             System.out.println(string+" - "+object);
//            
//        }
//        m5();

//		PersistenceLoader persistenceLoader = new PersistenceLoader();
//		List<PersistenceUnitInfo> persistenceGroups = persistenceLoader
//				.loadPersistence(resourceLocation);
    }

    private static void m1() {
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

    private static void m3() {

        String path = "C:\\Users\\Thilina\\Documents\\pro\\Data\\Batik\\stockinhand20140325b.xls";
        java.io.File fp = new java.io.File(path);
        try {
            Workbook wb = Workbook.getWorkbook(fp);
            Sheet sheet = wb.getSheet(0);
            int columns = sheet.getColumns();
            int rows = sheet.getRows();
            System.out.println(columns + " - " + rows);
//            String data;
//            String data = sheet.getCell(0, 9).getContents();
//            System.out.println(data);
            List<Serializable> serializables = new ArrayList<>();
            int i = 0;
            for (int row = 9; row < rows; row++) {

                String itemCode = sheet.getCell(0, row).getContents();
                if (itemCode.equals("")) {
                    continue;
                }

                String itemDescription = sheet.getCell(1, row).getContents();
                String itemTypeText = sheet.getCell(2, row).getContents();
                String supplierName = sheet.getCell(3, row).getContents();
                String quantityString = sheet.getCell(4, row).getContents();
                String costString = sheet.getCell(5, row).getContents();
                String sellingPriceString = sheet.getCell(6, row).getContents();
                String reorderLevelString = sheet.getCell(7, row).getContents();

                double quantity = Double.parseDouble(quantityString.replace(",", ""));
                double cost = Double.parseDouble(costString.replace(",", ""));
                double sellingPrice = Double.parseDouble(sellingPriceString.replace(",", ""));
                double reorderLevel = Double.parseDouble(reorderLevelString.replace(",", ""));

                Item item = manager.find(Item.class, itemCode);
                if (item == null) {
                    item = new Item(itemCode);
                    ItemType itemType = manager.find(ItemType.class, itemTypeText);
                    item.setItemTypeType(itemType);
                    item.setDescription(itemDescription);
                    Supplier supplier = Find.supplierByName(supplierName);

                    item.setSupplier(supplier);
//                    continue;
                }

                PriceList priceList = item.getPriceList();
                priceList = priceList == null ? new PriceList(itemCode) : priceList;
                priceList.setCostPack(cost);
                priceList.setSellingPack(sellingPrice);
                item.setPriceList(priceList);

                Stock stock = item.getStock();
                stock = stock == null ? new Stock(itemCode) : stock;
                stock.setQuantity(quantity);
                stock.setMinLimit(reorderLevel);
                item.setStock(stock);

                System.out.println((row - 8) + " ~ " + item.getSupplier());
                serializables.add(priceList);
                serializables.add(stock);
                serializables.add(item);
                i++;
            }
            manager.update(serializables);
            System.out.println(i);
        } catch (IOException | IndexOutOfBoundsException | BiffException ioe) {
            System.out.println("Error: " + ioe);
        }
    }

    private static void m4() {
        Class c = Supplier.class;
        Object o = manager.find(c, "1");
        for (Field field : c.getDeclaredFields()) {
//            Class type = field.getType();
            String fieldName = field.getName();
//            String toPrint = name;
            Annotation[] annotations = field.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation.toString().equalsIgnoreCase("@javax.persistence.Id()")) {
                    try {
                        for (PropertyDescriptor pd : Introspector.getBeanInfo(c).getPropertyDescriptors()) {
                            if (pd.getReadMethod() != null && !"class".equals(pd.getName()) && pd.getName().equalsIgnoreCase("name")) {
                                System.out.println(pd.getReadMethod().invoke(o));
                            }
                        }

//                        Method testMethod = c.getMethod("get" + fieldName);
//                        String result = (String) testMethod.invoke(o, 100);
//                        System.out.println(result);
//                        return;
                    } catch (SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | IntrospectionException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
//            System.out.println(name);
        }
    }

    private static void m5() {
        try {
            URL resourceLocation = manager.getClass().getClassLoader().getResource("META-INF/persistence.xml");
            System.out.println(resourceLocation);
            File fXmlFile = new File(resourceLocation.toURI());
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("persistence-unit");
            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);
                NodeList nodeList = nNode.getChildNodes();
                for (int ii = 0; ii < nodeList.getLength(); ii++) {
                    Node node = nodeList.item(i);
                    System.out.println(ii+"-"+node.getAttributes());

                }
//                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
//
//                    Element eElement = (Element) nNode;
//                    System.out.println(eElement.getNodeValue());
//                }

            }
        } catch (URISyntaxException | ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
