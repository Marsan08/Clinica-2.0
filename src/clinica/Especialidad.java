/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * verison 2
 * @author DAW109
 */
public class Especialidad {
    
    protected long id;
    // Identificador de la especialidad, debe ser siempre de tipo long.

    private String nombre;
    //Nombre de la especialidad ej; endodoncista, esta relacionada con cirujía ES OBLIGATORIO TENER UNA CADENA DE CARACTERES


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

    private Especialidad(long id, String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        
        return this.getId() + " | " + this.getNombre();
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
        
        
        //Metodos de entrada y salida
        
        
        public static ArrayList<Especialidad> fromTextFile (String path) {
        ArrayList<Especialidad> esp = new ArrayList<>();
        File fichero = new File(path);
        FileReader especial = null;
        BufferedReader buffer = null ;
        try {
            try {
                especial = new FileReader(fichero);
                buffer = new BufferedReader(especial);
                String linea;
                while((linea=buffer.readLine())!=null){
                    String[] campos = linea.split("\\|");
                    long id = Long.parseLong(campos[0]);
                    String nombre = campos[10];
                    Especialidad e = new Especialidad(id, nombre);
                    esp.add(e);                   
                }
            }finally{
                if(buffer!=null)
                    buffer.close();
                if(especial!=null)
                    especial.close();
            }
        }
        catch(FileNotFoundException e){
            System.out.println("Se ha producido una FileNotFoundException");
        }
        catch(IOException e){
            System.out.println("Se ha producido una IOException");
        }
        catch(Exception e){
            System.out.println("Se ha producido una Exception");
        }
        return esp;
    }
        
        
        public static ArrayList<Especialidad> fromBinaryFile (String path) {
        ArrayList<Especialidad> ret = new ArrayList<>();
        FileInputStream especial = null;
        ObjectInputStream espObjeto = null;
        try{
            try{
                especial = new FileInputStream(path);
                espObjeto = new ObjectInputStream(especial);
                Especialidad e;
                while((e = (Especialidad)espObjeto.readObject())!=null)
                    ret.add(e);
            }finally{
                if(especial!=null)
                    especial.close();
                if(espObjeto!=null)
                    espObjeto.close();
            }
        }
        catch(FileNotFoundException e){
            System.out.println("Se ha producido una FileNotFoundException");
        }
        catch(IOException e){
            System.out.println("Se ha producido una IOException");
        }
        catch(ClassNotFoundException e){
            System.out.println("Se ha producido una ClassNotFoundException");
        }
        catch(Exception e){
            System.out.println("Se ha producido una Exception");
        }
        return ret;
    }
    
    public void toTextFile (String path){
        File especialidad = new File(path);
        FileWriter especializado = null;
        PrintWriter buffer = null ;
        try {
            try {
                especializado = new FileWriter(especialidad);
                buffer = new PrintWriter(especializado);
                buffer.println(this.Data());
            }finally{
                if(buffer!=null)
                    buffer.close();
                if(especializado!=null)
                    especializado.close();
            }
        }
        catch(FileNotFoundException e){
            System.out.println("Se ha producido una FileNotFoundException");
        }
        catch(IOException e){
            System.out.println("Se ha producido una IOException");
        }
        catch(Exception e){
            System.out.println("Se ha producido una Exception");
        }
    }

   
    public void toBinaryFile (String path) {
        FileOutputStream especializado = null;
        ObjectOutputStream espObjeto = null;
        try{
            try{
                especializado = new FileOutputStream(path);
                espObjeto = new ObjectOutputStream(especializado);
                espObjeto.writeObject(this);
            }finally{
                if(especializado!=null)
                    especializado.close();
                if(espObjeto!=null)
                    espObjeto.close();
            }
        }
        catch(FileNotFoundException e){
            System.out.println("Se ha producido una FileNotFoundException");
        }
        catch(IOException e){
            System.out.println("Se ha producido una IOException");
        }
        catch(Exception e){
            System.out.println("Se ha producido una Exception");
        }
    }
  
        
        
        
}
