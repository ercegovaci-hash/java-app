/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.prijavljivanje;

import baza.DBBroker;
import model.AbstractDomainObject;
import model.Prijavljivanje;
import model.Kurs;
import java.util.Date;
import model.Student;
import so.AbstractSO;

/**
 *
 * @author Andjela
 */
public class SOUpdatePrijavljivanje extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
       
        if (!(ado instanceof Prijavljivanje)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Prijavljivanje!");
        }

        Prijavljivanje pr = (Prijavljivanje) ado;

       

        if (pr.getKurs().isEmpty()) {
            throw new Exception("Prijavljivanje mora imati barem jednu stavku!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        
        DBBroker.getInstance().update(ado);

        Prijavljivanje prijavljivanje = (Prijavljivanje) ado;

        DBBroker.getInstance().update(ado);

        Kurs prviKurs = prijavljivanje.getKurs().get(0);

        DBBroker.getInstance().delete(prviKurs);

        for (Kurs kurs : prijavljivanje.getKurs()) {

            DBBroker.getInstance().insert(kurs);

        }
        
    }
    
}
