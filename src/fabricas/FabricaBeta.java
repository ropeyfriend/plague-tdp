package fabricas;

import java.util.ArrayList;
import java.util.Random;

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
	public Infectado crearInfectado() {
		Infectado inf = new InfectadoBeta(5,5,game);	
		ArrayList<Integer> ubicacionX = new ArrayList<Integer> ();//lista donde guardo las posiciones de x
		
		Random rnd = new Random();
		int x = rnd.nextInt(this.game.getanchomapa() - inf.getEntidadGrafica().getAncho());
		
		while(repetido(x,ubicacionX)) {
			x = rnd.nextInt(this.game.getanchomapa() - inf.getEntidadGrafica().getAncho());
		}
		
		ubicacionX.add(x);
		
		int y = 0;//Poner el numero donde aparecen los infectados al principio
		inf.getEntidadGrafica().setX(x);
		inf.getEntidadGrafica().setY(y);

		return inf;
	}
	
	/**Verifica si el entero pasado por parametro este repetido en la lista con el fin de que no haya colisiones
	 * @param x, entero a verificar
	 * @param list, lista donde se guardan las posiciones de la variable x
	 * @return true si x se encuentra en la lista
	 * */
	private boolean repetido(int x, ArrayList<Integer> list) {
		int i = 0;
		boolean found = false;
		
		while(!found) {
			if(list.get(i) == x) {
				found = true;
			}
			i++;
		}
		return found;
	}
	
}