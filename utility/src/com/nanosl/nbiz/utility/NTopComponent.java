/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.utility;

import com.nanosl.lib.db.Manager;
import com.nanosl.lib.util.Format;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.windows.TopComponent;

/**
 *
 * @author Thilina Ranathunga
 */
public class NTopComponent extends TopComponent implements Format {

    public Manager m = Manager.getInstance();

    protected void showError(String string) {
        NotifyDescriptor d =
                new NotifyDescriptor.Message(string, NotifyDescriptor.ERROR_MESSAGE);
        DialogDisplayer.getDefault().notify(d);
    }

    protected void showSuccess(String string) {
        NotifyDescriptor d =
                new NotifyDescriptor.Message(string, NotifyDescriptor.INFORMATION_MESSAGE);
        DialogDisplayer.getDefault().notify(d);
    }
}
