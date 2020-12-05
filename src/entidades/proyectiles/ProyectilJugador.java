package entidades.proyectiles;

import entidades.EntidadGrafica;
import entidades.personajes.Infectado;
import entidades.visitor.Visitor;

/**Clase que modela al proyectil del jugador*/

public class ProyectilJugador extends Proyectil{
	
	/**Crea un nuevo proyectil del jugador*/
	public ProyectilJugador(int x, int y) {
		super(5,1);//Va hacia arriba (1)
		danio = 10;
		activo = true;
		ruta_dibujo_moviendose = "recursos/Proyectiles/ProyectilJugador.gif";
		entidadGrafica = new EntidadGrafica(ruta_dibujo_moviendose,x,y);
	}
	
	//Methods
	/**Desinfecta a un infectado
	 * @param i, infectado a desinfectar
	 * */
	public void disparar(Infectado i) {
		i.recibirDanio(danio);
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
	
	public void mover() {}
	
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

	@Override
	public boolean getMuerto() {
		// TODO Auto-generated method stub
		return false;
	}
	

}
