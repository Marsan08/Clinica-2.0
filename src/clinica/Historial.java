
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica;
import java.util.ArrayList;
import java.util.Scanner;
//import java.util.*;
/**
 * @version 2.0
 * @author DAW106
 * Clase del Historial de la clinica
 */
public class Historial {
    
    protected long id;//Lleva el identificador del historial
    private String descripcion;//Descripcion del historial
    private ArrayList<Alergia> alergias;
  //private List<Alergia>alergias=new ArrayList<Alergia>();
 
    public Historial() {
    }

    public Historial(int idHistoria, String descripcion) {
        this.id = idHistoria;
        this.descripcion = descripcion;
    }
    
    public Historial(Historial h){
        this.descripcion=h.getDescripcion();
        this.id=h.getId();
    }

    public ArrayList<Alergia> getAlergias() {
        return alergias;
    }

    public void setAlergias(ArrayList<Alergia> alergias) {
        this.alergias = alergias;
    }
    
    public long getId() {
        return id;
    }

    public void setIdHistoria(int idHistoria) {
        this.id = idHistoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Historial{" + "idHistoria=" + id + ", descripcion=" + descripcion + '}';
    }
    
    public String data() {
        return getId() + " | " + getDescripcion();
    }
    public ArrayList<Historial> getAllHistorial (){
    ArrayList <Historial> historiales = new ArrayList <Historial>();
    return historiales ;
    }
    public Historial getHistorialById (long id){
        Historial h = new Historial();
         return h;
    }
          public static Historial nuevoHistorial()
     {
        Historial h = new Historial();
        Scanner in = new Scanner(System.in);     
        
        System.out.println("Introduzca la descripcion");
        String descripcion = in.nextLine();
        h.setDescripcion(descripcion);
        
        System.out.println("Introduzca nº de alergias");
        int num = Integer.parseInt(in.nextLine());
        
        ArrayList<Alergia>ale=new ArrayList<Alergia>();
        
        for (int i=0; i<num;i++){
        
        System.out.println("Introduce alergia");
        String al= in.nextLine();
        
        Alergia a= new Alergia(i+1,al);
        ale.add(a);
        }
        
        h.setAlergias (ale);
        
        System.out.println("Lista alergias");
        h.getAlergias();
        
        ArrayList<Alergia>alerg=h.getAlergias();
        
        for (int i=0; i<alerg.size();i++){
        
        System.out.println(alerg.get(i).getNombreAlergia());
        
        }
        
        return h;

     }
    
}

