/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exploradormarte;

import static exploradormarte.Orientacion.E;
import static exploradormarte.Orientacion.N;
import static exploradormarte.Orientacion.S;
import static exploradormarte.Orientacion.W;

/**
 *
 * @author E205-1
 */
public class Explorador {

    Posicion posicion;
    Orientacion orientacion;
    private Marte marte;
    
    public Explorador(Posicion posicion, Orientacion orientacion) {
       this.posicion=posicion;
        this.orientacion=orientacion;
    }

    public int getX() {
       return this.posicion.getX();
    }

    public int getY() {
        return this.posicion.getY();
    }

    public Orientacion getOrientacion() {
       return this.orientacion;
    }

    public void comando(char c) {
        switch(c){
            case 'A':
                switch(this.orientacion){
                    case N:
                        if(this.getY()==this.marte.getY())
                           throw new IllegalArgumentException("Limite Superior Alcanzado");   
                        else
                           this.posicion.setY(this.posicion.getY()+1);
                        break;
                    case E:
                       if(this.getX()== this.marte.getX())
                        throw new IllegalArgumentException("Limite Derecho Alcanzado");   
                       else
                        this.posicion.setX(this.posicion.getX()+1);
                        break;
                    case S:
                        if(this.getY()==0)
                            throw new IllegalArgumentException("Limite Inferior Alcanzado");   
                        else
                         this.posicion.setY(this.posicion.getY()-1);
                        break;
                    case W:
                        if(this.getX()==0)
                            throw new IllegalArgumentException("Limite Izquierdo Alcanzado");
                        else
                           this.posicion.setX(this.posicion.getX()-1);
                        break;
                }
                break;
            case 'D':
            case 'I':
                girar(c);
                break;
            default:
                throw new IllegalArgumentException("Comando No Reconocido");
        }
        
    }

    public void girar(char c) {
      
      switch(c){
          case 'D': 
              switch(this.orientacion){
                  case N:
                      this.orientacion=Orientacion.E;break;
                  case E:
                      this.orientacion=Orientacion.S;break;
                  case S:
                      this.orientacion=Orientacion.W;break;
                  case W:
                      this.orientacion=Orientacion.N;break;
              }
              break;
          case 'I': 
              
              switch(this.orientacion){
                  case N:
                      this.orientacion=Orientacion.W;break;
                  case W:
                      this.orientacion=Orientacion.S;break;
                  case S:
                      this.orientacion=Orientacion.E;break;
                  case E:
                      this.orientacion=Orientacion.N;break;
              }
              break;
          default:
                throw new IllegalArgumentException("Rotacion No Reconocida");
      }
    }

    /**
     * @return the marte
     */
    public Marte getMarte() {
        return marte;
    }

    /**
     * @param marte the marte to set
     */
    public void setMarte(Marte marte) {
        this.marte = marte;
    }

    public Posicion getPosicionFinal() {
        this.posicion.setOrientacion(this.orientacion);
        return this.posicion;
    }

    public void ejecutarComandos(String comandos) {
      char cmd[]=comandos.toCharArray();
      for(char x:cmd){
          this.comando(x);
      }
    }
    
}
