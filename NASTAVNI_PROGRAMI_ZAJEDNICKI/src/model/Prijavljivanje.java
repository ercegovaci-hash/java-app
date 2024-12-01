/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author ivana
 */
public class Prijavljivanje extends AbstractDomainObject {

    private int prijavljivanjeID;
    private Date datumPrijavljivanja;
    private double ukupnaCena;
    private Predavac predavac;
    private Student student;
    private ArrayList <Kurs> kurs;

    public Prijavljivanje() {
    }

    public Prijavljivanje(int prijavljivanjeID, Date datumPrijavljivanja, double ukupnaCena, Predavac predavac, Student student, ArrayList<Kurs> kurs) {
        this.prijavljivanjeID = prijavljivanjeID;
        this.datumPrijavljivanja = datumPrijavljivanja;
        this.ukupnaCena = ukupnaCena;
        this.predavac = predavac;
        this.student = student;
        this.kurs = kurs;
    }

    public int getPrijavljivanjeID() {
        return prijavljivanjeID;
    }

    public void setPrijavljivanjeID(int prijavljivanjeID) {
        this.prijavljivanjeID = prijavljivanjeID;
    }

    public Date getDatumPrijavljivanja() {
        return datumPrijavljivanja;
    }

    public void setDatumPrijavljivanja(Date datumPrijavljivanja) {
        this.datumPrijavljivanja = datumPrijavljivanja;
    }

    public double getUkupnaCena() {
        return ukupnaCena;
    }

    public void setUkupnaCena(double ukupnaCena) {
        this.ukupnaCena = ukupnaCena;
    }

    public Predavac getPredavac() {
        return predavac;
    }

    public void setPredavac(Predavac predavac) {
        this.predavac = predavac;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public ArrayList<Kurs> getKurs() {
        return kurs;
    }

    public void setKurs(ArrayList<Kurs> kurs) {
        this.kurs = kurs;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Prijavljivanje other = (Prijavljivanje) obj;
        if (this.prijavljivanjeID != other.prijavljivanjeID) {
            return false;
        }
        if (Double.doubleToLongBits(this.ukupnaCena) != Double.doubleToLongBits(other.ukupnaCena)) {
            return false;
        }
        if (!Objects.equals(this.datumPrijavljivanja, other.datumPrijavljivanja)) {
            return false;
        }
        if (!Objects.equals(this.predavac, other.predavac)) {
            return false;
        }
        if (!Objects.equals(this.student, other.student)) {
            return false;
        }
        return Objects.equals(this.kurs, other.kurs);
    }

   
    @Override
    public String nazivTabele() {
         return "prijavljivanje";
    }

    @Override
    public String alijas() {
        return "pr";
    }

    @Override
    public String join() {
        return  " JOIN STUDENT S ON (S.STUDENTID = PR.STUDENT) "
                + "JOIN PREDAVAC P ON (P.PREDAVACID = PR.PREDAVAC) ";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista= new ArrayList<>();
       
       while(rs.next()){
       
           Predavac p = new Predavac(rs.getInt("predavacID"), rs.getString("ime"), rs.getString("prezime"), rs.getString("username"),
                    rs.getString("password"));
           Student s = new Student(rs.getInt("studentID"),rs.getString("ime"), rs.getString("prezime"), rs.getString("email"));
           
           Prijavljivanje prijavljivanje = new Prijavljivanje(rs.getInt("prijavljivanjeID"), rs.getDate("datum"),
               rs.getDouble("ukupnaCena"), p, s, null);
           
        lista.add(prijavljivanje);
           
       }
       rs.close();
       return lista;
       
    }

    @Override
    public String koloneZaInsert() {
             return " (datum,ukupnaCena,predavac,student)";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return "prijavljivanjeID = "+ prijavljivanjeID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + new java.sql.Date(datumPrijavljivanja.getTime()) + "', "
                + " " + ukupnaCena + " ,  " + predavac.getPredavacID() + ", "
                + student.getStudentID();
    }

    @Override
    public String vrednostiZaUpdate() {
        return " datum = '" + new java.sql.Date(datumPrijavljivanja.getTime()) + "', "
                + "ukupnaCena = " + ukupnaCena + " ";
    }

    @Override
    public String uslov() {
        return "";
    }
    
}
