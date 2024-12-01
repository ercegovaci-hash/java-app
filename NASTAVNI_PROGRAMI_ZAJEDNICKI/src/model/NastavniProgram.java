/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ivana
 */
public class NastavniProgram extends AbstractDomainObject  {
    private int programID;
    private String naziv;
    private String semestar;
   

    public NastavniProgram() {
    }

    public NastavniProgram(int programID, String naziv, String semestar) {
        this.programID = programID;
        this.naziv = naziv;
        this.semestar = semestar;
      
    }

    public int getProgramID() {
        return programID;
    }

    public void setProgramID(int programID) {
        this.programID = programID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getTrajanje() {
        return semestar;
    }

    public void setTrajanje(String semestar) {
        this.semestar = semestar;
    }

 
    

    @Override
    public String toString() {
        return  naziv;
    }

    @Override
    public String nazivTabele() {
         return "programi";
    }

    @Override
    public String alijas() {
         return "np";
    }

    @Override
    public String join() {
          return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
         ArrayList<AbstractDomainObject>  lista = new ArrayList<>();
        
        while(rs.next()){
            
            NastavniProgram np= new NastavniProgram(rs.getInt("programID"), rs.getString("naziv"), rs.getString("semestar"));
            
            lista.add(np);
            
            
        }
        
        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
         return "";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return "ProgramID:"+ programID; 
    }

    @Override
    public String vrednostiZaInsert() {
          return "";
    }

    @Override
    public String vrednostiZaUpdate() {
          return "";
    }

    @Override
    public String uslov() {
          return "";
    }
    
    
}
