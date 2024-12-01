/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threads;

import controller.ServerController;
import model.Prijavljivanje;
import model.Student;
import model.Predavac;
import model.NastavniProgram;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import transfer.ServerskiOdgovor;
import transfer.KlijentskiZahtev;
import static transfer.Operacije.GET_ALL_KURS;
import transfer.StatusOdgovora;

/**
 *
 * @author ivana
 */
public class ThreadClient extends Thread {
    
    private Socket socket;
    
    
    ThreadClient (Socket socket) {
        
        this.socket=socket;
        
    }

    @Override
    public void run() {
        
        while(!socket.isClosed()){
            
            try {            
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                KlijentskiZahtev zahtev= (KlijentskiZahtev) in.readObject();
                ServerskiOdgovor odgovor = handleKlijentskiZahtev(zahtev);
                System.out.println("SERVERSKI ODGOVOR: "+odgovor.getRezultat());
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                out.writeObject(odgovor);
                
                
            } catch (IOException ex) {
                Logger.getLogger(ThreadClient.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ThreadClient.class.getName()).log(Level.SEVERE, null, ex);
            }
            
                       
        }
            }

    private ServerskiOdgovor handleKlijentskiZahtev(KlijentskiZahtev zahtev) {
        
        ServerskiOdgovor odgovor = new ServerskiOdgovor(null, null,StatusOdgovora.Uspesno);
        try{
        switch(zahtev.getOperacija()){
            
            case LOGIN:
                Predavac predavac= (Predavac) zahtev.getParametar();
                Predavac ulogovani= ServerController.getInstance().login(predavac);
                odgovor.setRezultat(ulogovani);
                System.out.println("stiglo je do ovde");
                break;    
               case GET_ALL_STUDENTS:
                odgovor.setRezultat(ServerController.getInstance().getAllStudent());
                break;
            case ADD_NEW_STUDENT:
                Student student = (Student) zahtev.getParametar();
                ServerController.getInstance().addNewStudent(student);
                break;
            case DELETE_STUDENT:
                Student studentB = (Student) zahtev.getParametar();
                ServerController.getInstance().deleteStudent(studentB);
                break;
            case UPDATE_STUDENT:
                Student studentU = (Student) zahtev.getParametar();
                ServerController.getInstance().updateStudent(studentU);
                break;
            case GET_ALL_PROGRAMI:
                odgovor.setRezultat(ServerController.getInstance().getAllProgrami());
                break;
            case GET_ALL_KURS:
                odgovor.setRezultat(ServerController.getInstance().getAllKurs((Prijavljivanje)zahtev.getParametar()));
                break;
            case GET_ALL_KURSEVI:
                odgovor.setRezultat(ServerController.getInstance().getAllKursevi());
                break;
            case ADD_NEW_PRIJAVLJIVANJE:
                Prijavljivanje i= (Prijavljivanje) zahtev.getParametar();
                ServerController.getInstance().addNewPrijavljivanje(i);
                break;
            case GET_ALL_PRIJAVLJIVANJE:
                odgovor.setRezultat(ServerController.getInstance().getAllPrijavljivanje());
                break;
            case UPDATE_PRIJAVLJIIVANJE:
                Prijavljivanje pr = (Prijavljivanje) zahtev.getParametar();
                ServerController.getInstance().updatePrijavljivanje(pr);
                break;
            case DELETE_PRIJAVLJIVANJE:
                Prijavljivanje prBr= (Prijavljivanje) zahtev.getParametar();
                ServerController.getInstance().deletePrijavljivanje(prBr);
                break;
            case GET_ALL_STATISTIKA:
                odgovor.setRezultat(ServerController.getInstance().getAllStatistika());
                break;
            case LOGOUT:
                 Predavac predavaclog= (Predavac) zahtev.getParametar();
                ServerController.getInstance().logout(predavaclog);
                 break;
            default:
                return null;
            
            }
        
        }
        
        catch(EOFException eof){
            System.out.println("eof excepetion");
        }
        
        catch (Exception e) {
            odgovor.setStatusOdgovora(StatusOdgovora.Neuspesno);
            odgovor.setException(e);
        }
        
        
        return odgovor;
    }
    
    
    
    
}
