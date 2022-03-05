/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jhospital;

import jhospital.view.TelaPrincipal;

/**
 *
 * @author 
 */
public class JHospital {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TelaPrincipal telaPrincipal = new TelaPrincipal();
        telaPrincipal.validate();
        telaPrincipal.pack();
        telaPrincipal.setVisible(true);
    }
}
