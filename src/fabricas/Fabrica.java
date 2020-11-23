package fabricas;

import entidades.personajes.Infectado;

/**Clase que modela una fabrica de infectados*/

public abstract class Fabrica {
	
	/**Crea un nuevo arreglo de infectados
	 * @param n, cantidad de infectados a crear
	 * @return arreglo de infectados
	 * */
	public abstract Infectado[] crearInfectado(int n);
}
