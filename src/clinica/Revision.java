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
import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * @version 2.0
 * @author AdrianSaveli
 */
public class Revision extends Cita {

    static Revision nuevoRevision() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private String anotaciones;
    long idCirujano;//Son las anotaciones que se escriben en la revisión.Cadena de caracteres.
    //Getters y setters
    public long getIdCirujano() {
        return idCirujano;
    }
    public void setIdCirujano(long idCirujano) {    
        this.idCirujano = idCirujano;
    }

    public String getAnotaciones() {
        return anotaciones;
    }

    public void setAnotaciones(String anotaciones) {
        this.anotaciones = anotaciones;
    }
     public static ArrayList<Revision> FromTextFile (String path) {
        ArrayList<Revision> ret = new ArrayList<>();
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
                    String anotaciones = campos[1];
	            long idCirujano = Long.parseLong(campos[0]);
                    Revision r = new Revision();//Fallo con los constructores
                    ret.add(r);                   
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

    public static ArrayList<Revision> FromBinaryFile (String path) {
        ArrayList<Revision> ret = new ArrayList<>();
        FileInputStream lector = null;
        ObjectInputStream lectorObjeto = null;
        try{
            try{
                lector = new FileInputStream(path);
                lectorObjeto = new ObjectInputStream(lector);
                Revision r;
                while((r = (Revision)lectorObjeto.readObject())!=null){
                    ret.add(r);
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
    public Revision() {
    super();
    }
    //Constructor con argumentos
    public Revision(Date fecha, char rangoHorario,String hora,boolean estado,String anotaciones,long idCirujano) {
        super(fecha,rangoHorario,hora,estado);
        this.anotaciones = anotaciones;
        this.idCirujano = idCirujano;
    }
    //Constructor de copia
    public Revision (Revision p) {
        super(p);
        this.anotaciones = p.getAnotaciones();
        this.idCirujano = p.idCirujano;
    }
    public Revision(Cita c, String anotaciones){
       super(c);
       this.anotaciones = anotaciones;
    } 
    //Otros métodos sobreescritos
    @Override
    public String toString() {
        return super.toString()+"Revisi\u00f3n{" + "anotaciones=" + anotaciones + '}';
    }
    
    @Override
    public String data() {
        
        return super.data()+ "|"+getAnotaciones()+"|"+getIdCirujano();
    }
   
    
    public ArrayList<Revision> getAllRevision (){
    ArrayList <Revision> revisiones = new ArrayList <Revision>();
    return revisiones ;
    }
    
    
    public Revision getRevisionById (long id){
        Revision r = new Revision();
    /*Este método sirve para que posteriormente se busque el id dado
      y se obtengan los datos de aquella revision que tenga ese id dado.
      Aunque si no existe ninguna revision con ese id saldra null.  
    */    
        return r;
    }
    public static Revision nuevaRevision () throws ParseException{
  
        Revision r;
        Scanner in = new Scanner(System.in);
        boolean correcto;
        
        do{
            Cita c = Cita.nuevoCita();
            r = new Revision();
            
            System.out.println("Introduzca anotaciones:");
             String anot = in.nextLine();
            // r.setAnotaciones(anot);
            
           
           r= new Revision(c, anot);
            System.out.println("La revision introducida es: " + r);
            System.out.println("¿Es correcta la revision?");
            correcto = Utilidades.leerBoleano();
        }
        while(!correcto);
        
     return r;   
    } 
    
}
