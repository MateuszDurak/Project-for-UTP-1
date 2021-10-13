package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class ColorCellRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
       super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
       if (Integer.parseInt(value.toString()) > 20000) {
                setForeground(Color.RED);
            }
            else
                setForeground(Color.BLACK);
            return this;
    }

}
