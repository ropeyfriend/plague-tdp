package entidades.premios;

import entidades.Entidad;
import entidades.movimiento.MovimientoVertical;
import entidades.personajes.Jugador;
import juego.Juego;

/** Clase que modela a un premio del juego */

public abstract class Premio extends Entidad {
	/**
	 * La estrategia de movimiento
	 */
	protected MovimientoVertical mv;

	/**
	 * Dado un juego, crea un nuevo premio
	 * @param g El juego al que pertenece
	 */
	public Premio(Juego g) {
		game = g;
		mv = new MovimientoVertical(this, MovimientoVertical.ABAJO);
		velocidad = 15;
	}
	
	/**Activa el efecto del premio
	 * @param j, jugador donde aplica el efecto
	 * */
	public abstract void startEffect(Jugador j);
	
	/**
	 * Genera el movimiento
	 */
	public void mover() {
		this.mv.mover();
	}

	public void jugar() {
		if (!fueraDelMapa(this.entidadGrafica.getY())) {
			this.mover();
		} else
			game.eliminarEntidad(this);
	}

	public void setDireccion(int i) {
		if (i == 1 || i == -1)
			this.mv.setDireccion(i);
	}
	
	/**
	 * Dado un valor y, evuelve true si esta fuera del mapa
	 * @param y La posicion en y del premio
	 * @return true si esta fuera del mapa
	 */
	public boolean fueraDelMapa(int y) {
		boolean toret = false;
		if (y < 0 || y + this.getEntidadGrafica().getLabel().getHeight() > game.getMapa().getHeight())
			toret = true;
		return toret;
	}
}
