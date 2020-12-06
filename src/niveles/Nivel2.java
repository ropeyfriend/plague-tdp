package niveles;

import juego.Juego;


/**Clase que representa el nivel 2 del juego*/

public class Nivel2 extends Nivel{
	//Atributos
	int cant;
	
	/**Crea un nuevo nivel 2*/
	public Nivel2(Juego j) {
		super(j);
		siguiente = null;	
		cant = 16;//16 infectados
		setTanda(new Tanda1(this, cant/2));
		setTanda(new Tanda2(this, cant/2));
	}

	@Override
	public Nivel getSiguiente() {
		return null;
	}
	
	
	
}