package entidades.proyectiles;

import entidades.EntidadGrafica;
import entidades.movimiento.MovimientoVertical;
import entidades.visitor.ProyectilInfectadoVisitor;
import entidades.visitor.Visitor;
import juego.Juego;

/**Clase que modela al proyectil de un infectado*/

public class ProyectilInfectado extends Proyectil{
	
	/**Crea un nuevo proyectil infectado*/
	public ProyectilInfectado(Juego g ,int x, int y, int d, int r) {
		super(g, 10, MovimientoVertical.ABAJO, r, y); //Va hacia abajo (1)
		danio = d;
		activo = true;
		ruta_dibujo_moviendose = "/recursos/Proyectiles/ProyectilInfectado.gif";
		entidadGrafica = new EntidadGrafica(ruta_dibujo_moviendose,x,y);
		mv = new MovimientoVertical(this, this.direccion);
		visitor = new ProyectilInfectadoVisitor(this);
	}
	
	public void accept(Visitor v) {
		v.visitarProyectil(this);	
	}
	
	/**Retorna el rango del proyectil
	 * @return rango
	 * */
	public int getRango() {
		return rango;
	}
	
	
	/**Modifica el rango del proyectil por el pasado por parametro
	 * @param r, rango a modificar
	 * */
	public void setRango(int r) {
		rango = r;
	}	

}