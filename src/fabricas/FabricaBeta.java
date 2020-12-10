package fabricas;

import entidades.personajes.Infectado;
import entidades.personajes.InfectadoBeta;
import juego.Juego;

/**Clase que modela una fabrica de infectados Beta*/

public class FabricaBeta extends Fabrica{

	/**Crea una nueva fabrica Beta*/
	public FabricaBeta(Juego g) {
		super(g);
	}

	@Override
	public Infectado [] crearInfectado(int n, int vel, int rango) {
		Infectado inf[] = new InfectadoBeta[n];
		for(int i = 0; i < n; i++) {
			inf[i] = new InfectadoBeta(game, vel, rango);
		}
		return inf;
	}
	
}