package entidades.proyectiles;

import entidades.Entidad;
import entidades.EntidadGrafica;
import entidades.movimiento.MovimientoVertical;
import juego.Juego;

/** Clase que modela a un proyectil */

public abstract class Proyectil extends Entidad {
	/** Representa la velocidad del proyectil */
	protected int velocidad;
	/** Representa la direccion a la cual se mueve el proyectil */
	protected int direccion;
	/** Indica si el proyectil esta activo o no */
	protected boolean activo;
	/** Indica la cantidad de danio que genera el proyectil */
	protected int danio;
	/** Indica la distancia que recorre el proyectil hasta desaparecer */
	protected int rango;
	/** Indica la coordenada y inicial de cada proyectil */
	protected int y_inicial;
	/**Representa el movimiento del proyectil*/
	protected MovimientoVertical mv;
	
	/**
	 * Crea un nuevo proyectil
	 * @param v, velocidad del proyectil
	 * @param d, direccion del proyectil
	 */
	public Proyectil(Juego g, int v, int d, int r, int y) {
		velocidad = v;
		direccion = d;
		game = g;
		y_inicial = y;
		rango = r;
	}
	
	public void jugar() {
		if (!fueraDelMapa(this.entidadGrafica.getY()) && !fueraDeRango(this.entidadGrafica.getY()))
			this.mv.mover();
		else 
			eliminarProyectil();
	}

	/**
	 * Verifica si la coordenada y pasada por parametro, esta dentrod el mapa
	 * @param y
	 * @return toret true si pertenece al mapa y false caso contrario
	 */
	private boolean fueraDelMapa(int y) {
		boolean toret = false;
		if (y < 0 || y + this.getEntidadGrafica().getLabel().getHeight() > game.getMapa().getHeight()) {
			toret = true;
		}
		return toret;
	}
	
	/**
	 * Dada una coordenada y, devuelve true si esta fuera de rango
	 * @param coordenada y
	 * @return true si esta en rango, false caso contrario
	 */
	private boolean fueraDeRango(int y) {
		boolean toret = false;
		int dif = Math.abs(y_inicial - y);
		if (dif > rango)
			toret = true;
		return toret;
	}
	
	/**
	 * Elimina el proyectil del juego
	 */
	public void eliminarProyectil() {
		game.eliminarEntidad(this);
	}
	
	/**
	 * Setea la direccion de movimiento con el valor entero pasado por parametro
	 * @param i entero que representa la direccion
	 */
	public void setDireccion(int i) {
		if (i == 1 || i == -1) {
			this.mv.setDireccion(i);
			this.direccion = i;
		}
	}

	/**
	 * Retorna la velocidad del proyectil
	 * 
	 * @return velocidad
	 */
	public int getVelocidad() {
		return velocidad;
	}

	/**
	 * Retorna la direccion del proyectil
	 * 
	 * @return direccion
	 */
	public int getDireccion() {
		return direccion;
	}

	/**
	 * Retorna si el proyectil esta o no activo
	 * 
	 * @return activo
	 */
	public boolean getActivo() {
		return activo;
	}

	/** Retorna el danio generado por el proyectil */
	public int getDanio() {
		return danio;
	}

	/**
	 * Retorna la entidad grafica del proyectil
	 * 
	 * @return entidad grafica
	 */
	public EntidadGrafica getEntidadGrafica() {
		return entidadGrafica;
	}

	/**
	 * Modifica la velocidad del proyectil por la pasada por parametro
	 * 
	 * @param velocidad a modificar
	 */
	public void setVelocidad(int v) {
		velocidad = v;
	}

	/**
	 * Modifica la variable activo por la pasada por parametro
	 * 
	 * @param a, variable a modificar
	 */
	public void setActivo(boolean a) {
		activo = a;
	}

	/**
	 * Modifica el danio por el pasado por parametro
	 * 
	 * @param d, danio a modificar
	 */
	public void setDanio(int d) {
		danio = d;
	}

	/**
	 * Modifica la entidad grafica del proyectil por la pasada por parametro
	 * 
	 * @param entidad a modificar
	 */
	public void setEntidadGrafica(EntidadGrafica e) {
		entidadGrafica = e;
	}
}