package niveles;

import juego.Juego;

/**Clase que representa el nivel 1 del juego*/

public class Nivel1 extends Nivel {
	//Atributes
	/**Cantidad de infectados del nivel 1*/
	protected static final int cant = 10;
	
	/**Crea un nuevo nivel 1*/
	public Nivel1(Juego j) {
		super(j);
		siguiente = new Nivel2(game);
		setTanda(new Tanda1(this, cant/2));
		setTanda(new Tanda2(this, cant/2));	
	}

	@Override
	public Nivel getSiguiente() {
		return siguiente;
	}
}
