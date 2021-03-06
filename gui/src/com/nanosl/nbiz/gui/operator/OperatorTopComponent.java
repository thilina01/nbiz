/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.gui.operator;

import com.nanosl.nbiz.util.Combo;
import com.nanosl.nbiz.util.Data;
import com.nanosl.nbiz.util.NTopComponent;
import entity.Employee;
import entity.Operator;
import entity.Person;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.TopComponent;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
        dtd = "-//com.nanosl.nbiz.gui.operator//Operator//EN",
        autostore = false)
@TopComponent.Description(
        preferredID = "OperatorTopComponent",
        //iconBase="SET/PATH/TO/ICON/HERE", 
        persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@ActionID(category = "Window", id = "com.nanosl.nbiz.gui.operator.OperatorTopComponent")
@ActionReference(path = "Menu/General" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_OperatorAction",
        preferredID = "OperatorTopComponent")
@Messages({
    "CTL_OperatorAction=Operator",
    "CTL_OperatorTopComponent=Operator Window",
    "HINT_OperatorTopComponent=This is a Operator window"
})
public final class OperatorTopComponent extends NTopComponent {

    public OperatorTopComponent() {
        onLoad();
        setName(Bundle.CTL_OperatorTopComponent());
        setToolTipText(Bundle.HINT_OperatorTopComponent());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        employeeComboBox = new javax.swing.JComboBox();
        usernameTextField = new javax.swing.JTextField();
        PasswordField = new javax.swing.JPasswordField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tempTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        adminCurrentPasswordField = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        adminNewPasswordField = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        adminAgainPasswordField = new javax.swing.JPasswordField();

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        employeeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeComboBoxActionPerformed(evt);
            }
        });
        employeeComboBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                employeeComboBoxKeyPressed(evt);
            }
        });

        usernameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameTextFieldActionPerformed(evt);
            }
        });

        PasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordFieldActionPerformed(evt);
            }
        });

        tempTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Username", "Created Date", "Created By"
            }
        ));
        tempTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tempTableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tempTable);

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(OperatorTopComponent.class, "OperatorTopComponent.jLabel1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(OperatorTopComponent.class, "OperatorTopComponent.jLabel2.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(OperatorTopComponent.class, "OperatorTopComponent.jLabel3.text")); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(OperatorTopComponent.class, "OperatorTopComponent.jPanel2.border.title"))); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(OperatorTopComponent.class, "OperatorTopComponent.jLabel4.text")); // NOI18N

        adminCurrentPasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminCurrentPasswordFieldActionPerformed(evt);
            }
        });
        adminCurrentPasswordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                adminCurrentPasswordFieldKeyPressed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel5, org.openide.util.NbBundle.getMessage(OperatorTopComponent.class, "OperatorTopComponent.jLabel5.text")); // NOI18N

        adminNewPasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminNewPasswordFieldActionPerformed(evt);
            }
        });
        adminNewPasswordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                adminNewPasswordFieldKeyPressed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel6, org.openide.util.NbBundle.getMessage(OperatorTopComponent.class, "OperatorTopComponent.jLabel6.text")); // NOI18N

        adminAgainPasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminAgainPasswordFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(adminCurrentPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(adminNewPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(adminAgainPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(adminAgainPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(adminNewPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(adminCurrentPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(employeeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(employeeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void employeeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeComboBoxActionPerformed
        //        if (entities.Employee.isDescription()) {
        //            setDataLable(employeeComboBox, ((entities.Employee) employeeComboBox.getSelectedItem()).getCode());
        //        } else {
        //            setDataLable(employeeComboBox, ((entities.Employee) employeeComboBox.getSelectedItem()).getName());
        //        }
    }//GEN-LAST:event_employeeComboBoxActionPerformed

    private void employeeComboBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_employeeComboBoxKeyPressed
        if (evt.getKeyCode() == 10) {
            usernameTextField.requestFocus();
        }
    }//GEN-LAST:event_employeeComboBoxKeyPressed

    private void usernameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameTextFieldActionPerformed
        PasswordField.requestFocus();
    }//GEN-LAST:event_usernameTextFieldActionPerformed

    private void PasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordFieldActionPerformed
        createOperator();
    }//GEN-LAST:event_PasswordFieldActionPerformed

    private void tempTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tempTableKeyReleased
        if (tempTable.getSelectedRow() != -1 && evt.getKeyCode() == 123) {
            removeRows();
        }
    }//GEN-LAST:event_tempTableKeyReleased

    private void adminCurrentPasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminCurrentPasswordFieldActionPerformed
        if (adminCurrentPasswordField.getPassword().length > 0) {
            adminNewPasswordField.requestFocus();
        }
    }//GEN-LAST:event_adminCurrentPasswordFieldActionPerformed

    private void adminNewPasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminNewPasswordFieldActionPerformed
        if (adminNewPasswordField.getPassword().length > 0) {
            adminAgainPasswordField.requestFocus();
        }
    }//GEN-LAST:event_adminNewPasswordFieldActionPerformed

    private void adminAgainPasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminAgainPasswordFieldActionPerformed
        changeAdminPassword();

    }//GEN-LAST:event_adminAgainPasswordFieldActionPerformed

    private void adminCurrentPasswordFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_adminCurrentPasswordFieldKeyPressed

        if (evt.getKeyCode() == 10) {
            if (adminCurrentPasswordField.getPassword().length > 0) {
                adminNewPasswordField.requestFocus();
            }
        }
    }//GEN-LAST:event_adminCurrentPasswordFieldKeyPressed

    private void adminNewPasswordFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_adminNewPasswordFieldKeyPressed

        if (evt.getKeyCode() == 10) {}
    }//GEN-LAST:event_adminNewPasswordFieldKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.JPasswordField adminAgainPasswordField;
    private javax.swing.JPasswordField adminCurrentPasswordField;
    private javax.swing.JPasswordField adminNewPasswordField;
    public static javax.swing.JComboBox employeeComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tempTable;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables
    DefaultTableModel tempTableModel;

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
        Combo.fillEmployees(employeeComboBox);
        fillTempTable();
    }

    protected void onLoad() {
        initComponents();
        tempTableModel = (DefaultTableModel) tempTable.getModel();
        tempTable.setDefaultRenderer(Object.class, coloredCellRenderer);
    }

    private void removeRows() {
        int[] selected = tempTable.getSelectedRows();
        if (selected.length == tempTable.getRowCount()) {
            showError("You can't delete all operators");
            return;
        }
        for (int idx = 0; idx < selected.length; idx++) {
            if (!manager.delete(Operator.class, tempTable.getValueAt(selected[idx], 1).toString())) {
                continue;
            }
        }
        fillTempTable();
    }

    private void createOperator() {
        Object o = employeeComboBox.getSelectedItem();
        if (o instanceof Employee) {
            Employee employee = (Employee) o;
            Collection<Operator> operators = employee.getOperatorCollection();
            if (operators.isEmpty()) {
                String username = usernameTextField.getText().trim();
                String password = new String(PasswordField.getPassword()).trim();
                if (password.equals("") || username.equals("") || username.equals("admin")) {
                    return;
                }
                Operator operator = new Operator(username);
                operator.setCreatedBy(Data.getOperator().getUsername());
                operator.setEmployee(employee);
                operator.setUsername(username);
                operator.setPassword(password);
                operator.setPower(0);
                operator.setCreatedDate(new Date());
                manager.update(operator);
                fillTempTable();
                usernameTextField.setText("");
                PasswordField.setText("");
                employeeComboBox.requestFocus();
            } else {
                showError("This Employee Is Already an Operator");
            }
        }
    }

    void fillTempTable() {
        tempTableModel.setRowCount(0);
        List<Operator> operators = manager.find(Operator.class);
        for (Operator operator : operators) {
            Date cDat = operator.getCreatedDate() == null ? new Date() : operator.getCreatedDate();
            Employee employee = operator.getEmployee();
            if (employee == null) {
                continue;
            }
            Person person = employee.getPerson();
            if (person == null) {
                continue;
            }
            Object[] row = {employee.getPerson().getName(), operator.getUsername(), yyyy_MM_dd.format(cDat), operator.getCreatedBy()};
            tempTableModel.addRow(row);
        }
    }

    @Override
    public void componentOpened() {
        // TODO add custom code on component opening
    }

    @Override
    public void componentClosed() {
        // TODO add custom code on component closing
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    void readProperties(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }

    private void changeAdminPassword() {
        String currentPassword = new String(adminCurrentPasswordField.getPassword());
        String newPassword = new String(adminNewPasswordField.getPassword());
        String againPassword = new String(adminAgainPasswordField.getPassword());
        if (newPassword.equals(againPassword)) {
            Operator operator = manager.find(Operator.class, "admin");
            if (currentPassword.equals(operator.getPassword())) {
                operator.setPassword(newPassword);
                manager.update(operator);
                adminCurrentPasswordField.setText("");
                adminNewPasswordField.setText("");
                adminAgainPasswordField.setText("");
            }
        }

    }
}
