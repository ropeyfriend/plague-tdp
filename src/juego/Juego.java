package juego;

import java.util.LinkedList;

import entidades.Entidad;
import entidades.personajes.Infectado;
import entidades.personajes.Jugador;
import mapa.Mapa;

public class Juego {
    protected LinkedList <Entidad> entidades;
    protected Mapa mapa;
    protected Jugador jugador;
    
    public Juego() {
        mapa = new Mapa();
        jugador = new Jugador(393,440,this);
        entidades = new LinkedList<Entidad>();
        
        mapa.agregarEntidad(jugador);
        jugador.cambiarDibujo();
        mapa.repaint();
    }

    public void run() {
    }
    
    public Jugador getJugador() {
    	return jugador;
    }
    
    public Mapa getMapa() {
    	return mapa;
    }

	public void agregarArreglo(Infectado[] array) {
		// TODO Auto-generated method stub
		
	}

	public int getanchomapa() {
		// TODO Auto-generated method stub
		return 0;
	}
}