/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exploradormarte;

/**
 *
 * @author E205-1
 */
public class Marte {

    private int x;
    private int y;
    
    public Marte(int x, int y) {
        if(x<0||y<0) throw new IllegalArgumentException("Las coordenadas No pueden se negativas");
        this.x=x;
        this.y=y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
    
}
