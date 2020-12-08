package entidades.movimiento;

import entidades.Entidad;
import entidades.EntidadGrafica;

public class MovimientoVertical extends EstrategiaMovimiento {
	
	public static final int ARRIBA = -1;
	public static final int ABAJO = 1;

	public MovimientoVertical(Entidad entidad, int direccion) {
		super(entidad, direccion);
	}
	
	public void mover() {
		EntidadGrafica g = e.getEntidadGrafica();
		g.setY(g.getY() + d * e.getVelocidad());
	}

}
