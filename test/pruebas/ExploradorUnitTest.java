/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import exploradormarte.Explorador;
import exploradormarte.Marte;
import exploradormarte.Orientacion;
import exploradormarte.Posicion;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author E205-1
 */
public class ExploradorUnitTest {
    
    @Test
    public void debeConfigurarLaCoordenadaEnElExplorador(){
        Explorador ex=new Explorador(new Posicion(1,2), Orientacion.N);
        Assert.assertEquals(ex.getX(),1 );
        Assert.assertEquals(ex.getY(), 2);
        Assert.assertEquals(Orientacion.N, ex.getOrientacion());
    }
    
    @Test
    public void debeAvanzarEnlaMismaOrintacion(){
        Explorador ex=new Explorador(new Posicion(1,2), Orientacion.N);
        Marte m=new Marte(7,6);
        ex.setMarte(m);
        ex.comando('A');
        Assert.assertEquals(ex.getX(),1 );
        Assert.assertEquals( ex.getY(),3);
        Assert.assertEquals(Orientacion.N, ex.getOrientacion());
    }
    
    @Test
    public void debeGirarALaDerecha(){
       Explorador ex=new Explorador(new Posicion(1,2), Orientacion.N);
       ex.girar('D');
       Assert.assertEquals(ex.getOrientacion(),Orientacion.E);
    }
    
     @Test
    public void debeGirarALaIzquierda(){
       Explorador ex=new Explorador(new Posicion(1,2), Orientacion.N);
       ex.girar('I');
       Assert.assertEquals(ex.getOrientacion(),Orientacion.W);
    }
     
     @Test(expectedExceptions = IllegalArgumentException.class)
    public void debeFallarAlGirar(){
       Explorador ex=new Explorador(new Posicion(1,2), Orientacion.N);
       ex.girar('X');
       Assert.assertEquals(ex.getOrientacion(),Orientacion.W);
    }
     
      @Test(expectedExceptions = IllegalArgumentException.class)
    public void debeFallarAvanzar(){
       Explorador ex=new Explorador(new Posicion(1,2), Orientacion.N);
       ex.comando('X');       
    }
      
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void debeRespetarElLimiteIzquiedo(){
       Explorador ex=new Explorador(new Posicion(0,2), Orientacion.W);
       ex.comando('A');
    }
    
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void debeRespetarElLimiteDerecho(){
       Explorador ex=new Explorador(new Posicion(7,2), Orientacion.E);
       Marte m=new Marte(7,6);
       ex.setMarte(m);
       ex.comando('A');
    }
    
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void debeRespetarElLimiteInferior(){
       Explorador ex=new Explorador(new Posicion(7,0), Orientacion.S);
       Marte m=new Marte(7,6);
       ex.setMarte(m);
       ex.comando('A');
    }
    
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void debeRespetarElLimiteSuperior(){
       Explorador ex=new Explorador(new Posicion(7,6), Orientacion.N);
       Marte m=new Marte(7,6);
       ex.setMarte(m);
       ex.comando('A');
    }
    
    @Test
    public void debeExplorarSegunInstrucciones(){
        Explorador ex=new Explorador(new Posicion(1,2), Orientacion.N);
       Marte m=new Marte(7,6);
       ex.setMarte(m);
        String comandos="IAIAIAIAA";
        ex.ejecutarComandos(comandos);
        Posicion p=ex.getPosicionFinal();
        Assert.assertEquals(p.getX(),1);
        Assert.assertEquals(p.getY(),3);
        Assert.assertEquals(p.getOrientacion(),Orientacion.N);
    }
    
}