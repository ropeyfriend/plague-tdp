package niveles;

import juego.Juego;

/**Clase que represemta los niveles de un juego*/

public class Nivel {
	//Atributos
	/**Representa la tanda del nivel*/
	protected Tanda tanda;
	/**Representa al juego donde esta el nivel*/
	protected Juego game;
	/**Representa al nivel siguiente*/
	protected Nivel siguiente;
	/**Indica si el jugador gano el nivel*/
	protected boolean gane;
	/**Representa la cantidad de infectados del nivel*/
	protected int cant;
	/**Entero que representa el nivel actual*/
	//protected int nivel;
	
	/**Crea un nuevo nivel*/
	public Nivel(Juego g, int cant /*,int n*/) {
		game = g;
		gane = false;
		//nivel = n;
		this.cant = cant;
	}
	
	/**Crea un nuevo nivel*/
	public Nivel(Juego g) {
		game = g;
		gane = false;
		cant = 0;
	}
	
	//Methods
	/**Elimina los infectados muertos de la tanda, si todos los de la primer tanda murieron entonces pasa a la tanda siguiente*/
	public void delete() {
		
		tanda.delete();//elimina los infectados que estan muertos
		
		if (tanda!=null && tanda.isEmpty()) {//Si todos los infectados de la tanda fueron eliminados
			tanda = tanda.getNext();
			if (tanda != null) {//Segunda tanda
				game.agregarArreglo(tanda.getArray());
			}
			else {//Si elimino la primer y segunda tanda entonces gana el nivel
				gane = true;
			}
		}
	}
	
	//Getters
	/**Retorna el nivel siguiente al actual, si no hay nivel siguiente retorna NULL
	 * @return nivel siguiente
	 **/
	public Nivel getSiguiente() {
		return siguiente;
	}
	
	/**Obtiene la tanda del nivel
	 * @return tanda
	 * */
	public Tanda getTanda() { 
		return tanda;
	}
	
	/**Indica si el jugador gano el nivel
	 * @return true si gano el nivel
	 * */
	public boolean getGane() {
		return gane;
	}

	//Setters	
	/**Modifica la variable gane por la pasada por parametro
	 * @param g, variable a modificar
	 * */
	public void setGane(boolean g) {
		gane = g;
	}

	/**Modifica la tanda del nivel por la pasada por parametro
	 * @param t, tanda a modificar
	 * */
	public void setTanda(Tanda t) {
		tanda = t;
	}
	
	/**Modifica el nivel siguiente por el pasado por parametro
	 * @param n, nivel siguiente
	 * */
	public void setSiguiente(Nivel n) {
		siguiente = n;
	}
	
	/**Retorna un entero que representa el nivel actual
	 * @return nivel actual
	 * */
	/*public int getNivel() {
		return nivel;
	}*/
}
