/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanos.nbiz.pos;

import com.nanosl.nbiz.quicklaunch.SideBarPanel;
import javax.swing.JButton;
import org.openide.modules.ModuleInstall;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;

public class Installer extends ModuleInstall {

    @Override
    public void restored() {
        initializeToolbar();
//            Fix.e20140911();
    }

    private void initializeToolbar() {
        addButton("POS", "POSTopComponent", "specials-offers-save-sale");
    }

    private void addButton(String text, final String componentName, String icon) {

        JButton button = new JButton(text);
        if (!icon.equals("")) {
            button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nanos/nbiz/pos/resources/" + icon + ".png"))); // NOI18N
        }
        button.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TopComponent tc = WindowManager.getDefault().findTopComponent(componentName);
                if (tc == null) {
                    return;
                }
                tc.open();
                tc.requestActive();
            }
        });
        SideBarPanel.addButton(button);
    }

}
