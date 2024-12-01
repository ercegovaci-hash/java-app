/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.student;

import baza.DBBroker;
import java.util.ArrayList;
import model.AbstractDomainObject;
import model.Student;
import so.AbstractSO;

/**
 *
 * @author ivana
 */
public class SOAddNewStudent extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        
         if (!(ado instanceof Student)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Student!");
        }
        
         
         Student noviStudent = (Student) ado;

        ArrayList<Student> studenti = (ArrayList<Student>) (ArrayList<?>) DBBroker.getInstance().select(ado);

        for (Student student : studenti) {
            if (student.getEmail().equals(noviStudent.getEmail())) {
                throw new Exception("Vec postoji student s tim emailom!");
            }
        }
         
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        DBBroker.getInstance().insert(ado);
    }
    
}
