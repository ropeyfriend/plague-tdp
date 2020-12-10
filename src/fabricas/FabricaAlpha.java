package fabricas;

import entidades.personajes.Infectado;
import entidades.personajes.InfectadoAlpha;
import juego.Juego;

/**Clase que modela una fabrica de infectados Alpha*/

public class FabricaAlpha extends Fabrica{

	/**Crea una nueva fabrica Alpha*/
	public FabricaAlpha(Juego g) {
		super(g);
	}

	public Infectado [] crearInfectado(int n, int vel, int rango) {
		Infectado inf[] = new InfectadoAlpha[n];
		for(int i = 0; i < n; i++) {
			inf[i] = new InfectadoAlpha(game, vel, rango);
		}
		return inf;
	}
}
