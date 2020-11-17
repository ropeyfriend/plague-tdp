package entidades.personajes;
import entidades.*;

public abstract class Personaje extends Entidad{
	//Atributes
	protected int cargaViral;
	protected int velocidad;
	
	public Personaje() {
		super();
	}
	
	public int getCargaViral() {
		return cargaViral;
	}
	
	public int getVelocidad() {
		return velocidad;
	}
	
	public void setCargaViral(int c) {
		cargaViral = c;
	}
	
	public void setVelocidad(int v) {
		velocidad = v;
	}

}
