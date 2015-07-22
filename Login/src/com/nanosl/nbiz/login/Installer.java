/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.login;

import com.nanosl.nbiz.login.gui.LoginPanel;
import org.openide.modules.ModuleInstall;
import org.openide.windows.WindowManager;

public class Installer extends ModuleInstall {

//    private final LoginPanel loginPanel = new LoginPanel();
    @Override
    public void restored() {
        WindowManager.getDefault().invokeWhenUIReady(new Runnable() {
            @Override
            public void run() {
//                WindowManager.getDefault().getMainWindow().setExtendedState(Frame.ICONIFIED);
                LoginPanel.displayLoginDialog();
            }
        });
    }
}
