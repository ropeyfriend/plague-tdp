package fabricas;

import entidades.personajes.Infectado;
import entidades.personajes.InfectadoBeta;

/**Clase que modela una fabrica de infectados Beta*/

public class FabricaBeta extends Fabrica{

	@Override
	public Infectado[] crearInfectado(int n) {
		Infectado[] array = new InfectadoBeta[n];
		Infectado inf;
		
		for(int i = 0; i<n; i++) {
			inf = new InfectadoBeta(5,5,0,0);
			array[i] = inf;
		}
		
		return array;
	}

}
