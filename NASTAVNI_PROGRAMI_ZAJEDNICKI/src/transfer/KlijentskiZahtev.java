/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transfer;

import java.io.Serializable;

/**
 *
 * @author ivana
 */
public class KlijentskiZahtev implements Serializable{
    
    private Object parametar;
    private Operacije operacija;

    public KlijentskiZahtev() {
    }

    public KlijentskiZahtev(Object parametar, Operacije operacija) {
        this.parametar = parametar;
        this.operacija = operacija;
    }

    public Object getParametar() {
        return parametar;
    }

    public void setParametar(Object parametar) {
        this.parametar = parametar;
    }

    public Operacije getOperacija() {
        return operacija;
    }

    public void setOperacija(Operacije operacija) {
        this.operacija = operacija;
    }

    
    
    
}
