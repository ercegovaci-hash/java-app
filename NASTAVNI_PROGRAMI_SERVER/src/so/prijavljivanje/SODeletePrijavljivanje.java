/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.prijavljivanje;

import baza.DBBroker;
import model.AbstractDomainObject;
import model.Prijavljivanje;
import so.AbstractSO;

/**
 *
 * @author ivana
 */
public class SODeletePrijavljivanje extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Prijavljivanje)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Prijavljivanje!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
       
         DBBroker.getInstance().delete(ado);
    }
    
}
