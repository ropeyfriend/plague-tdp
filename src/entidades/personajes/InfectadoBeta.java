package entidades.personajes;

public class InfectadoBeta extends Infectado{
	//Atributes
	/*Cantidad de danio que le hace al jugador*/
	protected int cantDanioJugador;
	/*Cantidad de danio que recibe al ser golpeado por el jugador*/
	protected float danio_a_recibir;
	
	public InfectadoBeta(String path, int vel, int r) {
		super(path, vel, r);
		cantDanioJugador = 10;
		danio_a_recibir = 10;
	}

	public void recibirDanio() {//(Como le resto de a 10 entonces se muere en 10 golpes)
		if(cargaViral - danio_a_recibir>= 10) { //Si la cargaViral es cero, no sigo desinfectandolo
			cargaViral -= danio_a_recibir;
			
			if(cargaViral == 0) {
				infectado = false;
			}
		}
	}
	
	public void atacar(Jugador j) {
		j.recibirDanio(cantDanioJugador);
	}

}
