/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.gui;

import com.nanosl.nbiz.util.NTopComponent;
import entity.Employee;
import entity.EmployeePosition;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.windows.TopComponent;
import org.openide.util.NbBundle.Messages;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
        dtd = "-//com.nanosl.nbiz.gui//Employee//EN",
        autostore = false)
@TopComponent.Description(
        preferredID = "EmployeeTopComponent",
        //iconBase="SET/PATH/TO/ICON/HERE", 
        persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@ActionID(category = "Window", id = "com.nanosl.nbiz.gui.EmployeeTopComponent")
@ActionReference(path = "Menu/General" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_EmployeeAction",
        preferredID = "EmployeeTopComponent")
@Messages({
    "CTL_EmployeeAction=Employee",
    "CTL_EmployeeTopComponent=Employee Window",
    "HINT_EmployeeTopComponent=This is a Employee window"
})
public final class EmployeeTopComponent extends NTopComponent {

    public EmployeeTopComponent() {
        onLoad();
        setName(Bundle.CTL_EmployeeTopComponent());
        setToolTipText(Bundle.HINT_EmployeeTopComponent());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cityField = new javax.swing.JTextField();
        addressNumberLabel = new javax.swing.JLabel();
        cityLabel = new javax.swing.JLabel();
        employeePositionCodeLabel = new javax.swing.JLabel();
        addressNumberField = new javax.swing.JTextField();
        fixedLineField = new javax.swing.JTextField();
        mobileField = new javax.swing.JTextField();
        firstNameLabel = new javax.swing.JLabel();
        notesField = new javax.swing.JTextField();
        lastNameLabel = new javax.swing.JLabel();
        codeLabel = new javax.swing.JLabel();
        addressStreetLabel = new javax.swing.JLabel();
        masterScrollPane = new javax.swing.JScrollPane();
        masterTable = new javax.swing.JTable();
        mobileLabel = new javax.swing.JLabel();
        lastNameField = new javax.swing.JTextField();
        notesLabel = new javax.swing.JLabel();
        firstNameField = new javax.swing.JTextField();
        addressStreetField = new javax.swing.JTextField();
        codeField = new javax.swing.JTextField();
        fixedLineLabel = new javax.swing.JLabel();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        positionComboBox = new javax.swing.JComboBox();

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cityField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cityFieldActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(addressNumberLabel, org.openide.util.NbBundle.getMessage(EmployeeTopComponent.class, "EmployeeTopComponent.addressNumberLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(cityLabel, org.openide.util.NbBundle.getMessage(EmployeeTopComponent.class, "EmployeeTopComponent.cityLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(employeePositionCodeLabel, org.openide.util.NbBundle.getMessage(EmployeeTopComponent.class, "EmployeeTopComponent.employeePositionCodeLabel.text")); // NOI18N

        addressNumberField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressNumberFieldActionPerformed(evt);
            }
        });

        fixedLineField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fixedLineFieldActionPerformed(evt);
            }
        });

        mobileField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mobileFieldActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(firstNameLabel, org.openide.util.NbBundle.getMessage(EmployeeTopComponent.class, "EmployeeTopComponent.firstNameLabel.text")); // NOI18N

        notesField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notesFieldActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(lastNameLabel, org.openide.util.NbBundle.getMessage(EmployeeTopComponent.class, "EmployeeTopComponent.lastNameLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(codeLabel, org.openide.util.NbBundle.getMessage(EmployeeTopComponent.class, "EmployeeTopComponent.codeLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(addressStreetLabel, org.openide.util.NbBundle.getMessage(EmployeeTopComponent.class, "EmployeeTopComponent.addressStreetLabel.text")); // NOI18N

        masterTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Code", "Name", "Mobile"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        masterTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                masterTableMouseReleased(evt);
            }
        });
        masterTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                masterTableKeyReleased(evt);
            }
        });
        masterScrollPane.setViewportView(masterTable);
        masterTable.getColumnModel().getColumn(0).setPreferredWidth(30);
        masterTable.getColumnModel().getColumn(0).setHeaderValue(org.openide.util.NbBundle.getMessage(EmployeeTopComponent.class, "EmployeeTopComponent.masterTable.columnModel.title0")); // NOI18N
        masterTable.getColumnModel().getColumn(1).setHeaderValue(org.openide.util.NbBundle.getMessage(EmployeeTopComponent.class, "EmployeeTopComponent.masterTable.columnModel.title1")); // NOI18N
        masterTable.getColumnModel().getColumn(2).setPreferredWidth(300);
        masterTable.getColumnModel().getColumn(2).setHeaderValue(org.openide.util.NbBundle.getMessage(EmployeeTopComponent.class, "EmployeeTopComponent.masterTable.columnModel.title2")); // NOI18N
        masterTable.getColumnModel().getColumn(3).setHeaderValue(org.openide.util.NbBundle.getMessage(EmployeeTopComponent.class, "EmployeeTopComponent.masterTable.columnModel.title3")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(mobileLabel, org.openide.util.NbBundle.getMessage(EmployeeTopComponent.class, "EmployeeTopComponent.mobileLabel.text")); // NOI18N

        lastNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastNameFieldActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(notesLabel, org.openide.util.NbBundle.getMessage(EmployeeTopComponent.class, "EmployeeTopComponent.notesLabel.text")); // NOI18N

        firstNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstNameFieldActionPerformed(evt);
            }
        });

        addressStreetField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressStreetFieldActionPerformed(evt);
            }
        });

        codeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codeFieldActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(fixedLineLabel, org.openide.util.NbBundle.getMessage(EmployeeTopComponent.class, "EmployeeTopComponent.fixedLineLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(updateButton, org.openide.util.NbBundle.getMessage(EmployeeTopComponent.class, "EmployeeTopComponent.updateButton.text")); // NOI18N
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(deleteButton, org.openide.util.NbBundle.getMessage(EmployeeTopComponent.class, "EmployeeTopComponent.deleteButton.text")); // NOI18N
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(clearButton, org.openide.util.NbBundle.getMessage(EmployeeTopComponent.class, "EmployeeTopComponent.clearButton.text")); // NOI18N
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        positionComboBox.setName("positionComboBox1"); // NOI18N
        positionComboBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                positionComboBoxKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(updateButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clearButton))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(masterScrollPane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(codeLabel)
                                .addComponent(firstNameLabel)
                                .addComponent(lastNameLabel)
                                .addComponent(employeePositionCodeLabel)
                                .addComponent(addressNumberLabel)
                                .addComponent(addressStreetLabel)
                                .addComponent(cityLabel)
                                .addComponent(mobileLabel)
                                .addComponent(fixedLineLabel)
                                .addComponent(notesLabel))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(positionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(notesField)
                                .addComponent(fixedLineField)
                                .addComponent(mobileField)
                                .addComponent(cityField)
                                .addComponent(addressStreetField)
                                .addComponent(addressNumberField, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
                                .addComponent(codeField, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lastNameField)
                                .addComponent(firstNameField)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codeLabel)
                    .addComponent(codeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameLabel)
                    .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastNameLabel)
                    .addComponent(lastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(employeePositionCodeLabel)
                    .addComponent(positionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addressNumberLabel)
                    .addComponent(addressNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addressStreetLabel)
                    .addComponent(addressStreetField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cityLabel)
                    .addComponent(cityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mobileLabel)
                    .addComponent(mobileField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fixedLineLabel)
                    .addComponent(fixedLineField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(notesLabel)
                    .addComponent(notesField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clearButton)
                    .addComponent(deleteButton)
                    .addComponent(updateButton))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cityFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cityFieldActionPerformed
        if (!cityField.getText().trim().equals("")) {
            mobileField.requestFocus();
        }
    }//GEN-LAST:event_cityFieldActionPerformed

    private void addressNumberFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressNumberFieldActionPerformed
        if (!addressNumberField.getText().trim().equals("")) {
            addressStreetField.requestFocus();
        }
    }//GEN-LAST:event_addressNumberFieldActionPerformed

    private void fixedLineFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fixedLineFieldActionPerformed
        notesField.requestFocus();
    }//GEN-LAST:event_fixedLineFieldActionPerformed

    private void mobileFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mobileFieldActionPerformed
        fixedLineField.requestFocus();
    }//GEN-LAST:event_mobileFieldActionPerformed

    private void notesFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notesFieldActionPerformed
        updateButton.requestFocus();
    }//GEN-LAST:event_notesFieldActionPerformed

    private void masterTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masterTableMouseReleased
        fill();
    }//GEN-LAST:event_masterTableMouseReleased

    private void masterTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_masterTableKeyReleased
        fill();
    }//GEN-LAST:event_masterTableKeyReleased

    private void lastNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastNameFieldActionPerformed
        if (!lastNameField.getText().trim().equals("")) {
            positionComboBox.requestFocus();
        }
    }//GEN-LAST:event_lastNameFieldActionPerformed

    private void firstNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstNameFieldActionPerformed
        if (!firstNameField.getText().trim().equals("")) {
            lastNameField.requestFocus();
        }
    }//GEN-LAST:event_firstNameFieldActionPerformed

    private void addressStreetFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressStreetFieldActionPerformed
        if (!addressStreetField.getText().trim().equals("")) {
            cityField.requestFocus();
        }
    }//GEN-LAST:event_addressStreetFieldActionPerformed

    private void codeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codeFieldActionPerformed
        String code = codeField.getText().trim();
        if (!code.equals("")) {
            fill(code);
            firstNameField.requestFocus();
        }
    }//GEN-LAST:event_codeFieldActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        if (!codeField.getText().equals("") && !firstNameField.getText().equals("")) {// && !lastNameField.equals("") && !addressNumberField.getText().equals("") && !addressStreetField.getText().equals("") && !cityField.getText().equals("")
            update();
        } else {
            showError("Atleast First Name should be presented along with code");
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        delete();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        clear();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void positionComboBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_positionComboBoxKeyPressed
        if (evt.getKeyCode() == 10) {
            addressNumberField.requestFocus();
        }
    }//GEN-LAST:event_positionComboBoxKeyPressed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressNumberField;
    private javax.swing.JLabel addressNumberLabel;
    private javax.swing.JTextField addressStreetField;
    private javax.swing.JLabel addressStreetLabel;
    private javax.swing.JTextField cityField;
    private javax.swing.JLabel cityLabel;
    private javax.swing.JButton clearButton;
    private javax.swing.JTextField codeField;
    private javax.swing.JLabel codeLabel;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel employeePositionCodeLabel;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JTextField fixedLineField;
    private javax.swing.JLabel fixedLineLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JScrollPane masterScrollPane;
    private javax.swing.JTable masterTable;
    private javax.swing.JTextField mobileField;
    private javax.swing.JLabel mobileLabel;
    private javax.swing.JTextField notesField;
    private javax.swing.JLabel notesLabel;
    private javax.swing.JComboBox positionComboBox;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
    DefaultTableModel tableModel;

    protected void onLoad() {
        initComponents();
        tableModel = (DefaultTableModel) masterTable.getModel();
        masterTable.setDefaultRenderer(Object.class, coloredCellRenderer);
        clear();
    }

    private void clear() {
        clearFields();
        fillTable();
        fillPositions();
    }

    private void fillTable() {
        List<Employee> employees = manager.find(Employee.class);
        tableModel.setRowCount(0);
        int i = 0;
        for (Iterator<Employee> it = employees.iterator(); it.hasNext();) {
            Employee emp = it.next();
            Object[] row = {++i, emp.getCode(), emp.getFirstName() + " " + emp.getLastName(), emp.getMobile()};
            tableModel.addRow(row);
        }
    }

    private void fillPositions() {
        positionComboBox.setModel(new DefaultComboBoxModel(manager.find(EmployeePosition.class).toArray()));
    }

    private void clearFields() {
        codeField.requestFocus();
        codeField.setText("");
        firstNameField.setText("");
        lastNameField.setText("");
        addressNumberField.setText("");
        addressStreetField.setText("");
        cityField.setText("");
        mobileField.setText("");
        fixedLineField.setText("");
        notesField.setText("");
    }

    private void fill() {
        clearFields();
        int row = masterTable.getSelectedRow();
        if (row > -1) {
            fill(masterTable.getValueAt(row, 1).toString());
        }
    }

    private void delete() {
        String code = codeField.getText().trim();
        if (code.equals("")) {
            codeField.requestFocus();
            return;
        }
         if (JOptionPane.YES_OPTION != JOptionPane.showConfirmDialog(deleteButton, "Delete " + code + " ?", "sure?", JOptionPane.YES_NO_OPTION)) {
            return;}
        if (manager.delete(Employee.class, code)) {
            clear();
            return;
        }
        showError("Unable to delete " + code);
    }

    private void update() {
        String code = codeField.getText().trim();
        String firstName = firstNameField.getText().trim();
        String lastName = lastNameField.getText().trim();
        if (code.equals("")) {
            codeField.requestFocus();
            return;
        }
        if (firstName.equals("")) {
            firstNameField.requestFocus();
            return;
        }

        String addressNumber = addressNumberField.getText().trim();
        String addressStreet = addressStreetField.getText().trim();
        String mobile = mobileField.getText().trim();
        String fixedLine = fixedLineField.getText().trim();
        String notes = notesField.getText().trim();
        String city = cityField.getText().trim();
        Employee employee = manager.find(Employee.class, code);
        if (employee == null) {
            employee = new Employee(code);
        }
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setEmployeePosition((EmployeePosition) positionComboBox.getSelectedItem());
        employee.setAddressNumber(addressNumber);
        employee.setAddressStreet(addressStreet);
        employee.setFixedLine(fixedLine);
        employee.setMobile(mobile);
        employee.setNotes(notes);
        employee.setCity(city);
        if (manager.update(employee)) {
            clear();
            codeField.requestFocus();
            return;
        }
        showError("Unable to update " + code);
    }

    @Override
    public void componentOpened() {
        codeField.requestFocus();
    }

    @Override
    public void componentClosed() {
      codeField.requestFocus();
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

    private void fill(Employee employee) {
        if (employee != null) {
            codeField.setText(employee.getCode());

            firstNameField.setText(employee.getFirstName());
            lastNameField.setText(employee.getLastName());
            addressNumberField.setText(employee.getAddressNumber());
            addressStreetField.setText(employee.getAddressStreet());
            cityField.setText(employee.getCity());
            mobileField.setText(employee.getMobile());
            fixedLineField.setText(employee.getFixedLine());
            notesField.setText(employee.getNotes());
            positionComboBox.setSelectedItem(employee.getEmployeePosition());
        }
    }

    private void fill(String code) {
        Employee employee = manager.find(Employee.class, code);
        fill(employee);
    }
}
