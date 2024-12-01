/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table.model;

import kontrolor.Kontrolor;
import model.Prijavljivanje;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ivana
 */
public class TableModelPrijavljivanje extends AbstractTableModel implements Runnable {

    private ArrayList <Prijavljivanje> lista;
    private String [] kolone= {"ID", "datum","ukupna cena" , "student"};
    private String parametar="";
    
    public TableModelPrijavljivanje(){
        
        try {
            lista=Kontrolor.getInstance().getAllPrijavljivanje();
        } catch (Exception ex) {
            Logger.getLogger(TableModelPrijavljivanje.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public String getColumnName(int p) {
        return kolone[p];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       Prijavljivanje p = lista.get(rowIndex);
       SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
       
        switch (columnIndex) {
            case 0:
              return  p.getPrijavljivanjeID();
            case 1:
                return sdf.format(p.getDatumPrijavljivanja());
            case 2:
                return p.getUkupnaCena();
            case 3:
                return p.getStudent();
            default:
                throw new AssertionError();
        }
       
    }

    public Prijavljivanje getSelectedPrijavljivanje(int row) {
        return lista.get(row);
    }

    public ArrayList<Prijavljivanje> getLista() {
        return lista;
    }

    public void setParametar(String parametar) {
        this.parametar=parametar;
        refreshTable();
    }

    public void refreshTable() {
       
        try {
            lista= Kontrolor.getInstance().getAllPrijavljivanje();
            if(!parametar.equals("")){
                
                ArrayList<Prijavljivanje> novaLista = new ArrayList<>();
                for (Prijavljivanje prijavljivanje : lista) {
                    if(prijavljivanje.getStudent().getIme().contains(parametar)|| prijavljivanje.getStudent().getPrezime().contains(parametar)){
                        
                        novaLista.add(prijavljivanje);
                        
                    }
                }
                
                lista=novaLista;
                
            }
            
            fireTableDataChanged();
            
        } catch (Exception ex) {            
            Logger.getLogger(TableModelPrijavljivanje.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
 
    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Thread.sleep(10000);
                refreshTable();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(TableModelPrijavljivanje.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
}
