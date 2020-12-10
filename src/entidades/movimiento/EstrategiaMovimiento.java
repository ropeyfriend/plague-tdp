package entidades.movimiento;

import entidades.Entidad;

/**Clase que modela la estrategia de moviemiento de las entidades*/

public abstract class EstrategiaMovimiento {
	/**Representa la direccion del movimiento*/
	protected int d;
	/**Representa la entidad que realiza el movimiento*/
	protected Entidad e;
	
	/**Crea una nueva estrategia
	 * 
	 * @param entidad, entidad de la estrategia
	 * @param direccion, direccion de la estrategia*/
	public EstrategiaMovimiento(Entidad entidad, int direccion) {
		e = entidad;
		d = direccion;
	}
	
	/**Se encarga de mover a la entidad en el mapa*/
	public abstract void mover();
	
	//----------- Setters -----------
	/**Modifica la direccion por la pasada por parametro
	 * 
	 * @param direccion, nueva direccion
	 * */
	public void setDireccion(int direccion) {
		d = direccion;
	}
	
	/**Modifica la entidad por la pasada por parametro
	 * 
	 * @param entidad, entidad nueva
	 * */
	public void setEntidad(Entidad entidad) {
		e = entidad;
	}
	
	// ----------- Getters -----------
	/**Obtiene la entidad del movimiento
	 * 
	 * @return entidad del movimiento
	 * */
	public Entidad getEntidad() {
		return e;
	}
	
	/**Obtiene la direccion del movimiento
	 * 
	 * @return direccion del movimiento
	 * */
	public int getDireccion() {
		return d;
	}
	
}