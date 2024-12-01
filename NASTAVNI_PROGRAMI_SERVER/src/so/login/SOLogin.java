/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.login;

import java.sql.*;
import baza.DBBroker;
import model.AbstractDomainObject;
import model.Predavac;
import java.util.ArrayList;
import so.AbstractSO;
import controller.ServerController;


/**
 *
 * @author ivana
 */
public class SOLogin extends AbstractSO {
    Predavac ulogovani;
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Predavac)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Predavac!");
        }
        
        Predavac p = (Predavac) ado;
        
        for(Predavac predavac: ServerController.getInstance().getListaPrijavljenihPredavaca()){
            
            if(p.getUsername().equals(predavac.getUsername()) || p.getPassword().equals(predavac.getPassword())){
                throw new Exception("Vec postoji ulogovan predavac sa tim kredencijalima!");
            }
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
       
        Predavac p = (Predavac) ado;
        ArrayList<Predavac> predavaci = (ArrayList<Predavac>) (ArrayList<?>)DBBroker.getInstance().select(ado);
        
        for (Predavac predavac : predavaci) {
            if(predavac.getUsername().equals(p.getUsername()) 
                    && predavac.getPassword().equals(p.getPassword())){
                ulogovani=predavac;
                ServerController.getInstance().getListaPrijavljenihPredavaca().add(p);
                return;
            }
        }
        
        System.out.println("Ne postoji predavac sa tim kredencijalima");
        throw new Exception("Ne postoji predavac sa tim kredencijalima.");
        
    }

    public Predavac getUlogovani() {
        return ulogovani;
    }

    
}
