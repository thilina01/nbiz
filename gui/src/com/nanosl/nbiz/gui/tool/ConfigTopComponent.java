/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.gui.tool;

import com.nanosl.nbiz.util.NTopComponent;
import entity.Config;
import java.lang.reflect.Field;
import java.util.List;
import javax.swing.DefaultListModel;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.TopComponent;
import util.ToString;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
        dtd = "-//com.nanosl.nbiz.gui.tool//Config//EN",
        autostore = false
)
@TopComponent.Description(
        preferredID = "ConfigTopComponent",
        //iconBase="SET/PATH/TO/ICON/HERE", 
        persistenceType = TopComponent.PERSISTENCE_ALWAYS
)
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@ActionID(category = "Window", id = "com.nanosl.nbiz.gui.tool.ConfigTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_ConfigAction",
        preferredID = "ConfigTopComponent"
)
@Messages({
    "CTL_ConfigAction=Config",
    "CTL_ConfigTopComponent=Config Window",
    "HINT_ConfigTopComponent=This is a Config window"
})
public final class ConfigTopComponent extends NTopComponent {

    DefaultListModel fieldListModel, classListModel;

    public ConfigTopComponent() {
        initComponents();
        setName(Bundle.CTL_ConfigTopComponent());
        setToolTipText(Bundle.HINT_ConfigTopComponent());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        classList = new javax.swing.JList();
        reloadButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        fieldList = new javax.swing.JList();
        patternTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        sampleTextField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        classList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                classListValueChanged(evt);
            }
        });
        classList.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                classListPropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(classList);

        org.openide.awt.Mnemonics.setLocalizedText(reloadButton, org.openide.util.NbBundle.getMessage(ConfigTopComponent.class, "ConfigTopComponent.reloadButton.text")); // NOI18N
        reloadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reloadButtonActionPerformed(evt);
            }
        });

        fieldList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fieldListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(fieldList);

        patternTextField.setText(org.openide.util.NbBundle.getMessage(ConfigTopComponent.class, "ConfigTopComponent.patternTextField.text")); // NOI18N
        patternTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patternTextFieldActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(ConfigTopComponent.class, "ConfigTopComponent.jLabel1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(ConfigTopComponent.class, "ConfigTopComponent.jLabel2.text")); // NOI18N

        sampleTextField.setText(org.openide.util.NbBundle.getMessage(ConfigTopComponent.class, "ConfigTopComponent.sampleTextField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jButton1, org.openide.util.NbBundle.getMessage(ConfigTopComponent.class, "ConfigTopComponent.jButton1.text")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText(org.openide.util.NbBundle.getMessage(ConfigTopComponent.class, "ConfigTopComponent.jTextArea1.text")); // NOI18N
        jTextArea1.setWrapStyleWord(true);
        jScrollPane3.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(patternTextField)
                            .addComponent(sampleTextField)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane3)))
                    .addComponent(reloadButton))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(reloadButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(patternTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sampleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3)))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void reloadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reloadButtonActionPerformed
        fillClassList();
    }//GEN-LAST:event_reloadButtonActionPerformed

    private void classListPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_classListPropertyChange


    }//GEN-LAST:event_classListPropertyChange

    private void classListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_classListValueChanged
        fillFieldList();
    }//GEN-LAST:event_classListValueChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        patternTextField.setText("");
        sampleTextField.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void fieldListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fieldListMouseClicked
        if (evt.getClickCount() > 1) {
            String pattern = patternTextField.getText();
            if (pattern.isEmpty()) {
                pattern = fieldList.getSelectedValue() + ",";
            } else if (pattern.lastIndexOf(",") == pattern.length() - 1) {
                pattern += fieldList.getSelectedValue();
            } else {
                pattern += "," + fieldList.getSelectedValue();
            }
            patternTextField.setText(pattern);
            savePattern(pattern);

        }
    }//GEN-LAST:event_fieldListMouseClicked

    private void patternTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patternTextFieldActionPerformed
        savePattern(patternTextField.getText());
    }//GEN-LAST:event_patternTextFieldActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList classList;
    private javax.swing.JList fieldList;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField patternTextField;
    private javax.swing.JButton reloadButton;
    private javax.swing.JTextField sampleTextField;
    // End of variables declaration//GEN-END:variables
    @Override
    public void setVisible(boolean aFlag) {
        super.setVisible(aFlag);
        fillClassList();
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

    private void fillClassList() {
        classListModel = new DefaultListModel();
        List<Config> configs = manager.find(Config.class);
        for (Config config : configs) {
            classListModel.addElement(config.getConfigKey());
        }
        classList.setModel(classListModel);
    }

    private void fillFieldList() {
        try {
            fieldListModel = new DefaultListModel();
            fieldList.setModel(fieldListModel);
            patternTextField.setText("");
            sampleTextField.setText("");
            String className = (String) classList.getSelectedValue();
            if (className == null) {
                return;
            }
            Config config = manager.find(Config.class, className);
            if (config == null) {
                return;
            }
            patternTextField.setText(config.getConfigValue());
            Class<?> c = Class.forName("entity." + className);
            for (Field field : c.getDeclaredFields()) {
                fieldListModel.addElement(field.getName());
            }
            fieldList.setModel(fieldListModel);
            fillSample(className);
        } catch (ClassNotFoundException e) {
        }
    }

    private void fillSample(String className) {
        sampleTextField.setText("");
        try {
            Class<?> c = Class.forName("entity." + className);
            if (!className.substring(className.length() - 2).equals("PK")) {
                sampleTextField.setText(manager.findOne(c).toString());
            } else {
                sampleTextField.setText("Not Available");
            }
        } catch (ClassNotFoundException ex) {
            Exceptions.printStackTrace(ex);
        }
    }

    private void savePattern(String pattern) {
        String className = classList.getSelectedValue().toString();
        Config config = manager.find(Config.class, className);
        config.setConfigValue(pattern);
        manager.update(config);
        ToString.remove(className);
        fillSample(className);
    }
}