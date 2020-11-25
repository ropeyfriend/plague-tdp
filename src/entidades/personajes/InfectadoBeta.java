package entidades.personajes;

import entidades.EntidadGrafica;
import entidades.visitor.InfectadoVisitor;
import entidades.visitor.Visitor;

/**Clase que modela a un infectado Alpha del juego*/

public class InfectadoBeta extends Infectado{
	
	public InfectadoBeta(int vel, int r) {
		super(vel, r);
		cantDanioJugador = 10;
		danio_a_recibir = 10;
		muerto = false;
		visitor = new InfectadoVisitor(this);
		entidadGrafica = new EntidadGrafica();
		ruta_dibujo_moviendose = "recursos/Infectados/InfectadoBeta_caminar.gif";
		ruta_dibujo_ataque = "recursos/Infectados/InfectadoBeta_ataque.gif";
	}
	
	//Methods
	public void recibirDanio() {//(Como le resto de a 10 entonces se muere en 10 golpes)
		if(cargaViral - danio_a_recibir>= 10) { //Si la cargaViral es cero, no sigo desinfectandolo
			cargaViral -= danio_a_recibir;
			
			if(cargaViral == 0) {
				muerto = true;
				//Lo tengo q eliminar del juego
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
		p.disparar(j,cantDanioJugador);
	}
	
	public void accept(Visitor v){
		v.visitarInfectado(this);
	}
	

}
