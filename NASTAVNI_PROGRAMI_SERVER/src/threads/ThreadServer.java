/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threads;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author ivana
 */
public class ThreadServer extends Thread {
    
    
    private ServerSocket serversocket;
    
    public ThreadServer(){
        
        try {
            serversocket= new ServerSocket(9000);
            System.out.println("Uhvacen serverski soket...");
        } catch (IOException ex) {
            Logger.getLogger(ThreadServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void run() {
        try {
            while(!serversocket.isClosed()){
            System.out.println("Cekanje klijenta...");
            Socket socket= serversocket.accept();
            System.out.println("Klijent se povezao..");
            ThreadClient th= new ThreadClient(socket);
            th.start();
                
            }
            
        } catch (Exception ex) {
            System.out.println("STIGLI SMO DO SERVERSKE NITI");
            Logger.getLogger(ThreadServer.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        
        
    }

    public ServerSocket getServersocket() {
        return serversocket;
    }

    public void setServersocket(ServerSocket serversocket) {
        this.serversocket = serversocket;
    }
    
    
    
    
    
}
