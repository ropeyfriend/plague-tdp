package fabricas;

import entidades.personajes.Infectado;
import entidades.personajes.InfectadoAlpha;

/**Clase que modela una fabrica de infectados Alpha*/

public class FabricaAlpha extends Fabrica{

	@Override
	public Infectado[] crearInfectado(int n) {
		Infectado[] array = new InfectadoAlpha[n];
		Infectado inf;
		
		for(int i = 0; i<n; i++) {
			inf = new InfectadoAlpha(5,5);
			array[i] = inf;
		}
		
		return array;
	}

}
