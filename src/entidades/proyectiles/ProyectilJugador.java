package entidades.proyectiles;

import entidades.EntidadGrafica;
import entidades.movimiento.MovimientoVertical;
import entidades.visitor.ProyectilJugadorVisitor;
import entidades.visitor.Visitor;
import juego.Juego;

/**Clase que modela al proyectil del jugador*/

public class ProyectilJugador extends Proyectil{
	
	/** Velocidad constante del proyectil de un jugador */
	protected static final int velocidad = 20;
	
	/** Rango constante del proyectil del jugador */
	protected static final int rango = 500;
	
	/**Crea un nuevo proyectil del jugador*/
	public ProyectilJugador(Juego g ,int x, int y, boolean superArmaSanitaria) {
		super(g, velocidad ,MovimientoVertical.ARRIBA, rango, y); //Va hacia arriba (-1)
		danio = 10;
		activo = true;
		ruta_dibujo_moviendose = "/recursos/Proyectiles/ProyectilJugador.gif";
		entidadGrafica = new EntidadGrafica(ruta_dibujo_moviendose,x,y);
		mv = new MovimientoVertical(this, this.direccion);
		visitor = new ProyectilJugadorVisitor(this);
		
		if (superArmaSanitaria) {
			danio = danio * 3;
			ruta_dibujo_moviendose = "/recursos/Proyectiles/SuperArmaSanitaria.gif";
			entidadGrafica.updateImagen(ruta_dibujo_moviendose);
		}
	}
	
	public void accept(Visitor v) {
		v.visitarProyectil(this);	
	}
	
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
