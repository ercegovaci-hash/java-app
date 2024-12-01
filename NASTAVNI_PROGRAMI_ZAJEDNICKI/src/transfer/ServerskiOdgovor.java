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
public class ServerskiOdgovor implements Serializable{
    
    private Object rezultat;
    private Exception exception;
    private StatusOdgovora statusOdgovora;

    public ServerskiOdgovor() {
    }

    public ServerskiOdgovor(Object rezultat, Exception exception, StatusOdgovora statusOdgovora) {
        this.rezultat = rezultat;
        this.exception = exception;
        this.statusOdgovora = statusOdgovora;
    }

    public Object getRezultat() {
        return rezultat;
    }

    public void setRezultat(Object rezultat) {
        this.rezultat = rezultat;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public StatusOdgovora getStatusOdgovora() {
        return statusOdgovora;
    }

    public void setStatusOdgovora(StatusOdgovora statusOdgovora) {
        this.statusOdgovora = statusOdgovora;
    }
    
    
}
