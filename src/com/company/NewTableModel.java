package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class NewTableModel extends DefaultTableModel {

    @Override
    public Class getColumnClass(int columnIndex) {
        if(columnIndex== 2) {
            return Integer.class;
        }
        if(columnIndex ==3){
            return ImageIcon.class;
        }
        else
            return String.class;
    }
}
