package entidades.personajes;
import entidades.*;

public abstract class Personaje extends Entidad{
	//Atributes
	/*Representa la carga viral personaje*/
	protected float cargaViral;
	/*Representa la velocidad a la que se mueve el personaje*/
	protected int velocidad;
	
	public Personaje() {
		super();
	}
	
	//Getters
	public float getCargaViral() {
		return cargaViral;
	}
	
	public int getVelocidad() {
		return velocidad;
	}
	
	//Setters
	public void setCargaViral(int c) {
		cargaViral = c;
	}
	
	public void setVelocidad(int v) {
		velocidad = v;
	}
	
	public EntidadGrafica getEntidadGrafica() {
		return entidadGrafica;
	}
	
	public void setEntidadGrafica(EntidadGrafica e) {
		entidadGrafica = e;
	}

}
