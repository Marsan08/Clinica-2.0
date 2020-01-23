/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @version 4.0
 * @author AdrianSaveli
 */
public class Paciente {
    
    
    
    Historial historial;
    
    protected long id;//Es el identificador del paciente.
    
    private String nombre;//Es el nombre del paciente.Cadena de caracteres.
    private String apellidos;//Es el apellido del paciente.Cadena de caracteres.
    private String NIF;//Es la tarjeta de identidad del paciente.Cadena de caracteres.
    private String telefono;//Es el telefono de contacto del paciente.Cadena de caracteres.
    private String direccion;//Es la dirección de residencia del paciente.Cadena de caracteres.
    
    

    
    //Getters y setters

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

   
    //Constructor por defecto
    public Paciente() {
    }
    //Constructor con argumentos

    public Paciente(long idPaciente, String nombre, String apellidos, String NIF, String telefono, String direccion) {
        this.id = idPaciente;
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
        }
    //Otros métodos sobreescritos
    
    @Override
    public String toString() {
        return id + "Paciente{" + "ID" + ", nombre=" + nombre + ", apellidos=" + apellidos + ", NIF=" + NIF + ", telefono=" + telefono + ", direccion=" + direccion + '}';
    }
    
    public String data() {
        return ""+getId()+"|"+getNombre()+"|"+getApellidos()+"|"+getNIF()+"|"+getTelefono()+"|"+getDireccion();
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
        p.setNombre(nom);
        System.out.println("Dame el apellido:");
        ape=in.nextLine();
        p.setApellidos(ape);
        System.out.println("Dame el NIF:");
        nif=in.nextLine();
        p.setNIF(nif);
        System.out.println("Dame el telefono:");
        tel=in.nextLine();
        p.setTelefono(tel);
        System.out.println("Dame la dirección:");
        dir=in.nextLine();
        p.setDireccion(dir);
        System.out.println("¿Son correctos los datos del paciente?");
        
        correcto = Utilidades.leerBoleano();
        }
        while (!correcto);
        return p;
    }
}
