package juego;

import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

import entidades.Entidad;
import entidades.personajes.Infectado;
import entidades.personajes.Jugador;
import entidades.premios.Pocion;
import entidades.premios.Premio;
import gui.GUI;
import mapa.Mapa;
import niveles.Nivel;

/** Clase que modela al juego */

public class Juego implements Runnable {
	/** Lista de entidades del juego */
	protected LinkedList<Entidad> entidades;
	/** Un clon de la lista de entidades del juego*/
	private LinkedList<Entidad> entidadesClone;
	/** Mapa del juego */
	protected Mapa mapa;
	/** Jugador del juego */
	protected Jugador jugador;
	/** Nivel del juego actual */
	protected Nivel niveles[];
	/** Nivel actual del juego */
	protected int nivelActual;
	/** Tanda actual del juego */
	protected int tandaActual;
	/** Indica si la tanda actual esta activo o no */
	protected boolean tandaActiva;
	/** Indica si se perdio el juego */
	protected boolean gameover;
	/** Indica si el juego esta o no con el efecto cuarentena */
	protected boolean cuarentena;
	/** Pociones de curacion del juego */
	protected Premio[] pociones;
	/** Indica la cantidad de pociones maximas del juego */
	protected int cantPociones;
	/** Gui del juego */
	protected GUI gui;

	/**
	 * Crea un nuevo juego
	 * 
	 * @param g, gui del juego
	 */
	public Juego(GUI g) {
		gameover = false;
		gui = g;
		mapa = new Mapa();
		jugador = new Jugador(393, 440, this);
		pociones = new Premio[3];
		cuarentena = false;
		pociones[0] = new Pocion(this);
		pociones[1] = new Pocion(this);
		pociones[2] = new Pocion(this);

		cantPociones = 3;

		entidades = new LinkedList<Entidad>();
		this.agregarEntidad(jugador);

		// Nivel
		niveles = new Nivel[2];
		for (int i = 1; i <= niveles.length; i++)
			niveles[i - 1] = new Nivel(this, 10 * i);

		nivelActual = 0;
		tandaActual = 0; // se actualiza en iniciarNivel
		tandaActiva = false; // se actualiza en iniciarNivel
		iniciarNivel();
		mapa.repaint();
	}

	/**
	 * El metodo principal del thread
	 */
	@Override
	public void run() {
		while (!gameover) {
			try {
				Thread.sleep(75);
				entidadesClone = (LinkedList<Entidad>) entidades.clone();
				for (Entidad e : entidadesClone) {
					e.jugar();

					LinkedList<Entidad> colisiones = getColisiones(e);
					for (Entidad entidadQueColisiona : colisiones) {
						e.accept(entidadQueColisiona.getVisitor());
					}

					if (!jugador.getActivo() && !gameover) {
						gameover = true;
						gui.ganar(gameover);
					}

					if (niveles[nivelActual].getTanda(tandaActual).getTandaFinalizada() && tandaActiva && !gameover) {
						if (niveles[nivelActual].getNivelFinalizado() && nivelActual == 1) {
							gui.ganar(gameover);
							gameover = true;
						} else {
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

	/**
	 * Agrega las entidades del arreglo pasado por parametro a la lista de entidades
	 * del juego
	 * 
	 * @param array, arreglo a agregar
	 */
	public void agregarArreglo(Infectado[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] != null) {
				entidades.add(array[i]);
				agregarEntidad(array[i]);
			}
		}
	}

	/**
	 * Verifica si hubo una colision entre las entidadades pasadas por parametro
	 * 
	 * @param entidad_1, primera entidad
	 * @param entidad_2, segunda entidad
	 */
	private boolean verificarColision(Entidad entidad_1, Entidad entidad_2) {
		Rectangle r1 = entidad_1.getEntidadGrafica().getLabel().getBounds();
		Rectangle r2 = entidad_2.getEntidadGrafica().getLabel().getBounds();
		return r1.intersects(r2);
	}

	/** Inicializa un nuevo nivel del juego */
	private void iniciarNivel() {
		gui.cambiarNivel(getNivel());
		iniciarTanda(++tandaActual);
		tandaActiva = true;
	}

	/**
	 * Inicializa una nueva tanda del juego
	 * 
	 * @param tanda, tanda a inicializar
	 */
	private void iniciarTanda(int tanda) {
		Infectado[] infectados = niveles[nivelActual].getTanda(tanda).getInfectados();

		if (!niveles[nivelActual].getTanda(tanda).getTandaFinalizada()) {
			for (Infectado i : infectados) {
				agregarEntidad(i);
			}
		}
	}

	/**
	 * Retorna la pocion ubicada en la posicion pasada por parametro
	 * 
	 * @param n, posicion de la pocion en el arreglo de pociones
	 */
	public Pocion buscarPocion(int n) {
		return (Pocion) pociones[n];
	}

	/**
	 * Agrega una pocion al arreglo de pociones del juego
	 * 
	 * @param p, pocion a agregar
	 */
	public int agregarPocion(Pocion p) {
		boolean encontre = false;
		int j = 0;
		for (int i = 0; i < 3 && !encontre; i++) {
			if (pociones[i] == null) {
				encontre = true;
				pociones[i] = p;
				cantPociones++;
				j = i;
			}
		}
		return j;
	}

	/**
	 * Agrega una pocion p al arreglo de pociones en la posicion i
	 * 
	 * @param p, pocion a agregar
	 * @param i, posicion donde agregar la pocion
	 */
	public void agregarPocion(Pocion p, int i) {
		pociones[i] = p;
	}

	// ----------- Getters -----------
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

	/**
	 * Obtiene la gui del juego
	 * 
	 * @return gui
	 */
	public GUI getGUI() {
		return gui;
	}

	/**
	 * Obtiene las colisiones del juego con respecto a la entidad pasada por
	 * parametro
	 * 
	 * @param e, entidad a verificar las colisiones
	 * 
	 * @return colisiones
	 */
	public LinkedList<Entidad> getColisiones(Entidad e) {
		LinkedList<Entidad> toret = new LinkedList<Entidad>();
		for (Entidad entidad : entidadesClone) {
			if (!e.equals(entidad) && verificarColision(e, entidad)) {
				toret.add(entidad);
			}
		}
		return toret;
	}

	/**
	 * Retorna true si el juego esta con efecto cuarentena
	 * 
	 * @return true si el efecto esta activado
	 */
	public boolean getCuarentena() {
		return cuarentena;
	}

	/**
	 * Obtiene la cantidad de pociones del juego
	 * 
	 * @return cantidad de pociones
	 */
	public int getCantPociones() {
		return cantPociones;
	}

	// ----------- Setters -----------
	/**
	 * Le setea al efecto cuarentena el tiempo pasado por parametro
	 * 
	 * @param tiempo, tiempo del efecto
	 */
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

	/**
	 * Modifica la cantidad de pociones por la pasada por parametro
	 * 
	 * @param n, cantidad de pociones
	 */
	public void setCantPociones(int n) {
		cantPociones = n;
		if (cantPociones < 0)
			cantPociones = 0;
		if (cantPociones > 3)
			cantPociones = 3;
	}

	/**
	 * Modifica la variable cuarentena por la pasada por parametro
	 * 
	 * @param c, indica si la cuarentena esta o no activa
	 */
	public void setCuarentena(boolean c) {
		cuarentena = c;
	}

	/**
	 * Modifica el valor de la gui por la pasada por parametro
	 * 
	 * @param g, nueva gui
	 */
	public void setGui(GUI g) {
		gui = g;
	}

	/**
	 * Modifica el valor del mapa por el pasada por parametro
	 * 
	 * @param m, nuevo mapa
	 */
	public void setMapa(Mapa m) {
		mapa = m;
	}

	/**
	 * Modifica al jugador por el pasado por parametro
	 * 
	 * @param j, nuevo jugador
	 */
	public void setJugador(Jugador j) {
		jugador = j;
	}
}
