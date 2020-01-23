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
 * @version 3.1
 * @author AdrianSaveli
 */
public class Alergia {
    protected long id;//Es el identificador de las alergia.
    private String nombreAlergia;//Es el nombre de la alergia.Cadena de caracteres.
    private ArrayList<Historial> historiales;
    //Getters y setters

    public ArrayList<Historial> getHistoriales() {
        return historiales;
    }

    public void setHistoriales(ArrayList<Historial> historiales) {
        this.historiales = historiales;
    }
    
    public long getID() {
        return id;
    }

    public void setID(long ID) {
        this.id = ID;
    }

    public String getNombreAlergia() {
        return nombreAlergia;
    }

    public void setNombreAlergía(String nombreAlergía) {
        this.nombreAlergia = nombreAlergía;
    }
    //Constructor por defecto
    public Alergia() {
    }
    //Constructor con argumentos
    public Alergia(long ID, String nombreAlergía) {
        this.id = ID;
        this.nombreAlergia = nombreAlergía;
    }
    //Constructor de copia
    public Alergia (Alergia p) {
        this.nombreAlergia = p.getNombreAlergia();
        this.id = p.getID();
    }
    //Otros métodos sobreescritos
    @Override
    public String toString() {
        return "Alerg\u00eda{" + "ID=" + id + ", nombreAlerg\u00eda=" + nombreAlergia + '}';
    }
    public String data() {
        return ""+getID()+"|"+getNombreAlergia();
    }
    public ArrayList<Alergia> getAllAlergia (){
        
    ArrayList <Alergia> alergias = new ArrayList <Alergia>();
    
    return alergias;
    }
    
    public Alergia getAlergiaById (long id){
        Alergia a = new Alergia();
        /*Este método sirve para que posteriormente se busque el id dado
        y se obtengan los datos de aquella alergia que tenga ese id dado.
        Aunque si no existe ninguna alergia con ese id saldra null.  
        */ 
        return a;
    }
        public static Alergia nuevaAlergia () throws ParseException{
  
        Alergia a = new Alergia();
        Scanner in = new Scanner(System.in);
        boolean correcto;
        
        do{
            System.out.println("Introduzca el nombre de la alergia:");
             String nombre = in.nextLine();
            // i.setNombreAlergia(noma);
            
            ArrayList <Historial> historiales = new ArrayList();
            System.out.println("¿Quieres introducir los historiales que padezcan esta alergia? ");
            boolean resp = Utilidades.leerBoleano();
            if(resp){
               boolean resp2;
                do {
                   Historial h = Historial.nuevoHistorial();
                   historiales.add(h);
                   System.out.println("¿Quiere introducir otro historial?");
                   resp2 =Utilidades.leerBoleano();
                }
                while(resp2);
                a.setHistoriales (historiales);
            }
            System.out.println("La alergia introducida es: " + a);
            System.out.println("¿Es correcta la alergia?");
            correcto = Utilidades.leerBoleano();
        }
        while(!correcto);
        
     return a;   
    }   
}
