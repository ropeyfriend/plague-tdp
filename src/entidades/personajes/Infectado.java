package entidades.personajes;

import java.util.Random;

import entidades.movimiento.MovimientoVertical;
import entidades.premios.CuarentenaObligatoria;
import entidades.premios.Pocion;
import entidades.premios.Premio;
import entidades.premios.SuperArmaSanitaria;
import juego.Juego;

/** Clase que modela a un infectado del juego */

public abstract class Infectado extends Personaje {
	/**
	 * Constante de daño cuerpo a cuerpo
	 */
	protected static final int danio_cuerpo_a_cuerpo = 20;

	// Atributes
	/** Representa el rango donde se exparcen las particulas del infectado */
	protected int rango;

	/** Movimiento del infectado */
	protected MovimientoVertical mv;

	/**
	 * Crea un nuevo infectado
	 * 
	 * @param g,   juego del infectado
	 * @param vel, velocidad del infectado
	 * @param r,   rango del infectado
	 */
	public Infectado(int vel, int r, Juego g) {
		cargaViral = 100;
		velocidad = vel;
		mv = new MovimientoVertical(this, MovimientoVertical.ABAJO);
		game = g;
		activo = true;
		rango = r;
	}
	
	@Override
	public void jugar() {
		Random rnd = new Random();
		int probabilidad = rnd.nextInt(50);
		if (probabilidad == 0 && !game.getCuarentena()) {
			this.disparar();
		} else if (!fueraDelMapa(this.entidadGrafica.getY()) && !game.getCuarentena())
			this.mover();
		else if (fueraDelMapa(this.entidadGrafica.getY())) {
			this.entidadGrafica.setY(game.getMapa().y_infectados);
		}
	}
	
	/**
	 * Genera el movimietno del infectado
	 */
	public void mover() {
		entidadGrafica.updateImagen(ruta_dibujo_moviendose);
		this.mv.mover();
	}

	/**
	 * Verifica si el y pasado por parametro esta fuera del mapa
	 * 
	 * @param y, entero que representa una posicion del mapa
	 */
	private boolean fueraDelMapa(int y) {
		boolean toret = false;
		if (y < 0 || y + this.getEntidadGrafica().getLabel().getHeight() > game.getMapa().getHeight())
			toret = true;
		return toret;
	}

	/** Genera los drops del infectado y luego lo elimina logica y graficamente */
	public void morir() {
		Random rnd2 = new Random();
		int n2 = rnd2.nextInt(3); // determina que premio agregar
		int x = this.getEntidadGrafica().getX();
		int y = this.getEntidadGrafica().getY();

		if (n2 == 0) { // o agrego una pocion
			Premio p = new Pocion(x, y, game);
			game.agregarEntidad(p);
		} else if (n2 == 1) { // o agrego una cuarentena obligatoria
			Premio p = new CuarentenaObligatoria(game, 5000, x, y);
			game.agregarEntidad(p);
		} else if (n2 == 2) { // o agrego un super arma sanitaria
			Premio p = new SuperArmaSanitaria(10, 15, game, x, y);
			game.agregarEntidad(p);
		}

		game.eliminarEntidad(this);
		activo = false;
	}

	// ----------- Getters -----------
	/**
	 * Retorna el rango del infectado
	 * 
	 * @return rango del infectado
	 */
	public int getRango() {
		return rango;
	}

	// ----------- Setters -----------
	/**
	 * Modifica la direccion del infectado por la pasada por parametro
	 * 
	 * @param i, nueva direccion
	 */
	public void setDireccion(int i) {
		if (i == 1 || i == -1)
			this.mv.setDireccion(i);
	}

	/**
	 * Actualiza el valor del rango por el pasado por parametro
	 * 
	 * @param r, rango a actualizar
	 */
	public void setRango(int r) {
		rango = r;
	}

}
