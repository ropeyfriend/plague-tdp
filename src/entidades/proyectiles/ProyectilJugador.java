package entidades.proyectiles;

import entidades.personajes.Infectado;
import entidades.visitor.Visitor;

/**Clase que modela al proyectil del jugador*/

public class ProyectilJugador extends Proyectil{
	//Atributes
	/*Representa la capacidad de desinfeccion del virus del proyectil del jugador*/
	protected int capacidadDesinfeccion;
	
	/**Crea un nuevo proyectil del jugador*/
	public ProyectilJugador() {
		super(5,1);//Va hacia arriba (1)
		capacidadDesinfeccion = 10;
		/*ruta_dibujo_moviendose = "recursos/Proyectiles/ProyectilJugador.gif";
		ruta_dibujo_ataque = "recursos/Proyectiles/ProyectilJugador_ataque.gif";*/
	}
	
	//Methods
	/**Desinfecta a un infectado
	 * @param i, infectado a desinfectar
	 * */
	public void desinfectar(Infectado i) {
		i.recibirDanio();
	}
	
	public void accept(Visitor v) {
		v.visitarProyectil(this);	
	}
	
	/**Multiplica la capacidad de desinfeccion por la pasada por parametro
	 * @param valor a multiplicar
	 * */
	public void efectoSuper(int valor) {
		capacidadDesinfeccion = capacidadDesinfeccion * valor;
	}
	
	public void mover() {}
	
	//Getters
	/**Retorna la capacidad de desinfeccion del proyectil
	 * @return capacidad de desinfeccion
	 * */
	public int getCapacidadDesinfeccion() {
		return capacidadDesinfeccion;
	}
	
	//Setters
	/**Modifica la capacidad de desinfeccion del protectil por el pasado por parametro
	 * @param c, capacidad de decinfeccion a modificar
	 * */
	public void setCapacidadDesinfeccion(int c) {
		capacidadDesinfeccion = c;
	}
	

}
