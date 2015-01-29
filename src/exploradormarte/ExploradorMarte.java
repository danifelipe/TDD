/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exploradormarte;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author E205-1
 */
public class ExploradorMarte {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Lector l=new Lector("C:/Users/E205-1/Documents/sii/juegoRela.txt");
            Posicion limite=l.getLimiteSuperior();
            Marte m=new Marte(limite.getX(), limite.getY());
            while(l.readNextExplorador()){
               Posicion inicial=l.getOrientacion();
               Explorador ex=new Explorador(inicial, inicial.getOrientacion());
               ex.setMarte(m);
               ex.ejecutarComandos(l.getComandos());
               
               Posicion finalp=ex.getPosicionFinal();
                System.out.println(finalp.getX()+" "+finalp.getY()+" "+finalp.getOrientacion());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExploradorMarte.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ExploradorMarte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
