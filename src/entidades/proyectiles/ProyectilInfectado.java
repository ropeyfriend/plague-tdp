package entidades.proyectiles;

import entidades.EntidadGrafica;
import entidades.movimiento.MovimientoVertical;
import entidades.personajes.Jugador;
import entidades.visitor.Visitor;
import juego.Juego;

/**Clase que modela al proyectil de un infectado*/

public class ProyectilInfectado extends Proyectil{
	//Atributes
	/*Representa el rango de las particulas exparcidas por los infectados*/
	protected int rango;
		
	/**Crea un nuevo proyectil infectado*/
	public ProyectilInfectado(Juego g ,int x, int y) {
		super(g, 10, MovimientoVertical.ABAJO); //Va hacia abajo (1)
		rango = 5;
		activo = true;
		ruta_dibujo_moviendose = "src/recursos/Proyectiles/ProyectilInfectado.gif";
		entidadGrafica = new EntidadGrafica(ruta_dibujo_moviendose,x,y);
		mv = new MovimientoVertical(this, this.direccion);
	}
	
	public void accept(Visitor v) {
		v.visitarProyectil(this);	
	}
	
    /**Dispara al jugador pasado por parametro
     * @param j, jugador al cual disparar
     * */
	public void disparar(Jugador j) {
		j.recibirDanio(danio);
	}
	
	/**Retorna el rango del proyectil
	 * @return rango
	 * */
	public int getRango() {
		return rango;
	}
	
	@Override
	public boolean getMuerto() {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**Modifica el rango del proyectil por el pasado por parametro
	 * @param r, rango a modificar
	 * */
	public void setRango(int r) {
		rango = r;
	}

	

}