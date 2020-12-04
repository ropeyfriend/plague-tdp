package fabricas;

import java.util.Random;

import entidades.personajes.Infectado;
import entidades.personajes.InfectadoAlpha;
import juego.Juego;

/**Clase que modela una fabrica de infectados Alpha*/

public class FabricaAlpha extends Fabrica{

	/**Crea una nueva fabrica alpha*/
	public FabricaAlpha(Juego g) {
		super(g);
	}

	@Override
	public Infectado crearInfectado(int n) {
		Infectado inf=new InfectadoAlpha(5,5,game);
		
		//Random rnd=new Random();
		//int x = rnd.nextInt(this.game..getanchomapa()-inf.getancho());
		//inf.getEntidadGrafica().getLabel().setLocation(x,0);
		
		return inf;
	}

}
