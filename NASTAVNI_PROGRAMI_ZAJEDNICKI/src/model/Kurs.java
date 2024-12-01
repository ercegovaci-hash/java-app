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
public class Kurs extends AbstractDomainObject  {
    
    private int RbrStavke;
    private int brojESPB;
    private double cenaESPB;
    private NastavniProgram nastavniProgram;
    private Prijavljivanje prijavljivanje;
    
    public Kurs() {
    }

    public Kurs(int RbrStavke, int brojESPB, double cenaESPB, NastavniProgram nastavniProgram, Prijavljivanje prijavljivanje) {
        this.RbrStavke = RbrStavke;
        this.brojESPB = brojESPB;
        this.cenaESPB = cenaESPB;
        this.nastavniProgram = nastavniProgram;
        this.prijavljivanje = prijavljivanje;
    }


    public Prijavljivanje getPrijavljivanje() {
        return prijavljivanje;
    }

    public void setPrijavljivanje(Prijavljivanje prijavljivanje) {
        this.prijavljivanje = prijavljivanje;
    }

    public int getRbrStavke() {
        return RbrStavke;
    }

    public void setRbrStavke(int RbrStavke) {
        this.RbrStavke = RbrStavke;
    }

   
    
    public int getBrojESPB() {
        return brojESPB;
    }

    public void setBrojESPB(int brojESPB) {
        this.brojESPB = brojESPB;
    }

    public double getCenaESPB() {
        return cenaESPB;
    }

    public void setCenaESPB(double cenaESPB) {
        this.cenaESPB = cenaESPB;
    }

    public NastavniProgram getNastavniProgram() {
        return nastavniProgram;
    }

    public void setNastavniProgram(NastavniProgram nastavniProgram) {
        this.nastavniProgram = nastavniProgram;
    }

     
    
    @Override
    public String nazivTabele() {
        return "stavka_prijavljivanja";
    }

    @Override
    public String alijas() {
        return "k";
    }

    @Override
    public String join() {
         return "JOIN PRIJAVLJIVANJE PR ON K.prijavljivanje = PR.prijavljivanjeID "
                 + "JOIN STUDENT S ON S.STUDENTID = PR.STUDENT "
                 + "JOIN PREDAVAC P ON P.PREDAVACID=PR.PREDAVAC "
                 + "JOIN PROGRAMI PRO ON PRO.PROGRAMID=K.PROGRAM";

    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        
        ArrayList<AbstractDomainObject>  lista = new ArrayList<>();
        
        while(rs.next()){
            
            Predavac p = new Predavac(rs.getInt("predavacID"), rs.getString("ime"), rs.getString("prezime"), rs.getString("username"),
                    rs.getString("password"));
            Student s = new Student(rs.getInt("studentID"),rs.getString("ime"), rs.getString("prezime"), rs.getString("email"));
           
            Prijavljivanje prijavljivanje = new Prijavljivanje(rs.getInt("prijavljivanjeID"), rs.getDate("datum"),
               rs.getDouble("ukupnaCena"), p, s, null);
            
            NastavniProgram np= new NastavniProgram(rs.getInt("program"),rs.getString("naziv"),rs.getString("semestar"));
            
            Kurs k= new Kurs(rs.getInt("RbrStavke"), rs.getInt("brojESPB"), 
                    rs.getInt("cenaESPB"), np, prijavljivanje);
            
            lista.add(k);
        }
        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
         return "(RbrStavke, brojESPB, cenaESPB, program, prijavljivanje)";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return "prijavljivanje = " + prijavljivanje.getPrijavljivanjeID();
    }

    @Override
    public String vrednostiZaInsert() {
        return " " + RbrStavke + " , " + brojESPB + " ,  " + cenaESPB + " , " + nastavniProgram.getProgramID()+ " , " + prijavljivanje.getPrijavljivanjeID();
    }

    @Override
    public String vrednostiZaUpdate() {
         return "";
    }

    @Override
    public String uslov() {
         return " WHERE PR.PRIJAVLJIVANJEID = " + prijavljivanje.getPrijavljivanjeID();
    }
    
}
