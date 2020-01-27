/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica;
import excepciones.PacienteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author DAW109
 */
public class Utilidades {
    
    public static Date leerFecha() throws ParseException{
        Scanner in = new Scanner (System.in);    
        System.out.println("Escriba la fecha en formato dd/MM/yyyy");
        String fechaComoTexto = in.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha = sdf.parse(fechaComoTexto);
        return fecha;
    }
    
    public static boolean leerBoleano(){
        Scanner in = new Scanner(System.in);
        char c;
        do {
           System.out.println("Introduzca solo 's' o 'n'.");
           c = in.nextLine().charAt(0);
            
        } while (c!= 's'&& c!= 'n'&& c!='S'&& c!='N');
        
        if (c=='s'||c=='S'){
            
            return true;
        }
        else {
            
            return false;
        }
        
    }
    public final Paciente PACIENTES[] = {
        new Paciente(1, "Luis", "Gijon Mondragon", "455566T", "942779900","C/Menor Mallorca 45667"),
        new Paciente(2, "Ana", "Fervias Baixas", "764898U", "912331188","C/Ulises Huelva 32457"),
        new Paciente(3, "Bruno", "Barcelona Puig", "899322T", "932432245","C/Mayor Bilbao 40899"),
        new Paciente(4, "Carla", "Ramirez Dieguez", "0949384Z", "975073211", "C/Percebe Ourense 40978"),
        new Paciente(5, "Ramona", "Perez Montoya", "223832Y", "942779900","C/Andorra Valencia 85627")
    };
    
    
    
    //Caso de uso REGISTRAR PACIENTE hecho por Alberto
    public static void registraPaciente (Paciente p) throws PacienteException { 
    
//        Paciente p = new Paciente();
//        Scanner in= new Scanner(System.in);  
        

        String nombre = "";
        String apellidos = "";
        String NIF = "";
        String telefono = "";
        String direccion = "";
        
        
        //NOMBRE       
        System.out.println("Nombre:");
        nombre= p.getNombre(); //in.nextLine();
        for (int i=0;i<nombre.length();i++){
        char c=nombre.charAt(i);
        if(Character.isDigit(c)){
            throw new PacienteException("No se permiten digitos en el nombre");
        }       
        int tamanhoNombre=nombre.length();
        if(tamanhoNombre<2){
            throw new PacienteException("Demasiado corto");
        }
            if(tamanhoNombre>10){
            throw new PacienteException("Demasiado largo");      
            }
        }   
        
        
        //APELLIDO
        System.out.println("Apellido:");
        apellidos=p.getApellidos();// in.nextLine();
        for (int i=0;i<apellidos.length();i++){
        char c=apellidos.charAt(i);
        if(Character.isDigit(c)){
            throw new PacienteException("No se permiten digitos en el apellido");
        }
        }
        p.setApellidos(apellidos); 
        
                      
        //NIF
        System.out.println("NIF:");
        NIF=p.getNIF();//in.nextLine();
        for (int i=0;i<NIF.length()-1;i++){
        char c=NIF.charAt(i);
        if(Character.isLetter(c)){
            throw new PacienteException("No se permiten letras en el NIF");
        }
        int tamanhoNIF=NIF.length();
        if(tamanhoNIF>9){
            throw new PacienteException("Demasiado largo");
        }
        if(tamanhoNIF<9){
            throw new PacienteException("Demasiado corto");
        }
        }
        p.setNIF(NIF);  
        
        
        //TELEFONO
        System.out.println("Telefono:");
        telefono=p.getTelefono();//in.nextLine();
        for (int i=0;i<telefono.length();i++){
        char c=telefono.charAt(i);
        if(Character.isLetter(c)){
            throw new PacienteException("No se permiten letras en el telefono");
        }
        int tamanhoTelefono=telefono.length();
        if(tamanhoTelefono>9){
            throw new PacienteException("Demasiado largo");
        }
        if(tamanhoTelefono<9){
            throw new PacienteException("Demasiado corto");
        }
        }
        p.setTelefono(telefono); 
        

        //DIRECCION
        System.out.println("Direccion:");
        direccion=p.getDireccion();//in.nextLine();       
        p.setDireccion(direccion);
            
    }
   public void registraPaciente(String nombre,String apellidos,String nif, String tlf, String dir) {

            //Paciente p=new Paciente(nombre,apellidos,nif,tlf,dir);
            //System.out.println(p.toString());
}
    
}
