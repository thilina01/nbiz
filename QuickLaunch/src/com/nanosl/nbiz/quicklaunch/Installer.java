/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.quicklaunch;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Frame;
import javax.swing.JRootPane;
import org.openide.modules.ModuleInstall;
import org.openide.windows.WindowManager;

public class Installer extends ModuleInstall {

    @Override
    public void restored() {

        WindowManager.getDefault().invokeWhenUIReady(() -> {
            Frame mainWindow = WindowManager.getDefault().getMainWindow();
            Container contentPane = ((JRootPane) mainWindow.getComponents()[0]).getContentPane();
            SideBarPanel sideBarPanel = SideBarPanel.getInstance();
            contentPane.add(BorderLayout.WEST, sideBarPanel);
            ((BorderLayout) contentPane.getLayout()).invalidateLayout(contentPane);
            mainWindow.validate();
        });

    }

}
