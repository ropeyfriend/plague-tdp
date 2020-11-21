package entidades.personajes;


public abstract class Infectado extends Personaje{
	//Atributes
	/*Representa el rango donde se exparcen las particulas del infectado*/
	protected int rango;
	/*Cantidad de danio que le hace al jugador*/
	protected int cantDanioJugador;
	/*Cantidad de danio que recibe al ser golpeado por el jugador*/
	protected float danio_a_recibir;
	/*Indica si el personaje esta infectado o no*/
	protected boolean estaInfectado;

	public Infectado(int vel, int r) {
		super();
		cargaViral = 100;
		velocidad = vel;
		rango = r;
		estaInfectado = true;
	}
	
	 public abstract void recibirDanio();
	 
	 public abstract void atacar(Jugador j);
	
	//Getters
	public int getRango() {
		return rango;
	}
	
	public boolean getEstaInfectado() {
		return estaInfectado;
	}
	
	public float getDanio_a_recibir() {
		return danio_a_recibir;
	}
	
	public int getCantDanioJugador() {
		return cantDanioJugador;
	}
	
	//Setters
	public void setRango(int r) {
		rango = r;
	}
	
	public void setDanio_a_recibir(float d) {
		danio_a_recibir = d;
	}
	
	public void setCantDanioJugador(int d) {
		cantDanioJugador = d;
	}
	
	public void setEstaInfectado(boolean i) {
		estaInfectado = i;
	}
    
}
