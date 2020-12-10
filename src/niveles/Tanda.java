package niveles;

import java.util.Random;

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

	protected int velocidad;
	protected int rango;

	/** Crea una nueva tanda de infectados */
	public Tanda(Juego g, int cantidadInfectados, int velocidad, int rango) {
		this.game = g;
		this.cant = cantidadInfectados;
		this.velocidad = velocidad;
		this.rango = rango;
		this.array = new Infectado[cantidadInfectados];
		this.fabricas = new Fabrica[2];
		this.fabricas[0] = new FabricaAlpha(game);
		this.fabricas[1] = new FabricaBeta(game);
		init();
	}

	// Methods
	/**
	 * Inicializa las tandas
	 */
	public void init() {
		Infectado[] infectadosAlpha = fabricas[0].crearInfectado(cant / 2, velocidad, rango);
		Infectado[] infectadosBeta = fabricas[1].crearInfectado(cant / 2, velocidad, rango);

		for (int i = 0; i < cant / 2; i++) {
			array[i] = infectadosAlpha[i];
		}
		for (int i = cant / 2; i < cant - 1; i++) {
			array[i] = infectadosBeta[i - (cant / 2)];
		}

		// mete una cantidad cant-1 de infectados, este seria el ultimo
		array[cant - 1] = new InfectadoAlpha(game, velocidad, rango);

	}

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

	/**Devuelve true si la tanda finalizo
	 * 
	 * @return true si todos los infectados de la tanda fueron eliminados
	 * */
	public boolean getTandaFinalizada() {
		boolean toret = true;
		for (int i = 0; i < array.length && toret; i++) {
			if (array[i].getActivo())
				toret = false;
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