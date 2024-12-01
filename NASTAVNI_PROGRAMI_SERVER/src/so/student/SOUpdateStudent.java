/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.student;

import baza.DBBroker;
import model.AbstractDomainObject;
import model.Student;
import so.AbstractSO;

/**
 *
 * @author ivana
 */
public class SOUpdateStudent extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Student)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Student!");
        }
         
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        DBBroker.getInstance().update(ado);
    }
    
    
    
    
    
}
