package entidades.personajes;

public abstract class Infectado extends Personaje{
	//Atributes
	protected int velocidad;
	protected int rango;
	protected float cargaViral;
	protected boolean infectado;

	public Infectado(int vel, int r) {
		super();
		cargaViral = 100;
		velocidad = vel;
		rango = r;
		infectado = true;
	}
    
}
