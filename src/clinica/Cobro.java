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
 * @author DAW106
 */
public class Cobro {
    
    protected long id;
    private double importeTotalEuros;
    private Date fechaFinalizacion;
    private ArrayList <Pago> pagos; 

    public Cobro() {
    }

    public Cobro(int idCobro, double importeTotalEuros, Date fechaFinalizacion) {
        this.id = idCobro;
        this.importeTotalEuros = importeTotalEuros;
        this.fechaFinalizacion = fechaFinalizacion;
    }
    
    public Cobro(Cobro c) {
        this.id=c.id;
        this.importeTotalEuros=c.getImporteTotalEuros();
        this.fechaFinalizacion=c.getFechaFinalizacion();
    }

    public long getIdCobro() {
        return id;
    }

    public void setIdCobro(int idCobro) {
        this.id = idCobro;
    }

    public double getImporteTotalEuros() {
        return importeTotalEuros;
    }

    public void setImporteTotalEuros(double importeTotalEuros) {
        this.importeTotalEuros = importeTotalEuros;
    }

    public Date getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(Date fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public ArrayList<Pago> getPagos() {
        return pagos;
    }

    public void setPagos(ArrayList<Pago> pagos) {
        this.pagos = pagos;
    }
   

    @Override
    public String toString() {
        return "Cobro{" + "idCobro=" + id + ", importeTotalEuros=" + importeTotalEuros + ", fechaFinalizacion=" + fechaFinalizacion + '}';
    }
    
    public String data() {
        return getIdCobro() + " | " + getImporteTotalEuros()+ " | " + getFechaFinalizacion();
    }
    public ArrayList<Cobro> getAllCobro (){
    ArrayList <Cobro> cobros = new ArrayList <Cobro>();
    return cobros;
    }
    public Cobro getCobroById (long id){
        Cobro c = new Cobro();
        return c;
    }
    
   public static Cobro nuevoCobro () throws ParseException{
       
    Cobro c = new Cobro();
    Scanner in = new Scanner(System.in);
       
    boolean correcto = false;
    do {
            
    //**importe total euros, fecha arraypagos        
         
    System.out.println("Importe total en euros: ");
    double importeTotalEuros = in.nextDouble();
    c.setFechaFinalizacion();
            
    System.out.println("Introduzca la fecha de finalizacion: ");
    Date fecha = Utilidades.leerFecha();
    c.setFechaFinalizacion();        
            
    ArrayList <Pago> pagos = new ArrayList();
    System.out.println("¿Cuantos pagos realizara? ");
    int num = Integer.parseInt(in.nextLine());
    for (int i=0; i<num;i++){
        
        System.out.println("Introduce numero de pagos");
        String cob= in.nextLine();
        
        Pago p = Pago.nuevoPago();
        pagos.add(p);
        }
    
        }
    while (!correcto);
    return c;
        }

    private void setFechaFinalizacion() {
           }
       
       
       
   }
   
