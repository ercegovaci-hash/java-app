/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author ivana
 */
public class Student extends AbstractDomainObject {

    private int studentID;
    private String ime;
    private String prezime;
    private String email;

    public Student() {
    }

    public Student(int studentID, String ime, String prezime, String email) {
        this.studentID = studentID;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        final Student other = (Student) obj;
        if (this.studentID != other.studentID) {
            return false;
        }
        if (!Objects.equals(this.ime, other.ime)) {
            return false;
        }
        if (!Objects.equals(this.prezime, other.prezime)) {
            return false;
        }
        return Objects.equals(this.email, other.email);
    }

    @Override
    public String toString() {
        return ime+ " " +prezime ;
    }
    
    
    @Override
    public String nazivTabele() {
        return "student";
    }

    @Override
    public String alijas() {
        return "s";
    }

    @Override
    public String join() {
         return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista= new ArrayList<>();
        
        while(rs.next()){
            
            Student student = new Student(rs.getInt("studentID"),rs.getString("ime"), rs.getString("prezime"), rs.getString("email"));
            
            lista.add(student);
            
        }
        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
         return " (ime, prezime, email) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return "studentID = " + studentID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + ime + "', '" + prezime + "', " + "'" + email +"'";
    }

    @Override
    public String vrednostiZaUpdate() {
        return " ime = '" + ime + "', "
                + "prezime = '" + prezime + "', " + "email = '" + email + "' ";
    }

    @Override
    public String uslov() {
         return "";
    }
    
}
