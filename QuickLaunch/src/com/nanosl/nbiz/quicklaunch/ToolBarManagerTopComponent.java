/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.quicklaunch;

import com.nanosl.nbiz.util.NTopComponent;
import entity.ToolBarButton;
import java.awt.Toolkit;
import java.net.URL;
import java.util.Collection;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.table.DefaultTableModel;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.util.Lookup;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
        dtd = "-//com.nanosl.nbiz.quicklaunch//ToolBarManager//EN",
        autostore = false
)
@TopComponent.Description(
        preferredID = "ToolBarManagerTopComponent",
        //iconBase="SET/PATH/TO/ICON/HERE", 
        persistenceType = TopComponent.PERSISTENCE_ALWAYS
)
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@ActionID(category = "Window", id = "com.nanosl.nbiz.quicklaunch.ToolBarManagerTopComponent")
@ActionReference(path = "Menu/Tools" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_ToolBarManagerAction",
        preferredID = "ToolBarManagerTopComponent"
)
@Messages({
    "CTL_ToolBarManagerAction=ToolBarManager",
    "CTL_ToolBarManagerTopComponent=ToolBarManager Window",
    "HINT_ToolBarManagerTopComponent=This is a ToolBarManager window"
})
public final class ToolBarManagerTopComponent extends NTopComponent {

    public ToolBarManagerTopComponent() {
        initComponents();
        setName(Bundle.CTL_ToolBarManagerTopComponent());
        setToolTipText(Bundle.HINT_ToolBarManagerTopComponent());
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Button", "Status", "Component"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Boolean.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(0).setHeaderValue(org.openide.util.NbBundle.getMessage(ToolBarManagerTopComponent.class, "ToolBarManagerTopComponent.jTable1.columnModel.title0")); // NOI18N
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(1).setHeaderValue(org.openide.util.NbBundle.getMessage(ToolBarManagerTopComponent.class, "ToolBarManagerTopComponent.jTable1.columnModel.title1")); // NOI18N
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(2).setHeaderValue(org.openide.util.NbBundle.getMessage(ToolBarManagerTopComponent.class, "ToolBarManagerTopComponent.jTable1.columnModel.title2_1")); // NOI18N
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(92, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        boolean b = (boolean) jTable1.getValueAt(jTable1.getSelectedRow(), 1);
        String componentName = jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString();
        ToolBarButton toolBarButton = manager.find(ToolBarButton.class, componentName);
        toolBarButton.setStatus(b ? 1 : 0);
        manager.update(toolBarButton);
        SideBarPanel.getInstance().loadButtons();

    }//GEN-LAST:event_jTable1MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
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
    DefaultTableModel defaultTableModel;

    private void onLoad() {
        defaultTableModel = (DefaultTableModel) jTable1.getModel();

        jTable1.getColumn("Button").setCellRenderer(new ButtonRenderer());
        jTable1.getColumn("Button").setCellEditor(new ButtonEditor(new JCheckBox()));
        jTable1.setRowHeight(50);
        Collection<ToolBarButton> toolBarButtons = manager.find(ToolBarButton.class);
//        ArrayList<JButton> jButtons = new ArrayList<>();
        ClassLoader classLoader = Lookup.getDefault().lookup(ClassLoader.class);
        toolBarButtons.stream().forEach((toolBarButton) -> {
            TopComponent tc = WindowManager.getDefault().findTopComponent(toolBarButton.getComponentName());
            if (!(tc == null)) {
                ButtonRenderer button = new ButtonRenderer();
                button.setText(toolBarButton.getButtonText());
                String iconPath = toolBarButton.getIconPath();
                URL resource = classLoader.getResource(iconPath);
                if (resource != null) {
                    ImageIcon imageIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(resource));
                    button.setIcon(imageIcon);
                }
                button.addActionListener((java.awt.event.ActionEvent evt) -> {

                    tc.open();
                    tc.requestActive();
                });
                Object[] rowData = {button, toolBarButton.getStatus() == 1, toolBarButton.getComponentName()};
                defaultTableModel.addRow(rowData);
//                jButtons.add(button);
            }
        });
    }
}
