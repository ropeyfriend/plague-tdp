package entidades.movimiento;

import entidades.Entidad;

public abstract class EstrategiaMovimiento {
	
	protected int d;
	protected Entidad e;
	
	public EstrategiaMovimiento(Entidad entidad, int direccion) {
		e = entidad;
		d = direccion;
	}
	
	public int getDireccion() {
		return d;
	}
	
	public void setDireccion(int direccion) {
		d = direccion;
	}
	
	public Entidad getEntidad() {
		return e;
	}
	
	public void setEntidad(Entidad entidad) {
		e = entidad;
	}
	
	public abstract void mover();
}