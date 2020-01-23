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
 * @version 4.1
 * @author AdrianSaveli
 */
public class Informe {
    protected long id;//Es el identificador del informe.
    private String descripcionTratamiento;//Es la descripción del tratamiento a seguir del paciente.Cadena de caracteres.
    private ArrayList<Secretariado> secretariados;
    //Getters y setters

    public ArrayList<Secretariado> getSecretariados() {
        return secretariados;
    }

    public void setSecretariados(ArrayList<Secretariado> secretariados) {
        this.secretariados = secretariados;
    }
    
    public long getID() {
        return id;
    }

    public void setID(long ID) {
        this.id = ID;
    }

    public String getDescripciónTratamiento() {
        return descripcionTratamiento;
    }

    public void setDescripciónTratamiento(String descripciónTratamiento) {
        this.descripcionTratamiento = descripciónTratamiento;
    }
    //Constructor por defecto
    public Informe() {
    }
    //Constructor con argumentos
    public Informe(long ID, String descripciónTratamiento) {
        this.id = ID;
        this.descripcionTratamiento = descripciónTratamiento;
    }
    //Constructor de copia
    public Informe (Informe p) {
        this.descripcionTratamiento = p.getDescripciónTratamiento();
        this.id = p.getID();
    }
    //Otros métodos sobreescritos
    @Override
    public String toString() {
        return "Informe{" + "ID=" + id + ", descripci\u00f3nTratamiento=" + descripcionTratamiento + '}';
    }
    
    public String data() {
        return ""+getID()+"|"+getDescripciónTratamiento();
    }
    public ArrayList<Informe> getAllInforme (){
    ArrayList <Informe> informes = new ArrayList <Informe>();
    return informes ;
    }
    public Informe getInformeById (long id){
        Informe i = new Informe();
        /*Este método sirve para que posteriormente se busque el id dado
        y se obtengan los datos de aquel informe que tenga ese id dado.
        Aunque si no existe ningún informe con ese id saldra null.  
        */ 
        return i;
    }
        public static Informe nuevoInforme () throws ParseException{
  
        Informe i = Informe.nuevoInforme();
        Scanner in = new Scanner(System.in);
        boolean correcto;
        
        do{
            
            
            
            System.out.println("Introduzca descripción del tratamiento:");
            String dtrat = in.nextLine();
            // i.setDescripcionTratamiento(dtrat);
            
            ArrayList <Secretariado> secretariados = new ArrayList();
            System.out.println("¿Quieres introducir los secretarios? ");
            boolean resp = Utilidades.leerBoleano();
            if(resp){
               boolean resp2;
                do {
                   Secretariado s = Secretariado.nuevoSecretariado();
                   secretariados.add(s);
                   System.out.println("¿Quiere introducir otro secretariado/a?");
                   resp2 =Utilidades.leerBoleano();
                }
                while(resp2);    
                i.setSecretariados (secretariados);
            }
            System.out.println("El informe introducido es: " + i);
            System.out.println("¿Es correcto el informe?");
            correcto = Utilidades.leerBoleano();
        }
        while(!correcto);
        
     return i;   
    }  
}
