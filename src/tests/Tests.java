/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import java.io.IOException;

/**
 *
 * @author david
 */
public class Tests {

    /**
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        javafreechart demo = new javafreechart("Comparison", "Which operating system are you using?");
        demo.pack();
        demo.setVisible(true);
    }
}
