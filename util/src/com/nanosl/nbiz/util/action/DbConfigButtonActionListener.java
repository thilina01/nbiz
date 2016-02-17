/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.util.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.Exceptions;
import org.openide.util.Lookup;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "Edit",
        id = "com.nanosl.credit.editor.ActionListener.DbConfigButtonActionListener")
@ActionRegistration(
        //        iconBase = "com/nanosl/nbiz/gui/resources/accept.png",
        displayName = "#CTL_DbConfigButtonActionListener")
@ActionReference(path = "Menu/Tools", position = 1400)
@Messages("CTL_DbConfigButtonActionListener=DB Configuration")
public final class DbConfigButtonActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            ClassLoader classLoader = Lookup.getDefault().lookup(ClassLoader.class);
            Class c = classLoader.loadClass("com.nanosl.nbiz.main.Configuration");
            if (c != null) {
//                Object o = c.newInstance();
                c.getMethod("display").invoke(c);
            }
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException ex) {
            Exceptions.printStackTrace(ex);
        }
    }
}
