package entidades.movimiento;

import entidades.Entidad;
import entidades.EntidadGrafica;

public class MovimientoHorizontal extends EstrategiaMovimiento {
	
	public static final int DERECHA = 1;
	public static final int IZQUIERDA = -1;

	public MovimientoHorizontal(Entidad entidad, int direccion) {
		super(entidad, direccion);
	}
	
	public void mover() {
		EntidadGrafica g = e.getEntidadGrafica();
		g.setX(g.getX() + d * e.getVelocidad());
	}

}