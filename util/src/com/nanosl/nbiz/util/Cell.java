/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.util;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Thilina
 */
public interface Cell {

    public DefaultTableCellRenderer rightAlignCell = new DefaultTableCellRenderer() {
        private final DefaultTableCellRenderer DEFAULT_RENDERER = new DefaultTableCellRenderer();

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = DEFAULT_RENDERER.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            DEFAULT_RENDERER.setHorizontalAlignment(javax.swing.JLabel.RIGHT);

            if (isSelected) {
                c.setForeground(Color.WHITE);
                c.setBackground(Color.BLACK);
//                c.setForeground(row % 2 == 0 ? Color.BLACK : Color.BLUE);
            } else {
                c.setForeground(Color.BLACK);
                if (row % 2 == 0) {
                    c.setBackground(Color.WHITE);
                } else {
                    c.setBackground(new Color(200, 230, 250));
                }
            }
            return c;
        }
    };
    public DefaultTableCellRenderer coloredCellRenderer = new DefaultTableCellRenderer() {
        private DefaultTableCellRenderer DEFAULT_RENDERER = new DefaultTableCellRenderer();

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = DEFAULT_RENDERER.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            if (isSelected) {
                c.setForeground(Color.WHITE);
                c.setBackground(Color.BLACK);
//                c.setForeground(row % 2 == 0 ? Color.BLACK : Color.BLUE);
            } else {
                c.setForeground(Color.BLACK);
                if (row % 2 == 0) {
                    c.setBackground(Color.WHITE);
                } else {
                    c.setBackground(new Color(200, 230, 250));
                }
            }
            return c;
        }
    };
}
