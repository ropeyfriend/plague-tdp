package entidades.personajes;
import entidades.*;

public abstract class Personaje extends Entidad{
	//Atributes
	/*Representa la carga viral personaje*/
	protected float cargaViral;
	/*Representa la velocidad a la que se mueve el personaje*/
	protected int velocidad;
	
	//Getters
	/**Retorna la carga viral del personaje
	 * @return carga viral
	 * */
	public float getCargaViral() {
		return cargaViral;
	}
	
	/**Retorna la velocidad del personaje
	 * @return velocidad.
	 * */
	public int getVelocidad() {
		return velocidad;
	}
	
	/**Retorna la entidad grafica del personaje
	 * @return entidad grafica.
	 * */
	public EntidadGrafica getEntidadGrafica() {
		return entidadGrafica;
	}
	
	
	//Setters
	/**Modifica el valor de la carga viral por el pasado por parametro
	 * @param c, carga viral a modificar
	 * */
	public void setCargaViral(int c) {
		cargaViral = c;
	}
	
	/**Modifica el valor de la velocidad por el pasado por parametro
	 * @param v, velocidad a modificar
	 * */
	public void setVelocidad(int v) {
		velocidad = v;
	}
	
	/**Modifica el valor de la la entidad grafica por el pasado por parametro
	 * @param e, entidad grafica a modificar.
	 * */
	public void setEntidadGrafica(EntidadGrafica e) {
		entidadGrafica = e;
	}

}
