/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table.model;

import kontrolor.Kontrolor;
import model.Student;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ivana
 */
public class TableModelStudenti extends AbstractTableModel implements Runnable {
    
    
    private ArrayList<Student> lista;
    private String[] kolone = {"ID", "Ime", "Prezime", "Email"};
    private String parametar = "";

    public TableModelStudenti() {
        try {
            lista = Kontrolor.getInstance().getAllStudents();
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
        Student s = lista.get(row);

        switch (column) {
            case 0:
                return s.getStudentID();
            case 1:
                return s.getIme();
            case 2:
                return s.getPrezime();
            case 3:
                return s.getEmail();

            default:
                return null;
        }
    }

    public Student getSelectedKorisnik(int row) {
        return lista.get(row);
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Thread.sleep(10000); //na svakih 10 sekundi
                refreshTable();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(TableModelStudenti.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setParametar(String parametar) {
        this.parametar = parametar;
        refreshTable();
    }

    public void refreshTable() {
        try {
            lista = Kontrolor.getInstance().getAllStudents();
            if (!parametar.equals("")) {
                ArrayList<Student> novaLista = new ArrayList<>();
                for (Student s : lista) {
                    if (s.getIme().toLowerCase().contains(parametar.toLowerCase())
                            || s.getPrezime().toLowerCase().contains(parametar.toLowerCase())) {
                        novaLista.add(s);
                    }
                }
                lista = novaLista;
            }

            fireTableDataChanged();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    
    
    
    
    
}
