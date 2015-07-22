/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.util.action;

import com.nanosl.nbiz.util.NTopComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;

@ActionID(
        category = "Edit",
        id = "com.nanosl.nbiz.util.action.OpenAllButtonActionListener")
@ActionRegistration(
        //        iconBase = "com/nanosl/nbiz/gui/resources/accept.png",
        displayName = "#CTL_OpenAllButtonActionListener")
@ActionReference(path = "Menu/Tools", position = 1350)
@Messages("CTL_OpenAllButtonActionListener=OpenAll")
public final class OpenAllButtonActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        WindowManager windowManager = WindowManager.getDefault();
        windowManager.getModes().stream().map((next) -> next.getTopComponents()).forEach((topComponents) -> {
            for (TopComponent topComponent : topComponents) {
                System.out.println("Topcomponent: " + topComponent);
                if (topComponent instanceof NTopComponent) {
                    topComponent.open();
                }
            }
        });
    }
}
