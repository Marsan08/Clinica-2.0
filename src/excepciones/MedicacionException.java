/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

/**
 *
 * @author DAW110
 */
public class MedicacionException extends Exception {

    public MedicacionException(String mnsj) {
        super(mnsj);
    }

    public static boolean validarNombre(String nombre) throws MedicacionException {
        boolean nombreValido = false;
        if (nombre.isEmpty()) {
            nombreValido = false;
            throw new MedicacionException("El nombre esta vacio");
        }

        
        
        nombreValido=true;
        return nombreValido;

    }

}
