/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package session;

import model.Predavac;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author ivana
 */
public class Session {
    
    private static Session instance;
    private Socket socket;
    private Predavac ulogovani;
  

    private Session() {
        try {
            socket = new Socket("localhost", 9000);
            System.out.println("Session: Konekcija uspesno uspostavljena");
        } catch (IOException ex) {
            System.out.println("Greska pri uspostavljanju konekcije..."+ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static Session getInstance() {
        if (instance == null) {
            instance = new Session();
        }
        return instance;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setUlogovani(Predavac ulogovani) {
        this.ulogovani = ulogovani;
    }

    public Predavac getUlogovani() {
        return ulogovani;
    }

}
    
    
    

