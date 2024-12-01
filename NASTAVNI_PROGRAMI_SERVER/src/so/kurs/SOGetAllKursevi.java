/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.kurs;

import baza.DBBroker;
import model.AbstractDomainObject;
import model.Kurs;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author ivana
 */
public class SOGetAllKursevi extends AbstractSO {

    private ArrayList<Kurs> lista;
    
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
       if (!(ado instanceof Kurs)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Kurs!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        
        ArrayList<AbstractDomainObject> kursevi = DBBroker.getInstance().select(ado);
        lista = (ArrayList<Kurs>) (ArrayList<?>) kursevi;
        
    }

    public ArrayList<Kurs> getLista() {
        return lista;
    }

    public ArrayList<Kurs> getListaKurseva() {
         return lista;

    }
    
    
    
    
    
    
    
}
