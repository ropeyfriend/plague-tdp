package entidades.premios;

import java.util.Timer;
import java.util.TimerTask;

import entidades.EntidadGrafica;
import entidades.personajes.Jugador;
import entidades.visitor.Visitor;
import juego.Juego;

public class Pocion extends ObjetoPrecioso {
	/**Representa la cantidad de curacion de la pocion*/
	private int cantCuracion;
	
	/**Crea una nueva pocion*/
	public Pocion(int x, int y, Juego g) {
		super(g);
		cantCuracion = 25;
		ruta_dibujo_moviendose = "src/recursos/Premios/ObjetosPreciosos/PocionVida.png";
		entidadGrafica = new EntidadGrafica(ruta_dibujo_moviendose, x, y);
	}
	
	//Methods
	/**Cura al jugador pasado por parametro
	 * @param j, jugador a curar
	 * */
	public void startEffect(Jugador j) {
		j.curar(cantCuracion);
	}
	
	//Getter
	/**Obtiene la cantidad de curacion
	 * @return cantidad de curacion de la pocion
	 * */
	public int getCantCuracion() {
		return cantCuracion;
	}
	
	//Setter
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