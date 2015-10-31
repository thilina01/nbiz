/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanos.nbiz.pos;

import com.nanosl.nbiz.util.Shared;
import org.openide.modules.ModuleInstall;

public class Installer extends ModuleInstall {

    @Override
    public void restored() {
        Shared.registerToolBarButton("POS", "POSTopComponent", "com/nanos/nbiz/pos/resources/specials-offers-save-sale.png");
    }
}
