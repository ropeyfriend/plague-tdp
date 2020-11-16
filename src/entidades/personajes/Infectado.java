package entidades.personajes;

public abstract class Infectado extends Personaje{
	//Atributes
	protected int velocidad;
	protected int rango;
	protected float cargaViral;
	protected boolean infectado;

	public Infectado(String path, int vel, int r) {
		super(path);
		cargaViral = 100;
		velocidad = vel;
		rango = r;
		infectado = true;
	}
    
}
