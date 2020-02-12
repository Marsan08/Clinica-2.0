/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica;

import excepciones.MedicacionException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * version 3.0
 *
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

    public Medicamento() {
    }

    public Medicamento(int idMedicamento, String nombre, String principioActivo, int dosisMaxDiaria) throws MedicacionException {
        this.id = idMedicamento;
        if (MedicacionException.validarNombre(nombre)) {
            this.nombre = nombre;
        } else {

        }
        this.principioActivo = principioActivo;
        this.dosisMaxDiaria = dosisMaxDiaria;
    }

    public Medicamento(Medicamento m) throws MedicacionException {
        this.id = m.getId();
        this.nombre = m.getNombre();

        this.principioActivo = m.getPrincipioActivo();
        this.dosisMaxDiaria = (int) m.getDosisMaxDiaria();
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

    public void setNombre(String nombre) throws MedicacionException {
        this.nombre = nombre;
    }

    public String getPrincipioActivo() {
        return principioActivo;
    }

    public void setPrincipioActivo(String principioActivo) throws MedicacionException {
        this.principioActivo = principioActivo;
    }

    public float getDosisMaxDiaria() {
        return dosisMaxDiaria;
    }

    public void setDosisMaxDiaria(int dosisMaxDiaria) throws MedicacionException {
        this.dosisMaxDiaria = dosisMaxDiaria;
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

    public String Data() {
        return getId() + " | " + getNombre() + " | " + getPrincipioActivo() + " | " + getDosisMaxDiaria();
    }

    public ArrayList<Medicamento> getAllMedicamento() {
        ArrayList<Medicamento> medicamentos = new ArrayList<Medicamento>();
        return medicamentos;
    }

    public Medicamento getMedicamentoById(long id) {
        Medicamento m = new Medicamento();
        return m;
    }

    public static Medicamento nuevoMedicamento() throws MedicacionException {

        Medicamento m = new Medicamento();
        Scanner in = new Scanner(System.in);
        boolean correcto;

        do {

            System.out.println("Introduzca el nombre del medicamento:");
            String nmed = in.nextLine();
            try {
                if (MedicacionException.validarNombre(nmed)) {
                    m.setNombre(nmed);
                }
            } catch (MedicacionException ex) {
                System.out.println("Se ha producido una MedicacionException con el nombre del medicamento." + ex.getMessage());
            }

            System.out.println("Introduzca el principio activo del medicamento: ");
            String prina = in.nextLine();
            m.setPrincipioActivo(prina);
            try {
                if (MedicacionException.validarPrincipioActivo(prina)) {
                    m.setPrincipioActivo(prina);
                }
             } catch (MedicacionException ex) {
                System.out.println("Se ha producido una MedicacionException con el principio activo del medicamento." + ex.getMessage());
            }

            System.out.println("Introduza la dosis maxima diaria en mg:");
            int dmaxd = in.nextInt();
            m.setDosisMaxDiaria(dmaxd);
            try {
                if (MedicacionException.validarDosisMaxDiaria(dmaxd)) {
                    m.setDosisMaxDiaria(dmaxd);
                }
             } catch (MedicacionException ex) {
                System.out.println("Se ha producido una MedicacionException con el principio activo del medicamento." + ex.getMessage());
            }

            System.out.println("Introduzca la alergia: ");
            Alergia alergia = Alergia.nuevaAlergia();
            String aler = in.nextLine();
            m.setAlergia(alergia);

            System.out.println("Los datos introducidos son: " + m);
            System.out.println("¿Son correctos los datos introducidos?");
            correcto = Utilidades.leerBoleano();
        } while (!correcto);

        return m;
    }


    private void setCita(ArrayList<Cita> citas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
