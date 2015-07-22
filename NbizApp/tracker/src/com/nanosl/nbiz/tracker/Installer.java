/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.tracker;

import java.util.Timer;
import java.util.TimerTask;
import org.openide.modules.ModuleInstall;

public class Installer extends ModuleInstall {

    @Override
    public void restored() {

        TimerTask myTask = new TimerTask() {
            @Override
            public void run() {
//                com.nanosl.nbiz.util.Data.updateSales();
            }
        };

        Timer timer = new Timer();
        timer.schedule(myTask, 1 * 60 * 1000 /*delay for 1 minutes*/, 1 * 60 * 1000 /* every 1 minutes */);

    }

}
