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
 * version 2
 * @author DAW109
 */
public class Tratamiento {
 
    Informe informe;
    Paciente paciente;
    Cobro cobro;
    
    protected long id;
    //Identificador del tratamiento relacionado con el paciente TIENE QUE TENER VALOR MAYOR A CERO
    private String nombre;
    //Nombre del tratamiento Ej; Endodoncia... 
    private String fechaInicio;
    //Fecha de inicio del tratamiento pueden ser tratamientos de semanas... TIENE QUE TENER FORMATO DIA/MES/AÑO
    private boolean consentimiento;
    // Consentimiento del paciente al ser solo acepto o no se pone un boolean, OLO SE ACEPTAN VALORES DE VERDADERO (ACEPTA Y FALSO (NO ACEPTA)
    private ArrayList <Cita> citas;
    
    public Tratamiento() {
    }

    public Tratamiento(long id, String nombre, String fechaInicio, boolean consentimiento) {
        this.id = id;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.consentimiento = consentimiento;
    }
    
    public Tratamiento (Tratamiento t) {
        this.id = t.getId ();
        this.nombre = t.getNombre();
        this.fechaInicio = t.getFechaInicio();
        this.consentimiento = t.isConsentimiento();
       
    }

    public long getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public boolean isConsentimiento() {
        return consentimiento;
    }

    public void setConsentimiento(boolean consentimiento) {
        this.consentimiento = consentimiento;
    }

    public Informe getInforme() {
        return informe;
    }

    public void setInforme(Informe informe) {
        this.informe = informe;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Cobro getCobro() {
        return cobro;
    }

    public void setCobro(Cobro cobro) {
        this.cobro = cobro;
    }

    public ArrayList<Cita> getCitas() {
        return citas;
    }

    public void setCitas(ArrayList<Cita> citas) {
        this.citas = citas;
    }

    
    
    
    
    @Override
    public String toString() {
        return "Tratamiento{" + "idTratamiento=" + id + ", nombre=" + nombre + ", fechaInicio=" + fechaInicio + ", consentimiento=" + consentimiento + '}';
    }
     
    public String Data (){
     return getId() + " | " + getNombre() + " | " + getFechaInicio() + " | " + isConsentimiento ();
    }
    
    public ArrayList<Tratamiento> getAllTratamiento (){
    ArrayList <Tratamiento> tratamientos = new ArrayList <Tratamiento>();
    return tratamientos ;
    }
    
    public Tratamiento getTratamientoById (long id){
        Tratamiento t = new Tratamiento();
         return t;
    }
 
    public static Tratamiento nuevoTratamiento() throws ParseException{
            Tratamiento t = new Tratamiento();
            Scanner in = new Scanner(System.in);
            
            boolean correcto;
            
            do{
            
            System.out.println("Introduzca el paciente: ");
            Paciente paciente = Paciente.nuevoPaciente();
            String Paciente = in.nextLine();
            t.setPaciente(paciente);
            
            System.out.println("Introduzca el informe:");
            Informe informe = Informe.nuevoInforme();
            String Informe = in.nextLine();
            t.setInforme(informe);
        
           System.out.println("Introduzca el nombre del tratamiento:");
           String nom = in.nextLine();
           t.setNombre(nom);
           
           System.out.println("Introduzca la fecha de inicio del tratammiento");
           String fin =in.nextLine();
           t.setFechaInicio(fin);
           
           System.out.println(" ¿El paciente da el consentimiento?");
           char consentimiento;
           boolean consen = Utilidades.leerBoleano();
           
           if(consen){
               
               boolean consen2;
           
             do {
                
                System.out.println("Es necesario el consentimiento para realizar un tratamiento");
                consentimiento = in.nextLine().charAt(0);
                consen2 = Utilidades.leerBoleano();
                
            } while (!consen2);
             
             t.setConsentimiento(consen);

           }
           
                System.out.println("Introduzca el cobro del tratamiento:");
                Cobro cobro = Cobro.nuevoCobro();
                String Cobro = in.nextLine();
                t.setCobro(cobro);
           
              
                System.out.println("Los datos introducidos son: "+t);
                System.out.println("¿Son correctos los datos introducidos?");
                correcto = Utilidades.leerBoleano();
    
     }    while (!correcto);

    return t;
}

    private void setPaciente(String paciente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}


