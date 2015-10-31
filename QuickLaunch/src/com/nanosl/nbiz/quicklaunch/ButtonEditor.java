/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.quicklaunch;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;

/**
 * @version 1.0 11/09/98
 */
public class ButtonEditor extends DefaultCellEditor {

    protected JButton button;
    private String label;
    private boolean isPushed;

    public ButtonEditor(JCheckBox checkBox) {
        super(checkBox);
//        button = new JButton();
//        button.setOpaque(true);
//        button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                fireEditingStopped();
//            }
//        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
        button = (JButton) value;
        if (isSelected) {
            button.setForeground(table.getSelectionForeground());
            button.setBackground(table.getSelectionBackground());
        } else {
            button.setForeground(table.getForeground());
            button.setBackground(table.getBackground());
        }
//        label = (value == null) ? "" : value.toString();
//        button.setText(label);
        label = button.getText();
        isPushed = true;
        return button;
    }

    @Override
    public Object getCellEditorValue() {
//        if (isPushed) {
//            //
//            //
//            JOptionPane.showMessageDialog(button, label + ": Ouch!");
//            // System.out.println(label + ": Ouch!");
//        }
        isPushed = false;
        return button;
    }

    @Override
    public boolean stopCellEditing() {
        isPushed = false;
        return super.stopCellEditing();
    }

    @Override
    protected void fireEditingStopped() {
        super.fireEditingStopped();
    }
}
