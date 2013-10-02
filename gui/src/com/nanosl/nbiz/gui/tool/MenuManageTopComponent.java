/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.gui.tool;

import com.nanosl.nbiz.util.Find;
import com.nanosl.nbiz.util.NTopComponent;
import entity.Menu;
import entity.MenuItem;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.windows.TopComponent;
import org.openide.util.NbBundle.Messages;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
        dtd = "-//com.nanosl.nbiz.gui.tool//MenuManage//EN",
        autostore = false)
@TopComponent.Description(
        preferredID = "MenuManageTopComponent",
        //iconBase="SET/PATH/TO/ICON/HERE", 
        persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@ActionID(category = "Window", id = "com.nanosl.nbiz.gui.tool.MenuManageTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_MenuManageAction",
        preferredID = "MenuManageTopComponent")
@Messages({
    "CTL_MenuManageAction=MenuManage",
    "CTL_MenuManageTopComponent=MenuManage Window",
    "HINT_MenuManageTopComponent=This is a MenuManage window"
})
public final class MenuManageTopComponent extends NTopComponent {

    public MenuManageTopComponent() {
        initComponents();
        setName(Bundle.CTL_MenuManageTopComponent());
        setToolTipText(Bundle.HINT_MenuManageTopComponent());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        menuAssignButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        inactiveMenuList = new javax.swing.JList();
        menuRemoveButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        activeMenuList = new javax.swing.JList();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        menuItemRemoveButton = new javax.swing.JButton();
        menuItemassignButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        activeMenuItemList = new javax.swing.JList();
        jScrollPane4 = new javax.swing.JScrollPane();
        inactiveMenuItemList = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(MenuManageTopComponent.class, "MenuManageTopComponent.jPanel2.border.title"))); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(MenuManageTopComponent.class, "MenuManageTopComponent.jLabel1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(MenuManageTopComponent.class, "MenuManageTopComponent.jLabel3.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(menuAssignButton, org.openide.util.NbBundle.getMessage(MenuManageTopComponent.class, "MenuManageTopComponent.menuAssignButton.text")); // NOI18N
        menuAssignButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAssignButtonActionPerformed(evt);
            }
        });

        jScrollPane3.setViewportView(inactiveMenuList);

        org.openide.awt.Mnemonics.setLocalizedText(menuRemoveButton, org.openide.util.NbBundle.getMessage(MenuManageTopComponent.class, "MenuManageTopComponent.menuRemoveButton.text")); // NOI18N
        menuRemoveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRemoveButtonActionPerformed(evt);
            }
        });

        activeMenuList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                activeMenuListMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                activeMenuListMouseReleased(evt);
            }
        });
        activeMenuList.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                activeMenuListKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(activeMenuList);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menuRemoveButton)
                    .addComponent(menuAssignButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane3, 0, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(menuAssignButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(menuRemoveButton)))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(MenuManageTopComponent.class, "MenuManageTopComponent.jPanel3.border.title"))); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(MenuManageTopComponent.class, "MenuManageTopComponent.jLabel4.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(menuItemRemoveButton, org.openide.util.NbBundle.getMessage(MenuManageTopComponent.class, "MenuManageTopComponent.menuItemRemoveButton.text")); // NOI18N
        menuItemRemoveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemRemoveButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(menuItemassignButton, org.openide.util.NbBundle.getMessage(MenuManageTopComponent.class, "MenuManageTopComponent.menuItemassignButton.text")); // NOI18N
        menuItemassignButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemassignButtonActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(activeMenuItemList);

        jScrollPane4.setViewportView(inactiveMenuItemList);

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(MenuManageTopComponent.class, "MenuManageTopComponent.jLabel2.text")); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(menuItemRemoveButton)
                            .addComponent(menuItemassignButton)))
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(menuItemassignButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(menuItemRemoveButton))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void menuAssignButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAssignButtonActionPerformed
        menuOperation(1);
    }//GEN-LAST:event_menuAssignButtonActionPerformed

    private void menuRemoveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRemoveButtonActionPerformed
        menuOperation(0);
    }//GEN-LAST:event_menuRemoveButtonActionPerformed

    private void activeMenuListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_activeMenuListMouseClicked
        fillMenuItemList();
    }//GEN-LAST:event_activeMenuListMouseClicked

    private void activeMenuListMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_activeMenuListMouseReleased
        fillMenuItemList();
    }//GEN-LAST:event_activeMenuListMouseReleased

    private void activeMenuListKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_activeMenuListKeyReleased
        fillMenuItemList();
    }//GEN-LAST:event_activeMenuListKeyReleased

    private void menuItemRemoveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemRemoveButtonActionPerformed
        menuItemOperation(0);
    }//GEN-LAST:event_menuItemRemoveButtonActionPerformed

    private void menuItemassignButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemassignButtonActionPerformed
        menuItemOperation(1);
    }//GEN-LAST:event_menuItemassignButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList activeMenuItemList;
    private javax.swing.JList activeMenuList;
    private javax.swing.JList inactiveMenuItemList;
    private javax.swing.JList inactiveMenuList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton menuAssignButton;
    private javax.swing.JButton menuItemRemoveButton;
    private javax.swing.JButton menuItemassignButton;
    private javax.swing.JButton menuRemoveButton;
    // End of variables declaration//GEN-END:variables

    protected void onLoad() {
        initComponents();
        refresh();
    }

    private void refresh() {
        fillMenuList();
        fillMenuItemList();
//        mainView.menuRegister();
    }

    private void fillMenuList() {
        activeMenuList.setListData(Find.menuByStatus(1).toArray());
        inactiveMenuList.setListData(Find.menuByStatus(0).toArray());
    }

    private void fillMenuItemList() {
        Object o = activeMenuList.getSelectedValue();
        if (o == null) {
            activeMenuItemList.setListData(new Object[]{});
            inactiveMenuItemList.setListData(new Object[]{});
            return;
        }
        Menu menu = (Menu) o;
        menu = m.find(Menu.class, menu.getMenu());

        activeMenuItemList.setListData(Find.menuItemByMenuAndStatus(menu, 1).toArray());
        inactiveMenuItemList.setListData(Find.menuItemByMenuAndStatus(menu, 0).toArray());
    }

    private void menuOperation(int i) {
        Object o = i == 0 ? activeMenuList.getSelectedValue() : inactiveMenuList.getSelectedValue();
        if (o == null) {
            return;
        }
        Menu menu = (Menu) o;
        menu = m.find(Menu.class, menu.getMenu());
        menu.setStatus(i);
        m.update(menu);
        refresh();
    }

    private void menuItemOperation(int i) {
        Object o = i == 0 ? activeMenuItemList.getSelectedValue() : inactiveMenuItemList.getSelectedValue();
        if (o == null) {
            return;
        }
        MenuItem menuItem = (MenuItem) o;
        menuItem = m.find(MenuItem.class, menuItem.getMenuItemPK());
        menuItem.setStatus(i);
        m.update(menuItem);
        fillMenuItemList();
//        mainView.menuRegister();
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
}
