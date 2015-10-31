/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.cheque;

import com.nanosl.nbiz.util.Shared;
import org.openide.modules.ModuleInstall;

public class Installer extends ModuleInstall {

    @Override
    public void restored() {
        Shared.registerToolBarButton("Cheque", "ChequeTopComponent", "com/nanosl/nbiz/cheque/resources/checkbook36.png");
        Shared.registerToolBarButton("Svat", "SvatTopComponent", "com/nanosl/nbiz/cheque/resources/vat36.png");
    }
}
