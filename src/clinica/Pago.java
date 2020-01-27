/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica;
import excepciones.PagoExcepcion;
import java.text.ParseException;
import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * @version 3.1
 * @author AdrianSaveli
 */
public class Pago {
    
    protected long id;//Es el identificador del pago.
    private Date fechadePago;//Es la fecha de la realización del pago por parte del paciente.
    private double importe ;//Es el importe del pago.Solo son valores númericos.
    private String metododePago;//Es el método por el cual se efectua el pago (Transferencia,efectivo,...).
    Paciente paciente;//Paciente es el que realiza el pago.
    //Getters y setters
    
    public long getID() {
        return id;
    }

    public void setID(long ID) {
        this.id = ID;
    }

    public Date getFechaDePago() {
        return fechadePago;
    }

    public void setFechaDePago(Date fechaDePago) {
        this.fechadePago = fechaDePago;
    }

    public int getImporte() {
        return (int) importe;
    }

    public void setImporte(int importe) {
        this.importe = importe;
    }

    public String getMetodoDePago() {
        return metododePago;
    }

    public void setMetodoDePago(String métodoDePago) {
        this.metododePago = métodoDePago;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    
   //Constructor por defecto
    public Pago() {
    }
    //Constructor con argumentos
    public Pago(long ID, Date FechaDePago, int Importe, String MetodoDePago) {
        this.id = ID;
        this.fechadePago = FechaDePago;
        this.importe = Importe;
        this.metododePago = MetodoDePago;
    }
    //Constructor de copia
      public Pago (Pago p) {
        this.id = p.getID();
        this.fechadePago = p.getFechaDePago();
        this.importe = p.getImporte();
        this.metododePago = p.getMetodoDePago();
        }

    @Override
    public String toString() {
        return "Pago{" + "ID=" + id + ", fechaDePago=" + fechadePago + ", importe=" + importe + ", m\u00e9todoDePago=" + metododePago + '}';
    }
    
    public String data() {
        return ""+getID()+"|"+getFechaDePago()+"|"+getImporte()+"|"+getMetodoDePago();
    }
    
    
    public ArrayList<Pago> getAllPago (){
    ArrayList <Pago> pagos = new ArrayList <Pago>();
    return pagos;
    }
    
   
    public Pago getPagoById (long id){
        Pago p = new Pago();
        /*Este método sirve para que posteriormente se busque el id dado
        y se obtengan los datos de aquel pago que tenga ese id dado.
        Aunque si no existe ningún pago con ese id saldra null.  
        */ 
        return p;
    }
    public static Pago nuevoPago() throws  ParseException, excepciones.PagoExcepcion{
        Pago p = new Pago();
        Scanner in = new Scanner(System.in);
        boolean correcto;
        do {

            System.out.println("Introduzca la fecha del pago: ");
            Date fecha = Utilidades.leerFecha();
            p.setFechaDePago(fecha);

            System.out.println("Introduzca el importe del pago:");
            double importe = 0 ;
            String importe2 = Double.toString(importe);
            importe = in.nextInt();
            p.setImporte(importe);
           
            
            for (int i=0; i<importe2.length(); i++){
                    
            char b =importe2.charAt(i);
            
            if(Character.isLetter(b)){
                
            }
            throw new excepciones.PagoExcepcion("No se permiten letras en el importe de pago.");
             }
            int timporte = importe2.length();
            
            if(timporte <=-1){
            throw new excepciones.PagoExcepcion("No se puede crear un importe de pago negativo.");
            
            }
            
            
           
            System.out.println("Introduzca el método de pago: ");
            String metp = in.nextLine();
            p.setMetodoDePago(metp);
            
            for (int i=0; i<metp.length(); i++){
                    
            char c =metp.charAt(i);
            
            if(Character.isDigit(c)){
            throw new excepciones.PagoExcepcion("No se permiten digitos en el método de pago.");
             }
            int tamaniometp=metp.length();
            if(tamaniometp<2){
            throw new excepciones.PagoExcepcion("El nombre de metodo de pago es demasiado corto");
            }
            if(tamaniometp>10){
            throw new excepciones.PagoExcepcion("El nombre de metodo de pago es demaiado largo");
            }
            }

  
            System.out.println("La pago introducido es: " + p);
            System.out.println("¿Es correcto el pago?");
            correcto = Utilidades.leerBoleano();

        } while (!correcto);

        return p;
    }

    private void setImporte(double importe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
