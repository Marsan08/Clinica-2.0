/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * @version 1.0
 * @author DAW106
 */
public class Empleado{

    
    protected long id;
    private String nombre;
    private String apellido;
    private String telefono; 
    private String nif;
    private String direccion; //Direccion del empleado

    public Empleado() {
    }

    public Empleado( String nombre, String apellido, String telefono, String nif, String direccion) {
    
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.nif = nif;
        this.direccion= direccion;
    }
    
    public Empleado(Empleado e) {

        this.id=e.getId();

        this.nombre=e.getNombre();
        this.apellido=e.getApellido();
        this.telefono=e.getTelefono();
        this.nif=e.getNif();
        this.direccion=e.getDireccion();
        
    }


    public long getId() {

        return id;
    }


    public void setId(int id) {
        this.id = id;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Empleado{" + "idEmpleado=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono + ", nif=" + nif + ", direccion=" + direccion + '}';
    }
    
    public String data() {
      
        return getId() + " | " + getNombre() + " | " + getApellido() + " | " + getTelefono() + " | " + getNif() + " | " + getDireccion();
    }
    
    
    
    public ArrayList<Empleado> getAllCita (){
    ArrayList <Empleado> empleados = new ArrayList <Empleado>();
    return empleados ;
    }
    
    
    
    public Empleado getEmpleadoById (long id){
        Empleado e = new Empleado();
         return e;
    }
            public static Empleado nuevoEmpleado(){
     
        Empleado em = new Empleado();
        Scanner in = new Scanner(System.in);  
        
        boolean correcto;
        
        do{
        
        System.out.println("Introduzca el Nombre del empleado");
        String nombre = in.nextLine();
        em.setNombre(nombre);
        
        System.out.println("Introduzca el Apellido del empleado");
        String apellido = in.nextLine();
        em.setApellido(apellido);
        
        
        System.out.println("Introduzca el Telefono del empleado");
        String telefono = in.nextLine();
        em.setTelefono(telefono);
        
        System.out.println("Introduzca el NIF del empleado");
        String nif = in.nextLine();
        em.setNif(nif);
        
        System.out.println("Introduzca el Direccion del empleado");
        String direccion = in.nextLine();
        em.setDireccion(direccion);
        
        System.out.println("Estos son los datos del empleado:"+em);
        System.out.println("¿Los datos del empleado son correctos?");
        String correct = in.nextLine();
        correcto = Utilidades.leerBoleano();
        }
        while(!correcto);
        
        return em;

     }
}
