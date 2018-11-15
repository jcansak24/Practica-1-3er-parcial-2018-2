/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OrdenarPalabra;

import javax.swing.JFrame;


/**
 *
 * @author jimer.sayago
 */
public class Principal extends ventanaRegistro {

    //JFrame frame;
    ventanaRegistro vr;
    
    public Principal() {
        //frame = new JFrame("Practica 1");
        vr = new ventanaRegistro();
        vr.inicializar();
        
    }

    public static void main(String[] args) {
        Principal p = new Principal();
    }

    


}
