package entidades.personajes;
import entidades.*;
import entidades.proyectiles.Proyectil;

public abstract class Personaje extends Entidad{
	//Atributes
	
	/**Representa la carga viral personaje*/
	protected float cargaViral;
	/**Representa el danio que ejerce el personaje*/
	protected int danio; 
	/**String que representa la ruta donde se guarda el dibujo del personaje siendo golpeado*/
	protected String ruta_dibujo_hit;
	 
	/**
	 * Recibe daño (carga viral o desinfeccion) dado el proyectil que recibe
	 * @param p El proyectil que recibe
	 */
	 public abstract void recibirDanio(Proyectil p);
	
	/**
	 * Ejecuta un disparo 
	 */
	public abstract void disparar();
		
	//------- Getters ------- 
	/**Retorna la carga viral del personaje
	 * @return carga viral
	 * */
	public float getCargaViral() {
		return cargaViral;
	}
	
	/**Retorna el danio del personaje
	 * @return danio
	 * */
    public int getDanio() {
    	return danio;
    }	
	
	// ------- Setters ------- 
	/**Modifica el valor de la carga viral por el pasado por parametro
	 * @param c, carga viral a modificar
	 * */
	public void setCargaViral(int c) {
		cargaViral = c;
	}
	
	/**Modifica el valor del danio por el pasado por parametro
	 * @param d, danio viral a modificar
	 * */
    public void setDanio(int d) {
    	danio = d;
    }

}
