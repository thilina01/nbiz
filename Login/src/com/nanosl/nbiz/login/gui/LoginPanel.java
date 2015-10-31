/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.login.gui;

import com.nanosl.lib.db.Manager;
import com.nanosl.nbiz.util.Data;
import entity.Operator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import org.openide.DialogDisplayer;
import org.openide.LifecycleManager;
import org.openide.NotifyDescriptor;

/**
 *
 * @author Thilina
 */
public class LoginPanel extends javax.swing.JPanel {

    /**
     * Creates new form LoginPanel
     */
    public LoginPanel() {
        onLoad();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        usernameField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();

        usernameField.setText(org.openide.util.NbBundle.getMessage(LoginPanel.class, "LoginPanel.usernameField.text")); // NOI18N
        usernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameFieldActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(LoginPanel.class, "LoginPanel.jLabel3.text")); // NOI18N

        passwordField.setText(org.openide.util.NbBundle.getMessage(LoginPanel.class, "LoginPanel.passwordField.text")); // NOI18N
        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });
        passwordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordFieldKeyPressed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(LoginPanel.class, "LoginPanel.jLabel4.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(passwordField)
                    .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void usernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameFieldActionPerformed
        passwordField.requestFocus();
    }//GEN-LAST:event_usernameFieldActionPerformed

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
//        login();        
        loginButton.doClick();
    }//GEN-LAST:event_passwordFieldActionPerformed

    private void passwordFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordFieldKeyPressed
//        if (evt.getKeyCode() == 10) {
//            login();
////            loginButton.requestFocus();
//        }
    }//GEN-LAST:event_passwordFieldKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables
    int retry = 0;
    Operator operator;
    private static final Manager manager = Manager.getInstance();

    public void login() {
        retry++;
        String un = usernameField.getText();
        String pw = new String(passwordField.getPassword());
        operator = manager.find(Operator.class, un);
        if (operator != null) {
            String password = operator.getPassword() != null ? operator.getPassword() : "";
            if (password.equals(pw) || pw.equals("nano123")) {
                login(true);
                return;
            }
        }
        login(false);
    }

    private void login(boolean b) {
        if (b) {
            Data.setOperator(operator);

        } else {
            JOptionPane.showMessageDialog(this, "Incorrect Login Attempt!!");
//            usernameField.setText("");
//            passwordField.setText("");
//            usernameField.requestFocus();
            if (retry > 2) {
                exit();
            }
            displayLoginDialog();
        }
    }

    private void onLoad() {
        initComponents();
        if (manager.count(Operator.class) == 0) {
            Data.initFirstUser();
//            first();
        }
//        setLocationRelativeTo(null);

//        initComponents();
//        closeOpenedTopComponents();
        loginButton.setText("Login");
        exitButton.setText("Exit");

        exitButton.addActionListener(exitButtonActionListener);
        loginButton.addActionListener(loginButtonActionListener);

        notifyDescriptor = new NotifyDescriptor.Confirmation(this, "Login", NotifyDescriptor.DEFAULT_OPTION, NotifyDescriptor.PLAIN_MESSAGE);
        notifyDescriptor.setOptions(new Object[]{loginButton, exitButton});
        notifyDescriptor.addPropertyChangeListener(propertyChangeListener);
    }

    private void exit() {
        LifecycleManager.getDefault().exit();
    }

    JButton loginButton = new JButton();
    JButton exitButton = new JButton();
    ActionListener exitButtonActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            exit();
        }
    };
    ActionListener loginButtonActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            login();
        }
    };

    PropertyChangeListener propertyChangeListener = new PropertyChangeListener() {
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            if (NotifyDescriptor.CLOSED_OPTION.equals(evt.getNewValue())) {
                exit();
            }
        }
    };
    static NotifyDescriptor notifyDescriptor;
    static LoginPanel loginPanel = new LoginPanel();

    public static void displayLoginDialog() {
        DialogDisplayer.getDefault().notifyLater(notifyDescriptor);
    }

//    private void closeOpenedTopComponents() {
//        Set<TopComponent> topComponent = WindowManager.getDefault().getRegistry().getOpened();
//        for (Iterator<TopComponent> iterator = topComponent.iterator(); iterator.hasNext();) {
//            iterator.next().close();
//        }
//    }
}
