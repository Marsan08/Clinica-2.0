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
 * @version 2.0
 * @author AdrianSaveli
 */
public class Secretariado extends Empleado{
    private int añosExperiencia;//Son los años de experiencia del secretariado.Debe ser un número determinado.
    private ArrayList<Informe> informes;
    Cita cita;
    //Getters y setters

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
    //Constructor por defecto
    public Secretariado() {
        super();
    }
    //Constructor con argumentos
    public Secretariado(String nombre, String apellido, String telefono, String nif, String direccion) {
        super(nombre, apellido, telefono, nif, direccion);
        this.añosExperiencia = añosExperiencia;
    }
    //Constructor de copia
    public Secretariado (Secretariado p) {
        super(p);
        this.añosExperiencia = p.getAñosExperiencia();
      
    }
    
    public Secretariado (Empleado e, int añosExperiencia) {
        super (e);
        this.añosExperiencia= añosExperiencia;
    }
    public Secretariado (Empleado e, int añosExperiencia,ArrayList<Informe>informes) {
        super (e);
        this.añosExperiencia= añosExperiencia;
    }
    //Otros métodos sobreescritos
    @Override
    public String toString() {
        return super.toString()+ "Secretariado{" + "a\u00f1osExperiencia=" + añosExperiencia + '}';
    }
    
    
    @Override
     public String data() {
        return super.data()+""+getAñosExperiencia();
    }
     
     
    public Secretariado getSecretariadoById (long id){
        Secretariado s = new Secretariado();
        /*Este método sirve para que posteriormente se busque el id dado
        y se obtengan los datos de aquel secretariado que tenga ese id dado.
        Aunque si no existe ningún secretariado con ese id saldra null.  
        */ 
         return s;
    }
    
   public ArrayList<Secretariado> getAllSecretariado(){
       
       ArrayList<Secretariado> secretariados = new ArrayList<Secretariado>();
       
       return secretariados;
   }
       public static Secretariado nuevoSecretariado () throws ParseException{
  
        Secretariado s;
        Scanner in = new Scanner(System.in);
        boolean correcto;
        
        do{
            Empleado e = Empleado.nuevoEmpleado();
            s = new Secretariado();
            
            System.out.println("Introduzca los años de experiencia:");
            int ae = in.nextInt();
            // i.setDuracion(ae);
            
            ArrayList <Informe> informes = new ArrayList();
            System.out.println("¿Quieres introducir los informes? ");
            boolean resp = Utilidades.leerBoleano();
            if(resp){
               boolean resp2;
                do {
                   Informe i = Informe.nuevoInforme();
                   informes.add(i);
                   System.out.println("¿Quiere introducir otro informe?");
                   resp2 =Utilidades.leerBoleano();
                }
                while(resp2);    
                s.setInformes (informes);
            }
            s = new Secretariado(e,ae, informes);
            System.out.println("El secretariado introducido es: " + s);
            System.out.println("¿Son correctos los datos del secreatriado?");
            correcto = Utilidades.leerBoleano();
        }
        while(!correcto);
        
     return s;   
    } 
    
     
    
}
