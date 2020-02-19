/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica;
import java.io.BufferedReader;
import java.io.EOFException;
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
    //4 metodos E-S
     public static ArrayList<Informe> FromTextFile (String path) {
        ArrayList<Informe> ret = new ArrayList<>();
        File fichero = new File(path);
        FileReader lector = null;
        BufferedReader buffer = null ;
        try {
            try {
                lector = new FileReader(fichero);
                buffer = new BufferedReader(lector);
                String linea;
                while((linea=buffer.readLine())!=null){
                    String[] campos = linea.split("\\|");

                    long id = Long.parseLong(campos[0]);
                    String descripcionTratamiento = campos[1];
                    Informe i = new Informe(id, descripcionTratamiento);
                    ret.add(i);                   
                }
            }finally{
                if(buffer!=null)
                    buffer.close();
                if(lector!=null)
                    lector.close();
            }
        }
        catch(FileNotFoundException p){
            System.out.println("Se ha producido una FileNotFoundException"+p.getMessage());
        }
        catch(IOException p){
            System.out.println("Se ha producido una IOException"+p.getMessage());
        }
        catch(Exception p){
            System.out.println("Se ha producido una Exception"+p.getMessage());
        }
        return ret;
    }

    public static ArrayList<Informe> FromBinaryFile (String path) {
        ArrayList<Informe> ret = new ArrayList<>();
        FileInputStream lector = null;
        ObjectInputStream lectorObjeto = null;
        try{
            try{
                lector = new FileInputStream(path);
                lectorObjeto = new ObjectInputStream(lector);
                Informe i;
                while((i = (Informe)lectorObjeto.readObject())!=null){
                    ret.add(i);
                    lector.skip(4);}
            }finally{
                if(lectorObjeto!=null)
                    lectorObjeto.close();
                if(lector!=null)
                    lector.close();
            }
        }
        catch(FileNotFoundException p){
            System.out.println("Se ha producido una FileNotFoundException"+p.getMessage());
        }
        catch(EOFException p){
            System.out.println("Final de fichero");
        }
        catch(IOException p){
            System.out.println("Se ha producido una IOException: "+p.getMessage());
        }
        catch(ClassNotFoundException p){
            System.out.println("Se ha producido una ClassNotFoundException"+p.getMessage());
        }
        catch(Exception p){
            System.out.println("Se ha producido una Exception"+p.getMessage());
        }
        return ret;
    }

    public void writeToTextFile (String path){
        File fichero = new File(path);
        FileWriter escritor = null;
        PrintWriter buffer = null ;
        try {
            try {
                escritor = new FileWriter(fichero, true);
                buffer = new PrintWriter(escritor);
                buffer.print(this.data()+"\r\n");
            }finally{
                if(buffer!=null)
                    buffer.close();
                if(escritor!=null)
                    escritor.close();
            }
        }
        catch(FileNotFoundException p){
            System.out.println("Se ha producido una FileNotFoundException"+p.getMessage());
        }
        catch(IOException p){
            System.out.println("Se ha producido una IOException"+p.getMessage());
        }
        catch(Exception p){
            System.out.println("Se ha producido una Exception"+p.getMessage());
        }
    }

    public void writeToBinaryFile (String path) {
        try{
            FileOutputStream fichero = new FileOutputStream(path, true);
            ObjectOutputStream escritor = new ObjectOutputStream(fichero);
            escritor.writeObject(this);
            escritor.flush();
            escritor.close();
        }       
        catch(FileNotFoundException p){
            System.out.println("Se ha producido una FileNotFoundException"+p.getMessage());
        }
        catch(IOException p){
            System.out.println("Se ha producido una IOException"+p.getMessage());
        }
        catch(Exception p){
            System.out.println("Se ha producido una Exception"+p.getMessage());
        }
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
  
        Informe i = new Informe();
        Scanner in = new Scanner(System.in);
        boolean correcto;
        
        do{
            System.out.println("Introduzca descripción del tratamiento:");
            String dtrat = in.nextLine();
            i.setDescripciónTratamiento(dtrat);
            
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
