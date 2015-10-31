/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.quicklaunch;

import com.nanosl.lib.db.Manager;
import entity.ToolBarButton;
import java.awt.Toolkit;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import org.openide.util.Exceptions;
import org.openide.util.Lookup;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;

/**
 *
 * @author Thilina
 */
public class ToolBarManager {

    static Manager manager = Manager.getInstance();

    public static void registerToolBarButton(String buttonText, String componentName, String iconPath) {
        ToolBarButton toolBarButton = manager.find(ToolBarButton.class, componentName);
        if (toolBarButton == null) {
            toolBarButton = new ToolBarButton(componentName);
            toolBarButton.setStatus(0);
        }
        toolBarButton.setButtonText(buttonText);
        toolBarButton.setIconPath(iconPath);
        manager.update(toolBarButton);
    }

    public static ArrayList<JButton> getToolBarButtons() {
        Collection<ToolBarButton> toolBarButtons = manager.find(ToolBarButton.class);
        ArrayList<JButton> jButtons = new ArrayList<>();
        ClassLoader classLoader = Lookup.getDefault().lookup(ClassLoader.class);
        toolBarButtons.stream().forEach((toolBarButton) -> {
            TopComponent tc = WindowManager.getDefault().findTopComponent(toolBarButton.getComponentName());
            if (!(tc == null)) {
                if (toolBarButton.getStatus() != 0) {
                    JButton button = new JButton(toolBarButton.getButtonText());
                    String iconPath = toolBarButton.getIconPath();
                    URL resource = classLoader.getResource(iconPath);
                    if (resource != null) {
                        ImageIcon imageIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(resource));
                        button.setIcon(imageIcon);
                    }
                    button.addActionListener((java.awt.event.ActionEvent evt) -> {

                        tc.open();
                        tc.requestActive();
                    });
                    jButtons.add(button);
                }
            }
        });

        JButton calcButton = new JButton("Calc");
        calcButton.addActionListener((java.awt.event.ActionEvent evt) -> {
            try {
                Runtime.getRuntime().exec("calc");
            } catch (IOException ex) {
                Exceptions.printStackTrace(ex);
            }
        });
        ImageIcon calcIcon = new javax.swing.ImageIcon(classLoader.getResource("com/nanosl/nbiz/quicklaunch/resources/calc36.png"));
        calcButton.setIcon(calcIcon);
        jButtons.add(calcButton);

        JButton netButton = new JButton("Internet");
        netButton.addActionListener((java.awt.event.ActionEvent evt) -> {
            try {
                Runtime.getRuntime().exec("explorer http://www.google.lk");
            } catch (IOException ex) {
                Exceptions.printStackTrace(ex);
            }
        });
        ImageIcon browserIcon = new javax.swing.ImageIcon(classLoader.getResource("com/nanosl/nbiz/quicklaunch/resources/browser36.png"));
        netButton.setIcon(browserIcon);
        jButtons.add(netButton);

        try {
            Class c = classLoader.loadClass("com.nanosl.nbiz.login.gui.LoginPanel");
            if (c != null) {
//                System.out.println(o);

                JButton logoutButton = new JButton("Logout");
                logoutButton.addActionListener((java.awt.event.ActionEvent evt) -> {

                    try {
                        Object o = c.newInstance();
                        o.getClass().getMethod("displayLoginDialog").invoke(c);
                    } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | InstantiationException ex) {
                        Exceptions.printStackTrace(ex);
                    }

                });
                ImageIcon logoutIcon = new javax.swing.ImageIcon(classLoader.getResource("com/nanosl/nbiz/login/resources/logoff36.png"));
                logoutButton.setIcon(logoutIcon);
                jButtons.add(logoutButton);

            }
        } catch (ClassNotFoundException ex) {
            Exceptions.printStackTrace(ex);
        }
        return jButtons;
    }
}
