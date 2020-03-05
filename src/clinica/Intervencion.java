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
import java.text.ParseException;
import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * version 2
 * @author DAW109
 */
public class Intervencion extends Cita{
    
    private String duracion;
    
    private ArrayList <Enfermeria> enfermeros;
    
    private ArrayList <Cirujano> cirujanos;
    
    private long idCirujano;
    
    public Intervencion() {
    super();
    }
    
    public Intervencion(Date fecha, char rangoHorario,String hora,boolean estado,String duracion){
        super(fecha,rangoHorario,hora,estado);
        this.duracion = duracion;
       this.enfermeros = new ArrayList<Enfermeria>();
       this.cirujanos = new ArrayList<Cirujano>();
       this.idCirujano = idCirujano;
    }
    
    public Intervencion (Intervencion i) {
        super(i);
        this.duracion = i.getDuracion();
        this.enfermeros = new ArrayList<Enfermeria>();
        this.cirujanos = new ArrayList<Cirujano>();
        this.idCirujano = i.getIdCirujano();
    }
    
    public Intervencion(Cita c, String duracion){
       super(c);
       this.duracion = duracion;
       this.enfermeros = new ArrayList<Enfermeria>();
       this.cirujanos = new ArrayList<Cirujano>();
       this.idCirujano  =idCirujano;
       
   } 
    
   public Intervencion(Cita c, String duracion, ArrayList<Enfermeria> enfermeros){
       super(c);
       this.duracion = duracion;
       this.enfermeros = enfermeros;
       
   }
    
   
      public Intervencion(Cita c, String duracion, ArrayList<Enfermeria> enfermeros, ArrayList<Cirujano> cirujanos){
       super(c);
       this.duracion = duracion;
       this.enfermeros = enfermeros;
       this.cirujanos = cirujanos;
       
   }
      
      
   
    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public ArrayList<Enfermeria> getEnfermeros() {
        return enfermeros;
    }

    public void setEnfermeros(ArrayList<Enfermeria> enfermeros) {
        this.enfermeros = enfermeros;
    }

    public ArrayList<Cirujano> getCirujanos() {
        return cirujanos;
    }

    public void setCirujanos(ArrayList<Cirujano> cirujanos) {
        this.cirujanos = cirujanos;
    }

    public long getIdCirujano() {
        return idCirujano;
    }

    public void setIdCirujano(long idCirujano) {
        this.idCirujano = idCirujano;
    }
   

    @Override
    public String toString() {
        return super.toString()+ "Intervencion{" + "duracion=" + duracion + '}';
    }
    
    public String Data () {
        
        return super.data()+ " | " + getIdCirujano() + "|" + getDuracion();
        
    }
    
    public ArrayList<Intervencion> getAllIntervencion (){
    ArrayList <Intervencion> intervenciones = new ArrayList <Intervencion>();
    return intervenciones ;
    }
    
    public Intervencion getIntervencionById (long id){
        Intervencion i = new Intervencion();
    /*Este método sirve para que posteriormente se busque el id dado
      y se obtengan los datos de aquella intervencion que tenga ese id dado.
      Aunque si no existe ninguna intervencion con ese id saldra null.  
    */    
        return i;
    }
    
    public static Intervencion nuevaIntervencion () throws ParseException{
  
        Intervencion i;
        Scanner in = new Scanner(System.in);
        boolean correcto;
        
        do{
            Cita c = Cita.nuevoCita();
            i = new Intervencion();
            
            System.out.println("Introduzca duración:");
            String dur = in.nextLine();
            i.setDuracion(dur);
            
            ArrayList <Enfermeria> enfermeros = new ArrayList();
            System.out.println("¿Quieres introducir los enfermeros? ");
            boolean resp = Utilidades.leerBoleano();
            if(resp){
               boolean resp2;
                do {
                   Enfermeria e = Enfermeria.nuevoEnfermeria();
                   enfermeros.add(e);
                   System.out.println("¿Quiere introducir otro enfermero/a?");
                   resp2 =Utilidades.leerBoleano();
                }
                while(resp2);    
                i.setEnfermeros (enfermeros);
            }
            
            ArrayList <Cirujano> cirujanos = new ArrayList();
            System.out.println("¿Quieres introducir los ? ");
            Cirujano cij;
            boolean resp3 = Utilidades.leerBoleano();
            if(resp3){
               boolean resp4;
                do {
                   
                   cij = Cirujano.nuevoCirujanos();
                   cirujanos.add(cij);
                   System.out.println("¿Quiere introducir otro cirujano/a?");
                   resp4 =Utilidades.leerBoleano();
                }
                while(resp4);    
                i.setCirujanos (cirujanos);
            }
            i= new Intervencion(c, dur, enfermeros, cirujanos);
            System.out.println("La intervencion introducida es: " + i);
            System.out.println("¿Es correcta la intervencion?");
            correcto = Utilidades.leerBoleano();
        }
        while(!correcto);
        
     return i;   
    }    
    
    
            
        public static ArrayList<Intervencion> readIntervencionfromTextFile (String path) {
        ArrayList<Intervencion> inte = new ArrayList<>();
        File fichero = new File(path);
        FileReader interve = null;
        BufferedReader buffer = null ;
        try {
            try {
                interve = new FileReader(fichero);
                buffer = new BufferedReader(interve);
                String linea;
                while((linea=buffer.readLine())!=null){
                    String[] campos = linea.split("\\|");
                    long id = Long.parseLong(campos[0]);
                    String duracion = campos[10];
                    Intervencion i = new Intervencion();
                    inte.add(i);                   
                }
            }finally{
                if(buffer!=null)
                    buffer.close();
                if(interve!=null)
                    interve.close();
            }
        }
        catch(FileNotFoundException i){
            System.out.println("Se ha producido una FileNotFoundException");
        }
        catch(IOException i){
            System.out.println("Se ha producido una IOException");
        }
        catch(Exception i){
            System.out.println("Se ha producido una Exception");
        }
        return inte;
    }
        
        
        public static ArrayList<Intervencion> readIntervencionfromBinaryFile (String path) {
        ArrayList<Intervencion> inte = new ArrayList<>();
        FileInputStream interven = null;
        ObjectInputStream inObjeto = null;
        try{
            try{
                interven = new FileInputStream(path);
                inObjeto = new ObjectInputStream(interven);
                Intervencion i;
                while((i = (Intervencion)inObjeto.readObject())!=null)
                    inte.add(i);
            }finally{
                if(interven!=null)
                    interven.close();
                if(inObjeto!=null)
                    inObjeto.close();
            }
        }
        catch(FileNotFoundException i){
            System.out.println("Se ha producido una FileNotFoundException");
        }
        catch(IOException i){
            System.out.println("Se ha producido una IOException");
        }
        catch(ClassNotFoundException i){
            System.out.println("Se ha producido una ClassNotFoundException");
        }
        catch(Exception i){
            System.out.println("Se ha producido una Exception");
        }
        return inte;
    }
    
    public void toTextFile (String path){
        File inter = new File(path);
        FileWriter interv = null;
        PrintWriter buffer = null ;
        try {
            try {
                interv = new FileWriter(inter);
                buffer = new PrintWriter(interv);
                buffer.println(this.Data());
            }finally{
                if(buffer!=null)
                    buffer.close();
                if(interv!=null)
                    interv.close();
            }
        }
        catch(FileNotFoundException i){
            System.out.println("Se ha producido una FileNotFoundException");
        }
        catch(IOException i){
            System.out.println("Se ha producido una IOException");
        }
        catch(Exception i){
            System.out.println("Se ha producido una Exception");
        }
    }

   
    public void toBinaryFile (String path) {
        FileOutputStream inter = null;
        ObjectOutputStream inObjeto = null;
        try{
            try{
                inter = new FileOutputStream(path);
                inObjeto = new ObjectOutputStream(inter);
                inObjeto.writeObject(this);
            }finally{
                if(inter!=null)
                    inter.close();
                if(inObjeto!=null)
                    inObjeto.close();
            }
        }
        catch(FileNotFoundException i){
            System.out.println("Se ha producido una FileNotFoundException");
        }
        catch(IOException i){
            System.out.println("Se ha producido una IOException");
        }
        catch(Exception i){
            System.out.println("Se ha producido una Exception");
        }
    }
  
        
        
    
    
    
}
