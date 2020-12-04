package niveles;

import fabricas.Fabrica;
import fabricas.FabricaAlpha;
import fabricas.FabricaBeta;
import juego.Juego;

public class Nivel1 extends Nivel {
	//Atributos
	int cant;
	
	/**Crea un nuevo nivel 1*/
	public Nivel1(Juego j) {
		super(j);
		cant = 10; //10 infectados
		siguiente=new Nivel2(game);
		
		fabricas=new Fabrica[2];
		fabricas[0]=new FabricaAlpha(game);
		fabricas[1]=new FabricaBeta(game);
		
		setTanda(new Tanda1(this, cant));
		
	}
	//Metodos
}
