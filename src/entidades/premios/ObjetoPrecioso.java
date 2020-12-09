package entidades.premios;

import entidades.personajes.Jugador;
import juego.Juego;

public abstract class ObjetoPrecioso extends Premio {

	public ObjetoPrecioso(Juego g) {
		super(g);
	}
    
	/**Activa el efecto del premio
	 * @param j, jugador donde aplica el efecto
	 * */
	public abstract void startEffect(Jugador j);
	
}
