package fabricas;

import java.util.ArrayList;
import java.util.Random;
import entidades.personajes.Infectado;
import entidades.personajes.InfectadoAlpha;
import juego.Juego;

/**Clase que modela una fabrica de infectados Alpha*/

public class FabricaAlpha extends Fabrica{

	/**Crea una nueva fabrica Alpha*/
	public FabricaAlpha(Juego g) {
		super(g);
	}

	@Override
	public Infectado crearInfectado() {
		int x_random = 124;
		//Infectado inf = new InfectadoAlpha(5,5,game);
		Infectado inf = new InfectadoAlpha(game ,5 ,5 ,x_random ,game.getMapa().y_infectados); 
		
		ArrayList<Integer> ubicacionX = new ArrayList<Integer> ();//lista donde guardo las posiciones de x
		
		Random rnd = new Random();
		int x = rnd.nextInt(game.getMapa().getHeight() - inf.getEntidadGrafica().getAncho());
		
		while(repetido(x,ubicacionX)) {
			x = rnd.nextInt(game.getMapa().getHeight() - inf.getEntidadGrafica().getAncho());
		}
		
		ubicacionX.add(x);//Si no esta repetido guardo a x en la lista
		
		int y = 0;
		inf.getEntidadGrafica().setX(x);
		inf.getEntidadGrafica().setY(y);

		return inf;
	}
	
	/**Verifica si el entero pasado por parametro esta en la lista, con el fin de evitar colisiones
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
