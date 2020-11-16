package entidades.personajes;
import entidades.*;

public abstract class Personaje extends Entidad{
	//Atributes
	protected int cargaViral;
	protected int velocidad;
	
	public Personaje(String path) {
		super(path);
	}
	
	public int getCargaViral() {
		return cargaViral;
	}
	
	public int getVelocidad() {
		return velocidad;
	}

}
