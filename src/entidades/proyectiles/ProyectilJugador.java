package entidades.proyectiles;

import entidades.personajes.Infectado;
import entidades.visitor.Visitor;

public class ProyectilJugador extends Proyectil{
	//Atributes
	/*Representa la capacidad de desinfeccion del virus del proyectil del jugador*/
	protected int capacidadDesinfeccion;
	
	public ProyectilJugador() {
		super(5,1);//Va hacia arriba (1)
		capacidadDesinfeccion = 10;
		/*ruta_dibujo_moviendose = "img/enemigos/ProyectilJugador.gif";
		ruta_dibujo_ataque = "img/enemigos/ProyectilJugador_ataque.gif";*/
	}
	
	//Methods
	public void desinfectar(Infectado i) {
		i.recibirDanio();
	}
	
	public void accept(Visitor v) {
		v.visitarProyectil(this);	
	}
	
	public void efectoSuper(int valor) {
		capacidadDesinfeccion = capacidadDesinfeccion * valor;
	}
	
	public void mover() {}
	
	//Getters
	public int getCapacidadDesinfeccion() {
		return capacidadDesinfeccion;
	}
	
	//Setters
	public void setCapacidadDesinfeccion(int c) {
		capacidadDesinfeccion = c;
	}
	

}
