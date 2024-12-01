/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.prijavljivanje;

import baza.DBBroker;
import model.AbstractDomainObject;
import model.Prijavljivanje;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author ivana
 */
public class SOGetAllPrijavljivanje extends AbstractSO {
    
   private  ArrayList<Prijavljivanje> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
       if (!(ado instanceof Prijavljivanje)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Prijavljivanje!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        
         ArrayList <AbstractDomainObject> listaPrijavljivanja= DBBroker.getInstance().select(ado);
         lista= (ArrayList<Prijavljivanje>) (ArrayList<?>) listaPrijavljivanja;
    }

    public ArrayList<Prijavljivanje> getLista() {
        return lista;
    }
    
    
}
