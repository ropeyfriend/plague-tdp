package entidades.personajes;

import entidades.EntidadGrafica;
import entidades.visitor.InfectadoVisitor;
import entidades.visitor.Visitor;

public class InfectadoAlpha extends Infectado{
	/*Cantidad de danio que le hace al jugador*/
	protected int cantDanioJugador;
	/*Cantidad de danio que recibe al ser golpeado por el jugador*/
	protected float danio_a_recibir;
	/*Representa la parte grafica del infectado Alpha*/
	private EntidadGrafica entidadGrafica;
	
	public InfectadoAlpha(int vel,int r){
		super(vel, r);
		cantDanioJugador = 20;
		danio_a_recibir = 12.5F;
		this.entidadGrafica = new EntidadGrafica();
		visitor = new InfectadoVisitor(this);
		/*ruta_dibujo_moviendose = "img/enemigos/InfectadoAlpha.gif";
		ruta_dibujo_ataque = "img/enemigos/InfectadoAlpha_ataque.gif";*/
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
	
	public void updateImagenAtaque() {
		entidadGrafica.updateImagen(ruta_dibujo_ataque);
	}
	
	public void updateImagenCaminar() {
		entidadGrafica.updateImagen(ruta_dibujo_moviendose);
	}

	public void accept(Visitor v){
		v.visitarInfectadoAlpha(this);
	} 

}
