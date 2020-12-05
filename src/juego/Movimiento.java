package juego;

import entidades.EntidadGrafica;

public class Movimiento {
	
	private EntidadGrafica j;

	public Movimiento(EntidadGrafica jugador) {
		j = jugador;
	}

	public EntidadGrafica getJugador() {
		return j;
	}

	public void setJugador(EntidadGrafica jugador) {
		j = jugador;
	}

}