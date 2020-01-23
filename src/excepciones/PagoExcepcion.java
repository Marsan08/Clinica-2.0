/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

/**
 *
 * @author DAW109
 */
public class PagoExcepcion extends Exception {
    
    public PagoExcepcion(String msj){
        super(msj);
    }
}
