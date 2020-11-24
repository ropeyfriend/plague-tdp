package entidades.personajes;

/**Clase que modela a un infectado del juego*/

public abstract class Infectado extends Personaje{
	//Atributes
	/**Representa el rango donde se exparcen las particulas del infectado*/
	protected int rango;
	/**Cantidad de danio que le hace al jugador*/
	protected int cantDanioJugador;
	/**Cantidad de danio que recibe al ser golpeado por el jugador*/
	protected float danio_a_recibir;

	public Infectado(int vel, int r) {
		cargaViral = 100;
		velocidad = vel;
		rango = r;
	}
	
	/**Disminuye la carga viral del infectado*/
	 public abstract void recibirDanio();
	 
	/**Ataca al jugador pasado por parametro
	 * @param j, jugador a atacar
	 * */
	 public abstract void atacar(Jugador j);
	
	 /**Actualiza la imagen del infectado por la de caminar*/
	 public abstract void updateImagenCaminar();
	 
	 /**Actualiza la imagen del infectado por la de ataque*/
	 public abstract void updateImagenAtaque();
	 
	//Getters
	 /**Retorna el rango del infectado
	  * @return rango del infectado
	  * */
	public int getRango() {
		return rango;
	}
	
	/**Retorna la cantidad de danio que recibe el infectado
	 * @return danio que recibe el infectado
	 * */
	public float getDanio_a_recibir() {
		return danio_a_recibir;
	}
	
	/**Retorna la cantidad de danio que el infectado le hace al jugador
	 * @return danio hacia el jugador
	 * */
	public int getCantDanioJugador() {
		return cantDanioJugador;
	}
	
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
	public void setDanio_a_recibir(float d) {
		danio_a_recibir = d;
	}
	
	/**Actualiza el valor del danio que recibe el jugador por el pasado por parametro
	 * @param d, danio a actualizar.
	 * */
	public void setCantDanioJugador(int d) {
		cantDanioJugador = d;
	}
    
}
