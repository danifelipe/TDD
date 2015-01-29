/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exploradormarte;

/**
 *
 * @author E205-1
 */
public class Posicion {
    
   private int x;
   private int y;
   private Orientacion orientacion;
    public Posicion(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    public Orientacion getOrientacion() {
        return orientacion;
    }
    
    public void setOrientacion(Orientacion o){
      this.orientacion=o;
    }
   
   
    
}
