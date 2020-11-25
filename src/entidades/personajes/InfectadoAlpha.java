package entidades.personajes;

import entidades.EntidadGrafica;
import entidades.visitor.InfectadoVisitor;
import entidades.visitor.Visitor;

/**Clase que modela a un infectado Alpha del juego*/

public class InfectadoAlpha extends Infectado{
	
	public InfectadoAlpha(int vel,int r){
		super(vel, r);
		danio = 20;
		danio_a_recibir = 12.5F;
		muerto = false;
		visitor = new InfectadoVisitor(this);
		entidadGrafica = new EntidadGrafica();
		ruta_dibujo_moviendose = "recursos/Infectados/InfectadoAlpha_caminar.gif";
		ruta_dibujo_ataque = "recursos/Infectados/InfectadoAlpha_ataque.gif";
	}
	
	//Methods
	public void recibirDanio(){	//(Como le resto de a 12.5 entonces se muere en 8 golpes)
		if(cargaViral >= danio_a_recibir) {//Si la cargaViral es cero, no sigo desinfectandolo
			cargaViral -= danio_a_recibir;
			
			if(cargaViral == 0) {
				muerto = true;
				//Lo tengo q eliminar del juego
			}
			
			if(cargaViral < 20 && cargaViral != 0) {//Si la cargaV es menor a 20 y esta infectado, duplican su velocidad
				velocidad = velocidad*2;
			}
		}
	}
	
	public void atacar(Jugador j) {
		p.disparar(j);
	}
	
	public void updateImagenAtaque() {
		entidadGrafica.updateImagen(ruta_dibujo_ataque);
	}
	
	public void updateImagenCaminar() {
		entidadGrafica.updateImagen(ruta_dibujo_moviendose);
	}

	public void accept(Visitor v){
		v.visitarInfectado(this);
	} 

}
