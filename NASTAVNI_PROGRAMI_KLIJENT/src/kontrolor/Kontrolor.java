/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontrolor;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static java.lang.System.out;
import java.net.SocketException;
import java.util.ArrayList;
import model.Kurs;
import model.NastavniProgram;
import model.Predavac;
import model.Prijavljivanje;
import model.Statistika;
import model.Student;
import session.Session;
import transfer.KlijentskiZahtev;
import transfer.Operacije;
import transfer.ServerskiOdgovor;
import transfer.StatusOdgovora;

/**
 *
 * @author ivana
 */
public class Kontrolor {
    
    private static Kontrolor instance;
    
    private Kontrolor (){
        
    }
    
    public static Kontrolor getInstance(){
        if(instance==null){
            instance=new Kontrolor();
        }
        return instance;
    }
    
    private Object sendRequest(Object parametar,Operacije operacija) throws Exception {
    try{
        
        KlijentskiZahtev zahtev = new KlijentskiZahtev(parametar, operacija);

        ObjectOutputStream out = new ObjectOutputStream(Session.getInstance().getSocket().getOutputStream());
        out.writeObject(zahtev);

        ObjectInputStream in = new ObjectInputStream(Session.getInstance().getSocket().getInputStream());
        ServerskiOdgovor odgovor = (ServerskiOdgovor) in.readObject();

        if (odgovor.getStatusOdgovora().equals(StatusOdgovora.Neuspesno)) {
            throw odgovor.getException();
        } else {
            return odgovor.getRezultat();
        }
        
        } catch (SocketException ex) {
           throw new Exception("Veza sa serverom je prekinuta.", ex);
        }
        
}

    public Predavac login(Predavac p) throws Exception {
       return  (Predavac) sendRequest(p, Operacije.LOGIN);
    }

    public ArrayList<Student> getAllStudents() throws Exception {
       return (ArrayList<Student>) sendRequest(null, Operacije.GET_ALL_STUDENTS);
    }

    public void addNewStudent(Student s) throws Exception {
        sendRequest(s, Operacije.ADD_NEW_STUDENT);
    }

    public void deleteStudent(Student s) throws Exception {
        sendRequest(s, Operacije.DELETE_STUDENT);
    }

    public void updateStudent(Student s) throws Exception {
        sendRequest(s, Operacije.UPDATE_STUDENT);
    }

    public ArrayList<NastavniProgram> getAllNastavniPrograms() throws Exception {
        return (ArrayList<NastavniProgram>) sendRequest(null, Operacije.GET_ALL_PROGRAMI);
    }

    public ArrayList<Kurs> getAllKursevi(Prijavljivanje p) throws Exception {
        return (ArrayList<Kurs>) sendRequest(p, Operacije.GET_ALL_KURS);
    }

    public void addNewPrijavljivanje(Prijavljivanje prijavljivanje) throws Exception {
        sendRequest(prijavljivanje, Operacije.ADD_NEW_PRIJAVLJIVANJE);
    }

    public ArrayList<Prijavljivanje> getAllPrijavljivanje() throws Exception {
       return (ArrayList<Prijavljivanje>) sendRequest(null, Operacije.GET_ALL_PRIJAVLJIVANJE);
    }

    public void updatePrijavljivanje(Prijavljivanje prijavljivanje) throws Exception {
        sendRequest(prijavljivanje, Operacije.UPDATE_PRIJAVLJIIVANJE);
    }

    public void deletePrijavljivanje(Prijavljivanje prijavljivanje) throws Exception {
        sendRequest(prijavljivanje,Operacije.DELETE_PRIJAVLJIVANJE);
    }

    public ArrayList<Statistika> getAllStatistika() throws Exception {
       return (ArrayList<Statistika>) sendRequest(null, Operacije.GET_ALL_STATISTIKA); 
    }

    public void logout(Predavac p) throws Exception {
        sendRequest(p, Operacije.LOGOUT);
    }

    public ArrayList<Kurs> getAllKursevi() throws Exception {
        return (ArrayList<Kurs>) sendRequest(null, Operacije.GET_ALL_KURSEVI);
    }
}
