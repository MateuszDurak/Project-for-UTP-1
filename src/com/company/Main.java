/**
 *
 *  @author Durak Mateusz S21415
 *
 */

package com.company;


import javax.swing.*;

public class Main {

    private JTable ctab;

    public void createTable(String countriesFileName) throws Exception {
        ctab = new CountryTable(countriesFileName).create();
    }

    public void showGui() {
        SwingUtilities.invokeLater( new Runnable() {
            public void run() {
                JFrame f = new JFrame("Countries table");
                f.add( new JScrollPane(ctab) );
                f.pack();
                f.setLocationRelativeTo(null);
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setVisible(true);
            }
        });
    }

    public static void main(String[] args)  {
        Main main = new Main();
        try {
            main.createTable("C:\\Users\\Lenovo\\Desktop\\Pjatk\\UTP\\UTP1\\data\\countries.txt");
            main.showGui();
        } catch(Exception exc) {
            JOptionPane.showMessageDialog(null, "Table creation failed, " + exc);
        }
    }
}

