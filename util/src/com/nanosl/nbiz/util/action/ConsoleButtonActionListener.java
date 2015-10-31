/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.util.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "Edit",
        id = "com.nanosl.nbiz.util.action.ConsoleButtonActionListener")
@ActionRegistration(
//        iconBase = "com/nanosl/nbiz/gui/resources/accept.png",
        displayName = "#CTL_ConsoleButtonActionListener")
@ActionReference(path = "Menu/Tools", position = 1400)
@Messages("CTL_ConsoleButtonActionListener=Console")
public final class ConsoleButtonActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Process p = Runtime.getRuntime().exec("cmd /c start cmd.exe");
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
    }
}
