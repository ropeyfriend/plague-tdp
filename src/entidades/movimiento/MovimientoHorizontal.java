package entidades.movimiento;

import entidades.Entidad;
import entidades.EntidadGrafica;

/**Clase que modela el moviemiento horizontal de las entidades*/

public class MovimientoHorizontal extends EstrategiaMovimiento {
	/**
	 * Constantes de direccion
	 */
	public static final int DERECHA = 1;
	public static final int IZQUIERDA = -1;

	/**Crea un nuevo movimiento horizontal
	 * 
	 * @param entidad, entidad que ejecuta el movimiento
	 * @param direccion, direccion del movimiento
	 * */
	public MovimientoHorizontal(Entidad entidad, int direccion) {
		super(entidad, direccion);
	}
	
	public void mover() {
		EntidadGrafica g = e.getEntidadGrafica();
		g.setX(g.getX() + d * e.getVelocidad());
	}

}