package entidades.proyectiles;

import entidades.Entidad;
import entidades.EntidadGrafica;

public abstract class Proyectil extends Entidad{
	/*Representa la velocidad del proyectil*/
    protected int velocidad;
    /*Representa la direccion a la cual se mueve el proyectil*/
    protected int direccion;
    
    public Proyectil(int v, int d) {
    	velocidad = v;
    	direccion = d;
    }
    
    public abstract void mover();
    
    //Getters
    public int getVelocidad() {
    	return velocidad;
    }
    
    public int getDireccion() {
    	return direccion;
    }

	public EntidadGrafica getEntidadGrafica() {
		return entidadGrafica;
	}
	
	//Setters
	public void setEntidadGrafica(EntidadGrafica e) {
		entidadGrafica = e;
	}
	
	public void setVelocidad(int v) {
		velocidad = v;
	}
	
	public void setDireccion(int d) {
		direccion = d;
	}
    
}
