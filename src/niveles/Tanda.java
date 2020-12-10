package niveles;

import entidades.personajes.Infectado;
import entidades.personajes.InfectadoAlpha;
import fabricas.Fabrica;
import fabricas.FabricaAlpha;
import fabricas.FabricaBeta;
import juego.Juego;

public class Tanda {
	// Atributes
	/** Indica la cantidad de infectados de la tanda */
	protected int cant;
	/** Arreglo donde se guardan los infectados de la tanda */
	protected Infectado[] array;
	/** Representa al juego donde esta la tanda */
	protected Juego game;
	/** Fabricas de infectados */
	protected Fabrica[] fabricas;
	
	/**
	 * Atributos de velocidad y rango para los infectados Alfa y Beta
	 */
	protected int velocidad_alpha;
	protected int rango_alpha;
	protected int velocidad_beta;
	protected int rango_beta;

	/**
	 * Crea una tanda
	 * @param g El juego al que se vincula
	 * @param cantidadInfectados La cantidad de infectados de la tanda
	 * @param velocidad_alpha La velocidad para los infectados alfa
	 * @param rango_alpha El rango para los infectados alfa
	 * @param velocidad_beta La velocidad para los infectados beta
	 * @param rango_beta El rango para los infectados beta
	 */
	public Tanda(Juego g, int cantidadInfectados, int velocidad_alpha, int rango_alpha, int velocidad_beta,
			int rango_beta) {
		this.game = g;
		this.cant = cantidadInfectados;
		this.velocidad_alpha = velocidad_alpha;
		this.rango_alpha = rango_alpha;
		this.velocidad_beta = velocidad_beta;
		this.rango_beta = rango_beta;

		this.array = new Infectado[cantidadInfectados];
		this.fabricas = new Fabrica[2];
		this.fabricas[0] = new FabricaAlpha(game);
		this.fabricas[1] = new FabricaBeta(game);
		init();
	}

	/**
	 * Inicializa la tanda creando la misma cantidad de infectados Alfa que de Beta
	 */
	public void init() {
		Infectado[] infectadosAlpha = fabricas[0].crearInfectado(cant / 2, velocidad_alpha, rango_alpha);
		Infectado[] infectadosBeta = fabricas[1].crearInfectado(cant / 2, velocidad_beta, rango_beta);

		for (int i = 0; i < cant / 2; i++) {
			array[i] = infectadosAlpha[i];
		}
		for (int i = cant / 2; i < cant - 1; i++) {
			array[i] = infectadosBeta[i - (cant / 2)];
		}

		// mete una cantidad cant-1 de infectados, este seria el ultimo
		array[cant - 1] = new InfectadoAlpha(game, velocidad_alpha, rango_alpha);
	}

	// Getters
	/**
	 * Devuleve si la tanda tiene o no infectados
	 * 
	 * @return true si la tanda esta vacia
	 */
	public boolean isEmpty() {
		return cant == 0;
	}

	/**
	 * Obtiene la cantidad de infectados de la tanda
	 * 
	 * @return infectados de la tanda
	 */
	public int getCant() {
		return cant;
	}
	
	/**
	 * Retorna true si todos los infectados de la tanda estan muertos
	 * @return True si la tanda finalizo
	 */
	public boolean getTandaFinalizada() {
		boolean toret = true;
		for (int i = 0; i < array.length && toret; i++) {
			if (array[i].getActivo()) {
				toret = false;
			}
		}

		return toret;
	}

	/**
	 * Retorna el arreglo de infectados de la tanda
	 * 
	 * @return infectados de la tanda
	 */
	public Infectado[] getInfectados() {
		return array;
	}

	/**
	 * Modifica el arreglo de infectados por el pasado por parametro
	 * 
	 * @param a, arreglo de infectados a modificar
	 */
	public void setArreglo(Infectado[] a) {
		array = a;
		;
	}
}