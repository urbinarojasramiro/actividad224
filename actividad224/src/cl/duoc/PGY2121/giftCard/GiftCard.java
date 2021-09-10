/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.PGY2121.giftCard;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author escor
 */
public class GiftCard {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        // TODO code application logic here
        Scanner s = new Scanner(System.in);
        Date date = new Date(System.currentTimeMillis());
        long codigoBase = 1000000000000000L;
        
        int opcion = 0;
        
        Tarjeta tarjeta = new Tarjeta();
        tarjeta.generarCodigo(codigoBase);
        tarjeta.setClave(1645);
        tarjeta.setMonto(55000);
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = "2021-10-11";
        Date dateObject = sdf.parse(dateString);
        tarjeta.setVigencia(dateObject);
        
        Trabajador trabajador = new Trabajador();
        
        while(opcion != 5){
            System.out.println("1.-Ingresar Cliente Nuevo");
            System.out.println("2.-Pago mediante GiftCard");
            System.out.println("5.-Salir");
            opcion = s.nextInt();
            s.nextLine();
            if(opcion == 1){
                boolean esNombreValido = false;
                while(!esNombreValido){
                    System.out.println("Ingrese el nombre del cliente");
                    String nombre = s.nextLine();
                    trabajador.setNombre(nombre);
                    esNombreValido = trabajador.nombreEsVacio();
                    if(!esNombreValido){
                        System.out.println("Debe ingresar un nombre de usuario para continuar");
                    }
                }
                System.out.println("Ingrese el run del cliente, sin digito");
                int run = s.nextInt();
                trabajador.setRun(run);
                s.nextLine();
                
                boolean esDigitoValido = false;
                while(!esDigitoValido){
                    System.out.println("Ingrese el digito verificador");
                    String dv = s.nextLine();
                    trabajador.setDv(dv);
                    esDigitoValido = trabajador.esDVValido();
                    if(!esDigitoValido){
                        System.out.println("El dv ingresado no es válido, intente nuevamente!");
                    }
                }
            }
            
            if(opcion == 2){
                boolean existeTrabajador = trabajador.getRun() != 0;
                if(existeTrabajador){
                    tarjeta.setTrabajador(trabajador);
                    boolean esClaveValida = false;
                    while(!esClaveValida){
                        System.out.println("Ingrese la clave de la tarjeta:");
                        int clave = s.nextInt();
                        s.nextLine();
                        esClaveValida = tarjeta.esClaveValida(clave);
                        if(!esClaveValida){
                            System.out.println("La clave ingresada no es válida");
                        }
                    }
                    
                    boolean cubreCompra = false;
                    boolean esVigente = tarjeta.esVigente(date);
                    boolean tieneMonto = tarjeta.esMontoValido();
                    boolean esTarjetaValida = esVigente && tieneMonto;
                    if(!esVigente){
                        System.out.println("La giftCard está vencida");
                    }
                    
                    while(!cubreCompra && esTarjetaValida){
                        System.out.println("Ingrese el monto de la compra");
                        int compra = s.nextInt();
                        s.nextLine();
                        cubreCompra = tarjeta.cubreCompra(compra);
                        if(!cubreCompra){
                            System.out.println("El monto de la compra supera el monto de la giftcard");
                        }else{
                            tarjeta.descontarCompra(compra);
                        }
                    }
                }else{
                    System.out.println("Para pagar con giftcard primero debe ingresar cliente");
                }
            }
        }
        
        System.out.println("su saldo en la tarjeta es: " + tarjeta.getMonto());
    }
    
}
