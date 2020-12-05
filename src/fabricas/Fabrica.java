package fabricas;

import entidades.personajes.Infectado;
import juego.Juego;

/**Clase que modela una fabrica de infectados*/

public abstract class Fabrica {
	/**Representa el juego de la fabrica*/
	protected Juego game;
	/**Representa la posicion x donde se ubicara al infectado*/
	
	/**Crea una nueva fabrica*/
	public Fabrica(Juego g) {
		game = g;
	}
	
	/**Crea un nuevo arreglo de infectados
	 * @param n, cantidad de infectados a crear
	 * @return arreglo de infectados
	 * */
	public abstract Infectado crearInfectado();
}
