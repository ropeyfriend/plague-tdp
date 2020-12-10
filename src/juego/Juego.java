package juego;

import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

import entidades.Entidad;
import entidades.personajes.Infectado;
import entidades.personajes.InfectadoAlpha;
import entidades.personajes.InfectadoBeta;
import entidades.personajes.Jugador;
import entidades.premios.CuarentenaObligatoria;
import entidades.premios.Pocion;
import entidades.premios.Premio;
import gui.GUI;
import mapa.Mapa;
import niveles.Nivel;
import niveles.Tanda;

public class Juego implements Runnable {
	/** Lista de entidades del juego */
	protected LinkedList<Entidad> entidades;
	/***/
	private LinkedList<Entidad> entidadesClone;
	/** Mapa del juego */
	protected Mapa mapa;
	/** Jugador del juego */
	protected Jugador jugador;
	/** Nivel del juego actual */
	protected Nivel niveles[];
	protected int nivelActual;
	protected int tandaActual;
	protected boolean tandaActiva;
	protected boolean gameover;
	/** Pociones de curacion del juego */
	protected Premio[] pociones;
	/** Gui del juego */
	protected GUI gui;
	protected boolean cuarentena;

	public Juego(GUI g) {
		gameover = false;
		gui = g;
		mapa = new Mapa();
		jugador = new Jugador(393, 440, this);
		pociones = new Premio[3];
		cuarentena = false;
		entidades = new LinkedList<Entidad>();
		this.agregarEntidad(jugador);

		// Nivel
		niveles = new Nivel[2];
		for (int i = 1; i <= niveles.length; i++)
			niveles[i - 1] = new Nivel(this, 10 * i, 3, 3);

		nivelActual = 0;
		tandaActual = 0; // se actualiza en iniciarNivel
		tandaActiva = false; // se actualiza en iniciarNivel
		iniciarNivel();
		mapa.repaint();
	}

	@Override
	public void run() {
		while (!gameover) {
			try {
				Thread.sleep(2);
				entidadesClone = (LinkedList<Entidad>) entidades.clone();
				for (Entidad e : entidadesClone) {
					e.jugar();

					LinkedList<Entidad> colisiones = getColisiones(e);
					for (Entidad entidadQueColisiona : colisiones) {
						e.accept(entidadQueColisiona.getVisitor());
					}
					if (niveles[nivelActual].getTanda(tandaActual).getTandaFinalizada() && tandaActiva) {
						if (niveles[nivelActual].getNivelFinalizado() && nivelActual == 1) {
							System.out.println("nivel 2 tanda 2 -> game over");
							gameover=true;
						} else {
							System.out
									.println("nivel " + (nivelActual+1) + " tanda " + tandaActual);
							tandaActiva = false;
							Timer t = new Timer();
							TimerTask activarSigTanda = new TimerTask() {
								@Override
								public void run() {
									if (tandaActual == 2) {
										nivelActual++;
										tandaActual = 0;
										iniciarNivel();
									} else if (tandaActual == 1) {
										iniciarNivel();
									}
								}
							};
							t.schedule(activarSigTanda, 4000);
						}
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Agrega una pocion al arreglo de pociones del juego
	 * 
	 * @param p, pocion a agregar
	 */
	public void agregarPocion(Pocion p) {
		boolean encontre = false;

		for (int i = 0; i < pociones.length && !encontre; i++) {
			if (pociones[i] == null) {
				encontre = true;
				pociones[i] = p;
				gui.agregarPocion(p);
			}
		}
	}

	/**
	 * Elimina la pocion ubicada en la posicion pasada por parametro
	 * 
	 * @param n, posicion en el arreglo de pociones
	 */
	public void eliminarPocion(int n) {
		pociones[n] = null;
	}

	/**
	 * Agrega una entidad a la lista de entidades del juego
	 * 
	 * @param e, entidad a agregar
	 */
	public void agregarEntidad(Entidad e) {
		entidades.add(e);
		mapa.agregarEntidad(e);
	}

	/**
	 * Elimina una entidad de la lista de entidades del juego
	 * 
	 * @param e, entidad a eliminar
	 */
	public void eliminarEntidad(Entidad e) {
		entidades.remove(e);
		mapa.eliminarEntidad(e);
	}

	public void agregarArreglo(Infectado[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] != null) {
				entidades.add(array[i]);
				agregarEntidad(array[i]);
			}
		}
	}

	// Getters
	/**
	 * Retorna el nivel del juego
	 * 
	 * @return nivel del juego
	 */
	public int getNivel() {
		return nivelActual + 1;
	}

	/**
	 * Obtiene el jugador del juego
	 * 
	 * @return jugador
	 */
	public Jugador getJugador() {
		return jugador;
	}

	/**
	 * Obtiene el mapa del juego
	 * 
	 * @return mapa
	 */
	public Mapa getMapa() {
		return mapa;
	}

	public GUI getGUI() {
		return gui;
	}

	public LinkedList<Entidad> getColisiones(Entidad e) {
		LinkedList<Entidad> toret = new LinkedList<Entidad>();
		for (Entidad entidad : entidadesClone) {
			if (!e.equals(entidad) && verificarColision(e, entidad)) {
				toret.add(entidad);
			}
		}
		return toret;
	}

	public void setCuarentena(int tiempo) {
		cuarentena = true;
		Timer t = new Timer();
		TimerTask setFalse = new TimerTask() {
			@Override
			public void run() {
				cuarentena = false;
			}
		};
		t.schedule(setFalse, tiempo);
	}

	public boolean getCuarentena() {
		return cuarentena;
	}

	private boolean verificarColision(Entidad entidad_1, Entidad entidad_2) {
		Rectangle r1 = entidad_1.getEntidadGrafica().getLabel().getBounds();
		Rectangle r2 = entidad_2.getEntidadGrafica().getLabel().getBounds();
		return r1.intersects(r2);
	}

	private void iniciarNivel() {
		iniciarTanda(++tandaActual);
		tandaActiva = true;
	}

	private void iniciarTanda(int tanda) {
		Infectado[] infectados = niveles[nivelActual].getTanda(tanda).getInfectados();

		if (!niveles[nivelActual].getTanda(tanda).getTandaFinalizada()) {
			for (Infectado i : infectados) {
				agregarEntidad(i);
			}
		}
	}

}
