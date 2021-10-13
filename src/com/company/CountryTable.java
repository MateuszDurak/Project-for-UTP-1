package com.company;

import javax.swing.*;
import java.io.*;
import java.util.*;

public class CountryTable {
    public CountryTable(String countriesFileName) {
    }


    public JTable create() throws IOException {

        Scanner scanner = new Scanner(new File("data/countries1.txt"));
        String pierwszyWiersz = scanner.nextLine();
        String[] kolNazwa = pierwszyWiersz.split("\\t");
        scanner.useDelimiter("[\\t]");
        NewTableModel tabelaModel = new NewTableModel();
        JTable tabela = new JTable(tabelaModel);

        for (int i = 0; i < kolNazwa.length; i++) {
            tabelaModel.addColumn(kolNazwa[i]);
        }
        Object[]dane = new Object[kolNazwa.length];
        int a = 0;
        while(scanner.hasNext()) {
            dane[a] = scanner.next();
            a++;
            if (a == kolNazwa.length) {
                tabelaModel.addRow(dane);
               dane = new Object[kolNazwa.length];
               a=0;
            }
        }
        tabela.setRowHeight(40);
        tabela.setDefaultRenderer(Integer.class, new ColorCellRenderer());
        scanner.close();
        Scanner flagi = new Scanner(new File("data/countries1.txt"));
        flagi.nextLine();
        flagi.useDelimiter("[\\t]");
        int j = 0;
        while(flagi.hasNext()) {
            System.out.println(flagi.next());
            System.out.println(flagi.next());
            System.out.println(flagi.next());

                tabela.setValueAt(dodajFlage(flagi.next()),j,3);
                j++;
        }
        flagi.close();
        return tabela;
    }
    public ImageIcon dodajFlage(String kod){
        String sciezka = "data/Flagi/"+kod.toLowerCase()+".png";
        System.out.println(sciezka);
        ImageIcon flaga = new ImageIcon(sciezka);
        return flaga;
    }
}
