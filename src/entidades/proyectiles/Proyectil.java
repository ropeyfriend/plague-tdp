package entidades.proyectiles;

import entidades.Entidad;
import entidades.EntidadGrafica;

public abstract class Proyectil extends Entidad{
    protected int velocidad;
    protected int direccion;
    
    public Proyectil() {
    }
    
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
