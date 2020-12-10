package entidades.movimiento;

import entidades.Entidad;
import entidades.EntidadGrafica;

/**Clase que modela el moviemiento vertical de las entidades*/

public class MovimientoVertical extends EstrategiaMovimiento {
	/**
	 * constantes de direccion
	 */
	public static final int ARRIBA = -1;
	public static final int ABAJO = 1;
	
	/**Crea un nuevo movimiento vertical
	 * 
	 * @param entidad, entidad que ejecuta el movimiento
	 * @param direccion, direccion del movimiento
	 * */
	public MovimientoVertical(Entidad entidad, int direccion) {
		super(entidad, direccion);
	}
	
	public void mover() {
		EntidadGrafica g = e.getEntidadGrafica();
		g.setY(g.getY() + d * e.getVelocidad());
	}

}
