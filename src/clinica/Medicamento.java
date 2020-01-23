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
 * version 3.0
 * @author DAW109
 */
public class Medicamento {
    
    Alergia alergia;
    
    protected long id;
    //Identificador del medicamento. VALOR SUPERIOR A CERO
    private String nombre;
    // Nombre del medicamento por ejemplo, aspirina... 
    private String principioActivo;
    // Principio activo del medicamento
    private int dosisMaxDiaria;
    // Dosis máxima diaria en mg puesto, por tanto tiene que ser un int porque debe ser un numero entero, NO PUEDE SER VALOR 0
    private ArrayList<Cita> citas;
    
    public Medicamento() {
    }

    public Medicamento(int idMedicamento, String nombre, String principioActivo, int dosisMaxDiaria) {
        this.id = idMedicamento;
        this.nombre = nombre;
        this.principioActivo = principioActivo;
        this.dosisMaxDiaria = dosisMaxDiaria;
    }

    public Medicamento (Medicamento m){
        this.id = m.getId();
        this.nombre = m.getNombre();
        this.principioActivo = m.getPrincipioActivo ();
        this.dosisMaxDiaria= (int) m.getDosisMaxDiaria();
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

    public String getPrincipioActivo() {
        return principioActivo;
    }

    public void setPrincipioActivo(String principioActivo) {
        this.principioActivo = principioActivo;
    }

    public float getDosisMaxDiaria() {
        return dosisMaxDiaria;
    }

    public void setDosisMaxDiaria(int dosisMaxDiaria) {
        this.dosisMaxDiaria = dosisMaxDiaria;
    }

    public ArrayList<Cita> getCitas() {
        return citas;
    }

    public void setCitas(ArrayList<Cita> citas) {
        this.citas = citas;
    }

    public Alergia getAlergia() {
        return alergia;
    }

    public void setAlergia(Alergia alergia) {
        this.alergia = alergia;
    }
    
   

    @Override
    public String toString() {
        return "Medicamento{" + "idMedicamento=" + id + ", nombre=" + nombre + ", principioActivo=" + principioActivo + ", dosisMaxDiaria=" + dosisMaxDiaria + '}';
    }
    
    public String Data (){
        return getId() + " | " + getNombre() + " | " + getPrincipioActivo() + " | " + getDosisMaxDiaria();
    }
    
    
    public ArrayList<Medicamento> getAllMedicamento (){
    ArrayList <Medicamento> medicamentos = new ArrayList <Medicamento>();
    return medicamentos ;
    }
    
    
    public Medicamento getMedicamentoById (long id){
        Medicamento m = new Medicamento();
         return m;
    }
    
    
    public static Medicamento nuevoMedicamento() throws ParseException{
        
        Medicamento m = new Medicamento();
        Scanner in = new Scanner (System.in);
        boolean correcto;
       
        do {
            //*nombre principioActivo DosisMaxDairia
            System.out.println("Introduzca el nombre del medicamento:");
            String nmed = in.nextLine();
            m.setNombre (nmed);
            
            System.out.println("Introduzca el principio activo del medicamento: ");
            String prina = in.nextLine();
            m.setPrincipioActivo(prina);
            
            System.out.println("Introduza la dosis maxima diaria en mg:");
            String dmaxd = in.nextLine();
            m.setDosisMaxDiaria(dmaxd);
            
            ArrayList <Cita> citas = new ArrayList();
            System.out.println("¿Quieres introducir el numero de citas? ");
            boolean resp = Utilidades.leerBoleano();
            if(resp){
               boolean resp2;
                do {
                   Cita c = Cita.nuevoCita();
                   citas.add(c);
                   System.out.println("¿Quiere introducir otra cita?");
                   resp2 =Utilidades.leerBoleano();
                }
                while(resp2);    
                
                m.setCita (citas);
            }
            
            System.out.println("Introduzca la alergia: ");
            Alergia alergia = Alergia.nuevaAlergia();
            String aler = in.nextLine();
            m.setAlergia(alergia);
            
            System.out.println("Los datos introducidos son: "+m);
            System.out.println("¿Son correctos los datos introducidos?");
            correcto = Utilidades.leerBoleano();
        }
        while (!correcto);
        
        
        return m;
    }

    private void setDosisMaxDiaria(String dmaxd) {
        
    }

    private void setCita(ArrayList<Cita> citas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
