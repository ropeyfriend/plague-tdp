package niveles;

import java.util.LinkedList;
import java.util.Random;

import entidades.personajes.Infectado;
import juego.Juego;

/**
 * Clase Nivel modela un conjunto de infectados en dos tandas
 *
 */
public class Nivel {
	/**
	 * El juego al que se vincula
	 */
	protected Juego game;
	/**
	 * La primer tanda atribuida 
	 */
	protected Tanda t1;
	/**
	 * La segunda tanda atribuida 
	 */
	protected Tanda t2;
	
	/**
	 * Atributos constantes de velocidad y rango para los infectados Alpha y Beta
	 */
	protected static int velocidad_alpha = 2;
	protected static int rango_alpha = 250;
	protected static int velocidad_beta = 3;
	protected static int rango_beta = 400;
	
	/**
	 * Crea un nivel vinculado a un Juego y con una cantidad de infectados
	 * @param game El juego al que se vincula
	 * @param cantidadInfectados La cantidad de infectados del nivel
	 */
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
	
	/**
	 * Inicializa los valores x e y de todos los infectados de la tanda 1 y 2
	 */
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
	
	/**
	 * Devuelve la primer tanda
	 * @return la primer tanda
	 */
	public Tanda getTanda1() {
		return t1;
	}
	
	/**
	 * Devuelve la segunda tanda
	 * @return la segunda tanda
	 */
	public Tanda getTanda2() {
		return t2;
	}
	
	/**
	 * Dado un valor 1 o 2 devuelve la primer o segunda tanda
	 * @param i El parametor que indica la tanda a devolver
	 * @return La primer o segunda tanda dependiendo del parametro pasado
	 */
	public Tanda getTanda(int i) {
		Tanda toret = null;
		if (i == 1) 
			toret = t1;
		else if (i == 2)
			toret = t2;
		
		return toret;
	}
	
	/**
	 * Devuelve true cuando todos los infectados de la primer y segunda tanda estan muertos
	 * @return true si el nivel finalizo
	 */
	public boolean getNivelFinalizado() {
		return t1.getTandaFinalizada() && t2.getTandaFinalizada();
	}
}