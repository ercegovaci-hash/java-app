/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author ivana
 */
public class Predavac extends AbstractDomainObject  {

    private int predavacID;
    private String ime;
    private String prezime;
    private String username;
    private String password;

    public Predavac() {
    }

    public Predavac(int predavacID, String ime, String prezime, String username, String password) {
        this.predavacID = predavacID;
        this.ime = ime;
        this.prezime = prezime;
        this.username = username;
        this.password = password;
    }

    
    
    public int getPredavacID() {
        return predavacID;
    }

    public void setPredavacID(int predavacID) {
        this.predavacID = predavacID;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Predavac other = (Predavac) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return Objects.equals(this.password, other.password);
    }

    

    @Override
    public String toString() {
        return ime + " " + prezime;
    }
    
    
    
    
    @Override
    public String nazivTabele() {
        return "predavac";
    }

    @Override
    public String alijas() {
        return "p";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();
        
        while(rs.next()){
            
            Predavac predavac = new Predavac(rs.getInt("predavacID"), rs.getString("ime"), rs.getString("prezime"), rs.getString("username"),rs.getString("password"));
                   
            lista.add(predavac);
            
        }
        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return "(Ime,Prezime,Username,Password)";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return "predavacID = " + predavacID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + ime + "', '" + prezime + "', "
                + "'" + username + "', '" + password + "'";
    }

    @Override
    public String vrednostiZaUpdate() {
         return " Ime = '" + ime + "', Prezime = '" + prezime + "', "
                + "Username = '" + username + "', Password = '" + password + "' ";
    }

    @Override
    public String uslov() {
          return "";
    }
    
}
