package entidades.personajes;
import entidades.*;
import entidades.proyectiles.Proyectil;

public abstract class Personaje extends Entidad{
	//Atributes
	/**Representa la carga viral personaje*/
	protected float cargaViral;
	/**Indica si es personaje esta muerto*/
	protected boolean muerto;
	/**Representa el danio que ejerce el personaje*/
	protected int danio; 
	 
	/**Disminuye la carga viral del infectado*/
	 public abstract void recibirDanio(int d);
	
	//Getters
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
	
	/**Retorna si el personaje esta o no muerto
	 * @return muerto
	 * */
	public boolean getMuerto() {
		return muerto;
	}
	
	//Setters
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
	
	/**Modifica el valor de la variable muerto por la pasada por parametro
	 * @param m, variable a modificar
	 * */
	public void setMuerto(boolean m) {
		muerto = m;
	}

}
