package entidades.premios;

import entidades.EntidadGrafica;
import entidades.personajes.Jugador;
import entidades.visitor.PocionVisitor;
import entidades.visitor.Visitor;
import juego.Juego;

public class Pocion extends ObjetoPrecioso {
	/**Representa la cantidad de curacion de la pocion*/
	private int cantCuracion;
	
	/**
	 * Crea una pocion en una posicion
	 * @param x El valor x de la posicion en el mapa
	 * @param y El valor y de la posicion en el mapa
	 * @param g El juego al que pertenece
	 */
	public Pocion(int x, int y, Juego g) {
		super(g);
		cantCuracion = 25;
		ruta_dibujo_moviendose = "/recursos/Premios/ObjetosPreciosos/PocionVida.png";
		entidadGrafica = new EntidadGrafica(ruta_dibujo_moviendose, x, y);
		visitor = new PocionVisitor(this);
	}
	/**Crea una nueva pocion
	 * @param g El juego al que pertenece
	 * */
	public Pocion(Juego g) {
		super(g);
		cantCuracion = 25;
	}
	
	//Methods
	/**Cura al jugador pasado por parametro
	 * @param j, jugador a curar
	 * */
	public void startEffect(Jugador j) {
		j.curar(cantCuracion);
	}
	
	//------ Getter ------ 
	/**Obtiene la cantidad de curacion
	 * @return cantidad de curacion de la pocion
	 * */
	public int getCantCuracion() {
		return cantCuracion;
	}
	
	//------ Setter ------ 
	/**Modifica el valor de la cantidad de curacion por el pasado por parametro
	 * @param cant, cantidad de curacion a modificar
	 * */
	public void setCantCuracion(int cant) {
		cantCuracion = cant;
	}

	@Override
	public void accept(Visitor v) {
		v.visitarPocion(this);
	}

}