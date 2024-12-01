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
public class Statistika extends AbstractDomainObject {
    
    private int statistikaID;
    private int ocena;
    private NastavniProgram program;
    private Student student;

    public Statistika() {
    }

    public Statistika(int statistikaID, int ocena, NastavniProgram program, Student student) {
        this.statistikaID = statistikaID;
        this.ocena = ocena;
        this.program = program;
        this.student = student;
    }

   
    public int getStatistikaID() {
        return statistikaID;
    }

    public void setStatistikaID(int statistikaID) {
        this.statistikaID = statistikaID;
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }

    public NastavniProgram getProgram() {
        return program;
    }

    public void setProgram(NastavniProgram program) {
        this.program = program;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Statistika{" + "statistikaID=" + statistikaID + ", ocena=" + ocena + ", program=" + program + ", student=" + student + '}';
    }
     
    @Override
    public String nazivTabele() {
        return "statistika";
    }

    @Override
    public String alijas() {
        return "st";
    }

    @Override
    public String join() {
        return " JOIN STUDENT S ON (S.STUDENTID = ST.STUDENT) "
                + "JOIN PROGRAMI NP ON (NP.PROGRAMID = ST.PROGRAM) ";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
       
        ArrayList<AbstractDomainObject> lista= new ArrayList<>();
       
       while(rs.next()){
       
           NastavniProgram np= new NastavniProgram(rs.getInt("programID"), rs.getString("naziv"), rs.getString("semestar"));
           Student s = new Student(rs.getInt("studentID"),rs.getString("ime"), rs.getString("prezime"), rs.getString("email"));
           
           Statistika statistika= new Statistika(rs.getInt("statistikaID"), rs.getInt("ocena"), np, s);
           
        lista.add(statistika);
           
           
       }
       rs.close();
       return lista;

    }

    @Override
    public String koloneZaInsert() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return "statistikaID = "+ statistikaID;
    }

    @Override
    public String vrednostiZaInsert() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vrednostiZaUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String uslov() {
        return "";
    }
    
}
