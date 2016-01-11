/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entradas;

import javax.swing.UIManager;

/**
 *
 * @author pc
 */
public class Entradas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

     try {
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
	} catch (Exception e) {
	}

     //new Thread(new splash()).start();
    new registros().principal();
 }
}


