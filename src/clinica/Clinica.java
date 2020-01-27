/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica;

import java.text.ParseException;
import excepciones.PagoExcepcion;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @version 1.0
 * @author DAW106
 */
public class Clinica { 
    /**
     * @param args the command line arguments
     * Programa principal de la clinica. Prueba los métodos data y toString de las clases creadas.
     */
    public static void main(String[] args) throws ParseException {
        
       //* Historial h1= new Historial(7,"Paciente"); //Se crea el objeto historial h1
        //*Empleado e1= new Empleado(1,"Jose","Sanchez","938298","239883-A","Calle Heliodoro 123");
        //Cobro c1=new Cobro(3,50.0,"13/04/2007");
        //Cita ci1=new Cita(1,"12/04/2005",'T',"09:34");
        //*Cirujano cir1=new Cirujano("especialidades");
        
       //* System.out.println("*****HISTORIAL DEL PACIENTE*****");
       //* System.out.println(h1.data());
       //* System.out.println(h1.toString());
       //* System.out.println("********************************");
        
        
       //* System.out.println(e1.data());
       //* System.out.println(e1.toString());
        
        //System.out.println(c1.data());
        //System.out.println(c1.toString());
        
        //System.out.println(ci1.data());
        //System.out.println(ci1.toString());
        
       //* System.out.println(cir1.data());
       //* System.out.println(cir1.toString());
        //Cita cita = Cita.nuevoCita();
        //Pago pago = Pago.nuevoPago();
        
        //Utilidades u = new Utilidades();
        //u.registraPaciente();
       
        //Utilidades u = new Utilidades();
        //Utilidades.registraPaciente(p);
        
    //Paciente paciente[]; 
    //paciente=u.PACIENTES;
    //for(int i=0;i<paciente.length;i++){
        
    //Paciente p=new Paciente(paciente[i].getNombre(),paciente[i].getApellidos(),paciente[i].getNIF(),paciente[i].getTelefono(),paciente[i].getDireccion());  
    //u.registraPaciente(p.getNombre(), p.getApellidos(), p.getNIF(), p.getTelefono(), p.getDireccion());
    //}
    
    
    Paciente p = new Paciente();
     try{
    Pago k= Pago.nuevoPago();
     Tratamiento t = new Tratamiento();
   
    
        p.realizarPago(t);
        
        
    } 
    catch(PagoExcepcion ex){
    
            System.out.println("Se ha producido una PagoExcepcion"+ ex.getMessage());
    
    }
    
    }
}
    
    
    
    
    
    
    
    
            
            

