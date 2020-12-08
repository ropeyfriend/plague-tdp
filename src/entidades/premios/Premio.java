package entidades.premios;

import entidades.Entidad;
import entidades.personajes.Jugador;
import juego.Juego;

/**Clase que modela a un premio del juego*/

public abstract class Premio extends Entidad{
	/**Crea un nuevo premio*/
	public Premio(Juego g) {
		game = g;
	}
    
	/**Activa el efecto del premio
	 * @param j, jugador donde aplica el efecto
	 * */
	public abstract void startEffect(Jugador j);
}
