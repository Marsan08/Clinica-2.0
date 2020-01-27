/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * verison 2
 * @author DAW109
 */
public class Especialidad {
    
    private String nombre;
    //Nombre de la especialidad ej; endodoncista, esta relacionada con cirujía ES OBLIGATORIO TENER UNA CADENA DE CARACTERES
    protected long id;
    // Identificador de la especialidad, puede ser SA125 por eso es un String, NO PUEDE SER VALOR 0

    public Especialidad() {
    }

    public Especialidad(String nombre, long idEspecialidad) {
        this.nombre = nombre;
        this.id = idEspecialidad;
    }
    
  public Especialidad (Especialidad e){
      
      this.nombre = e.getNombre();
      this.id = e.getId();
      
  }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Especialidad{" + "nombre=" + nombre + ", idEspecialidad=" + id + '}';
    }
    
    public String Data(){
        
        return getNombre() + " | " + getId();
    }

    
    public ArrayList<Especialidad> getAllEspecialidad(){
        
        ArrayList <Especialidad> especilidades = new ArrayList <Especialidad>();
        
        return especilidades;
        
    }
    

    
    public Especialidad getEspecilidadById (long id){
        Especialidad e =new Especialidad();
        
        return e;
    }
    
        
        
        public static Especialidad nuevaEspecialidad(){
        
        Especialidad e = new Especialidad();
        Scanner in = new Scanner(System.in);
        boolean correcto;
        
        do{
            
            System.out.println("Inserte el nombre de la especialidad:");
            String esp = in.nextLine();
            e.setNombre(esp);
            
            System.out.println("¿Es correcto el nombre de la especialidad?");
            correcto = Utilidades.leerBoleano();
            
        } while (!correcto);
                                                

      return e;  
    }
}
