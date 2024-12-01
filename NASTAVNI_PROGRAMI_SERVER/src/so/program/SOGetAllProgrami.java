/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.program;

import baza.DBBroker;
import model.AbstractDomainObject;
import model.NastavniProgram;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author ivana
 * 
 */
public class SOGetAllProgrami extends AbstractSO {

    ArrayList<NastavniProgram> listaPrograma;
    
    
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        
        if (!(ado instanceof NastavniProgram)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Nastavni Program!");
        }
        
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        
        ArrayList<AbstractDomainObject> programi = DBBroker.getInstance().select(ado);
        listaPrograma= ( ArrayList<NastavniProgram>)(ArrayList<?>) programi;
        
    }

    public ArrayList<NastavniProgram> getListaPrograma() {
        return listaPrograma;
    }
    
    
    
    
    
    
}
