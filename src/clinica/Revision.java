/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica;
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
    //Son las anotaciones que se escriben en la revisión.Cadena de caracteres.
    
    //Getters y setters
    
    public String getAnotaciones() {
        return anotaciones;
    }

    public void setAnotaciones(String anotaciones) {
        this.anotaciones = anotaciones;
    }
    //Constructor por defecto
    public Revision() {
    super();
    }
    //Constructor con argumentos
    public Revision(Date fecha, char rangoHorario,String hora,boolean estado,String anotaciones) {
        super(fecha,rangoHorario,hora,estado);
        this.anotaciones = anotaciones;
    }
    //Constructor de copia
    public Revision (Revision p) {
        super(p);
        this.anotaciones = p.getAnotaciones();  
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
    
    public String data() {
        
        return super.data()+ "|"+getAnotaciones();
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
