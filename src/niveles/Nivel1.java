package niveles;

import juego.Juego;

/**Clase que representa el nivel 1 del juego*/

public class Nivel1 extends Nivel {
	//Atributes
	/**Cantidad de infectados del nivel*/
	int cant;
	
	/**Crea un nuevo nivel 1*/
	public Nivel1(Juego j) {
		super(j);
		cant = 10; //10 infectados
		siguiente = new Nivel2(game);
		setTanda(new Tanda1(this, cant/2));
		setTanda(new Tanda2(this, cant/2));	
	}

	@Override
	public Nivel getSiguiente() {
		return siguiente;
	}
}
