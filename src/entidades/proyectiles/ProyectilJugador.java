package entidades.proyectiles;

import entidades.personajes.InfectadoAlpha;
import entidades.personajes.InfectadoBeta;
import entidades.visitor.Visitor;

public class ProyectilJugador extends Proyectil{
	//Atributes
	/*Representa la capacidad de desinfeccion del virus del proyectil del jugador*/
	protected int capacidadDesinfeccion;
	
	public ProyectilJugador() {
		super();
		direccion = 1; //Va hacia ARRIBA
		velocidad = 5;
		capacidadDesinfeccion = 10;
	}
	
	//Methods
	public void desinfectarAlpha(InfectadoAlpha i) {
		i.recibirDanio();
	}
	
	public void desinfectarBeta(InfectadoBeta i) {
		i.recibirDanio();
	}
	
	public void accept(Visitor v) {
		v.visitarProyectil(this);	
	}
	
	/*
	public void efectoSuper() {//----------------------------------------------------------------------Preguntar
		capacidadDesinfeccion =capacidadDesinfeccion * 2;
	}*/
	
	//Getters
	public int getCapacidadDesinfeccion() {
		return capacidadDesinfeccion;
	}
	
	public void setCapacidadDesinfeccion(int c) {
		capacidadDesinfeccion = c;
	}
	

}
