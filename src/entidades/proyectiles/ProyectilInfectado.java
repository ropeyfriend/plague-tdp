package entidades.proyectiles;

import entidades.visitor.Visitor;

public class ProyectilInfectado extends Proyectil{
	//Atributes
	/*Representa el rango de las particulas exparcidas por los infectados*/
	protected int rango;
	
	public ProyectilInfectado() {
		direccion = -1; //Va hacia ABAJO
		velocidad = 3;
		rango = 5;	
	}
	
	public int getRango() {
		return rango;
	}
	
	public void setRango(int r) {
		rango = r;
	}
	
	public void accept(Visitor v) {
		v.visitarProyectil(this);	
	}

}
