package fabricas;

import java.util.ArrayList;
import java.util.Random;
import entidades.personajes.Infectado;
import entidades.personajes.InfectadoAlpha;
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
		Infectado inf = new InfectadoBeta(game,5,3);//ver el tema del rango
		ArrayList<Integer> ubicacionX = new ArrayList<Integer> ();//lista donde guardo las posiciones de x
		
		Random rnd = new Random();
		int x = rnd.nextInt();
		if(!fueraDelMapa(x, inf)) {//Si la ubicacion esta dentro de los limites del mapa
			while(repetido(x,ubicacionX)) {
				x = rnd.nextInt(780);
			}
			
			ubicacionX.add(x);//Si no esta repetido guardo a x en la lista
			inf.getEntidadGrafica().setX(x);
			inf.getEntidadGrafica().setY(game.getMapa().y_infectados);
		}
		else {//Si esta fuera de rango
			while(fueraDelMapa(x,inf)) {
				x = rnd.nextInt(780);
			}
			
			while(repetido(x,ubicacionX)) {//Una vez que esta dentro del rango me fijo q no este repetida la x
				x = rnd.nextInt(780);
			}
			
			ubicacionX.add(x);//Si no esta repetido guardo a x en la lista
			inf.getEntidadGrafica().setX(x);
			inf.getEntidadGrafica().setY(game.getMapa().y_infectados);	
			//game.agregarEntidad(inf);
		}
		
		return inf;
	}
	
	
	public boolean fueraDelMapa(int y, Infectado inf) {
		boolean toret = false;
		if (y < 0 || y + inf.getEntidadGrafica().getLabel().getHeight() > game.getMapa().getHeight()) {
			toret = true;
		}
		return toret;
	}
	
	/**Verifica si el entero pasado por parametro esta en la lista, con el fin de evitar colisiones
	 * @param x, entero a verificar
	 * @param list, lista donde se guardan las posiciones de la variable x
	 * @return true si x se encuentra en la lista
	 * */
	private boolean repetido(int x, ArrayList<Integer> list) {
		int i = 0;
		boolean found = false;
		
		while(!found && i<list.size()) {
			if(list.get(i) == x) {
				found = true;
			}
			i++;
		}
		return found;
	}
	
}