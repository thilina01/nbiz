/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.login;

import com.nanosl.nbiz.login.gui.LoginPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "Edit",
        id = "com.nanosl.nbiz.util.action.LogoutButtonActionListener")
@ActionRegistration(
        //        iconBase = "com/nanosl/nbiz/gui/resources/accept.png",
        displayName = "#CTL_LogoutButtonActionListener")
@ActionReference(path = "Menu/Tools", position = 1355)
@Messages("CTL_LogoutButtonActionListener=Logout")
public final class LogoutButtonActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        new LoginPanel().displayLoginDialog();
    }
}
