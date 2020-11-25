package entidades.proyectiles;

import entidades.personajes.Jugador;
import entidades.visitor.Visitor;

/**Clase que modela al proyectil de un infectado*/

public class ProyectilInfectado extends Proyectil{
	//Atributes
	/*Representa el rango de las particulas exparcidas por los infectados*/
	protected int rango;
	
	/**Crea un nuevo proyectil infectado*/
	public ProyectilInfectado() {
		super(3,-1); //Va hacia abajo (-1)
		rango = 5;
		activo = true;
		ruta_dibujo_moviendose = "recursos/Proyectiles/ProyectilInfectado.gif";
	}
	
	//Methods
	public void mover() {
		
	}
	
	public void accept(Visitor v) {
		v.visitarProyectil(this);	
	}
	
	public void disparar(Jugador j, int d) {
		j.recibirDanio(d);
	}
	
	//Getter
	/**Retorna el rango del proyectil
	 * @return rango
	 * */
	public int getRango() {
		return rango;
	}
	
	//Setter
	/**Modifica el rango del proyectil por el pasado por parametro
	 * @param r, rango a modificar
	 * */
	public void setRango(int r) {
		rango = r;
	}

}