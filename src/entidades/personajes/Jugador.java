package entidades.personajes;
import entidades.EntidadGrafica;
import entidades.proyectiles.*;
import entidades.visitor.*;

public class Jugador extends Personaje{
	
	//Atributes
	/*Arma para desinfectar a los infectados*/
	protected ProyectilJugador armaSanitaria;
	/*Indica si el juagador esta vivo o muerto*/
	protected boolean vivo;
	/*Representa la parte grafica del jugador*/
	private EntidadGrafica entidadGrafica;

	public Jugador(ProyectilJugador p, int vel) {
		super();
		cargaViral = 0;
		velocidad = vel;
		armaSanitaria = p;
		vivo = true;
		visitor = new JugadorVisitor(this);
		/*ruta_dibujo_moviendose = "img/enemigos/Jugador.gif";
		ruta_dibujo_ataque = "img/enemigos/Jugador_ataque.gif";*/
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
	
	public void updateImagenAtaque() {
		entidadGrafica.updateImagen(ruta_dibujo_ataque);
	}
	
	public void updateImagenCaminar() {
		entidadGrafica.updateImagen(ruta_dibujo_moviendose);
	}
	
	public void accept(Visitor v){
		v.visitarJugador(this);
	} 
}
