package entidades;

import entidades.visitor.*;

/**Clase que modela una entidad del juego.
 * */

public abstract class Entidad {
	/**Representa la parte grafica de la entidad*/
    protected EntidadGrafica entidadGrafica;
    /**Representa al visitor de la entidad*/
    protected Visitor visitor;
    /**Ruta de el gif que contiene al dibujo de la entidad moviendose*/
	protected String ruta_dibujo_moviendose;
	/**Ruta de el gif que contiene al dibujo de la entidad atacando*/
	protected String ruta_dibujo_ataque;
    
	/**Se encarga de aceptar al visitor pasado por parametro
	 * @param v, visitor a aceptar*/
    public abstract void accept(Visitor v);

}
