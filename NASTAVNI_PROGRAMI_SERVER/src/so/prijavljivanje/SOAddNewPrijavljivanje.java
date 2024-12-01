/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.prijavljivanje;

import baza.DBBroker;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.AbstractDomainObject;
import model.Prijavljivanje;
import model.Kurs;
import so.AbstractSO;

/**
 *
 * @author ivana
 */
public class SOAddNewPrijavljivanje extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
         if (!(ado instanceof Prijavljivanje)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Prijavljivanje!");
        }
        
        Prijavljivanje pr = (Prijavljivanje) ado;
        
       if (pr.getKurs().isEmpty()) {
            throw new Exception("Prijavljivanje mora imati barem jedan kurs!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        PreparedStatement ps = DBBroker.getInstance().insert(ado);
        
        ResultSet tableKeys = ps.getGeneratedKeys();
        tableKeys.next();
        int prijavljivanjeID = tableKeys.getInt(1);

        
        Prijavljivanje pr =  (Prijavljivanje) ado;
        pr.setPrijavljivanjeID(prijavljivanjeID);

        
        for (Kurs kurs : pr.getKurs()) {
            kurs.setPrijavljivanje(pr);
            DBBroker.getInstance().insert(kurs);
        }
    }
    
}
