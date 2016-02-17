/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.util;

import java.util.Iterator;
import java.util.Set;
import org.openide.modules.ModuleInstall;
import org.openide.windows.TopComponent;

public class Installer extends ModuleInstall {

    @Override
    public void restored() {
//        MenuManager.restore();
    }

    @Override
    public boolean closing() {
        TopComponent.Registry registry = TopComponent.getRegistry();
        Set<TopComponent> topComponentSet = registry.getOpened();
        for (Iterator<TopComponent> iterator = topComponentSet.iterator(); iterator.hasNext();) {
            iterator.next().close();
        }
        return super.closing(); //To change body of generated methods, choose Tools | Templates.
    }

}
