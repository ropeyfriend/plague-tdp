package entidades;

import entidades.visitor.*;
import juego.Juego;

/** Clase que modela una entidad del juego. */

public abstract class Entidad {
	/** Representa el juego de la entidad */
	protected Juego game;
	/** Representa la parte grafica de la entidad */
	protected EntidadGrafica entidadGrafica;
	/** Representa al visitor de la entidad */
	protected Visitor visitor;
	/** Ruta de el gif que contiene al dibujo de la entidad moviendose */
	protected String ruta_dibujo_moviendose;
	/** Ruta de el gif que contiene al dibujo de la entidad atacando */
	protected String ruta_dibujo_ataque;
	/** Representa la velocidad a la que se mueve el personaje */
	protected int velocidad;
	/** Indica si la entidad esta activa y si fue eliminada del juego */
	protected boolean activo;

	/** Crea una nueva entidad */
	public Entidad() {
	}

	// ----------- Methods -----------
	/**
	 * Se encarga de aceptar al visitor pasado por parametro
	 * 
	 * @param v, visitor a aceptar
	 */
	public abstract void accept(Visitor v);

	/** Define el comportamiento de la entidad */
	public abstract void jugar();

	// ----------- Getters -----------
	/**
	 * Retorna la entidad grafica del personaje
	 * 
	 * @return entidad grafica.
	 */
	public EntidadGrafica getEntidadGrafica() {
		return entidadGrafica;
	}

	/**
	 * Retorna true si la entidad esta activa
	 * 
	 * @return true si esta activa
	 */
	public boolean getActivo() {
		return activo;
	}

	/**
	 * Retorna la velocidad del personaje
	 * 
	 * @return velocidad.
	 */
	public int getVelocidad() {
		return velocidad;
	}

	/**
	 * Retorna el juego de la entidad
	 * 
	 * @return juego
	 */
	public Juego getJuego() {
		return game;
	}

	/**
	 * Retorna el visitor de la entidad
	 * 
	 * @return visitor
	 */
	public Visitor getVisitor() {
		return visitor;
	}

	// ----------- Setters -----------
	/**
	 * Modifica el valor de la velocidad por el pasado por parametro
	 * 
	 * @param v, velocidad a modificar
	 */
	public void setVelocidad(int v) {
		velocidad = v;
	}

	/**
	 * Modifica el valor de activo por el pasado por parametro
	 * 
	 * @param a, variable a modificar
	 */
	public void setActivo(boolean a) {
		activo = a;
	}

	/**
	 * Modifica el valor de la la entidad grafica por el pasado por parametro
	 * 
	 * @param e, entidad grafica a modificar.
	 */
	public void setEntidadGrafica(EntidadGrafica e) {
		entidadGrafica = e;
	}

	/**
	 * Modifica el valor de juego por el pasado por parametro
	 * 
	 * @param g, variable a modificar
	 */
	public void setJuego(Juego g) {
		game = g;
	}

}