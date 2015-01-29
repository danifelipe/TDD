/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import exploradormarte.Lector;
import exploradormarte.Orientacion;
import exploradormarte.Posicion;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author E205-1
 */
public class LectorTest {
    
    @Test
    public void probarLecturaPrimerLinea() throws IOException{
        Lector l=new Lector("juego.txt"); 
        Posicion limite=l.getLimiteSuperior();
        Assert.assertTrue(limite.getX()>0);
        Assert.assertTrue(limite.getY()>0);
    }
    
    @Test
    public void pruebaLaConstruccionDelLector() throws FileNotFoundException{
       Lector l=new Lector("juego.txt");        
    }
    
    @Test
    public void pruebaleerOrientacion() throws FileNotFoundException, IOException{
       Lector l=new Lector("C:/Users/E205-1/Documents/sii/juego.txt"); 
       l.readNextExplorador();
       Posicion p=l.getOrientacion();
       Assert.assertEquals(p.getX(),2);
       Assert.assertEquals(p.getY(),2);
       Assert.assertEquals(p.getOrientacion(), Orientacion.N);
    }
    
    @Test
    public void pruebaleerComandos() throws FileNotFoundException, IOException{
       Lector l=new Lector("C:/Users/E205-1/Documents/sii/juego.txt"); 
       l.readNextExplorador();
       String s=l.getComandos();
       Assert.assertEquals(s,"IAIIAAA");
    }
    
}
