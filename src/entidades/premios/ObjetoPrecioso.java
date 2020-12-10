package entidades.premios;

import juego.Juego;

public abstract class ObjetoPrecioso extends Premio {
	
	/**
	 * Crea un objeto precioso
	 * @param g El juego al que pertenece
	 */
	public ObjetoPrecioso(Juego g) {
		super(g);
	}
}