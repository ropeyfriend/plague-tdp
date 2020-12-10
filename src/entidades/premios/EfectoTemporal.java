package entidades.premios;

import juego.Juego;

public abstract class EfectoTemporal extends Premio {
	/**Representa el tiempo de duracion del efecto temporal*/
	protected int duracion;
	
	/**Crea un nuevo efecto temporal
	 * @param d, duracion del efecto
	 * */
	public EfectoTemporal(int d, Juego g) {
		super(g);
		duracion = d;
	}	
	
	//------- Getter -------
	/**Obtiene la duracion del efecto temporal
	 * @return duracion del efecto
	 * */
	public int getDuracion() {
		return duracion;
	}
	
	//------- Setter -------
	/**Modifica la duracion del efecto temporal por la pasada por parametro
	 * @param d, duracion a modificar
	 * */
	public void setDuracion(int d) {
		duracion = d;
	}
}