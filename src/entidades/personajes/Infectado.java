package entidades.personajes;

import entidades.proyectiles.ProyectilInfectado;
import juego.Juego;

/**Clase que modela a un infectado del juego*/

public abstract class Infectado extends Personaje{
	//Atributes
	/**Representa el rango donde se exparcen las particulas del infectado*/
	protected int rango;
	/**Cantidad de danio que recibe al ser golpeado por el jugador*/
	protected float danio_a_recibir;

	/**Crea un nuevo infectado
	 * @param vel, velocidad del infectado
	 * @param r, rango del infectado
	 * */
	public Infectado(int vel, int r, Juego g) {
		cargaViral = 100;
		velocidad = vel;
		game = g;
		//p = new ProyectilInfectado();
		rango = r;
	}
	 
	//Methods
	/**Ataca al jugador pasado por parametro
	 * @param j, jugador a atacar
	 * */
	 public abstract void atacar(Jugador j);
	 
	//Getters
	 /**Retorna el rango del infectado
	 * @return rango del infectado
	 * */
	public int getRango() {
		return rango;
	}
	
	/*/**Retorna la cantidad de danio que recibe el infectado
	 * @return danio que recibe el infectado
	 * */
	/*public float getDanio_a_recibir() {
		return danio_a_recibir;
	}*/
	
	//Setters
	/**Actualiza el valor del rango por el pasado por parametro
	 * @param r, rango a actualizar
	 * */
	public void setRango(int r) {
		rango = r;
	}
	
	/**Actualiza el valor del danio que recibe el infectado por el pasado por parametro
	 * @param d, danio a actualizar.
	 * */
	/*public void setDanio_a_recibir(float d) {
		danio_a_recibir = d;
	}*/
    
}
