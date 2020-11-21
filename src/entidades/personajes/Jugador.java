package entidades.personajes;
import entidades.EntidadGrafica;
import entidades.proyectiles.*;
import entidades.visitor.*;

public class Jugador extends Personaje{
	
	//Atributes
	/*Arma para desinfectar a los infectados*/
	protected ProyectilJugador armaSanitaria;
	/*Indica si el jugador esta vivo o muerto*/
	protected boolean muerto;

	public Jugador(ProyectilJugador p, int vel) {
		cargaViral = 0;
		velocidad = vel;
		armaSanitaria = p;
		muerto = false;
		visitor = new JugadorVisitor(this);
		entidadGrafica = new EntidadGrafica();
		/*ruta_dibujo_moviendose = "img/Jugador.gif";
		ruta_dibujo_ataque = "img/Jugador_ataque.gif";*/
	}

	//Methods
	public void atacarInfectado(Infectado i) {
		armaSanitaria.desinfectar(i);
	}
	
	public void recibirDanio(int danio){
		if(cargaViral+danio < 100) {
			cargaViral += danio;
			
			if(cargaViral == 100) {
				muerto = true;
			}
		}
	}
	
	public void updateImagenAtaque() {
		entidadGrafica.updateImagen(ruta_dibujo_ataque);
	}
	
	public void updateImagenCaminar() {
		entidadGrafica.updateImagen(ruta_dibujo_moviendose);
	}
	
	public void accept(Visitor v){
		v.visitarJugador(this);
	}
	
	//Setters
	public void setMuerto(boolean m) {
		muerto = m;
	}
	
	public void setArmaSanitaria(ProyectilJugador a) {
		armaSanitaria = a;
	}
	
	//Getters
	public boolean getMuerto() {
		return muerto;
	}
	
	public ProyectilJugador getArmaSanitaria() {
		return armaSanitaria;
	}
}
