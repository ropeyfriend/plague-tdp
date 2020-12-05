package fabricas;

import java.util.Random;

import entidades.personajes.Infectado;
import entidades.personajes.InfectadoAlpha;
import entidades.personajes.InfectadoBeta;
import juego.Juego;

/**Clase que modela una fabrica de infectados Alpha*/

public class FabricaAlpha extends Fabrica{

	/**Crea una nueva fabrica Alpha*/
	public FabricaAlpha(Juego g) {
		super(g);
	}

	@Override
	public Infectado crearInfectado() {
		Infectado inf = new InfectadoAlpha(5,5,game);	
		int [] xPositions = new int[100];
		Random rnd = new Random();
		int x = rnd.nextInt(this.game.getanchomapa()-inf.getEntidadGrafica().getAncho());
		
		while(repetido(x,xPositions)) {
			x = rnd.nextInt(this.game.getanchomapa()-inf.getEntidadGrafica().getAncho());
		}
		
		int y = 0;
		inf.getEntidadGrafica().setX(x);
		inf.getEntidadGrafica().setY(y);

		return inf;
	}
	
	private boolean repetido(int x, int [] xPositions) {
		boolean found = false;
		for(int i = 0; i<xPositions.length && !found; i++) {
			if(xPositions[i] == x) {
				found = true;
			}
		}
		return found;
	}

}
