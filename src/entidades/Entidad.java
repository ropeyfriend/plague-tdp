package entidades;

import entidades.visitor.*;
import juego.Juego;

/**Clase que modela una entidad del juego.
 * */

public abstract class Entidad {
	/**Representa el juego de la entidad*/
	protected Juego game;
	/**Representa la parte grafica de la entidad*/
    protected EntidadGrafica entidadGrafica;
    /**Representa al visitor de la entidad*/
    protected Visitor visitor;
    /**Ruta de el gif que contiene al dibujo de la entidad moviendose*/
	protected String ruta_dibujo_moviendose;
	/**Ruta de el gif que contiene al dibujo de la entidad atacando*/
	protected String ruta_dibujo_ataque;
    
	public Entidad() {
	}
	
	/**Retorna la entidad grafica del personaje
	 * @return entidad grafica.
	 * */
	public EntidadGrafica getEntidadGrafica() {
		return entidadGrafica;
	}
	
	/**Modifica el valor de la la entidad grafica por el pasado por parametro
	 * @param e, entidad grafica a modificar.
	 * */
	public void setEntidadGrafica(EntidadGrafica e) {
		entidadGrafica = e;
	}
	
	/**Se encarga de aceptar al visitor pasado por parametro
	 * @param v, visitor a aceptar*/
    public abstract void accept(Visitor v);
    
    /**Verifica si la entidad fue eliminada del juego
     * @return true si la entidad fue eliminada
     * */
    public abstract boolean getMuerto();
    
}
