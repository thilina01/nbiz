/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.gui.actionListener;

import com.nanosl.lib.db.Manager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.awt.NotificationDisplayer;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "Edit",
        id = "com.nanosl.credit.editor.ActionListener.HomeButtonActionListener")
@ActionRegistration(
        iconBase = "com/nanosl/nbiz/gui/resources/db24.png",
        displayName = "#CTL_BackupButtonActionListener")
@ActionReference(path = "Menu/Tools", position = 1300)
@Messages("CTL_BackupButtonActionListener=Backup")
public final class BackupButtonActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        backupDB();
    }
    static File source;
    static JDialog jDialog;
    static JComboBox<File> comboBox;
    static KeyAdapter itemComboBoxKeyAdapter = new java.awt.event.KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent evt) {
            comboboxKeyPressed();
        }

    };

    private static void backupDB() {
        new Thread() {
            @Override
            public void run() {
                String path = Manager.getInstance().backup();
                source = new File(path);
                jDialog = new JDialog();
                jDialog.setTitle("Backup To:");
                jDialog.setSize(200, 70);
                jDialog.setLocationRelativeTo(null);
                comboBox = new JComboBox<>(File.listRoots());
                comboBox.removeItem(source.toPath().getRoot().toFile());
                comboBox.setSelectedIndex(comboBox.getItemCount() - 1);
                comboBox.addKeyListener(itemComboBoxKeyAdapter);
                jDialog.add(comboBox);
                jDialog.setVisible(true);
                comboBox.requestFocus();
            }
        }.start();
    }

    private static void comboboxKeyPressed() {
        File drive = (File) comboBox.getSelectedItem();
        jDialog.dispose();
        File destination = new File(drive.getPath() + "\\" + source.getName());
        ImageIcon imageIcon = new javax.swing.ImageIcon(BackupButtonActionListener.class.getResource("/com/nanosl/nbiz/gui/resources/accept16.png"));
        if (!destination.exists()) {
            if (source.renameTo(destination)) {
                NotificationDisplayer.getDefault().notify("Backup Complete", imageIcon, "", null);
            }
        }
//        System.out.println(destination);
    }
}
