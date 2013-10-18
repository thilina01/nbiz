/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.gui;

import entity.DamageNotes;
import entity.Employee;
import entity.Item;
import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import javax.swing.JComponent;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.windows.TopComponent;
import org.openide.util.NbBundle.Messages;
import query.Find;
import com.nanosl.nbiz.util.NTopComponent;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
        dtd = "-//com.nanosl.nbiz.gui//DamageNotes//EN",
        autostore = false)
@TopComponent.Description(
        preferredID = "DamageNotesTopComponent",
        //iconBase="SET/PATH/TO/ICON/HERE", 
        persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@ActionID(category = "Window", id = "com.nanosl.nbiz.gui.DamageNotesTopComponent")
@ActionReference(path = "Menu/Main" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_DamageNotesAction",
        preferredID = "DamageNotesTopComponent")
@Messages({
    "CTL_DamageNotesAction=DamageNotes",
    "CTL_DamageNotesTopComponent=DamageNotes Window",
    "HINT_DamageNotesTopComponent=This is a DamageNotes window"
})
public final class DamageNotesTopComponent extends NTopComponent {

    public DamageNotesTopComponent() {
        setName(Bundle.CTL_DamageNotesTopComponent());
        setToolTipText(Bundle.HINT_DamageNotesTopComponent());
        onLoad();

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
        reloadButton = new javax.swing.JButton();
        totalLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        datePicker = new org.jdesktop.swingx.JXDatePicker();
        repComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        masterTable.setAutoCreateRowSorter(true);
        masterTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Date", "Code", "Description", "Quantity", "Rate", "Value"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        masterTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                masterTableMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                masterTableMouseClicked(evt);
            }
        });
        masterTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                masterTableKeyReleased(evt);
            }
        });
        masterScrollPane.setViewportView(masterTable);
        masterTable.getColumnModel().getColumn(0).setPreferredWidth(30);
        masterTable.getColumnModel().getColumn(0).setHeaderValue(org.openide.util.NbBundle.getMessage(DamageNotesTopComponent.class, "DamageNotesTopComponent.masterTable.columnModel.title0")); // NOI18N
        masterTable.getColumnModel().getColumn(1).setHeaderValue(org.openide.util.NbBundle.getMessage(DamageNotesTopComponent.class, "DamageNotesTopComponent.masterTable.columnModel.title1")); // NOI18N
        masterTable.getColumnModel().getColumn(2).setHeaderValue(org.openide.util.NbBundle.getMessage(DamageNotesTopComponent.class, "DamageNotesTopComponent.masterTable.columnModel.title2")); // NOI18N
        masterTable.getColumnModel().getColumn(3).setPreferredWidth(300);
        masterTable.getColumnModel().getColumn(3).setHeaderValue(org.openide.util.NbBundle.getMessage(DamageNotesTopComponent.class, "DamageNotesTopComponent.masterTable.columnModel.title3")); // NOI18N
        masterTable.getColumnModel().getColumn(4).setHeaderValue(org.openide.util.NbBundle.getMessage(DamageNotesTopComponent.class, "DamageNotesTopComponent.masterTable.columnModel.title4")); // NOI18N
        masterTable.getColumnModel().getColumn(4).setCellRenderer(rightAlignCell);
        masterTable.getColumnModel().getColumn(5).setHeaderValue(org.openide.util.NbBundle.getMessage(DamageNotesTopComponent.class, "DamageNotesTopComponent.masterTable.columnModel.title5")); // NOI18N
        masterTable.getColumnModel().getColumn(5).setCellRenderer(rightAlignCell);
        masterTable.getColumnModel().getColumn(6).setHeaderValue(org.openide.util.NbBundle.getMessage(DamageNotesTopComponent.class, "DamageNotesTopComponent.masterTable.columnModel.title6")); // NOI18N
        masterTable.getColumnModel().getColumn(6).setCellRenderer(rightAlignCell);

        org.openide.awt.Mnemonics.setLocalizedText(reloadButton, org.openide.util.NbBundle.getMessage(DamageNotesTopComponent.class, "DamageNotesTopComponent.reloadButton.text")); // NOI18N
        reloadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reloadButtonActionPerformed(evt);
            }
        });

        totalLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(totalLabel, org.openide.util.NbBundle.getMessage(DamageNotesTopComponent.class, "DamageNotesTopComponent.totalLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(DamageNotesTopComponent.class, "DamageNotesTopComponent.jLabel3.text")); // NOI18N

        datePicker.setName("datePicker"); // NOI18N
        datePicker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datePickerActionPerformed1(evt);
            }
        });
        datePicker.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                datePickerKeyPressed(evt);
            }
        });

        repComboBox.setName("repComboBox"); // NOI18N
        repComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repComboBoxActionPerformed(evt);
            }
        });
        repComboBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                repComboBoxKeyPressed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(DamageNotesTopComponent.class, "DamageNotesTopComponent.jLabel4.text")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 898, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(repComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(datePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(reloadButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(totalLabel)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(repComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(datePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(reloadButton, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
    }//GEN-LAST:event_masterTableMouseClicked

    private void masterTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masterTableMouseReleased
    }//GEN-LAST:event_masterTableMouseReleased

    private void masterTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_masterTableKeyReleased
    }//GEN-LAST:event_masterTableKeyReleased

    private void reloadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reloadButtonActionPerformed
        fillTable(datePicker.getDate());
    }//GEN-LAST:event_reloadButtonActionPerformed

    private void datePickerActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datePickerActionPerformed1
        fillTable(datePicker.getDate());
    }//GEN-LAST:event_datePickerActionPerformed1

    private void datePickerKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_datePickerKeyPressed
        if (evt.getKeyCode() == 10) {
            fillTable(datePicker.getDate());
        }
    }//GEN-LAST:event_datePickerKeyPressed

    private void repComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repComboBoxActionPerformed
    }//GEN-LAST:event_repComboBoxActionPerformed

    private void repComboBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_repComboBoxKeyPressed
        if (evt.getKeyCode() == 10) {
            fillTable(datePicker.getDate());
        }
    }//GEN-LAST:event_repComboBoxKeyPressed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXDatePicker datePicker;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane masterScrollPane;
    private javax.swing.JTable masterTable;
    private javax.swing.JButton reloadButton;
    private javax.swing.JComboBox repComboBox;
    private javax.swing.JLabel totalLabel;
    // End of variables declaration//GEN-END:variables
    DefaultTableModel tableModel;

    private void fillTable(Date date) {
        Employee employee = (Employee) repComboBox.getSelectedItem();
        tableModel.setRowCount(0);
        int i = 0;
        double total = 0;
        Collection<DamageNotes> damageNoteses = Find.damageNotesByDateAndRef(date, employee);
        for (Iterator<DamageNotes> it = damageNoteses.iterator(); it.hasNext();) {
            DamageNotes damageNotes = it.next();
            Item item = damageNotes.getItem();
            double quantity = damageNotes.getQuantity();
            double rate = damageNotes.getRate() != null ? damageNotes.getRate() : 0.0;
            total += (quantity * rate);
            Object[] row = {++i, yyyy_MM_dd.format(damageNotes.getDamageNotesPK().getDateTime()), item.getCode(), item.getDescription(), nf2d.format(quantity), nf2d.format(rate), nf2d.format(quantity * rate)};
            tableModel.addRow(row);
        }
        totalLabel.setText(nf2d.format(total));
    }

    protected void onLoad() {
        initComponents();
        tableModel = (DefaultTableModel) masterTable.getModel();
        masterTable.setDefaultRenderer(Object.class, coloredCellRenderer);
        KeyAdapter();
    }

    private void KeyAdapter() {
        AutoCompleteDecorator.decorate(repComboBox);
        setComboBoxKeyAdapters(repComboBox);
        setComboBoxKeyAdapters(datePicker);
    }

    private void setComboBoxKeyAdapters(JComponent comp) {
        String compName = comp.getName();
        Component component[] = comp.getComponents();
        for (int i = 0; i < component.length; i++) {
            if (compName.equals("repComboBox")) {
                component[i].addKeyListener(repComboBoxKeyAdapter);
            } else if (compName.equals("datePicker")) {
                component[i].addKeyListener(datePickerKeyAdapter);
            }
        }
    }
    KeyAdapter datePickerKeyAdapter = new java.awt.event.KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent evt) {
            datePickerKeyPressed(evt);
        }
    };
    KeyAdapter repComboBoxKeyAdapter = new java.awt.event.KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent evt) {
            repComboBoxKeyPressed(evt);
        }
    };

    @Override
    public void componentOpened() {
        repComboBox.requestFocus();
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
}
