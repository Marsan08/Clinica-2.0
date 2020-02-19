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
 * @version 2.0
 * @author AdrianSaveli
 */
public class Secretariado extends Empleado {

    private int añosExperiencia;//Son los años de experiencia del secretariado.Debe ser un número determinado.
    private ArrayList<Informe> informes;
    Cita cita;
    long idCita;
    //Getters y setters

    public long getIdCita() {
        return idCita;
    }

    public void setIdCita(long idCita) {
        this.idCita = idCita;
    }
    
    public ArrayList<Informe> getInformes() {
        return informes;
    }

    public void setInformes(ArrayList<Informe> informes) {
        this.informes = informes;
    }

    public int getAñosExperiencia() {
        return añosExperiencia;
    }

    public void setAñosExperiencia(int añosExperiencia) {
        this.añosExperiencia = añosExperiencia;
    }
     public static ArrayList<Secretariado> FromTextFile (String path) {
        ArrayList<Secretariado> ret = new ArrayList<>();
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
                    String añosExperiencia = campos[1];
	            long idCita = Long.parseLong(campos[0]);
                 //No se porque falla.   Secretariado s = new Secretariado(id,añosExperiencia,idCita);
                  //  ret.add(s);                   
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

    public static ArrayList<Secretariado> FromBinaryFile (String path) {
        ArrayList<Secretariado> ret = new ArrayList<>();
        FileInputStream lector = null;
        ObjectInputStream lectorObjeto = null;
        try{
            try{
                lector = new FileInputStream(path);
                lectorObjeto = new ObjectInputStream(lector);
                Secretariado s;
                while((s = (Secretariado)lectorObjeto.readObject())!=null){
                    ret.add(s);
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
    public Secretariado() {
        super();
    }

    //Constructor con argumentos
    public Secretariado(String nombre, String apellido, String telefono, String nif, String direccion,int añosExperiencia,long idCita) {
        super(nombre, apellido, telefono, nif, direccion);
        this.añosExperiencia = añosExperiencia;
        this.idCita= idCita;
    }

    //Constructor de copia
    public Secretariado(Secretariado p) {
        super(p);
        this.añosExperiencia = p.getAñosExperiencia();
        this.idCita= p.getIdCita();

    }

    public Secretariado(Empleado e, int añosExperiencia) {
        super(e);
        this.añosExperiencia = añosExperiencia;
    }

    public Secretariado(Empleado e, int añosExperiencia, ArrayList<Informe> informes) {
        super(e);
        this.añosExperiencia = añosExperiencia;
    }

    //Otros métodos sobreescritos
    @Override
    public String toString() {
        return super.toString() + "Secretariado{" + "a\u00f1osExperiencia=" + añosExperiencia + '}';
    }

    @Override
    public String data() {
        return super.data() + "|" + getAñosExperiencia();
    }

    public Secretariado getSecretariadoById(long id) {
        Secretariado s = new Secretariado();
        /*Este método sirve para que posteriormente se busque el id dado
        y se obtengan los datos de aquel secretariado que tenga ese id dado.
        Aunque si no existe ningún secretariado con ese id saldra null.  
         */
        return s;
    }

    public ArrayList<Secretariado> getAllSecretariado() {

        ArrayList<Secretariado> secretariados = new ArrayList<Secretariado>();

        return secretariados;
    }

    public static Secretariado nuevoSecretariado() throws ParseException {

        Secretariado s;
        Scanner in = new Scanner(System.in);
        boolean correcto;

        do {
            Empleado e = Empleado.nuevoEmpleado();
            s = new Secretariado();

            System.out.println("Introduzca los años de experiencia:");
            int ae = in.nextInt();
            // i.setDuracion(ae);

            ArrayList<Informe> informes = new ArrayList();
            System.out.println("¿Quieres introducir los informes? ");
            boolean resp = Utilidades.leerBoleano();
            if (resp) {
                boolean resp2;
                do {
                    Informe i = Informe.nuevoInforme();
                    informes.add(i);
                    System.out.println("¿Quiere introducir otro informe?");
                    resp2 = Utilidades.leerBoleano();
                } while (resp2);
                s.setInformes(informes);
            }
            s = new Secretariado(e, ae, informes);
            System.out.println("El secretariado introducido es: " + s);
            System.out.println("¿Son correctos los datos del secreatriado?");
            correcto = Utilidades.leerBoleano();
        } while (!correcto);

        return s;
    }

    
    
    public boolean realizarInforme(Tratamiento t) {
        boolean ret = false;
        Scanner in = new Scanner(System.in);

        Informe nuevo = t.getInforme();
        System.out.println("Introduzca descripción del tratamiento:");
        String dtrat = in.nextLine();
        
        ArrayList<Secretariado> secres = nuevo.getSecretariados();
        secres.add(this);
        nuevo.setSecretariados(secres);
            
        
        ret=true;    
        t.setInforme(nuevo);
       return ret;
    }
;

}
