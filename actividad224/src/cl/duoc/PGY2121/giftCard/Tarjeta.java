/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.PGY2121.giftCard;

import java.util.Date;

/**
 *
 * @author escor
 */
public class Tarjeta {
    private long codigo;
    private int clave;
    private int monto;
    private Date vigencia;
    private Trabajador trabajador;

    public Tarjeta(long codigo, int clave, int monto, Date vigencia, Trabajador trabajador) {
        this.codigo = codigo;
        this.clave = clave;
        this.monto = monto;
        this.vigencia = vigencia;
        this.trabajador = trabajador;
    }

    public Tarjeta() {
    }
    
    public void generarCodigo(long codigoBase){
        this.codigo = codigoBase + 1;
    }
    
    public boolean esClaveValida(int claveInput){
        int run = this.trabajador.getRun();
        String runToString = String.valueOf(run);
        String primerosDigitos = runToString.substring(0, 4);
        return Integer.parseInt(primerosDigitos) == claveInput;
    }
    
    public boolean cubreCompra(int montoCompra){
        return this.monto >= montoCompra;
    }
    
    public void descontarCompra(int montoCompra){
        this.monto = this.monto - montoCompra;
    }
    
    public boolean esVigente(Date fechaActual){
        int vigenciaTarj = this.vigencia.compareTo(fechaActual);
        return vigenciaTarj != -1;
    }
    
    public boolean esMontoValido(){
        return this.monto >= 0;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public Date getVigencia() {
        return vigencia;
    }

    public void setVigencia(Date vigencia) {
        this.vigencia = vigencia;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }
    
    
}
