/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.gui;

import com.nanosl.nbiz.util.NTopComponent;
import entity.Employee;
import entity.EmployeePosition;
import entity.Person;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
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
        addressField = new javax.swing.JTextField();
        fixedLineField = new javax.swing.JTextField();
        mobileField = new javax.swing.JTextField();
        firstNameLabel = new javax.swing.JLabel();
        notesField = new javax.swing.JTextField();
        codeLabel = new javax.swing.JLabel();
        masterScrollPane = new javax.swing.JScrollPane();
        masterTable = new javax.swing.JTable();
        mobileLabel = new javax.swing.JLabel();
        notesLabel = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        codeField = new javax.swing.JTextField();
        fixedLineLabel = new javax.swing.JLabel();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        positionComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        nicTextField = new javax.swing.JTextField();

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cityField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cityFieldActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(addressNumberLabel, org.openide.util.NbBundle.getMessage(EmployeeTopComponent.class, "EmployeeTopComponent.addressNumberLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(cityLabel, org.openide.util.NbBundle.getMessage(EmployeeTopComponent.class, "EmployeeTopComponent.cityLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(employeePositionCodeLabel, org.openide.util.NbBundle.getMessage(EmployeeTopComponent.class, "EmployeeTopComponent.employeePositionCodeLabel.text")); // NOI18N

        addressField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressFieldActionPerformed(evt);
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

        org.openide.awt.Mnemonics.setLocalizedText(codeLabel, org.openide.util.NbBundle.getMessage(EmployeeTopComponent.class, "EmployeeTopComponent.codeLabel.text")); // NOI18N

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
        if (masterTable.getColumnModel().getColumnCount() > 0) {
            masterTable.getColumnModel().getColumn(0).setPreferredWidth(30);
            masterTable.getColumnModel().getColumn(0).setHeaderValue(org.openide.util.NbBundle.getMessage(EmployeeTopComponent.class, "EmployeeTopComponent.masterTable.columnModel.title0")); // NOI18N
            masterTable.getColumnModel().getColumn(1).setHeaderValue(org.openide.util.NbBundle.getMessage(EmployeeTopComponent.class, "EmployeeTopComponent.masterTable.columnModel.title1")); // NOI18N
            masterTable.getColumnModel().getColumn(2).setPreferredWidth(300);
            masterTable.getColumnModel().getColumn(2).setHeaderValue(org.openide.util.NbBundle.getMessage(EmployeeTopComponent.class, "EmployeeTopComponent.masterTable.columnModel.title2")); // NOI18N
            masterTable.getColumnModel().getColumn(3).setHeaderValue(org.openide.util.NbBundle.getMessage(EmployeeTopComponent.class, "EmployeeTopComponent.masterTable.columnModel.title3")); // NOI18N
        }

        org.openide.awt.Mnemonics.setLocalizedText(mobileLabel, org.openide.util.NbBundle.getMessage(EmployeeTopComponent.class, "EmployeeTopComponent.mobileLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(notesLabel, org.openide.util.NbBundle.getMessage(EmployeeTopComponent.class, "EmployeeTopComponent.notesLabel.text")); // NOI18N

        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFieldActionPerformed(evt);
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
        positionComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                positionComboBoxActionPerformed(evt);
            }
        });
        positionComboBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                positionComboBoxKeyPressed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(EmployeeTopComponent.class, "EmployeeTopComponent.jLabel1.text")); // NOI18N

        nicTextField.setText(org.openide.util.NbBundle.getMessage(EmployeeTopComponent.class, "EmployeeTopComponent.nicTextField.text")); // NOI18N
        nicTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nicTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cityLabel)
                            .addComponent(mobileLabel)
                            .addComponent(fixedLineLabel)
                            .addComponent(notesLabel)
                            .addComponent(codeLabel)
                            .addComponent(firstNameLabel)
                            .addComponent(employeePositionCodeLabel)
                            .addComponent(addressNumberLabel))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cityField, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(updateButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(clearButton))
                            .addComponent(positionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addressField, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fixedLineField, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mobileField, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(notesField, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(codeField, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nicTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(masterScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {addressField, cityField, fixedLineField, mobileField, nameField, notesField, positionComboBox});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codeLabel)
                    .addComponent(codeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(nicTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameLabel)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(employeePositionCodeLabel)
                    .addComponent(positionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addressNumberLabel)
                    .addComponent(addressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void addressFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressFieldActionPerformed
        if (!addressField.getText().trim().equals("")) {
            cityField.requestFocus();
        }
    }//GEN-LAST:event_addressFieldActionPerformed

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

    private void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFieldActionPerformed
        if (!nameField.getText().trim().equals("")) {
            positionComboBox.requestFocus();
        }
    }//GEN-LAST:event_nameFieldActionPerformed

    private void codeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codeFieldActionPerformed
        String code = codeField.getText().trim();
        if (!code.equals("")) {
            fill(code);
            nicTextField.requestFocus();
        }
    }//GEN-LAST:event_codeFieldActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        if (!codeField.getText().equals("") && !nameField.getText().equals("")&& !nicTextField.getText().equals("")) {// && !lastNameField.equals("") && !addressNumberField.getText().equals("") && !addressStreetField.getText().equals("") && !cityField.getText().equals("")
            update();
        } else {
            showError("code, Name and NIC should be presented");
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
            addressField.requestFocus();
        }
    }//GEN-LAST:event_positionComboBoxKeyPressed

    private void positionComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_positionComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_positionComboBoxActionPerformed

    private void nicTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nicTextFieldActionPerformed
        String nic = nicTextField.getText().trim();
        if (!nic.equals("")) {
            fillByNic(nic);
            nameField.requestFocus();
        }
    }//GEN-LAST:event_nicTextFieldActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressField;
    private javax.swing.JLabel addressNumberLabel;
    private javax.swing.JTextField cityField;
    private javax.swing.JLabel cityLabel;
    private javax.swing.JButton clearButton;
    private javax.swing.JTextField codeField;
    private javax.swing.JLabel codeLabel;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel employeePositionCodeLabel;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JTextField fixedLineField;
    private javax.swing.JLabel fixedLineLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane masterScrollPane;
    private javax.swing.JTable masterTable;
    private javax.swing.JTextField mobileField;
    private javax.swing.JLabel mobileLabel;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField nicTextField;
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
        for (Employee employee : employees) {
            Person person = employee.getPerson();
            if (person == null) {
                continue;
            }
            Object[] row = {++i, employee.getCode(), person.getName(), person.getMobile()};
            tableModel.addRow(row);
        }
    }

    private void fillPositions() {
        positionComboBox.setModel(new DefaultComboBoxModel(manager.find(EmployeePosition.class).toArray()));
    }

    private void clearFields() {
        codeField.requestFocus();
        codeField.setText("");
        nicTextField.setText("");
        nameField.setText("");
        addressField.setText("");
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
            return;
        }
        if (manager.delete(Employee.class, code)) {
            clear();
            return;
        }
        showError("Unable to delete " + code);
    }

    private void update() {
        String code = codeField.getText().trim();
        String nic = nicTextField.getText().trim();
        String name = nameField.getText().trim();
        if (code.equals("")) {
            codeField.requestFocus();
            return;
        }
        if (name.equals("")) {
            nameField.requestFocus();
            return;
        }

        String address = addressField.getText().trim();
        String mobile = mobileField.getText().trim();
        String fixedLine = fixedLineField.getText().trim();
        String notes = notesField.getText().trim();
        String city = cityField.getText().trim();
        Employee employee = manager.find(Employee.class, code);
        if (employee == null) {
            employee = new Employee(code);
        }
        Person person = new Person(nic);
        person.setName(name);
        employee.setPerson(person);
        employee.setEmployeePosition((EmployeePosition) positionComboBox.getSelectedItem());
        person.setAddress(address);
        employee.setFixedLine(fixedLine);
        person.setMobile(mobile);
        employee.setNotes(notes);
        person.setCity(city);
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
            Person person = employee.getPerson();
            fill(person);
            codeField.setText(employee.getCode());
            fixedLineField.setText(employee.getFixedLine());
            notesField.setText(employee.getNotes());
            positionComboBox.setSelectedItem(employee.getEmployeePosition());
        }
    }

    private void fill(Person person) {
        if (person != null) {
            nameField.setText(person.getName());
            addressField.setText(person.getAddress());
            cityField.setText(person.getCity());
            mobileField.setText(person.getMobile());
        }
    }

    private void fill(String code) {
        Employee employee = manager.find(Employee.class, code);
        fill(employee);
    }

    private void fillByNic(String nic) {
        Person person = manager.find(Person.class, nic);
        fill(person);
    }
}
