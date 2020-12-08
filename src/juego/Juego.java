package juego;

import java.util.LinkedList;

import entidades.Entidad;
import entidades.personajes.Infectado;
import entidades.personajes.Jugador;
import gui.MovimientoJugador;
import mapa.Mapa;
import niveles.Nivel;
import niveles.Tanda1;
import niveles.Tanda2;

public class Juego {
    protected LinkedList <Entidad> entidades;
    protected Mapa mapa;
    protected Jugador jugador;
    protected Nivel nivel;
    
    public Juego() {
        mapa = new Mapa();
        jugador = new Jugador(393,300,this);
        entidades = new LinkedList<Entidad>();
        
        mapa.agregarEntidad(jugador);
        jugador.cambiarDibujo();
        mapa.repaint();
        nivel = new Nivel(this);
    }

    public void run() {
    	
    }
    
    /**Crea un nuevo nivel del juego
     * @param n, es un entero que representa el nivel a crear
     * @param siguiente, nivel siguiente al actual
     * @param cant, cantidad de infectados a crear en ese nivel
     * */
    public void crearNivel(int n, Nivel siguiente, int cant) {
    	nivel = new Nivel(this,cant,n);
    	nivel.setSiguiente(siguiente);
		nivel.setTanda(new Tanda1(nivel, cant/2));
		nivel.setTanda(new Tanda2(nivel, cant/2));	
    }
    
    //Getters
    /**Retorna el nivel del juego
     * @return nivel del juego
     * */
    public int getNivel() {
    	return nivel.getNivel();
    }
    
    /**Obtiene el jugador del juego
     * @return jugador
     * */
    public Jugador getJugador() {
    	return jugador;
    }
    
    /**Obtiene el mapa del juego
     * @return mapa
     * */
    public Mapa getMapa() {
    	return mapa;
    }
    
    //Setters
    /**Modifica el nivel del juego por el pasado por parametro
     * @param n, nivel a modificar
     * */
    public void setNivel(Nivel n) {
    	nivel = n;
    }

	public void agregarArreglo(Infectado[] array) {
		// TODO Auto-generated method stub
		
	}


}
