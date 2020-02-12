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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @version 3.1
 * @author AdrianSaveli
 */
public class Pago {

    protected long id;//Es el identificador del pago.
    private Date fechadePago;//Es la fecha de la realización del pago por parte del paciente.
    private double importe;//Es el importe del pago.Solo son valores númericos.
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

    public void setImporte(Double importe) {
        this.importe = importe;

    }

    public double getImporte() {
        return importe;
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
    public Pago(long ID, Date FechaDePago, double importe, String MetodoDePago) throws PagoExcepcion {
        this.id = ID;
        this.fechadePago = FechaDePago;
        try {
            if (PagoExcepcion.validarImporte(importe)) {
                this.importe = importe;
            }

        } catch (PagoExcepcion ex) {
            System.out.println("Error al validar el importe del pago.");
        }

        try {
            if (PagoExcepcion.validarMetodoDePago(MetodoDePago)) {
                this.metododePago = MetodoDePago;
            }
        } catch (PagoExcepcion ex) {

            System.out.println("Error al valido el método de pago");
        }

    }

    //Constructor de copia
    public Pago(Pago p) {
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
        return "" + getID() + "|" + getFechaDePago() + "|" + getImporte() + "|" + getMetodoDePago();
    }

    public ArrayList<Pago> getAllPago() {
        ArrayList<Pago> pagos = new ArrayList<Pago>();
        return pagos;
    }

    public Pago getPagoById(long id) {
        Pago p = new Pago();
        /*Este método sirve para que posteriormente se busque el id dado
        y se obtengan los datos de aquel pago que tenga ese id dado.
        Aunque si no existe ningún pago con ese id saldra null.  
         */
        return p;
    }

    public static Pago nuevoPago() {
        Pago p = new Pago();
        Scanner in = new Scanner(System.in);
        boolean correcto;
        do {

            System.out.println("Introduzca la fecha del pago: ");
            Date fecha = Utilidades.leerFecha();
            p.setFechaDePago(fecha);

            System.out.println("Introduzca el importe del pago:");
            double importe;
            importe = in.nextDouble();
            try {
                if (!excepciones.PagoExcepcion.validarImporte(importe)) {
                    p.setImporte(importe);
                }
                System.out.println("Introduzca el método de pago: ");
                String metp = in.nextLine();
                if (!excepciones.PagoExcepcion.validarMetodoDePago(metp)) {
                    p.setMetodoDePago(metp);
                }

            } catch (PagoExcepcion ex) {
                Logger.getLogger(Pago.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println("La pago introducido es: " + p);
            System.out.println("¿Es correcto el pago?");
            correcto = Utilidades.leerBoleano();

        } while (!correcto);

        return p;
    }

}
