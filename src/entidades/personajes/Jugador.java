package entidades.personajes;
import entidades.proyectiles.*;

public class Jugador extends Personaje{
	
	//Atributes
	/*Arma para desinfectar a los infectados*/
	protected ProyectilJugador armaSanitaria;
	/*Indica si el juagador esta vivo o muerto*/
	protected boolean vivo;

	public Jugador(String path,ProyectilJugador p, int vel) {
		super(path);
		cargaViral = 0;
		velocidad = vel;
		armaSanitaria = p;
		vivo = true;
	}

	public void atacarInfectadoAlpha(InfectadoAlpha a) {
		a.recibirDanio();	
	}
	
	public void atacarInfectadoBeta(InfectadoBeta b) {
		b.recibirDanio();
	}
	
	public void recibirDanio(int danio){
		if(cargaViral+danio < 100) {
			cargaViral += danio;
			
			if(cargaViral == 100) {
				vivo = false;
			}
		}
	
	}
}
