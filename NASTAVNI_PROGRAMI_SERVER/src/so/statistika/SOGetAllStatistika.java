/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.statistika;

import baza.DBBroker;
import model.AbstractDomainObject;
import model.Statistika;
import model.NastavniProgram;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author ivana
 */
public class SOGetAllStatistika extends AbstractSO {
    
     ArrayList<Statistika> listaStatistika;
    
    
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        
        if (!(ado instanceof Statistika)) {
            throw new Exception("Prosledjeni objekat nije instanca klase statistika!");
        }
        
        
        
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        
        ArrayList<AbstractDomainObject> statistika = DBBroker.getInstance().select(ado);
        listaStatistika= ( ArrayList<Statistika>)(ArrayList<?>) statistika;
        
        
    }

    public ArrayList<Statistika> getListaStatistika() {
        return listaStatistika;
    }


 
    
    
    
    
}
