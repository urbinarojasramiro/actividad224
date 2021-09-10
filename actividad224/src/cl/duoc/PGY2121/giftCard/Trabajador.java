/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.PGY2121.giftCard;

/**
 *
 * @author escor
 */
public class Trabajador {
    private int run;
    private String dv;
    private String nombre;

    public Trabajador(int run, String dv, String nombre) {
        this.run = run;
        this.dv = dv;
        this.nombre = nombre;
    }

    public Trabajador() {
    }
    
    public boolean nombreEsVacio(){
        return !("".equals(this.nombre) || this.nombre == null);
    }
    
    public boolean esDVValido(){
        int digito = Integer.parseInt(this.dv);
        boolean esDigito = (0 <= digito && 9 >= digito);
        boolean esK = "k".equals(this.dv.toLowerCase());
        return esDigito || esK;
    }

    public int getRun() {
        return run;
    }

    public void setRun(int run) {
        this.run = run;
    }

    public String getDv() {
        return dv;
    }

    public void setDv(String dv) {
        this.dv = dv;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
