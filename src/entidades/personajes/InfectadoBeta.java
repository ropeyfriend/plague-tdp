package entidades.personajes;

import entidades.EntidadGrafica;
import entidades.visitor.InfectadoVisitor;
import entidades.visitor.Visitor;

public class InfectadoBeta extends Infectado{
	//Atributes
	/*Cantidad de danio que le hace al jugador*/
	protected int cantDanioJugador;
	/*Cantidad de danio que recibe al ser golpeado por el jugador*/
	protected float danio_a_recibir;
	/*Representa la parte grafica del infectado Alpha*/
	private EntidadGrafica entidadGrafica;
	
	public InfectadoBeta(int vel, int r) {
		super(vel, r);
		cantDanioJugador = 10;
		danio_a_recibir = 10;
		this.entidadGrafica = new EntidadGrafica();
		visitor = new InfectadoVisitor(this);
		/*ruta_dibujo_moviendose = "img/enemigos/InfectadoBeta.gif";
		ruta_dibujo_ataque = "img/enemigos/InfectadoBeta_ataque.gif";*/
	}

	public void recibirDanio() {//(Como le resto de a 10 entonces se muere en 10 golpes)
		if(cargaViral - danio_a_recibir>= 10) { //Si la cargaViral es cero, no sigo desinfectandolo
			cargaViral -= danio_a_recibir;
			
			if(cargaViral == 0) {
				infectado = false;
			}
		}
	}
	
	public void updateImagenAtaque() {
		entidadGrafica.updateImagen(ruta_dibujo_ataque);
	}
	
	public void updateImagenCaminar() {
		entidadGrafica.updateImagen(ruta_dibujo_moviendose);
	}
	
	public void atacar(Jugador j) {
		j.recibirDanio(cantDanioJugador);
	}
	
	public void accept(Visitor v){
		v.visitarInfectadoBeta(this);
	} 

}
