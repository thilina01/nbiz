/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.util.action;

import com.nanosl.nbiz.util.Data;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "Edit",
        id = "com.nanosl.credit.editor.ActionListener.UserButtonActionListener")
@ActionRegistration(
//        iconBase = "com/nanosl/nbiz/gui/resources/accept.png",
        displayName = "#CTL_UserButtonActionListener")
@ActionReference(path = "Menu/Help", position = 1400)
@Messages("CTL_UserButtonActionListener=User")
public final class UserButtonActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, Data.getOperator().getUsername());
    }
}
