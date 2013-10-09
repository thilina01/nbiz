/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.login;

import com.nanosl.nbiz.login.gui.LoginPanel;
import org.openide.modules.ModuleInstall;

public class Installer extends ModuleInstall {

    private LoginPanel loginPanel = new LoginPanel();

    @Override
    public void restored() {
//        loginPanel.createLoginDialog();

    }
}
