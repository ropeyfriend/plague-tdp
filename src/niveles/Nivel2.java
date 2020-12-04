package niveles;

import fabricas.Fabrica;
import fabricas.FabricaAlpha;
import fabricas.FabricaBeta;
import juego.Juego;

public class Nivel2 extends Nivel{
	//Atributos
	int cant;
	
	/**Crea un nuevo nivel 2*/
	public Nivel2(Juego j) {
		super(j);
		siguiente = null;	
		cant = 15;//15 infectados
		
		fabricas = new Fabrica[2];
		fabricas[0] = new FabricaAlpha(game);
		fabricas[1] = new FabricaBeta(game);
		
		setTanda(new Tanda1(this, cant));
		
	}
	
}