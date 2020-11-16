package entidades.personajes;

public class InfectadoAlpha extends Infectado{
	/*Cantidad de danio que le hace al jugador*/
	protected int cantDanioJugador;
	/*Cantidad de danio que recibe al ser golpeado por el jugador*/
	protected float danio_a_recibir;
	
	public InfectadoAlpha(String path, int vel,int r){
		super(path, vel, r);
		cantDanioJugador = 20;
		danio_a_recibir = 12.5F;
	}
	
	public void recibirDanio(){	//(Como le resto de a 12.5 entonces se muere en 8 golpes)
		if(cargaViral >= danio_a_recibir) {//Si la cargaViral es cero, no sigo desinfectandolo
			cargaViral -= danio_a_recibir;
			
			if(cargaViral == 0) {
				infectado = false;
			}
			
			if(cargaViral < 20 && cargaViral != 0) {//Si la cargaV es menor a 20 y esta infectado, duplican su velocidad
				velocidad = velocidad*2;
			}
		}
	}
	
	public void atacar(Jugador j) {
		j.recibirDanio(cantDanioJugador);
	}

}
