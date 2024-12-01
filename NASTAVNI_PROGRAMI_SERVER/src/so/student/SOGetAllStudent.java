/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.student;

import baza.DBBroker;
import model.AbstractDomainObject;
import model.Student;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author ivana
 * 
 */
public class SOGetAllStudent extends AbstractSO {

    
   private ArrayList <Student> listaStudenata;
    
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
       if (!(ado instanceof Student)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Student!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        
        ArrayList<AbstractDomainObject> studenti= DBBroker.getInstance().select(ado);
        listaStudenata= (ArrayList<Student>) (ArrayList<?>) studenti;
    }

    public ArrayList<Student> getListaStudenata() {
        return listaStudenata;
    }
    
    
    
    
}
