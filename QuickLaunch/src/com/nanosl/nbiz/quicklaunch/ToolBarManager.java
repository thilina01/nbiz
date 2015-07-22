/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.quicklaunch;

import com.nanosl.lib.db.Manager;
import entity.ToolBarButton;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
        for (ToolBarButton toolBarButton : toolBarButtons) {
            JButton button = new JButton(toolBarButton.getButtonText());
            String iconPath = toolBarButton.getIconPath();
            ClassLoader classLoader = Lookup.getDefault().lookup(ClassLoader.class);
            URL resource = classLoader.getResource(iconPath);
            if (resource != null) {
                ImageIcon imageIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(resource));
                button.setIcon(imageIcon);
            }
            button.addActionListener((java.awt.event.ActionEvent evt) -> {
                TopComponent tc = WindowManager.getDefault().findTopComponent(toolBarButton.getComponentName());
                if (tc == null) {
                    return;
                }
                tc.open();
                tc.requestActive();
            });
            jButtons.add(button);
        }
        return jButtons;
    }
}
