/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table.model;

import kontrolor.Kontrolor;
import model.Prijavljivanje;
import model.Kurs;
import model.NastavniProgram;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ivana
 */
public class TableModelKursevi extends AbstractTableModel {

    private ArrayList<Kurs> lista;
    private String[] kolone = {"RbrStavke", "Nastavni program","Trajanje programa", "Broj ESPB", "Cena ESPB"};
    private int rBr = 0;

    public TableModelKursevi() {
        lista = new ArrayList<>();
    }

    public TableModelKursevi(Prijavljivanje p) {
        try {
            lista = Kontrolor.getInstance().getAllKursevi(p);
        } catch (Exception ex) {
            Logger.getLogger(TableModelKursevi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int p) {
        return kolone[p];
    }

    @Override
    public Object getValueAt(int row, int column) {
        Kurs k = lista.get(row);

        switch (column) {
            case 0:
                return k.getRbrStavke();
            case 1:
                return k.getNastavniProgram().getNaziv();
            case 2:
                return k.getNastavniProgram().getTrajanje();
            case 3:
                return k.getBrojESPB();
            case 4:
                return k.getCenaESPB();
            case 5:
                return k.getNastavniProgram();
           

            default:
                return null;
        }
    }

  

    public void obrisiKurs(int row) {
        lista.remove(row);

        rBr = 0;
        for (Kurs kurs : lista) {
            kurs.setRbrStavke(++rBr);
        }

        fireTableDataChanged();
    }

    public double vratiUkupnuCenu() {
        double ukupnaCena = 0;
        for (Kurs kurs : lista) {
            ukupnaCena += (kurs.getBrojESPB()*kurs.getCenaESPB());
        }

        return ukupnaCena;
    }

    public ArrayList<Kurs> getLista() {
        return lista;
    }

    public void dodajKurs(Kurs k) {
        rBr = lista.size();
        k.setRbrStavke(++rBr);
        lista.add(k);
        fireTableDataChanged();
    }
    
    
    
    
    
}
