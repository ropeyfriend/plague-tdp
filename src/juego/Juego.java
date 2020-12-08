package juego;

import java.util.LinkedList;

import entidades.Entidad;
import entidades.personajes.Infectado;
import entidades.personajes.Jugador;
import mapa.Mapa;
import niveles.Nivel;

public class Juego {
    protected LinkedList <Entidad> entidades;
    protected Mapa mapa;
    protected Jugador jugador;
    protected Nivel level;
    
    public Juego() {
        mapa = new Mapa();
        jugador = new Jugador(393,300, this);
        entidades = new LinkedList<Entidad>();
        
        mapa.agregarEntidad(jugador);
        jugador.cambiarDibujo();
        mapa.repaint();
    }

    public void run() {
    	
    }
    
    /**Retorna verdadero si el jugador gano el juego
     * @return true si el jugador gano
     * */
    public boolean ganar() {
    	return level.getGane();
    }
    
    public Jugador getJugador() {
    	return jugador;
    }
    
    public Mapa getMapa() {
    	return mapa;
    }

	public int getanchomapa() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void agregarArreglo(Infectado[] array) {
		// TODO Auto-generated method stub
		
	}
}
