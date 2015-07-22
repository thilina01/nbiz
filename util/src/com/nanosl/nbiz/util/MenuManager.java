/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.util;

import com.nanosl.lib.db.Manager;
import entity.Menu;
import entity.MenuItem;
import entity.MenuItemPK;
import java.awt.Component;
import java.awt.Container;
import java.awt.Frame;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.MenuElement;
import javax.swing.SwingUtilities;
import org.openide.util.Exceptions;
import org.openide.windows.WindowManager;

/**
 *
 * @author Thilina
 */
public class MenuManager {

    public static void initialize() {
        Frame frame = WindowManager.getDefault().getMainWindow();
        fl(frame);
//        if (!menuItemsLoaded) {
//            initialize();
//        }
    }

    static Manager manager = Manager.getInstance();
    static boolean menuItemsLoaded = false;

    static void fl(Container container) {
        if (container instanceof JMenuItem) {
            JMenuItem jMenuItem = (JMenuItem) container;
            MenuElement[] menuComponents = jMenuItem.getSubElements();
            Menu menu = manager.find(Menu.class, jMenuItem.getText());
            if (menu == null) {
                menu = new Menu(jMenuItem.getText());
                menu.setStatus(0);
                manager.update(menu);
            }
            jMenuItem.setVisible(menu.getStatus() > 0 || Data.getOperator().getUsername().equalsIgnoreCase("admin"));
            for (MenuElement menuElement : menuComponents) {
                JPopupMenu popupMenu = (JPopupMenu) menuElement;
                Component[] components = popupMenu.getComponents();
                menuItemsLoaded = components.length > 0;
                List<Serializable> menuItems = new ArrayList<>();
                for (Component component : components) {
                    if (component instanceof JMenuItem) {
                        JMenuItem jMenuItem1 = (JMenuItem) component;
                        MenuItemPK menuItemPK = new MenuItemPK(jMenuItem.getText(), jMenuItem1.getText());
                        MenuItem menuItem = manager.find(MenuItem.class, menuItemPK);
                        if (menuItem == null) {
                            menuItem = new MenuItem(menuItemPK);
                            menuItem.setStatus(0);
                            menuItem.setMenu(menu);
                            manager.update(menuItem);
                            menuItems.add(menuItem);
                        }
                        jMenuItem1.setVisible(menuItem.getStatus() > 0 || Data.getOperator().getUsername().equalsIgnoreCase("admin"));
//                        fl(jMenuItem1);
//                        System.out.println(" : " + container1.getText() + " - " + container1.getClass());

                    }
                }
//                menu.setMenuItemCollection(menuItems);
                manager.update(menuItems);
            }
        }
        Component[] components = container.getComponents();
        for (Component component : components) {
            Container container1 = (Container) component;
            fl(container1);
        }
    }

    static void restore() {
        WindowManager.getDefault().invokeWhenUIReady(() -> {
            Thread thread = new Thread(() -> {

                SwingUtilities.invokeLater(() -> {
                    MenuManager.initialize();
                });
            });
            try {
                thread.join();
            } catch (InterruptedException ex) {
                Exceptions.printStackTrace(ex);
            }
            thread.start();
        });
    }
}
