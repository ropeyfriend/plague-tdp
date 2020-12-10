package niveles;

import java.util.LinkedList;
import java.util.Random;

import entidades.Entidad;
import entidades.personajes.Infectado;
import juego.Juego;

public class Nivel {
	protected Juego game;
	protected Tanda t1;
	protected Tanda t2;

	public Nivel(Juego game, int cantidadInfectados, int velocidad, int rango) {
		this.game = game;
		t1 = new Tanda(game, cantidadInfectados / 2, velocidad, rango);
		// si es par, la tanda 2 tiene la misma cantidad que la tanda 1, si es impar
		// tiene uno mas
		if (cantidadInfectados % 2 == 0) {
			t2 = new Tanda(game, cantidadInfectados / 2, velocidad, rango);
		} else
			t2 = new Tanda(game, (cantidadInfectados / 2) + 1, velocidad, rango);
		setPosiciones();
	}

	public void setPosiciones() {
		LinkedList<Integer> posiciones_x = new LinkedList<Integer>();
		Random rnd = new Random();
		int rango = game.getMapa().ancho_mapa;
		int x;
		for (Infectado i : t1.getInfectados()) {
			x = rnd.nextInt(rango - i.getEntidadGrafica().getAncho()); // un numero entre 0 y el borde del mapa sin que se pase el label
			i.getEntidadGrafica().setX(x);
			i.getEntidadGrafica().setY(game.getMapa().y_infectados);
			
			posiciones_x.add(x);
			
		}
		for (Infectado i : t2.getInfectados()) {
			x = rnd.nextInt(rango - i.getEntidadGrafica().getAncho()); // un numero entre 0 y el borde del mapa sin que
																		// se pase el label
			while (posiciones_x.contains(x)) // si ya contiene la posicion, entonces la recalculamos
				x = rnd.nextInt(rango - i.getEntidadGrafica().getAncho());

			i.getEntidadGrafica().setX(x);
			i.getEntidadGrafica().setY(game.getMapa().y_infectados);
			posiciones_x.add(x);
		}
	}

	public Tanda getTanda1() {
		return t1;
	}

	public Tanda getTanda2() {
		return t2;
	}
	
	public Tanda getTanda(int i) {
		Tanda toret = null;
		if (i == 1) 
			toret = t1;
		else if (i == 2)
			toret = t2;
		
		return toret;
	}

	public boolean getNivelFinalizado() {
		return t1.getTandaFinalizada() && t2.getTandaFinalizada();
	}
}