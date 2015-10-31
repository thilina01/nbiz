/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.util;

import java.lang.reflect.InvocationTargetException;
import org.openide.util.Exceptions;
import org.openide.util.Lookup;

/**
 *
 * @author Thilina
 */
public class Shared {

    public static void registerToolBarButton(String buttonText, String componentName, String iconPath) {

        try {
            ClassLoader classLoader = Lookup.getDefault().lookup(ClassLoader.class);
            Class c = classLoader.loadClass("com.nanosl.nbiz.quicklaunch.ToolBarManager");
            if (c != null) {
                Class[] paramString = {String.class, String.class, String.class};
                try {
                    c.newInstance().getClass().getMethod("registerToolBarButton", paramString).invoke(c, buttonText, componentName, iconPath);
                } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | InstantiationException ex) {
                    Exceptions.printStackTrace(ex);
                }
            }
        } catch (ClassNotFoundException ex) {
            Exceptions.printStackTrace(ex);
        }

    }
}
