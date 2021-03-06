/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.gui.tool;

import com.nanosl.nbiz.util.NTopComponent;
import entity.RootArea;
import java.util.Iterator;
import java.util.List;
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
        dtd = "-//com.nanosl.nbiz.gui.tool//RootArea//EN",
        autostore = false)
@TopComponent.Description(
        preferredID = "RootAreaTopComponent",
        //iconBase="SET/PATH/TO/ICON/HERE", 
        persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@ActionID(category = "Window", id = "com.nanosl.nbiz.gui.tool.RootAreaTopComponent")
@ActionReference(path = "Menu/Tools" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_RootAreaAction",
        preferredID = "RootAreaTopComponent")
@Messages({
    "CTL_RootAreaAction=RootArea",
    "CTL_RootAreaTopComponent=RootArea Window",
    "HINT_RootAreaTopComponent=This is a RootArea window"
})
public final class RootAreaTopComponent extends NTopComponent {

    public RootAreaTopComponent() {
        onLoad();
        setName(Bundle.CTL_RootAreaTopComponent());
        setToolTipText(Bundle.HINT_RootAreaTopComponent());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        masterScrollPane = new javax.swing.JScrollPane();
        masterTable = new javax.swing.JTable();
        codeLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        codeField = new javax.swing.JTextField();
        nameField = new javax.swing.JTextField();
        clearButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        masterTable.setAutoCreateRowSorter(true);
        masterTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Code", "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        masterTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                masterTableMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                masterTableMouseReleased(evt);
            }
        });
        masterTable.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                masterTableAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        masterTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                masterTableKeyReleased(evt);
            }
        });
        masterScrollPane.setViewportView(masterTable);

        org.openide.awt.Mnemonics.setLocalizedText(codeLabel, org.openide.util.NbBundle.getMessage(RootAreaTopComponent.class, "RootAreaTopComponent.codeLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(nameLabel, org.openide.util.NbBundle.getMessage(RootAreaTopComponent.class, "RootAreaTopComponent.nameLabel.text")); // NOI18N

        codeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codeFieldActionPerformed(evt);
            }
        });

        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFieldActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(clearButton, org.openide.util.NbBundle.getMessage(RootAreaTopComponent.class, "RootAreaTopComponent.clearButton.text")); // NOI18N
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(updateButton, org.openide.util.NbBundle.getMessage(RootAreaTopComponent.class, "RootAreaTopComponent.updateButton.text")); // NOI18N
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(deleteButton, org.openide.util.NbBundle.getMessage(RootAreaTopComponent.class, "RootAreaTopComponent.deleteButton.text")); // NOI18N
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(updateButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(deleteButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(clearButton))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(codeLabel)
                                .addComponent(nameLabel))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(codeField, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(masterScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(masterScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codeLabel)
                    .addComponent(codeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clearButton)
                    .addComponent(deleteButton)
                    .addComponent(updateButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void masterTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masterTableMouseClicked
        fill();
    }//GEN-LAST:event_masterTableMouseClicked

    private void masterTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masterTableMouseReleased
        fill();
    }//GEN-LAST:event_masterTableMouseReleased

    private void masterTableAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_masterTableAncestorAdded
        update();
        codeField.requestFocus();
    }//GEN-LAST:event_masterTableAncestorAdded

    private void masterTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_masterTableKeyReleased
        fill();
    }//GEN-LAST:event_masterTableKeyReleased

    private void codeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codeFieldActionPerformed
        if (!codeField.getText().trim().equals("")) {
            nameField.requestFocus();
        }
    }//GEN-LAST:event_codeFieldActionPerformed

    private void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFieldActionPerformed
        update();
        codeField.requestFocus();
    }//GEN-LAST:event_nameFieldActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        clear();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        update();
    }//GEN-LAST:event_updateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        delete();
    }//GEN-LAST:event_deleteButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearButton;
    private javax.swing.JTextField codeField;
    private javax.swing.JLabel codeLabel;
    private javax.swing.JButton deleteButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane masterScrollPane;
    private javax.swing.JTable masterTable;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
    DefaultTableModel tableModel;

    private void clear() {
        clearFields();
        fillTable();
    }

    private void fillTable() {
        List<RootArea> rootAreas = manager.find(RootArea.class);
        tableModel.setRowCount(0);
        int i = 0;
        for (Iterator<RootArea> it = rootAreas.iterator(); it.hasNext();) {
            RootArea rootArea = it.next();
            Object[] row = {++i, rootArea.getCode(), rootArea.getName()};
            tableModel.addRow(row);
        }
    }

    protected void onLoad() {
        initComponents();
        tableModel = (DefaultTableModel) masterTable.getModel();
        masterTable.setDefaultRenderer(Object.class, coloredCellRenderer);
        clear();
    }

    private void update() {
        String code = codeField.getText().trim();
        String name = nameField.getText().trim();
        if (code.equals("")) {
            codeField.requestFocus();
            return;
        }
        if (name.equals("")) {
            nameField.requestFocus();
            return;
        }

        RootArea rootArea = new RootArea(code);
        rootArea.setName(name);
        if (manager.update(rootArea)) {
            clear();
            return;
        }
        showError("Unable To Update!");
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
        if (manager.delete(RootArea.class, code)) {
            clear();
             return;
        }
        showError("Unable to delete " + code);
    }

    private void fill() {
        int row = masterTable.getSelectedRow();
        if (row > -1) {
            codeField.setText("" + masterTable.getValueAt(row, 1));
            nameField.setText("" + masterTable.getValueAt(row, 2));
        }
    }

    private void clearFields() {
        codeField.requestFocus();
        codeField.setText("");
        nameField.setText("");
    }

    @Override
    public void componentOpened() {
        // TODO add custom code on component opening
    }

    @Override
    public void componentClosed() {
        codeField.requestFocus();
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
}
