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
public class Cita {

    protected long id;
    private Date fecha;
    private char rangoHorario;
    private String hora;
    private boolean estado;

    public Cita() {
    }

    public Cita(Date fecha, char rangoHorario, String hora, boolean estado) {

        this.fecha = fecha;
        this.rangoHorario = rangoHorario;
        this.hora = hora;
        this.estado = estado;
    }

    public Cita(Cita c) {
        this.id = c.getId();
        this.fecha = c.getFecha();
        this.rangoHorario = c.getRangoHorario();
        this.hora = c.getHora();
    }

    public long getId() {
        return id;
    }

    public void setId(int idCita) {
        this.id = idCita;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public char getRangoHorario() {
        return rangoHorario;
    }

    public void setRangoHorario(char rangoHorario) {
        this.rangoHorario = rangoHorario;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Cita{" + "idCita=" + id + ", fecha=" + fecha + ", rangoHorario=" + rangoHorario + ", hora=" + hora + '}';
    }

    public String data() {
        return getId() + " | " + getFecha() + " | " + getRangoHorario() + " | " + getHora();

    }

    public ArrayList<Cita> getAllCita() {
        ArrayList<Cita> citas = new ArrayList<Cita>();
        return citas;
    }

    public Cita getCitaById(long id) {
        Cita c = new Cita();
        return c;
    }

    public static Cita nuevoCita() throws ParseException {
        Cita c = new Cita();
        boolean correcto;
        do {

            System.out.println("Introduzca la fecha de la cita: ");
            Date fecha = Utilidades.leerFecha();
            c.setFecha(fecha);

            System.out.println("Introduzca el rango horario de la cita 'm' o 't':  ");
            char rango;
            Scanner in = new Scanner(System.in);
            do {
                System.out.println("Introduzca solo 'm' para las mañanas o 't' para las tardes.");
                rango = in.nextLine().charAt(0);

            } while (rango != 'm' && rango != 't' && rango != 'M' && rango != 'T');

            c.setRangoHorario(rango);

            System.out.println("Introduzca la hora de la cita: ");
            String hora = in.nextLine();
            c.setHora(hora);

            System.out.println("¿Es urgente la cita? (s/n)");
            boolean urgente = Utilidades.leerBoleano();
            c.setEstado(urgente);

            System.out.println("La cita introducida es: " + c);
            System.out.println("¿Es correcta la cita?");
            correcto = Utilidades.leerBoleano();

        } while (!correcto);

        return c;
    }

}
