/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.main;

import com.nanosl.lib.db.Manager;
import entity.Operator;
import org.openide.modules.ModuleInstall;

public class Installer extends ModuleInstall {

    @Override
    public void restored() {
        Manager.setPu("dbPU");
        com.nanosl.nbiz.util.Data.setOperator(Manager.getInstance().find(Operator.class, "admin"));
    }
}
