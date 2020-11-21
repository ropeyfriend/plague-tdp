package entidades.proyectiles;

import entidades.visitor.Visitor;

public class ProyectilInfectado extends Proyectil{
	//Atributes
	/*Representa el rango de las particulas exparcidas por los infectados*/
	protected int rango;
	
	public ProyectilInfectado() {
		super(3,-1); //Va hacia abajo (-1)
		rango = 5;
		/*ruta_dibujo_moviendose = "img/enemigos/ProyectilInfectado.gif";
		ruta_dibujo_ataque = "img/enemigos/ProyectilInfectado_ataque.gif";*/
	}
	
	//Methods
	public void mover() {
		
	}
	
	public void accept(Visitor v) {
		v.visitarProyectil(this);	
	}
	
	//Getters
	public int getRango() {
		return rango;
	}
	
	//Setters
	public void setRango(int r) {
		rango = r;
	}

}