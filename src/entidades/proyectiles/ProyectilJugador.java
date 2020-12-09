package entidades.proyectiles;

import entidades.EntidadGrafica;
import entidades.movimiento.MovimientoVertical;
import entidades.personajes.Infectado;
import entidades.visitor.ProyectilJugadorVisitor;
import entidades.visitor.Visitor;
import juego.Juego;

/**Clase que modela al proyectil del jugador*/

public class ProyectilJugador extends Proyectil{
	
	/**Crea un nuevo proyectil del jugador*/
	public ProyectilJugador(Juego g ,int x, int y) {
		super(g, 10 ,MovimientoVertical.ARRIBA); //Va hacia arriba (-1)
		danio = 10;
		activo = true;
		ruta_dibujo_moviendose = "src/recursos/Proyectiles/ProyectilJugador.gif";
		entidadGrafica = new EntidadGrafica(ruta_dibujo_moviendose,x,y);
		mv = new MovimientoVertical(this, this.direccion);
		visitor = new ProyectilJugadorVisitor(this);
	}
	
	
	public void accept(Visitor v) {
		v.visitarProyectil(this);	
	}
	
	/**Multiplica la capacidad de desinfeccion por la pasada por parametro
	 * @param valor a multiplicar
	 * */
	public void efectoSuper(int valor) {
		danio = danio * valor;
	}

	//Getters
	
	/**Retorna la capacidad de desinfeccion del proyectil
	 * @return capacidad de desinfeccion
	 * */
	public double getdanio() {
		return danio;
	}
	
	//Setters
	/**Modifica la capacidad de desinfeccion del protectil por el pasado por parametro
	 * @param c, capacidad de decinfeccion a modificar
	 * */
	public void setdanio(int c) {
		danio = c;
	}	

}
