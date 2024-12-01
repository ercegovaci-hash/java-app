/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table.model;

import kontrolor.Kontrolor;

import model.Statistika;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ivana
 */
public class TableModelStatistika extends AbstractTableModel {

   private ArrayList<Statistika> lista;
    private String[] kolone = {"ID", "Ocena", "Student", "Kurs"};
   

    public TableModelStatistika() {
        try {
            lista = Kontrolor.getInstance().getAllStatistika();
        } catch (Exception ex) {
            Logger.getLogger(TableModelStudenti.class.getName()).log(Level.SEVERE, null, ex);
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
    public String getColumnName(int i) {
        return kolone[i];
    }

    @Override
    public Object getValueAt(int row, int column) {
        Statistika s = lista.get(row);

        switch (column) {
            case 0:
                return s.getStatistikaID();
            case 1:
                return s.getOcena();
            case 2:
                return s.getStudent().getIme() + " " + s.getStudent().getPrezime();
            case 3:
                return s.getProgram().getNaziv();

            default:
                return null;
        }
    }



    
    }

    
    
    
    
    
    

