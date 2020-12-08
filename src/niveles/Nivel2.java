package niveles;

import juego.Juego;

/**Clase que representa el nivel 2 del juego*/

public class Nivel2 extends Nivel{
	//Atributos
	/**Cantidad de infectados del nivel 2*/
	protected static final int cant = 16;
	
	/**Crea un nuevo nivel 2*/
	public Nivel2(Juego j) {
		super(j);
		siguiente = null;	
		setTanda(new Tanda1(this, cant/2));
		setTanda(new Tanda2(this, cant/2));
	}

	@Override
	public Nivel getSiguiente() {
		return null;
	}
	
}