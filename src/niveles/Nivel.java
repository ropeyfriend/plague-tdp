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
	
	protected static int velocidad_alpha = 2;
	protected static int rango_alpha = 300;
	protected static int velocidad_beta = 3;
	protected static int rango_beta = 400;
	
	public Nivel(Juego game, int cantidadInfectados) {
		this.game = game;
		t1 = new Tanda(game, cantidadInfectados / 2, velocidad_alpha, rango_alpha, velocidad_beta, rango_beta);
		// si es par, la tanda 2 tiene la misma cantidad que la tanda 1, si es impar
		// tiene uno mas
		if (cantidadInfectados % 2 == 0) {
			t2 = new Tanda(game, cantidadInfectados / 2, velocidad_alpha, rango_alpha, velocidad_beta, rango_beta);
		} else
			t2 = new Tanda(game, (cantidadInfectados / 2) + 1, velocidad_alpha, rango_alpha, velocidad_beta, rango_beta);
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