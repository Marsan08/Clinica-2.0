/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica;

import excepciones.PacienteException;
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
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @version 4.0
 * @author AdrianSaveli
 */
public class Paciente {
    
    
    

    protected long id;//Es el identificador del paciente.
    
    private String nombre;//Es el nombre del paciente.Cadena de caracteres.
    private String apellidos;//Es el apellido del paciente.Cadena de caracteres.
    private String NIF;//Es la tarjeta de identidad del paciente.Cadena de caracteres.
    private String telefono;//Es el telefono de contacto del paciente.Cadena de caracteres.
    private String direccion;//Es la dirección de residencia del paciente.Cadena de caracteres.
    Historial historial;
    long idHistorial;
    
    public long getIdHistorial() {    
        return idHistorial;
    }

    //Getters y setters
    public void setIdHistorial(long idHistorial) {    
        this.idHistorial = idHistorial;
    }

    public long getId() {
        return id;
    }

    public void setId(long idPaciente) {
        this.id = idPaciente;
    }
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    //Los 4 métodos de lectura y escritura.
    public static ArrayList<Paciente> fromTextFile (String path) {
        ArrayList<Paciente> ret = new ArrayList<>();
        File fichero = new File(path);
        FileReader lector = null;
        BufferedReader buffer = null ;
        try {
            try {
                lector = new FileReader(fichero);
                buffer = new BufferedReader(lector);
                String linea;
                while((linea=buffer.readLine())!=null){
                    String[] campos = linea.split("|");
                    long id = Long.parseLong(campos[0]);
                    String nombre = campos[1];
		    String apellido = campos[2];
		    String NIF = campos[1];
                    String telefono = campos[2];
		    String direccion = campos[1];
                    Paciente p = new Paciente(id,nombre,apellido,NIF, telefono,direccion);
                    ret.add(p);                   
                }
            }finally{
                if(buffer!=null)
                    buffer.close();
                if(lector!=null)
                    lector.close();
            }
        }
        catch(PacienteException p){
            System.out.println("Se ha producido una ClienteException");
        }
        catch(FileNotFoundException p){
            System.out.println("Se ha producido una FileNotFoundException");
        }
        catch(IOException p){
            System.out.println("Se ha producido una IOException");
        }

        return ret;
    }
     public static ArrayList<Paciente> fromBinaryFile (String path) {
        ArrayList<Paciente> ret = new ArrayList<>();
        FileInputStream lector = null;
        ObjectInputStream lectorObjeto = null;
        try{
            try{
                lector = new FileInputStream(path);
                lectorObjeto = new ObjectInputStream(lector);
                Paciente p;
                while((p = (Paciente)lectorObjeto.readObject())!=null)
                    ret.add(p);
            }finally{
                if(lector!=null)
                    lector.close();
                if(lectorObjeto!=null)
                    lectorObjeto.close();
            }
        }

        catch(FileNotFoundException e){
            System.out.println("Se ha producido una FileNotFoundException");
        }
        catch(IOException p){
            System.out.println("Se ha producido una IOException");
        }
                catch(ClassNotFoundException p){
            System.out.println("Se ha producido una ClassNotFoundException");
        }

        return ret;
    }
    
    
 public void toTextFile (String path){
        File fichero = new File(path);
        FileWriter escritor = null;
        PrintWriter buffer = null ;
        try {
            try {
                escritor = new FileWriter(fichero);
                buffer = new PrintWriter(escritor);
                buffer.println(this.data());
            }finally{
                if(buffer!=null)
                    buffer.close();
                if(escritor!=null)
                    escritor.close();
            }
        }
        catch(FileNotFoundException p){
            System.out.println("Se ha producido una FileNotFoundException");
        }
        catch(IOException p){
            System.out.println("Se ha producido una IOException");
        }
        catch(Exception p){
            System.out.println("Se ha producido una Exception");
        }
    }

    public void toBinaryFile (String path) {
        FileOutputStream escritor = null;
        ObjectOutputStream escritorObjeto = null;
        try{
            try{
                escritor = new FileOutputStream(path);
                escritorObjeto = new ObjectOutputStream(escritor);
                escritorObjeto.writeObject(this);
            }finally{
                if(escritor!=null)
                    escritor.close();
                if(escritorObjeto!=null)
                    escritorObjeto.close();
            }
        }
        catch(FileNotFoundException p){
            System.out.println("Se ha producido una FileNotFoundException");
        }
        catch(IOException p){
            System.out.println("Se ha producido una IOException");
        }
        catch(Exception p){
            System.out.println("Se ha producido una Exception");
        }
    }
   
    //Constructor por defecto
    public Paciente() {
    }
    //Constructor con argumentos

    public Paciente(long idPaciente, String nombre, String apellidos, String NIF, String telefono, String direccion) throws PacienteException {
        this.id = idPaciente;
        
        try{
        if (PacienteException.validarNombre(nombre)) this.nombre = nombre; 
        }
        catch(PacienteException ex){
            System.out.println("Error al validar el nombre del paciente." + ex.getMessage());
        }
        
        try{
        if (PacienteException.validarApellido(apellidos)) this.apellidos = apellidos;
        }
        catch (PacienteException ex){
             System.out.println("Error al validar el apellido del paciente." + ex.getMessage());
        }
        
        try{
        if (PacienteException.validarNif(NIF)) this.NIF = NIF;
        }
        catch (PacienteException ex){
            System.out.println("Error al validar el NIF del paciente." + ex.getMessage());
        }
        
        try{
        if (PacienteException.validarTelefono(telefono)) this.telefono = telefono;
        }
        catch (PacienteException ex){
            System.out.println("Error al validar el telefono del paciente." + ex.getMessage());
        }
        this.direccion = direccion;
    }

    public Paciente(Historial historial, long idHistorial, long id, String nombre, String apellidos, String NIF, String telefono, String direccion) {
        this.historial = historial;
        this.idHistorial = idHistorial;
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.NIF = NIF;
        this.telefono = telefono;
        this.direccion = direccion;
        
    }


   
    //Constructor de copia
   public Paciente (Paciente p) {
        this.id = p.getId();
        this.nombre = p.getNombre();
        this.apellidos = p.getApellidos();
        this.NIF = p.getNIF();
        this.telefono = p.getTelefono();
        this.direccion = p.getDireccion();
        this.idHistorial = p.getIdHistorial();
        
        }
    //Otros métodos sobreescritos
    
    @Override
    public String toString() {
        return id + "Paciente{" + "ID" + ", nombre=" + nombre + ", apellidos=" + apellidos + ", NIF=" + NIF + ", telefono=" + telefono + ", direccion=" + direccion + '}';
    }
    
    public String data() {
        return ""+getId()+"|"+getNombre()+"|"+getApellidos()+"|"+getNIF()+"|"+getTelefono()+"|"+getDireccion()+"|"+getIdHistorial();
    }

    

    public ArrayList<Paciente> getAllPaciente (){
    ArrayList <Paciente> pacientes = new ArrayList <Paciente>();
    return pacientes;
    }
    
    public Paciente getPacienteById (long id){
        Paciente p = new Paciente();
        /*Este método sirve para que posteriormente se busque el id dado
        y se obtengan los datos de aquel paciente que tenga ese id dado.
        Aunque si no existe ningún paciente con ese id saldra null.  
        */ 
        return p;
    }
    
    
    public static Paciente nuevoPaciente (){
        Paciente p = new Paciente();
        Scanner in= new Scanner(System.in);
        
        boolean correcto;
        do{
            
        String nom,ape,nif,tel,dir;
        System.out.println("Dame el nombre:");
        nom=in.nextLine();
        
        try{
            if(!excepciones.PacienteException.validarNombre(nom)){
        p.setNombre(nom);    
            }
            
         System.out.println("Dame el apellido:");
        ape=in.nextLine();
        
        if(!excepciones.PacienteException.validarApellido(ape)){
        p.setApellidos(ape);
        }
        
        System.out.println("Dame el NIF:");
        nif=in.nextLine();
  
        
        if(!excepciones.PacienteException.validarNif(nif)) {
        p.setNIF(nif);  
            
        }
        System.out.println("Dame el telefono:");
        tel=in.nextLine();
        
         if(!excepciones.PacienteException.validarTelefono(tel)){
         
         p.setTelefono(tel);
        }
       
        } catch (PacienteException ex){
            System.out.println("PacienteException: " +ex.getMessage());
        }
        
        System.out.println("Dame la dirección:");
        dir=in.nextLine();
        p.setDireccion(dir);
        
        System.out.println("¿Son correctos los datos del paciente?");
        
        correcto = Utilidades.leerBoleano();
        }
        while (!correcto);
        
        return p;
    }
    
    
    
    //Caso de uso REALIZAR PAGO hecho por Mar Santin.
    
    public boolean realizarPago (Tratamiento t){
        
        Scanner in = new Scanner (System.in);
        
        Cobro c = t.getCobro();
        
        Double importePagado= 0.0;
        
        ArrayList<Pago> pagos= c.getPagos();
        
        for (Pago p: pagos){
            
            importePagado += p.getImporte();
            
        }
        
        if (importePagado < c.getImporteTotalEuros()){
            
            System.out.println("El importe total del tratamiento todavía no ha sido abonado, por favor introduzca un nuevo pago.");
            double npago = in.nextDouble();
            c.setPagos(npago);
        
            pagos.add(Pago.nuevoPago());
            
        }
        
        return true;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
