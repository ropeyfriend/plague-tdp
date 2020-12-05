package niveles;

import fabricas.Fabrica;
import fabricas.FabricaAlpha;
import fabricas.FabricaBeta;
import juego.Juego;

public class Nivel1 extends Nivel {
	//Atributes
	/**Cantidad de infectados del nivel*/
	int cant;
	
	/**Crea un nuevo nivel 1*/
	public Nivel1(Juego j) {
		super(j);
		cant = 10; //10 infectados
		siguiente = new Nivel2(game);
		
		fabricas=new Fabrica[2];
		fabricas[0]=new FabricaAlpha(game);
		fabricas[1]=new FabricaBeta(game);
		
		setTanda(new Tanda1(this, cant/2));
		setTanda(new Tanda2(this, cant/2));	
	}

	@Override
	/**Retorna el nivel siguiente al actual
	 * @return nivel siguiente
	 **/
	public Nivel getSiguiente() {
		return siguiente;
	}
}
