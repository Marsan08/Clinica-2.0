/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * version 2
 * @author DAW109
 */
public class Enfermeria extends Empleado{
    
    private char categoria;
    //Dado que la categoría tiene que estar solo representado por una letra es un char PUEDE TENER LOS VALORES QUE SE QUIERAN PUESTO QUE PUEDEN PONER LAS CATEGORÍAS COMO CATEGORÍA A,0, 1... SOLO PUEDE SER UN CARACTER.
    private ArrayList <Intervencion> intervenciones;
    //Constructor por defecto
    public Enfermeria() {
        super();
    }
    //Constructor con parámetros

    public Enfermeria(String nombre, String apellido, String telefono, String nif, String direccion) {
        super (nombre, apellido, telefono, nif, direccion);
        this.categoria = categoria;
    }
    //Constructor de copia
    
    public Enfermeria (Enfermeria e){
        super (e);
        this.categoria=e.getCategoria();
    
    }
    
    public Enfermeria (Empleado e, char categoria) {
        super (e);
        this.categoria= categoria;
    }

    public char getCategoria() {
        return categoria;
    }

    public void setCategoria(char categoria) {
        this.categoria = categoria;
    }

    public ArrayList<Intervencion> getIntervenciones() {
        return intervenciones;
    }

    public void setIntervenciones(ArrayList<Intervencion> intervenciones) {
        this.intervenciones = intervenciones;
    }
  

    public String Data () {
        
        return super.data()+ getCategoria() + "";
    }

    @Override
    public String toString() {
        return super.toString()+  "Enfermeria{" + "categoria=" + categoria + '}';
    }
    
    public Enfermeria getEnfermeriaById (long id){
        Enfermeria e = new Enfermeria ();
         return e;
    }
 
  public ArrayList<Enfermeria> getAllEnfermeria (){
      
      ArrayList<Enfermeria> enfermerias = new ArrayList <Enfermeria>();
      
      return enfermerias;
              
  }
  
  public static Enfermeria nuevoEnfermeria() throws ParseException{
       Enfermeria e = new Enfermeria();
       Scanner in = new Scanner (System.in);
       boolean correcto;
       
       do {
           
           Empleado em = Empleado.nuevoEmpleado();
           
           System.out.println("Introduzca la categoria de los enfermeros/as.");
           char cat;
           cat = in.nextLine().charAt(0);
           e.setCategoria(cat);
           
           ArrayList <Intervencion> intervenciones = new ArrayList();
           System.out.println("¿Quiere introducir las intervenciones?");
           Intervencion intr;
           
           boolean resp = Utilidades.leerBoleano();
           
           if(resp){
               
               boolean resp2;
           do{
               
               intr = Intervencion.nuevaIntervencion();
               intervenciones.add(intr);
               System.out.println("¿Quiere introducir otra intervención?");
               resp2 = Utilidades.leerBoleano();
               
           } while (resp2);
          
                   }
           System.out.println("Los datos introducidos son:"+e);
           System.out.println("¿Son correctos los datos introducidos?");
           correcto = Utilidades.leerBoleano();
      
  } while (!correcto);
    
    return e;
}
  
  
}

